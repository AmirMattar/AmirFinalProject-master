package com.example.user.amir;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BookCustomAdapter extends ArrayAdapter<Book> {

    private int resourceLayout;
    private Context mContext;

    public BookCustomAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);

        this.resourceLayout = resource;
        this.mContext = context;
    }
    public View getView(int position, View convertView, ViewGroup parent){

        View v=convertView;
        if(v==null){
            v= LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);
        }
        Book p = getItem(position);

        if(p != null){
            TextView tvName=v.findViewById(R.id.tvBookName);
            tvName.setText(p.getName());

            ImageView imageView = v.findViewById(R.id.imageView2);
            imageView.setImageResource(p.getImage());

            Button btAdd = v.findViewById(R.id.btAddToWish);
            btAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "added to wishlist", Toast.LENGTH_SHORT).show();
                }
            });
        }
        return v;

    }
}
