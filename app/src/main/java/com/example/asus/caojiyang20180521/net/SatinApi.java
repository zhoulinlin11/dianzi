package com.example.asus.caojiyang20180521.net;

import com.example.asus.caojiyang20180521.bean.SatinBean;

import io.reactivex.Observable;

/**
 * Created by asus on 2018/5/21.
 */

public class SatinApi {
    private static SatinApi satinApi;
    private SatinApiService satinApiService;

    private SatinApi (SatinApiService satinApiService){
        this.satinApiService=satinApiService;
    }
    public  static  SatinApi getSatinApi(SatinApiService satinApiService){
        if (satinApi==null){
            satinApi=new SatinApi(satinApiService);
        }
        return satinApi;
    }
    public Observable<SatinBean> getSatinApi(int type,int page){
        return satinApiService.getSatinApi(type,page);
    }
}
