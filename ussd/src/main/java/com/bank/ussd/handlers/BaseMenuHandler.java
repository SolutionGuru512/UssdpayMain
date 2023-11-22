package com.bank.ussd.handlers;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.services.api.AuthenticatorApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseMenuHandler implements IMenuHandler {
  private static final Logger log = LogManager.getLogger(BaseMenuHandler.class);

  @Autowired
  private AuthenticatorApiService apiService;

  public final String getMenuOutput(UssdSession session, Menu menu) {
    String output = getOutput(session, menu);
    log.info("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), output);
    return output;
  }

  public final String handleMenuInput(UssdSession session, String input, Menu menu) {
    String response = handleInput(session, input, menu);
    log.info(menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), response);
    return response;
  }

  public abstract String getOutput(UssdSession paramUssdSession, Menu paramMenu);

  public abstract String handleInput(UssdSession paramUssdSession, String paramString, Menu paramMenu);
}