package com.example.rview;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/**
 * 第一个页面
 */
public class oneFragment extends Fragment{
    RecyclerView rv ;
    List<CallLogBean> mDatas = new ArrayList<>();   //数据源
    private oneAdapter adapter;
    public oneFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        rv = (RecyclerView) view.findViewById(R.id.call_rv);
        //        1.设置布局管理者
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
//        2.数据源
//      3.设置适配器
        adapter = new oneAdapter(getActivity(),mDatas);
        rv.setAdapter(adapter);
//        4.获取本地通话记录
        loadData();
        return view;
    }
    //获取本地通话记录   添加权限  Call_log
    private void loadData() {
//        1.权限  该版本22
//        2.获取ContentResolver对象
        ContentResolver resolver = getActivity().getContentResolver();
//      3.获取Uri地址
        Uri callUri = CallLog.Calls.CONTENT_URI;
//        4.开始执行查询的过程
        @SuppressLint("MissingPermission") Cursor cursor = resolver.query(callUri, null, null, null, null);
//        5.遍历Cursor信息
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("_id"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String time = cursor.getString(cursor.getColumnIndex("duration"));
            CallLogBean bean = new CallLogBean(id, number, time);
//            添加对象到集合当中
            mDatas.add(bean);
        }
//        数据源发生变化，提示adapter更新
        adapter.notifyDataSetChanged();
    }
}