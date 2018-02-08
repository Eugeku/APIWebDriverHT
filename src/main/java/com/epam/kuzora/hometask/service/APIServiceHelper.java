package com.epam.kuzora.hometask.service;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.service.api.RetrofitAPIService;
import com.epam.kuzora.hometask.service.api.SimpleAPIService;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class APIServiceHelper {
    private SimpleAPIService apiService;
    private RetrofitAPIService retrofitAPIService;

    public APIServiceHelper(String apiParentUrl) {
        this.apiService = new SimpleAPIService(apiParentUrl);
        this.retrofitAPIService = new RetrofitAPIService(apiParentUrl);
    }

    public String getEntityAsString(String request) {
        HttpEntity entity;
        try {
            entity = apiService.getResponse(apiService.setRequest(request)).getEntity();
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            Logger.logInConsole(e.getMessage());
        }
        return "";
    }


}
