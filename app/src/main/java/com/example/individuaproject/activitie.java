package com.example.individuaproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activitie extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    String[] activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitie);
        listView = findViewById(R.id.ListView);
        activity = new String[]{"Activity 1 : play football","Activity 2 : play basketball",
                "Activity 3 : swimming","Activity 4 : play hockey","Activity 5 : boxing ",
                "Activity 6 : play rugby","Activity 7 : play Kayaking","Activity 8 : play Skiing",
                "Activity 9 : Running","Activity 10 : play Golf","Activity 11 : play Hockey",
                "Activity 12 : play Handball","Activity 13 : play Table Tennis","Activity 14 : play Volleyball",
                "Activity 15 : play Javelin","Activity 16 : play Water Polo","Activity 17 : play Squash",
                "Activity 18 : play Racquetball","Activity 19 : play Long Jump","Activity 20 : play Fencing",
                "Activity 21 : play Canoeing","Activity 22 : play Bowling"};
        ArrayAdapter<String> activityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,activity);
        listView.setAdapter(activityAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        String activity = adapterView.getItemAtPosition(i).toString();
       String act= activity[i];
        Toast.makeText(getApplicationContext(), act,Toast.LENGTH_SHORT).show();
    }
}