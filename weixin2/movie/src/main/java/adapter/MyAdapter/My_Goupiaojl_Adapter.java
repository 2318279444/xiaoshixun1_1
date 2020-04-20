package adapter.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.MyBean.My_GoupiaoliBean;
import bean.shouye.JijiangBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class My_Goupiaojl_Adapter extends RecyclerView.Adapter<My_Goupiaojl_Adapter.Holder> {
    List<My_GoupiaoliBean.ResultBean> list;
    Context context;



    public My_Goupiaojl_Adapter(List<My_GoupiaoliBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_goupiaojl, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);
        holder.name.setText(list.get(position).getMovieName());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getCreateTime());
        holder.personnumber.setText(format+"");


        holder.time.setText(list.get(position).getOrderId()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toJijiangCall.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,time,personnumber;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_jijiang_ima);
            name=itemView.findViewById(R.id.Shouye_jijiang_moviename);
            time=itemView.findViewById(R.id.Shouye_jijiang_ritime);
            personnumber=itemView.findViewById(R.id.Shouye_jijiang_personnumber);
        }
    }

    public interface ToJijiangCall{
        void onClick(int position);
    }

    public ToJijiangCall toJijiangCall;

    public void setToJijiangCall(ToJijiangCall toJijiangCall){
        this.toJijiangCall=toJijiangCall;
    }
}
