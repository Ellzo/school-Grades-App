package com.example.schoolgrades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class subsGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subs_grade);

        //Hide action bar
        getSupportActionBar().hide();

        //Get data from intent
        Intent intent = getIntent();
        String grade = intent.getStringExtra("grade");

        //Set displayed text
        TextView txt = findViewById(R.id.txt);
        txt.setText(grade);
    }
}
