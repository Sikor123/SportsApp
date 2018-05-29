package com.example.bartek.sportsapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class MyTask  extends AsyncTask<Integer , String , Void> {

    Context context;
    TextView tx;
    int czas;

    MyTask(Context context , TextView tx, int czas){
        this.context = context;
        this.tx = tx;
        this.czas = czas;
    }

    @Override
    protected void onPreExecute() {
        Log.i("wszedlem" , "4");
        //publishProgress("Zaczynamy");
//        Log.i("wszedlem" , "5");
//        try {
//            wait(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        Log.i("wszedlem" , "66");
        //long start = System.currentTimeMillis();
        synchronized (this){
        while (czas >= 0) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (System.currentTimeMillis() - start >= 1000) {
//                Log.i("wszedlem" , "sekunda");
//                start = System.currentTimeMillis();
//                czas--;
//                czas--;
//                publishProgress(Integer.toString(czas));
//            }
            if (isCancelled()) break;
            Log.i("wszedlem" , "77");
            czas--;
            publishProgress(Integer.toString(czas));
        }}
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        publishProgress("Koniec");


    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.i("wszedlem" , "88");
        tx.setText(values[0]);
        Log.i("wszedlem" , "99");
    }

    @Override
    protected void onCancelled() {

    }
}