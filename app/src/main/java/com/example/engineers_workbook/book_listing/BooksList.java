package com.example.engineers_workbook.book_listing;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class BooksList extends AppCompatActivity {

    public String recieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_list);

        EditText et= (EditText) findViewById(R.id.reciever);

        recieve=et.getText().toString();

        Button but = (Button) findViewById(R.id.submit_but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(BooksList.this, ListViewActivity.class);
                myIntent.putExtra("Search_results",recieve);
                startActivity(myIntent);

            }
        });
    }



}
