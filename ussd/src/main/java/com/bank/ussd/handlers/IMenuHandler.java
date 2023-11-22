package com.bank.ussd.handlers;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;

public interface IMenuHandler {
  String getMenuOutput(UssdSession paramUssdSession, Menu paramMenu);
  
  String handleMenuInput(UssdSession paramUssdSession, String paramString, Menu paramMenu);
}
