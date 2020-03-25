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
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder> {
    List<MovieBean.CategoryBean.ChildsBean> list;
    Context context;
    int lposition;

    public MyAdapter2(List<MovieBean.CategoryBean.ChildsBean> list, Context context) {
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
        holder.textView.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack2.onClick(position);
            }
        });

        if(lposition==position){
            holder.textView.setBackgroundColor(Color.BLUE);
        }else {
            holder.textView.setBackgroundColor(Color.WHITE);
        }



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

    public interface CallBack2{
        void onClick(int position);
    }

    public CallBack2 callBack2;

    public void setCallBack2(CallBack2 callBack2){
        this.callBack2=callBack2;
    }

    public void setColor2(int posirion){
        this.lposition=posirion;
        notifyDataSetChanged();
    }
}
