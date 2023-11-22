package com.bank.ussd.data;

 import com.bank.ussd.enums.MetadataKey;

 import java.io.Serializable;
 import java.util.HashMap;
 import org.springframework.data.annotation.Id;
 import org.springframework.data.redis.core.RedisHash;

 @RedisHash(value = "sessions", timeToLive = 180L)
 public class UssdSession implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   private String id;

   private String sessionId;

   private String serviceCode;

   private String phoneNumber;

   private String text;

   private String pin;

   private String customerId;

   private String previousMenuLevel;

   private String currentMenuLevel;

   private String customerStatus;

   private String externalUser;

   private String arrangementID;

   private HashMap<String, Object> metadata;

   public void setId(String id) {
     this.id = id;
   }

   public void setSessionId(String sessionId) {
     this.sessionId = sessionId;
   }

   public void setServiceCode(String serviceCode) {
     this.serviceCode = serviceCode;
   }

   public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
   }

   public void setText(String text) {
     this.text = text;
   }

   public void setPin(String pin) {
     this.pin = pin;
   }

   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }

   public void setPreviousMenuLevel(String previousMenuLevel) {
     this.previousMenuLevel = previousMenuLevel;
   }

   public void setCurrentMenuLevel(String currentMenuLevel) {
     this.currentMenuLevel = currentMenuLevel;
   }

   public void setCustomerStatus(String customerStatus) {
     this.customerStatus = customerStatus;
   }

   public void setExternalUser(String externalUser) {
     this.externalUser = externalUser;
   }

   public void setArrangementID(String arrangementID) {
     this.arrangementID = arrangementID;
   }

   public void setMetadata(HashMap<String, Object> metadata) {
     this.metadata = metadata;
   }



   public String getId() {
     return this.id;
   }

   public String getSessionId() {
     return this.sessionId;
   }

   public String getServiceCode() {
     return this.serviceCode;
   }

   public String getPhoneNumber() {
     return this.phoneNumber;
   }

   public String getText() {
     return this.text;
   }

   public String getPin() {
     return this.pin;
   }

   public String getCustomerId() {
     return this.customerId;
   }

   public String getPreviousMenuLevel() {
     return this.previousMenuLevel;
   }

   public String getCurrentMenuLevel() {
     return this.currentMenuLevel;
   }

   public String getCustomerStatus() {
     return this.customerStatus;
   }

   public String getExternalUser() {
     return this.externalUser;
   }

   public String getArrangementID() {
     return this.arrangementID;
   }

   public HashMap<String, Object> getMetadata() {
     return this.metadata;
   }

   public void setMetaProperty(String key, Object value) {
     if (this.metadata == null)
       this.metadata = new HashMap<>();
     this.metadata.put(key, value);
     if (key.equals("pin"))
       this.pin = (String)value;
     if (key.equals("customerId"))
       this.customerId = (String)value;
   }

   public Object getMetaProperty(String key) {
     if (this.metadata != null)
       return this.metadata.get(key);
     return null;
   }

   public void setMetaValue(MetadataKey key, Object value) {
     if (key != null)
       setMetaProperty(key.toString(), value);
   }

   public Object getMetaValue(MetadataKey key) {
     if (key != null)
       return getMetaProperty(key.toString());
     return null;
   }

   public void clearMetadata() {
     this.metadata = new HashMap<>();
   }

   public String getCredentials() {
     return getExternalUser() + "/123456";
   }
 }

