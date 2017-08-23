package com.mizuki.sinatv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mizuki.sinatv.R;
import com.mizuki.sinatv.bean.Gift;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<Gift.GiftListBean> mDatas;
    private LayoutInflater inflater;
    private int curIndex;//页数下标,从0开始(当前是第几页)
    private int pageSize;//每一页显示的个数
    private Context mContext;

    public GridViewAdapter(Context context, List<Gift.GiftListBean> mDatas, int curIndex, int pageSize) {
        inflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
        this.curIndex = curIndex;
        this.pageSize = pageSize;
        this.mContext = context;
    }

    /**
     * 先判断数据集的大小是否足够显示满本页,
     * 如果够，则直接返回每一页显示的最大条目个数pageSize,
     * 如果不够，则有几项就返回几,(也就是最后一页的时候就显示剩余item)
     */
    @Override
    public int getCount() {
        return mDatas.size() > (curIndex + 1) * pageSize ? pageSize : (mDatas.size() - curIndex * pageSize);
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position + curIndex * pageSize);
    }

    @Override
    public long getItemId(int position) {
        return position + curIndex * pageSize;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv = convertView.findViewById(R.id.tv1);
            viewHolder.tv2 = convertView.findViewById(R.id.tv2);
            viewHolder.iv = convertView.findViewById(R.id.iv1);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /**
         * 在给View绑定显示的数据时，计算正确的position = position + curIndex * pageSize
         */
        int pos = position + curIndex * pageSize;
        viewHolder.tv.setText(mDatas.get(pos).getGiftName());
//        viewHolder.iv.setImageResource(mDatas.get(pos).iconRes);
        Picasso.with(mContext)
                .load(mDatas.get(pos).getGiftPic())
                .into(viewHolder.iv);
        viewHolder.tv2.setText(mDatas.get(pos).getGiftPrice());
        return convertView;
    }

    class ViewHolder {

        public ImageView iv;
        public TextView tv;
        public TextView tv2;
    }
}