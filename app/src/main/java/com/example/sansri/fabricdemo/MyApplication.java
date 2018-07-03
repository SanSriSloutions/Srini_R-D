package com.example.sansri.fabricdemo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.sansri.fabricdemo.Analytics.FabricComponent;

import io.fabric.sdk.android.Fabric;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FabricComponent.getFabricInstance().initializeFabricComponents(getApplicationContext());
    }

}
