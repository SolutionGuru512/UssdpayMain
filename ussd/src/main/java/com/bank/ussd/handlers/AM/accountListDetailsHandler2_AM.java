package com.bank.ussd.handlers.AM;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Transaction;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.handlers.BaseMenuHandler;
import com.bank.ussd.handlers.TransactionListMenuHandler;
import com.bank.ussd.services.api.TransactionsApiService;
import com.bank.ussd.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
@Component
public class accountListDetailsHandler2_AM extends BaseMenuHandler {
    private static final Logger log = LogManager.getLogger(TransactionListMenuHandler.class);

    @Autowired
    private TransactionsApiService apiService;

    public String getOutput(UssdSession session, Menu menu) {
        String accountId = (String)session.getMetaValue(MetadataKey.account_list_selected_account_id);
        String balance = (String)session.getMetaValue(MetadataKey.account_list_selected_account_balance);
        List<Transaction> transactions = null;
        try {

            transactions = this.apiService.getNextTransactions(session, accountId);

        } catch (RestClientException ex) {
            log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
            return "CON ሒሳቡን ማግኘት አልቻለም.\nለመመለስ 0 ይጫኑ.";
        }

        StringBuilder builder = new StringBuilder("CON ");
        //builder.append("Available balance: ${account_list_selected_account_currency} ${account_list_selected_account_balance}\n");
        if (transactions.size() == 0) {
            builder.append("ምንም ሒሳብ አልተገኘም\n");
        }
        int count = 1;
        for (Transaction transaction : transactions) {
            builder.append(count++ + ". " + StringUtils.shortDate(transaction.getTransactionDate()) + ": "  + StringUtils.currency(transaction.getAmount()) + "\n");
        }
//        builder.append("*.Back\n");
//        builder.append("0.Return to Main Menu");
        builder.append("*.ለመመለስ\n");
        builder.append("0.ወደ ዋናው ለመመለስ");
        return builder.toString();
    }

    public String handleInput(UssdSession session, String input, Menu menu) {
//        if (input.equalsIgnoreCase("6"))
//            return "ACCOUNT_LIST_DETAILS1";
        String accountId = (String)session.getMetaValue(MetadataKey.account_list_selected_account_id);
        List<Transaction> transactions = null;
        try {
            transactions = this.apiService.getNextTransactions(session, accountId);
        } catch (RestClientException ex) {
            log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
            return menu.getMenuLevel();
        }
        int index = StringUtils.stringToInt(input, -1);
        if (index <= 0 || index > transactions.size())
            return menu.getMenuLevel();
        Transaction selectedTransaction = transactions.get(index - 1);
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction, Integer.valueOf(index));
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_to, selectedTransaction.getDestinationDescriptor());
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_from, selectedTransaction.getSourceDescriptor());
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_narrative, selectedTransaction.getNarrative());
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_amount, StringUtils.currency(selectedTransaction.getAmount()));
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_date, StringUtils.longDate(selectedTransaction.getTransactionDate()));
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_id, selectedTransaction.getId());
        session.setMetaValue(MetadataKey.transaction_list_selected_transaction_currency, selectedTransaction.getCurrencyId());
        return null;
    }
}
