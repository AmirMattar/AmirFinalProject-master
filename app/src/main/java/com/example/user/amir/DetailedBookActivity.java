package com.example.user.amir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailedBookActivity extends AppCompatActivity implements View.OnClickListener{
    TextView BookName,BookRating,BookSummary;
    ImageView BookImage;
    Button addwish;
    //get the current user logged in, then get the UID set by the firebase
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    String userId = currentUser.getUid();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("WishList/"+userId);
    Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_book);


        book = (Book) getIntent().getSerializableExtra("book");


        BookName=findViewById(R.id.BookName);
        BookImage=findViewById(R.id.BookImage);
        BookRating=findViewById(R.id.BookRating);
        BookSummary=findViewById(R.id.BookSummary);


        BookName.setText(book.getName());
        BookImage.setImageResource(book.getImage());
        BookRating.setText(book.getRating()+"");
        BookSummary.setText(book.getSummary());

        addwish=findViewById(R.id.addwish);
        addwish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        reference.push().setValue(book);
    }
}
