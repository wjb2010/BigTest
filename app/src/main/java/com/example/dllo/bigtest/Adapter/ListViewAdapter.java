package com.example.dllo.bigtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.bigtest.Bean.TestBean;
import com.example.dllo.bigtest.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */

public class ListViewAdapter extends BaseAdapter{

    private ArrayList<TestBean> data;
    private Context context;

    public ListViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TestBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return data!=null?data.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LVViewHolder viewHolder=null;

        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_item,parent,false);
            viewHolder=new LVViewHolder(convertView);
            convertView.setTag(viewHolder);



        }else {

            viewHolder= (LVViewHolder) convertView.getTag();

        }
        viewHolder.tv.setText(data.get(position).getName());


        return convertView;
    }



    class LVViewHolder{
        private TextView tv;

        public LVViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.lv_tv_name);
        }
    }

}
