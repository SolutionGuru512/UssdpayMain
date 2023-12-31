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

/**
 * SystemScreenErrorResponseBodyErrorDetails
 */

public class SystemScreenErrorResponseBodyErrorDetails {
  @JsonProperty("fieldName")
  private String fieldName = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  public SystemScreenErrorResponseBodyErrorDetails fieldName(String fieldName) {
    this.fieldName = fieldName;
    return this;
  }

   /**
   * The name of the field
   * @return fieldName
  **/
  @ApiModelProperty(value = "The name of the field")
  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public SystemScreenErrorResponseBodyErrorDetails code(String code) {
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

  public SystemScreenErrorResponseBodyErrorDetails message(String message) {
    this.message = message;
    return this;
  }

   /**
   * The actual t24 error message caused by server
   * @return message
  **/
  @ApiModelProperty(value = "The actual t24 error message caused by server")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemScreenErrorResponseBodyErrorDetails systemScreenErrorResponseBodyErrorDetails = (SystemScreenErrorResponseBodyErrorDetails) o;
    return Objects.equals(this.fieldName, systemScreenErrorResponseBodyErrorDetails.fieldName) &&
        Objects.equals(this.code, systemScreenErrorResponseBodyErrorDetails.code) &&
        Objects.equals(this.message, systemScreenErrorResponseBodyErrorDetails.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldName, code, message);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemScreenErrorResponseBodyErrorDetails {\n");
    
    sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

