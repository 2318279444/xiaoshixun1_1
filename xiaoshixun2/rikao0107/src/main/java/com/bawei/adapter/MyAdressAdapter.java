package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Adressbean;
import com.bawei.rikao0107.R;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/9
 *@Time:8:59
 *@Description:
 **/
public class MyAdressAdapter extends RecyclerView.Adapter<MyAdressAdapter.Holder> {
    List<Adressbean.ResultBean> list;
    Context context;

    public MyAdressAdapter(List<Adressbean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adressitem, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getRealName());
        holder.phone.setText(list.get(position).getPhone()+"");
        holder.adr.setText(list.get(position).getAddress());
        holder.yb.setText(list.get(position).getZipCode()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private TextView name,phone,adr,yb;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            phone=itemView.findViewById(R.id.phone);
            adr=itemView.findViewById(R.id.adr);
            yb=itemView.findViewById(R.id.yb);
        }
    }
}
