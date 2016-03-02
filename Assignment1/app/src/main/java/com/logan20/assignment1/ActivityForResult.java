package com.logan20.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_for_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //gets button and sets listener
        Button b= (Button)findViewById(R.id.btnSubmit);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //performs tasks once button is clicked
                TextView userData = (TextView)findViewById(R.id.txtName);
                Intent retIntent=new Intent();
                retIntent.putExtra("data",userData.getText().toString());
                setResult(Activity.RESULT_OK,retIntent);
                finish();
            }
        });
    }
}
