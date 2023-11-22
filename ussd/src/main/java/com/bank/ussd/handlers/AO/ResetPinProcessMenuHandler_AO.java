 package com.bank.ussd.handlers.AO;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.handlers.BaseMenuHandler;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class ResetPinProcessMenuHandler_AO extends BaseMenuHandler {
   @Autowired
   private AuthenticatorApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
       String conformationPin = (String)session.getMetaValue(MetadataKey.conformation_pin);
       String pin = (String)session.getMetaValue(MetadataKey.new_pin);
//     String pin = session.getText();
       Customer result=null;
       if (pin.compareTo(conformationPin)==0) {
           result = this.apiService.changePin(session.getPhoneNumber(), null, pin);
       }
       else{
           return "END Mirkaneessa lakkoofsa iccitii sirrii hin taane.\nLakk Iccitii haaraa galchuu hin dandeenye";
       }
     if (result != null && !result.getIsError().booleanValue())
       return menu.getText();
     return "END Lakk Iccitii haaraa galchuu hin dandeenye";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
       if (input.compareTo("1")==0){
           return "MAIN_AO";
       }
       session.setMetaProperty(MetadataKey.conformation_pin.toString(), input);
       String pin = (String)session.getMetaValue(MetadataKey.new_pin);
       Customer result=null;
       if (pin.compareTo(input)==0) {
           result = this.apiService.changePin(session.getPhoneNumber(), null, pin);
       }
       if (result != null && !result.getIsError().booleanValue())
           return null;
       return menu.getMenuLevel();
   }
 }
