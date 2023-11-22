package com.bank.ussd.services.api;

import com.bank.ussd.data.UssdSession;

import com.bank.ussd.apiclient.payments2.model.CreateFundsTransferNewTrf;
import com.bank.ussd.apiclient.payments2.model.FundsTransferNewTrfResponse;

import com.bank.ussd.data.api.Transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class PaymentsApiService {

  @Autowired
//  @Qualifier("paymentsApi2")
  private com.bank.ussd.apiclient.payments2.api.DefaultApi paymentsApi2;


   public Transfer createTransfer(UssdSession session, Transfer transfer) throws RestClientException {
       
      CreateFundsTransferNewTrf tr = transfer.toPaymentOrderNew();
    FundsTransferNewTrfResponse result = this.paymentsApi2.createFundsTransferNewTrf(tr, session.getCredentials(), null, null);
    return new Transfer(result.getHeader().getId(), result.getBody());
  }





}

