package adapter.YingAdapter;

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

import bean.Ying.YingTuijianBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/28
 *@Time:20:24
 *@Description:
 **/
public class MyMovieRecommendAdapter extends RecyclerView.Adapter<MyMovieRecommendAdapter.Holder> {
    List<YingTuijianBean.ResultBean> list;
    Context context;

    public MyMovieRecommendAdapter(List<YingTuijianBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemrecommendmovie, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getLogo())
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.name.setText(list.get(position).getName());
        holder.location.setText(list.get(position).getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecommendMovieCallBack.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,location;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imagerecomendmovie);
            name=itemView.findViewById(R.id.recommendmoviename);
            location=itemView.findViewById(R.id.recommendmovielocation);
        }
    }


    public interface onRecommendMovieCallBack{
        void onClick(int position);
    }

    public onRecommendMovieCallBack onRecommendMovieCallBack;

    public void setOnRecommendMovieCallBack(onRecommendMovieCallBack onRecommendMovieCallBack){
        this.onRecommendMovieCallBack=onRecommendMovieCallBack;
    }
}
