package com.bawei.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Catebean;
import com.bawei.dengxianchao20200106.R;

import java.util.List;

import butterknife.BindView;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:9:02
 *@Description:
 **/
public class MyCateAdapter extends RecyclerView.Adapter<MyCateAdapter.Holder> {
    List<String> list;
    Context context;
    int liposition=0;


    public MyCateAdapter(List<String> list, Context context) {
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
        holder.textView.setText(list.get(position));

        if (liposition==position){
            holder.textView.setTextColor(Color.RED);
        }else {
            holder.textView.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cateCallBack.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tex1);
        }
    }

    public interface CateCallBack{
        void onClick(int position);
    }

    public CateCallBack cateCallBack;

    public void setCateCallBack(CateCallBack cateCallBack){
        this.cateCallBack=cateCallBack;
    }

    public void setColor(int position){
        this.liposition=position;
        notifyDataSetChanged();
    }
}
