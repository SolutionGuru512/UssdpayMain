package com.bank.ussd.data.api;

public class Customer {
  private String phone;

  private String externalUser;

  private String customerId;

  private String name;

  private String status;

  private String activationCode;

  private String pin;

  private String oldPin;

  private String errorMessage;
  private String language;
  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setExternalUser(String externalUser) {
    this.externalUser = externalUser;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setActivationCode(String activationCode) {
    this.activationCode = activationCode;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public void setOldPin(String oldPin) {
    this.oldPin = oldPin;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setIsError(Boolean isError) {
    this.isError = isError;
 }
   public enum CustomerStatus {
     STATUS_PENDING, STATUS_ACTIVE, STATUS_RESET, STATUS_SUSPENDED, STATUS_LOCKED, STATUS_NOT_FOUND;

     public String getStatus() {
       return name();
     }

     public boolean equals(String status) {
       if (status == null)
         return false;
       return getStatus().equals(status);
     }
   }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getPhone() {
     return this.phone;
   }

   public String getExternalUser() {
     return this.externalUser;
   }

   public String getCustomerId() {
     return this.customerId;
   }

   public String getName() {
     return this.name;
   }

   public String getStatus() {
     return this.status;
   }

   public String getActivationCode() {
     return this.activationCode;
   }

   public String getPin() {
     return this.pin;
   }

   public String getOldPin() {
     return this.oldPin;
   }

   public String getErrorMessage() {
     return this.errorMessage;
   }

   private Boolean isError = Boolean.valueOf(false);

   public Boolean getIsError() {
     return this.isError;
   }
 }