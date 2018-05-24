package com.example.bartek.sportsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Setting extends AppCompatActivity implements View.OnClickListener{

    int counter = 0;
    Button btnm;
    Button btnp;
    Button start;
    TextView tx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        btnm = (Button)findViewById(R.id.scminus);
        btnp = (Button)findViewById(R.id.scplus);
        tx = (TextView)findViewById(R.id.seconds);
        start = (Button)findViewById(R.id.start);
        btnm.setOnClickListener(this);
        btnp.setOnClickListener(this);
        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.scminus:
               counter--;
               tx.setText(Integer.toString(counter));
               break;
            case R.id.scplus:
                counter++;
                tx.setText(Integer.toString(counter));
                break;
            case R.id.start:
                Intent intent = new Intent(this , Start.class);
                intent.putExtra("czas" , counter);
                startActivity(intent);
                break;
        }
    }
}
