package com.example.dllo.bigtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Bitmap bitmap;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.start_btn);
        iv = (ImageView) findViewById(R.id.iv);
        btn.setOnClickListener(this);

        new GetImage().execute("http://img.pipaw.net/wy/editor/news/2016/10/24/662f91df32c851677b8198b3f91159d9.jpg");


    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }



    class GetImage extends AsyncTask<String,Void,Bitmap>{




        @Override
        protected Bitmap doInBackground(String... params) {



            try {
                URL url=new URL(params[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                InputStream is=connection.getInputStream();
              bitmap= BitmapFactory.decodeStream(is);






            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return bitmap;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }
    }


}
