package com.example.asus.caojiyang20180521.ui.base;

/**
 * Created by asus on 2018/5/21.
 */

public interface BaseContract {
    interface BasePresenter<T extends BaseView> {
        void attchView(T view);

        void detachView();
    }
    interface BaseView{
        void showLoading();

        void dismissLoading();
    }
}
