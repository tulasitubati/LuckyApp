package com.example.myapplication.manager;

import com.example.myapplication.services.ApiClient;
import com.example.myapplication.services.ApiInterface;

public class ApiManager {
    public static ApiInterface mApiInterface;
    public static ApiInterface getAPI(){
        if(mApiInterface==null){
            mApiInterface= ApiClient.getInstance();
        }
        return mApiInterface;
    }
}
