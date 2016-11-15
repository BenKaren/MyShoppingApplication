package com.qianfeng.myshoppingapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.qianfeng.myshoppingapplication.fragment.DrawerFragment;
import com.qianfeng.myshoppingapplication.fragment.TodayFragment;

public class MainActivity extends SlidingFragmentActivity {

    private ImageView slideImage;
    private ImageView setImage;
    private DrawerLayout drawLayout;
    private CommonTabLayout tabLayout;

    private TodayFragment todayFragment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       slideImage = ((ImageView) findViewById(R.id.select_iamge));
        setImage = ((ImageView) findViewById(R.id.set_image));
        //添加第三方框架进行侧滑

        SlidingMenu menu =getSlidingMenu();
          DrawerFragment drawerFragment =new DrawerFragment();
        //setBehindContentView(R.layout.fragment_drawer);
        View slidingView = getLayoutInflater().inflate(R.layout.fragment_drawer, null);
        LinearLayout todayLL = (LinearLayout) slidingView.findViewById(R.id.today);
        todayLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "today clicked", Toast.LENGTH_SHORT).show();
            }
        });
        setBehindContentView(slidingView);
//          getSupportFragmentManager().beginTransaction().replace(R.id.fagment_drawer,drawerFragment)
//              .commit();
        menu.setMode(SlidingMenu.LEFT);
        //设置触摸屏的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidth(R.dimen.activity_sliding_width);
        menu.setBehindOffsetRes(R.dimen.activity_shadow_width);

        menu.setFadeDegree(0.35f);
        menu.setMenu(R.layout.fragment_drawer);
        menu.showMenu();
        menu.showContent();

        //设置tabLayout
      //  tabLayout = ((CommonTabLayout) findViewById(R.id.tab_layout));

    }
}
