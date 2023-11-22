/*    */ package com.bank.ussd.configs;

 import org.springframework.beans.factory.annotation.Value;
 import org.springframework.cache.annotation.CachingConfigurerSupport;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
 import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
 import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

 @Configuration
 @EnableRedisRepositories
 public class RedisConfiguration extends CachingConfigurerSupport {
   @Value("${ussd.cache.host}")
   private String host;

   @Value("${ussd.cache.port}")
   private int port;

   @Value("${ussd.cache.password}")
   private String password;

   @Value("${ussd.cache.default-ttl}")
   private String defaultTTL;

   @Value("${ussd.api.host}")
   private String apiHost;

   @Bean
   public LettuceConnectionFactory redisConnectionFactory() {
     RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
     redisStandaloneConfiguration.setHostName(this.host);
     redisStandaloneConfiguration.setPort(this.port);
     redisStandaloneConfiguration.setPassword(this.password);
     return new LettuceConnectionFactory(redisStandaloneConfiguration);
   }
 }

