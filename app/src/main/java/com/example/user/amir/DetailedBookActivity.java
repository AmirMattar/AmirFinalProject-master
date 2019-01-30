package com.example.user.amir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedBookActivity extends AppCompatActivity {
    TextView BookInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_book);

        Book book = (Book) getIntent().getSerializableExtra("book");


        BookInfo=findViewById(R.id.BookInfo);


        BookInfo.setText(book.getName());

    }
}
