 package com.bank.ussd.adapters.xml;

 import com.bank.ussd.adapters.INetworkAdapter;
 import java.time.LocalDateTime;
 import java.time.format.DateTimeFormatter;

 public class XMLNetworkAdapter implements INetworkAdapter {
   private static final String DEFAULT_DATE_FORMAT = "yyyyMMdd'T'HH:mm:ss";

   private static final String ACTION_REQUEST = "request";

   private static final String ACTION_END = "end";

   private static final String DATE_TYPE = "dateTime.iso8601";

   private static final String STRING_TYPE = "string";

   private static final String INT_TYPE = "int";

   private static final String FAULT_STRING = "faultString";

   private static final String FAULT_CODE = "faultCode";

   private static final String TRANSACTION_TIME = "TransactionTime";

   private static final String USSD_RESPONSE_STRING = "USSDResponseString";

   private static final String TRANSACTION_ID = "TransactionId";

   private static final String ACTION = "action";

   private static final String USSD_REQUEST_STRING = "USSDRequestString";

   private static final String MSISDN = "MSISDN";

   private static final String USSD_SERVICE_CODE = "USSDServiceCode";

   private MethodCall call;

   public INetworkAdapter copy() {
     XMLNetworkAdapter copy = new XMLNetworkAdapter();
     copy.call = this.call;
     return copy;
   }

   public void setInput(String input) {
     this.call = MethodCall.fromString(input);
   }

   public String getSessionId() {
     if (this.call == null)
       return null;
     Member mbr = this.call.getMember("TransactionId");
     if (mbr != null)
       return mbr.getVal();
     return null;
   }

   public String getServiceCode() {
     if (this.call == null)
       return null;
     Member mbr = this.call.getMember("USSDServiceCode");
     if (mbr != null)
       return mbr.getVal();
     return null;
   }

   public String getPhoneNumber() {
     if (this.call == null)
       return null;
     Member mbr = this.call.getMember("MSISDN");
     if (mbr != null)
       return mbr.getVal();
     return null;
   }

   public String getText() {
     if (this.call == null)
       return null;
     Member mbr = this.call.getMember("USSDRequestString");
     if (mbr != null)
       return mbr.getVal();
     return null;
   }

   public String formatOutput(String output) {
     MethodResponse response = new MethodResponse();
     response.addMember("TransactionId", getSessionId(), "string");
     if (output.startsWith("END ")) {
       response.addMember("USSDResponseString", output.replaceFirst("END ", ""), "string");
       response.addMember("action", "end", "string");
     } else if (output.startsWith("CON ")) {
       response.addMember("USSDResponseString", output.replaceFirst("CON ", ""), "string");
       response.addMember("action", "request", "string");
     } else {
       response.addMember("USSDResponseString", output, "string");
       response.addMember("action", "request", "string");
     }
     String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd'T'HH:mm:ss"));
     response.addMember("TransactionTime", dt, "dateTime.iso8601");
     return response.toString();
   }

   public String formatErrorOutput(String output) {
     MethodResponse response = new MethodResponse();
     response.addFaultMember("faultCode", "40001", "int");
     response.addFaultMember("faultString", output, "string");
     return response.toString();
   }
 }
