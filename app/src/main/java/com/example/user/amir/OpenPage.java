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

public class OpenPage extends AppCompatActivity {

    ListView lvSubCategory;
    ArrayList<Book> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);

        lvSubCategory = findViewById(R.id.lvSubCategory);

        String category = getIntent().getStringExtra("categories");
        Toast.makeText(this, getIntent().getStringExtra("categories"), Toast.LENGTH_LONG).show();
        fillSubCategoriesList(category);

        BookCustomAdapter adapter = new BookCustomAdapter(this, R.layout.book_custom_row, arrayList);
        lvSubCategory.setAdapter(adapter);


    }

    public void fillSubCategoriesList(String category) {
        arrayList = new ArrayList<>();


        if (category.equals("Science fiction")) {
            arrayList.add(new Book("LOTR", 10, "perfect", R.drawable.lotr));
            arrayList.add(new Book("The Witcher", 10, "perfect", R.drawable.thewicther));

        } else if (category.equals("Action and Adventure")) {
            arrayList.add(new Book("Harry Potter", 10, "perfect", R.drawable.hp));
            arrayList.add(new Book("Game Of Thrones", 10, "perfect", R.drawable.got));

        } else if (category.equals("Romance")) {
            arrayList.add(new Book("The Bronze Horseman", 10, "perfect", R.drawable.bronze));
            arrayList.add(new Book("Looking For alaska", 10, "perfect", R.drawable.alaska));

        }else if (category.equals("Comics")) {
            arrayList.add(new Book("Kingdom", 10, "perfect", R.drawable.kingdom));
            arrayList.add(new Book("Bone", 10, "perfect", R.drawable.bone));

        }else if (category.equals("Mystery")) {
            arrayList.add(new Book("Sherlock Holmes", 10, "perfect", R.drawable.sherlock));
            arrayList.add(new Book("Percy Jackson", 10, "perfect", R.drawable.percy));

        }
/*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,DetailedBookActivity.class);
        i.putExtra("book", arrayList.get(position).toString());
        startActivity(i);
    }*/
    }
}

