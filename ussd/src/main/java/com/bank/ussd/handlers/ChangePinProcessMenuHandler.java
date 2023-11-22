 package com.bank.ussd.handlers;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import static java.lang.System.exit;

 @Component
 public class ChangePinProcessMenuHandler extends BaseMenuHandler {
   @Autowired
   private AuthenticatorApiService apiService;
   private int status=0;

   public String getOutput(UssdSession session, Menu menu) {
//       if (this.status==3){
//           return "END exited From USSD service.\nRedial *877#";
//       }
     String newPin = (String)session.getMetaValue(MetadataKey.new_pin);
     String oldPin = (String)session.getMetaValue(MetadataKey.old_pin);
     String conformationPin= (String)session.getMetaValue(MetadataKey.conformation_pin);
       Customer result=null;
    if (newPin.compareTo(conformationPin)==0) {
         result = this.apiService.changePin(session.getPhoneNumber(), oldPin, newPin);
     }
    else{
        this.status=0;
        return "CON Invalid Conformation Pin\nPlease enter Conformation PIN\n0. Return to Main Menu";
    }
     if (result != null && !result.getIsError().booleanValue()) {
         this.status=1;
         return menu.getText();
     }
       this.status=0;
     return "CON Unable to set new PIN.\n" + result.getErrorMessage() + "\nPress * to return.";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
       if (this.status==1) {
           if (input.length()==1 && input.compareTo("1") == 0) {
               return "START";
           }else {
               status=3;
               //System.exit(1);
               return "LANGUAGES_LOGIN";
           }
       }
       session.setMetaProperty(MetadataKey.conformation_pin.toString(), input);
       String newPin = (String)session.getMetaValue(MetadataKey.new_pin);
       String oldPin = (String)session.getMetaValue(MetadataKey.old_pin);
       Customer result=null;
       if (newPin.compareTo(input)==0) {
           result = this.apiService.changePin(session.getPhoneNumber(), oldPin, newPin);
       }
       if (result != null && !result.getIsError().booleanValue()) {
           return null;
       }
       return menu.getMenuLevel();
   }
 }
