/*    */ package com.bank.ussd.data;

 import com.bank.ussd.enums.MenuType;
 import com.fasterxml.jackson.annotation.JsonProperty;

 import java.util.List;

 public class Menu {
   @JsonProperty("id")
   private String id;

   @JsonProperty("menu_level")
   private String menuLevel;

   @JsonProperty("text")
   private String text;

   @JsonProperty("type")
   private MenuType type;

   @JsonProperty("handler")
   private String handler;

   @JsonProperty("variable")
   private String variable;

   @JsonProperty("next_menu_level")
   private String nextMenuLevel;

   @JsonProperty("previous_menu_level")
   private String previousMenuLevel;

   @JsonProperty("menu_options")
   private List<MenuOption> menuOptions;

   @JsonProperty("action")
   private String action;

   @JsonProperty("validation")
   private String validation;

   @JsonProperty("validation_error")
   private String validationError;

   @JsonProperty("max_selections")
   private Integer maxSelections;

   @JsonProperty("clear_session")
   private Boolean clearSession;

   @JsonProperty("values")
   private List<String> values;

   @JsonProperty("labels")
   private List<String> labels;

   @JsonProperty("id")
   public void setId(String id) {
     this.id = id;
   }

   @JsonProperty("menu_level")
   public void setMenuLevel(String menuLevel) {
     this.menuLevel = menuLevel;
   }

   @JsonProperty("text")
   public void setText(String text) {
     this.text = text;
   }

   @JsonProperty("type")
   public void setType(MenuType type) {
     this.type = type;
   }

   @JsonProperty("handler")
   public void setHandler(String handler) {
     this.handler = handler;
   }

   @JsonProperty("variable")
   public void setVariable(String variable) {
     this.variable = variable;
   }

   @JsonProperty("next_menu_level")
   public void setNextMenuLevel(String nextMenuLevel) {
     this.nextMenuLevel = nextMenuLevel;
   }

   @JsonProperty("previous_menu_level")
   public void setPreviousMenuLevel(String previousMenuLevel) {
     this.previousMenuLevel = previousMenuLevel;
   }

   @JsonProperty("menu_options")
   public void setMenuOptions(List<MenuOption> menuOptions) {
     this.menuOptions = menuOptions;
   }

   @JsonProperty("action")
   public void setAction(String action) {
     this.action = action;
   }

   @JsonProperty("validation")
   public void setValidation(String validation) {
     this.validation = validation;
   }

   @JsonProperty("validation_error")
   public void setValidationError(String validationError) {
     this.validationError = validationError;
   }

   @JsonProperty("max_selections")
   public void setMaxSelections(Integer maxSelections) {
     this.maxSelections = maxSelections;
   }

   @JsonProperty("clear_session")
   public void setClearSession(Boolean clearSession) {
     this.clearSession = clearSession;
   }

   @JsonProperty("values")
   public void setValues(List<String> values) {
     this.values = values;
   }

   @JsonProperty("labels")
   public void setLabels(List<String> labels) {
     this.labels = labels;
   }
  public String getId() {
    return this.id;
  }

  public String getMenuLevel() {
    return this.menuLevel;
  }

  public String getText() {
    return this.text;
  }

  public MenuType getType() {
    return this.type;
  }

  public String getHandler() {
    return this.handler;
  }

  public String getVariable() {
    return this.variable;
  }

  public String getNextMenuLevel() {
    return this.nextMenuLevel;
  }

  public String getPreviousMenuLevel() {
    return this.previousMenuLevel;
  }

  public List<MenuOption> getMenuOptions() {
    return this.menuOptions;
  }

  public String getAction() {
    return this.action;
  }

  public String getValidation() {
    return this.validation;
  }

  public String getValidationError() {
    return this.validationError;
  }

  public Integer getMaxSelections() {
    return this.maxSelections;
  }

  public Boolean getClearSession() {
    return this.clearSession;
  }

  public List<String> getValues() {
    return this.values;
  }

  public List<String> getLabels() {
    return this.labels;
  }
}
