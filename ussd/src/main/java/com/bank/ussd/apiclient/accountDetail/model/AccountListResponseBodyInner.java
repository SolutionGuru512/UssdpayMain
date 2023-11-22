

package com.bank.ussd.apiclient.accountDetail.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * AccountListResponseBodyInner
 */

public class AccountListResponseBodyInner {
  @JsonProperty("accountId")
  private String accountId = null;

  @JsonProperty("accountName")
  private String accountName = null;

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("onlineActualBalance")
  private BigDecimal onlineActualBalance = null;

  public AccountListResponseBodyInner accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Identifier of the account. Often referred to as the account number, yet for consistency this is always referred to as accountId. Accepts both IBAN &amp; BBAN
   * maximum: 19
   * @return accountId
  **/
  @ApiModelProperty(value = "Identifier of the account. Often referred to as the account number, yet for consistency this is always referred to as accountId. Accepts both IBAN & BBAN")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public AccountListResponseBodyInner accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * Display name or short name of the account specified.
   * @return accountName
  **/
  @ApiModelProperty(value = "Display name or short name of the account specified.")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public AccountListResponseBodyInner customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Identifier of the customer
   * @return customerId
  **/
  @ApiModelProperty(value = "Identifier of the customer")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public AccountListResponseBodyInner currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Identifies the currency. E.g. USD, GBP etc
   * @return currency
  **/
  @ApiModelProperty(value = "Identifies the currency. E.g. USD, GBP etc")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public AccountListResponseBodyInner productName(String productName) {
    this.productName = productName;
    return this;
  }

   /**
   * Product name of the bank for this account, proprietary definition.
   * @return productName
  **/
  @ApiModelProperty(value = "Product name of the bank for this account, proprietary definition.")
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public AccountListResponseBodyInner onlineActualBalance(BigDecimal onlineActualBalance) {
    this.onlineActualBalance = onlineActualBalance;
    return this;
  }

   /**
   * Real-time balance including all authorised transactions posted against the account, excluding any entries with a future processing date.
   * maximum: 19
   * @return onlineActualBalance
  **/
  @ApiModelProperty(value = "Real-time balance including all authorised transactions posted against the account, excluding any entries with a future processing date.")
  public BigDecimal getOnlineActualBalance() {
    return onlineActualBalance;
  }

  public void setOnlineActualBalance(BigDecimal onlineActualBalance) {
    this.onlineActualBalance = onlineActualBalance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountListResponseBodyInner accountListResponseBodyInner = (AccountListResponseBodyInner) o;
    return Objects.equals(this.accountId, accountListResponseBodyInner.accountId) &&
        Objects.equals(this.accountName, accountListResponseBodyInner.accountName) &&
        Objects.equals(this.customerId, accountListResponseBodyInner.customerId) &&
        Objects.equals(this.currency, accountListResponseBodyInner.currency) &&
        Objects.equals(this.productName, accountListResponseBodyInner.productName) &&
        Objects.equals(this.onlineActualBalance, accountListResponseBodyInner.onlineActualBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, accountName, customerId, currency, productName, onlineActualBalance);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountListResponseBodyInner {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    onlineActualBalance: ").append(toIndentedString(onlineActualBalance)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

