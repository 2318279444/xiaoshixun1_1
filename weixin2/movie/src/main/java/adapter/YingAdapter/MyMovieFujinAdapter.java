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

import bean.Ying.YingFujinBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/28
 *@Time:20:24
 *@Description:
 **/
public class MyMovieFujinAdapter extends RecyclerView.Adapter<MyMovieFujinAdapter.Holder> {
    List<YingFujinBean.ResultBean> list;
    Context context;

    public MyMovieFujinAdapter(List<YingFujinBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fujin_movie1, null);
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
                onFujinMovieCallBack.onClick(position);
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
            imageView=itemView.findViewById(R.id.imagefujinmovie);
            name=itemView.findViewById(R.id.fujinmoviename);
            location=itemView.findViewById(R.id.fujinmovielocation);
        }
    }


    public interface onFujinMovieCallBack{
        void onClick(int position);
    }

    public onFujinMovieCallBack onFujinMovieCallBack;

    public void setOnFujinMovieCallBack(onFujinMovieCallBack onFujinMovieCallBack){
        this.onFujinMovieCallBack=onFujinMovieCallBack;
    }

}
