package com.logan20.assignment1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Dialogs extends AppCompatActivity {
    ArrayList mSelectedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView dialogs = (ListView)findViewById(R.id.dialogListView);
        dialogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launchActivity(position);
            }
        });
    }

    private void launchActivity(int position){
        //performs action based on selection
        switch(position){
            case 0: createAlert();
                    break;
            case 1: confirm();
                    break;
            case 2: date();
                    break;
            case 3: list();
                    break;
            case 4: mList();
                    break;
            default:break;
        }
    }
    private void mList(){
        mSelectedItems = new ArrayList();  // Where we track the selected items
        new AlertDialog.Builder(this)
                .setTitle("Choose Vowel")
                .setMultiChoiceItems(R.array.vowels, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(which);
                                } else if (mSelectedItems.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(which));
                                }
                            }
                        })
                        // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String[] vowels = getResources().getStringArray(R.array.vowels);
                        String str = "";
                        for (int x=0;x<mSelectedItems.size();x++) {
                            str+=vowels[(Integer)mSelectedItems.get(x)];
                        }
                        makeToast(str);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).show();

    }
    private void list(){
        new AlertDialog.Builder(Dialogs.this)//creates a new alert dialog builder
                .setTitle("Name:") //sets the title
                .setItems(R.array.nameList, new DialogInterface.OnClickListener() {//sets the items to the array specified
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] name = getResources().getStringArray(R.array.nameList);
                        makeToast("Name selected: "+name[which]);
                    }
                }).show(); //show the alert dialog
    }
    private void date(){
        Calendar c = Calendar.getInstance();
        int y =c.get(Calendar.YEAR), m=c.get(Calendar.MONTH), d=c.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                makeToast(dayOfMonth +"/"+(monthOfYear+1)+"/"+year);

            }
        },y,m,d).show();
    }

    private void confirm(){
        new AlertDialog.Builder(Dialogs.this)//creates a new alert dialog builder
                .setTitle("Name") //sets the title
                .setMessage("Is your name Kyle?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        makeToast("Confirmation");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        makeToast("Denial");
                    }
                })
                .show(); //show the alert dialog
    }
    private void createAlert(){
        new AlertDialog.Builder(Dialogs.this)//creates a new alert dialog builder
                .setTitle("This is an alert") //sets the title
                .setMessage("You have been alerted")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .show(); //show the alert dialog
    }
    private void makeToast(String x){
        Toast.makeText(getApplicationContext(), x, Toast.LENGTH_LONG).show();
    }

}
