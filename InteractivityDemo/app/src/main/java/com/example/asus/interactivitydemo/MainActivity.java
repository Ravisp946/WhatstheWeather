package com.example.asus.interactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText nameEditText=(EditText)findViewById(R.id.nameEditText);
        EditText passEditText=(EditText)findViewById(R.id.passEditText);

        Log.i("INFO","This is my first Interactive App!!");

        Log.i("Values",nameEditText.getText().toString());
        Log.i("Values",passEditText.getText().toString());

        String s=nameEditText.getText().toString();
        Toast.makeText(this, "Hi ".concat(s), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
