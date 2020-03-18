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

import com.bawei.jiaqizuoye2020_03_14.Addnet;
import com.bawei.jiaqizuoye2020_03_14.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import bean.ShopBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/14
 *@Time:10:31
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
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.namebig.setText(list.get(position).getCategoryName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.recyclerViewbig.setLayoutManager(manager);
        holder.recyclerViewbig.setAdapter(new Small(list.get(position).getShoppingCartList(),position));

        holder.checkbig.setChecked(list.get(position).isZhuangtai());

        holder.checkbig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toShopCall.bigindex(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView namebig;
        RecyclerView recyclerViewbig;
        CheckBox checkbig;
        public Holder(@NonNull View itemView) {
            super(itemView);
            namebig=itemView.findViewById(R.id.namebig);
            checkbig=itemView.findViewById(R.id.checkbig);
            recyclerViewbig=itemView.findViewById(R.id.recycbig);
        }
    }


    public class Small extends RecyclerView.Adapter<Small.Holder>{
        List<ShopBean.ResultBean.ShoppingCartListBean> llist;
        int ind;

        public Small(List<ShopBean.ResultBean.ShoppingCartListBean> llist, int ind) {
            this.llist = llist;
            this.ind = ind;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.small, null);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, final int position) {
            Glide.with(context).load(llist.get(position).getPic())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .into(holder.imageView);

            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getPrice()+"");
            holder.count.setText(llist.get(position).getCount()+"");

            holder.checkBox.setChecked(llist.get(position).isZhuangtai());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean zhuangtai = llist.get(position).isZhuangtai();
                    toShopCall.smallindx(ind,position,zhuangtai);
                }
            });

            holder.addnet.setNumber(llist.get(position).getCount());
            holder.addnet.setAddCall(new Addnet.AddCall() {
                @Override
                public void onClick(int number) {
                    toShopCall.sumcount(ind,position,number);
                }
            });



        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView name,pri,count;
            CheckBox checkBox;
            Addnet addnet;
            public Holder(@NonNull View itemView) {
                super(itemView);
                addnet=itemView.findViewById(R.id.addne);
                imageView=itemView.findViewById(R.id.ima);
                checkBox=itemView.findViewById(R.id.checksmall);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
                count=itemView.findViewById(R.id.count);
            }
        }
    }

    public interface ToShopCall{
        void bigindex(int position);
        void smallindx(int bigposition,int smallposition,boolean zhuangt);
        void sumcount(int bigposition,int smallposition,int count);

    }

    public ToShopCall toShopCall;

    public void setToShopCall(ToShopCall toShopCall){
        this.toShopCall=toShopCall;
    }

    public void tobigc(int position){
        ShopBean.ResultBean resultBean = list.get(position);
        boolean zhuangtai = resultBean.isZhuangtai();
        resultBean.setZhuangtai(!zhuangtai);
        for (int i = 0; i < list.get(position).getShoppingCartList().size(); i++) {
            list.get(position).getShoppingCartList().get(i).setZhuangtai(!zhuangtai);
        }
    }

    public void tosmallc(int bigposition,int smallposition,boolean zhuangt){
        boolean flag=true;
        list.get(bigposition).getShoppingCartList().get(smallposition).setZhuangtai(!zhuangt);
        for (int i = 0; i < list.get(bigposition).getShoppingCartList().size(); i++) {
            if(!list.get(bigposition).getShoppingCartList().get(i).isZhuangtai()){
                flag=false;
            }
        }
        list.get(bigposition).setZhuangtai(flag);
    }

    public  void tosc(int bigposition,int smallposition,int count){
        list.get(bigposition).getShoppingCartList().get(smallposition).setCount(count);
    }

    public int setc(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isZhuangtai()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount();
                }
            }
        }
        return sum;

    }


    public int setp(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                if(list.get(i).getShoppingCartList().get(j).isZhuangtai()){
                    sum+=list.get(i).getShoppingCartList().get(j).getCount()*list.get(i).getShoppingCartList().get(j).getPrice();
                }
            }
        }
        return sum;
    }





}
