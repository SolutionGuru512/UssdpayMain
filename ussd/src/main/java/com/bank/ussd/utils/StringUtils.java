package com.bank.ussd.utils;

 import com.fasterxml.jackson.databind.JsonNode;
 import com.fasterxml.jackson.databind.ObjectMapper;
 import java.math.BigDecimal;
 import java.text.DecimalFormat;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;
 import java.util.Map;
 import org.apache.commons.text.StringSubstitutor;
 import org.springframework.web.client.HttpClientErrorException;

 public class StringUtils {
   public static String replaceVariable(Map<String, Object> variablesMap, String response) {
     if (variablesMap == null)
       return response;
     StringSubstitutor sub = new StringSubstitutor(variablesMap);
     return sub.replace(response);
   }

   public static int stringToInt(String value, int def) {
     try {
       return Integer.parseInt(value);
     } catch (NumberFormatException ex) {
       return def;
     }
   }

   public static String shortDate(LocalDate date) {
     if (date == null)
       return "";
     String pattern = "dd/MM";
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return date.format(formatter);
   }

   public static String fullDate(LocalDate date) {
     if (date == null)
       return "";
     String pattern = "dd/MM/yy";
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return date.format(formatter);
   }

   public static String longDate(LocalDate date) {
     if (date == null)
       return "";
     String pattern = "dd/MM/yyyy";
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return date.format(formatter);
   }

   public static String date(LocalDate date, String pattern) {
     if (date == null)
       return "";
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return date.format(formatter);
   }

   public static LocalDate parseDate(String date) {
     if (date == null)
       return null;
     String pattern = "dd/MM/yyyy";
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return LocalDate.parse(date, formatter);
   }

   public static LocalDate parseDate(String date, String pattern) {
     if (date == null || pattern == null)
       return null;
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
     return LocalDate.parse(date, formatter);
   }

   public static String currency(BigDecimal amount) {
     if (amount == null)
       return "";
     String pattern = (amount.longValue() > 0L) ? "+###,##0.00" : "###,##0.00";
     DecimalFormat df = new DecimalFormat(pattern);
     return df.format(amount);
   }

   public static String currencyAmount(BigDecimal amount) {
     if (amount == null)
       return "";
     String pattern = "###,##0.00";
     DecimalFormat df = new DecimalFormat(pattern);
     return df.format(amount);
   }
   public static String currencyAmount(String amount) {
     BigDecimal bigDecimal=new BigDecimal(amount);
     if (amount == null)
       return "";
     String pattern = "###,##0.00";
     DecimalFormat df = new DecimalFormat(pattern);
     return df.format(bigDecimal);
   }

   public static String getErrorMessage(Exception ex, String def) {
     String errorMessage = def;
     if (ex instanceof HttpClientErrorException.BadRequest) {
       String errorString = ((HttpClientErrorException.BadRequest)ex).getResponseBodyAsString();
       ObjectMapper mapper = new ObjectMapper();
       try {
         JsonNode json = (JsonNode)mapper.readValue(errorString, JsonNode.class);
         errorMessage = json.path("error").path("errorDetails").get(0).path("message").asText("Error processing transaction.");
       } catch (Exception exception) {}
     }
     return errorMessage;
   }
 }
