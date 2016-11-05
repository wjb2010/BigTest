package com.example.dllo.bigtest.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dllo.bigtest.Adapter.RecyclerViewAdapter;
import com.example.dllo.bigtest.Bean.TestBean;
import com.example.dllo.bigtest.Interface.MyClick;
import com.example.dllo.bigtest.R;
import com.example.dllo.bigtest.TestActivity;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */

public class SecondFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<TestBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_two_recyclerview,container,false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv = (RecyclerView) view.findViewById(R.id.rv);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        data=new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            TestBean t=new TestBean("嘿嘿"+i);
//            data.add(t);
//        }


        Cursor cursor=getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        if (cursor!=null){
            cursor.moveToFirst();
            do {
                String name=cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));

                TestBean t=new TestBean(name);
                data.add(t);
            }while (cursor.moveToNext());




        }




        RecyclerViewAdapter r=new RecyclerViewAdapter(getContext());
        r.setData(data);
        r.setMyClick(new MyClick() {
            @Override
            public void MyClick(String data) {

                Intent intent=new Intent(getContext(), TestActivity.class);
                intent.putExtra("text",data);
                startActivity(intent);
            }
        });
        rv.setAdapter(r);

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false));






    }
}
