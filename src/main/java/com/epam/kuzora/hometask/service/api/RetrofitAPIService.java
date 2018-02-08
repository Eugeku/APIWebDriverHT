package com.epam.kuzora.hometask.service.api;


import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.model.bean.fakerestapi.User;
import com.epam.kuzora.hometask.service.api.command.Command;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetBook;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.book.GetListsOfBooks;
import com.epam.kuzora.hometask.service.api.command.fakerestapi.users.GetListOfUsers;
import retrofit2.Call;

import java.util.List;

public class RetrofitAPIService {
    private String apiParentUrl;

    public RetrofitAPIService(String apiParentUrl) {
        this.apiParentUrl = apiParentUrl;
    }

    public Call<List<Book>> getAllBooks() throws Exception {
        return new GetListsOfBooks().execute(apiParentUrl);
    }

    public Call<Book> getBook(int id) throws Exception {
        return new GetBook().execute(apiParentUrl, id);
    }

    public Call<List<User>> getAllUsers() throws Exception {
        return new GetListOfUsers().execute(apiParentUrl);
    }

    public Call<?> flexibleCommand(Command command, Object... params) throws Exception {
        return command.execute(params);
    }


}
