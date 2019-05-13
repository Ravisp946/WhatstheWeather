package com.example.asus.downloadingimages;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    public void imageButton(View view){

        DownloadImage task=new DownloadImage();
        Bitmap myimage;
        try{
            myimage=task.execute("https://m.media-amazon.com/images/M/MV5BMTQ3ODE2NTMxMV5BMl5BanBnXkFtZTgwOTIzOTQzMjE@._V1_UY317_CR21,0,214,317_AL_.jpg").get();

            imageView.setImageBitmap(myimage);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... urls) {
//            String result="";
            URL url;
            HttpURLConnection urlConnection=null;

            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                urlConnection.connect();
                InputStream in=urlConnection.getInputStream();
                Bitmap myBitmap=BitmapFactory.decodeStream(in);

                return myBitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView);
    }
}
