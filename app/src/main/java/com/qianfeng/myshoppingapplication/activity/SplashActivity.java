package com.qianfeng.myshoppingapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.qianfeng.myshoppingapplication.MainActivity;
import com.qianfeng.myshoppingapplication.MyApp;
import com.qianfeng.myshoppingapplication.R;

public class SplashActivity extends AppCompatActivity {

    private TextView textView;
    private int totalTime =3;
    private Handler mHandler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = ((TextView) findViewById(R.id.text_splash));

        startClock();
    }

    private void startClock() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(totalTime>=0){
                    textView.setText(totalTime+"秒");
                    totalTime--;
                   mHandler.postDelayed(this,1000);
                }else {
                    textView.setText("");
                    //判断进入主界面还是引导页
                    if(MyApp.firstLogin()){
                        Intent intent =new Intent(SplashActivity.this,GuideActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent =new Intent(SplashActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    finish();
                }

            }
        },1000);
    }
}
