package com.example.user.amir;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    EditText etName;
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);


        tvName=findViewById(R.id.tvName);
        etName=findViewById(R.id.etName);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        //in case shared prefrence doesnt contain keywoard "name" null is returned

        SharedPreferences prof = getSharedPreferences("mypref",MODE_PRIVATE);
        String name=prof.getString("name",null);
        if(name != null){
            tvName.setText(name);
        }



    }

    @Override
    public void onClick(View v) {
        SharedPreferences prof = getSharedPreferences("mypref",MODE_PRIVATE);
//open files for editing
        SharedPreferences.Editor editor= prof.edit();
//values saved
        editor.putString("name",etName.getText().toString());
//commit the changes to the file and save
        editor.commit();







    }
}
