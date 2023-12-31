/*
 * GetHoldingsAPI
 * Get Holdings API
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.accountList.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * BusinessQueryErrorResponseBody
 */

public class BusinessQueryErrorResponseBody {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("type")
  private String type = null;

  public BusinessQueryErrorResponseBody code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The identifier of the error message
   * @return code
  **/
  @ApiModelProperty(value = "The identifier of the error message")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BusinessQueryErrorResponseBody message(String message) {
    this.message = message;
    return this;
  }

   /**
   * The actual Transact error message for bad requests
   * @return message
  **/
  @ApiModelProperty(value = "The actual Transact error message for bad requests")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public BusinessQueryErrorResponseBody type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The identifier of error type: Business
   * @return type
  **/
  @ApiModelProperty(value = "The identifier of error type: Business")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessQueryErrorResponseBody businessQueryErrorResponseBody = (BusinessQueryErrorResponseBody) o;
    return Objects.equals(this.code, businessQueryErrorResponseBody.code) &&
        Objects.equals(this.message, businessQueryErrorResponseBody.message) &&
        Objects.equals(this.type, businessQueryErrorResponseBody.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessQueryErrorResponseBody {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

