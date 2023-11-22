package com.bank.ussd.adapters.xml;

public class Param {
  private Value value;

  public String toString() {
    return "Param(value=" + getValue() + ")";
  }
   public void setValue(Value value) {
     this.value = value;
   }

   public Value getValue() {
     return this.value;
   }
 }
