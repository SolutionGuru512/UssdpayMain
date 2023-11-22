/*
 * Holdings APIs
 * Get customer holdings
 *
 * OpenAPI spec version: v1.0.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.bank.ussd.apiclient.holdings2.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * QueryHeaderAudit
 */

public class QueryHeaderAudit {
  @JsonProperty("T24_time")
  private Integer t24Time = null;

  @JsonProperty("versionNumber")
  private String versionNumber = null;

  @JsonProperty("parse_time")
  private Integer parseTime = null;

  public QueryHeaderAudit t24Time(Integer t24Time) {
    this.t24Time = t24Time;
    return this;
  }

   /**
   * Time taken to response by T24
   * @return t24Time
  **/
  @ApiModelProperty(value = "Time taken to response by T24")
  public Integer getT24Time() {
    return t24Time;
  }

  public void setT24Time(Integer t24Time) {
    this.t24Time = t24Time;
  }

  public QueryHeaderAudit versionNumber(String versionNumber) {
    this.versionNumber = versionNumber;
    return this;
  }

   /**
   * The CURR.NO. of the record
   * @return versionNumber
  **/
  @ApiModelProperty(value = "The CURR.NO. of the record")
  public String getVersionNumber() {
    return versionNumber;
  }

  public void setVersionNumber(String versionNumber) {
    this.versionNumber = versionNumber;
  }

  public QueryHeaderAudit parseTime(Integer parseTime) {
    this.parseTime = parseTime;
    return this;
  }

   /**
   * Time taken to parse the response by IRIS
   * @return parseTime
  **/
  @ApiModelProperty(value = "Time taken to parse the response by IRIS")
  public Integer getParseTime() {
    return parseTime;
  }

  public void setParseTime(Integer parseTime) {
    this.parseTime = parseTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryHeaderAudit queryHeaderAudit = (QueryHeaderAudit) o;
    return Objects.equals(this.t24Time, queryHeaderAudit.t24Time) &&
        Objects.equals(this.versionNumber, queryHeaderAudit.versionNumber) &&
        Objects.equals(this.parseTime, queryHeaderAudit.parseTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(t24Time, versionNumber, parseTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryHeaderAudit {\n");
    
    sb.append("    t24Time: ").append(toIndentedString(t24Time)).append("\n");
    sb.append("    versionNumber: ").append(toIndentedString(versionNumber)).append("\n");
    sb.append("    parseTime: ").append(toIndentedString(parseTime)).append("\n");
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

