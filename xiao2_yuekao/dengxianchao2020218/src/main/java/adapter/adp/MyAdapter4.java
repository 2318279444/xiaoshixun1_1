package adapter.adp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dengxianchao2020218.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.DingdanBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/18
 *@Time:9:20
 *@Description:
 **/
public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.Holder> {
    List<DingdanBean.OrderListBean> list;
    Context context;

    String st="http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg";

    public MyAdapter4(List<DingdanBean.OrderListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.big4, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.danhao.setText(list.get(position).getOrderId()+"");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        String format = simpleDateFormat.format(list.get(position).getOrderTime());
        holder.shijian.setText(format+"");



        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(RecyclerView.VERTICAL);
        holder.bigrecyclerView.setLayoutManager(manager);
        holder.bigrecyclerView.setAdapter(new smallHolder(list.get(position).getDetailList(),position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView danhao,shijian,gs,dh;
        RecyclerView bigrecyclerView;

        public Holder(@NonNull View itemView) {
            super(itemView);

            danhao=itemView.findViewById(R.id.danhao);
            gs=itemView.findViewById(R.id.gs);
            dh=itemView.findViewById(R.id.dh);
            shijian=itemView.findViewById(R.id.shijian);
            bigrecyclerView=itemView.findViewById(R.id.recycbig);
        }
    }



    public class smallHolder extends RecyclerView.Adapter<smallHolder.Holder>{
        List<DingdanBean.OrderListBean.DetailListBean> llist;

        public smallHolder(List<DingdanBean.OrderListBean.DetailListBean> llist, int position) {
            this.llist = llist;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.small4, null);
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
