package adapter.YingAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.HalfFloat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;

import java.util.List;

import bean.Ying.XQLeftBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/3
 *@Time:20:31
 *@Description:
 **/
public class MyMovieXQLeftAdapter extends RecyclerView.Adapter<MyMovieXQLeftAdapter.Holdel> {
    List<XQLeftBean.ResultBean> list;
    Context context;


    public MyMovieXQLeftAdapter(List<XQLeftBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holdel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xq_left, null);
        return new Holdel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holdel holder, int position) {
        holder.adress.setText(list.get(position).getAddress());
        holder.phone.setText(list.get(position).getPhone()+"");
        holder.style.setText(list.get(position).getVehicleRoute());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holdel extends RecyclerView.ViewHolder{
        TextView adress,phone,style;
        public Holdel(@NonNull View itemView) {
            super(itemView);
            adress=itemView.findViewById(R.id.XQaddress);
            phone=itemView.findViewById(R.id.XQphone);
            style=itemView.findViewById(R.id.XQstyle);
        }
    }
}
