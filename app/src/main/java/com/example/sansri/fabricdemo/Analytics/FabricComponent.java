package com.example.sansri.fabricdemo.Analytics;

import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.answers.SearchEvent;

import java.util.HashMap;
import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class FabricComponent {

    private static FabricComponent fabricInstance = null;


    public static FabricComponent getFabricInstance() {
        if (fabricInstance == null) {
            fabricInstance = new FabricComponent();
        }
        return fabricInstance;
    }

    // initialize the Crashlytics
    public void initializeFabricComponents(Context mContext) {
        Fabric.with(mContext, new Crashlytics());
        Fabric.with(mContext, new Answers());
    }

    /**
     * @param eventName is the track events
     * @param map       is Custom Data for an Event
     */

    public void logFabricCustomEventWithData(String eventName, HashMap<String, ?> map) {
        CustomEvent customEvent = new CustomEvent(eventName);
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                customEvent.putCustomAttribute(key, value.toString());
            }
        }
        Answers.getInstance().logCustom(customEvent);
    }

    public void logFabricCustomEvent(String eventName) {
        CustomEvent customEvent = new CustomEvent(eventName);
        Answers.getInstance().logCustom(customEvent);
    }

    /**
     * @param searchItem is tracking
     */
    public void logSearchEvent(String searchItem) {
        Answers.getInstance().logSearch(new SearchEvent().putQuery(searchItem));
    }

    public void logUser(String identifier, String email, String userName) {
        Crashlytics.setUserIdentifier(identifier);
        Crashlytics.setUserEmail(email);
        Crashlytics.setUserName(userName);
    }

}
