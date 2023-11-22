 package com.bank.ussd.adapters.xml;

 import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
 import java.util.List;

 public class Value {
   @JacksonXmlElementWrapper(localName = "struct")
   private List<Member> member;

   public String toString() {
     return "Value(member=" + getMember() + ")";
   }

   public void setMember(List<Member> member) {
     this.member = member;
   }

   public List<Member> getMember() {
     return this.member;
   }
 }
