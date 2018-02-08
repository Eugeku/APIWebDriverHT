package com.epam.kuzora.hometask.service.api.command.fakerestapi.book;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.service.api.command.Command;
import com.epam.kuzora.hometask.service.api.retrofit.fakerestapi.books.BookAPI;
import retrofit2.Call;

import java.util.List;

public class GetListsOfBooks extends Command {

    @Override
    public Call<List<Book>> execute(Object... params) throws Exception {
        return super.init(params[0].toString(), BookAPI.class).getListOfBooks();
    }
}
