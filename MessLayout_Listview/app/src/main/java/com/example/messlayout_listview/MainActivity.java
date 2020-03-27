package com.example.messlayout_listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

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

        friendAdapter = new FriendAdapter(MainActivity.this, friendList);
        lvFriend.setAdapter(friendAdapter);

        // Locate the EditText in listview_main.xml
        edSearch = (EditText) findViewById(R.id.edSearch);

        final ArrayList<Friend> array_sort = new ArrayList<>();

        // Capture Text in EditText
        edSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = edSearch.getText().toString().toLowerCase(Locale.getDefault());
                friendAdapter.filter(text);
            }

        });
    }
}
