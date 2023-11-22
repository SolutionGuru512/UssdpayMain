 package com.bank.ussd.data;

 import com.bank.ussd.enums.MenuOptionAction;
 import com.fasterxml.jackson.annotation.JsonProperty;

 public class MenuOption {
   private String type;

   private String response;

   @JsonProperty("error_message")
   private String errorMessage;

   @JsonProperty("next_menu_level")
   private String nextMenuLevel;

   private MenuOptionAction action;

   public void setType(String type) {
     this.type = type;
   }

   public void setResponse(String response) {
     this.response = response;
   }

   @JsonProperty("error_message")
   public void setErrorMessage(String errorMessage) {
     this.errorMessage = errorMessage;
   }

   @JsonProperty("next_menu_level")
   public void setNextMenuLevel(String nextMenuLevel) {
     this.nextMenuLevel = nextMenuLevel;
   }

   public void setAction(MenuOptionAction action) {
     this.action = action;
   }
   public String toString() {
     return "MenuOption(type=" + getType() + ", response=" + getResponse() + ", errorMessage=" + getErrorMessage() + ", nextMenuLevel=" + getNextMenuLevel() + ", action=" + getAction() + ")";
   }

   public String getType() {
     return this.type;
   }

   public String getResponse() {
     return this.response;
   }

   public String getErrorMessage() {
     return this.errorMessage;
   }

   public String getNextMenuLevel() {
     return this.nextMenuLevel;
   }

   public MenuOptionAction getAction() {
     return this.action;
   }
 }
