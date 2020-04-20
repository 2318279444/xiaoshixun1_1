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

import bean.shouye.ShouyeBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class MyShouyeAdapter_remen extends RecyclerView.Adapter<MyShouyeAdapter_remen.Holder> {
    List<ShouyeBean.ResultBean> list;
    Context context;



    public MyShouyeAdapter_remen(List<ShouyeBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_shouyeremen, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(holder.imageView);

        holder.name.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toJijiangCall.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_Item_Ima);
            name=itemView.findViewById(R.id.Shouye_Item_name);
        }
    }

    public interface ToJijiangCall{
        void onClick(int position);
    }

    public MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall;

    public void setToJijiangCall(MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall){
        this.toJijiangCall=toJijiangCall;
    }



}
