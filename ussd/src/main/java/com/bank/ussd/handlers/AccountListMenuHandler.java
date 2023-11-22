 package com.bank.ussd.handlers;

 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Account;
 import com.bank.ussd.enums.MetadataKey;
 import com.bank.ussd.services.api.HoldingsApiService;
 import com.bank.ussd.utils.StringUtils;
 import java.util.List;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
 import org.springframework.web.client.RestClientException;

 @Component
 public class AccountListMenuHandler extends BaseMenuHandler {
   private static final Logger log = LogManager.getLogger(AccountListMenuHandler.class);

   @Autowired
   HoldingsApiService apiService;

   public String getOutput(UssdSession session, Menu menu) {
     List<Account> accounts;
     try {
       accounts = this.apiService.findAccountList(session);
     } catch (RestClientException ex) {
       log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
       return "CON Unable to fetch accounts.\nPress 0 to return.";
     }
     StringBuilder builder = new StringBuilder(menu.getText());
     if (accounts.size() == 0)
       builder.append("No accounts found\n");
     int count = 1;
     for (Account account : accounts) {
         String balance="0.0";
         if (account.getBalance()!=null){
             balance=account.getBalance();
         }
         builder.append(count++ + ". " + account.getProductName() + "(" + account.getShortNumber(4) +") "+ account.getCurrencyCode()+" "+ balance  + "\n");
     }
     builder.append("*. Back\n");
     return builder.toString();
   }

   public String handleInput(UssdSession session, String input, Menu menu) {
     List<Account> accounts;
     try {
       accounts = this.apiService.findAccountList(session);
     } catch (RestClientException ex) {
       log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
       return menu.getMenuLevel();
     }
     int index = StringUtils.stringToInt(input, -1);
     if (index <= 0 || index > accounts.size())
       return menu.getMenuLevel();
     Account selectedAccount = accounts.get(index - 1);

     session.setMetaValue(MetadataKey.account_list_selected_account, Integer.valueOf(index));
     session.setMetaValue(MetadataKey.account_list_selected_account_name, selectedAccount.getName());
     session.setMetaValue(MetadataKey.account_list_selected_account_id, selectedAccount.getId());
     if (selectedAccount.getBalance()==null){
         session.setMetaValue(MetadataKey.account_list_selected_account_balance, 0.00);
     }else {
         session.setMetaValue(MetadataKey.account_list_selected_account_balance, selectedAccount.getBalance());
     }
     session.setMetaValue(MetadataKey.account_list_selected_account_holder, selectedAccount.getAccountHolder());
     session.setMetaValue(MetadataKey.account_list_selected_account_currency, selectedAccount.getCurrencyCode());
     return null;
   }
 }
