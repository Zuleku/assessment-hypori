package me.karlburg.assessment.hypori.filter.type;
import me.karlburg.assessment.hypori.filter.FilterType;

public abstract class NumberedFilterType implements FilterType {

    public boolean isAllowedTypes(String value) {
        try { Double.parseDouble(value); return true; }
        catch(NumberFormatException ex) { return false; }
    }
}