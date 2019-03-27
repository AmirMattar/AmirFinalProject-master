package com.example.user.amir;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure");

        builder.setCancelable(true);//nothing happens if clicked on no

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(AlertDialogActivity.this, SignIn.class);
                startActivity(i);//if clicked on the yes button on the warning app will return to the sign in page
            }
        });

        builder.setNegativeButton("NO",this);

        AlertDialog dialog=builder.create();

        dialog.show();
        //activates the warning
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i==dialogInterface.BUTTON_POSITIVE)
        {
            Toast.makeText(this,"YES",Toast.LENGTH_SHORT).show();
        }
        if(i==dialogInterface.BUTTON_NEGATIVE)
        {
            Toast.makeText(this,"NO",Toast.LENGTH_SHORT).show();
        }



    }

}
