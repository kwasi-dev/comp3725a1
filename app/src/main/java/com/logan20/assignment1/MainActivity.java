package com.logan20.assignment1;

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

public class MainActivity extends AppCompatActivity {

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
        switch(position){
            case 0: startActivity(new Intent(this,UIComponents.class));
                    break;
            case 1: startActivity(new Intent(this,Layouts.class));
                    break;
            case 2: startActivity(new Intent(this,Dialogs.class));
                    break;
            case 3: startActivity(new Intent(this,ToastAndSnackbar.class));
                    break;
            case 4: startActivity(new Intent(this,ActivityBundle.class));
                    break;
            case 5: startActivity(new Intent(this,ActivityForResult.class));
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
