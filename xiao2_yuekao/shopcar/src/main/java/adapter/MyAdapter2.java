package adapter;

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

import com.bawei.shopcar.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import bean.DingdanBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/13
 *@Time:14:03
 *@Description:
 **/
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> {
    List<DingdanBean.OrderListBean> list;
    Context context;

    String st="http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg";

    public MyAdapter2(List<DingdanBean.OrderListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.big2, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.danhao.setText(list.get(position).getOrderId()+"");
        holder.shijian.setText(list.get(position).getOrderTime()+"");
        holder.gsi.setText(list.get(position).getExpressCompName());
        holder.kd.setText(list.get(position).getOrderStatus()+"");


        Log.e("aaa","danhao"+list.get(position).getOrderId());


        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.RecyclerView.setLayoutManager(manager);
        holder.RecyclerView.setAdapter(new smallAdapter(list.get(position).getDetailList(),position));
        
        
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView danhao,shijian,gsi,kd;

        RecyclerView RecyclerView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            gsi=itemView.findViewById(R.id.gsi);
            kd=itemView.findViewById(R.id.kd);
            danhao=itemView.findViewById(R.id.bigdanhao);
            shijian=itemView.findViewById(R.id.bigshijian);
            RecyclerView=itemView.findViewById(R.id.bigRecyclerview);
        }
    }



    public class smallAdapter extends RecyclerView.Adapter<smallAdapter.Holder>{
        List<DingdanBean.OrderListBean.DetailListBean> llist;

        public smallAdapter(List<DingdanBean.OrderListBean.DetailListBean> llist, int position) {
            this.llist = llist;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.small, null);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.name.setText(llist.get(position).getCommodityName());
            holder.pri.setText(llist.get(position).getCommodityPrice()+"");

            String[] split = st.split(",");
            Glide.with(context).load(split[position])
                    .error(R.drawable.black_background)
                    .placeholder(R.drawable.black_background)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300))).
                    into(holder.imageView);


            Log.e("aaa",""+llist.get(position).getCommodityPic());

        }

        @Override
        public int getItemCount() {
            return llist.size();
        }

        class Holder extends RecyclerView.ViewHolder{
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
