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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UIComponents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //gets the save button and sets the on click listener
        Button save = (Button)findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //get the objects in which data was entered
                TextView uName = (TextView)findViewById(R.id.txt_username);
                TextView pwd = (TextView)findViewById(R.id.txt_password);
                TextView email = (TextView)findViewById(R.id.txt_email);
                RadioGroup sex = (RadioGroup)findViewById(R.id.radiogrp);

                //display data on the textviews
                TextView outName = (TextView)findViewById(R.id.usernameTxtView);
                outName.setText("Username: "+uName.getText());

                TextView outPwd= (TextView)findViewById(R.id.passwordTxtView);
                outPwd.setText("Password: "+pwd.getText());

                TextView outEmail = (TextView)findViewById(R.id.emailTxtView);
                outEmail.setText("Email: "+email.getText());

                //set text from radio button
                if (sex.getCheckedRadioButtonId()!=-1){
                    RadioButton selected = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
                    String x = selected.getText().toString();
                    TextView outSex = (TextView)findViewById(R.id.sexTxtView);
                    outSex.setText("Sex: "+x);
                }
            }
        });
    }

}
