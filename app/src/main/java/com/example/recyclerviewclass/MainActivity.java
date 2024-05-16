package com.example.recyclerviewclass;

import static java.util.Locale.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    SearchView searchView;
    CustomAdepter customAdepter;

    ArrayList<CustomModel> customModelArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        itemDisplay();



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText);

                return true;



            }
        });





    }

    private void filter(String newText) {

        ArrayList<CustomModel> filtereadList = new ArrayList<>();

        for (CustomModel item :customModelArrayList){

            if (item.getTitle().toLowerCase().contains(newText.toLowerCase())){

                filtereadList.add(item);


            }

            customAdepter.filterList(filtereadList);

        }






    }

    private void itemDisplay(){

        customModelArrayList.add(new CustomModel(R.drawable.python,"Python","Python Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.java,"Java","Java Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.kotlin,"Kotlin","Kotlin Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.javascript,"Javascript","Javascript Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.php,"Php","PHP Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.cpp,"CPP","CPP Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.swift,"Swift","Swift Programing"));
        customModelArrayList.add(new CustomModel(R.drawable.ruby,"Ruby","Ruby Programing"));



         customAdepter = new CustomAdepter(this,customModelArrayList);
        recyclerView.setAdapter(customAdepter);


    }
}