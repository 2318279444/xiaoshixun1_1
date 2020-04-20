package adapter.ShouyeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.shouye.Shouye_Movie_XQBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/10
 *@Time:19:29
 *@Description:
 **/
public class My_mx_Yanyuan_Adapter extends RecyclerView.Adapter<My_mx_Yanyuan_Adapter.Holder> {
    List<Shouye_Movie_XQBean.ResultBean.MovieActorBean> list;
    Context context;

    public My_mx_Yanyuan_Adapter(List<Shouye_Movie_XQBean.ResultBean.MovieActorBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xm_yanyuan, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_jieshao_ima);
            name=itemView.findViewById(R.id.Shouye_jieshao_name);
        }
    }
}
