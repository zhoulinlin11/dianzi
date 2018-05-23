package com.example.asus.caojiyang20180521.module;

import com.example.asus.caojiyang20180521.net.SatinApi;
import com.example.asus.caojiyang20180521.net.SatinApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus on 2018/5/21.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder provideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);
    }
    @Provides
    SatinApi provideSatinApi(OkHttpClient.Builder builder){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        SatinApiService satinApiService = retrofit.create(SatinApiService.class);
        return  SatinApi.getSatinApi(satinApiService);

    }
}
