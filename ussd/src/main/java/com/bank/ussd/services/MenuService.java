package com.bank.ussd.services;

import com.bank.ussd.data.Menu;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
  @Autowired
  ResourceLoader resourceLoader;

  @Value("${ussd.api.host}")
  private String host;

  private String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    try {
      String line;
      while ((line = br.readLine()) != null)
        resultStringBuilder.append(line).append("\n");
      br.close();
    } catch (Throwable throwable) {
      try {
        br.close();
      } catch (Throwable throwable1) {
        throwable.addSuppressed(throwable1);
      }
      throw throwable;
    }
    return resultStringBuilder.toString();
  }

  public Map<String, Menu> loadMenus() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Resource resource = this.resourceLoader.getResource("classpath:menu.json");
    InputStream input = resource.getInputStream();
    String json = readFromInputStream(input);
    return (Map<String, Menu>)objectMapper.readValue(json, new TypeReference<Map<String, Menu>>() {

        });
  }
}
