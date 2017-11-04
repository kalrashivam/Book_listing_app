package com.example.engineers_workbook.book_listing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hp on 03-11-2017.
 */

public class Booksadaptor extends ArrayAdapter<Books> {

    Booksadaptor(Context context, ArrayList<Books> books) {
        super(context, 0, books);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Books current_book =getItem(position);

        ImageView first=(ImageView) listItemView.findViewById(R.id.bookimage);
   try {
        URL url = new URL(current_book.getNurl());
       Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
       first.setImageBitmap(bmp);
    }catch(MalformedURLException e){
       Toast.makeText(getContext(),"url malformed",Toast.LENGTH_LONG).show();
    }catch(IOException e){
       Toast.makeText(getContext(),"url malformed",Toast.LENGTH_LONG).show();
   }





        TextView t1 =(TextView) listItemView.findViewById(R.id.Title);

        t1.setText(current_book.getNtitle());


        TextView t2 =(TextView) listItemView.findViewById(R.id.Subtitle);

        t2.setText(current_book.getNsubtitle());

        return listItemView;


    }
}
