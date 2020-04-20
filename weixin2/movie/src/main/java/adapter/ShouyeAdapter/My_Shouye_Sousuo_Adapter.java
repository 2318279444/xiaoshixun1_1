package adapter.ShouyeAdapter;

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

import bean.shouye.Shouye_SousuoBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/29
 *@Time:19:32
 *@Description:
 **/
public class My_Shouye_Sousuo_Adapter extends RecyclerView.Adapter<My_Shouye_Sousuo_Adapter.Holder> {
    List<Shouye_SousuoBean.ResultBean> list;
    Context context;

    public My_Shouye_Sousuo_Adapter(List<Shouye_SousuoBean.ResultBean> list, Context context) {
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
        holder.moviename.setText(list.get(position).getName());
        holder.name.setText(list.get(position).getDirector());
        holder.yyname.setText(list.get(position).getStarring());
        holder.pf.setText(list.get(position).getScore()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView moviename,name,yyname,pf;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.Shouye_ima);
            moviename=itemView.findViewById(R.id.moviename);
            name=itemView.findViewById(R.id.Shouye_name);
            yyname=itemView.findViewById(R.id.Shouye_yanyuan);
            pf=itemView.findViewById(R.id.Shouye_pf);
        }
    }
}
