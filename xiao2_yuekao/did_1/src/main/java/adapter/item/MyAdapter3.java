package adapter.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.did_1.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.DingDanBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/17
 *@Time:13:44
 *@Description:
 **/
public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.Holder> {
    List<DingDanBean.OrderListBean> list;
    Context context;

    String st="http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg";

    public MyAdapter3(List<DingDanBean.OrderListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.big3, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.danhao.setText(list.get(position).getOrderId()+"");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getOrderTime());
        holder.shijian.setText(format+"");

        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setLayoutManager(manager);
        holder.bigrecyclerView.setAdapter(new smallAdapter(list.get(position).getDetailList(),position));



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView danhao,shijian;
        RecyclerView bigrecyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            danhao=itemView.findViewById(R.id.danhao);
            shijian=itemView.findViewById(R.id.shijian);
            bigrecyclerView=itemView.findViewById(R.id.bigrecyc);
        }
    }


    public class smallAdapter extends RecyclerView.Adapter<smallAdapter.Holder>{
        List<DingDanBean.OrderListBean.DetailListBean> llist;

        public smallAdapter(List<DingDanBean.OrderListBean.DetailListBean> llist, int position) {
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
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                    .into(holder.imageView);
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
