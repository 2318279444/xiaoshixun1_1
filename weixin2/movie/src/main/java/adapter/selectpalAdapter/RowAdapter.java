package adapter.selectpalAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;

import java.util.List;

import bean.selectpal2.RowBean;


public class RowAdapter extends RecyclerView.Adapter<RowAdapter.Holder> {

    private Context mContext;
    private List<RowBean.ResultBean> mList;
    private int mIndex = 0;

    private boolean isCheck;

    public RowAdapter(Context mContext, List<RowBean.ResultBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mContext, R.layout.adapter_row, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
        holder.row_Name.setText(mList.get(i).getScreeningHall() + "");
        holder.row_beginTime.setText(mList.get(i).getBeginTime() + "");
        holder.row_endTime.setText(mList.get(i).getEndTime() + "");

        final double fare = mList.get(i).getFare();

        final int scheduId = mList.get(i).getId();
        final int hallId = mList.get(i).getHallId();


        if (mIndex == i) {
            holder.row_CheckBox.setBackgroundResource(R.drawable.my_red);
        } else {
            holder.row_CheckBox.setBackgroundResource(R.drawable.my_shape);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (onItemClick != null) {
                    onItemClick.setOnItemClick(i,scheduId, hallId,fare);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView row_Name, row_beginTime, row_endTime;
        RadioGroup radioGroup;
        RadioButton row_CheckBox;

        public Holder(@NonNull View itemView) {
            super(itemView);
            row_Name = itemView.findViewById(R.id.row_Name);
            row_beginTime = itemView.findViewById(R.id.row_beginTime);
            row_endTime = itemView.findViewById(R.id.row_endTime);
            row_CheckBox = itemView.findViewById(R.id.radioButton);
            radioGroup = itemView.findViewById(R.id.radioGroup);
        }
    }

    public interface onItemClick {
        void setOnItemClick(int index, int scheduleId, int hallId, double price);
    }

    private onItemClick onItemClick;

    public void setOnItemClick(RowAdapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setmIndex(int mIndex) {
        this.mIndex = mIndex;
        notifyDataSetChanged();
    }
}
