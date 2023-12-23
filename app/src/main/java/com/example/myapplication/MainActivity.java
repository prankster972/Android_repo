package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] adj = { "Кривой", "Длинный", "Красивый", "Старый"};
    String selectedItem;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner noun;
        noun = findViewById(R.id.spinner);
        TextView text = findViewById(R.id.textView);
        ListView adjectiveList;
        adjectiveList = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, adj);
        adjectiveList.setAdapter(adapter);

        adjectiveList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedItem = adj[position];
//                text.setText(selectedItem);

            }
        });

        Resources noun_res = getResources();
        String[] noun_array = noun_res.getStringArray(R.array.Noun);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.Noun,
                android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noun.setAdapter(adapter1);

    }

    public void CreateText(View view) {
        TextView text = findViewById(R.id.textView);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        Spinner noun = findViewById(R.id.spinner);
        String test = noun.getSelectedItem().toString();
        int test3 = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(test3);
        String test5 = radioButton.getText().toString();
        String test1 = selectedItem;
        String all =test1 + " " + test + " " + test5;
        text.setText(all);
    }

}