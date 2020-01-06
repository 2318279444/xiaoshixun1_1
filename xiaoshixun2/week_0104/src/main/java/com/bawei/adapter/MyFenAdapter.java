package com.bawei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Fenbean;
import com.bawei.week_0104.R;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:9:42
 *@Description:
 **/
public class MyFenAdapter extends RecyclerView.Adapter<MyFenAdapter.Holder> {
    List<Fenbean.ResultBean.SecondCategoryVoBean> list;
    Context context;
    private int liposition=0;

    public MyFenAdapter(List<Fenbean.ResultBean.SecondCategoryVoBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(list.get(position).getName());

        if(liposition==position){
            holder.textView.setTextColor(Color.RED);
        }else {
            holder.textView.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenCallBack.onClick(position);
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

    public interface FenCallBack{
        void onClick(int position);
    }

    public FenCallBack fenCallBack;

    public void setFenCallBack(FenCallBack fenCallBack){
        this.fenCallBack=fenCallBack;
    }

    public void setColorposition(int position){
        this.liposition=position;
        notifyDataSetChanged();
    }
}
