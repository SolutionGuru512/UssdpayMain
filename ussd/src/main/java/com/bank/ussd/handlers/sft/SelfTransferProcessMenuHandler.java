package com.bank.ussd.handlers.sft;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Transfer;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.handlers.BaseMenuHandler;
import com.bank.ussd.services.api.PaymentsApiService;
import com.bank.ussd.utils.StringUtils;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

@Component
public class SelfTransferProcessMenuHandler extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(SelfTransferProcessMenuHandler.class);

  @Autowired
  PaymentsApiService apiService;

  public String getOutput(UssdSession session, Menu menu) {
    Transfer transfer = new Transfer();
    transfer.setDestinationAccountId((String)session.getMetaProperty(MetadataKey.sft_dest_account_id.toString()));
    transfer.setSourceAccountId((String)session.getMetaProperty(MetadataKey.sft_source_account_id.toString()));
    transfer.setAmount(new BigDecimal((String)session.getMetaProperty(MetadataKey.sft_amount.toString())));
    transfer.setReason((String)session.getMetaProperty(MetadataKey.sft_reason.toString()));
    transfer.setCurrencyId((String)session.getMetaProperty(MetadataKey.sft_currency.toString()));
    log.info("SFT \n" + transfer.toPaymentOrderNew().toString());
    try {
      Transfer completedTransfer = this.apiService.createTransfer(session, transfer);
      return "CON Transfer successful.\nTxn Amount: " + StringUtils.currencyAmount(transfer.getAmount()) + " ETB\nTxn ID: " + completedTransfer
        .getId() + "\nDebit Acct: " + completedTransfer
        .getSourceAccountId() + "\nCredit Acct: " + completedTransfer
        .getDestinationAccountId() + "\nDate: " +
        StringUtils.fullDate(completedTransfer.getTransferDate()) + "\nEnter 0 to return to main menu.";
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      String errorMessage = StringUtils.getErrorMessage((Exception)ex, "Unable to process transaction.");
      return "CON " + errorMessage + "\nPress 0 to return.";
    }
  }

  public String handleInput(UssdSession session, String input, Menu menu) {
    return null;
  }
}
