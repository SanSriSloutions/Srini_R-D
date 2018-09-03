package com.example.sansri.fabricdemo.Analytics;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;
import java.util.Map;

public class FireBaseComponent {
    private static FireBaseComponent mFireBaseComp;
    private static final long MIN_SESSION_DURATION = 5000; // default is 10000//10 sec
    private static final long SESSION_TIME_OUT_DURATION = 1000000;
    private static FirebaseAnalytics mFireBaseAnalytics;


    public static FireBaseComponent getFireBaseAnalyticsInstance(Context mContext) {
        if (mFireBaseComp == null) {
            mFireBaseAnalytics = FirebaseAnalytics.getInstance(mContext);
            mFireBaseComp=new FireBaseComponent();
        }
        return mFireBaseComp;
    }

    /**
     * Set the fireBase Analytics Properties
     */
    public void setFireBaseProperties() {
        mFireBaseAnalytics.setAnalyticsCollectionEnabled(true);
        mFireBaseAnalytics.setMinimumSessionDuration(MIN_SESSION_DURATION);
        mFireBaseAnalytics.setSessionTimeoutDuration(SESSION_TIME_OUT_DURATION);
    }

    public void logUserProperties(HashMap<String, ?> map) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            mFireBaseAnalytics.setUserProperty(key, value.toString());
        }
    }

    public void logUserProperty(String key, Object value) {
        mFireBaseAnalytics.setUserProperty(key, value.toString());
    }

    public void logEvent(String eventName, Bundle bundle) {
        mFireBaseAnalytics.logEvent(eventName, bundle);
    }


    // public void logEvent
}
