package adapter.ShouyeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.shouye.Shouye_Movie_XQBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class My_Shouye_Movie_XQAdapter extends RecyclerView.Adapter<My_Shouye_Movie_XQAdapter.Holder> {
    List<Shouye_Movie_XQBean.ResultBean> list;
    Context context;



    public My_Shouye_Movie_XQAdapter(List<Shouye_Movie_XQBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shouye_xq, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());

        holder.time.setText(list.get(position).getDuration());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
        String format = simpleDateFormat.format(list.get(position).getReleaseTime());
        holder.sy.setText(format+"");



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,time,sy;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_XQ_ima);
            name=itemView.findViewById(R.id.Shouye_XQ_name);
            time=itemView.findViewById(R.id.Shouye_XQ_time);
            sy=itemView.findViewById(R.id.Shouye_XQ_sy);
        }
    }


}
