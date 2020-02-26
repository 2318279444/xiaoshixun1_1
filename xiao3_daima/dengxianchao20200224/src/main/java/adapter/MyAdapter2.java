package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dengxianchao20200224.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.List;

import bean.LiWuBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/24
 *@Time:13:17
 *@Description:
 **/
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> {
    List<LiWuBean.ResultBean> list;
    Context context;

    public MyAdapter2(List<LiWuBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getNickName());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getHandselTime());
        holder.time.setText(format+"");
        Glide.with(context).load(list.get(position).getHeadPic())
                .error(R.drawable.black_background)
                .placeholder(R.drawable.black_background)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(holder.imageView1);
        Glide.with(context).load(list.get(position).getGiftPic())
                .error(R.drawable.black_background)
                .placeholder(R.drawable.black_background)
                .into(holder.imageView2);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2;
        TextView name,time;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView1=itemView.findViewById(R.id.ima1);
            imageView2=itemView.findViewById(R.id.ima2);
            name=itemView.findViewById(R.id.name);
            time=itemView.findViewById(R.id.time);
        }
    }
}
