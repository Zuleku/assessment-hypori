package me.karlburg.assessment.hypori.filter;

// Spring Framework Imports
import org.springframework.stereotype.Component;

// Java Language Imports
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilterName {

    /**
     * String value used to represent the specific filter to use based on
     * an extracted HTTP query parameter.
     *
     * @return string value
     */
    String value();
}
