package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.DdBean;
import com.bawei.month1230.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/9
 *@Time:15:55
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<DdBean.OrderListBean> list;
    Context context;

    public MyAdapter(List<DdBean.OrderListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.big, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bigtextViewid.setText(list.get(position).getOrderId()+"");
        holder.bigtextViewtime.setText(list.get(position).getOrderTime()+"");


        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setAdapter(new small(list.get(position).getDetailList(),position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private TextView bigtextViewid,bigtextViewtime;
        private RecyclerView bigrecyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            bigtextViewid=itemView.findViewById(R.id.bigtextid);
            bigtextViewtime=itemView.findViewById(R.id.bigtexttime);
            bigrecyclerView=itemView.findViewById(R.id.bigRecyclerView);
        }
    }



    public class small extends RecyclerView.Adapter<small.smallHolder>{
        List<DdBean.OrderListBean.DetailListBean> llist;
        int ind;

        public small(List<DdBean.OrderListBean.DetailListBean> llist, int ind) {
            this.llist = llist;
            this.ind = ind;
        }

        @NonNull
        @Override
        public smallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.small, null);
            return new smallHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull smallHolder holder, int position) {
            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getCommodityPrice()+"");
            Glide.with(context).load(llist.get(position).getCommodityPic()).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder{
            private ImageView imageView;
            TextView name,pri;
            public smallHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.image);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }
}
