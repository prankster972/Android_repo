package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] adjective = res.getStringArray(R.array.Adjective);
        ListView adverbsList = findViewById(R.id.list_view);
        // создаем адаптер
        ArrayAdapter<?> listView = ArrayAdapter.createFromResource(this,
                R.array.Adjective,
                android.R.layout.simple_spinner_item);
        // устанавливаем для списка адаптер
        adverbsList.setAdapter(listView);


        Resources noun_res = getResources();
        String[] noun_array = noun_res.getStringArray(R.array.Noun);
        Spinner noun = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Noun,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noun.setAdapter(adapter);



    }
}