package com.bank.ussd.apiclient.otherpayments.api;

import com.bank.ussd.apiclient.otherpayments.handler.ApiClient;

import com.bank.ussd.apiclient.otherpayments.model.CreateFundsTransferOtherAcTrf;
import com.bank.ussd.apiclient.otherpayments.model.FundsTransferOtherAcTrfResponse;

import java.util.List;

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


@Component("com.bank.ussd.apiclient.otherpayments.api.DefaultApi")
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
     * createFundsTransferOtherAcTrf
     * <p><b>200</b> - FundsTransferOtherAcTrfResponse
     * <p><b>400</b> - BusinessScreenErrorResponse
     * <p><b>500</b> - SystemScreenErrorResponse
     * <p><b>0</b> - ScreenErrorResponse
     * @param payload body Payload
     * @param credentials The credentials parameter
     * @param companyId The companyId parameter
     * @param validateOnly The identifier to indicate if it is set to only validate or not.
     * @return FundsTransferOtherAcTrfResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public FundsTransferOtherAcTrfResponse createFundsTransferOtherAcTrf(CreateFundsTransferOtherAcTrf payload, String credentials, String companyId, Boolean validateOnly) throws RestClientException {
        Object postBody = payload;
        
        // verify the required parameter 'payload' is set
        if (payload == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'payload' when calling createFundsTransferOtherAcTrf");
        }
        
        String path = UriComponentsBuilder.fromPath("/otherPayments").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "validate_only", validateOnly));
        
        if (credentials != null)
        headerParams.add("credentials", apiClient.parameterToString(credentials));
        if (companyId != null)
        headerParams.add("companyId", apiClient.parameterToString(companyId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<FundsTransferOtherAcTrfResponse> returnType = new ParameterizedTypeReference<FundsTransferOtherAcTrfResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
