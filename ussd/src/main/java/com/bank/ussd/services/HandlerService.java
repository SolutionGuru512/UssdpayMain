package com.bank.ussd.services;

import com.bank.ussd.handlers.IMenuHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class HandlerService {
  private static final Logger log = LogManager.getLogger(HandlerService.class);

  @Autowired
  ApplicationContext context;

  public IMenuHandler handlerForName(String handlerName) {
    try {
      IMenuHandler handler = (IMenuHandler)this.context.getBean(handlerName);
      if (handler != null)
        return handler;
    } catch (Exception e) {
      log.error(e);
    }
    return (IMenuHandler)this.context.getBean("defaultMenuHandler");
  }
}

