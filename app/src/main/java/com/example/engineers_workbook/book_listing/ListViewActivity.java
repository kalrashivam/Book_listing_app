package com.example.engineers_workbook.book_listing;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    public static final String LOG_TAG = ListViewActivity.class.getName();
    private String First_Url = "http://earthquake.usgs.gov/fdsnws/event/1/query";
    public String in;
    public Booksadaptor badaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        in = getIntent().getStringExtra("Search_results");
        Log.e(LOG_TAG, in);

        ListView books = (ListView) findViewById(R.id.card);

        badaptor = new Booksadaptor(this, new ArrayList<Books>());

        books.setAdapter(badaptor);


        BooksAsyncTask task = new BooksAsyncTask();
        task.execute(First_Url);
    }

    private class BooksAsyncTask extends AsyncTask<String, Void, List<Books>> {

        @Override
        protected List<Books> doInBackground(String... urls) {
            if (urls[0] == null || urls.length <= 1) {
                return null;
            } else {

                    List<Books> result = QueryUtils.fetchBooksdata(urls[0]);
                    return result;

                }

        }

        @Override
        protected void onPostExecute(List<Books> bookses) {

            badaptor.clear();

           if (bookses != null && !bookses.isEmpty()) {
                badaptor.addAll(bookses);
            }
        }
    }

}