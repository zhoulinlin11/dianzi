package com.example.asus.caojiyang20180521.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.asus.caojiyang20180521.R;
import com.example.asus.caojiyang20180521.adapter.MyFragmentadapter;
import com.example.asus.caojiyang20180521.ui.fragment.Fragment1;
import com.example.asus.caojiyang20180521.ui.fragment.Fragment2;
import com.example.asus.caojiyang20180521.ui.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class showActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup rg;
    private List<Fragment> list;
    private ViewPager mViewpager;
    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        //fullScreen(this);


        //数据
        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment3());
        list.add(new Fragment3());
        MyFragmentadapter myFragmentadapter = new MyFragmentadapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(myFragmentadapter);
        //监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        viewPager.setCurrentItem(4);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}