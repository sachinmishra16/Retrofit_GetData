package com.sachin.retrofit_getdata.API;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api_Client
{
    public static String Base_Url="http://dev.appsquadz.com/story_stream/index.php/";

    public static Retrofit retrofit;

    private static OkHttpClient.Builder httpClient=new OkHttpClient.Builder();

    public static Retrofit getRetrofit_Instance()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);



        OkHttpClient okHttpClient = httpClient.addInterceptor(interceptor).connectTimeout(25,
                TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS) .
                writeTimeout(30, TimeUnit.SECONDS).build();



        /*final Gson gson = new GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();*/

        if (retrofit==null)
        {

        /*retrofit=new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create(*//*gson*//*))
                .*//*client(okHttpClient).*//*build();
*/

            retrofit=new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit;
        }
}
