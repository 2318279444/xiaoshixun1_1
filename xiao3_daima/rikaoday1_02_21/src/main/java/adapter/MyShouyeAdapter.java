package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.rikaoday1_02_21.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.ShouyeBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:16:29
 *@Description:
 **/
public class MyShouyeAdapter extends RecyclerView.Adapter<MyShouyeAdapter.Holder> {
    List<ShouyeBean.ResultBean.RxxpBean.CommodityListBean> list;
    Context context;

    public MyShouyeAdapter(List<ShouyeBean.ResultBean.RxxpBean.CommodityListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rx, null);
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

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,pri;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imarx);
            name=itemView.findViewById(R.id.namerx);
            pri=itemView.findViewById(R.id.prirx);
        }
    }
}
