package com.example.sansri.fcmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    Button btnReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        btnReport=findViewById(R.id.btn_report);
        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             getFloatingString("");
            }
        });
    }

    public static String getFloatingString(String price) {
        price="";
        //LogUtils.LOGD("AppUtils", "OriginalPrice:"+price);
        if (price == null) return "";
        price = price.replaceAll(",", "");
//        String floatPrice= String.format(Locale.US, "%.2f", Float.parseFloat(price));

//        DecimalFormat formatter = new DecimalFormat("#,##,##,##0.00");
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,##,##,##0.00");

        String formattedPrice = formatter.format(Double.parseDouble(price));

        //LogUtils.LOGD("AppUtils", "FormattedPrice:"+formattedPrice);
        return formattedPrice;
    }

}
