package com.example.engineers_workbook.book_listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListViewActivity extends AppCompatActivity {

    public String in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        Intent Incomingtext =getIntent();
        in =Incomingtext.getStringExtra("Search_results");

    }
}
