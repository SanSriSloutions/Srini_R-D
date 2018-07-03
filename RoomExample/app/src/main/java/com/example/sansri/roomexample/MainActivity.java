package com.example.sansri.roomexample;

import android.arch.persistence.room.RoomDatabase;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sansri.roomexample.database.AppDataBase;
import com.example.sansri.roomexample.database.entities.Repo;
import com.example.sansri.roomexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        activityMainBinding.btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String name = "";
        String url = "";
        Repo repo = new Repo(1, name, url);

        AppDataBase.getInstance(getApplicationContext()).getRepoDao().insert(repo);
        activityMainBinding.tvName.setText("name : ".concat(activityMainBinding.evUserName.getText().toString()));
        activityMainBinding.tvUrl.setText("url : ".concat(activityMainBinding.evUrl.getText().toString()));
    }
}
