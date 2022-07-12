package me.karlburg.assessment.hypori.filter.type;
import me.karlburg.assessment.hypori.filter.FilterName;
import me.karlburg.assessment.hypori.filter.FilterType;
import org.springframework.data.jpa.domain.Specification;

@FilterName("gte")
public class GreaterThanEqualFilterType extends NumberedFilterType {

    @Override
    public <E> Specification<E> generateSpecification(
            final String field, final String value) {

        return (root, query, criteriaBuilder)
                -> criteriaBuilder.greaterThanOrEqualTo(
                        root.get(field), value);
    }
}
