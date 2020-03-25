package adapter.ShouyeAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;

import java.util.List;

import bean.shouye.Shouye_Movie_XQBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class My_Shouye_Movie_mx_jieshaoAdapter extends RecyclerView.Adapter<My_Shouye_Movie_mx_jieshaoAdapter.Holder> {
    List<Shouye_Movie_XQBean.ResultBean> list;
    Context context;



    public My_Shouye_Movie_mx_jieshaoAdapter(List<Shouye_Movie_XQBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_jieshao, null);
        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

       holder.name.setText(list.get(position).getSummary());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView jieshao,name;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.mx_ima);
            jieshao=itemView.findViewById(R.id.mx_jieshao);
            name=itemView.findViewById(R.id.mx_dyname);

        }
    }


}
