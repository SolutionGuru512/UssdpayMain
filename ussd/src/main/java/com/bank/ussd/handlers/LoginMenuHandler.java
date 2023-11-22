 package com.bank.ussd.handlers;

 import com.bank.ussd.data.CustomerLanguage;
 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class LoginMenuHandler extends BaseMenuHandler {
   private static final Logger log = LogManager.getLogger(LoginMenuHandler.class);



   @Autowired
   AuthenticatorApiService authenticatorApiService;


   public String getOutput(UssdSession session, Menu menu) {
     Customer customer = this.authenticatorApiService.lookupCustomer(session.getPhoneNumber());
     if (customer == null)
       return "END Welcome to Gadaa Bank USSD platform \nPlease Visit Your nearest Gadaa Bank Branch for registration!";
     this.authenticatorApiService.updateLanguage(session.getPhoneNumber(), CustomerLanguage.ENGLISH.getCustomerLanguage());
     session.setCustomerStatus(customer.getStatus());
     session.setCustomerId(customer.getCustomerId());
     session.setExternalUser(customer.getExternalUser());
     switch (customer.getStatus()) {
       case "STATUS_NOT_FOUND":
         return getNotFoundOutput(session, menu);
       case "STATUS_ACTIVE":
         return getActiveOutput(session, menu);
       case "STATUS_LOCKED":
       case "STATUS_ACTIVATION_FAILED":
         return getLockedOutput(session, menu);
       case "STATUS_PENDING":
         return getPendingOutput(session, menu);
       case "STATUS_RESET":
         return getResetOutput(session, menu);
       case "STATUS_SUSPENDED":
         return getSuspendedOutput(session, menu);
     }
     return "END Unexpected error";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
     String status = session.getCustomerStatus();
     switch (status) {
       case "STATUS_ACTIVE":
         return handleActiveInput(session, menu);
       case "STATUS_PENDING":
         return handlePendingInput(session, menu);
       case "STATUS_RESET":
         return handleResetInput(session, menu);
     }
     return null;
   }

   private String getNotFoundOutput(UssdSession session, Menu menu) {
     return "END Welcome to Gadaa Bank Mobile Banking.\n Please Visit Your nearest Gadaa Bank Branch!";
   }

   private String getActiveOutput(UssdSession session, Menu menu) {
     Integer failedLoginCount = (Integer)session.getMetaValue(MetadataKey.login_failed_count);
     if (failedLoginCount == null)
       failedLoginCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedLoginCount.intValue() == 0) {
       builder.append("CON Welcome to Gadaa Bank\nMobile Banking USSD Platform\nEnter PIN");
     } else {
       builder.append("CON Invalid Pin (Attempt " + (failedLoginCount.intValue() + 1) + ")\nEnter PIN");
     }
     return builder.toString();
   }

   private String getLockedOutput(UssdSession session, Menu menu) {
     return "END Your mobile banking user has been locked.\nPlease contact your nearest branch.";
   }

   private String getPendingOutput(UssdSession session, Menu menu) {
     Integer failedActivationCount = (Integer)session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedActivationCount.intValue() == 0) {
       builder.append("CON Welcome to Gadaa Bank Mobile Banking\nEnter your activation code");
     } else {
       builder.append("CON Invalid Code (Attempt " + (failedActivationCount.intValue() + 1) + ")\nEnter activation code");
     }
     return builder.toString();
   }

   private String getResetOutput(UssdSession session, Menu menu) {
     return getActiveOutput(session, menu);
   }

   private String getSuspendedOutput(UssdSession session, Menu menu) {
     return "END Your mobile banking user has been suspended.\nPlease contact your nearest branch.";
   }

   private String handleActiveInput(UssdSession session, Menu menu) {
     if (session.getText().length()!=4){
       return menu.getMenuLevel();
     }
     Customer result = this.authenticatorApiService.authenticateCustomer(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       String arrangementID = session.getExternalUser();
       if (arrangementID != null)
         session.setArrangementID(arrangementID);
       return "MAIN";
     }
     Integer failedLoginCount = (Integer)session.getMetaValue(MetadataKey.login_failed_count);
     if (failedLoginCount == null)
       failedLoginCount = Integer.valueOf(0);
     session.setMetaValue(MetadataKey.login_failed_count, Integer.valueOf(failedLoginCount.intValue() + 1));
     return menu.getMenuLevel();
   }

   private String handlePendingInput(UssdSession session, Menu menu) {
     Customer customer = this.authenticatorApiService.activateCustomer(session.getPhoneNumber(), session.getText(), null, true);
     if (customer != null && !customer.getIsError().booleanValue()) {
       session.setMetaValue(MetadataKey.activation_code, session.getText());
       return "SET_PIN";
     }
     Integer failedActivationCount = (Integer)session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     session.setMetaValue(MetadataKey.activation_failed_count, Integer.valueOf(failedActivationCount.intValue() + 1));
     return "START";
   }

   private String handleResetInput(UssdSession session, Menu menu) {
     Customer result = this.authenticatorApiService.authenticateCustomer2(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       return "RESET_PIN";
     }
     return menu.getMenuLevel();
   }
 }
