package com.bank.ussd.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AccountLookup {
  @JsonProperty("ACC.SHORTNAME")
  private String accountHolder;

  public String toString() {
    return "AccountLookup(accountHolder=" + getAccountHolder() + ")";
  }


  @JsonProperty("ACC.SHORTNAME")
  public void setAccountHolder(String accountHolder) {
    this.accountHolder = accountHolder;
  }

  public static class AccountLookupList {
    public List<AccountLookup> rows;
  }

  public static class AccountLookupData {
    public AccountLookup.AccountLookupList data;
  }

  public String getAccountHolder() {
    return this.accountHolder;
  }
}
