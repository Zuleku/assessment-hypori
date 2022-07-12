package me.karlburg.assessment.hypori.filter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterQuery {

    private final List<String> errors;
    private final String filterName;
    private final List<FilterQueryEntry> entries;

    public FilterQuery(String filterName) {
        this.errors = new ArrayList<>();
        this.filterName = filterName;
        this.entries = new ArrayList<>();
    }

    public void addEntry(FilterType type, String field, String value) {
        this.entries.add(new FilterQueryEntry(type, field, value));
        // check is allowed type
    }

    public void error(String error) {
        this.errors.add(error);
    }

    public <E> List<Specification<E>> generateSpecs(Class<E> entity) {
        var violations = new ArrayList<FilterViolation>();
        var specs = new ArrayList<Specification<E>>();

        for(var entry : this.entries) {
            var type = entry.entryType;

            var field = ReflectionUtils.findField(entity, entry.field);
            if(Objects.isNull(field)) {
                //
            }

            specs.add(type.generateSpecification(entry.field, entry.value));
        }

        return specs;
    }

    private record FilterQueryEntry(FilterType entryType, String field, String value) {}
}