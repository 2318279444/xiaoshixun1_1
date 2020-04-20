package adapter;

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

import com.bumptech.glide.Glide;
import com.bw.dengxianchao20200414.Addnet;
import com.bw.dengxianchao20200414.R;

import java.util.List;

import bean.GwcBean;

public class MuAdapter extends RecyclerView.Adapter<MuAdapter.Holder> {
    String st="http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg";
    List<GwcBean.OrderListBean> list;
    Context context;

    public MuAdapter(List<GwcBean.OrderListBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.bigname.setText(list.get(position).getExpressCompName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyc.setLayoutManager(manager);
        holder.bigrecyc.setAdapter(new small(list.get(position).getDetailList(),position));

        holder.bigcheck.setChecked(list.get(position).isStus());
        holder.bigcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopCall.bigindex(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        CheckBox bigcheck;
        RecyclerView bigrecyc;
        TextView bigname;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigcheck=itemView.findViewById(R.id.bigCheck);
            bigrecyc=itemView.findViewById(R.id.bigrecyc);
            bigname=itemView.findViewById(R.id.bigname);
        }
    }

    public class small extends RecyclerView.Adapter<small.smallHolder>{
        List<GwcBean.OrderListBean.DetailListBean> llist;
        int ind;

        public small(List<GwcBean.OrderListBean.DetailListBean> llist, int ind) {
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
        public void onBindViewHolder(@NonNull smallHolder holder, final int position) {

            final String[] split = st.split(",");
            Glide.with(context).load(split[position]).into(holder.imageView);
            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getCommodityPrice()+"");

            holder.checkBox.setChecked(llist.get(position).isStus());

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean stus = llist.get(position).isStus();
                    shopCall.smallindex(ind,position,stus);
                }
            });

            holder.addnet.setnumber(llist.get(position).getCommodityCount());

            holder.addnet.setAddCall(new Addnet.AddCall() {
                @Override
                public void onClick(int number) {
                    shopCall.addindex(ind,position,number);
                }
            });

        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class smallHolder extends RecyclerView.ViewHolder {
            CheckBox checkBox;
            ImageView imageView;
            TextView name,pri;

            Addnet addnet;
            public smallHolder(@NonNull View itemView) {
                super(itemView);
                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
                addnet=itemView.findViewById(R.id.ad);
            }
        }
    }


    public  interface ShopCall{
        void bigindex(int bigpo);
        void smallindex(int bigpo,int smallpo,boolean stus);
        void addindex(int bigpo,int smallpo,int count);
    }

    public ShopCall shopCall;

    public void setShopCall(ShopCall shopCall){
        this.shopCall=shopCall;
    }


    public void big(int bigpo){
        GwcBean.OrderListBean orderListBean = list.get(bigpo);
        boolean stus = orderListBean.isStus();
        orderListBean.setStus(!stus);
        for (int i = 0; i < list.get(bigpo).getDetailList().size(); i++) {
            if(list.get(bigpo).getDetailList().get(i).setStus(!stus)){
                list.get(bigpo).getDetailList().get(i).setStus(!stus);
            }
        }
    }



    public void small(int bigpo,int smallpo,boolean stus){
        boolean flag=true;

        list.get(bigpo).getDetailList().get(smallpo).setStus(!stus);
        for (int i = 0; i <list.get(bigpo).getDetailList().size() ; i++) {
            if(!list.get(bigpo).getDetailList().get(i).isStus()){
                flag=false;
            }
        }

        list.get(bigpo).setStus(flag);
    }



    public void add(int bigpo,int smallpo,int count){
        list.get(bigpo).getDetailList().get(smallpo).setCommodityCount(count);
    }

    public int sum(){
        int sum=0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getDetailList().size(); j++) {
                if(list.get(i).getDetailList().get(j).isStus()){
                    sum+=list.get(i).getDetailList().get(j).getCommodityCount()*list.get(i).getDetailList().get(j).getCommodityPrice();
                }
            }
        }
        return sum;
    }




}