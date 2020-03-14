package com.example.myapplication.modules.item;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity extends AppCompatActivity {
    ActivityMain2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main2);
        Intent in=getIntent();
        binding.setTitle(in.getStringExtra("title"));
        binding.setDescription(in.getStringExtra("description"));


    }
}
