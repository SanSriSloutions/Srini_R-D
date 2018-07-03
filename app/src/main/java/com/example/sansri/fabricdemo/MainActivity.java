package com.example.sansri.fabricdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sansri.fabricdemo.Analytics.FabricComponent;
import com.example.sansri.fabricdemo.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding activityMainBinding;
FabricComponent fabricComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initviews();
    }

    private void initviews() {
        fabricComponent=FabricComponent.getFabricInstance();
        activityMainBinding.btnTrackEvent.setOnClickListener(this);
        activityMainBinding.btnTrackEventWithData.setOnClickListener(this);
        activityMainBinding.btSearch.setOnClickListener(this);
        fabricComponent.logUser("111","surya.nitk@gmail.com","Surya");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_search:
                fabricComponent.logSearchEvent("Srinivas");
                break;
            case R.id.btn_trackEvent:
                fabricComponent.logFabricCustomEvent("trackingSample");
                break;

            case R.id.btn_trackEvent_with_data:
                HashMap map=new HashMap<>();
                map.put("userName","Surya");
                map.put("Id",200);
                map.put("marks",200.05);
                fabricComponent.logFabricCustomEventWithData("trackingSampleData",map);
                break;
        }
    }
}
