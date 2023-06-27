package com.example.lab1;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class AsyncTaskRunner extends AsyncTask<String, String, String> {
    private String resp;
    private ProgressDialog dialog;
    private TextView tvressult;
    private EditText time;
    private Context context;

    public AsyncTaskRunner (Context context, TextView tvressult, EditText time){
        this.tvressult = tvressult;
        this.context = context;
        this.time = time;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "ProgressDialog", "Wait for " + time.getText().toString()+ "seconds");
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("sleeping...");
        try{
            int time = Integer.parseInt(strings[0]) * 1000;
            Thread.sleep(time);
            resp = "slept for "+ strings[0]+ "seconds";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (dialog.isShowing()){
            dialog.dismiss();
        }
        tvressult.setText(s);
    }

}
