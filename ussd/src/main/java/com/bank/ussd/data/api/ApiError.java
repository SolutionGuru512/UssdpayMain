/*   */ package com.bank.ussd.data.api;
/*   */ 
/*   */ public class ApiError {
/*   */   public boolean equals(Object o) {
/* 5 */     if (o == this)
/* 5 */       return true; 
/* 5 */     if (!(o instanceof ApiError))
/* 5 */       return false; 
/* 5 */     ApiError other = (ApiError)o;
/* 5 */     return !!other.canEqual(this);
/*   */   }
/*   */   
/*   */   protected boolean canEqual(Object other) {
/* 5 */     return other instanceof ApiError;
/*   */   }
/*   */   
/*   */   public int hashCode() {
/* 5 */     int result = 1;
/* 5 */     return 1;
/*   */   }
/*   */   
/*   */   public String toString() {
/* 5 */     return "ApiError()";
/*   */   }
/*   */ }

