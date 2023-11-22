 package com.bank.ussd.configs;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.bank.ussd.utils.CustomDateDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;


 @Configuration
 public class ApiConfiguration {
   @Value("${ussd.api.host}")
   private String host;

   @Value("${ussd.api.host2}")
   private String host2;

   @Value("${ussd.api.host3}")
   private String host3;

   @Value("${ussd.api.host4}")
   private String host4;

   @Value("${ussd.api.host5}")
   private String host5;
     @Value("${ussd.api.host6}")
     private String host6;

     @Value("${ussd.api.host7}")
     private String host7;



   @Value("${ussd.api.username}")
   private String username;

   @Value("${ussd.api.password}")
   private String password;

   private static final String dateFormat = "yyyy-MM-dd";

   private static final String dateFormat2 = "yyyyMMdd";

   private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

   @Bean
   @ConditionalOnProperty(value = {"spring.jackson.date-format"}, matchIfMissing = true, havingValue = "none")
   public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
     return new Jackson2ObjectMapperBuilderCustomizer() {
         public void customize(Jackson2ObjectMapperBuilder builder) {
           builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
           builder.serializers(new JsonSerializer[] { (JsonSerializer)new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")) });
           builder.serializers(new JsonSerializer[] { (JsonSerializer)new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) });
           builder.deserializers(new JsonDeserializer[] { (JsonDeserializer)new CustomDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")) });
         }
       };
   }
     @Bean
     @Primary
     @Autowired
     public com.bank.ussd.apiclient.transactions.api.DefaultApi transactionsDefaultApi(RestTemplate template) {
         com.bank.ussd.apiclient.transactions.handler.ApiClient apiClient = new com.bank.ussd.apiclient.transactions.handler.ApiClient(template);
         apiClient.setBasePath(this.host7);
         com.bank.ussd.apiclient.transactions.api.DefaultApi api = new com.bank.ussd.apiclient.transactions.api.DefaultApi(apiClient);
         return api;
     }
     @Bean
     @Primary
     @Autowired
     public com.bank.ussd.apiclient.payments2.api.DefaultApi paymentsApi2(RestTemplate template) {
         com.bank.ussd.apiclient.payments2.handler.ApiClient apiClient = new com.bank.ussd.apiclient.payments2.handler.ApiClient(template);
         apiClient.setBasePath(this.host7);
         com.bank.ussd.apiclient.payments2.api.DefaultApi api = new com.bank.ussd.apiclient.payments2.api.DefaultApi(apiClient);
         return api;
     }
     @Bean
     @Primary
     @Autowired
     public com.bank.ussd.apiclient.accountDetail.api.DefaultApi accountDetailDefaultApi(RestTemplate template) {
         com.bank.ussd.apiclient.accountDetail.handler.ApiClient apiClient = new com.bank.ussd.apiclient.accountDetail.handler.ApiClient(template);
         apiClient.setBasePath(this.host7);
         com.bank.ussd.apiclient.accountDetail.api.DefaultApi api = new com.bank.ussd.apiclient.accountDetail.api.DefaultApi(apiClient);
         return api;
     }

     @Bean
     @Primary
     @Autowired
     public com.bank.ussd.apiclient.accountList.api.DefaultApi accountListDefaultApi(RestTemplate template) {
         com.bank.ussd.apiclient.accountList.handler.ApiClient apiClient = new com.bank.ussd.apiclient.accountList.handler.ApiClient(template);
         apiClient.setBasePath(this.host7);
         com.bank.ussd.apiclient.accountList.api.DefaultApi api = new com.bank.ussd.apiclient.accountList.api.DefaultApi(apiClient);
         return api;
     }
 }
