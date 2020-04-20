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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.R;

import java.util.List;

import bean.Ying.Ying_PaiqiBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/28
 *@Time:10:17
 *@Description:
 **/
public class My_Paiqi_Adapter extends RecyclerView.Adapter<My_Paiqi_Adapter.Holder> {
    List<Ying_PaiqiBean.ResultBean> list;
    Context context;

    public My_Paiqi_Adapter(List<Ying_PaiqiBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_paiqi_liebiao, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(holder.imageView);

        holder.moviename.setText(list.get(position).getName());
        holder.name.setText(list.get(position).getDirector());
        holder.yyname.setText(list.get(position).getStarring());
        holder.pf.setText(list.get(position).getScore()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paiqiCall.onclick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
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


    public interface PaiqiCall{
        void onclick(int position);
    }

    public PaiqiCall paiqiCall;

    public void setPaiqiCall(PaiqiCall paiqiCall){
        this.paiqiCall=paiqiCall;
    }
}
