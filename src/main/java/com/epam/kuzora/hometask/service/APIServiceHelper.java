package com.epam.kuzora.hometask.service;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.service.api.RetrofitAPIService;
import com.epam.kuzora.hometask.service.api.SimpleAPIService;
import com.epam.kuzora.hometask.service.api.command.Command;
import com.epam.kuzora.hometask.service.exception.APICommandException;
import com.epam.kuzora.hometask.service.exception.APIServiceException;
import okhttp3.Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.util.EntityUtils;
import retrofit2.Response;

import java.io.IOException;

public class APIServiceHelper {
    private String apiParentUrl;
    private SimpleAPIService apiService;
    private RetrofitAPIService retrofitAPIService;

    public APIServiceHelper(String apiParentUrl) {
        this.apiParentUrl = apiParentUrl;
        this.apiService = new SimpleAPIService(apiParentUrl);
        this.retrofitAPIService = new RetrofitAPIService(apiParentUrl);
    }

    public String getEntityAsString(String request) {
        HttpEntity entity;
        try {
            entity = getResponse(request).getEntity();
            return EntityUtils.toString(entity);
        } catch (APIServiceException | IOException e) {
            Logger.logInConsole(e.getMessage());
        }
        return "";
    }

    public HttpUriRequest getHttpUriRequest(String request) {
        return apiService.setRequest(request);
    }

    public HttpResponse getResponse(String request) throws APIServiceException {
        try {
            return apiService.getResponse(apiService.setRequest(request));
        } catch (APIServiceException e) {
            Logger.logInConsole(e.getMessage());
        }
        return null;
    }

    public Response<?> getResponseWithRetrofitCommand(Command command, Object... params) {
        try {
            return retrofitAPIService.flexibleCommand(command, apiParentUrl, params).execute();
        } catch (APICommandException | IOException e) {
            Logger.logInConsole(e.getMessage());
        }
        return null;
    }

    public Request getRequestWithRetrofitCommand(Command command, Object... params) {
        try {
            return retrofitAPIService.flexibleCommand(command, apiParentUrl, params).request();
        } catch (APICommandException e) {
            Logger.logInConsole(e.getMessage());
        }
        return null;
    }
}
