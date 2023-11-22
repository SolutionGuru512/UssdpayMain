package com.bank.ussd.apiclient.holdings2.api;

import com.bank.ussd.apiclient.holdings2.handler.ApiClient;
import com.bank.ussd.apiclient.holdings2.model.HoldingsResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


@Component("com.bank.ussd.apiclient.holdings2.api.DefaultApi")
public class DefaultApi {
    private ApiClient apiClient;

    public DefaultApi() {
        this(new ApiClient());
    }

    @Autowired
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 
     * 
     * <p><b>200</b> - HoldingsResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param customerId The identifier of the customer
     * @param holdingsType The holdingsType parameter
     * @param holdingsId The holdingsId parameter
     * @param getPreferredHoldings The getPreferredHoldings parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @return HoldingsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public HoldingsResponse getPreferredHoldings(String customerId, String holdingsType, String holdingsId, String getPreferredHoldings, Integer pageSize, Integer pageStart, String pageToken, String credentials, String companyId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/holdings/preferredHoldings").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customerId", customerId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "holdingsType", holdingsType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "holdingsId", holdingsId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "getPreferredHoldings", getPreferredHoldings));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "credentials", credentials));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "companyId", companyId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<HoldingsResponse> returnType = new ParameterizedTypeReference<HoldingsResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - HoldingsResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param customerId The identifier of the customer
     * @param holdingsType The holdingsType parameter
     * @param holdingsId The holdingsId parameter
     * @param getPreferredHoldings The getPreferredHoldings parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @return HoldingsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public HoldingsResponse getUserHoldings(String customerId, String holdingsType, String holdingsId, String getPreferredHoldings, Integer pageSize, Integer pageStart, String pageToken, String credentials, String companyId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/holdings/myHoldingsAc").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customerId", customerId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "holdingsType", holdingsType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "holdingsId", holdingsId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "getPreferredHoldings", getPreferredHoldings));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "credentials", credentials));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "companyId", companyId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<HoldingsResponse> returnType = new ParameterizedTypeReference<HoldingsResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
