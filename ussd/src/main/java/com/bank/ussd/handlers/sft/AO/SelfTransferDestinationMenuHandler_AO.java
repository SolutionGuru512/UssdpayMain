package com.bank.ussd.handlers.sft.AO;

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
public class SelfTransferDestinationMenuHandler_AO extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(SelfTransferDestinationMenuHandler_AO.class);

  @Autowired
  HoldingsApiService apiService;

  public String getOutput(UssdSession session, Menu menu) {
    List<Account> accounts;
    try {
      accounts = this.apiService.findTransactionAccountList(session);
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      return "CON Herregicha argachuu hin dandeenye.\nDuubatti deebi'uuf 0 tuqi.";
    }
    StringBuilder builder = new StringBuilder("CON Mallaqa ofii daddabrsuu (2/4)\nGara Lakk Herrega\n");
    if (accounts.size() == 0)
      builder.append("Herregni hin argamne \n");
    String sourceAccount = (String)session.getMetaProperty(MetadataKey.sft_source_account_id.toString());
    int count = 1;
    for (Account account : accounts) {
      if (!account.getId().equalsIgnoreCase(sourceAccount)) {
        builder.append(count++ + ". " + account.getDescriptor() + "\n");
        continue;
      }
      count++;
    }
    builder.append("*.Dubatti Deebi'i");
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
    if (index <= 0 || index > accounts.size())
      return menu.getMenuLevel();
    Account selectedAccount = accounts.get(index - 1);
    session.setMetaProperty(MetadataKey.sft_dest_account.toString(), Integer.valueOf(index));
    session.setMetaProperty(MetadataKey.sft_dest_account_name.toString(), selectedAccount.getShortDescriptor());
    session.setMetaProperty(MetadataKey.sft_dest_account_id.toString(), selectedAccount.getId());
    return null;
  }
}

