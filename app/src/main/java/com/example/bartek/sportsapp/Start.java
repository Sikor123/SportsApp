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


public class Start extends AppCompatActivity {

    private static final String TAG = "BroadcastTest";
    private Intent clockIntent;
    TextView tx;


    private IntentFilter filter =
            new IntentFilter("com.example.broadcastsample.PRZYKLADOWY");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clockIntent = new Intent(this, ClockService.class);
        setContentView(R.layout.start_activity);
        Intent intent = getIntent();
        int czas = intent.getIntExtra("czas", 0);
        tx = (TextView) findViewById(R.id.time);
        tx.setText(Integer.toString(czas));


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "jestem1");
        startService(clockIntent);
        registerReceiver(broadcastReceiver, new IntentFilter(ClockService.BROADCAST_ACTION));

    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        stopService(clockIntent);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
        }
    };

    private void updateUI(Intent intent) {
        String time = intent.getStringExtra("counter");
        Log.d(TAG, time);
        tx.setText(time);
    }
}

