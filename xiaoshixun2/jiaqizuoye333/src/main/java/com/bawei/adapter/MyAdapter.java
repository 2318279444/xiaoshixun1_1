package com.bawei.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Shops;
import com.bawei.rikao0111.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.math.RoundingMode;
import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:9:25
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shops.OrderListBean> list;
    Context context;
    String st="http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg";

    public MyAdapter(List<Shops.OrderListBean> list, Context context) {
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
        holder.bigname.setText(list.get(position).getExpressCompName());
        holder.bigtime.setText(list.get(position).getOrderTime()+"");

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerview.setLayoutManager(manager);
        holder.bigrecyclerview.setAdapter(new small(list.get(position).getDetailList(),position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private TextView bigname,bigtime,bigcount,bigpri;

        private RecyclerView bigrecyclerview;
        public Holder(@NonNull View itemView) {
            super(itemView);
//            bigcount=itemView.findViewById(R.id.bigcount);
//            bigpri=itemView.findViewById(R.id.bigpri);
            bigname=itemView.findViewById(R.id.bigname);
            bigtime=itemView.findViewById(R.id.bigtime);
            bigrecyclerview=itemView.findViewById(R.id.bigrecyclervire);
        }
    }

    public class small extends RecyclerView.Adapter <small.smallHolder> {
        List<Shops.OrderListBean.DetailListBean> llist;
        int ind;

        public small(List<Shops.OrderListBean.DetailListBean> llist, int ind) {
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
            String[] split = st.split(",");



                Glide.with(context).load(split[position])
                        .error(R.drawable.black_background)
                        .placeholder(R.drawable.black_background)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                        .into(holder.imageView);



            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getCommodityPrice()+"");





        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder{
          ImageView imageView;
            TextView name,pri;
            public smallHolder(@NonNull View itemView) {
                super(itemView);

                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }


    public interface ShopCallBack{
        void onclick(int position);
    }

    public ShopCallBack shopCallBack;

    public void setShopCallBack(ShopCallBack shopCallBack){
        this.shopCallBack=shopCallBack;
    }



//    public int sumc(){
//        Log.e("aaa","Aaa");
//        int sum=0;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).getDetailList().size(); j++) {
//                sum+=list.get(i).getDetailList().get(j).getCommodityCount();
//                Log.e("bbb","sum:"+sum);
//            }
//        }
//        return sum;
//    }
//
//    public int sump(){
//        int sum=0;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).getDetailList().size(); j++) {
//                sum+=list.get(i).getDetailList().get(j).getCommodityCount()*list.get(i).getDetailList().get(j).getCommodityPrice();
//            }
//        }
//        return sum;
//    }



}
