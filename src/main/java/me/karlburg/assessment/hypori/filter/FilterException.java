package me.karlburg.assessment.hypori.filter;
import java.io.Serial;
import java.util.List;

public class FilterException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 6347411481921338014L;

    public final List<FilterViolation> filterViolations;

    public FilterException(List<FilterViolation> filterViolations) {
        super();
        this.filterViolations = filterViolations;
    }
}