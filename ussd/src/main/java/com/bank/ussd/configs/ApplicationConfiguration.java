/*    */ package com.bank.ussd.configs;

 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.context.annotation.Configuration;

 @Configuration
 @ConfigurationProperties(prefix = "ussd")
 public class ApplicationConfiguration {
   private CacheConfigurationProperties cache;

   public String toString() {
     return "ApplicationConfiguration(cache=" + getCache() + ")";
   }



   public void setCache(CacheConfigurationProperties cache) {
     this.cache = cache;
   }

   public CacheConfigurationProperties getCache() {
     return this.cache;
   }

   private class CacheConfigurationProperties {
     private Integer port;

     private String host;

     private String password;

     private String defaultTtl;

     public Integer getPort() {
       return this.port;
     }

     public String getHost() {
       return this.host;
     }

     public String getPassword() {
       return this.password;
     }

     public String getDefaultTtl() {
       return this.defaultTtl;
     }
   }
 }
