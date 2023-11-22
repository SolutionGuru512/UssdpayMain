package com.bank.ussd.handlers;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Transaction;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.services.api.TransactionsApiService;
import com.bank.ussd.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.util.List;
@Component
public class accountListDetailsHandler2 extends BaseMenuHandler {
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
            return "CON Unable to fetch transactions.\nPress 0 to return.";
        }

        StringBuilder builder = new StringBuilder("CON ${account_list_selected_account_id}\n");
        //builder.append("Available balance: ${account_list_selected_account_currency} ${account_list_selected_account_balance}\n");
        if (transactions.size() == 0) {
            builder.append("No transactions found\n");
        }
        int count = 1;
        for (Transaction transaction : transactions) {
            builder.append(count++ + ". " + StringUtils.shortDate(transaction.getTransactionDate()) + ": " + ((transaction.getAmount().longValue() >= 0L) ? "Credit" : "Debit") + "  " + StringUtils.currency(transaction.getAmount()) + "\n");
        }
        builder.append("*.Back\n");
        builder.append("0.Return to Main Menu");
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
