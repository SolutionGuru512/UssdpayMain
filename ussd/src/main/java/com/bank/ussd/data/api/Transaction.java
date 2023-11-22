 package com.bank.ussd.data.api;

 import com.fasterxml.jackson.annotation.JsonProperty;
 import com.bank.ussd.apiclient.transactions.model.AccountTransactionsResponseBodyInner;
 import java.math.BigDecimal;
 import java.time.LocalDate;
 import org.springframework.data.annotation.Id;

 public class Transaction {
   @Id
   private String id;

   private String description;

   private BigDecimal amount;

   @JsonProperty("transactionDate")
   private LocalDate transactionDate;

   private Account source;

   private Account destination;

   private String narrative;

   private String currencyId;

   public void setId(String id) {
     this.id = id;
   }

   public void setDescription(String description) {
     this.description = description;
   }

   public void setAmount(BigDecimal amount) {
     this.amount = amount;
   }

   @JsonProperty("transactionDate")
   public void setTransactionDate(LocalDate transactionDate) {
     this.transactionDate = transactionDate;
   }

   public void setSource(Account source) {
     this.source = source;
   }

   public void setDestination(Account destination) {
     this.destination = destination;
   }

   public void setNarrative(String narrative) {
     this.narrative = narrative;
   }

   public void setCurrencyId(String currencyId) {
     this.currencyId = currencyId;
   }
   public String getId() {
     return this.id;
   }

   public String getDescription() {
     return this.description;
   }

   public BigDecimal getAmount() {
     return this.amount;
   }

   public LocalDate getTransactionDate() {
     return this.transactionDate;
   }

   public Account getSource() {
     return this.source;
   }

   public Account getDestination() {
     return this.destination;
   }

   public String getNarrative() {
     return this.narrative;
   }

   public String getCurrencyId() {
     return this.currencyId;
   }

   public String getDestinationDescriptor() {
     return (this.destination != null) ? this.destination.getShortDescriptor() : "";
   }

   public String getSourceDescriptor() {
     return (this.source != null) ? (this.source.getAccountHolder() + " - " + this.source.getShortNumber(4)) : "";
   }

   public Transaction(AccountTransactionsResponseBodyInner transaction) {
     this.amount = transaction.getStatementAmount();
     this.narrative = transaction.getNarrative();
     this.transactionDate = transaction.getBookingDate();
     this.id = transaction.getTransactionReference();
     this.currencyId = transaction.getCurrencyId();
   }
 }

