package com.example.asus.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadingTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;

            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);

                int data=reader.read();
                while(data!=-1)
                {
                    char current=(char)data;

                    result+=current;

                    data=reader.read();
                }

                return result;
            } catch (Exception e) {
                e.printStackTrace();

                return "Failure!";
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadingTask task=new DownloadingTask();
        String result=null;

        try {
            result=task.execute("https://zappycode.com/").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i("Result",result);
    }
}
