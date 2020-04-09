package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends BaseAdapter {
    public Context context;
    public int layoutResourceId;
    public List<Task> taskList;

    public MyAdapter(Context context, int layoutResourceId, List<Task> taskList) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_inner_view, null);

        TextView mTextView = convertView.findViewById(R.id.text);
        mTextView.setText(taskList.get(position).getTaskName());
        return convertView;
    }

}


//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.list_inner_view, parent, false);
//        CheckBox chk=(CheckBox)rowView.findViewById(R.id.chkStatus);
//        Task current=taskList.get(position);
//        chk.setText(current.getTaskName());
//        chk.setChecked(current.getStatus()==1?true:false);
//
//        return rowView;
//    }
