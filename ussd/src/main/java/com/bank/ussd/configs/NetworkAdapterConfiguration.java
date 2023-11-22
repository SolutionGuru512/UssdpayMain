package com.bank.ussd.configs;

import com.bank.ussd.adapters.INetworkAdapter;
import com.bank.ussd.adapters.xml.XMLNetworkAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NetworkAdapterConfiguration {
  @Bean
  public INetworkAdapter networkAdapter() {
    return (INetworkAdapter)new XMLNetworkAdapter();
  }
}

