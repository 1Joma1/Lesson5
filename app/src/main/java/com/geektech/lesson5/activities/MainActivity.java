package com.geektech.lesson5.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.geektech.lesson5.R;
import com.geektech.lesson5.adapters.MainAdapter;
import com.geektech.lesson5.interfaces.IOnTaskListener;
import com.geektech.lesson5.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnTaskListener {

    RecyclerView recyclerView;
    Button addButton;

    ArrayList<Task> data = new ArrayList<Task>(){{
       add(new Task(1, "Title task 1", "Description"));
        add(new Task(2, "Title task 2", "Description"));
        add(new Task(3, "Title task 3", "Description"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.mainAdd);

        recyclerView = findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MainAdapter adapter = new MainAdapter(data, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onTaskClick(int id) {
        Log.d("ololo", "on Task click : " + id);
        Task task = data.get(2);
        Intent intent = new Intent(this, TaskDetailsActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            assert data != null;
            String id = data.getStringExtra("resId");
            String title = data.getStringExtra("resTitle");
            String des = data.getStringExtra("resDes");
            MainActivity.this.data.add(new Task(Integer.valueOf(id), title, des));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
