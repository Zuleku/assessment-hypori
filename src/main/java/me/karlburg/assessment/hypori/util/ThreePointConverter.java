package me.karlburg.assessment.hypori.util;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Objects;

@Converter
public class ThreePointConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
//        return Objects.isNull(attribute) ?;
        return null;
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return null;
    }

    public static class Deserializer extends JsonDeserializer<Boolean> {

        @Override
        public Boolean deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JacksonException {
            var value = p.getText();
            return "n/a".equalsIgnoreCase(value) ? null : "Y".equalsIgnoreCase(value);
        }
    }
}