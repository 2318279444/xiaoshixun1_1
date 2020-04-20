package adapter.YingAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;

import java.util.List;

import bean.Ying.Location_RightBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/5
 *@Time:13:48
 *@Description:
 **/
public class MyLocationRightAdapter extends RecyclerView.Adapter<MyLocationRightAdapter.Holder> {
    List<Location_RightBean.ResultBean> list;
    Context context;

    public MyLocationRightAdapter(List<Location_RightBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_location_right, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.textView.setText(list.get(i).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location_rightCallBack.onClick(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_Location_right);
        }
    }

    public interface Location_RightCallBack{
        void onClick(int position);
    }

    public Location_RightCallBack location_rightCallBack;

    public void setLocation_rightCallBack(Location_RightCallBack location_rightCallBack){
        this.location_rightCallBack=location_rightCallBack;

    }
}
