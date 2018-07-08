package com.example.rview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class oneAdapter extends RecyclerView.Adapter<oneAdapter.CallViewHolder>{
    private Context context;
    private List<CallLogBean>mDatas;

    public oneAdapter(Context context, List<CallLogBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    @Override
    public CallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_call_log, parent, false);
        CallViewHolder holder = new CallViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CallViewHolder holder, int position) {
        CallLogBean logBean = mDatas.get(position);
        holder.idTv.setText("编号："+logBean.getId());
        holder.numberTv.setText("电话号码："+logBean.getNumber());
        holder.timeTv.setText("持续时间："+logBean.getTime()+"秒");
    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class CallViewHolder extends RecyclerView.ViewHolder{
        TextView idTv,numberTv,timeTv;
        public CallViewHolder(View itemView) {
            super(itemView);
            idTv     =   itemView.findViewById(R.id.item_call_id);
            numberTv =   itemView.findViewById(R.id.item_call_number);
            timeTv   =   itemView.findViewById(R.id.item_call_time);
        }
    }
}