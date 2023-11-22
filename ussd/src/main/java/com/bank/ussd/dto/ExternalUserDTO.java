package com.bank.ussd.dto;

 import com.fasterxml.jackson.annotation.JsonGetter;
 import com.fasterxml.jackson.annotation.JsonInclude;
 import com.fasterxml.jackson.annotation.JsonSetter;
 import java.util.Date;
 import java.util.List;

 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class ExternalUserDTO {
   private String userId;

   private String name;

   private String arrangementID;

   private Date accessStartDate;

   private Date accessEndDate;

   private String phone;

   private String customerId;

   private String status;

   public static class ExternalUserList {
     public List<ExternalUserDTO> rows;
   }

   public static class ExternalUserData {
     public ExternalUserDTO.ExternalUserList data;
   }

   @JsonGetter("customerId")
   public String getCustomerId() {
     return this.customerId;
   }

   @JsonSetter("CUSTOMER.ID")
   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }

   @JsonGetter("userId")
   public String getUserId() {
     return this.userId;
   }

   @JsonSetter("EXTERNAL.USER.ID")
   public void setUserId(String userId) {
     this.userId = userId;
   }

   @JsonGetter("name")
   public String getName() {
     return this.name;
   }

   @JsonSetter("CUSTOMER.NAME")
   public void setName(String name) {
     this.name = name;
   }

   @JsonGetter("arrangementID")
   public String getArrangementID() {
     return this.arrangementID;
   }

   @JsonSetter("ARRANGEMENT.ID")
   public void setArrangementID(String arrangementID) {
     this.arrangementID = arrangementID;
   }

   public Date getAccessStartDate() {
     return this.accessStartDate;
   }

   public void setAccessStartDate(Date accessStartDate) {
     this.accessStartDate = accessStartDate;
   }

   public Date getAccessEndDate() {
     return this.accessEndDate;
   }

   public void setAccessEndDate(Date accessEndDate) {
     this.accessEndDate = accessEndDate;
   }

   @JsonGetter("phone")
   public String getPhone() {
     return this.phone;
   }

   public void setPhone(String phone) {
     this.phone = phone;
   }

   @JsonGetter("status")
   public String getStatus() {
     return this.status;
   }

   @JsonSetter("STATUS")
   public void setStatus(String status) {
     this.status = status;
   }
 }
