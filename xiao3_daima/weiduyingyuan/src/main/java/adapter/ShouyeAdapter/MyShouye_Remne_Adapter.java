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

import java.util.List;

import bean.shouye.RemenBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class MyShouye_Remne_Adapter extends RecyclerView.Adapter<MyShouye_Remne_Adapter.Holder> {
    List<RemenBean.ResultBean> list;
    Context context;



    public MyShouye_Remne_Adapter(List<RemenBean.ResultBean> list, Context context) {
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
}
