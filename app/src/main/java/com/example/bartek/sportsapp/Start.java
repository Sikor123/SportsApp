package com.example.bartek.sportsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.sql.Time;


public class Start extends AppCompatActivity {


    TextView tx;

    private BroadcastReceiver broadcast = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            //Tutaj tak samo jak w poprzednim przykładzie.
        }
    };

    private IntentFilter filter =
            new IntentFilter("com.example.broadcastsample.PRZYKLADOWY");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        Intent intent = getIntent();
        int czas = intent.getIntExtra("czas", 0);

        tx = (TextView) findViewById(R.id.time);
        tx.setText(Integer.toString(czas));
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcast, filter);
        tx = (TextView) findViewById(R.id.time);
        Intent intent = getIntent();
        int czas = intent.getIntExtra("czas", 0);
        long start = System.currentTimeMillis();
        while (czas > 0) {

            if (System.currentTimeMillis() - start >= 1000) {
                Log.i("wszedlem" , "sekunda");
                start = System.currentTimeMillis();
                czas--;
                tx.setText(Integer.toString(czas));

            }
        }
    }

    public void onPause() {
        unregisterReceiver(broadcast);
        // trzeba zawsze po sobie posprzątać w tym przypadku wyrejestrować receiver.
        super.onPause();
    }
}

