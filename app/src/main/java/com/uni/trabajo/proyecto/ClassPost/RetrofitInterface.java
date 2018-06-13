package com.uni.trabajo.proyecto.ClassPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("/posts")
    Call<List<Post>> getPostList();

    @GET("/posts/{Id}")
    Call<Post> getSinglePost(@Path("Id") int postId);

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build();
}
