/*    */ package com.bank.ussd.data.api;
/*    */ 
/*    */ public class Activity {
/*    */   private String action;
/*    */   
/*    */   private String user;
/*    */   
/*    */   private String target;
/*    */   
/*    */   private String details;
/*    */   
/*    */   private Boolean error;
/*    */   
/*    */   public void setAction(String action) {
/*  5 */     this.action = action;
/*    */   }
/*    */   
/*    */   public void setUser(String user) {
/*  5 */     this.user = user;
/*    */   }
/*    */   
/*    */   public void setTarget(String target) {
/*  5 */     this.target = target;
/*    */   }
/*    */   
/*    */   public void setDetails(String details) {
/*  5 */     this.details = details;
/*    */   }
/*    */   
/*    */   public void setError(Boolean error) {
/*  5 */     this.error = error;
/*    */   }

/*    */   
/*    */   public String getAction() {
/*  8 */     return this.action;
/*    */   }
/*    */   
/*    */   public String getUser() {
/* 10 */     return this.user;
/*    */   }
/*    */   
/*    */   public String getTarget() {
/* 12 */     return this.target;
/*    */   }
/*    */   
/*    */   public String getDetails() {
/* 14 */     return this.details;
/*    */   }
/*    */   
/*    */   public Boolean getError() {
/* 16 */     return this.error;
/*    */   }
/*    */   
/*    */   public Activity(String action, String user, String target, String details, Boolean error) {
/* 19 */     this.action = action;
/* 20 */     this.user = user;
/* 21 */     this.target = target;
/* 22 */     this.details = details;
/* 23 */     this.error = error;
/*    */   }
/*    */   
/*    */   public Activity(String action, String user, String target, String details) {
/* 27 */     this(action, user, target, details, Boolean.valueOf(false));
/*    */   }
/*    */ }
