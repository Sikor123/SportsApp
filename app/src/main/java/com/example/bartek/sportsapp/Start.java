package com.example.bartek.sportsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Start extends AppCompatActivity implements View.OnClickListener {


    TextView tx;
    Button bt;
    MyTask myTask;
    Intent intentInit;
    int czas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        intentInit = getIntent();
        bt = (Button)findViewById(R.id.wstecz1) ;

        czas = intentInit.getIntExtra("czas", 0);
        tx = (TextView) findViewById(R.id.time);
        tx.setText(Integer.toString(czas));


    }

    @Override
    protected void onResume() {
        super.onResume();

        tx = (TextView) findViewById(R.id.time);
        Log.i("wszedlem" , "1");
        myTask = new MyTask(Start.this , tx , czas);
        bt.setOnClickListener(this );
        Log.i("wszedlem" , "2");
        myTask.execute();
        Log.i("wszedlem" , "3");

    }

    public void onPause() {
        super.onPause();

    }

    @Override
    public void onClick(View v ) {
        switch(v.getId()){
            case R.id.wstecz1:

                Log.i("wszedlem" , "0");
                myTask.cancel(false);
                finish();
                break;

        }

    }


}