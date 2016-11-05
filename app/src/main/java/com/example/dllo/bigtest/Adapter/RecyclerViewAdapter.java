package com.example.dllo.bigtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.bigtest.Bean.TestBean;
import com.example.dllo.bigtest.Interface.MyClick;
import com.example.dllo.bigtest.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/4.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RVViewHolder> {

    private ArrayList<TestBean> data;
    private Context context;
    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TestBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        RVViewHolder viewHolder=new RVViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.MyClick(data.get(position).getName());
            }
        });



        holder.tv.setText(data.get(position).getName());




    }

    @Override
    public int getItemCount() {
        return data!=null&&data.size()>0?data.size():0;
    }



    class RVViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public RVViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.rv_tv);


        }
    }


}
