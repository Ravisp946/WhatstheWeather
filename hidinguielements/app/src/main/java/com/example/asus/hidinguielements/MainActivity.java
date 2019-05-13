package com.example.asus.hidinguielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean click=true;
    public void check(View view)
    {
        Button button=(Button)findViewById(R.id.button);
        Button button2=(Button)findViewById(R.id.button2);
        TextView textView=(TextView)findViewById(R.id.textView);
        if(click)
        {
            textView.setVisibility(View.VISIBLE);
            button.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.VISIBLE);
            click=false;
        }
        else
        {   click=true;
            textView.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
            button2.setVisibility(View.INVISIBLE);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
