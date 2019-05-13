package com.example.asus.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomnumber;
//    Random rand = new Random();
//
//    // Obtain a number between [0 - 49].
//    public int n = rand.nextInt(20)+1;

    public void generateRandomNumber()
    {
        Random rand=new Random();
        randomnumber=rand.nextInt(20)+1;
    }

    public void guess(View view){

        Log.i("INFO!","Button Pressed!");

        EditText editText=(EditText)findViewById(R.id.editText);

        String number=editText.getText().toString();
        int num=Integer.parseInt(number);
        d

        String msg;
        if(num>randomnumber)
        {
            msg="Lower";
        }
        else if(num<randomnumber)
        {
            msg="Higher";
        }
        else
        {
            msg="You Win!!";
            generateRandomNumber();
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }
}
