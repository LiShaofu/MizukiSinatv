package com.mizuki.sinatv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mizuki.sinatv.R;

import java.util.List;

/**
 * functions 的消息 Adapter
 */

public class FunctionsMessageAdapter extends RecyclerView.Adapter<MessageHolder> {
    List<String> list ;
    Context mContext;

    public FunctionsMessageAdapter(Context mContext,List<String> list) {
        this.mContext = mContext;
        this.list=list;
    }

    public void setData(String s){
        this.list.add(s);
        notifyDataSetChanged();
    }
    public List<String> getData(){
       return list;
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.functions_message, parent, false);
        MessageHolder messageHolder = new MessageHolder(view);
        return messageHolder;
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        //这是最主要的代码，显示内容
//        holder.functionsTvUser.setText(list.get(position));
        holder.functionsTvMessage.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MessageHolder extends RecyclerView.ViewHolder {
    TextView functionsTvUser;
    TextView functionsTvMessage;

    public MessageHolder(View itemView) {
        super(itemView);
        functionsTvUser = itemView.findViewById(R.id.functions_tv_user);
        functionsTvMessage = itemView.findViewById(R.id.functions_tv_message);
    }
}