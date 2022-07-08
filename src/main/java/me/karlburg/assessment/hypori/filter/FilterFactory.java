package me.karlburg.assessment.hypori.filter;
//import me.karlburg.assessment.hypori.filter.type.EqualFilterType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Component
public class FilterFactory {

    private static final String DEFAULT_FILTER = "eq";
    private static final Pattern FILTER_PATTERN
            = Pattern.compile("^(?:([^:]*):)?(.*)$");

    private final Set<FilterType> filterTypes;

    private FilterFactory(Set<FilterType> filterTypes) {
        this.filterTypes = filterTypes;
        // remove all types without name
    }

    public Set<FilterQuery> convertParams(MultiValueMap<String, String> params) {
        var filterQuerySet = new HashSet<FilterQuery>();
        for(var key : params.keySet()) {
            var filterQuery = new FilterQuery(key);
            filterQuerySet.add(filterQuery);
            loop: for(var value : params.get(key)) {
                var matcher = FILTER_PATTERN.matcher(value);
                if(!matcher.find()) {
                    System.out.println("");
                }
                var filterValue = matcher.group(2);
                var typeName = matcher.group(1);
                if(Objects.isNull(typeName) || typeName.isBlank()) {
                    typeName = DEFAULT_FILTER;
                }

                for(var filterType : this.filterTypes) {
                    var filterName = AnnotationUtils.findAnnotation(
                            filterType.getClass(), FilterName.class);
                    if(Objects.isNull(filterName)) { continue; }
                    if(filterName.value().equals(typeName)) {
                        filterQuery.addEntry(filterType, filterValue);
                        continue loop;
                    }
                }
                // record error in filter-query
            }
        }
        return filterQuerySet;
    }
}