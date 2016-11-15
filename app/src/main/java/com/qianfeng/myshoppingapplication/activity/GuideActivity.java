package com.qianfeng.myshoppingapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.qianfeng.myshoppingapplication.MainActivity;
import com.qianfeng.myshoppingapplication.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager viewPager;

    //定义viewpager所需要存放的视图
    List<View> views =new ArrayList<>();
    private CirclePageIndicator indicator;
    private Button enterButton;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mContext=this;
        viewPager = ((ViewPager) findViewById(R.id.pager_guide));
        indicator = ((CirclePageIndicator) findViewById(R.id.vp_indicator));
        enterButton = ((Button) findViewById(R.id.enter_btn));
        initData();

       GuideAdapter adapter =new GuideAdapter();
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
               GuideActivity.this.finish();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                     enterButton.setVisibility(View.GONE);
                        break;

                    case 1:
                        enterButton.setVisibility(View.GONE);
                        break;

                    case 2:
                        enterButton.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        int[] pictures ={R.mipmap.guide1,R.mipmap.guide2,R.mipmap.guide3};
        for (int i = 0; i < pictures.length; i++) {
            ImageView imageView =new ImageView(this);
            imageView.setImageResource(pictures[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            views.add(imageView);
        }

    }

    class GuideAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }
}
