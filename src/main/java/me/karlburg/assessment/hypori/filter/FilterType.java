package me.karlburg.assessment.hypori.filter;

// Spring Framework Imports
import org.springframework.data.jpa.domain.Specification;

/**
 * Provides a contract for actions performed based on the type of filter.
 * The concrete classes that implement this interface should contain a
 * {@link FilterName} annotation to signify the string value of the filter.
 * <pre>
 * {@code @FilterName("eq")} -> http://server.port/resource?field=eq:name
 * {@code @FilterName("gte")} -> http://server.port/resource?field=gte:3.2
 * </pre>
 */
public interface FilterType {

    /**
     * Generates a JPA {@code Specification} based on the values of the
     * field and value. This should determine if the appropriate value is
     * available on the field.
     *
     * @param field entity field to run specification against
     * @param value value to place for test case
     * @return specification object that can be used on a repository
     * @param <E> entity type for specification
     */
    <E> Specification<E> generateSpecification(
            final String field, final String value);

    /**
     * Returns if the supplied value is of an allowed type. This should
     * conduct a basic check on if the {@code value} object can be cast to
     * a specific type.
     *
     * @param value string value to test
     * @return if the value can be cast to an allowed type
     */
    default boolean isAllowedTypes(String value) { return true; }
}