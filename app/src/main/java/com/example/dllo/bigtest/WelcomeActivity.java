package com.example.dllo.bigtest;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.dllo.bigtest.Adapter.WelcomeAdapter;
import com.example.leisuredb.DBValues;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<View> data;
    private ViewPager vp;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        vp = (ViewPager) findViewById(R.id.vp);


        data=new ArrayList<>();

        View viewOne= getLayoutInflater().inflate(R.layout.welcome_one,null);
        View viewTwo= getLayoutInflater().inflate(R.layout.welcome_two,null);
        View viewThree= getLayoutInflater().inflate(R.layout.welcome_three,null);

        viewThree.findViewById(R.id.welcome_btn).setOnClickListener(this);
        data.add(viewOne);
        data.add(viewTwo);
        data.add(viewThree);

        WelcomeAdapter w=new WelcomeAdapter(data);
        vp.setAdapter(w);





    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}
