package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Xinxi;
import com.bawei.dengxianchao20191231.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:9:00
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Xinxi.RankingBean> list;
    Context context;

    public MyAdapter(List<Xinxi.RankingBean> list, Context context) {
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
        holder.textViewrank.setText(list.get(position).getRank()+"");
        holder.textViewname.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getAvatar())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onclick(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        public TextView textViewrank,textViewname;
        public ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textViewname=itemView.findViewById(R.id.text2);
            textViewrank=itemView.findViewById(R.id.text1);
            imageView=itemView.findViewById(R.id.image);
        }
    }


    public interface  CallBack{
        void onclick(int position);
    }

    public CallBack callBack;

    public void setCallBack(CallBack callBack){
        this.callBack=callBack;
    }
}
