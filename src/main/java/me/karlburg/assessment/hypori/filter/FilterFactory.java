package me.karlburg.assessment.hypori.filter;

// Spring Framework Imports
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

// Java Language Imports
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class FilterFactory {

    /**
     * Default filter type to utilize if no specific value is stated.
     */
    public static final String DEFAULT_FILTER = "eq";

    /**
     * Regular expression pattern used to extract the filter statement.
     * Pattern is stated as a static resource to help prevent constant
     * re-compilation of the regular expression.
     */
    public static final Pattern FILTER_PATTERN
            = Pattern.compile("^(?:([^:]*):)?(.*)$");

    /**
     * Collection of {@link FilterType} beans with a defined
     * {@link FilterName} annotation.
     */
    private final Set<FilterType> filterTypes;

    /**
     * Constructs a {@code FilterFactory} with the supplied injected beans.
     * This will sort through the beans and only select the appropriate
     * objects based on the existence of the {@link FilterName} annotation.
     *
     * @param filterTypes collection of beans in application context
     */
    public FilterFactory(Set<FilterType> filterTypes) {
        this.filterTypes = new HashSet<>();
        for(var filterType : filterTypes) {
            var clazz = filterType.getClass();
            if(clazz.isAnnotationPresent(FilterName.class)) {
                this.filterTypes.add(filterType);
            }
        }
    }

    /**
     * Converts the supplied values to a collection of queries inside the
     * {@code FilterQuery}. This will utilize the {@link #FILTER_PATTERN}
     * to determine the {@link FilterType} to assign to the specific
     * filter process.
     *
     * @param params parameter map, usually retrieved from the query-params
     *               of an HTTP request call to the application
     * @return object that contains the collection of filters
     */
    public FilterQuery convert(MultiValueMap<String, String> params) {
        var violations = new ArrayList<FilterViolation>();
        var filterQuery = new FilterQuery("");
        for(var key : params.keySet()) {

            // TODO: look into moving this to a function
            valueLoop: for(var value : params.get(key)) {
                var matcher = FILTER_PATTERN.matcher(value);
                if(!matcher.find()) {
                    /* TODO: logically, the regular expression should cover
                     *       all cases, need to investigate */
                    violations.add(new FilterViolation(key, String.format(
                            "Filter pattern does not match: %s", value)));
                }

                var filterValue = matcher.group(2);
                var typeName = matcher.group(1);
                if(Objects.isNull(typeName) || typeName.isBlank()) {
                    typeName = DEFAULT_FILTER;
                }

                for(var filterType : this.filterTypes) {
                    var filterName = AnnotationUtils.findAnnotation(
                            filterType.getClass(), FilterName.class);
                    // TODO: this check is unnecessary and can be removed
                    if(Objects.isNull(filterName)) { continue; }
                    if(filterName.value().equals(typeName)) {
                        filterQuery.addEntry(filterType, key, filterValue);
                        continue valueLoop;
                    }
                }
                violations.add(new FilterViolation(key, String.format(
                        "No filter exists to process '%s'", typeName)));
            }
        }
        if(!violations.isEmpty()) {

        }
        return filterQuery;
    }
}