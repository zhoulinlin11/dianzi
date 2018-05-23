package com.example.asus.caojiyang20180521.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.asus.caojiyang20180521.R;
import com.example.asus.caojiyang20180521.bean.SatinBean;
import com.example.asus.caojiyang20180521.component.DaggerHttpComponent;
import com.example.asus.caojiyang20180521.module.HttpModule;
import com.example.asus.caojiyang20180521.ui.adapter.XrvAdapter;
import com.example.asus.caojiyang20180521.ui.base.BaseFragment;
import com.example.asus.caojiyang20180521.ui.contract.SatinContract;
import com.example.asus.caojiyang20180521.ui.presenter.SatinPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by asus on 2018/5/21.
 */

public class Fragment1 extends BaseFragment<SatinPresenter> implements SatinContract.View{
    private XRecyclerView xrv;
    private XrvAdapter xrvAdapter;
    @Override
    public int getContentLayout() {
        return R.layout.fr1;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        xrv = view.findViewById(R.id.xrv);
        mPresenter.getSatinBean(3,1);
    }

    @Override
    public void getSatinBeanSuccess(SatinBean satinBean) {
        List<SatinBean.DataBean> data = satinBean.getData();
        //布局样式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        xrv.setLayoutManager(linearLayoutManager);
        //添加Android自带的分割线
        xrv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        //设置适配器
        xrvAdapter = new XrvAdapter(getContext(), data);
        xrv.setAdapter(xrvAdapter);
    }
}
