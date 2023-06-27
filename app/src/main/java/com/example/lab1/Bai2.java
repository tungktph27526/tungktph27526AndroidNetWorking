package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private ImageView img1;
    private TextView tvMes;
    private ProgressDialog progressDialog;
    private String url = "https://upload.wikimedia.org/wikipedia/commons/2/20/FPT_Polytechnic.png";
    private Bitmap bitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        btnLoad = (Button) findViewById(R.id.btn_load);
        img1 = (ImageView) findViewById(R.id.img_1);
        tvMes = (TextView) findViewById(R.id.tv_mes);
        btnLoad.setOnClickListener(this);
    }
    private Handler messageHandler = new Handler () {
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvMes.setText(message);
            img1.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };
    @Override
    public void onClick(View view) {
        progressDialog = progressDialog.show(Bai2.this, "", "Downloading...");
        Runnable arunnable = new Runnable() {
            @Override
            public void run() {
                bitmap = dowloadBitmap(url);
                Message msg = messageHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String threadMesssage = "Image downloaded";
                bundle.putString("message", threadMesssage);
                msg.setData(bundle);
                messageHandler.sendMessage(msg);
            }
        };
        Thread athread = new Thread(arunnable);
        athread.start();
    }
    private Bitmap dowloadBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}