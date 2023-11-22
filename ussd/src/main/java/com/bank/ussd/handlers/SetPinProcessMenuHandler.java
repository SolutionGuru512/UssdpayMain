 package com.bank.ussd.handlers;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class SetPinProcessMenuHandler extends BaseMenuHandler {
   @Autowired
   private AuthenticatorApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
     String activationCode = (String)session.getMetaValue(MetadataKey.activation_code);
     String conformationPin= (String)session.getMetaValue(MetadataKey.conformation_pin);
       String pin = (String)session.getMetaValue(MetadataKey.new_pin);
       //String pin = session.getText();
       Customer result=null;
       if (pin.compareTo(conformationPin)==0) {
           result = this.apiService.activateCustomer(session.getPhoneNumber(), activationCode, pin, false);
       }else{
           return "CON Invalid Conformation Pin\nPlease enter Conformation PIN";
       }
     if (result != null && !result.getIsError().booleanValue())
       return menu.getText();
     return "END Invalid PIN\nPlease enter new PIN";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
       if (input.compareTo("1")==0){
           return null;
       }
       session.setMetaProperty(MetadataKey.conformation_pin.toString(), input);
       String activationCode = (String)session.getMetaValue(MetadataKey.activation_code);
       String pin = (String)session.getMetaValue(MetadataKey.new_pin);
       //String pin = session.getText();
       Customer result=null;
       if (pin.compareTo(input)==0) {
           result = this.apiService.activateCustomer(session.getPhoneNumber(), activationCode, pin, false);
       }
       if (result != null && !result.getIsError().booleanValue())
           return null;
     return menu.getMenuLevel();
   }
 }

