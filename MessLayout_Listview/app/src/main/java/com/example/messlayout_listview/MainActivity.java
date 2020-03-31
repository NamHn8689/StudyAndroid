package com.example.messlayout_listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    String a = "Lorem Ipsum is simply dummy text";
    ListView lvFriend;
    FriendAdapter friendAdapter;
    EditText edSearch;
    ArrayList<Friend> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFriend = findViewById(R.id.lvFriend);
        friendList = new ArrayList<Friend>();

        friendList.add(new Friend("Lorem", a));
        friendList.add(new Friend("Terijwezen", a));
        friendList.add(new Friend("Neque Porro", a));
        friendList.add(new Friend("Quisquam Est", a));
        friendList.add(new Friend("Qui Dolorem", a));
        friendList.add(new Friend("Quia Dolor", a));
        friendList.add(new Friend("Sit Amet", a));
        friendList.add(new Friend("Consectetur", a));
        friendList.add(new Friend("Adipisci Velit", a));
        friendList.add(new Friend("Ame To Srit", a));
        friendList.add(new Friend("ELe Tetterzetting", a));
        friendList.add(new Friend("Zet Terijwezen", a));
        friendList.add(new Friend("Tit Loreea", a));
        friendList.add(new Friend("Gebruwe Terijzeniken", a));
        friendList.add(new Friend("kKlassieke Literatuur ", a));

        friendAdapter = new FriendAdapter(MainActivity.this, R.layout.data_lv, friendList);
        lvFriend.setAdapter(friendAdapter);

        edSearch = findViewById(R.id.edSearch);

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Friend> newList = new ArrayList<>();

                for (int i = 0; i < friendList.size(); i++)
                    if (friendList.get(i).getName().toLowerCase().contains(s.toString().toLowerCase().trim()))
                        newList.add(friendList.get(i));
                FriendAdapter adapter = new FriendAdapter(MainActivity.this, R.layout.data_lv, newList);
                lvFriend.setAdapter(adapter);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

    }
}
