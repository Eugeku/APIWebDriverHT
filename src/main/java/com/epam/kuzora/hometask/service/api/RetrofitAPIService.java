package com.epam.kuzora.hometask.service.api;

import com.epam.kuzora.hometask.service.api.command.Command;
import com.epam.kuzora.hometask.service.exception.APICommandException;
import retrofit2.Call;

public class RetrofitAPIService {
    private String apiParentUrl;

    public RetrofitAPIService(String apiParentUrl) {
        this.apiParentUrl = apiParentUrl;
    }

    public Call<?> flexibleCommand(Command command, Object... params) throws APICommandException {
        return command.execute(params);
    }
}
