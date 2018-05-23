package com.example.asus.caojiyang20180521.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.caojiyang20180521.R;
import com.example.asus.caojiyang20180521.bean.SatinBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by asus on 2018/5/21.
 */

public class XrvAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<SatinBean.DataBean> data;

    public XrvAdapter(Context context, List<SatinBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        SatinBean.DataBean dataBean = data.get(position);


        holder1.sim.setImageURI(dataBean.getProfile_image());
        holder1.sim2.setImageURI(dataBean.getProfile_image());
        holder1.text.setText(dataBean.getText()+"");
        holder1.text1.setText(dataBean.getName()+"");
        holder1.text2.setText(dataBean.getPasstime()+"");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private final SimpleDraweeView sim2;
        private final SimpleDraweeView sim;
        private final TextView text;
        private final TextView text1;
        private final TextView text2;
        public ViewHolder(View itemView) {
            super(itemView);
            sim2 = itemView.findViewById(R.id.sim2);
            sim = itemView.findViewById(R.id.sim);
            text = itemView.findViewById(R.id.text);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
        }
    }
    /**
     * 刷新
     * @param templist
     */
    public void refresh(List<SatinBean.DataBean> templist) {
        this.data.clear();
        this.data.addAll(templist);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     * @param list
     */
    public void loadMore(List<SatinBean.DataBean> list) {
        this.data.addAll(list);
        notifyDataSetChanged();
    }

}