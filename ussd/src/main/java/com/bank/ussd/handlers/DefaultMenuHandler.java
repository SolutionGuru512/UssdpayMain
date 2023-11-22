 package com.bank.ussd.handlers;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import org.springframework.stereotype.Component;

 @Component
 public class DefaultMenuHandler extends BaseMenuHandler {
   public String getOutput(UssdSession session, Menu menu) {
     return "END Service unavailable.";
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
     return null;
   }
 }
