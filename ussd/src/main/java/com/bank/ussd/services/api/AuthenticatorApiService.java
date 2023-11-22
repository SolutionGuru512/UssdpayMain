/*     */ package com.bank.ussd.services.api;

import com.bank.ussd.data.api.Activity;
import com.bank.ussd.data.api.Customer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthenticatorApiService {
  @Autowired
  private ObjectMapper mapper;

  private WebClient defaultWebClient;

//  @Value("${authenticator.api.host}")
  @Value("${ussd.api.host8}")
  private String host;

  private WebClient defaultWebClient() {
    if (this.defaultWebClient == null)
      this.defaultWebClient = WebClient.builder().baseUrl(this.host).build();
    return this.defaultWebClient;
  }

  public Customer lookupCustomer(String phone) {
    return (Customer)defaultWebClient().get().uri("/customers/lookup/" + phone, new Object[0]).retrieve()
      .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
      .map(node -> {
          if (node.findValue("success").asBoolean() == true)
            return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
          Customer def = new Customer();
          def.setStatus(Customer.CustomerStatus.STATUS_NOT_FOUND.getStatus());
          def.setIsError(Boolean.valueOf(true));
          return def;
        }).block();
  }
    public Customer getLanguage(String phone) {
        return (Customer)defaultWebClient().get().uri("/customers/lookup/" + phone, new Object[0]).retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
                .map(node -> {
                    if (node.findValue("success").asBoolean() == true)
                        return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
                    Customer def = new Customer();
                    def.setLanguage("");
                    //def.setIsError(Boolean.valueOf(true));
                    return def;
                }).block();
    }
    public Customer updateLanguage(String phone,String language) {
        return (Customer)defaultWebClient().get().uri("/customers/updateLanguage/" + phone+"/"+language, new Object[0]).retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
                .map(node -> {
                    if (node.findValue("success").asBoolean() == true)
                        return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
                    Customer def = new Customer();
                    def.setLanguage("");
                    //def.setIsError(Boolean.valueOf(true));
                    return def;
                }).block();
    }
  public Customer activateCustomer(String phone, String activationCode, String pin, boolean validateOnly) {
    Customer body = new Customer();
    body.setPhone(phone);
    body.setActivationCode(activationCode);
    body.setPin(pin);
    return (Customer)((WebClient.RequestBodySpec)defaultWebClient().put().uri("/customers/activate?validateOnly=" + validateOnly, new Object[0])).bodyValue(body)
      .retrieve().onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
      .map(node -> {
          if (node.findValue("success").asBoolean() == true)
            return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
          String errorMessage = node.findValue("response").findPath("errors").get(0).asText();
          Customer def = new Customer();
          def.setStatus(Customer.CustomerStatus.STATUS_NOT_FOUND.getStatus());
          def.setIsError(Boolean.valueOf(true));
          def.setErrorMessage(errorMessage);
          return def;
        }).block();
  }

  public Customer authenticateCustomer(String phone, String pin) {
    Customer body = new Customer();
    body.setPhone(phone);
    body.setPin(pin);
//    body.setStatus("RESET");
    return (Customer)((WebClient.RequestBodySpec)defaultWebClient().post().uri("/customers/authenticate", new Object[0])).bodyValue(body).retrieve()
      .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
      .map(node -> {
          if (node.findValue("success").asBoolean() == true)
            return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
          Customer def = new Customer();
          def.setStatus(Customer.CustomerStatus.STATUS_NOT_FOUND.getStatus());
          def.setIsError(Boolean.valueOf(true));
          return def;
        }).block();
  }
    public Customer authenticateCustomer2(String phone, String pin) {
        Customer body = new Customer();
        body.setPhone(phone);
        body.setPin(pin);
         body.setStatus("RESET");
        return (Customer)((WebClient.RequestBodySpec)defaultWebClient().post().uri("/customers/authenticate", new Object[0])).bodyValue(body).retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty()).bodyToMono(JsonNode.class)
                .map(node -> {
                    if (node.findValue("success").asBoolean() == true)
                        return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
                    Customer def = new Customer();
                    def.setStatus(Customer.CustomerStatus.STATUS_NOT_FOUND.getStatus());
                    def.setIsError(Boolean.valueOf(true));
                    return def;
                }).block();
    }
  public Customer changePin(String phone, String oldPin, String pin) {
    Customer body = new Customer();
    body.setPhone(phone);
    body.setPin(pin);
    body.setOldPin(oldPin);
    return (Customer)((WebClient.RequestBodySpec)defaultWebClient().put().uri("/customers/changepin", new Object[0])).bodyValue(body).retrieve()
      .onStatus(HttpStatus::is4xxClientError, response -> Mono.empty())
      .bodyToMono(JsonNode.class)
      .map(node -> {
          if (node.findValue("success").asBoolean() == true)
            return (Customer)this.mapper.convertValue(node.findValue("response"), Customer.class);
          String errorMessage = node.findValue("response").findPath("errors").get(0).asText();
          Customer def = new Customer();
          def.setStatus(Customer.CustomerStatus.STATUS_NOT_FOUND.getStatus());
          def.setIsError(Boolean.valueOf(true));
          def.setErrorMessage(errorMessage);
          return def;
        }).block();
  }

  public void log(String action, String user, String target, String details) {
    log(action, user, target, details, Boolean.valueOf(false));
  }

  public void log(String action, String user, String target, String details, Boolean error) {
    Activity activity = new Activity(action, user, target, details, error);
    ((WebClient.RequestBodySpec)defaultWebClient()
      .post()
      .uri("/activity", new Object[0]))
      .bodyValue(activity).retrieve().onStatus(HttpStatus::is2xxSuccessful, response -> {
          System.out.println("Done");
          return Mono.empty();
        }).bodyToMono(JsonNode.class).subscribe();
  }
}
