 package com.bank.ussd.handlers.AM;

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
 public class LoginMenuHandler_AM extends BaseMenuHandler {
   private static final Logger log = LogManager.getLogger(LoginMenuHandler_AM.class);


   @Autowired
   AuthenticatorApiService authenticatorApiService;



   public String getOutput(UssdSession session, Menu menu) {
     Customer customer = this.authenticatorApiService.lookupCustomer(session.getPhoneNumber());
     if (customer == null)
       return "END Not found";
     this.authenticatorApiService.updateLanguage(session.getPhoneNumber(), CustomerLanguage.AMHARIC.getCustomerLanguage());
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
     return "END እንኳን ወደ ገዳ ባንክ የሞባይል ባንኪንግ አገልግሎት በደህና መጡ\nእባክዎ ለሞባይል ባንክ አገልግሎት ይመዝገቡ";
   }

   private String getActiveOutput(UssdSession session, Menu menu) {
     Integer failedLoginCount = (Integer)session.getMetaValue(MetadataKey.login_failed_count);
     if (failedLoginCount == null)
       failedLoginCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedLoginCount.intValue() == 0) {
       builder.append("CON እንኳን ወደ ገዳ ባንክ የሞባይል ባንኪንግ አገልግሎት በደህና መጡ\nእባክዎ የሚስጥር ቁጥር ያስገቡ");
     } else {
       builder.append("CON የተሳሳተ የሚስጥር ቁጥር የማስገባት ሙከራ(" + (failedLoginCount.intValue() + 1) + ")\nአኃዝ የሚስጥር ቁጥር ያስገቡ");
     }
     return builder.toString();
   }

   private String getLockedOutput(UssdSession session, Menu menu) {
     return "END የሞባይል ባንኪንግ አገልግሎት ተጠቃምነትዎ ተዘግቷል፡፡.\nእባክዎ አቅራቢያዎ የሚገኘውን የባንካችን ቅርንጫፍ ያነጋግሩ.";
   }

   private String getPendingOutput(UssdSession session, Menu menu) {
     Integer failedActivationCount = (Integer)session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     StringBuilder builder = new StringBuilder("");
     if (failedActivationCount.intValue() == 0) {
       builder.append("CON እንኳን ወደ ገዳ ባንክ የሞባይል ባንኪንግ አገልግሎት በደህና መጡ \nማሰሪያ ኮድዎን ያስገቡ");
     } else {
       builder.append("CON የተሳሳተ ማሰሪያ ኮድ (Attempt " + (failedActivationCount.intValue() + 1) + ")\nእባከዎን ደግመው ይሞክሩ");
     }
     return builder.toString();
   }

   private String getResetOutput(UssdSession session, Menu menu) {
     return getActiveOutput(session, menu);
   }

   private String getSuspendedOutput(UssdSession session, Menu menu) {
     return "END የሞባይል ባንኪንግ አገልግሎት ተጠቃምነትዎ ተቋርጧል፡፡\nእባክዎ አቅራቢያዎ የሚገኘውን የባንካችን ቅርንጫፍ ያነጋግሩ";
   }

   private String handleActiveInput(UssdSession session, Menu menu) {
     Customer result = this.authenticatorApiService.authenticateCustomer(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       String arrangementID = session.getExternalUser();
       if (arrangementID != null)
         session.setArrangementID(arrangementID);
       return "MAIN_AM";
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
       return "SET_PIN_AM";
     }
     Integer failedActivationCount = (Integer)session.getMetaValue(MetadataKey.activation_failed_count);
     if (failedActivationCount == null)
       failedActivationCount = Integer.valueOf(0);
     session.setMetaValue(MetadataKey.activation_failed_count, Integer.valueOf(failedActivationCount.intValue() + 1));
     return "START_AM";
   }

   private String handleResetInput(UssdSession session, Menu menu) {
     Customer result = this.authenticatorApiService.authenticateCustomer2(session.getPhoneNumber(), session.getText());
     if (result != null && !result.getIsError().booleanValue()) {
       return "RESET_PIN_AM";
     }
     return menu.getMenuLevel();
   }
 }
