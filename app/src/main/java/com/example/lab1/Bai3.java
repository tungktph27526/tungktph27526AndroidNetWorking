package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai3 extends AppCompatActivity implements View.OnClickListener, Listener {
    private Button btnLoad;
    private ImageView img1;
    private TextView tvMes;
    public static final String IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btnLoad = (Button) findViewById(R.id.btn_load);
        img1 = (ImageView) findViewById(R.id.img_1);
        tvMes = (TextView) findViewById(R.id.tv_mes);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.btn_load){
           new ImageLoaded(this, this).execute(IMAGE_URL);
       }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        img1.setImageBitmap(bitmap);
        tvMes.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        tvMes.setText("Error Download image");
    }


}