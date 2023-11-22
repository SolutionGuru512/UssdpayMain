 package com.bank.ussd.handlers.oft.AO;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Account;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.handlers.BaseMenuHandler;
 import com.bank.ussd.services.api.HoldingsApiService;
 import com.bank.ussd.utils.StringUtils;

 import java.util.ArrayList;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 @Component
 public class OtherTransferDestinationLookupMenuHandler_AO extends BaseMenuHandler {
   @Autowired
   private HoldingsApiService accountLookupApi;

   public String getOutput(UssdSession session, Menu menu) {
     String destAccount = (String)session.getMetaValue(MetadataKey.oft_dest_account_id);
     String holderName = this.accountLookupApi.getAccountHolderName(destAccount);
     if (holderName == null)
       return "CON Herregni wal fakkataan argamuu hin dandeenyr. Lakkoofsa herrega kessan mirkaneessaa.\n" + "*. Tuquun duubatti deebi'aa";
     session.setMetaValue(MetadataKey.oft_dest_account_name, holderName);
     List<Account> accounts = new ArrayList<>();
     Account acc = new Account("1", "lakkoofsa herregaa");
     acc.setNumber((String)session.getMetaValue(MetadataKey.oft_dest_account_id));
     acc.setAccountHolder(holderName);
     accounts.add(acc);
     StringBuilder builder = new StringBuilder("CON Mallaqa nama biroof daddabarsuu (3/4)\ngara lakkoofsa herregaa\n");
     int count = 1;
     for (Account account : accounts)
       builder.append(count++ + ". " + account.getAccountHolder() + " - " + account.getShortNumber(4) + "\n");
     builder.append("*.haquuf");
     return builder.toString();
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
     List<Account> accounts = new ArrayList<>();
     Account acc = new Account("1", "lakkoofsa herregaa");
     acc.setNumber((String)session.getMetaProperty(MetadataKey.oft_dest_account_id.toString()));
     acc.setAccountHolder((String)session.getMetaProperty(MetadataKey.oft_dest_account_name.toString()));
     accounts.add(acc);
     int index = StringUtils.stringToInt(input, -1);
     if (index <= 0 || index > accounts.size())
       return menu.getMenuLevel();
     Account selectedAccount = accounts.get(index - 1);
     session.setMetaValue(MetadataKey.oft_dest_account, Integer.valueOf(index));
     session.setMetaValue(MetadataKey.oft_dest_account_name, selectedAccount.getAccountHolder() + " - " + selectedAccount.getShortNumber(4));
     session.setMetaValue(MetadataKey.oft_dest_account_id, selectedAccount.getNumber());
     return null;
   }
 }


