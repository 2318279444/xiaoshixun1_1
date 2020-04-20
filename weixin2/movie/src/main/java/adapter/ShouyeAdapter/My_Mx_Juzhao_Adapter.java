package adapter.ShouyeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;

import java.util.List;

import bean.shouye.Shouye_JuzhaoBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/27
 *@Time:15:09
 *@Description:
 **/
public class My_Mx_Juzhao_Adapter extends RecyclerView.Adapter<My_Mx_Juzhao_Adapter.Holder> {
    List<Shouye_JuzhaoBean.ResultBean> list;
    Context context;

    public My_Mx_Juzhao_Adapter(List<Shouye_JuzhaoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_juzhao, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(list.get(position).getPosterList()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.juzhao_ima);
        }
    }
}
