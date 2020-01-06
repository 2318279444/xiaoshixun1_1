package com.bawei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.FenleiBean;
import com.bawei.week_0103_2.R;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:11:27
 *@Description:
 **/
public class MyFenleiAdapter extends RecyclerView.Adapter<MyFenleiAdapter.Holder> {
    List<FenleiBean.ResultBean.SecondCategoryVoBean> list;
    Context context;
    private int liposition;

    public MyFenleiAdapter(List<FenleiBean.ResultBean.SecondCategoryVoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.textView.setText(list.get(position).getName());

        if(liposition==position){
            holder.textView.setTextColor(Color.RED);
        }else {
            holder.textView.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenleiCallBack.onclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tex1);
        }
    }


    public interface FenleiCallBack{
        void onclick(int position);
    }

    public FenleiCallBack fenleiCallBack;

    public void setFenleiCallBack(FenleiCallBack fenleiCallBack){
        this.fenleiCallBack=fenleiCallBack;
    }

    public void setColorposition(int position){
        this.liposition=position;

        notifyDataSetChanged();
    }
}
