 package com.bank.ussd;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.builder.SpringApplicationBuilder;
 import org.springframework.boot.web.client.RestTemplateBuilder;
 import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 import org.springframework.context.annotation.Bean;
 import org.springframework.web.client.RestTemplate;

 @SpringBootApplication
// @SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
 public class UssdApplication extends SpringBootServletInitializer {
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
     return application.sources(UssdApplication.class);
   }

   public static void main(String[] args) {
     SpringApplication.run(UssdApplication.class, args);
   }

   @Bean
   public RestTemplate restTemplate(RestTemplateBuilder builder) {
     return builder.build();
   }
 }