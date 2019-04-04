package com.geektech.lesson5.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geektech.lesson5.R;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd;
    EditText etId, etTitle, etDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = findViewById(R.id.btnAdd);
        etId = findViewById(R.id.etId);
        etTitle = findViewById(R.id.etTitle);
        etDes = findViewById(R.id.etDes);

        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("resId", etId.getText().toString());
            returnIntent.putExtra("resTitle", etTitle.getText().toString());
            returnIntent.putExtra("resDes", etDes.getText().toString());
            setResult(RESULT_OK, returnIntent);
            finish();
    }
}
