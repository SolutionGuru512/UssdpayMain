package com.bank.ussd.services.api;

import com.bank.ussd.apiclient.accountDetail.model.AccountListResponse;
import com.bank.ussd.apiclient.accountList.api.DefaultApi;
import com.bank.ussd.data.UssdSession;
import com.bank.ussd.data.api.Account;
import com.bank.ussd.apiclient.accountList.model.LoanHoldingsResponseBody;
import com.bank.ussd.apiclient.accountList.model.TransactionalHoldingsResponseBody;
import com.bank.ussd.apiclient.holdings2.model.HoldingsResponse;
import com.bank.ussd.apiclient.holdings2.model.HoldingsResponseBodyInnerProducts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bank.ussd.services.HandlerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class HoldingsApiService {
  private static final Logger log = LogManager.getLogger(HoldingsApiService.class);

  @Autowired
//  @Qualifier("holdingsApi2")
  private com.bank.ussd.apiclient.holdings2.api.DefaultApi holdingsApi2;
  @Autowired
//  @Qualifier("holdingsApi2")
  private DefaultApi accountListApi;
  @Autowired
//  @Qualifier("com.bank.ussd.apiclient.accountDetail.api.DefaultApi")
  private com.bank.ussd.apiclient.accountDetail.api.DefaultApi accountDetailApiInstance;
  public String getAccountHolderName(String accountNumber) {
    try {

      AccountListResponse result = this.accountDetailApiInstance.getAccountList(accountNumber, null, null, null, null, null, null);
      if (result == null) {
        log.debug("getAccountHolderName null");
        return "";
      }
      log.debug(result.toString());
      if (result.getBody().isEmpty())
        return "";
      return result.getBody().stream().map((accountListResponseBodyInner) -> {
        return accountListResponseBodyInner.getAccountName();
      }).collect(Collectors.toList()).get(0);
    }catch (Exception e){
      log.debug("getAccountHolderName null");
      log.debug(e.getMessage());
      return null;
    }
  }
  public List<Account> findAccountList(UssdSession session) throws RestClientException {


    TransactionalHoldingsResponseBody transactionalHoldingsResponseBody=accountListApi.getTransactionalHoldings(session.getCustomerId(),null,null,null,null,null,null).getBody();

    List<Account> tAccounts=transactionalHoldingsResponseBody.stream().map((transactionalHoldingsResponseBodyInner)->{
      Account account=new Account();
      account.setName(transactionalHoldingsResponseBodyInner.getShortTitle());
      account.setId(transactionalHoldingsResponseBodyInner.getAccountId());
      account.setNumber(transactionalHoldingsResponseBodyInner.getAccountId());
      if(transactionalHoldingsResponseBodyInner.getOnlineActualBalance()!= null) {
        account.setBalance(transactionalHoldingsResponseBodyInner.getOnlineActualBalance());
      }else {
        account.setBalance(transactionalHoldingsResponseBodyInner.getWorkingBalance());
      }
      account.setAccountHolder(transactionalHoldingsResponseBodyInner.getShortTitle());
      account.setCurrencyCode(transactionalHoldingsResponseBodyInner.getCurrencyId());
      account.setProductName(transactionalHoldingsResponseBodyInner.getProductLineName());
//              accounts.add(account);
      return account;
    }).collect(Collectors.toList());

//    LoanHoldingsResponseBody loanHoldingsResponseBody=accountListApi.getLoanHoldings(session.getCustomerId(),null,null,null,null,null,null).getBody();
//    List<Account> lAccount=loanHoldingsResponseBody.stream().map((loanHoldingsResponseBodyInner)->{
//      Account account2=new Account();
//      account2.setName(loanHoldingsResponseBodyInner.getShortTitle());
//      account2.setId(loanHoldingsResponseBodyInner.getAccountId());
//      account2.setNumber(loanHoldingsResponseBodyInner.getAccountId());
//      if(loanHoldingsResponseBodyInner.getOnlineActualBalance()!= null) {
//        account2.setBalance(loanHoldingsResponseBodyInner.getOnlineActualBalance());
//      }else {
//        account2.setBalance(loanHoldingsResponseBodyInner.getWorkingBalance());
//      }
//      account2.setAccountHolder(loanHoldingsResponseBodyInner.getShortTitle());
//      account2.setCurrencyCode(loanHoldingsResponseBodyInner.getCurrencyId());
//      tAccounts.add(account2);
//      return account2;
//    }).collect(Collectors.toList());
    log.debug(tAccounts.toString());
    return tAccounts;
  }
  public List<Account> findTransactionAccountList(UssdSession session) throws RestClientException {
//    List<Account> accounts = null;

    TransactionalHoldingsResponseBody transactionalHoldingsResponseBody=accountListApi.getTransactionalHoldings(session.getCustomerId(),null,null,null,null,null,null).getBody();
    List<Account> tAccounts=transactionalHoldingsResponseBody.stream().map((transactionalHoldingsResponseBodyInner)->{
      Account account=new Account();
      account.setName(transactionalHoldingsResponseBodyInner.getShortTitle());
      account.setId(transactionalHoldingsResponseBodyInner.getAccountId());
      account.setNumber(transactionalHoldingsResponseBodyInner.getAccountId());
      if(transactionalHoldingsResponseBodyInner.getOnlineActualBalance()!= null) {
        account.setBalance(transactionalHoldingsResponseBodyInner.getOnlineActualBalance());
      }else {
        account.setBalance(transactionalHoldingsResponseBodyInner.getWorkingBalance());
      }
      account.setAccountHolder(transactionalHoldingsResponseBodyInner.getShortTitle());
      account.setCurrencyCode(transactionalHoldingsResponseBodyInner.getCurrencyId());
      account.setProductName(transactionalHoldingsResponseBodyInner.getProductLineName());
//              accounts.add(account);
      return account;
    }).collect(Collectors.toList());
    log.debug(tAccounts.toString());
    return tAccounts;
  }
 }
