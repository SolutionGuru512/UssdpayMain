 package com.bank.ussd.handlers.oft;

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
 public class OtherTransferSourceMenuHandler extends BaseMenuHandler {
   private static final Logger log = LogManager.getLogger(OtherTransferSourceMenuHandler.class);

   @Autowired
   HoldingsApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
     List<Account> accounts;
     try {
       accounts = this.apiService.findTransactionAccountList(session);
     } catch (RestClientException ex) {
       log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
       return "CON Unable to fetch accounts. Press # to return.";
     }
     StringBuilder builder = new StringBuilder("CON Other Funds Transfer (1/4)\nFrom Account\n");
     if (accounts.size() == 0)
       builder.append("No accounts found\n");
     int count = 1;
     for (Account account : accounts)
       builder.append(count++ + ". " + account.getDescriptor() + "\n");
     builder.append("*. Back");
     return builder.toString();
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
     List<Account> accounts;
     try {
       accounts = this.apiService.findTransactionAccountList(session);
     } catch (RestClientException ex) {
         System.out.println("*********");
       log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
       return menu.getMenuLevel();
     }
     int index = StringUtils.stringToInt(input, -1);
     if (index <= 0 || index > accounts.size())
       return menu.getMenuLevel();
     Account selectedAccount = accounts.get(index - 1);
     session.setMetaProperty(MetadataKey.oft_source_account.toString(), Integer.valueOf(index));
     session.setMetaProperty(MetadataKey.oft_source_account_name.toString(), selectedAccount.getShortDescriptor());
     session.setMetaProperty(MetadataKey.oft_source_account_id.toString(), selectedAccount.getId());
     session.setMetaProperty(MetadataKey.oft_currency.toString(), selectedAccount.getCurrencyCode());
     return null;
   }
 }
