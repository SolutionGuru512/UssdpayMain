 package com.bank.ussd.handlers.AM;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.handlers.BaseMenuHandler;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class SetPinProcessMenuHandler_AM extends BaseMenuHandler {
   @Autowired
   private AuthenticatorApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
     String conformationPin = (String)session.getMetaValue(MetadataKey.conformation_pin);
       String activationCode = (String)session.getMetaValue(MetadataKey.activation_code);
       String pin = (String)session.getMetaValue(MetadataKey.new_pin);
       //String pin = session.getText();
       Customer result=null;
       if (pin.compareTo(conformationPin)==0) {
           result = this.apiService.activateCustomer(session.getPhoneNumber(), activationCode, pin, false);
       }
       else{
           return "END ትክክለኛ ያልሆነ የሚስጥር ቁጥር ማረጋገጫ.\nUnable to set new PIN";
       }
     if (result != null && !result.getIsError().booleanValue())
       return menu.getText();
     return "END የተሳሳተ የሚስጥር ቁጥር\nእባክዎ አዲስ የሚስጥር ቁጥር ያስገቡ";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
       if (input.compareTo("1")==0){
           return "MAIN_AM";
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

