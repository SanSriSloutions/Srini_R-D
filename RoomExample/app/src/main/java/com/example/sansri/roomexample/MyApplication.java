package com.example.sansri.roomexample;

import android.app.Application;

import com.example.sansri.roomexample.database.AppDataBase;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

         // Create Static Instance for AppDatabase.
         AppDataBase.getInstance(getApplicationContext());

    }
}
