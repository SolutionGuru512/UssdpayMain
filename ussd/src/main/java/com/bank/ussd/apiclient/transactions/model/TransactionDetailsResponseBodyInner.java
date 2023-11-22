/*
 * Transactions APIs
 * Get Transactions Details
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.transactions.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * TransactionDetailsResponseBodyInner
 */

public class TransactionDetailsResponseBodyInner {
  @JsonProperty("debits")
  private List<TransactionDetailsResponseBodyInnerDebits> debits = null;

  @JsonProperty("credits")
  private List<TransactionDetailsResponseBodyInnerCredits> credits = null;

  @JsonProperty("beneficiaries")
  private List<TransactionDetailsResponseBodyInnerBeneficiaries> beneficiaries = null;

  @JsonProperty("statementReference")
  private String statementReference = null;

  @JsonProperty("bookingDate")
  private LocalDate bookingDate = null;

  @JsonProperty("narrative")
  private String narrative = null;

  @JsonProperty("currencyId")
  private String currencyId = null;

  @JsonProperty("exposureDate")
  private LocalDate exposureDate = null;

  @JsonProperty("valueDate")
  private LocalDate valueDate = null;

  @JsonProperty("transactionReference")
  private String transactionReference = null;

  @JsonProperty("transactionName")
  private String transactionName = null;

  @JsonProperty("baseCurrencyId")
  private String baseCurrencyId = null;

  @JsonProperty("chargeType")
  private String chargeType = null;

  @JsonProperty("chargeAmount")
  private String chargeAmount = null;

  @JsonProperty("authorisationDate")
  private LocalDate authorisationDate = null;

  @JsonProperty("processingDate")
  private LocalDate processingDate = null;

  @JsonProperty("chequeNumber")
  private String chequeNumber = null;

  @JsonProperty("chequeDrawn")
  private String chequeDrawn = null;

  @JsonProperty("accountId")
  private String accountId = null;

  @JsonProperty("customerRate")
  private String customerRate = null;

  public TransactionDetailsResponseBodyInner debits(List<TransactionDetailsResponseBodyInnerDebits> debits) {
    this.debits = debits;
    return this;
  }

  public TransactionDetailsResponseBodyInner addDebitsItem(TransactionDetailsResponseBodyInnerDebits debitsItem) {
    if (this.debits == null) {
      this.debits = new ArrayList<>();
    }
    this.debits.add(debitsItem);
    return this;
  }

   /**
   * 
   * @return debits
  **/
  @ApiModelProperty(value = "")
  public List<TransactionDetailsResponseBodyInnerDebits> getDebits() {
    return debits;
  }

  public void setDebits(List<TransactionDetailsResponseBodyInnerDebits> debits) {
    this.debits = debits;
  }

  public TransactionDetailsResponseBodyInner credits(List<TransactionDetailsResponseBodyInnerCredits> credits) {
    this.credits = credits;
    return this;
  }

  public TransactionDetailsResponseBodyInner addCreditsItem(TransactionDetailsResponseBodyInnerCredits creditsItem) {
    if (this.credits == null) {
      this.credits = new ArrayList<>();
    }
    this.credits.add(creditsItem);
    return this;
  }

   /**
   * 
   * @return credits
  **/
  @ApiModelProperty(value = "")
  public List<TransactionDetailsResponseBodyInnerCredits> getCredits() {
    return credits;
  }

  public void setCredits(List<TransactionDetailsResponseBodyInnerCredits> credits) {
    this.credits = credits;
  }

  public TransactionDetailsResponseBodyInner beneficiaries(List<TransactionDetailsResponseBodyInnerBeneficiaries> beneficiaries) {
    this.beneficiaries = beneficiaries;
    return this;
  }

  public TransactionDetailsResponseBodyInner addBeneficiariesItem(TransactionDetailsResponseBodyInnerBeneficiaries beneficiariesItem) {
    if (this.beneficiaries == null) {
      this.beneficiaries = new ArrayList<>();
    }
    this.beneficiaries.add(beneficiariesItem);
    return this;
  }

