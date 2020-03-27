package com.example.messlayout_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class FriendAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflate;
    static ArrayList<Friend> friendList_original;
    static ArrayList<Friend> temp_arrayList;

    public FriendAdapter(Context mContext, ArrayList<Friend> friendList_original) {
        this.mContext = mContext;
        this.friendList_original = friendList_original;
        inflate = LayoutInflater.from(mContext);
        this.temp_arrayList = new ArrayList<Friend>();
        this.temp_arrayList.addAll(friendList_original);
    }

    public class ViewHolder {
        TextView name;
        TextView message;
    }

    @Override
    public int getCount() {
        return temp_arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return temp_arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflate.inflate(R.layout.data_lv, null);
            holder.name = (TextView) convertView.findViewById(R.id.tvName);
            holder.message = (TextView) convertView.findViewById(R.id.tvMessage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(temp_arrayList.get(position).getName());
        holder.message.setText(temp_arrayList.get(position).getMessage());
        return convertView;
    }

    //Filter Class
    public static void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault()).trim();
        temp_arrayList.clear();
        if (charText.length() == 0) {
            temp_arrayList.addAll(friendList_original);
        } else {
            for (Friend t : friendList_original) {
                if (t.getName().toLowerCase(Locale.getDefault()).contains(charText))
                    temp_arrayList.add(t);
            }
        }
    }

}
