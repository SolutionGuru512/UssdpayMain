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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * StatementForTransactionResponseBodyInner
 */

public class StatementForTransactionResponseBodyInner {
  @JsonProperty("images")
  private List<StatementForTransactionResponseBodyInnerImages> images = null;

  @JsonProperty("statementId")
  private String statementId = null;

  @JsonProperty("bookingDate")
  private LocalDate bookingDate = null;

  @JsonProperty("narrative")
  private String narrative = null;

  @JsonProperty("statementAmount")
  private BigDecimal statementAmount = null;

  @JsonProperty("currencyId")
  private String currencyId = null;

  @JsonProperty("accountId")
  private String accountId = null;

  @JsonProperty("accountName")
  private String accountName = null;

  @JsonProperty("companyId")
  private String companyId = null;

  @JsonProperty("notes")
  private String notes = null;

  @JsonProperty("transactionId")
  private String transactionId = null;

  public StatementForTransactionResponseBodyInner images(List<StatementForTransactionResponseBodyInnerImages> images) {
    this.images = images;
    return this;
  }

  public StatementForTransactionResponseBodyInner addImagesItem(StatementForTransactionResponseBodyInnerImages imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * 
   * @return images
  **/
  @ApiModelProperty(value = "")
  public List<StatementForTransactionResponseBodyInnerImages> getImages() {
    return images;
  }

  public void setImages(List<StatementForTransactionResponseBodyInnerImages> images) {
    this.images = images;
  }

  public StatementForTransactionResponseBodyInner statementId(String statementId) {
    this.statementId = statementId;
    return this;
  }

   /**
   * 
   * @return statementId
  **/
  @ApiModelProperty(value = "")
  public String getStatementId() {
    return statementId;
  }

  public void setStatementId(String statementId) {
    this.statementId = statementId;
  }

  public StatementForTransactionResponseBodyInner bookingDate(LocalDate bookingDate) {
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

  public StatementForTransactionResponseBodyInner narrative(String narrative) {
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

  public StatementForTransactionResponseBodyInner statementAmount(BigDecimal statementAmount) {
    this.statementAmount = statementAmount;
    return this;
  }

   /**
   * 
   * @return statementAmount
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getStatementAmount() {
    return statementAmount;
  }

  public void setStatementAmount(BigDecimal statementAmount) {
    this.statementAmount = statementAmount;
  }

  public StatementForTransactionResponseBodyInner currencyId(String currencyId) {
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

  public StatementForTransactionResponseBodyInner accountId(String accountId) {
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

  public StatementForTransactionResponseBodyInner accountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

   /**
   * The name of the account that is displayed
   * @return accountName
  **/
  @ApiModelProperty(value = "The name of the account that is displayed")
  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public StatementForTransactionResponseBodyInner companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

   /**
   * The identifier of the company, following the format CCGGGLLLL, where: CC is the country code, GGG is Company Group Code and LLLL is the Local Code. Country Code must be a valid countryCode, Company Group Code must be 3 numeric characters in the range 001-999 and must be a valid companyGroup. The Local Code is 4 numeric characters in the range 0001-9999, e.g. GB0010001
   * @return companyId
  **/
  @ApiModelProperty(value = "The identifier of the company, following the format CCGGGLLLL, where: CC is the country code, GGG is Company Group Code and LLLL is the Local Code. Country Code must be a valid countryCode, Company Group Code must be 3 numeric characters in the range 001-999 and must be a valid companyGroup. The Local Code is 4 numeric characters in the range 0001-9999, e.g. GB0010001")
  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public StatementForTransactionResponseBodyInner notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * 
   * @return notes
  **/
  @ApiModelProperty(value = "")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public StatementForTransactionResponseBodyInner transactionId(String transactionId) {
    this.transactionId = transactionId;
    return this;
  }

   /**
   * The unique transaction identifier
   * @return transactionId
  **/
  @ApiModelProperty(value = "The unique transaction identifier")
  public String getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatementForTransactionResponseBodyInner statementForTransactionResponseBodyInner = (StatementForTransactionResponseBodyInner) o;
    return Objects.equals(this.images, statementForTransactionResponseBodyInner.images) &&
        Objects.equals(this.statementId, statementForTransactionResponseBodyInner.statementId) &&
        Objects.equals(this.bookingDate, statementForTransactionResponseBodyInner.bookingDate) &&
        Objects.equals(this.narrative, statementForTransactionResponseBodyInner.narrative) &&
        Objects.equals(this.statementAmount, statementForTransactionResponseBodyInner.statementAmount) &&
        Objects.equals(this.currencyId, statementForTransactionResponseBodyInner.currencyId) &&
        Objects.equals(this.accountId, statementForTransactionResponseBodyInner.accountId) &&
        Objects.equals(this.accountName, statementForTransactionResponseBodyInner.accountName) &&
        Objects.equals(this.companyId, statementForTransactionResponseBodyInner.companyId) &&
        Objects.equals(this.notes, statementForTransactionResponseBodyInner.notes) &&
        Objects.equals(this.transactionId, statementForTransactionResponseBodyInner.transactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(images, statementId, bookingDate, narrative, statementAmount, currencyId, accountId, accountName, companyId, notes, transactionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatementForTransactionResponseBodyInner {\n");
    
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    statementId: ").append(toIndentedString(statementId)).append("\n");
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    narrative: ").append(toIndentedString(narrative)).append("\n");
    sb.append("    statementAmount: ").append(toIndentedString(statementAmount)).append("\n");
    sb.append("    currencyId: ").append(toIndentedString(currencyId)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    accountName: ").append(toIndentedString(accountName)).append("\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    transactionId: ").append(toIndentedString(transactionId)).append("\n");
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
