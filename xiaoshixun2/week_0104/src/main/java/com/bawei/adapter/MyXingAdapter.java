package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Xiangbean;
import com.bawei.week_0104.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:10:42
 *@Description:
 **/
public class MyXingAdapter extends RecyclerView.Adapter<MyXingAdapter.Holder> {
    List<Xiangbean.ResultBean> list;
    Context context;

    public MyXingAdapter(List<Xiangbean.ResultBean> list, Context context) {
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
        Glide.with(context).load(list.get(position).getMasterPic())
                .error(R.drawable.black_background)
                .placeholder(R.drawable.black_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);

        holder.textView.setText(list.get(position).getCommodityName());
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

            imageView=itemView.findViewById(R.id.ima2);
            textView=itemView.findViewById(R.id.tex2);
        }
    }
}
