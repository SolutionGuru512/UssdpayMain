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
 * BusinessScreenErrorResponseBody
 */

public class BusinessScreenErrorResponseBody {
  @JsonProperty("errorDetails")
  private List<BusinessScreenErrorResponseBodyErrorDetails> errorDetails = null;

  @JsonProperty("type")
  private String type = null;

  public BusinessScreenErrorResponseBody errorDetails(List<BusinessScreenErrorResponseBodyErrorDetails> errorDetails) {
    this.errorDetails = errorDetails;
    return this;
  }

  public BusinessScreenErrorResponseBody addErrorDetailsItem(BusinessScreenErrorResponseBodyErrorDetails errorDetailsItem) {
    if (this.errorDetails == null) {
      this.errorDetails = new ArrayList<>();
    }
    this.errorDetails.add(errorDetailsItem);
    return this;
  }

   /**
   * Get errorDetails
   * @return errorDetails
  **/
  @ApiModelProperty(value = "")
  public List<BusinessScreenErrorResponseBodyErrorDetails> getErrorDetails() {
    return errorDetails;
  }

  public void setErrorDetails(List<BusinessScreenErrorResponseBodyErrorDetails> errorDetails) {
    this.errorDetails = errorDetails;
  }

  public BusinessScreenErrorResponseBody type(String type) {
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessScreenErrorResponseBody businessScreenErrorResponseBody = (BusinessScreenErrorResponseBody) o;
    return Objects.equals(this.errorDetails, businessScreenErrorResponseBody.errorDetails) &&
        Objects.equals(this.type, businessScreenErrorResponseBody.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorDetails, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessScreenErrorResponseBody {\n");
    
    sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
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

