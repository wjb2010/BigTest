package com.example.dllo.bigtest.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.bigtest.Adapter.ListViewAdapter;
import com.example.dllo.bigtest.Bean.TestBean;
import com.example.dllo.bigtest.R;
import com.example.dllo.bigtest.TestActivity;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */

public class FirstFragment extends Fragment{

    private ListView lv;
    private ArrayList<TestBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one_listview,container,false);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            data=new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//
//            TestBean b=new TestBean("哈哈"+i);
//            data.add(b);
//        }

        Cursor cursor=getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursor!=null){
            cursor.moveToFirst();
            do {
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                TestBean t=new TestBean(name);
                data.add(t);
            }while (cursor.moveToNext());




        }





        ListViewAdapter l=new ListViewAdapter(getContext());
        l.setData(data);
        lv.setAdapter(l);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), TestActivity.class);
                intent.putExtra("text",data.get(position).getName());
                startActivity(intent);
            }
        });


    }
}
