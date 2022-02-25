package com.example.bigbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Fruit_List extends AppCompatActivity
{

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        add = findViewById(R.id.add);

        final ArrayList<NumberView> arrayList = new ArrayList<NumberView>();

        arrayList.add(new NumberView(R.drawable.banana, "Banana", "75"));
        arrayList.add(new NumberView(R.drawable.apple, "Apple", "100"));
        arrayList.add(new NumberView(R.drawable.graps, "Graps", "60"));
        arrayList.add(new NumberView(R.drawable.chickoo, "Chickoo", "90"));
        arrayList.add(new NumberView(R.drawable.mango, "Mango", "200"));

        NumbersAdapterView numbersArrayAdapter = new NumbersAdapterView(this, arrayList);
        ListView numbersListView = findViewById(R.id.listview);

        numbersListView.setAdapter(numbersArrayAdapter);




    }

}