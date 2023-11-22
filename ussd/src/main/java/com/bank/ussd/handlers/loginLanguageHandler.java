package com.bank.ussd.handlers;

import com.bank.ussd.data.CustomerLanguage;
import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.services.api.AuthenticatorApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class loginLanguageHandler extends BaseMenuHandler{
    @Autowired
    AuthenticatorApiService authenticatorApiService;
    @Override
    public String getOutput(UssdSession session, Menu menu) {
        StringBuilder builder = new StringBuilder("CON Welcome to Gadaa Bank USSD platform\nLanguage Preferences\nFilannoo Afaanii\n1.English\n2.Afaan Oromoo\n3.Amharic");
    return builder.toString();
    }

    @Override
    public String handleInput(UssdSession session, String input, Menu paramMenu) {
        if (input.equalsIgnoreCase("1")){
            return "START";
        }else if (input.equalsIgnoreCase("2")){
            return "START_AO";
        }
        else if (input.equalsIgnoreCase("3")){
            return "START_AM";
        }else {
            return paramMenu.getMenuLevel();
        }
//        return null;
    }
}
