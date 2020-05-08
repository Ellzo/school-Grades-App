package com.example.schoolgrades;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class subjectAdapter extends ArrayAdapter<subject> {
    private ArrayList<subject> subjects;
    private subject s;

    //subjectAdapter constructor
    public subjectAdapter(Activity context, ArrayList<subject> subjects) {
        super(context, 0, subjects);
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItemView = convertView;

        //Inflate the layout if convertView is null
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_subject, parent, false);
        }

        //Get subject item from the list
        s = getItem(position);

        //Set text the the subject TextView depending on the item
        TextView txt = (TextView) listItemView.findViewById(R.id.subject);
        txt.setText(s.getName());


        return listItemView;
    }


}
