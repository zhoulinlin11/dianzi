package com.example.asus.caojiyang20180521.ui.contract;

import com.example.asus.caojiyang20180521.bean.SatinBean;
import com.example.asus.caojiyang20180521.ui.base.BaseContract;

/**
 * Created by asus on 2018/5/21.
 */

public interface SatinContract {
    interface View extends BaseContract.BaseView{
        void getSatinBeanSuccess(SatinBean satinBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getSatinBean(int type,int page);
    }
}
