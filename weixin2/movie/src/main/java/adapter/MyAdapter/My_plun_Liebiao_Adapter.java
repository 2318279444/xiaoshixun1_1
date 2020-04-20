package adapter.MyAdapter;

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

import java.text.SimpleDateFormat;
import java.util.List;

import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import bean.MyBean.My_Plun_LeibiaoBean;
import bean.shouye.RemenBean;

/*
 *@auther:邓先超
 *@Date: 2020/3/6
 *@Time:13:20
 *@Description:
 **/
public class My_plun_Liebiao_Adapter extends RecyclerView.Adapter<My_plun_Liebiao_Adapter.Holder> {
    List<My_Plun_LeibiaoBean.ResultBean> list;
    Context context;



    public My_plun_Liebiao_Adapter(List<My_Plun_LeibiaoBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemplun_liebiao, null);
        return new Holder(view);
    }


    //{"result":[{"commentTime":1585816704000,"director":"韩延","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dwsj/dwsj1.jpg","
    // movieId":10,"movieName":"动物世界","movieScore":0,"myCommentContent":"好看啊","myCommentScore"
    // :10,"starring":"李易峰,迈克尔·道格拉斯,周冬雨"},{"commentTime":1585816606000,"director":"\r\n李
    // 仁港","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/pdz/pdz1.jpg","movieId":25,"
    // movieName":"攀登者","movieScore":0,"myCommentContent":"很好看","myCommentScore":9,
    // "starring":"吴京,章子怡,井柏然,胡歌"},{"commentTime":1585812225000,"director":"姜文",
    // "imageUrl":"http://mobile.bwstudent.com/images/movie/stills/xbyz/xbyz1.jpg",
    // "movieId":5,"movieName":"邪不压正","movieScore":0,"myCommentContent":"12312312",
    // "myCommentScore":9,"starring":"姜文,彭于晏,廖凡,许晴,周韵"},{"commentTime":1585811876000,
    // "director":"克里斯托弗·麦奎里","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg"
    // ,"movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"1",
    // "myCommentScore":5,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},
    // {"commentTime":1585479793000,"director":"\r\n刘伟强","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zgjz/z
    // gjz1.jpg","movieId":24,"movieName":"中国机长","movieScore":0,"myCommentContent":"好看\n",
    // "myCommentScore":4.5,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"}],"message":"查询成功","status":"0000"}
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.imageView);

        holder.movien.setText(list.get(position).getMovieName());
        holder.name.setText(list.get(position).getDirector());
        holder.yanyuan.setText(list.get(position).getStarring());


        holder.pf.setText(list.get(position).getMyCommentScore()+"");

        holder.pl.setText(list.get(position).getMyCommentContent());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = simpleDateFormat.format(list.get(position).getCommentTime());
        holder.time.setText(format+"");

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toJijiangCall.onClick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,yanyuan,pf,movien,pl,time;

        public Holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.Shouye_ima);
            movien=itemView.findViewById(R.id.moviename);
            name=itemView.findViewById(R.id.Shouye_name);
            yanyuan=itemView.findViewById(R.id.Shouye_yanyuan);
            pf=itemView.findViewById(R.id.Shouye_pf);
            pl=itemView.findViewById(R.id.my_Plun);
            time=itemView.findViewById(R.id.my_time);
        }
    }

//    public interface ToJijiangCall{
//        void onClick(int position);
//    }
//
//    public MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall;
//
//    public void setToJijiangCall(MyShouye_jijiang_Adapter.ToJijiangCall toJijiangCall){
//        this.toJijiangCall=toJijiangCall;
//    }
}
