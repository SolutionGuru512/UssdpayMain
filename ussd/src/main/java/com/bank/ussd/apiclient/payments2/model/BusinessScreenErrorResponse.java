/*
 * TC CHANNELS FT PUBLISHED API
 * TC CHANNELS FT PUBLISHED API
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.payments2.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BusinessScreenErrorResponse
 */
@ApiModel(description = "BusinessScreenErrorResponse")

public class BusinessScreenErrorResponse {
  @JsonProperty("header")
  private ErrorHeader header = null;

  @JsonProperty("error")
  private BusinessScreenErrorResponseBody error = null;

  @JsonProperty("override")
  private OverrideBody override = null;

  public BusinessScreenErrorResponse header(ErrorHeader header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  public ErrorHeader getHeader() {
    return header;
  }

  public void setHeader(ErrorHeader header) {
    this.header = header;
  }

  public BusinessScreenErrorResponse error(BusinessScreenErrorResponseBody error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(value = "")
  public BusinessScreenErrorResponseBody getError() {
    return error;
  }

  public void setError(BusinessScreenErrorResponseBody error) {
    this.error = error;
  }

  public BusinessScreenErrorResponse override(OverrideBody override) {
    this.override = override;
    return this;
  }

   /**
   * Get override
   * @return override
  **/
  @ApiModelProperty(value = "")
  public OverrideBody getOverride() {
    return override;
  }

  public void setOverride(OverrideBody override) {
    this.override = override;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessScreenErrorResponse businessScreenErrorResponse = (BusinessScreenErrorResponse) o;
    return Objects.equals(this.header, businessScreenErrorResponse.header) &&
        Objects.equals(this.error, businessScreenErrorResponse.error) &&
        Objects.equals(this.override, businessScreenErrorResponse.override);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, error, override);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessScreenErrorResponse {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    override: ").append(toIndentedString(override)).append("\n");
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

