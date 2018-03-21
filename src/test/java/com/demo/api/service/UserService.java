package com.demo.api.service;

import com.demo.api.entity.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


/**
 * Created by alpa on 3/20/18
 */
public interface UserService {

    @GET("/apanashchenko/demo-rest-server/users")
    Call<List<User>> getUsers();

    @GET("/apanashchenko/demo-rest-server/users/{id}")
    Call<User> getUser(@Path("id") int id);

    @POST("/apanashchenko/demo-rest-server/users/")
    Call<User> createUser(@Body User user);

    @PUT("/apanashchenko/demo-rest-server/users/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("/apanashchenko/demo-rest-server/users/{id}")
    Call<User> deleteUser(@Path("id") int id);


}
