package me.karlburg.assessment.hypori.filter;

/**
 * Provides a contract for actions performed based on the type of filter. The
 * concrete classes that implement this interface should contain a
 * {@link FilterName} annotation to signify the string value of the filter.
 * <pre>
 * {@code @FilterName("eq")} -> http://server.port/resource?field=eq:name
 * {@code @FilterName("gte")} -> http://server.port/resource?field=gte:3.2
 * </pre>
 */
public interface FilterType {
    boolean checkTypes(String value);
}