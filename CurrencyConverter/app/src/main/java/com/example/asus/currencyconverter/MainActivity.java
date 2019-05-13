package com.example.asus.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view)
    {
        EditText editText=(EditText)findViewById(R.id.editText);

        Log.i("INFO","Button Pressed!");

        String amountindollar=editText.getText().toString();

        Double amountindollardouble=Double.parseDouble(amountindollar);

        Double amountinrupee=amountindollardouble*69.88;

        String amountinrupeestring=Double.toString(amountinrupee);

        Toast.makeText(this, "$"+amountindollar+" is "+amountinrupeestring+" in rupees.", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
