package com.bank.ussd.adapters.xml;

 import com.fasterxml.jackson.annotation.JsonRootName;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.databind.JsonMappingException;
 import com.fasterxml.jackson.dataformat.xml.XmlMapper;
 import java.util.List;
 import java.util.NoSuchElementException;

 @JsonRootName("methodCall")
 public class MethodCall {
   private String methodName;

   private List<Param> params;

   public void setMethodName(String methodName) {
     this.methodName = methodName;
   }

   public void setParams(List<Param> params) {
     this.params = params;
   }

   public String toString() {
     return "MethodCall(methodName=" + getMethodName() + ", params=" + getParams() + ")";
   }

   public String getMethodName() {
     return this.methodName;
   }

   public List<Param> getParams() {
     return this.params;
   }

   public static MethodCall fromString(String value) {
     XmlMapper xmlMapper = new XmlMapper();
     try {
       return (MethodCall)xmlMapper.readValue(value, MethodCall.class);
     } catch (JsonMappingException e) {
       e.printStackTrace();
     } catch (JsonProcessingException e) {
       e.printStackTrace();
     }
     return null;
   }

   public Member getMember(String name) {
     if (getParams() == null || getParams().size() == 0)
       return null;
     try {
       Member mbr = ((Param)getParams().get(0)).getValue().getMember().stream().filter(member -> member.getName().equals(name)).findFirst().get();
       return mbr;
     } catch (NoSuchElementException ex) {
       return null;
     }
   }
 }