   /**
   * 
   * @return beneficiaries
  **/
  @ApiModelProperty(value = "")
  public List<TransactionDetailsResponseBodyInnerBeneficiaries> getBeneficiaries() {
    return beneficiaries;
  }

  public void setBeneficiaries(List<TransactionDetailsResponseBodyInnerBeneficiaries> beneficiaries) {
    this.beneficiaries = beneficiaries;
  }

  public TransactionDetailsResponseBodyInner statementReference(String statementReference) {
    this.statementReference = statementReference;
    return this;
  }

   /**
   * 
   * @return statementReference
  **/
  @ApiModelProperty(value = "")
  public String getStatementReference() {
    return statementReference;
  }

  public void setStatementReference(String statementReference) {
    this.statementReference = statementReference;
  }

  public TransactionDetailsResponseBodyInner bookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
    return this;
  }

   /**
   * The date on which the entry was generated. Normally, but not necessarily, the actual date at the time the entry is generated, e.g. if the previous day&#39;s business is still being processed after midnight, the actual date changes, but the run date is still the previous day.
   * @return bookingDate
  **/
  @ApiModelProperty(value = "The date on which the entry was generated. Normally, but not necessarily, the actual date at the time the entry is generated, e.g. if the previous day's business is still being processed after midnight, the actual date changes, but the run date is still the previous day.")
  public LocalDate getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(LocalDate bookingDate) {
    this.bookingDate = bookingDate;
  }

  public TransactionDetailsResponseBodyInner narrative(String narrative) {
    this.narrative = narrative;
    return this;
  }

   /**
   * The additional text printed on descriptive statements in addition to the standard narrative and/or reference
   * @return narrative
  **/
  @ApiModelProperty(value = "The additional text printed on descriptive statements in addition to the standard narrative and/or reference")
  public String getNarrative() {
    return narrative;
  }

  public void setNarrative(String narrative) {
    this.narrative = narrative;
  }

  public TransactionDetailsResponseBodyInner currencyId(String currencyId) {
    this.currencyId = currencyId;
    return this;
  }

   /**
   * The identifier of the curreny. The is the 3 letter ISO 4217 code of the currency.
   * @return currencyId
  **/
  @ApiModelProperty(value = "The identifier of the curreny. The is the 3 letter ISO 4217 code of the currency.")
  public String getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(String currencyId) {
    this.currencyId = currencyId;
  }

  public TransactionDetailsResponseBodyInner exposureDate(LocalDate exposureDate) {
    this.exposureDate = exposureDate;
    return this;
  }

   /**
   * 
   * @return exposureDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getExposureDate() {
    return exposureDate;
  }

  public void setExposureDate(LocalDate exposureDate) {
    this.exposureDate = exposureDate;
  }

  public TransactionDetailsResponseBodyInner valueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
    return this;
  }

   /**
   * The applicable value date
   * @return valueDate
  **/
  @ApiModelProperty(value = "The applicable value date")
  public LocalDate getValueDate() {
    return valueDate;
  }

  public void setValueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
  }

  public TransactionDetailsResponseBodyInner transactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
    return this;
  }

   /**
   * The transaction reference identifier
   * @return transactionReference
  **/
  @ApiModelProperty(value = "The transaction reference identifier")
  public String getTransactionReference() {
    return transactionReference;
  }

  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
  }

  public TransactionDetailsResponseBodyInner transactionName(String transactionName) {
    this.transactionName = transactionName;
    return this;
  }

   /**
   * The name of the transaction
   * @return transactionName
  **/
  @ApiModelProperty(value = "The name of the transaction")
  public String getTransactionName() {
    return transactionName;
  }

  public void setTransactionName(String transactionName) {
    this.transactionName = transactionName;
  }

  public TransactionDetailsResponseBodyInner baseCurrencyId(String baseCurrencyId) {
    this.baseCurrencyId = baseCurrencyId;
    return this;
  }

   /**
   * 
   * @return baseCurrencyId
  **/
  @ApiModelProperty(value = "")
  public String getBaseCurrencyId() {
    return baseCurrencyId;
  }

  public void setBaseCurrencyId(String baseCurrencyId) {
    this.baseCurrencyId = baseCurrencyId;
  }

  public TransactionDetailsResponseBodyInner chargeType(String chargeType) {
    this.chargeType = chargeType;
    return this;
  }

   /**
   * The type of charge
   * @return chargeType
  **/
  @ApiModelProperty(value = "The type of charge")
  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }

  public TransactionDetailsResponseBodyInner chargeAmount(String chargeAmount) {
    this.chargeAmount = chargeAmount;
    return this;
  }

   /**
   * Holds the charge amount equivalent in charge account currency
   * @return chargeAmount
  **/
  @ApiModelProperty(value = "Holds the charge amount equivalent in charge account currency")
  public String getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(String chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public TransactionDetailsResponseBodyInner authorisationDate(LocalDate authorisationDate) {
    this.authorisationDate = authorisationDate;
    return this;
  }

   /**
   * 
   * @return authorisationDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getAuthorisationDate() {
    return authorisationDate;
  }

  public void setAuthorisationDate(LocalDate authorisationDate) {
    this.authorisationDate = authorisationDate;
  }

  public TransactionDetailsResponseBodyInner processingDate(LocalDate processingDate) {
    this.processingDate = processingDate;
    return this;
  }

   /**
   * The bank date that an accounting movement is applied to the bank GL
   * @return processingDate
  **/
  @ApiModelProperty(value = "The bank date that an accounting movement is applied to the bank GL")
  public LocalDate getProcessingDate() {
    return processingDate;
  }

  public void setProcessingDate(LocalDate processingDate) {
    this.processingDate = processingDate;
  }

  public TransactionDetailsResponseBodyInner chequeNumber(String chequeNumber) {
    this.chequeNumber = chequeNumber;
    return this;
  }

   /**
   * The cheque number. Formed as chequeType.accountId.chequeOrDraftNumber. See chequeId
   * @return chequeNumber
  **/
  @ApiModelProperty(value = "The cheque number. Formed as chequeType.accountId.chequeOrDraftNumber. See chequeId")
  public String getChequeNumber() {
    return chequeNumber;
  }

  public void setChequeNumber(String chequeNumber) {
    this.chequeNumber = chequeNumber;
  }

  public TransactionDetailsResponseBodyInner chequeDrawn(String chequeDrawn) {
    this.chequeDrawn = chequeDrawn;
    return this;
  }

   /**
   * 
   * @return chequeDrawn
  **/
  @ApiModelProperty(value = "")
  public String getChequeDrawn() {
    return chequeDrawn;
  }

  public void setChequeDrawn(String chequeDrawn) {
    this.chequeDrawn = chequeDrawn;
  }

  public TransactionDetailsResponseBodyInner accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * The identifier of the account. Often referred to as the account number, yet for consistency this is always referred to as accountId.
   * @return accountId
  **/
  @ApiModelProperty(value = "The identifier of the account. Often referred to as the account number, yet for consistency this is always referred to as accountId.")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public TransactionDetailsResponseBodyInner customerRate(String customerRate) {
    this.customerRate = customerRate;
    return this;
  }

   /**
   * The exchange rate that is actually used to convert an amount from one currency to another in a payment transaction.
   * @return customerRate
  **/
  @ApiModelProperty(value = "The exchange rate that is actually used to convert an amount from one currency to another in a payment transaction.")
  public String getCustomerRate() {
    return customerRate;
  }

  public void setCustomerRate(String customerRate) {
    this.customerRate = customerRate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionDetailsResponseBodyInner transactionDetailsResponseBodyInner = (TransactionDetailsResponseBodyInner) o;
    return Objects.equals(this.debits, transactionDetailsResponseBodyInner.debits) &&
        Objects.equals(this.credits, transactionDetailsResponseBodyInner.credits) &&
        Objects.equals(this.beneficiaries, transactionDetailsResponseBodyInner.beneficiaries) &&
        Objects.equals(this.statementReference, transactionDetailsResponseBodyInner.statementReference) &&
        Objects.equals(this.bookingDate, transactionDetailsResponseBodyInner.bookingDate) &&
        Objects.equals(this.narrative, transactionDetailsResponseBodyInner.narrative) &&
        Objects.equals(this.currencyId, transactionDetailsResponseBodyInner.currencyId) &&
        Objects.equals(this.exposureDate, transactionDetailsResponseBodyInner.exposureDate) &&
        Objects.equals(this.valueDate, transactionDetailsResponseBodyInner.valueDate) &&
        Objects.equals(this.transactionReference, transactionDetailsResponseBodyInner.transactionReference) &&
        Objects.equals(this.transactionName, transactionDetailsResponseBodyInner.transactionName) &&
        Objects.equals(this.baseCurrencyId, transactionDetailsResponseBodyInner.baseCurrencyId) &&
        Objects.equals(this.chargeType, transactionDetailsResponseBodyInner.chargeType) &&
        Objects.equals(this.chargeAmount, transactionDetailsResponseBodyInner.chargeAmount) &&
        Objects.equals(this.authorisationDate, transactionDetailsResponseBodyInner.authorisationDate) &&
        Objects.equals(this.processingDate, transactionDetailsResponseBodyInner.processingDate) &&
        Objects.equals(this.chequeNumber, transactionDetailsResponseBodyInner.chequeNumber) &&
        Objects.equals(this.chequeDrawn, transactionDetailsResponseBodyInner.chequeDrawn) &&
        Objects.equals(this.accountId, transactionDetailsResponseBodyInner.accountId) &&
        Objects.equals(this.customerRate, transactionDetailsResponseBodyInner.customerRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(debits, credits, beneficiaries, statementReference, bookingDate, narrative, currencyId, exposureDate, valueDate, transactionReference, transactionName, baseCurrencyId, chargeType, chargeAmount, authorisationDate, processingDate, chequeNumber, chequeDrawn, accountId, customerRate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDetailsResponseBodyInner {\n");
    
    sb.append("    debits: ").append(toIndentedString(debits)).append("\n");
    sb.append("    credits: ").append(toIndentedString(credits)).append("\n");
    sb.append("    beneficiaries: ").append(toIndentedString(beneficiaries)).append("\n");
    sb.append("    statementReference: ").append(toIndentedString(statementReference)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    narrative: ").append(toIndentedString(narrative)).append("\n");
    sb.append("    currencyId: ").append(toIndentedString(currencyId)).append("\n");
    sb.append("    exposureDate: ").append(toIndentedString(exposureDate)).append("\n");
    sb.append("    valueDate: ").append(toIndentedString(valueDate)).append("\n");
    sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
    sb.append("    transactionName: ").append(toIndentedString(transactionName)).append("\n");
    sb.append("    baseCurrencyId: ").append(toIndentedString(baseCurrencyId)).append("\n");
    sb.append("    chargeType: ").append(toIndentedString(chargeType)).append("\n");
    sb.append("    chargeAmount: ").append(toIndentedString(chargeAmount)).append("\n");
    sb.append("    authorisationDate: ").append(toIndentedString(authorisationDate)).append("\n");
    sb.append("    processingDate: ").append(toIndentedString(processingDate)).append("\n");
    sb.append("    chequeNumber: ").append(toIndentedString(chequeNumber)).append("\n");
    sb.append("    chequeDrawn: ").append(toIndentedString(chequeDrawn)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    customerRate: ").append(toIndentedString(customerRate)).append("\n");
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

