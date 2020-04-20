package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dengxianchao2020_03_09.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import bean.HotMovieBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:13:45
 *@Description:
 **/
public class MyHotAdapter extends RecyclerView.Adapter<MyHotAdapter.Holder> {
    List<HotMovieBean.ResultBean> list;
    Context context;

    public MyHotAdapter(List<HotMovieBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl())
                .error(R.drawable.black_background)
                .placeholder(R.drawable.black_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);
        holder.moviename.setText(list.get(position).getName());
        holder.daoyanname.setText(list.get(position).getDirector());
        holder.yanyuanname.setText(list.get(position).getStarring());
        holder.pf.setText(list.get(position).getScore()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView daoyanname,yanyuanname,pf,moviename;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ima);
            daoyanname=itemView.findViewById(R.id.daoyanname);
            yanyuanname=itemView.findViewById(R.id.yanyuanname);
            pf=itemView.findViewById(R.id.pf);
            moviename=itemView.findViewById(R.id.moviename);

        }
    }

}
