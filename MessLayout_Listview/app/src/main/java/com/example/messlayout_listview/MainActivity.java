package com.example.messlayout_listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ListView lvFriend;
    String a = "Lorem Ipsum is simply dummy text";
    EditText edSearch;
    FriendAdapter friendAdapter;
    int textLength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFriend = findViewById(R.id.lvFriend);

        final ArrayList<Friend> friendList = new ArrayList<Friend>();
        final ArrayList<Friend> array_sort = new ArrayList<>();

        friendList.add(new Friend("Lorem", a));
        friendList.add(new Friend("Ipsum", a));
        friendList.add(new Friend("Neque Porro", a));
        friendList.add(new Friend("Quisquam Est", a));
        friendList.add(new Friend("Qui Dolorem", a));
        friendList.add(new Friend("Quia Dolor", a));
        friendList.add(new Friend("Sit Amet", a));
        friendList.add(new Friend("Consectetur", a));
        friendList.add(new Friend("Adipisci Velit", a));
        friendList.add(new Friend("ELe Tetterzetting", a));
        friendList.add(new Friend("Zet Terijwezen", a));
        friendList.add(new Friend("Gebruwe Terijzeniken", a));
        friendList.add(new Friend("kKlassieke Literatuur ", a));

        friendAdapter = new FriendAdapter(MainActivity.this, R.layout.data_lv, friendList);
        lvFriend.setAdapter(friendAdapter);

        // Locate the EditText in listview_main.xml
        edSearch = (EditText) findViewById(R.id.edSearch);

        // Capture Text in EditText
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                array_sort.clear();
                for (int i = 0; i < friendList.size(); i++) {
                    if (friendList.get(i).getName().toLowerCase().contains(edSearch.toString().toLowerCase())) {
                        array_sort.add(friendList.get(i));
                    }
                    friendAdapter = new FriendAdapter(MainActivity.this, R.layout.data_lv, array_sort);
                    lvFriend.setAdapter(friendAdapter);


//                adapter = new ListViewAdapter(MainActivity.this, array_sort);
//                list.setAdapter(adapter);

                }
            }

        });
    }
}
