package com.example.sansri.fabricdemo;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.sansri.fabricdemo.Analytics.FabricComponent;
import com.example.sansri.fabricdemo.Analytics.FireBaseComponent;
import com.google.firebase.analytics.FirebaseAnalytics;

import io.fabric.sdk.android.Fabric;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeFabricAnalytics();
        initializeFireBaseAnalytics();


    }

    private void initializeFabricAnalytics() {
        FabricComponent.getFabricInstance().initializeFabricComponents(getApplicationContext());
    }
    private void initializeFireBaseAnalytics() {
        FireBaseComponent.getFireBaseAnalyticsInstance(getApplicationContext());
    }

}
