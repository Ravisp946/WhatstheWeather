package com.example.asus.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView=(ListView)findViewById(R.id.myListView);

        final ArrayList<String> myFamily=new ArrayList<String>();

        myFamily.add("Ravi");
        myFamily.add("Saroj");
        myFamily.add("Sandy");
        myFamily.add("Sapna");
        myFamily.add("Mummy");
        myFamily.add("Papa");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("Person Name!",myFamily.get(position));
            Toast.makeText(MainActivity.this, "This is the Tapped Name "+myFamily.get(position), Toast.LENGTH_LONG).show();
            }
        });


    }
}
