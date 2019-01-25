package com.example.user.amir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutProject extends AppCompatActivity {

    TextView Info, About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_project);

        Info=findViewById(R.id.Info);
        About=findViewById(R.id.About);
    }
}
