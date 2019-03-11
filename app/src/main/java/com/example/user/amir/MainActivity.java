package com.example.user.amir;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button cbutton, wishbutton;


    private static final int NOTIFICATION_REMINDER_NIGHT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent notifyIntent = new Intent(this,MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 60 * 24, pendingIntent);


        cbutton=findViewById(R.id.cbutton);

        cbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),List.class);
                startActivity(i);
            }
        });
        wishbutton=findViewById(R.id.wishbutton);
        wishbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),WishlistActivity.class);
                startActivity(i);
            }
        });
    }






    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Intent GoToAlert = new Intent(getApplicationContext(), AlertDialogActivity.class);
        Intent GoToAbout = new Intent(getApplicationContext(), AboutProject.class);

        switch (item.getItemId()) {
            case R.id.action_settings:
                GoToAlert = new Intent(getApplicationContext(), AlertDialogActivity.class);
                startActivity(GoToAlert);
                break;
            case R.id.about:
                GoToAlert = new Intent(getApplicationContext(), AboutProject.class);
                startActivity(GoToAbout);
                break;
            case R.id.sign_out:
                GoToAlert = new Intent(getApplicationContext(), AlertDialogActivity.class);
                startActivity(GoToAlert);
                break;

            case R.id.camera:
                GoToAlert = new Intent(getApplicationContext(), CameraGalleryActivity.class);
                startActivity(GoToAlert);
                break;



        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {



        }



        return true;
    }
}
