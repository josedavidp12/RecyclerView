package com.example.recyclerviewclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView getImageView;
    TextView tvGeTitle,tvGetDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getImageView = findViewById(R.id.getImageView);
        tvGeTitle = findViewById(R.id.tvGeTitle);
        tvGetDesc = findViewById(R.id.tvGetDesc);

        Intent intent = getIntent();

        String getTitle = intent.getStringExtra("title");
        String getDesc = intent.getStringExtra("desc");

        int getImage = intent.getIntExtra("icon",0);

        getImageView.setImageResource(getImage);
        tvGeTitle.setText(getTitle);
        tvGetDesc.setText(getDesc);









    }
}