package com.bank.ussd.data.api;

import com.bank.ussd.apiclient.accountList.model.TransactionalHoldingsResponseBodyInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.bank.ussd.apiclient.holdings2.model.HoldingsResponseBodyInnerProducts;
import java.util.List;

public class Account {
  @JsonProperty("name")
  private String name;

  @JsonProperty("number")
  private String number;

  @JsonProperty("balance")
  private String balance;

  @JsonProperty("currencyCode")
  private String currencyCode;

  @JsonProperty("accountHolder")
  private String accountHolder;
  @JsonProperty("productLineName")
  private String productName;
  @JsonProperty("id")
  private String id;

  private List<String> interests;

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("number")
  public void setNumber(String number) {
    this.number = number;
  }

  @JsonProperty("balance")
  public void setBalance(String balance) {
    this.balance = balance;
  }

  @JsonProperty("currencyCode")
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  @JsonProperty("accountHolder")
  public void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
  }

  @JsonProperty("productLineName")
  public void setProductName(String productName) {
    this.productName = productName;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }


  public String toString() {
    return "Account(name=" + getName() + ", number=" + getNumber() + ", balance=" + getBalance() + ", currencyCode=" + getCurrencyCode() + ", accountHolder=" + getAccountHolder() + ", id=" + getId() + ", interests=" + getInterests() + ")";
  }

  public String getName() {
    return this.name;
  }

  public String getNumber() {
    return this.number;
  }

  public String getBalance() {
    return this.balance;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public String getAccountHolder() {
    return this.accountHolder;
  }

  public String getId() {
    return this.id;
  }

  public List<String> getInterests() {
    return this.interests;
  }
 public String getProductName(){
    return this.productName;
 }
  public Account() {}

  public Account(TransactionalHoldingsResponseBodyInner account) {
    if (account == null)
      return;
    this.id = account.getAccountId();
    this.name = account.getShortTitle();
    this.number = account.getAccountId();
    this.balance = account.getAvailableBalance().toString();
    if (this.balance == null)
      this.balance = account.getWorkingBalance().toString();
    this.currencyCode = account.getCurrencyId();
    this.accountHolder = account.getShortTitle();
    this.productName=account.getProductLineName();
  }

  public Account(String id, String name) {
    this.id = this.number = id;
    this.name = name;
  }

  public String getShortNumber(int count) {
    if (this.number != null && this.number.length() > count)
      return this.number.substring(this.number.length() - count);
    return this.number;
  }

  public String getDescriptor() {
    return getName() + " - " + getCurrencyCode() + " - " + getShortNumber(4);
  }

  public String getShortDescriptor() {
    return getName() + " - " + getShortNumber(4);
  }
}

