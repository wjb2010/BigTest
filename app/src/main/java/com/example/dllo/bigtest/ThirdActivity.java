package com.example.dllo.bigtest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.dllo.bigtest.Adapter.ThirdAdapter;
import com.example.dllo.bigtest.Fragment.FirstFragment;
import com.example.dllo.bigtest.Fragment.SecondFragment;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private ArrayList<Fragment> data;
    private ViewPager vp;

    private TabLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tab = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.vp);
        data=new ArrayList<>();

        data.add(new FirstFragment());
        data.add(new SecondFragment());

        ThirdAdapter t=new ThirdAdapter(getSupportFragmentManager(),data);
        vp.setAdapter(t);

        tab.setupWithViewPager(vp);




    }
}
