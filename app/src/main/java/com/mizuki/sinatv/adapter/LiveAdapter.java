package com.mizuki.sinatv.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.bean.Live;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.mizuki.sinatv.utils.PhoneInfoUtils.context;

/**
 * 精选的RecyclerView的Adapter
 */

public abstract class LiveAdapter extends RecyclerView.Adapter<LiveHolder> {
    Context mContext;
    List<Live.ResultBean.ListBean> list;

    //用于传参：上下文对象，数据
    public LiveAdapter(Context context) {
        this.mContext = context;
        this.list = new ArrayList<>();
    }

    @Override
    public LiveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.live_rv_item, parent, false);
        LiveHolder liveHolder = new LiveHolder(view);
        return liveHolder;
    }

    @Override
    public void onBindViewHolder(LiveHolder holder, final int position) {
        if (holder instanceof LiveHolder) {
            //这是最主要的代码，显示内容
            holder.liveTvLiveName.setText(list.get(position)
                    .getData().getLive_name());
            holder.liveTvUserName.setText(list.get(position)
                    .getUser().getUser_data().getUser_name());

            String liveIvAvatar_url = list.get(position).getUser().getUser_data().getAvatar();
            String liveIvPic_url = list.get(position).getData().getPic();

            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
            Picasso.with(mContext)
                    .load(liveIvAvatar_url)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.liveIvAvatar);
            Picasso.with(mContext)
                    .load(liveIvPic_url)
                    .into(holder.liveIvPic);

            //item点击事件监听
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //student.play(position);调用，此处实现
                    clickLiveItem(position);
                }
            });
        }
    }

    /**
     * 点击的抽象方法
     */
    public abstract void clickLiveItem( int position);

    @Override
    public int getItemCount() {
        return list.size();
    }

    //本地清空
    public void clearData() {
        list.clear();
        notifyDataSetChanged();
    }

    //刷新
    public void refreshData(List<Live.ResultBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    //加载
    public void moreData(List<Live.ResultBean.ListBean> list) {
        this.list.addAll(list);
        notifyItemChanged(this.list.size());
    }
}

class LiveHolder extends RecyclerView.ViewHolder {
    de.hdodenhof.circleimageview.CircleImageView liveIvAvatar;//头像
    TextView liveTvLiveName;//直播名字
    TextView liveTvUserName;//名字
    ImageView liveIvPic;//图片

    public LiveHolder(View itemView) {
        super(itemView);
        liveIvAvatar = itemView.findViewById(R.id.live_iv_avatar);
        liveTvLiveName = itemView.findViewById(R.id.live_tv_live_name);
        liveTvUserName = itemView.findViewById(R.id.live_tv_user_name);
        liveIvPic = itemView.findViewById(R.id.live_iv_pic);
    }
}