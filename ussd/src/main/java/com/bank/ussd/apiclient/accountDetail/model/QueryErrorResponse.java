/*
 * getAccountListAPI
 * getAccountListAPI
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.accountDetail.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * QueryErrorResponse
 */
@ApiModel(description = "QueryErrorResponse")

public class QueryErrorResponse {
  @JsonProperty("header")
  private ErrorHeader header = null;

  @JsonProperty("error")
  private QueryErrorResponseBody error = null;

  public QueryErrorResponse header(ErrorHeader header) {
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

  public QueryErrorResponse error(QueryErrorResponseBody error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(value = "")
  public QueryErrorResponseBody getError() {
    return error;
  }

  public void setError(QueryErrorResponseBody error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryErrorResponse queryErrorResponse = (QueryErrorResponse) o;
    return Objects.equals(this.header, queryErrorResponse.header) &&
        Objects.equals(this.error, queryErrorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, error);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryErrorResponse {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
