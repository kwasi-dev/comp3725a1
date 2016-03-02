package com.logan20.assignment1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastAndSnackbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_and_snackbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get the list view and set listener
        ListView toast = (ListView)findViewById(R.id.toast_snack_view);
        toast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launchActivity(position);
            }
        });
    }
    private void launchActivity(int pos){
        //perform necessary action based on input
        switch (pos){
            case 0: Toast.makeText(this,"This is short length toast",Toast.LENGTH_SHORT).show();
                    break;
            case 1: Toast.makeText(this,"This is long length toast",Toast.LENGTH_LONG).show();
                    break;
            case 2: Snackbar.make(findViewById(R.id.toast_snack_view), "Snackbar message", Snackbar.LENGTH_LONG).show();
                    break;
            case 3: Snackbar.make(findViewById(R.id.toast_snack_view), "This is message 1", Snackbar.LENGTH_LONG)
                            .setAction("Change", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar.make(findViewById(R.id.toast_snack_view), "This is Message 2!", Snackbar.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                    break;
            default:break;

        }
    }
}
