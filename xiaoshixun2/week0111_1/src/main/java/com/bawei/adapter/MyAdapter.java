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

import com.bawei.bean.ShopBean;
import com.bawei.week0111_1.Addnet;
import com.bawei.week0111_1.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:10:33
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<ShopBean.ResultBean> list;
    Context context;

    public MyAdapter(List<ShopBean.ResultBean> list, Context context) {
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




        /////////////////////////最外层全选,商家商品联动


        holder.bigcheckBox.setChecked(list.get(position).isStadus());
        holder.bigcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCallBack.bigindex(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        if (list!=null){

            return list.size();
        }
        return 0;

    }

    class Holder extends RecyclerView.ViewHolder{
        private CheckBox bigcheckBox;
        private TextView bigtextView;
        private RecyclerView bigrecyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            bigrecyclerView=itemView.findViewById(R.id.bigRecyclerView);
            bigtextView=itemView.findViewById(R.id.bigname);
            bigcheckBox=itemView.findViewById(R.id.bigcheck);
        }
    }


    public class small extends RecyclerView.Adapter<small.smallHolder>{
        List<ShopBean.ResultBean.ShoppingCartListBean> llist;
        int ind;

        public small(List<ShopBean.ResultBean.ShoppingCartListBean> llist, int ind) {
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
            holder.pri.setText(llist.get(position).getPrice()+"");
            holder.count.setText(llist.get(position).getCount()+"");

            Glide.with(context).load(llist.get(position).getPic())
                    .error(R.drawable.black_background)
                    .placeholder(R.drawable.black_background)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .into(holder.imageView);

            holder.checkBox.setChecked(llist.get(position).isStadus());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean stadus = llist.get(position).isStadus();
                    shopCallBack.samllindex(ind,position,stadus);
                    notifyDataSetChanged();
                }
            });


            holder.addnet.setnumber(llist.get(position).getCount());
            holder.addnet.setJiajianqi(new Addnet.Jiajianqi() {
                @Override
                public void onClick(int number) {
                    shopCallBack.addindex(ind,position,number);
                }
            });



        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder{
            private CheckBox checkBox;
            private ImageView imageView;
            private TextView name,pri,count;
            private Addnet addnet;
            public smallHolder(@NonNull View itemView) {
                super(itemView);
                addnet=itemView.findViewById(R.id.addnet);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
                count=itemView.findViewById(R.id.count);
                imageView=itemView.findViewById(R.id.ima);
                checkBox=itemView.findViewById(R.id.check);

            }
        }
    }









    public interface ShopCallBack{
        void bigindex(int bigindex);
        void samllindex(int bigindex,int smallindex,boolean stadus);
        void addindex(int bigindex,int smallindex,int count);
    }

    public ShopCallBack shopCallBack;

    public void setShopCallBack(ShopCallBack shopCallBack){
        this.shopCallBack=shopCallBack;
    }


    public void bigindexCallBack(int position){
        ShopBean.ResultBean resultBean = list.get(position);
        boolean stadus = resultBean.isStadus();
        resultBean.setStadus(!stadus);
        for (int i = 0; i < list.get(position).getShoppingCartList().size(); i++) {
            list.get(position).getShoppingCartList().get(i).setStadus(!stadus);
        }

    }



    public void smallindexCallBack(int bigindex,int smallindex ,boolean stads){
        boolean flag=true;
        list.get(bigindex).getShoppingCartList().get(smallindex).setStadus(!stads);
        for (int i = 0; i < list.get(bigindex).getShoppingCartList().size(); i++) {
            if(!list.get(bigindex).getShoppingCartList().get(i).isStadus()){
                flag=false;
            }
        }

        list.get(bigindex).setStadus(flag);
    }



    public void addindexCallBack(int bigindex,int smallindex,int count){
        list.get(bigindex).getShoppingCartList().get(smallindex).setCount(count);
    }


    public int sumcount(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStadus()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount();
                }
            }
        }
        return sum;
    }





    public int sumprice(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStadus()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount()*list.get(i).getShoppingCartList().get(j).getPrice();
                }
            }
        }
        return sum;
    }


}
