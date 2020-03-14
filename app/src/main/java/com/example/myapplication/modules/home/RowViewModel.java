package com.example.myapplication.modules.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Facts;
import com.example.myapplication.services.NetworkCallsManager;

public class RowViewModel extends ViewModel {

     public MutableLiveData<Facts>getFacts(){
        return NetworkCallsManager.getInstance().getRows();
    }
}
