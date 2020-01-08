package com.bawei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.bean.Shops;
import com.bawei.rikao0107.Addnet;
import com.bawei.rikao0107.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/7
 *@Time:8:50
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<Shops.ResultBean> list;
    Context context;

    public MyAdapter(List<Shops.ResultBean> list, Context context) {
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
        holder.bigtextView.setText(list.get(position).getCategoryName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setLayoutManager(manager);
        holder.bigrecyclerView.setAdapter(new small(list.get(position).getShoppingCartList(),position));


        holder.bigcheckBox.setChecked(list.get(position).isStats());
        holder.bigcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCallBack.bigindex(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        CheckBox bigcheckBox;
        TextView bigtextView;
        RecyclerView bigrecyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigcheckBox=itemView.findViewById(R.id.bigchexk);
            bigtextView=itemView.findViewById(R.id.bigname);
            bigrecyclerView=itemView.findViewById(R.id.bigRecyclerView);
        }
    }


    public class small extends RecyclerView.Adapter<small.smallHolder>{
        List<Shops.ResultBean.ShoppingCartListBean> llist;
        int ind;

        public small(List<Shops.ResultBean.ShoppingCartListBean> llist, int ind) {
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
            holder.name.setText(llist.get(position).getCommodityName());
            holder.count.setText(llist.get(position).getCount()+"");
            holder.pri.setText(llist.get(position).getPrice()+"");

            Glide.with(context).load(llist.get(position).getPic()).error(R.drawable.black_background)
                    .placeholder(R.drawable.black_background)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .into(holder.imageView);


            holder.checkBox.setChecked(llist.get(position).isStats());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean stats = llist.get(position).isStats();
                    shopCallBack.smallindex(ind,position,stats);
                }
            });



            holder.addnet.setnumber(llist.get(position).getCount());
            holder.addnet.setJiajianCall(new Addnet.JiajianCall() {
                @Override
                public void onClick(int number) {
                    shopCallBack.jiajian(ind,position,number);
                }
            });

        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder{
            CheckBox checkBox;
            ImageView imageView;
            TextView name,count,pri;
            Addnet addnet;
            public smallHolder(@NonNull View itemView) {
                super(itemView);

                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.image);
                name=itemView.findViewById(R.id.name);
                count=itemView.findViewById(R.id.count);
                pri=itemView.findViewById(R.id.pri);
                addnet=itemView.findViewById(R.id.jiajianqi);
            }
        }
    }



    public interface ShopCallBack{
        void bigindex(int position);
        void smallindex(int bigposition,int smallposition,boolean stats);
        void jiajian(int bigposition,int smallposition,int count);
    }

    public ShopCallBack shopCallBack;

    public void setShopCallBack(ShopCallBack shopCallBack){
        this.shopCallBack=shopCallBack;
    }


    public void bigindex(int position){
        Shops.ResultBean resultBean = list.get(position);
        boolean stats = resultBean.isStats();
        list.get(position).setStats(!stats);

        for (int i = 0; i < list.get(position).getShoppingCartList().size(); i++) {
            list.get(position).getShoppingCartList().get(i).setStats(!stats);
        }
    }



    public void smallindex(int bigposition,int smallposition,boolean stats){
        boolean flag=true;
        list.get(bigposition).getShoppingCartList().get(smallposition).setStats(!stats);

        for (int i = 0; i < list.get(bigposition).getShoppingCartList().size(); i++) {
            if (!list.get(bigposition).getShoppingCartList().get(i).isStats()){
                flag=false;
            }
        }
        list.get(bigposition).setStats(flag);
        
    }


    public void jiajiancount(int bigposition,int smallposition,int count){
        list.get(bigposition).getShoppingCartList().get(smallposition).setCount(count);
    }

    public int sumprice(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStats()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount()*list.get(i).getShoppingCartList().get(j).getPrice();
                }
            }
        }
        return sum;
    }


    public int sumcount(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStats()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount();
                }
            }
        }
        return sum;
    }
}
