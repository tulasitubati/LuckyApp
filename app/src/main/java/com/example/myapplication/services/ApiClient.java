package com.example.myapplication.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit ;
    public static synchronized ApiInterface getInstance(){
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiInterface.class);
    }
}
