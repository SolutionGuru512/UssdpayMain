 package com.bank.ussd.services.api;

 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Transaction;
 import com.bank.ussd.apiclient.transactions.api.DefaultApi;
 import com.bank.ussd.apiclient.transactions.model.AccountTransactionsResponse;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.web.client.RestClientException;

 @Service
 public class TransactionsApiService {
   private static final Logger log = LoggerFactory.getLogger(TransactionsApiService.class);

   @Autowired
   private DefaultApi transactionsApiInstance;

   public List<Transaction> getTransactions(UssdSession session, String accountId) throws RestClientException {
//     this.transactionsApiInstance.getApiClient().addDefaultHeader("credentials", session.getCredentials());
     AccountTransactionsResponse result = this.transactionsApiInstance.getAccountTransactions(accountId, null, "RECENT", "9", null, null, null, null, null, null, null, null, null, null, null, null, null);
     log.debug(result.toString());
     if (result.getBody().isEmpty())
       return new ArrayList<>();
     return (List<Transaction>)result.getBody().stream().limit(9L).map(transaction -> new Transaction(transaction)).collect(Collectors.toList());
   }
    public List<Transaction> getFirstTransactions(UssdSession session, String accountId){
         List<Transaction> transactions=getTransactions(session,accountId);
         if (transactions.size()>0)
             return transactions.subList(0,3);
         return new ArrayList<>();
     }
     public List<Transaction> getNextTransactions(UssdSession session, String accountId){
         List<Transaction> transactions=getTransactions(session,accountId);
         if (transactions.size()>0)
             return transactions.subList(4,transactions.size()-1);
         return new ArrayList<>();
     }
 }

