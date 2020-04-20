package com.bw.yanshenghao20200414;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.yanshenghao20200414.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：OneAdapter类
 * 作者：闫圣豪
 * 当前日期：2020/4/14
 * 当前时间：11:00
 */
public class OneAdapter extends RecyclerView.Adapter<OneAdapter.Holder> {


    private final ArrayList<ShopBean.OrderListBean> list;
    private final Main2Activity main2Activity;
    private List<ShopBean.OrderListBean.DetailListBean> detailList;

    public OneAdapter(ArrayList<ShopBean.OrderListBean> list, Main2Activity main2Activity) {

        this.list = list;
        this.main2Activity = main2Activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(main2Activity,R.layout.item1,null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        detailList = list.get(i).getDetailList();
        holder.namea.setText(list.get(i).getExpressCompName()+"");
        SmallAdapter smallAdapter = new SmallAdapter(list.get(i).getDetailList(),i);
        holder.small_Recy.setAdapter(smallAdapter);

        holder.mBigCheck.setChecked(setBigCheck(i));
        holder.mBigCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.bigCheckClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private CheckBox mBigCheck;
        private TextView namea;
        private RecyclerView small_Recy;
        public Holder(@NonNull View itemView) {
            super(itemView);
            mBigCheck = itemView.findViewById(R.id.Big_CheckBox);
           namea=itemView.findViewById(R.id.namea);
           small_Recy=itemView.findViewById(R.id.small_Recy);
           small_Recy.setLayoutManager(new LinearLayoutManager(main2Activity));
        }
    }



    class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.Holder>{

        private final List<ShopBean.OrderListBean.DetailListBean> detailList;
        private final int position;

        public SmallAdapter(List<ShopBean.OrderListBean.DetailListBean> detailList, int position) {

            this.detailList = detailList;
            this.position = position;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=View.inflate(main2Activity,R.layout.item,null);
            Holder holder = new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int i) {
            holder.name.setText(detailList.get(i).getCommodityName()+"");
            holder.price.setText(detailList.get(i).getCommodityPrice()+"");
            holder.mSmallCheck.setChecked(detailList.get(i).isStatus());
            holder.mSmallCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.smallCheckClick(position, i);
                    }
                }
            });
           Glide.with(main2Activity).load(detailList.get(i).getCommodityPic()).into(holder.image_one);
        }

        @Override
        public int getItemCount() {
            return detailList.size();
        }

        public class Holder extends RecyclerView.ViewHolder {
            private CheckBox mSmallCheck;
            private ImageView image_one;
            private TextView name,price;
            public Holder(@NonNull View itemView) {
                super(itemView);
                mSmallCheck = itemView.findViewById(R.id.small_Check);
                image_one=itemView.findViewById(R.id.image_one);
                name=itemView.findViewById(R.id.name);
                price=itemView.findViewById(R.id.price);
            }
        }
    }


    public interface ShoppingCallback {
        void bigCheckClick(int bigIndex);

        void smallCheckClick(int bigIndex, int smallIndex);

        void smallCheckClickCount(int bigIndex, int smallIndex, int number);
    }

    private ShoppingCallback callback;

    public void setCallback(ShoppingCallback callback) {
        this.callback = callback;
    }


    public boolean setBigCheck(int bigIndex) {
        boolean flag = true;
        ShopBean.OrderListBean orderListBean = list.get(bigIndex);
        for (int i = 0; i < orderListBean.getDetailList().size(); i++) {
            if (!orderListBean.getDetailList().get(i).isStatus()) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }


    public void setBigCheckStatus(int bigIndex, boolean isStatus) {
        List<ShopBean.OrderListBean.DetailListBean> cartList = list.get(bigIndex).getDetailList();
        for (ShopBean.OrderListBean.DetailListBean cardBean : cartList) {
            cardBean.setStatus(isStatus);
        }
    }


    public void setSmallCheck(int bigIndex, int smallIndex, boolean isCheck) {
        list.get(bigIndex).getDetailList().get(smallIndex).setStatus(isCheck);
    }


    public boolean isAllChecked() {
        boolean isAllchecked = true;
        for (int i = 0; i < list.size(); i++) {
            List<ShopBean.OrderListBean.DetailListBean> detailList = list.get(i).getDetailList();
            for (int j = 0; j < detailList.size(); j++) {
                if (!detailList.get(j).isStatus()) {
                    isAllchecked = false;
                    return isAllchecked;
                }
            }
        }
        return isAllchecked;
    }


    public void setAllChecked(boolean isCheck) {
        for (int i = 0; i < list.size(); i++) {
            List<ShopBean.OrderListBean.DetailListBean> detailList = list.get(i).getDetailList();
            for (int j = 0; j < detailList.size(); j++) {
                detailList.get(j).setStatus(isCheck);
            }
        }
    }






}
