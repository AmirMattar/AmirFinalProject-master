package com.example.user.amir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedBookActivity extends AppCompatActivity {
    TextView BookName,BookRating,BookSummary;
    ImageView BookImage;
    Button addwish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_book);

        Book book = (Book) getIntent().getSerializableExtra("book");


        BookName=findViewById(R.id.BookName);
        BookImage=findViewById(R.id.BookImage);
        BookRating=findViewById(R.id.BookRating);
        BookSummary=findViewById(R.id.BookSummary);
        addwish=findViewById(R.id.addwish);

        BookName.setText(book.getName());

        BookImage.setImageResource(book.getImage());
        BookRating.setText(book.getRating()+"");
        BookSummary.setText(book.getSummary());
    }
}
