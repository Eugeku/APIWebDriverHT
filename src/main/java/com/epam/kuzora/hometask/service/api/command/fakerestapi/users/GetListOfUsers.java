package com.epam.kuzora.hometask.service.api.command.fakerestapi.users;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.model.bean.fakerestapi.User;
import com.epam.kuzora.hometask.service.api.command.Command;
import com.epam.kuzora.hometask.service.api.retrofit.fakerestapi.users.UserAPI;
import com.epam.kuzora.hometask.service.exception.APICommandException;
import retrofit2.Call;

import java.util.List;

public class GetListOfUsers extends Command {
    @Override
    public Call<List<User>> execute(Object... params) throws APICommandException {
        try {
            return super.init(params[0].toString(), UserAPI.class).getListOfUsers();
        } catch (Exception e) {
            Logger.logInConsole(e.getMessage());
            throw new APICommandException(e);
        }
    }
}
