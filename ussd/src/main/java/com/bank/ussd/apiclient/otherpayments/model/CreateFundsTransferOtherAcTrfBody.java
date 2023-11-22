/*
 * TC CHANNELS OTHER AC FT PUBLISHED API
 * TC CHANNELS OTHER AC FT PUBLISHED API
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.otherpayments.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * CreateFundsTransferOtherAcTrfBody
 */

public class CreateFundsTransferOtherAcTrfBody {
  @JsonProperty("paymentDetails")
  private List<CreateFundsTransferOtherAcTrfBodyPaymentDetails> paymentDetails = null;

  @JsonProperty("debitAccountId")
  private String debitAccountId = null;

  @JsonProperty("creditCurrency")
  private String creditCurrency = null;

  @JsonProperty("creditAccountId")
  private String creditAccountId = null;

  @JsonProperty("creditAmount")
  private BigDecimal creditAmount = null;

  @JsonProperty("processingDate")
  private LocalDate processingDate = null;

  @JsonProperty("transactionType")
  private String transactionType = null;

  public CreateFundsTransferOtherAcTrfBody paymentDetails(List<CreateFundsTransferOtherAcTrfBodyPaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  public CreateFundsTransferOtherAcTrfBody addPaymentDetailsItem(CreateFundsTransferOtherAcTrfBodyPaymentDetails paymentDetailsItem) {
    if (this.paymentDetails == null) {
      this.paymentDetails = new ArrayList<>();
    }
    this.paymentDetails.add(paymentDetailsItem);
    return this;
  }

   /**
   * Indicates the payment details for the beneficiary to apply the payment.
   * @return paymentDetails
  **/
  @ApiModelProperty(value = "Indicates the payment details for the beneficiary to apply the payment.")
  public List<CreateFundsTransferOtherAcTrfBodyPaymentDetails> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(List<CreateFundsTransferOtherAcTrfBodyPaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public CreateFundsTransferOtherAcTrfBody debitAccountId(String debitAccountId) {
    this.debitAccountId = debitAccountId;
    return this;
  }

   /**
   * Indicates the debit account number of the payment or transaction.
   * @return debitAccountId
  **/
  @ApiModelProperty(required = true, value = "Indicates the debit account number of the payment or transaction.")
  public String getDebitAccountId() {
    return debitAccountId;
  }

  public void setDebitAccountId(String debitAccountId) {
    this.debitAccountId = debitAccountId;
  }

  public CreateFundsTransferOtherAcTrfBody creditCurrency(String creditCurrency) {
    this.creditCurrency = creditCurrency;
    return this;
  }

   /**
   * Currency of the account which funds will be transferred to.
   * @return creditCurrency
  **/
  @ApiModelProperty(value = "Currency of the account which funds will be transferred to.")
  public String getCreditCurrency() {
    return creditCurrency;
  }

  public void setCreditCurrency(String creditCurrency) {
    this.creditCurrency = creditCurrency;
  }

  public CreateFundsTransferOtherAcTrfBody creditAccountId(String creditAccountId) {
    this.creditAccountId = creditAccountId;
    return this;
  }

   /**
   * Credit account identifier of the payment or transaction
   * @return creditAccountId
  **/
  @ApiModelProperty(required = true, value = "Credit account identifier of the payment or transaction")
  public String getCreditAccountId() {
    return creditAccountId;
  }

  public void setCreditAccountId(String creditAccountId) {
    this.creditAccountId = creditAccountId;
  }

  public CreateFundsTransferOtherAcTrfBody creditAmount(BigDecimal creditAmount) {
    this.creditAmount = creditAmount;
    return this;
  }

   /**
   * Amount to be credited in a payment transaction
   * minimum: 1
   * maximum: 29
   * @return creditAmount
  **/
  @ApiModelProperty(required = true, value = "Amount to be credited in a payment transaction")
  public BigDecimal getCreditAmount() {
    return creditAmount;
  }

  public void setCreditAmount(BigDecimal creditAmount) {
    this.creditAmount = creditAmount;
  }

  public CreateFundsTransferOtherAcTrfBody processingDate(LocalDate processingDate) {
    this.processingDate = processingDate;
    return this;
  }

   /**
   * The date when payment instruction is processed in system.
   * @return processingDate
  **/
  @ApiModelProperty(value = "The date when payment instruction is processed in system.")
  public LocalDate getProcessingDate() {
    return processingDate;
  }

  public void setProcessingDate(LocalDate processingDate) {
    this.processingDate = processingDate;
  }

  public CreateFundsTransferOtherAcTrfBody transactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

   /**
   * Identifies the transaction type applicable to the transaction being processed, i.e. outward or inward payment. For example: ACPX, OTPX etc.
   * @return transactionType
  **/
  @ApiModelProperty(value = "Identifies the transaction type applicable to the transaction being processed, i.e. outward or inward payment. For example: ACPX, OTPX etc.")
  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateFundsTransferOtherAcTrfBody createFundsTransferOtherAcTrfBody = (CreateFundsTransferOtherAcTrfBody) o;
    return Objects.equals(this.paymentDetails, createFundsTransferOtherAcTrfBody.paymentDetails) &&
        Objects.equals(this.debitAccountId, createFundsTransferOtherAcTrfBody.debitAccountId) &&
        Objects.equals(this.creditCurrency, createFundsTransferOtherAcTrfBody.creditCurrency) &&
        Objects.equals(this.creditAccountId, createFundsTransferOtherAcTrfBody.creditAccountId) &&
        Objects.equals(this.creditAmount, createFundsTransferOtherAcTrfBody.creditAmount) &&
        Objects.equals(this.processingDate, createFundsTransferOtherAcTrfBody.processingDate) &&
        Objects.equals(this.transactionType, createFundsTransferOtherAcTrfBody.transactionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentDetails, debitAccountId, creditCurrency, creditAccountId, creditAmount, processingDate, transactionType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateFundsTransferOtherAcTrfBody {\n");
    
    sb.append("    paymentDetails: ").append(toIndentedString(paymentDetails)).append("\n");
    sb.append("    debitAccountId: ").append(toIndentedString(debitAccountId)).append("\n");
    sb.append("    creditCurrency: ").append(toIndentedString(creditCurrency)).append("\n");
    sb.append("    creditAccountId: ").append(toIndentedString(creditAccountId)).append("\n");
    sb.append("    creditAmount: ").append(toIndentedString(creditAmount)).append("\n");
    sb.append("    processingDate: ").append(toIndentedString(processingDate)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
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

