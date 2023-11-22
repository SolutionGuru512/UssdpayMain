package com.bank.ussd.adapters;

public interface INetworkAdapter {
  INetworkAdapter copy();
  
  void setInput(String paramString);
  
  String getSessionId();
  
  String getServiceCode();
  
  String getPhoneNumber();
  
  String getText();
  
  String formatOutput(String paramString);
  
  String formatErrorOutput(String paramString);
}

