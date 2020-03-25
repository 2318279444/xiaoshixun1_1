package adapter.YingAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.Ying.PLRightBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/4
 *@Time:14:04
 *@Description:
 **/
public class MyMoviePLRightAdapter extends RecyclerView.Adapter<MyMoviePLRightAdapter.Holder> {
    List<PLRightBean.ResultBean> list;
    Context context;

    public MyMoviePLRightAdapter(List<PLRightBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pl_right, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getCommentHeadPic())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView);

        holder.name.setText(list.get(position).getCommentUserName());
        Log.e("aaa","pladapter"+list.get(position).getCommentHeadPic());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.time.setText(format+"");

        holder.pl.setText(list.get(position).getCommentContent());

        holder.shu.setText(list.get(position).getGreatNum()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView time,name,shu,pl;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.pl_right_ima);
            time=itemView.findViewById(R.id.pl_right_time);
            name=itemView.findViewById(R.id.pl_right_name);
            shu=itemView.findViewById(R.id.pl_right_shuliang);
            pl=itemView.findViewById(R.id.pl_right_pl);
        }
    }
}
