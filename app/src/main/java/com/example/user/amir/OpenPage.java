package com.example.user.amir;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OpenPage extends AppCompatActivity{

    ListView lvSubCategory;
    ArrayList<Book> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);

        lvSubCategory =findViewById(R.id.lvSubCategory);

        String category = getIntent().getStringExtra("categories");
        Toast.makeText(this,  getIntent().getStringExtra("categories"), Toast.LENGTH_LONG).show();
        fillSubCategoriesList(category);

        BookCustomAdapter adapter = new BookCustomAdapter(this, R.layout.book_custom_row, arrayList);
        lvSubCategory.setAdapter(adapter);


    }
    public void fillSubCategoriesList(String category){
        arrayList = new ArrayList<>();


       if(category.equals("Science fiction")){
           arrayList.add(new Book("amir fiction",10,"perfect",R.drawable.as));
           arrayList.add(new Book("amir fiction",10,"perfect",R.drawable.as));

        }else if(category.equals("Action and Adventure")){
           arrayList.add(new Book("amir action",10,"perfect",R.drawable.action));
           arrayList.add(new Book("amir action",10,"perfect",R.drawable.action));

        }

    }
/*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,DetailedBookActivity.class);
        i.putExtra("book", arrayList.get(position).toString());
        startActivity(i);
    }*/
}
