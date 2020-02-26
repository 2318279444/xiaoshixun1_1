package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.zhoumozuoye2020_02_22.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.ZhengzaiBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/22
 *@Time:16:34
 *@Description:
 **/
public class MyjiAdapter extends RecyclerView.Adapter<MyjiAdapter.Holder> {
    List<ZhengzaiBean.SubjectsBean> list;
    Context context;

    String st="https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1534766550.03.webp,https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1523448357.59.webp,https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44986.webp";


//    .CastsBean.AvatarsBean
    public MyjiAdapter(List<ZhengzaiBean.SubjectsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ji1, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Glide.with(context).load(list.get(position).getImages())
                .error(R.drawable.black_background)
                .into(holder.imageView);
        holder.time.setText(list.get(position).getId()+"");
        holder.name.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,type,time;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ima);
            name=itemView.findViewById(R.id.name);
            type=itemView.findViewById(R.id.type);
            time=itemView.findViewById(R.id.time);
        }
    }
}
