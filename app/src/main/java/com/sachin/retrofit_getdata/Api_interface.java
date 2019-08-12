package com.sachin.retrofit_getdata;

import com.sachin.retrofit_getdata.Models.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_interface
{
    @GET("api_panel/category/get_category")
    Call<CategoryResponse> get_category();

}
