package com.geektech.lesson5.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.geektech.lesson5.R;
import com.geektech.lesson5.models.Task;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView tvTaskTitle;
    TextView tvTaskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        tvTaskTitle = findViewById(R.id.tda_task_title);
        tvTaskDescription = findViewById(R.id.tda_task_description);

        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra("task");
        tvTaskTitle.setText(task.title);
        tvTaskDescription.setText(task.description);
    }
}
