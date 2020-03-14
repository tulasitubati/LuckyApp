package com.example.myapplication.services;

import com.example.myapplication.model.Facts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("facts.json")
    Call<Facts> getListData();
}
