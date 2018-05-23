package com.example.asus.caojiyang20180521.component;

import com.example.asus.caojiyang20180521.module.HttpModule;
import com.example.asus.caojiyang20180521.ui.fragment.Fragment1;
import com.example.asus.caojiyang20180521.ui.fragment.Fragment2;

import dagger.Component;

/**
 * Created by asus on 2018/5/21.
 */
@Component(modules= HttpModule.class)
public interface HttpComponent {
    void inject(Fragment1 fragment1) ;
    void inject(Fragment2 fragment2) ;
}
