 package com.bank.ussd.services;

 import com.bank.ussd.data.CustomerLanguage;
 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.MenuOption;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.data.api.Customer;
 import com.bank.ussd.enums.MenuOptionAction;
 import com.bank.ussd.enums.MenuType;
 import com.bank.ussd.handlers.IMenuHandler;
 import com.bank.ussd.services.api.AuthenticatorApiService;
 import com.bank.ussd.utils.StringUtils;
 import java.io.IOException;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 import org.apache.commons.text.StringSubstitutor;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 @Service
 public class UssdRoutingService {
   @Autowired
   private MenuService menuService;

   @Autowired
   private SessionService sessionService;

   @Autowired
   private HandlerService handlerService;

   @Autowired
   private AuthenticatorApiService apiService;

//Welcome to Gadaa Bank
//Mobile Banking USSD Platform
   public String menulevelrouter(String sessionId, String serviceCode, String phoneNumber, String text) throws IOException, IllegalArgumentException {
     if (sessionId == null || serviceCode == null || phoneNumber == null)
       throw new IllegalArgumentException("Required parameter is null", null);
     if (text == null)
       text = "";
     Map<String, Menu> menus = this.menuService.loadMenus();
     String[] inputs = text.split("\\*");
     if (text.equals("*"))
       inputs = new String[] { "*" };
     String output = "";
     for (String input : inputs) {
       UssdSession session = checkAndSetSession(sessionId, serviceCode, phoneNumber, input);
       if (session.getText().length() > 0) {
         output = getNextMenuItem(session, menus);
       } else {
         output = getMenu(session.getCurrentMenuLevel(), session);
       }
     }
     return output;
   }

   public String getNextMenuItem(UssdSession session, Map<String, Menu> menus) throws IOException {
     String[] levels = session.getText().split("\\*");
     String lastValue = (levels.length > 1) ? levels[levels.length - 1] : session.getText();
     Menu menuLevel = menus.get(session.getCurrentMenuLevel());
     if (lastValue.equalsIgnoreCase("0") || lastValue.equalsIgnoreCase("**")) {
         if ( session.getCurrentMenuLevel().compareTo("LANGUAGES_LOGIN")!=0 && menuLevel.getPreviousMenuLevel().compareTo("START")!=0 && menuLevel.getPreviousMenuLevel().compareTo("START_AO")!=0&& menuLevel.getPreviousMenuLevel().compareTo("START_AM")!=0 && menuLevel.getPreviousMenuLevel().compareTo("SET_PIN")!=0 && menuLevel.getPreviousMenuLevel().compareTo("SET_PIN_AM")!=0 && menuLevel.getPreviousMenuLevel().compareTo("SET_PIN_AO")!=0&& menuLevel.getPreviousMenuLevel().compareTo("SET_PIN_CONFORMATION")!=0&& menuLevel.getPreviousMenuLevel().compareTo("SET_PIN_CONFORMATION_AM")!=0&& menuLevel.getPreviousMenuLevel().compareTo("SET_PIN_CONFORMATION_AO")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN_CONFORMATION_AO")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN_CONFORMATION_AM")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN_CONFORMATION")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN_AO")!=0&& menuLevel.getPreviousMenuLevel().compareTo("RESET_PIN_AM")!=0) {
             if (session.getCurrentMenuLevel().endsWith("_AO")) {
                 updateSessionMenuLevel(session, "MAIN_AO");
                 clearSessionMetadata(session);
                 return getMenu("MAIN_AO", session);
             }
             if (session.getCurrentMenuLevel().endsWith("_AM")) {
                 updateSessionMenuLevel(session, "MAIN_AM");
                 clearSessionMetadata(session);
                 return getMenu("MAIN_AM", session);
             }
             updateSessionMenuLevel(session, "MAIN");
             clearSessionMetadata(session);
             return getMenu("MAIN", session);
         }
         return getMenu("LANGUAGES_LOGIN", session);
     }
     if (session.getText().endsWith("*")) {
       String previousMenu = menuLevel.getPreviousMenuLevel();
       if (previousMenu == null)
         previousMenu = session.getPreviousMenuLevel();
       if (previousMenu != null) {
         updateSessionMenuLevel(session, previousMenu);
         return getMenu(previousMenu, session);
       }
         if(session.getCurrentMenuLevel().endsWith("_AO")){
             updateSessionMenuLevel(session, "MAIN_AO");
             return getMenu("MAIN_AO", session);
         }
         if(session.getCurrentMenuLevel().endsWith("_AM")){
             updateSessionMenuLevel(session, "MAIN_AM");
             return getMenu("MAIN_AM", session);
         }
       updateSessionMenuLevel(session, "MAIN");
       return getMenu("MAIN", session);
     }
     if (menuLevel.getType() == MenuType.STATIC) {
       int index = StringUtils.stringToInt(lastValue, 0);
       if (index > 0 && index <= menuLevel.getMenuOptions().size()) {
         MenuOption menuOption = menuLevel.getMenuOptions().get(index - 1);
         return processStaticMenuOption(session, menuOption);
       }
       return getMenu(menuLevel.getMenuLevel(), session);
     }
     if (menuLevel.getType() == MenuType.DYNAMIC)
       return processDynamicMenu(session, menuLevel, lastValue);
     if (menuLevel.getType() == MenuType.INPUT)
       return processInputMenu(session, menuLevel, lastValue);
     if (menuLevel.getType() == MenuType.SELECT)
       return processSelectMenu(session, menuLevel, lastValue);
     return "CON ";
   }

   public String getMenu(String menuLevel, UssdSession session) throws IOException {
     Map<String, Menu> menus = this.menuService.loadMenus();
     Menu menu = menus.get(menuLevel);
     String menuContent = "";
     if (menu.getType() == MenuType.STATIC || menu.getType() == MenuType.INPUT || menu.getType() == MenuType.SELECT) {
       menuContent = menu.getText();
     } else if (menu.getHandler() != null) {
       IMenuHandler handler = this.handlerService.handlerForName(menu.getHandler());
       if (handler != null)
         menuContent = handler.getMenuOutput(session, menu);
     } else {
       menuContent = "END An error has occurred.";
     }
     String content = StringUtils.replaceVariable(session.getMetadata(), menuContent);
     if (menu.getClearSession() != null && menu.getClearSession().booleanValue())
       session.clearMetadata();
     this.sessionService.update(session);
     return content;
   }

   public String processStaticMenuOption(UssdSession session, MenuOption menuOption) throws IOException {
     if (menuOption.getType().equals("response"))
       return processMenuOptionResponses(menuOption);
     if (menuOption.getType().equals("level")) {
       updateSessionMenuLevel(session, menuOption.getNextMenuLevel());
       return getMenu(menuOption.getNextMenuLevel(), session);
     }
     return "CON ";
   }

   public String processMenuOptionResponses(MenuOption menuOption) {
     String response = menuOption.getResponse();
     Map<String, String> variablesMap = new HashMap<>();
     if (menuOption.getAction() == MenuOptionAction.PROCESS_ACC_BALANCE) {
       variablesMap.put("account_balance", "10000");
       response = replaceVariable(variablesMap, response);
     } else if (menuOption.getAction() == MenuOptionAction.PROCESS_ACC_NUMBER) {
       variablesMap.put("account_number", "123412512");
       response = replaceVariable(variablesMap, response);
     } else if (menuOption.getAction() == MenuOptionAction.PROCESS_ACC_PHONE_NUMBER) {
       variablesMap.put("phone_number", "254702759950");
       response = replaceVariable(variablesMap, response);
     }
     return response;
   }

   private String processDynamicMenu(UssdSession session, Menu menuLevel, String lastValue) throws IOException {
     IMenuHandler handler = this.handlerService.handlerForName(menuLevel.getHandler());
     if (handler != null) {
       String nextLevel = handler.handleMenuInput(session, lastValue, menuLevel);
       if (nextLevel == null)
         nextLevel = menuLevel.getNextMenuLevel();
       updateSessionMenuLevel(session, nextLevel);
       return getMenu(nextLevel, session);
     }
     return "CON ";
   }

   private String processInputMenu(UssdSession session, Menu menuLevel, String input) throws IOException {
     Boolean validInput = Boolean.valueOf(true);
     if (menuLevel.getValidation() != null && menuLevel.getValidation().length() > 0) {
       Pattern pattern = Pattern.compile(menuLevel.getValidation());
       Matcher matcher = pattern.matcher(input);
       validInput = Boolean.valueOf(matcher.matches());
     }
     if (validInput.booleanValue()) {
       session.setMetaProperty(menuLevel.getVariable(), input);
       String nextLevel = menuLevel.getNextMenuLevel();
       updateSessionMenuLevel(session, nextLevel);
       return getMenu(nextLevel, session);
     }
     return "CON " + menuLevel.getValidationError();
   }

   private String processSelectMenu(UssdSession session, Menu menuLevel, String input) throws IOException {
     Boolean validInput = Boolean.valueOf(true);
     int in = StringUtils.stringToInt(input, -1);
     if (menuLevel.getValues() != null && in > 0 && menuLevel.getValues().size() >= in)
       validInput = Boolean.valueOf(true);
     if (validInput.booleanValue()) {
       session.setMetaProperty(menuLevel.getVariable(), menuLevel.getValues().get(in - 1));
       session.setMetaProperty(menuLevel.getVariable() + "_label", menuLevel.getLabels().get(in - 1));
       String nextLevel = menuLevel.getNextMenuLevel();
       updateSessionMenuLevel(session, nextLevel);
       return getMenu(nextLevel, session);
     }
     return "CON " + menuLevel.getValidationError();
   }

   public String replaceVariable(Map<String, String> variablesMap, String response) {
     StringSubstitutor sub = new StringSubstitutor(variablesMap);
     return sub.replace(response);
   }

   public UssdSession updateSessionMenuLevel(UssdSession session, String menuLevel) {
     session.setPreviousMenuLevel(session.getCurrentMenuLevel());
     session.setCurrentMenuLevel(menuLevel);
     return this.sessionService.update(session);
   }

   public UssdSession clearSessionMetadata(UssdSession session) {
     session.clearMetadata();
     return this.sessionService.update(session);
   }

   public UssdSession checkAndSetSession(String sessionId, String serviceCode, String phoneNumber, String text) {
     UssdSession session = this.sessionService.get(sessionId);
     if (session != null) {
       session.setText(text);
       return this.sessionService.update(session);
     }
     session = new UssdSession();
       Customer customer = this.apiService.lookupCustomer(phoneNumber);
       if (customer.getLanguage()!=null){
           if (customer.getLanguage().compareTo(CustomerLanguage.AFAANOROMOO.getCustomerLanguage())==0){
               session.setCurrentMenuLevel("START_AO");//
               session.setPreviousMenuLevel("START_AO");//START
           }
           else if (customer.getLanguage().compareTo(CustomerLanguage.AMHARIC.getCustomerLanguage())==0){
               session.setCurrentMenuLevel("START_AM");//
               session.setPreviousMenuLevel("START_AM");//START
           }
           else if (customer.getLanguage().compareTo(CustomerLanguage.ENGLISH.getCustomerLanguage())==0){
               session.setCurrentMenuLevel("START");//
               session.setPreviousMenuLevel("START");//START
           }
           else {
               session.setCurrentMenuLevel("LANGUAGES_LOGIN");//START
               session.setPreviousMenuLevel("LANGUAGES_LOGIN");//START
           }

       }else {
           session.setCurrentMenuLevel("LANGUAGES_LOGIN");//START
           session.setPreviousMenuLevel("LANGUAGES_LOGIN");//START
       }
//       session.setCurrentMenuLevel("LANGUAGES_LOGIN");//START
//       session.setPreviousMenuLevel("LANGUAGES_LOGIN");//START
     session.setId(sessionId);
     session.setPhoneNumber(phoneNumber);
     session.setServiceCode(serviceCode);
     session.setText("");
     return this.sessionService.createUssdSession(session);
   }
 }