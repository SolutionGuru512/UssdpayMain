/*
 * Transactions APIs
 * Get Transactions Details
 *
 * OpenAPI spec version: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.transactions.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * AccountTransactionsResponse
 */
@ApiModel(description = "AccountTransactionsResponse")

public class AccountTransactionsResponse {
  @JsonProperty("header")
  private QueryHeader header = null;

  @JsonProperty("body")
  private AccountTransactionsResponseBody body = null;

  public AccountTransactionsResponse header(QueryHeader header) {
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

  public AccountTransactionsResponse body(AccountTransactionsResponseBody body) {
    this.body = body;
    return this;
  }

   /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(value = "")
  public AccountTransactionsResponseBody getBody() {
    return body;
  }

  public void setBody(AccountTransactionsResponseBody body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountTransactionsResponse accountTransactionsResponse = (AccountTransactionsResponse) o;
    return Objects.equals(this.header, accountTransactionsResponse.header) &&
        Objects.equals(this.body, accountTransactionsResponse.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, body);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountTransactionsResponse {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

