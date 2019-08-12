package com.sachin.retrofit_getdata.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sachin.retrofit_getdata.Models.Category;
import com.sachin.retrofit_getdata.R;
import com.sachin.retrofit_getdata.SecondActivity;

import java.util.ArrayList;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ResponseHolder>
{
    Context context;
    ArrayList<Category> arrayList;

    public ResponseAdapter(Context context, ArrayList<Category> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ResponseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.recycle_layout, viewGroup, false);
        ResponseHolder holder=new ResponseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResponseHolder responseHolder, final int i)
    {

        responseHolder.textView.setText("Name : "+arrayList.get(i).getName()+"\nID : "+arrayList.get(i).getId());
        responseHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(context, SecondActivity.class);
                Bundle bundle=new Bundle();

                bundle.putSerializable("datalist",arrayList);
                intent.putExtra("data",bundle);
                intent.putExtra("position",i);
                context.startActivity(intent);

                //Toast.makeText(context, ""+arrayList.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }

    public class ResponseHolder extends RecyclerView.ViewHolder
    {

        TextView textView;
        public ResponseHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textid);
        }
    }
}
