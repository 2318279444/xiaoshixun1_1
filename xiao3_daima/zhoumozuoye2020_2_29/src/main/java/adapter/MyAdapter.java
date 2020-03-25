package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhoumozuoye2020_2_29.R;
import com.bumptech.glide.Glide;

import java.util.List;

import bean.BookBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/29
 *@Time:13:17
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    List<BookBean.DataBean.ContentBean> list;
    Context context;


    public MyAdapter(List<BookBean.DataBean.ContentBean> list, Context context) {
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
        Glide.with(context).load(list.get(position).getBook_cover()).into(holder.imageView);
        holder.name.setText(list.get(position).getBookname());
        holder.pri.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,pri;
        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.ima);
            name=itemView.findViewById(R.id.name);
            pri=itemView.findViewById(R.id.pri);
        }
    }

}
