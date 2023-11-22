package com.bank.ussd.data.api;

 import com.bank.ussd.apiclient.otherpayments.model.CreateFundsTransferOtherAcTrf;
 import com.bank.ussd.apiclient.otherpayments.model.CreateFundsTransferOtherAcTrfBody;
 import com.bank.ussd.apiclient.otherpayments.model.CreateFundsTransferOtherAcTrfBodyPaymentDetails;

 import com.bank.ussd.apiclient.payments2.model.CreateFundsTransferNewTrfBodyPaymentDetails;
 import com.bank.ussd.apiclient.payments2.model.FundsTransferNewTrfResponseBody;
 import com.bank.ussd.apiclient.payments2.model.CreateFundsTransferNewTrf;
 import com.bank.ussd.apiclient.payments2.model.CreateFundsTransferNewTrfBody;

 import java.math.BigDecimal;
 import java.time.LocalDate;
 import java.util.ArrayList;
 import java.util.List;

 import org.springframework.data.annotation.Id;

 public class Transfer {
   @Id
   private String id;

   private String sourceAccountId;

   private String destinationAccountId;

   private String currencyId;

   private BigDecimal amount;

   private String reason;

   private LocalDate transferDate;

   public void setId(String id) {
     this.id = id;
   }

   public void setSourceAccountId(String sourceAccountId) {
     this.sourceAccountId = sourceAccountId;
   }

   public void setDestinationAccountId(String destinationAccountId) {
     this.destinationAccountId = destinationAccountId;
   }

   public void setCurrencyId(String currencyId) {
     this.currencyId = currencyId;
   }

   public void setAmount(BigDecimal amount) {
     this.amount = amount;
   }

   public void setReason(String reason) {
     this.reason = reason;
   }

   public void setTransferDate(LocalDate transferDate) {
     this.transferDate = transferDate;
   }

   public String getId() {
     return this.id;
   }

   public String getSourceAccountId() {
     return this.sourceAccountId;
   }

   public String getDestinationAccountId() {
     return this.destinationAccountId;
   }

   public String getCurrencyId() {
     return this.currencyId;
   }

   public BigDecimal getAmount() {
     return this.amount;
   }

   public String getReason() {
     return this.reason;
   }

   public LocalDate getTransferDate() {
     return this.transferDate;
   }

   public Transfer() {}



   public Transfer(String id, FundsTransferNewTrfResponseBody paymentOrder) {
     setId(id);
     setAmount(paymentOrder.getCreditAmount());
     setCurrencyId(paymentOrder.getCreditCurrency());
     setSourceAccountId(paymentOrder.getDebitAccountId());
     setDestinationAccountId(paymentOrder.getCreditAccountId());
     setTransferDate(paymentOrder.getProcessingDate());
     if (paymentOrder.getPaymentDetails() != null && paymentOrder.getPaymentDetails().size() > 0)
       setReason(paymentOrder.getPaymentDetails().get(0).getPaymentDetail());
   }



   public CreateFundsTransferNewTrf toPaymentOrderNew() {
     return (new CreateFundsTransferNewTrf()).body((new CreateFundsTransferNewTrfBody())

         .debitAccountId(this.sourceAccountId)
         .creditAccountId(this.destinationAccountId)
         .transactionType("ACIB")
         .creditAmount(this.amount)
             .addPaymentDetailsItem((new CreateFundsTransferNewTrfBodyPaymentDetails()).paymentDetail(this.reason))
         .creditCurrency(this.currencyId));
   }

   public CreateFundsTransferOtherAcTrf toPaymentOrderToOther() {
     return (new CreateFundsTransferOtherAcTrf()).body((new CreateFundsTransferOtherAcTrfBody())

         .debitAccountId(this.sourceAccountId)
         .creditAccountId(this.destinationAccountId)
         .transactionType("ACIB")
         .creditAmount(this.amount)
         .addPaymentDetailsItem((new CreateFundsTransferOtherAcTrfBodyPaymentDetails()).paymentDetail("ussd"))
         .creditCurrency(this.currencyId).processingDate(LocalDate.now()));
   }
 }
