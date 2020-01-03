package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Shop;
import com.bawei.rikao0102.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:8:46
 *@Description:
 **/
public class MypzshAdapter extends RecyclerView.Adapter<MypzshAdapter.Holder> {
    List<Shop.ResultBean.PzshBean.CommodityListBeanX> list;
    Context context;

    public MypzshAdapter(List<Shop.ResultBean.PzshBean.CommodityListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(list.get(position).getCommodityName());
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.rxxpimage);
            textView=itemView.findViewById(R.id.rxxptext);
        }
    }
}
