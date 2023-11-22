package com.bank.ussd.controllers;

 import com.bank.ussd.adapters.INetworkAdapter;
 import com.bank.ussd.data.Menu;
 import com.bank.ussd.data.UssdSession;
 import com.bank.ussd.services.UssdRoutingService;
 import com.bank.ussd.services.MenuService;

 import java.io.IOException;
 import java.util.Map;
 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PatchMapping;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.PutMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;

 @Controller
 @ResponseBody
 @CrossOrigin({"*"})
 public class IndexController {
   private static final Logger log = LogManager.getLogger(IndexController.class);

   @Autowired
   private MenuService menuService;

   @Autowired
   private UssdRoutingService ussdRoutingService;

   @Autowired
   private INetworkAdapter networkAdapter;

   @GetMapping(path = {"menus"})
   public Map<String, Menu> menusLoad() throws IOException {
     return this.menuService.loadMenus();
   }

   @GetMapping(path = {""})
   public String index() throws IOException {
     log.info("USSD Get");
     return "You have reached us";
   }



   @PutMapping(path = {""})
   public String ussdIngress(@RequestBody String body) throws IOException {
     System.out.println("USSD PUT method called\n" + body);
     log.info("USSD PUT");
     return "Hello from Gadaa Bank";
   }

   @PostMapping(path = {"gadaa"}, produces = {"application/xml"})
   public String ussdIngressPost(@RequestBody String body) throws IOException {
     System.out.println("USSD POST method called\n" + body);
     log.info("USSD POST");
     INetworkAdapter adapter = this.networkAdapter.copy();
     adapter.setInput(body);
     try {
       String output = this.ussdRoutingService.menulevelrouter(adapter.getSessionId(), adapter.getServiceCode(), adapter.getPhoneNumber(), adapter.getText());
       String formattedOutput = adapter.formatOutput(output);
       log.info("Response sent for " + adapter.getPhoneNumber() + "\n" + formattedOutput);
       return formattedOutput;
     } catch (Exception e) {
       String error = adapter.formatErrorOutput(e.getMessage());
         UssdSession session = new UssdSession();

       log.info("Encountered error for " + adapter.getPhoneNumber() + "\n" + error);
       return adapter.formatOutput("END An error has occurred.");
     }
   }

   @PatchMapping(path = {""})
   public String ussdIngressPatch(@RequestBody String body) throws IOException {
     System.out.println("USSD Patch method called\n" + body);
     log.info("USSD Patch");
     return "Hello from Gadaa Bank";
   }

   @GetMapping(path = {"ussd"})
   public String ussdIngress(@RequestParam String sessionId, @RequestParam String serviceCode, @RequestParam String phoneNumber, @RequestParam String text) throws IOException {
     try {
       return this.ussdRoutingService.menulevelrouter(sessionId, serviceCode, phoneNumber, text);
     } catch (IOException e) {
       return "END " + e.getMessage();
     }
   }
 }
