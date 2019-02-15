package com.example.user.amir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView Lvbooks;

    CustomAdapter2 ArrayAdapter;

    ArrayList<Item> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);


        Lvbooks = findViewById(R.id.Lvbooks);
        arrayList.add(new Item(R.drawable.fiction,"Science fiction"));
        arrayList.add(new Item(R.drawable.action,"Action and Adventure"));
        arrayList.add(new Item(R.drawable.crime,"Mystery"));
        arrayList.add(new Item(R.drawable.comics,"Comics"));
        arrayList.add(new Item(R.drawable.history,"Histroy"));





      /*  arrayList.add("Drama");
        arrayList.add("Action and Adventure");
        arrayList.add("Mystery");
        arrayList.add("Romance");*/


        ArrayAdapter=new CustomAdapter2(this,R.layout.custom_row,arrayList);
        Lvbooks.setAdapter(ArrayAdapter);
        Lvbooks.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i=new Intent(this,CategoryChoose.class);
        i.putExtra("categories", arrayList.get(position).toString());
        startActivity(i);
    }
}


