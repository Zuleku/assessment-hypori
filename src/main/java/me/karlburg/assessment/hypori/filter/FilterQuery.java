package me.karlburg.assessment.hypori.filter;
import java.util.ArrayList;
import java.util.List;

public class FilterQuery {

    private final String filterName;
    private final List<FilterEntry> filterEntries;

    public FilterQuery(String filterName) {
        this.filterName = filterName;
        this.filterEntries = new ArrayList<>();
    }

    public void addEntry(FilterType type, String value) {
        this.filterEntries.add(new FilterEntry(type, value));
    }

    private record FilterEntry(FilterType entryType, String value) {}
}