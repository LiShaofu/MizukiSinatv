package com.mizuki.sinatv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mizuki.sinatv.R;

/**
 * Created by Administrator on 2017/8/23.
 */

public class FunctionsAvatarAdapter extends RecyclerView.Adapter<FunctionsAvatarHolder> {
    Context mContext;
    int array[] = new int[]{R.drawable.meinv, R.drawable.meinv, R.drawable.meinv,
            R.drawable.meinv, R.drawable.meinv};

    //用于传参：上下文对象，数据
    public FunctionsAvatarAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public FunctionsAvatarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.functions_avatar, parent, false);
        FunctionsAvatarHolder functionsAvatarHolder = new FunctionsAvatarHolder(view);
        return functionsAvatarHolder;
    }

    @Override
    public void onBindViewHolder(FunctionsAvatarHolder holder, int position) {
        if (holder instanceof FunctionsAvatarHolder) {
            //这是最主要的代码，显示内容
            holder.functionsIvAvatar.setImageResource(array[position]);
        }
    }

    @Override
    public int getItemCount() {
        return array.length;
    }
}

class FunctionsAvatarHolder extends RecyclerView.ViewHolder {
    de.hdodenhof.circleimageview.CircleImageView functionsIvAvatar;//头像

    public FunctionsAvatarHolder(View itemView) {
        super(itemView);
        functionsIvAvatar = itemView.findViewById(R.id.functions_iv_avatar);
    }
}