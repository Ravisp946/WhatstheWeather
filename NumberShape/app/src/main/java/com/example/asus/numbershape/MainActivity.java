package com.example.asus.numbershape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class Numbers{
        int number;

        public boolean isTriangular()
        {
            int x=1;

            int triangularnumber=1;

            while(triangularnumber<number)
            {

                x++;
                triangularnumber=triangularnumber+x;
            }
            if(triangularnumber==number)
                return true;
            else
                return false;
        }

        public boolean isSquare()
        {
            Double d=Double.valueOf(number);
            Double sr=Math.sqrt(d);
            return (sr-Math.floor(sr)==0);
        }
    }
    public void Square(View view)
    {
        Log.i("INFO","Square Button Pressed");

        EditText editText=(EditText)findViewById(R.id.editText);

        int num=Integer.parseInt(editText.getText().toString());

        Numbers mynumber=new Numbers();
        mynumber.number=num;
        String msg;
        if(mynumber.isSquare())
            msg="Number is Square!!";
        else
            msg="Number is not Sqaure!!";

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    public void Traingular(View view)
    {
        Log.i("INFO","Triangular Button Pressed");

        EditText editText=(EditText)findViewById(R.id.editText);

        int num=Integer.parseInt(editText.getText().toString());

        Numbers mynumber=new Numbers();
        mynumber.number=num;
        String msg;
        if(mynumber.isTriangular())
            msg="Number is Triangular!!";
        else
            msg="Number is not Triangular!!";

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
