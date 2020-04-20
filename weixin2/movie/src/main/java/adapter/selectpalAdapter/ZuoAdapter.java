package adapter.selectpalAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;

import java.util.ArrayList;
import java.util.List;

import bean.selectpal2.ZuoBean;


public class ZuoAdapter extends RecyclerView.Adapter<ZuoAdapter.Holder> {

    private Context mContext;
    private List<ZuoBean.ResultBean> mList;
    private List<String> list = new ArrayList<>();
    private String seat;


    public ZuoAdapter(Context mContext, List<ZuoBean.ResultBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.adapter_zuo, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {

        String row = mList.get(i).getRow();
        seat = mList.get(i).getSeat();
        int status = mList.get(i).getStatus();

        if (status == 1) {
            holder.checkBox.setChecked(false);
        } else if (status == 2) {
            holder.checkBox.setBackgroundResource(R.drawable.my_yellow);
        } else if (status == 3) {
            holder.checkBox.setChecked(true);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    list.add(mList.get(i).getRow() + "-" + mList.get(i).getSeat());
//                    Toast.makeText(mContext, "选中了" + mList.get(i).getRow() + "-" + mList.get(i).getSeat(), Toast.LENGTH_SHORT).show();
                } else {
                    list.remove(mList.get(i).getRow() + "-" + mList.get(i).getSeat());
                    Toast.makeText(mContext, "取消了" + "座位", Toast.LENGTH_SHORT).show();
                }
                onItemClick.setOnItemClick(list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        CheckBox checkBox;

        public Holder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.zuo_che);
        }
    }

    public interface onItemClick {
        void setOnItemClick(List<String> list);
    }

    private onItemClick onItemClick;

    public void setOnItemClick(ZuoAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
