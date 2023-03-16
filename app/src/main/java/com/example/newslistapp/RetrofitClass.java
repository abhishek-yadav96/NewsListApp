package com.example.newslistapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static Retrofit retrofit;
    private static final String BASEURL="https://newsapi.org/v2/";
    public static Retrofit getclientci(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient apiclient=new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(100, TimeUnit.SECONDS).writeTimeout(100,TimeUnit.SECONDS).connectTimeout(100,TimeUnit.SECONDS).retryOnConnectionFailure(false).build();
        Gson gson=new GsonBuilder().setLenient().create();
        retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).client(apiclient).build();
        return  retrofit;
    }

}
