package me.karlburg.assessment.hypori.filter;
import java.io.Serial;

public class FilterException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6347411481921338014L;

    public final String filterField;

    public FilterException(String filterField, String message) {
        super(message);
        this.filterField = filterField;
    }
}