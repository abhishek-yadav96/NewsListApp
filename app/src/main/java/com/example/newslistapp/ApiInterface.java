package com.example.newslistapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {




@GET("everything")
    Call<ModelResponse> getresponse(@Query("q") String q, @Query("sortBy") String sortby, @Query("apiKey") String apiKey);

}
