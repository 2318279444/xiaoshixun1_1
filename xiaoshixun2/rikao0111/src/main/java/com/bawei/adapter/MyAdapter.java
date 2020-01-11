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

import com.bawei.bean.Shops;
import com.bawei.rikao0111.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:9:25
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shops.OrderListBean> list;
    Context context;

    public MyAdapter(List<Shops.OrderListBean> list, Context context) {
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
        holder.bigname.setText(list.get(position).getExpressCompName());
        holder.bigtime.setText(list.get(position).getOrderTime()+"");


        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerview.setLayoutManager(manager);
        holder.bigrecyclerview.setAdapter(new small(list.get(position).getDetailList(),position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private TextView bigname,bigtime;

        private RecyclerView bigrecyclerview;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigname=itemView.findViewById(R.id.bigname);
            bigtime=itemView.findViewById(R.id.bigtime);
            bigrecyclerview=itemView.findViewById(R.id.bigrecyclervire);
        }
    }

    public class small extends RecyclerView.Adapter <small.smallHolder> {
        List<Shops.OrderListBean.DetailListBean> llist;
        int ind;

        public small(List<Shops.OrderListBean.DetailListBean> llist, int ind) {
            this.llist = llist;
            this.ind = ind;
        }

        @NonNull
        @Override
        public smallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull smallHolder holder, int position) {
            Glide.with(context).load(llist.get(position).getCommodityPic()).into(holder.imageView);

            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getCommodityPrice()+"");
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

                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }

}
