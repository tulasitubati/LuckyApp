package com.example.myapplication.services;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.manager.ApiManager;
import com.example.myapplication.model.Facts;
import com.example.myapplication.model.Row;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCallsManager {

    MutableLiveData<Facts> mutableLiveData;

    private static final NetworkCallsManager ourInstance=new NetworkCallsManager();
    public static NetworkCallsManager getInstance(){
        return ourInstance;
    }
    ApiInterface apiManager;

    private NetworkCallsManager() {
        apiManager = ApiManager.getAPI();
    }

    public MutableLiveData<Facts>getRows() {
    mutableLiveData=new MutableLiveData<>();
    apiManager.getListData().enqueue(new Callback<Facts>() {
        @Override
        public void onResponse(Call<Facts> call, Response<Facts> response) {
            if(response.body()!=null && response.isSuccessful()){
                mutableLiveData.setValue(response.body());
            }

        }

        @Override
        public void onFailure(Call<Facts> call, Throwable t) {
            Log.e("tag",""+t.getMessage());

        }
    });


    return mutableLiveData;
    }
}
