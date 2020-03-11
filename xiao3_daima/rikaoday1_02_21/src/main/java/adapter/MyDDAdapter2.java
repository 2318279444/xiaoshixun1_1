package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.rikaoday1_02_21.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.DdBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/11
 *@Time:17:03
 *@Description:
 **/
public class MyDDAdapter2 extends RecyclerView.Adapter<MyDDAdapter2.Holder> {
    List<DdBean.OrderListBean> list;
    Context context;


    public MyDDAdapter2(List<DdBean.OrderListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(list.get(position).getOrderId()+"");

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setAdapter(new Small(list.get(position).getDetailList(),position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        RecyclerView recyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.dh);
            recyclerView=itemView.findViewById(R.id.recycbig);
        }
    }


    public class Small extends RecyclerView.Adapter<Small.Holder>{
        List<DdBean.OrderListBean.DetailListBean> listBeans;

        String st="http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg";


        public Small(List<DdBean.OrderListBean.DetailListBean> listBeans, int position) {
            this.listBeans = listBeans;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.small2, null);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            String[] split = st.split(",");
            Glide.with(context).load(split[position]).into(holder.imageView);
            holder.name.setText(listBeans.get(position).getCommodityName());
            holder.pri.setText(listBeans.get(position).getCommodityPrice()+"");
        }

        @Override
        public int getItemCount() {
            return listBeans.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView name,pri;
            public Holder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.ima);
                name=itemView.findViewById(R.id.name);
                pri=itemView.findViewById(R.id.pri);
            }
        }
    }

}
