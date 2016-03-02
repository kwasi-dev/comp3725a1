package com.logan20.assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityBundle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //gets the array of values
        String[] colorValues = getResources().getStringArray(R.array.colorOptions);
        //extracts the index from the bundle
        int id = getIntent().getExtras().getInt("idx");
        //sets the textview to the color of choice
        TextView t = (TextView)findViewById(R.id.txtChoice);
        t.setText("Your color of choice is "+ colorValues[id]);
    }

}
