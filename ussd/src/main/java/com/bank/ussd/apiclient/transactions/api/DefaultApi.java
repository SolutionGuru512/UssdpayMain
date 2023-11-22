package com.bank.ussd.apiclient.transactions.api;

import com.bank.ussd.apiclient.transactions.handler.ApiClient;
import com.bank.ussd.apiclient.transactions.model.AccountTransactionsResponse;
import com.bank.ussd.apiclient.transactions.model.StatementForTransactionResponse;
import com.bank.ussd.apiclient.transactions.model.TransactionDetailsResponse;

import java.time.LocalDate;

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


@Component("com.nibbank.ussd.apiclient.transactions.api.DefaultApi")
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
     * <p><b>200</b> - AccountTransactionsResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param accountId The identifier of the account. Often referred to as the account number, yet for consistency this is always referred to as accountId.
     * @param customerId The identifier of the customer
     * @param listType The listType parameter
     * @param transactionCount The transactionCount parameter
     * @param payType The payType parameter
     * @param dateFrom Payment schedule from date
     * @param dateTo Payment schedule to date
     * @param minimumAmount The minimumAmount parameter
     * @param maximumAmount The maximumAmount parameter
     * @param displayName The name used for display purposes
     * @param transactionCode The transactionCode parameter
     * @param statementReference The statementReference parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @return AccountTransactionsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AccountTransactionsResponse getAccountTransactions(String accountId, String customerId, String listType, String transactionCount, String payType, LocalDate dateFrom, LocalDate dateTo, String minimumAmount, String maximumAmount, String displayName, String transactionCode, String statementReference, Integer pageSize, Integer pageStart, String pageToken, String credentials, String companyId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/transactions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "accountId", accountId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "customerId", customerId));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "listType", listType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "transactionCount", transactionCount));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "payType", payType));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dateFrom", dateFrom));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dateTo", dateTo));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "minimumAmount", minimumAmount));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "maximumAmount", maximumAmount));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "displayName", displayName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "transactionCode", transactionCode));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "statementReference", statementReference));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
//        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "credentials", credentials));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "companyId", companyId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<AccountTransactionsResponse> returnType = new ParameterizedTypeReference<AccountTransactionsResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - StatementForTransactionResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param transactionReference The transactionReference parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @return StatementForTransactionResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatementForTransactionResponse getStatementForTransaction(String transactionReference, Integer pageSize, Integer pageStart, String pageToken, String credentials, String companyId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'transactionReference' is set
        if (transactionReference == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transactionReference' when calling getStatementForTransaction");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transactionReference", transactionReference);
        String path = UriComponentsBuilder.fromPath("/transactions/{transactionReference}/transactions").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
//        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "credentials", credentials));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "companyId", companyId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<StatementForTransactionResponse> returnType = new ParameterizedTypeReference<StatementForTransactionResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - TransactionDetailsResponse
     * <p><b>0</b> - QueryErrorResponse
     * @param transactionId The transactionId parameter
     * @param pageSize The total number of records per page
     * @param pageStart The record from which the response should be displayed
     * @param pageToken Unique id expected to get as part of response from t24 on every enquiry request.
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @return TransactionDetailsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public TransactionDetailsResponse getTransactionDetails(String transactionId, Integer pageSize, Integer pageStart, String pageToken, String credentials, String companyId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'transactionId' is set
        if (transactionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'transactionId' when calling getTransactionDetails");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transactionId", transactionId);
        String path = UriComponentsBuilder.fromPath("/transactions/{transactionId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_size", pageSize));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_start", pageStart));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page_token", pageToken));
//        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "credentials", credentials));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "companyId", companyId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<TransactionDetailsResponse> returnType = new ParameterizedTypeReference<TransactionDetailsResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
