package com.qianfeng.myshoppingapplication.bean;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.qianfeng.myshoppingapplication.MyApp;
import com.qianfeng.myshoppingapplication.R;

/**
 * Created by Administrator on 2016/10/31.
 */

public class MyCustomTabEntity implements CustomTabEntity{

    private String title ;
    public MyCustomTabEntity(int resStringTitle){
        this.title = MyApp.mContext.getResources().getString(resStringTitle);
    }
    @Override
    public String getTabTitle() {
        return null;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
