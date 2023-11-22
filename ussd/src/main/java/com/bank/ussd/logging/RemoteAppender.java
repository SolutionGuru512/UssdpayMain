package com.bank.ussd.logging;

import com.bank.ussd.services.api.AuthenticatorApiService;
import java.util.Optional;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Plugin(name = "RemoteAppender", category = "Core", elementType = "appender")
 @Component
 public class RemoteAppender extends AbstractAppender implements ApplicationContextAware {
   private static AuthenticatorApiService apiService;

   public static final String LOG_REMOTE = "LogRemote {} {} {} {}";

   public static final String LOG_REMOTE_BASE = "LogRemote";

   private RemoteAppender() {
     super("RemoteAppender", null, null);
   }

   @PluginFactory
   public static RemoteAppender createAppender(@PluginAttribute("name") String name, @PluginElement("Filter") Filter filter) {
     System.out.println("Remote Appender Added");
     RemoteAppender appender = new RemoteAppender();
     appender.addFilter(filter);
     return appender;
   }

   public void append(LogEvent logEvent) {
     if (logEvent.getMessage().getFormattedMessage().indexOf("LogRemote") != 0)
       return;
     Object[] msg = logEvent.getMessage().getParameters();
     if (msg != null && msg.length >= 4)
       apiService.log(msg[0]
           .toString(),
           Optional.ofNullable(msg[1]).orElse("").toString(),
           Optional.ofNullable(msg[2]).orElse("").toString(),
           Optional.ofNullable(msg[3]).orElse("").toString(),
           Boolean.valueOf(logEvent.getLevel().equals(Level.ERROR)));
   }

   public void setApplicationContext(ApplicationContext applicationContext) {
     if (applicationContext.getAutowireCapableBeanFactory().getBean("authenticatorApiService") != null)
       apiService = (AuthenticatorApiService)applicationContext.getAutowireCapableBeanFactory().getBean("authenticatorApiService");
   }
 }