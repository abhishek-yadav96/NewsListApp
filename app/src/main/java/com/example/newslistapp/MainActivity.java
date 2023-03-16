package com.example.newslistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.newslistapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
ApiInterface apiInterface;
ModelResponse modelResponse;
String q_,sortby,apikey;
MainactivityAdapter mainactivityAdapter;
    ArrayList<ModelResponse> arrmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        arrmodel = new ArrayList<>();
        apiInterface=RetrofitClass.getclientci().create(ApiInterface.class);
        apiInterface.getresponse("Apple","popularity","27d62c53103348ea8497532567a0dec4").enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                if(response.isSuccessful()){
                    modelResponse=response.body();
                    mainBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    mainactivityAdapter = new MainactivityAdapter(getApplicationContext(),modelResponse);
                    mainBinding.recyclerview.setAdapter(mainactivityAdapter);
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "not working", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}