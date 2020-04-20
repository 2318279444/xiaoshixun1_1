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
import com.bw.dayi_yuekao.Addnet;
import com.bw.dayi_yuekao.R;

import java.util.List;

import bean.GwcBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<GwcBean.OrderListBean> list;
    Context context;

    public MyAdapter(List<GwcBean.OrderListBean> list, Context context) {
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
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setAdapter(new small(list.get(position).getDetailList(),position));


        holder.bigCheck.setChecked(list.get(position).isStus());

        holder.bigCheck.setOnClickListener(new View.OnClickListener() {
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
        CheckBox bigCheck;
        RecyclerView recyclerView;
        TextView bigname;
        RecyclerView bigrecyc;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bigname=itemView.findViewById(R.id.Bigname);
            bigCheck=itemView.findViewById(R.id.BigCheck);
            recyclerView=itemView.findViewById(R.id.Bigrecyc);
        }
    }





    public class small extends RecyclerView.Adapter<small.smallHolder>{
        String st="http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg";

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
            holder.count.setText(llist.get(position).getCommodityCount()+"");
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
                    shopCall.addnetA(ind,position,number);
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
                name=itemView.findViewById(R.id.name);
                addnet=itemView.findViewById(R.id.ad);
                checkBox=itemView.findViewById(R.id.check);
                imageView=itemView.findViewById(R.id.ima);
                count=itemView.findViewById(R.id.count);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }



    public interface ShopCall{
        void bigindex(int bigpo);

        void smallindex(int bigpo,int smallpo,boolean stus);

        void addnetA(int bigpo,int smallpo,int count);
    }

    public ShopCall shopCall;

    public void setShopCall(ShopCall shopCall){
        this.shopCall=shopCall;
    }


    public void setBig(int bigpo){
        GwcBean.OrderListBean orderListBean = list.get(bigpo);
        boolean stus = orderListBean.isStus();
        orderListBean.setStus(!stus);
        for (int i = 0; i < list.get(bigpo).getDetailList().size(); i++) {
            list.get(bigpo).getDetailList().get(i).setStus(!stus);
        }
    }

    public void setsmall(int bigpo,int smallpo,boolean stus){
        boolean flag=true;
        list.get(bigpo).getDetailList().get(smallpo).setStus(!stus);
        for (int i = 0; i < list.get(bigpo).getDetailList().size(); i++) {
            if(!list.get(bigpo).getDetailList().get(i).isStus()){
                flag=false;
            }
        }
        list.get(bigpo).setStus(flag);
    }

    public void addnet(int bigpo,int smallpo,int count){
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
