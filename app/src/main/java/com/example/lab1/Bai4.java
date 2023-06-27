package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Bai4 extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText editNhap;
    private Button btnLoad;
    private TextView tvResult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        editNhap = (TextInputEditText) findViewById(R.id.edit_nhap);
        btnLoad = (Button) findViewById(R.id.btn_load);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            if (view.getId() == R.id.btn_load){
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(this, tvResult, editNhap);
                String sleepTime = editNhap.getText().toString();
                asyncTaskRunner.execute(sleepTime);
            }
        }
}