 package com.bank.ussd.enums;

 import com.fasterxml.jackson.annotation.JsonValue;

 public enum MenuType {
   STATIC("static"),
   DYNAMIC("dynamic"),
   INPUT("input"),
   SELECT("select");

   private String type;

   MenuType(String type) {
     this.type = type;
   }

   @JsonValue
   private String getType() {
     return this.type;
   }
 }
