package me.karlburg.assessment.hypori.filter.type;
import me.karlburg.assessment.hypori.filter.FilterName;
import me.karlburg.assessment.hypori.filter.FilterType;

@FilterName("eq")
public class EqualFilterType implements FilterType {

    public boolean checkTypes(String value) {
        return "eq".equals(value);
    }
}