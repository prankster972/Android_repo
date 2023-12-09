package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner noun;
    ListView adverbsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] adjective = res.getStringArray(R.array.Adjective);

        noun = findViewById(R.id.spinner);
        adverbsList = findViewById(R.id.list_view);

        ArrayAdapter<?> listView = ArrayAdapter.createFromResource(this,
                R.array.Adjective,
                android.R.layout.simple_spinner_item);
        adverbsList.setAdapter(listView);


        Resources noun_res = getResources();
        String[] noun_array = noun_res.getStringArray(R.array.Noun);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Noun,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noun.setAdapter(adapter);

    }

    public void CreateText(View view) {
        TextView textView = findViewById(R.id.textView);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        noun = findViewById(R.id.spinner);
        adverbsList = findViewById(R.id.list_view);
        String test = noun.getSelectedItem().toString();
        ListAdapter test2 = adverbsList.getAdapter();
        int convert = Math.toIntExact(test6);
        test2.getItemId();
//        String selectedFromList = (String) (adverbsList.getItemAtPosition(test2));
        int test3 = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(test3);
        String test5 = radioButton.getText().toString();
        String all =test2 + " "+ test +" "+ test5;
        textView.setText(all);
    }
}