package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dengxianchao2020_03_02.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.ShopBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/2
 *@Time:13:08
 *@Description:
 **/
public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.Holder> {
    List<ShopBean.ResultBean.PzshBean.CommodityListBeanX> list;
    Context context;

    public MyAdapter3(List<ShopBean.ResultBean.PzshBean.CommodityListBeanX> list, Context context) {
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
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.imageView);
        holder.name.setText(list.get(position).getCommodityName());
        holder.pri.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,pri;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.ima1);
            name=itemView.findViewById(R.id.name1);
            pri=itemView.findViewById(R.id.pri1);

        }
    }
}
