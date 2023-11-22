package com.bank.ussd.apiclient.accountDetail.api;

import com.bank.ussd.apiclient.accountDetail.handler.ApiClient;
import com.bank.ussd.apiclient.accountDetail.model.AccountListResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Component("com.bank.ussd.apiclient.accountDetail.api.DefaultApi")
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
     * getAccountList
     * <p><b>200</b> - AccountListResponse
     * <p><b>400</b> - BusinessQueryErrorResponse
     * <p><b>500</b> - SystemQueryErrorResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param accountId The accountId parameter
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @param disablePagination The disablePagination parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @return AccountListResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccountListResponse getAccountList(String accountId, String credentials, String companyId, String disablePagination, Integer pageSize, Integer pageStart, String pageToken) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accountId' when calling getAccountList");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("accountId", accountId);
        String path = UriComponentsBuilder.fromPath("/getAccountList/{accountId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
        
        if (credentials != null)
        headerParams.add("credentials", apiClient.parameterToString(credentials));
        if (companyId != null)
        headerParams.add("companyId", apiClient.parameterToString(companyId));
        if (disablePagination != null)
        headerParams.add("disablePagination", apiClient.parameterToString(disablePagination));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<AccountListResponse> returnType = new ParameterizedTypeReference<AccountListResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
