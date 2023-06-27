package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    private Button btnBai1;
    private Button btnBai2;
    private Button btnBai3;
    private Button btnBai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btnBai1 = (Button) findViewById(R.id.btn_bai1);
        btnBai2 = (Button) findViewById(R.id.btn_bai2);
        btnBai3 = (Button) findViewById(R.id.btn_bai3);
        btnBai4 = (Button) findViewById(R.id.btn_bai4);

    }
    public void Bai1(View view){
        Intent intent = new Intent(MainActivity2.this, Bai1.class);
        startActivity(intent);
    }
    public void Bai2(View view){
        Intent intent = new Intent(MainActivity2.this, Bai2.class);
        startActivity(intent);
    }
    public void Bai3(View view){
        Intent intent = new Intent(MainActivity2.this, Bai3.class);
        startActivity(intent);
    }
    public void Bai4(View view){
        Intent intent = new Intent(MainActivity2.this, Bai4.class);
        startActivity(intent);
    }
}