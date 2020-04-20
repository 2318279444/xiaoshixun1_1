package adapter.YingAdapter;

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

import java.util.List;

import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import bean.Ying.Ying_PaiqiBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class My_Ying_PaiqiAdapter extends RecyclerView.Adapter<My_Ying_PaiqiAdapter.Holder> {
    List<Ying_PaiqiBean.ResultBean> list;
    Context context;



    public My_Ying_PaiqiAdapter(List<Ying_PaiqiBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemshouye, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);
        holder.movien.setText(list.get(position).getName());
        holder.name.setText(list.get(position).getDirector());
        holder.yanyuan.setText(list.get(position).getStarring());
        holder.pf.setText(list.get(position).getScore()+"");

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
        TextView name,yanyuan,pf,movien;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_ima);
            movien=itemView.findViewById(R.id.moviename);
            name=itemView.findViewById(R.id.Shouye_name);
            yanyuan=itemView.findViewById(R.id.Shouye_yanyuan);
            pf=itemView.findViewById(R.id.Shouye_pf);
        }
    }

    public interface ToJijiangCall{
        void onClick(int position);
    }

    public MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall;

    public void setToJijiangCall(MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall){
        this.toJijiangCall=toJijiangCall;
    }



}
