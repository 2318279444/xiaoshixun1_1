package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Shopbean;
import com.bawei.dengxianchao20200106.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:9:40
 *@Description:
 **/
public class MyShopAdapter extends RecyclerView.Adapter<MyShopAdapter.Holder> {
    List<Shopbean.DataBean> list;
    Context context;
    @BindView(R.id.ima2)
            
    ImageView ima;
    @BindView(R.id.tex2)
    TextView tex;

    public MyShopAdapter(List<Shopbean.DataBean> list, Context context) {
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
        holder.textView.setText(list.get(position).getGoods_name());
        Glide.with(context).load(list.get(position).getGoods_thumb())
                .error(R.drawable.black_background)
                .placeholder(R.drawable.black_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ima2);
            textView=itemView.findViewById(R.id.tex2);
        }
    }
}
