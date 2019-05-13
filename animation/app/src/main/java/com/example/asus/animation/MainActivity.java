package com.example.asus.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean bartImage=true;

    public void fade(View view)
    {
        Log.i("INFO","Image Tapped");

        ImageView bartImageView=(ImageView)findViewById(R.id.bartImageView);

        ImageView homorImageView=(ImageView)findViewById(R.id.homorImageView);

//        if(bartImage) {
//            bartImageView.animate().alpha(0).setDuration(2000);
//
//            homorImageView.animate().alpha(1).setDuration(2000);
//            bartImage=false;
//        }else
//        {
//            homorImageView.animate().alpha(0).setDuration(2000);
//
//            bartImageView.animate().alpha(1).setDuration(2000);
//            bartImage=true;
//        }
        bartImageView.animate().translationXBy(1000).rotation(-3600).setDuration(2000);


        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView=(ImageView)findViewById(R.id.bartImageView);
        bartImageView.setX(-1000);

        bartImageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);

    }
}
