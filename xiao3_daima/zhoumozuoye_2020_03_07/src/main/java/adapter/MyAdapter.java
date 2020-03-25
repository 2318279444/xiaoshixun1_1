package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhoumozuoye_2020_03_07.R;

import java.util.List;

import bean.MovieBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/7
 *@Time:14:21
 *@Description:
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<MovieBean.CategoryBean> list;
    Context context;
    int lposition;

    public MyAdapter(List<MovieBean.CategoryBean> list, Context context) {
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
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        if(lposition==position){
            holder.textView.setTextColor(Color.RED);
        }else {
            holder.textView.setTextColor(Color.BLACK);
        }

        holder.textView.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView textView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tex);
        }

    }

    public interface CallBack{
        void onClick(int position);
    }

    public CallBack callBack;

    public void setCallBack(CallBack callBack){
        this.callBack=callBack;
    }

    public void setColor(int position){
        this.lposition=position;
        notifyDataSetChanged();
    }
}
