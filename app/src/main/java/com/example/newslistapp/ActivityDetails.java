package com.example.newslistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.newslistapp.databinding.ActivityDetailsBinding;
import com.squareup.picasso.Picasso;

public class ActivityDetails extends AppCompatActivity {
ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        binding.details.setText(intent.getStringExtra("details"));
        binding.de.setText(intent.getStringExtra("desc"));
        binding.au.setText(intent.getStringExtra("aut"));
        binding.date.setText(intent.getStringExtra("date"));
        Picasso.get().load( intent.getStringExtra("pic")).into(binding.im);

    }
}