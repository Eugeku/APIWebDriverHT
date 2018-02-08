package com.epam.kuzora.hometask.service.api.retrofit.fakerestapi.users;

import com.epam.kuzora.hometask.model.bean.fakerestapi.Book;
import com.epam.kuzora.hometask.model.bean.fakerestapi.User;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.List;

public interface UserAPI {
    @Headers({"Accept: application/json"})
    @GET("/api/Users")
    Call<List<User>> getListOfUsers();

    @Headers({"Accept: application/json"})
    @GET("/api/Users/{id}")
    Call<Book> getUserById(@Path("id") Integer id);

    @DELETE("/api/Users/{id}")
    Call<Boolean> deleteBookById(@Path("id") Integer id);
}
