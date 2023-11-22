package com.bank.ussd.handlers.sft.AM;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Account;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.handlers.BaseMenuHandler;
import com.bank.ussd.services.api.HoldingsApiService;
import com.bank.ussd.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;

@Component
public class SelfTransferSourceMenuHandler_AM extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(SelfTransferSourceMenuHandler_AM.class);

  @Autowired
  HoldingsApiService apiService;

  public String getOutput(UssdSession session, Menu menu) {
    List<Account> accounts;
    try {
      accounts = this.apiService.findTransactionAccountList(session);
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      return "CON ሒሳቡን ማግኘት አልቻለም.\nለመመለስ 0 ይጫኑ.";
    }
    StringBuilder builder = new StringBuilder("CON ");
    if (accounts.size() != 1) {
      builder.append("የራስ ገንዘብ ማስተላለፍ(1/4)\nከሂሳብ ቁጥር\n");
    }
     if (accounts.size() == 0)
      builder.append("ምንም ሒሳብ አልተገኘም\n");
    if (accounts.size() == 1) {
      builder.append("ወደ ራስ ሂሳብ ማስተላለፍ አይችሉም ምክንያቱም አንድ ሒሳብ ብቻ ነው ያልዎት.\n");
    } else {
      int count = 1;
      for (Account account : accounts)
        builder.append(count++ + ". " + account.getNumber() + "\n");
    }
    builder.append("*.ለመመለስ");
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
