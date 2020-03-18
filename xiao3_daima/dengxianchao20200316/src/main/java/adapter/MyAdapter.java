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

import com.bawei.dengxianchao20200316.AddNet;
import com.bawei.dengxianchao20200316.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.ShopBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:9:28
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<ShopBean.OrderDataBean> list;
    Context context;

    public MyAdapter(List<ShopBean.OrderDataBean> list, Context context) {
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
        holder.namebig.setText(list.get(position).getShopName());

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.recycbig.setLayoutManager(manager);
        holder.recycbig.setAdapter(new Small(list.get(position).getCartlist(),position));

        holder.checkBoxbig.setChecked(list.get(position).isZhuanttai());

        holder.checkBoxbig.setOnClickListener(new View.OnClickListener() {
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

    class Holder extends RecyclerView.ViewHolder {
        TextView namebig;
        RecyclerView recycbig;
        CheckBox checkBoxbig;
        public Holder(@NonNull View itemView) {
            super(itemView);
            namebig=itemView.findViewById(R.id.namebig);
            recycbig=itemView.findViewById(R.id.recycbig);
            checkBoxbig=itemView.findViewById(R.id.checckbig);
        }
    }


    public class Small extends RecyclerView.Adapter<Small.Holder>{
        List<ShopBean.OrderDataBean.CartlistBean> llist;
        int ind;

        public Small(List<ShopBean.OrderDataBean.CartlistBean> llist, int ind) {
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
            Glide.with(context).load(llist.get(position).getDefaultPic()).into(holder.imageView);
            holder.name.setText(llist.get(position).getProductName());
            holder.color.setText(llist.get(position).getColor());
            holder.pri.setText(llist.get(position).getPrice()+"");


            holder.checkBox.setChecked(llist.get(position).isZhuangtai());
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean zhuangtai = llist.get(position).isZhuangtai();
                    toShopCall.smallindex(ind,position,zhuangtai);
                }
            });


            holder.addNet.setnumber(llist.get(position).getCount());
            holder.addNet.setToAddCall(new AddNet.ToAddCall() {
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

        class Holder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView name,color,pri;
            CheckBox checkBox;
            AddNet addNet;
            public Holder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                color=itemView.findViewById(R.id.color);
                pri=itemView.findViewById(R.id.pri);
                checkBox=itemView.findViewById(R.id.check);
                addNet=itemView.findViewById(R.id.add);
            }
        }
    }




    public interface ToShopCall{
        void bigindex(int position);

        void smallindex(int bposition,int sposition,boolean zhuangtai);

        void sumcount(int bposition,int sposition,int count);


    }
    public ToShopCall toShopCall;

    public void setToShopCall(ToShopCall toShopCall){
        this.toShopCall=toShopCall;
    }

    public void tobig(int position){
        ShopBean.OrderDataBean orderDataBean = list.get(position);
        boolean zhuanttai = orderDataBean.isZhuanttai();
        orderDataBean.setZhuanttai(!zhuanttai);

        for (int i = 0; i < list.get(position).getCartlist().size(); i++) {
            list.get(position).getCartlist().get(i).setZhuangtai(!zhuanttai);
        }
    }


    public void tosmall(int bposition,int sposition,boolean zhuangtai){
        boolean flag=true;
        list.get(bposition).getCartlist().get(sposition).setZhuangtai(!zhuangtai);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getCartlist().size(); j++) {
                if(!list.get(bposition).getCartlist().get(i).isZhuangtai()){
                    flag=false;
                }
            }
        }
        list.get(bposition).setZhuanttai(flag);
    }

    public void tosum(int bposition,int sposition,int count){
        list.get(bposition).getCartlist().get(sposition).setCount(count);
    }


    public int sumprice(){
        int sum=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getCartlist().size(); j++) {
                if(list.get(i).getCartlist().get(j).isZhuangtai()){
                    sum+=list.get(i).getCartlist().get(j).getCount()*list.get(i).getCartlist().get(j).getPrice();
                }
            }
        }
        return sum;
    }



}
