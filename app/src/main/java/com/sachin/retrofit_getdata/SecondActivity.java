package com.sachin.retrofit_getdata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sachin.retrofit_getdata.Models.Category;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    ArrayList<Category> categoryArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.text2id);

        Bundle bundle=getIntent().getBundleExtra("data");
        Bundle bundle2=getIntent().getExtras();


        categoryArrayList= (ArrayList<Category>) bundle.getSerializable("datalist");

        int pos= bundle2.getInt("position");


        tv.setText("Name : "+categoryArrayList.get(pos).getName()+"\nID : "+categoryArrayList.get(pos).getId());
    }
}
