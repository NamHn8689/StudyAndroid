package com.example.messlayout_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends BaseAdapter {

    public Context context;
    public int layout;
    ArrayList<Friend> friendList;

    public FriendAdapter(Context context, int layout, ArrayList<Friend> friendList) {
        this.context = context;
        this.layout = layout;
        this.friendList = friendList;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvMessage = convertView.findViewById(R.id.tvMessage);

        tvName.setText(friendList.get(position).getName());
        tvMessage.setText(friendList.get(position).getMessage());

        return convertView;
    }
}
