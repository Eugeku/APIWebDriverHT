package com.epam.kuzora.hometask.service.api.retrofit.fakerestapi.books;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface BookAPI {
    @Headers({"Accept: application/json"})
    @GET("/api/Books")
    Call<List<Book>> getListOfBooks();

    @Headers({"Accept: application/json"})
    @GET("/api/Books/{id}")
    Call<Book> getBookById(@Path("id") Integer id);

    @DELETE("/api/Books/{id}")
    Call<Boolean> deleteBookById(@Path("id") Integer id);
}
