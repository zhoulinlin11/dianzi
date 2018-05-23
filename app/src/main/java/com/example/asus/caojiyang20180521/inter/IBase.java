package com.example.asus.caojiyang20180521.inter;

import android.view.View;

/**
 * Created by asus on 2018/5/21.
 */

public interface IBase {
    int getContentLayout();
    void inject();

    void initView(View view);
}
