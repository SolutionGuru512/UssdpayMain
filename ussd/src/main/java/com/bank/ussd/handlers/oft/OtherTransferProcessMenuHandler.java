package com.bank.ussd.handlers.oft;

import com.bank.ussd.data.Menu;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Transfer;
import com.bank.ussd.enums.MetadataKey;
import com.bank.ussd.handlers.BaseMenuHandler;
import com.bank.ussd.services.api.PaymentsApiService;
import com.bank.ussd.utils.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;

@Component
public class OtherTransferProcessMenuHandler extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(OtherTransferProcessMenuHandler.class);

  @Autowired
  PaymentsApiService apiService;

  public String getOutput(UssdSession session, Menu menu) {
    Transfer transfer = new Transfer();
    transfer.setDestinationAccountId((String)session.getMetaProperty(MetadataKey.oft_dest_account_id.toString()));
    transfer.setSourceAccountId((String)session.getMetaProperty(MetadataKey.oft_source_account_id.toString()));
    transfer.setAmount(new BigDecimal((String)session.getMetaProperty(MetadataKey.oft_amount.toString())));
    transfer.setReason((String)session.getMetaProperty(MetadataKey.oft_reason.toString()));
    transfer.setCurrencyId((String)session.getMetaProperty(MetadataKey.oft_currency.toString()));
    log.info("OFT \n" + transfer.toPaymentOrderNew().toString());
    try {
      Transfer completedTransfer = this.apiService.createTransfer(session, transfer);
      return "CON Transfer successful.\nTxn Amount: " + StringUtils.currencyAmount(transfer.getAmount()) + " ETB\nTxn ID: " + completedTransfer
        .getId() + "\nDebit Acct: " + completedTransfer.getSourceAccountId() +
              "\nCredit Acct: " + completedTransfer.getDestinationAccountId() +
              "\nDate: " +StringUtils.fullDate(completedTransfer.getTransferDate()) +
              "\nReason: " + completedTransfer.getReason() +
              "\nEnter 0 to return to main menu.";
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      String errorMessage = StringUtils.getErrorMessage((Exception)ex, "Unable to process transaction.");
      return "CON " + errorMessage + "\nPress 0 to return.";
    } finally {}
  }

  public String handleInput(UssdSession session, String input, Menu menu) {
    return null;
  }
}

