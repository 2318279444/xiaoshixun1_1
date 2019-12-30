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
import com.bawei.week1230.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:10:41
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shop.ResultBean> list;
    Context context;


    public MyAdapter(List<Shop.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getMasterPic())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);
        holder.textView.setText(list.get(position).getCommodityName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
        }
    }



    public interface CallBack {
        void onClick(int position);
    }

    public CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
