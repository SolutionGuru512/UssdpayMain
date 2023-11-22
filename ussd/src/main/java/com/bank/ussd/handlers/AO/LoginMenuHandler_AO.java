 package com.bank.ussd.handlers.AO;

 import com.bank.ussd.data.CustomerLanguage;
 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.handlers.BaseMenuHandler;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class LoginMenuHandler_AO extends BaseMenuHandler {
   private static final Logger log = LogManager.getLogger(LoginMenuHandler_AO.class);


   @Autowired
   AuthenticatorApiService authenticatorApiService;


   public String getOutput(UssdSession session, Menu menu) {
     Customer customer = this.authenticatorApiService.lookupCustomer(session.getPhoneNumber());
     if (customer == null)
       return "END Not found";
     this.authenticatorApiService.updateLanguage(session.getPhoneNumber(), CustomerLanguage.AFAANOROMOO.getCustomerLanguage());
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
     return "END Tajaajila Baankii Mobaayilaaf galmaa'aa ";
   }

   private String getActiveOutput(UssdSession session, Menu menu) {
     Integer failedLoginCount = (Integer) session.getMetaValue(MetadataKey.login_failed_count);
     if (failedLoginCount == null)
       failedLoginCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedLoginCount.intValue() == 0) {
       builder.append("CON Baga gara Tajaajila   Baankii  Moobayilaa Gadaatti Nagaan Dhuftan \nLakk.Iccitii galchaa ");
     } else {
       builder.append("CON  Lakk. Iccitii Dogoggoraa galchuuf yaalu (" + (failedLoginCount.intValue() + 1) + ")\nLakk.Iccitii galchaa");
     }
     return builder.toString();
   }

   private String getLockedOutput(UssdSession session, Menu menu) {
     return "END Itti Fayyadamni Tajaajila Baankii Moobaayilaa keessanii Cufameera.\nDamee baankii keenya isinitti dhihoo  jiru quunnamaa.";
   }

   private String getPendingOutput(UssdSession session, Menu menu) {
     Integer failedActivationCount = (Integer) session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedActivationCount.intValue() == 0) {
       builder.append("CON Baga gara Tajaajila   Baankii  Moobayila Gadaa tti Nagaan Dhuftan \nKoodii dalagsiistuu keessaan galchaa");
     } else {
       builder.append("CON Invalid Code (Attempt " + (failedActivationCount.intValue() + 1) + ")\nKoodii dalagsiistuu keessaan galchaa");
     }
     return builder.toString();
   }

   private String getResetOutput(UssdSession session, Menu menu) {
     return getActiveOutput(session, menu);
   }

   private String getSuspendedOutput(UssdSession session, Menu menu) {
     return "END Itti Fayyadamni Tajaajila Baankii Moobaayila keessanii addaan citeera.\nDamee baankii keenya isinitti dhihoo  jiru quunnamaa.";
   }

   private String handleActiveInput(UssdSession session, Menu menu) {
     Customer result = this.authenticatorApiService.authenticateCustomer(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       String arrangementID = session.getExternalUser();
       if (arrangementID != null)
         session.setArrangementID(arrangementID);
       return "MAIN_AO";
     }
     Integer failedLoginCount = (Integer) session.getMetaValue(MetadataKey.login_failed_count);
     if (failedLoginCount == null)
       failedLoginCount = Integer.valueOf(0);
     session.setMetaValue(MetadataKey.login_failed_count, Integer.valueOf(failedLoginCount.intValue() + 1));
     return menu.getMenuLevel();
   }

   private String handlePendingInput(UssdSession session, Menu menu) {
     Customer customer = this.authenticatorApiService.activateCustomer(session.getPhoneNumber(), session.getText(), null, true);
     if (customer != null && !customer.getIsError().booleanValue()) {
       session.setMetaValue(MetadataKey.activation_code, session.getText());
       return "SET_PIN_AO";
     }
     Integer failedActivationCount = (Integer) session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     session.setMetaValue(MetadataKey.activation_failed_count, Integer.valueOf(failedActivationCount.intValue() + 1));
     return "START_AO";
   }

   private String handleResetInput(UssdSession session, Menu menu) {
     Customer result = this.authenticatorApiService.authenticateCustomer2(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       return "RESET_PIN_AO";
     }
     return menu.getMenuLevel();
   }
 }
