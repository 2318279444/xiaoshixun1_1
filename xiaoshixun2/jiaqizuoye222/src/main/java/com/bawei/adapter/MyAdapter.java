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
import com.bawei.jiaqizuoye222.Addnet;
import com.bawei.jiaqizuoye222.R;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/26
 *@Time:14:12
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

        holder.bigcheckBox.setChecked(list.get(position).isStu());
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
        private TextView bigtextView;
        private CheckBox bigcheckBox;
        private RecyclerView bigrecyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigtextView=itemView.findViewById(R.id.bigname);
            bigcheckBox=itemView.findViewById(R.id.bigche);
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
            Glide.with(context).load(llist.get(position).getPic()).into(holder.imageView);

            holder.name.setText(llist.get(position).getCommodityName());
            holder.count.setText(llist.get(position).getCount()+"");
            holder.pri.setText(llist.get(position).getPrice()+"");

            holder.checkBox.setChecked(llist.get(position).isStu());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean stu = llist.get(position).isStu();
                    shopCallBack.smallidnex(ind,position,stu);
                }
            });


            holder.addnet.setnumbet(llist.get(position).getCount());

            holder.addnet.setAddCall(new Addnet.AddCall() {
                @Override
                public void onClick(int number) {
                    shopCallBack.addin(ind,position,number);
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
            private TextView name,count,pri;
            private Addnet addnet;

            public smallHolder(@NonNull View itemView) {
                super(itemView);
                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                count=itemView.findViewById(R.id.count);
                pri=itemView.findViewById(R.id.pri);
                addnet=itemView.findViewById(R.id.adn);
            }
        }
    }


    public interface ShopCallBack{
        void bigindex(int bigposition);
        void smallidnex(int bigposition,int smallposition,boolean stuuuu);
        void addin(int bigposition,int smallposition,int count);
    }

    public ShopCallBack shopCallBack;

    public void setShopCallBack(ShopCallBack shopCallBack){
        this.shopCallBack=shopCallBack;
    }



    public void bigCallBack(int position){
        Shops.ResultBean resultBean = list.get(position);
        boolean stu = resultBean.isStu();
        resultBean.setStu(!stu);
        for (int i = 0; i < list.get(position).getShoppingCartList().size(); i++) {
            list.get(position).getShoppingCartList().get(i).setStu(!stu);
        }
    }


    public void smallCallBack(int bigposition,int smallposition,boolean stuuuu){
        boolean flag=true;
        list.get(bigposition).getShoppingCartList().get(smallposition).setStu(!stuuuu);
        for (int i = 0; i < list.get(bigposition).getShoppingCartList().size(); i++) {
            if(!list.get(bigposition).getShoppingCartList().get(i).isStu()){
                flag=false;
            }
        }
        list.get(bigposition).setStu(flag);
    }

    public void addCallAdapter(int bigposition,int smallposition,int count){
        list.get(bigposition).getShoppingCartList().get(smallposition).setCount(count);
    }

    public int sumc(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStu()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount();
                }
            }
        }
        return sum;
    }

    public int sump(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isStu()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount()*list.get(i).getShoppingCartList().get(j).getPrice();
                }
            }
        }
        return sum;
    }
}
