package com.example.bartek.sportsapp;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity  implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button);
        button.setOnClickListener( this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.i("wszedlem" , "jestem");
                Intent i = new Intent(this,Setting.class);
                startActivity(i);
                break;
        }

    }
}
