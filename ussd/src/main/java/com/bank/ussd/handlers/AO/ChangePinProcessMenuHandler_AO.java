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
 public class ChangePinProcessMenuHandler_AO extends BaseMenuHandler {
   @Autowired
   private AuthenticatorApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
     String newPin = (String)session.getMetaValue(MetadataKey.new_pin);
     String oldPin = (String)session.getMetaValue(MetadataKey.old_pin);
       Customer result=null;
       String conformationPin= (String)session.getMetaValue(MetadataKey.conformation_pin);
       if (newPin.compareTo(conformationPin)==0) {
           result = this.apiService.changePin(session.getPhoneNumber(), oldPin, newPin);
       }
       else{
           return "CON Mirkaneessa lakkoofsa iccitii sirrii hin taane\nMirkaneessa lakkoofsa iccitii sirrii ta'e galchaa\nGara Baafata duratti deebi'uuf 0 tuqi";
       }
     if (result != null && !result.getIsError().booleanValue())
       return menu.getText();
     return "CON Lakk. Iccitii haaraa  galchuu hin dandeenye.\n" + result.getErrorMessage() + "\nDuubatti deebi'uuf * tuqi.";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
       if (input.compareTo("1")==0){
           return "START_AO";
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
