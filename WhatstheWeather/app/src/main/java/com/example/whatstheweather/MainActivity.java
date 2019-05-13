package com.example.whatstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
         EditText cityText;
    Button button;

    public void checkWeather(View view)
    {

        String city=cityText.getText().toString();


        DownloadTask task=new DownloadTask();
        String result="ABC";

        try
        {
            result=task.execute("https://openweathermap.org/data/2.5/weather?q="+city+"&appid=b6907d289e10d714a6e88b30761fae22").get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        InputMethodManager mgr=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cityText.getWindowToken(),0);
        
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String result="";

            URL url;
            HttpURLConnection urlConnection=null;
            try{
                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                urlConnection.connect();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);

                int data=reader.read();
                while(data!=-1)
                {
                    char current=(char)data;
                    data=reader.read();
                    result+=current;

                }
                return result;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return "Failure";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try{
                JSONObject jsonObject=new JSONObject(s);
                String weatherInfo=jsonObject.getString("weather");

                Log.i("Weather Content",weatherInfo);

                JSONArray arr=new JSONArray(weatherInfo);

                for(int i=0;i<arr.length();i++)
                {
                    JSONObject jsonPart=arr.getJSONObject(i);
                    resultTextView.setVisibility(View.VISIBLE);
                    resultTextView.setText(jsonPart.getString("main")+'\n'+jsonPart.getString("description"));

                    Log.i("main! ",jsonPart.getString("main"));
                    Log.i("description!",jsonPart.getString("description"));

                }
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityText=(EditText) findViewById(R.id.cityText);
        resultTextView=(TextView)findViewById(R.id.resultTesxtVIew);
    }
}
