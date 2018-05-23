package com.example.asus.caojiyang20180521.ui.base;

/**
 * Created by asus on 2018/5/21.
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    //抽取公共方法
    protected T mView;
    @Override
    public void attchView(T view) {
        if (view!=null) {
            this.mView = view;
        }
    }

    @Override
    public void detachView() {
        if (mView!=null){
            mView=null;
        }
    }
}
