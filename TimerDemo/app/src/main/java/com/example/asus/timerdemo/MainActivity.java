package com.example.asus.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Handler handler=new Handler();
//
//        final Runnable run=new Runnable() {
//            @Override
//            public void run() {
//                Log.i("Hey its us","A second has passed!!");
//
//                handler.postDelayed(this,1000);
//            }
//        };
//        handler.post(run);

        new CountDownTimer(10000,1000)
        {
            public void onTick(long millisecondsuntildone)
            {
                Log.i("Seconds Left!!",String.valueOf(millisecondsuntildone/1000));
            }
            public void onFinish()
            {
                Log.i("We're Done!!","No more Counting!!");
            }
        }.start();
    }
}
