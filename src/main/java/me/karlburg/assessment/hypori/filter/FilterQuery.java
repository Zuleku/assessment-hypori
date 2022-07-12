package me.karlburg.assessment.hypori.filter;
import java.util.ArrayList;
import java.util.List;

public class FilterQuery {

    private final List<String> errors;
    private final String filterName;
    private final List<FilterEntry> filterEntries;

    public FilterQuery(String filterName) {
        this.errors = new ArrayList<>();
        this.filterName = filterName;
        this.filterEntries = new ArrayList<>();
    }

    public void addEntry(FilterType type, String value) {
        this.filterEntries.add(new FilterEntry(type, value));
    }

    public void error(String error) {
        this.errors.add(error);
    }

    private record FilterEntry(FilterType entryType, String value) {}
}