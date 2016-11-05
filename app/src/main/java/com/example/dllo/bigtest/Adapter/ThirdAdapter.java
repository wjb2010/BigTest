package com.example.dllo.bigtest.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */

public class ThirdAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> data;
    private String[] title={"第一页","第二页"};

    public ThirdAdapter(FragmentManager fm,ArrayList<Fragment> data) {
        super(fm);
        this.data=data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null&&data.size()>0?data.size():0;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
