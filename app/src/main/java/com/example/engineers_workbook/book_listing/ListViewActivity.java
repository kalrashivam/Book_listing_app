package com.example.engineers_workbook.book_listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    public static final String LOG_TAG = ListViewActivity.class.getName();
    public String in;
    public Booksadaptor badaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        Intent Incomingtext =getIntent();
        in =Incomingtext.getStringExtra("Search_results");

        ListView books= (ListView) findViewById(R.id.card);

        badaptor = new Booksadaptor(this, new ArrayList<Books>())

        books.setAdapter(badaptor);

    }
}
