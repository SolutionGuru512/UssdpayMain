package com.bank.ussd.adapters.xml;

 import com.fasterxml.jackson.annotation.JsonRootName;
 import com.fasterxml.jackson.core.JsonProcessingException;
 import com.fasterxml.jackson.dataformat.xml.XmlMapper;
 import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
 import java.util.ArrayList;
 import java.util.List;

 @JsonRootName("methodResponse")
 public class MethodResponse {
   @JacksonXmlElementWrapper(localName = "params")
   private List<Param> param;

   public void setParam(List<Param> param) {
     this.param = param;
   }

   public List<Param> getParam() {
     return this.param;
   }

   public Member addMember(String name, String value, String valueType) {
     Member member = new Member();
     member.setName(name);
     member.setVal(value);
     member.setValType(valueType);
     if (this.param == null)
       this.param = new ArrayList<>();
     if (this.param.size() == 0) {
       Param param1 = new Param();
       this.param.add(param1);
     }
     Param param = this.param.get(0);
     if (param.getValue() == null)
       param.setValue(new Value());
     Value val = param.getValue();
     if (val.getMember() == null)
       val.setMember(new ArrayList<>());
     val.getMember().add(member);
     return member;
   }

   public Member addFaultMember(String name, String value, String valueType) {
     Member member = new Member();
     member.setName(name);
     member.setVal(value);
     member.setValType(valueType);
     if (this.param == null)
       this.param = new ArrayList<>();
     if (this.param.size() == 0) {
       Param param1 = new Fault();
       this.param.add(param1);
     }
     Param param = this.param.get(0);
     if (param.getValue() == null)
       param.setValue(new Value());
     Value val = param.getValue();
     if (val.getMember() == null)
       val.setMember(new ArrayList<>());
     val.getMember().add(member);
     return member;
   }

   public String toString() {
     XmlMapper xmlMapper = new XmlMapper();
     try {
       return xmlMapper.writeValueAsString(this);
     } catch (JsonProcessingException e) {
       e.printStackTrace();
       return null;
     }
   }
 }

