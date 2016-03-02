package com.logan20.assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActionBarAndMenus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_and_menus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    // sets menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action, menu);
        return true;
    }
    //performs actions based on menu item clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_favorite:
                Toast.makeText(this, "You have favorited", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_genToast:
                Toast.makeText(this,"Toast generated from menu",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this,"Settings was pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings2:
                Toast.makeText(this,"Menu option 2 was pressed",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings3:
                Toast.makeText(this,"Menu option 3 was pressed",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
