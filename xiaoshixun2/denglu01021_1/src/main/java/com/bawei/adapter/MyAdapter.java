package com.bawei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.base.Shops;
import com.bawei.denglu01021_1.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/8
 *@Time:19:39
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shops.ResultBean> list;
    Context context;

    public MyAdapter(List<Shops.ResultBean> list, Context context) {
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
        holder.bigtextView.setText(list.get(position).getCategoryName());
        Log.e("aaa","big"+list.get(position).getCategoryName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setLayoutManager(manager);
        holder.bigrecyclerView.setAdapter(new small(list.get(position).getShoppingCartList(),position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private CheckBox bigcheckBox;
        private TextView bigtextView;
        private RecyclerView bigrecyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigcheckBox=itemView.findViewById(R.id.bigcheck);
            bigtextView=itemView.findViewById(R.id.bigname);
            bigrecyclerView=itemView.findViewById(R.id.bigRecyclerView);
        }
    }


    public class small extends RecyclerView.Adapter <small.smallHolder>{
        List<Shops.ResultBean.ShoppingCartListBean> llist;
        int ind;

        public small(List<Shops.ResultBean.ShoppingCartListBean> llist, int ind) {
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
            holder.count.setText(llist.get(position).getCount()+"");
            holder.pri.setText(llist.get(position).getPrice()+"");

            Glide.with(context).load(llist.get(position).getPic())
                    .error(R.drawable.black_background)
                    .placeholder(R.drawable.black_background)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder{
            private CheckBox checkBox;
            ImageView imageView;
            TextView name,count,pri;

            public smallHolder(@NonNull View itemView) {
                super(itemView);
                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.imag);
                name=itemView.findViewById(R.id.name);
                count=itemView.findViewById(R.id.count);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }
}
