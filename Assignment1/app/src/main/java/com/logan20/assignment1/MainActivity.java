package com.logan20.assignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    protected static int userOption;
    private int reqCode =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get the list and set it's onclick listener
        ListView lv = (ListView)findViewById(R.id.landingList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launchActivity(position);
            }
        });

    }
    private void launchActivity(int position){
        //perform action based on input
        switch(position){
            case 0: startActivity(new Intent(this,UIComponents.class));
                    break;
            case 1: startActivity(new Intent(this,Layouts.class));
                    break;
            case 2: startActivity(new Intent(this,Dialogs.class));
                    break;
            case 3: startActivity(new Intent(this,ToastAndSnackbar.class));
                    break;
            case 4: activityBundle(); //runs the method which will start the activity bundle intent
                    break;
            case 5: startActivityForResult(new Intent(this,ActivityForResult.class),reqCode);
                    break;
            case 6: startActivity(new Intent(this,CustomAdapter.class));
                    break;
            case 7: startActivity(new Intent(this,Fragment.class));
                    break;
            case 8: startActivity(new Intent(this,ActionBarAndMenus.class));
                    break;
            case 9: startActivity(new Intent(this,ItemListActivity.class));
                    break;
            default:break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        //runs when the activity for result intent terminates
        if (requestCode==reqCode){
            String name = "No data was passed in from the activity";
            if (resultCode== Activity.RESULT_OK){
                String entName = data.getStringExtra("data");
                if (entName.equals(""))
                    entName = "Anonymous";
                name = "I hope you're enjoying the app "+entName;
            }
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        }
    }
    public void activityBundle() {
        new AlertDialog.Builder(MainActivity.this)//creates a new alert dialog builder
                .setTitle(R.string.userInputTitle) //sets the title to 'userInputTitle' specified in strings.xml
                .setItems(R.array.colorOptions, new DialogInterface.OnClickListener() {//sets the items to the array specified by 'colorOptions'
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //when a certain activity is clicked, launch the new intent passing the index of that item to the new intent
                        startActivity(new Intent(MainActivity.this, ActivityBundle.class).putExtra("idx", which));
                    }
                }).show(); //show the alert dialog
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
