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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * TransactionalHoldingsResponse
 */
@ApiModel(description = "TransactionalHoldingsResponse")

public class TransactionalHoldingsResponse {
  @JsonProperty("header")
  private QueryHeader header = null;

  @JsonProperty("body")
  private TransactionalHoldingsResponseBody body = null;

  public TransactionalHoldingsResponse header(QueryHeader header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(value = "")
  public QueryHeader getHeader() {
    return header;
  }

  public void setHeader(QueryHeader header) {
    this.header = header;
  }

  public TransactionalHoldingsResponse body(TransactionalHoldingsResponseBody body) {
    this.body = body;
    return this;
  }

   /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(value = "")
  public TransactionalHoldingsResponseBody getBody() {
    return body;
  }

  public void setBody(TransactionalHoldingsResponseBody body) {
    this.body = body;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionalHoldingsResponse transactionalHoldingsResponse = (TransactionalHoldingsResponse) o;
    return Objects.equals(this.header, transactionalHoldingsResponse.header) &&
        Objects.equals(this.body, transactionalHoldingsResponse.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, body);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionalHoldingsResponse {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

