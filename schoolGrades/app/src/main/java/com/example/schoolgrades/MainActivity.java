package com.example.schoolgrades;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<subject> subjects;
    subjectAdapter subsAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create list of Subjects
        subjects = new ArrayList<subject>();

        subjects.add(new subject(getString(R.string.name_maths)
                , getString(R.string.grade_maths)));
        subjects.add(new subject(getString(R.string.name_physics)
                , getString(R.string.grade_phyics)));
        subjects.add(new subject(getString(R.string.name_chemistry)
                , getString(R.string.grade_chemistry)));
        subjects.add(new subject(getString(R.string.name_biology)
                , getString(R.string.grade_biology)));
        subjects.add(new subject(getString(R.string.name_eng)
                , getString(R.string.grade_eng)));
        subjects.add(new subject(getString(R.string.name_ar)
                , getString(R.string.grade_ar)));
        subjects.add(new subject(getString(R.string.name_fr)
                , getString(R.string.grade_fr)));
        subjects.add(new subject(getString(R.string.name_en)
                , getString(R.string.grade_en)));
        subjects.add(new subject(getString(R.string.name_his)
                , getString(R.string.grade_his)));
        subjects.add(new subject(getString(R.string.name_geo)
                , getString(R.string.grade_geo)));
        subjects.add(new subject(getString(R.string.name_religion)
                , getString(R.string.grade_religion)));
        subjects.add(new subject(getString(R.string.name_sport)
                , getString(R.string.grade_sport)));

        //Create subjectAdapter
        subsAdp = new subjectAdapter(this, subjects);

        //Create ListView
        ListView lsView = findViewById(R.id.lsView);

        //Link the adapter with the ListView
        lsView.setAdapter(subsAdp);

        //Make context menu for the ListView
        registerForContextMenu(lsView);

        //Show the results when the user click on a subject
        lsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seeResults(position);

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Inflate the ContextMenu with the menu resource
        getMenuInflater().inflate(R.menu.contextual_manu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //Make different action depending on the selected menu item
        switch (item.getItemId()) {
            case R.id.grade:
                seeResults(info.position);
                return true;
            case R.id.share:
                String mimeType = "text/plain";
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType(mimeType)
                        .setChooserTitle("Share this subject grade with: ")
                        .setText("My grade in " + subjects.get(info.position).getName() + " is :" + subjects.get(info.position).getGrade() + " !")
                        .startChooser();
                return true;
            case R.id.dalete:
                subjects.remove(info.position);
                subsAdp.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void seeResults(int position) {
        //Create intent object
        Intent intent = new Intent(MainActivity.this, subsGrade.class);

        //Put extra data on that intent
        intent.putExtra("grade", subjects.get(position).getGrade());

        //Start activity with the intent
        startActivity(intent);

        //Make fade animation while transition to subsGrade activity
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}