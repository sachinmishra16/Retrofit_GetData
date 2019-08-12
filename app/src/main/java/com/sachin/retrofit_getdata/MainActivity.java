package com.sachin.retrofit_getdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sachin.retrofit_getdata.API.Api_Client;
import com.sachin.retrofit_getdata.Adapter.ResponseAdapter;
import com.sachin.retrofit_getdata.Models.Category;
import com.sachin.retrofit_getdata.Models.CategoryResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ArrayList<Category> arrayList=new ArrayList<>();
    String data="";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerid);


        Api_interface api_interface= Api_Client.getRetrofit_Instance().create(Api_interface.class);

        Call<CategoryResponse> call=api_interface.get_category();

        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {

                CategoryResponse categoryResponse=response.body();

                arrayList.addAll(categoryResponse.getResult());

                ResponseAdapter adapter=new ResponseAdapter(MainActivity.this,arrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.hasFixedSize();

                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

                Log.d("errr",t.getMessage());
            }
        });
    }
}
