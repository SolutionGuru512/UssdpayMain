package com.bank.ussd.handlers;

import com.bank.ussd.data.CustomerLanguage;
import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.services.api.AuthenticatorApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class languageProcessMenuHandler extends BaseMenuHandler{
    @Autowired
    AuthenticatorApiService authenticatorApiService;
    @Override
    public String getOutput(UssdSession session, Menu menu) {
        this.authenticatorApiService.updateLanguage(session.getPhoneNumber(), CustomerLanguage.ENGLISH.getCustomerLanguage());
        return menu.getText();
    }

    @Override
    public String handleInput(UssdSession session, String paramString, Menu paramMenu) {
        return null;
    }
}
