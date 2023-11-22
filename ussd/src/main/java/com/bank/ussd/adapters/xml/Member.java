 package com.bank.ussd.adapters.xml;

 import com.fasterxml.jackson.annotation.JsonIgnore;
 import com.fasterxml.jackson.annotation.JsonProperty;
 import java.util.HashMap;
 import java.util.Map;

 public class Member {
   private String name;

   @JsonIgnore
   private String val;

   @JsonIgnore
   private String valType;

   public void setName(String name) {
     this.name = name;
   }

   @JsonIgnore
   public void setVal(String val) {
     this.val = val;
   }

   @JsonIgnore
   public void setValType(String valType) {
/* 11 */     this.valType = valType;
/*    */   }

  public String toString() {
    return "Member(name=" + getName() + ", val=" + getVal() + ", valType=" + getValType() + ")";
  }

  public String getName() {
    return this.name;
  }

  public String getVal() {
    return this.val;
  }

  public String getValType() {
    return this.valType;
  }

  @JsonProperty("value")
  private void valueDeserializer(Map<String, Object> valueMap) {
    this.valType = valueMap.keySet().stream().findFirst().get();
    this.val = (String)valueMap.get(this.valType);
  }

  public HashMap<String, String> getValue() {
    HashMap<String, String> val = new HashMap<>();
    val.put(this.valType, this.val);
    return val;
  }
}