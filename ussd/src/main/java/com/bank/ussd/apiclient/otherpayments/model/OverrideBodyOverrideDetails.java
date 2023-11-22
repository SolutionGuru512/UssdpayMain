/*
 * TC CHANNELS OTHER AC FT PUBLISHED API
 * TC CHANNELS OTHER AC FT PUBLISHED API
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.otherpayments.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * OverrideBodyOverrideDetails
 */

public class OverrideBodyOverrideDetails {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("options")
  private List<String> options = null;

  @JsonProperty("type")
  private String type = null;

  public OverrideBodyOverrideDetails id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The identifier of the override.
   * @return id
  **/
  @ApiModelProperty(value = "The identifier of the override.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OverrideBodyOverrideDetails description(String description) {
    this.description = description;
    return this;
  }

   /**
   * The actual override message.
   * @return description
  **/
  @ApiModelProperty(value = "The actual override message.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OverrideBodyOverrideDetails code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The code related to override message.
   * @return code
  **/
  @ApiModelProperty(value = "The code related to override message.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OverrideBodyOverrideDetails options(List<String> options) {
    this.options = options;
    return this;
  }

  public OverrideBodyOverrideDetails addOptionsItem(String optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(optionsItem);
    return this;
  }

   /**
   * The usable options for the override.
   * @return options
  **/
  @ApiModelProperty(value = "The usable options for the override.")
  public List<String> getOptions() {
    return options;
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }

  public OverrideBodyOverrideDetails type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the override.
   * @return type
  **/
  @ApiModelProperty(value = "The type of the override.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OverrideBodyOverrideDetails overrideBodyOverrideDetails = (OverrideBodyOverrideDetails) o;
    return Objects.equals(this.id, overrideBodyOverrideDetails.id) &&
        Objects.equals(this.description, overrideBodyOverrideDetails.description) &&
        Objects.equals(this.code, overrideBodyOverrideDetails.code) &&
        Objects.equals(this.options, overrideBodyOverrideDetails.options) &&
        Objects.equals(this.type, overrideBodyOverrideDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, code, options, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OverrideBodyOverrideDetails {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

