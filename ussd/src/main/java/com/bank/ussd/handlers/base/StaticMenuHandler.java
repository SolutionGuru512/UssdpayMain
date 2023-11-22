package com.bank.ussd.handlers.base;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.handlers.BaseMenuHandler;

public class StaticMenuHandler extends BaseMenuHandler {
  public String getOutput(UssdSession session, Menu menu) {
    return menu.getText();
  }

  public String handleInput(UssdSession session, String input, Menu menu) {
    return null;
  }
}


