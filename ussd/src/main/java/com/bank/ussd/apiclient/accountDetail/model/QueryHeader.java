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
import io.swagger.annotations.ApiModelProperty;

/**
 * QueryHeader
 */

public class QueryHeader {
  @JsonProperty("audit")
  private QueryHeaderAudit audit = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("page_size")
  private Integer pageSize = null;

  @JsonProperty("page_start")
  private Integer pageStart = null;

  @JsonProperty("total_size")
  private Integer totalSize = null;

  @JsonProperty("page_token")
  private String pageToken = null;

  public QueryHeader audit(QueryHeaderAudit audit) {
    this.audit = audit;
    return this;
  }

   /**
   * Get audit
   * @return audit
  **/
  @ApiModelProperty(value = "")
  public QueryHeaderAudit getAudit() {
    return audit;
  }

  public void setAudit(QueryHeaderAudit audit) {
    this.audit = audit;
  }

  public QueryHeader status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the API(success/failed)
   * @return status
  **/
  @ApiModelProperty(value = "Status of the API(success/failed)")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public QueryHeader pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * The total number of records per page
   * @return pageSize
  **/
  @ApiModelProperty(value = "The total number of records per page")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public QueryHeader pageStart(Integer pageStart) {
    this.pageStart = pageStart;
    return this;
  }

   /**
   * The record from which the response should be displayed
   * @return pageStart
  **/
  @ApiModelProperty(value = "The record from which the response should be displayed")
  public Integer getPageStart() {
    return pageStart;
  }

  public void setPageStart(Integer pageStart) {
    this.pageStart = pageStart;
  }

  public QueryHeader totalSize(Integer totalSize) {
    this.totalSize = totalSize;
    return this;
  }

   /**
   * The total number of records present
   * @return totalSize
  **/
  @ApiModelProperty(value = "The total number of records present")
  public Integer getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(Integer totalSize) {
    this.totalSize = totalSize;
  }

  public QueryHeader pageToken(String pageToken) {
    this.pageToken = pageToken;
    return this;
  }

   /**
   * Unique id expected to get as part of response from t24 on every enquiry request
   * @return pageToken
  **/
  @ApiModelProperty(value = "Unique id expected to get as part of response from t24 on every enquiry request")
  public String getPageToken() {
    return pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryHeader queryHeader = (QueryHeader) o;
    return Objects.equals(this.audit, queryHeader.audit) &&
        Objects.equals(this.status, queryHeader.status) &&
        Objects.equals(this.pageSize, queryHeader.pageSize) &&
        Objects.equals(this.pageStart, queryHeader.pageStart) &&
        Objects.equals(this.totalSize, queryHeader.totalSize) &&
        Objects.equals(this.pageToken, queryHeader.pageToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(audit, status, pageSize, pageStart, totalSize, pageToken);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryHeader {\n");
    
    sb.append("    audit: ").append(toIndentedString(audit)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    pageStart: ").append(toIndentedString(pageStart)).append("\n");
    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
    sb.append("    pageToken: ").append(toIndentedString(pageToken)).append("\n");
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

