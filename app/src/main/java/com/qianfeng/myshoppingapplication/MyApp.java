package com.qianfeng.myshoppingapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/10/31.
 */

public class MyApp extends Application{

    public static Context mContext;
    //定义shareprfs的存储根路径
    private static final String ROOT_SHAREDPRES_PATH="";
    private static final String SHAREPREFS_FILE_NAME="shoppingConfig";
    public static SharedPreferences sharedPreferences;
    //第一次登录时key的名字
    private static final String KEY_FIRST_LOGIN ="firstLogin";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        initPrefs();
    }

    private void initPrefs() {
        sharedPreferences = mContext.getSharedPreferences(SHAREPREFS_FILE_NAME,MODE_PRIVATE);
    }

    public static boolean firstLogin(){
        boolean value = sharedPreferences.getBoolean(KEY_FIRST_LOGIN, true);
        if(value){
            sharedPreferences.edit().putBoolean(KEY_FIRST_LOGIN,false).apply();
        }
        return value;
    }
}
