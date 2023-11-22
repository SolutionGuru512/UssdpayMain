package com.bank.ussd.handlers.sft.AM;

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
public class SelfTransferProcessMenuHandler_AM extends BaseMenuHandler {
  private static final Logger log = LogManager.getLogger(SelfTransferProcessMenuHandler_AM.class);

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
      return "CON ማስተላለፉ ተሳክቷል\nየተላለፈው መጠን: " + StringUtils.currencyAmount(transfer.getAmount()) + "\nለመያ: " + completedTransfer
        .getId() + "\nተቀናሽ ሂሳብ: " + completedTransfer
        .getSourceAccountId() + "\nገቢ የተደረገበት ሒሳብ: " + completedTransfer
        .getDestinationAccountId() + "\nቀን: " +
        StringUtils.fullDate(completedTransfer.getTransferDate()) + "\nወደ ዋና መግቢያ ለመመለስ 0 ይጫኑ.";
    } catch (RestClientException ex) {
      log.error("LogRemote {} {} {} {}", menu.getMenuLevel(), session.getExternalUser(), session.getPhoneNumber(), ex);
      String errorMessage = StringUtils.getErrorMessage((Exception)ex, "ማስተላለፉን ማከናወን አልተቻለም.");
      return "CON " + errorMessage + "\nለመመለስ 0 ይጫኑ.";
    }
  }

  public String handleInput(UssdSession session, String input, Menu menu) {
    return null;
  }
}
