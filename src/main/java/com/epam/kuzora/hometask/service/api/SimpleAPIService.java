package com.epam.kuzora.hometask.service.api;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.service.exception.APIServiceException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class SimpleAPIService {
    private String apiParentUrl;
    private HttpUriRequest request;
    private HttpResponse httpResponse;

    public SimpleAPIService(String apiParentUrl) {
        this.apiParentUrl = apiParentUrl;
    }

    public HttpUriRequest getRequestValue() {
        return request;
    }

    public HttpResponse getHttpResponseValue() {
        return httpResponse;
    }

    public HttpUriRequest setRequest(String req) {
        request = new HttpGet(apiParentUrl + req);
        return request;
    }

    public HttpResponse getResponse(HttpUriRequest request) throws APIServiceException {
        try {
            httpResponse = HttpClientBuilder.create().build().execute(request);
        } catch (Exception e) {
            Logger.logInConsole(e.getMessage());
            throw new APIServiceException(e);
        }
        return httpResponse;
    }
}
