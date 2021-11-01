package com.example.listview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] listObject = {"Ноутбуки", "Планешеты", "Телефоны", "Компьютеры"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.lst);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, listObject
        );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringJoiner joiner = new StringJoiner(", ");
                for(int i = 0; i < list.getCheckedItemPositions().size(); i++)
                {
                    int key = list.getCheckedItemPositions().keyAt(i);
                    if(list.getCheckedItemPositions().get(key) == true)
                    {
                        joiner.add(listObject[key]);
                    }
                }
                if(joiner.length() != 0){

                    Toast.makeText(getApplicationContext(), joiner.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}