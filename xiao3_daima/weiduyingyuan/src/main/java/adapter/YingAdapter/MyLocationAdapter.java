package adapter.YingAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;

import java.util.List;

import bean.Ying.Location_leftBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/5
 *@Time:13:12
 *@Description:
 **/
public class MyLocationAdapter extends RecyclerView.Adapter<MyLocationAdapter.Holder> {
    List<Location_leftBean.ResultBean> list;
    Context context;
    int lposition;

    public MyLocationAdapter(List<Location_leftBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_location_left, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.textView.setText(list.get(position).getRegionName());
        holder.textView.setTextSize(26);

        if(lposition==position){
            holder.textView.setTextColor(Color.BLACK);
        }else {
            holder.textView.setTextColor(Color.GRAY);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationCallBack.onclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_Location_left);
        }
    }

    public interface LocationCallBack{
        void onclick(int position);
    }

    public LocationCallBack locationCallBack;

    public void setLocationCallBack(LocationCallBack locationCallBack){
        this.locationCallBack=locationCallBack;
    }

    public void setColor(int position){
        this.lposition=position;
        notifyDataSetChanged();
    }
}
