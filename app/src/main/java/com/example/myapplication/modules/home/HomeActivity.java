package com.example.myapplication.modules.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.R;

public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       UpdateContainer();


    }
    private void UpdateContainer(){
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frags_container,new HomeFragment()).commit();

    }


}
