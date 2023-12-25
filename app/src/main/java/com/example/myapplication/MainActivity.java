package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity{

    String[] adj = { "Кривой", "Длинный", "Красивый", "Старый"};
    ArrayList<String> list = new ArrayList<>();
    String selectedItem;
    ArrayList<String> adjAL = new ArrayList<String>();
    ArrayAdapter<String> listAdapter;
    ArrayAdapter<String> adapter;
    EditText editText;
    String all;
    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner noun;
        for (int i=0; i<adj.length; i++)
        {
            list.add(adj[i]);
        }
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        noun = findViewById(R.id.spinner);
        TextView text = findViewById(R.id.textView);
        ListView adjectiveList;
        adjectiveList = findViewById(R.id.list_view);
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, adj);
        adjectiveList.setAdapter(listAdapter);

        adjectiveList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                selectedItem = list.get(position);
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

        editText = findViewById(R.id.editTextText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && keyCode == keyEvent.KEYCODE_ENTER)
                {
                        edit(view);
                }
                return false;
            }
        });

    }

    public void CreateText(View view) {
        TextView text = findViewById(R.id.textView);
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        CheckBox check = findViewById(R.id.checkBox);
        Spinner noun = findViewById(R.id.spinner);
        String test = noun.getSelectedItem().toString();
        int test3 = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(test3);
        String test5 = radioButton.getText().toString();
        String test1 = selectedItem;


        if (check.isChecked()){
            test1 = " ";
            all =test1  + " " + test + " " + test5;
            char [] test21 = new char[all.length()];
            String test31;
            for (int i = 0; i<all.length(); i++)
            {

//                test21[i] = all.charAt(i);
//                test31 = test21.toString();
//                text.setText(test31);

            }
        }

        else {
            String all =test1  + " " + test + " " + test5;
            text.setText(all);
        }

    }

    public void remove(View view){
       int itmId = listAdapter.getPosition(selectedItem);

          if (listAdapter.getCount() == 1)
          {
              TextView text = findViewById(R.id.textView);
              text.setText("нельзя удалить последний эл-т");
          }
          else {
              listAdapter.remove(listAdapter.getItem(itmId));
          }
    }

    public void add(View view){
        editText = findViewById(R.id.editTextText);
        String addtext = editText.getText().toString();
//        listAdapter.add(addtext);

        listAdapter.insert(addtext, listAdapter.getPosition(selectedItem)+1);
        listAdapter.notifyDataSetChanged();
    }

    public void select(View view){
        editText =findViewById(R.id.editTextText);
        editText.setText(selectedItem);
    }
    public void edit(View view) {
        editText =findViewById(R.id.editTextText);
        String edittext = editText.getText().toString();
        int needpos = listAdapter.getPosition(selectedItem);
        list.set(needpos, edittext);
        listAdapter.notifyDataSetChanged();

    }

    public void choose(View view){


    }

}

