package com.example.user.amir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedBookActivity extends AppCompatActivity {
TextView WriterInfo, BookInfo;
ImageView DetailImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_book);

        WriterInfo=findViewById(R.id.WriterInfo);
        BookInfo=findViewById(R.id.BookInfo);
        DetailImage=findViewById(R.id.DetailImage);

    }
}
