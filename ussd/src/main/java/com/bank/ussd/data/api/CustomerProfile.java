 package com.bank.ussd.data.api;

 import java.util.Date;

 public class CustomerProfile {
   private String customerId;

   private Date lastLogin;

   public void setCustomerId(String customerId) {
     this.customerId = customerId;
   }

   public void setLastLogin(Date lastLogin) {
     this.lastLogin = lastLogin;
   }

   public String toString() {
     return "CustomerProfile(customerId=" + getCustomerId() + ", lastLogin=" + getLastLogin() + ")";
   }

   public String getCustomerId() {
     return this.customerId;
   }

   public Date getLastLogin() {
     return this.lastLogin;
   }
 }

