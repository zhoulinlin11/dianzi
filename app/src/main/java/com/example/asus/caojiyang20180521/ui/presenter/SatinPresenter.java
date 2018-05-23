package com.example.asus.caojiyang20180521.ui.presenter;

import com.example.asus.caojiyang20180521.bean.SatinBean;
import com.example.asus.caojiyang20180521.net.SatinApi;
import com.example.asus.caojiyang20180521.ui.base.BasePresenter;
import com.example.asus.caojiyang20180521.ui.contract.SatinContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/21.
 */

public class SatinPresenter extends BasePresenter<SatinContract.View> implements SatinContract.Presenter {
    private SatinApi satinApi;
    @Inject
    public SatinPresenter(SatinApi satinApi) {
        this.satinApi = satinApi;
    }

    @Override
    public void getSatinBean(int type,int page) {
        satinApi.getSatinApi(type,page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SatinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SatinBean satinBean) {
                        mView.getSatinBeanSuccess(satinBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
