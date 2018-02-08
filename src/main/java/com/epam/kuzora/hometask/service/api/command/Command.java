package com.epam.kuzora.hometask.service.api.command;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class Command {
    public abstract Call<?> execute(Object... params) throws Exception;

    public <T> T init(String apiParentUrl, Class<T> tClass) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(apiParentUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(tClass);
    }
}
