package com.example.asus.caojiyang20180521.net;

import com.example.asus.caojiyang20180521.bean.SatinBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/5/21.
 */

public interface SatinApiService {
    @GET("satinApi")
    Observable<SatinBean> getSatinApi(@Query("type") int type,@Query("page") int page);
}
