package com.bawei.adapter;

import android.content.Context;
import android.util.Log;
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
import com.bawei.jiaqizuoye111.Addnet;
import com.bawei.jiaqizuoye111.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:54
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
        View view = LayoutInflater.from(context).inflate(R.layout.big1, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bigtextView.setText(list.get(position).getCategoryName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setLayoutManager(manager);
        holder.bigrecyclerView.setAdapter(new small(list.get(position).getShoppingCartList(),position));

        holder.bigcheckBox.setChecked(list.get(position).getStau());
        Log.e("aaa","bool"+list.get(position).getStau());
        holder.bigcheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCallBack.bindex(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private CheckBox bigcheckBox;
        private TextView bigtextView;
        private RecyclerView bigrecyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigcheckBox=itemView.findViewById(R.id.bche);
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
            Glide.with(context).load(llist.get(position).getPic())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .error(R.drawable.black_background)
                    .placeholder(R.drawable.black_background)
                    .into(holder.imageView);


            holder.checkBox.setChecked(llist.get(position).getStau());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean stau = llist.get(position).getStau();
                    shopCallBack.smallindex(ind,position,stau);
                }
            });


            holder.addnet.setnumber(llist.get(position).getCount());
            holder.addnet.setAddCallBack(new Addnet.AddCallBack() {
                @Override
                public void onClick(int number) {
                    shopCallBack.addcount(ind,position,number);
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
            private TextView name,count ,pri;
            private Addnet addnet;
            public smallHolder(@NonNull View itemView) {
                super(itemView);
                addnet=itemView.findViewById(R.id.add);
                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                count=itemView.findViewById(R.id.count);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }



    public interface ShopCallBack{
        void bindex(int position);
        void smallindex(int bigindex,int smallindex,boolean status);
        void addcount(int bigindex,int smallindex,int count);
    }

    public ShopCallBack shopCallBack;

    public void setShopCallBack(ShopCallBack shopCallBack){
        this.shopCallBack=shopCallBack;
    }

    public void bigCallBack(int position){
        Shops.ResultBean resultBean = list.get(position);
        Boolean stadus = resultBean.getStau();
        resultBean.setStau(!stadus);
        for (int i = 0; i < list.get(position).getShoppingCartList().size(); i++) {
            list.get(position).getShoppingCartList().get(i).setStau(!stadus);
        }
    }
    public void smallCallBack(int bigindex,int smallindex,boolean status){
        boolean flag=true;
        list.get(bigindex).getShoppingCartList().get(smallindex).setStau(!status);
            for (int i = 0; i < list.get(bigindex).getShoppingCartList().size(); i++) {
                if(!list.get(bigindex).getShoppingCartList().get(i).getStau()){
                    flag=false;
            }
        }
        list.get(bigindex).setStau(flag);
    }

    public void addCallBack(int bigindex,int smallindex,int count){
        list.get(bigindex).getShoppingCartList().get(smallindex).setCount(count);
    }



    public int setCount(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).getStau()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount();
                }
            }
        }
        return sum;
    }

    public int setpri(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).getStau()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount()*list.get(i).getShoppingCartList().get(j).getPrice();
                }
            }
        }
        return sum;
    }

}
