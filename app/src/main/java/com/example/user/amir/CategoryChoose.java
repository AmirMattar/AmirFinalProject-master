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

public class CategoryChoose extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvBookList;
    ArrayList<Book> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_page);

        lvBookList = findViewById(R.id.lvBookList);

        String category = getIntent().getStringExtra("categories");
        Toast.makeText(this, getIntent().getStringExtra("categories"), Toast.LENGTH_LONG).show();
        fillSubCategoriesList(category);

        BookCustomAdapter adapter = new BookCustomAdapter(this, R.layout.book_custom_row, arrayList);
        lvBookList.setAdapter(adapter);
        lvBookList.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,DetailedBookActivity.class);
        i.putExtra("book", arrayList.get(position));
        startActivity(i);
    }

    public void fillSubCategoriesList(String category) {

        if (category.equals("Science fiction")) {
            arrayList.add(new Book("LOTR", 9, "twenty rings existed: three for elves, seven for dwarves, nine for men, and one made by the Dark Lord Sauron, in Mordor, which would rule all the others. Sauron poured all his evil and his will to dominate into this ring. An alliance of elves and humans resisted Sauron’s ring and fought against Mordor. They won the battle and the ring fell to Isildur, the son of the king of Gondor, but just as he was about to destroy the ring in Mount Doom, he changed his mind and held on to it for himself. Later he was killed, and the ring fell to the bottom of the sea. The creature Gollum discovered it and brought it to his cave. Then he lost it to the hobbit Bilbo Baggins.", R.drawable.lotr));
            arrayList.add(new Book("The Witcher", 10, "...", R.drawable.thewicther));

        } else if (category.equals("Action and Adventure")) {
            arrayList.add(new Book("Harry Potter", 10, "..", R.drawable.hp));
            arrayList.add(new Book("Game Of Thrones", 10, "..", R.drawable.got));

        } else if (category.equals("Romance")) {
            arrayList.add(new Book("The Bronze Horseman", 10, "..", R.drawable.bronze));
            arrayList.add(new Book("Looking For alaska", 10, "..", R.drawable.alaska));

        } else if (category.equals("Comics")) {
            arrayList.add(new Book("Kingdom", 10, "..", R.drawable.kingdom));
            arrayList.add(new Book("Bone", 10, "..", R.drawable.bone));

        } else if (category.equals("Mystery")) {
            arrayList.add(new Book("Sherlock Holmes", 10, "..", R.drawable.sherlock));
            arrayList.add(new Book("Percy Jackson", 10, "..", R.drawable.percy));

        }
    }

}


