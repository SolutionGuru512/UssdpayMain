package com.bank.ussd.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Locale;
import org.springframework.expression.ParseException;

public class CustomDateDeserializer extends JsonDeserializer {
  private static final long serialVersionUID = 1L;

  public CustomDateDeserializer() {
    this(null);
  }

  public CustomDateDeserializer(DateTimeFormatter formatter) {}

  public Class handledType() {
    return LocalDate.class;
  }

  private static final String[] DATE_FORMATS = new String[] { "yyyy-MM-dd", "yyyyMMdd" };

  public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    JsonNode node = (JsonNode)p.getCodec().readTree(p);
    String date = node.textValue();
    for (String DATE_FORMAT : DATE_FORMATS) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ROOT);
      try {
        return LocalDate.parse(date, formatter);
      } catch (DateTimeParseException dateTimeParseException) {}
    }
    throw new ParseException(0, "Unparseable date: \"" + date + "\". Supported formats: " +
        Arrays.toString(DATE_FORMATS));
  }
}
