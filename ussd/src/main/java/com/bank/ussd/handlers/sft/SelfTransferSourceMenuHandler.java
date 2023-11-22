package com.bank.ussd.handlers.sft;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Account;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.handlers.BaseMenuHandler;
import com.bank.ussd.services.api.HoldingsApiService;
import com.bank.ussd.utils.StringUtils;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class SelfTransferSourceMenuHandler extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(SelfTransferSourceMenuHandler.class);

  @Autowired
  HoldingsApiService apiService;

  public String getOutput(UssdSession session, Menu menu) {
    List<Account> accounts;
    try {
      accounts = this.apiService.findTransactionAccountList(session);
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      return "CON Unable to fetch accounts. Press 0 to return.";
    }
    StringBuilder builder = new StringBuilder("CON Self Funds Transfer (1/4)\nFrom Account\n");
    if (accounts.size() == 0)
      builder.append("No accounts found\n");
    if (accounts.size() == 1) {
      builder.append("You cannot do a self funds transfer because you only have one account.\n");
    } else {
      int count = 1;
      for (Account account : accounts)
        builder.append(count++ + ". " + account.getDescriptor() + "\n");
    }
    builder.append("*. Back");
    return builder.toString();
  }

  public String handleInput(UssdSession session, String input, Menu menu) {
    List<Account> accounts;
    try {
      accounts = this.apiService.findTransactionAccountList(session);
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      return menu.getMenuLevel();
    }
    int index = StringUtils.stringToInt(input, -1);
    if (index <= 0 || index > accounts.size() || accounts.size() <= 1)
      return menu.getMenuLevel();
    Account selectedAccount = accounts.get(index - 1);
    session.setMetaProperty(MetadataKey.sft_source_account.toString(), Integer.valueOf(index));
    session.setMetaProperty(MetadataKey.sft_source_account_name.toString(), selectedAccount.getShortDescriptor());
    session.setMetaProperty(MetadataKey.sft_source_account_id.toString(), selectedAccount.getId());
    session.setMetaProperty(MetadataKey.sft_currency.toString(), selectedAccount.getCurrencyCode());
    return null;
  }
}
