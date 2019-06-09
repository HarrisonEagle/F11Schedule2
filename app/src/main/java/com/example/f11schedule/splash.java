package com.example.f11schedule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    protected Handler mHandler=new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(splash.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);
    }
}
