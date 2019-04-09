package com.example.xueshang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
/**
 * Created by asus on 2018/8/14.
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

//更好地知晓自己在哪一个活动