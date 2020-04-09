package com.example.todoapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    protected TaskerDbHelper db;
    List<Task> list;
    MyAdapter myAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new TaskerDbHelper(this);
        list = db.getAllTasks();
        myAdapter = new MyAdapter(this, R.layout.list_inner_view, list);
        mListView = findViewById(R.id.listView1);
        mListView.setAdapter(myAdapter);
    }

    public void addTaskNow(View v) {
        EditText mEditText = findViewById(R.id.editText);
        String s = mEditText.getText().toString();
        if (!s.equalsIgnoreCase("")) {
            Task task = new Task(s, 0);
            db.addTask(task);
            Log.d("Tasker", "data added");
            Toast.makeText(getApplicationContext(), "Data added", Toast.LENGTH_SHORT).show();
            mEditText.setText("");
            list = db.getAllTasks();
            myAdapter = new MyAdapter(this, R.layout.list_inner_view, list);
            mListView.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();

        } else
            Toast.makeText(getApplicationContext(), "Enter the task description first!", Toast.LENGTH_SHORT).show();
    }
}