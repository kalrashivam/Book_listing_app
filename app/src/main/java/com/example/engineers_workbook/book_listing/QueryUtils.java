package com.example.engineers_workbook.book_listing;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by hp on 03-11-2017.
 */

public class QueryUtils {
    public static final String LOG_TAG = ListViewActivity.class.getName();
    private QueryUtils(){
    }

    public static List<Books> fetchBooksdata(String simple){
        URL url =CreateUrl(simple);

        String jsonresponse;
        try{ jsonresponse = makeHttpRequest(url);

        }catch(IOException e){
            Log.e(LOG_TAG,"error",e);

        }

        List<Books> gbooks= extractFeaturefromjson(jsonresponse);

        return gbooks;

    }


    private static URL CreateUrl(String s){
        URL url = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            Log.e("QueryUtils", "Error with creating URL ", e);
        }
        return url;
    }


    private static String makeHttpRequest(URL url){
        String jsonresponse = "";

        if(url == null){
            return jsonresponse;
        }

        HttpURLConnection Urlconnection = null;
        InputStream inputstream = null;
        try{
            Urlconnection = (HttpURLConnection) url.openConnection();
            Urlconnection.setReadTimeout(10000);
            Urlconnection.setConnectTimeout(15000);
            Urlconnection.setRequestMethod("GET");
            Urlconnection.connect();

            if(Urlconnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputstream = Urlconnection.getInputStream();
                jsonresponse = readFromStream(inputstream);
            }
        }catch(IOException e){
            Log.e("QueryUtils","Httpconnection wasn't formed",e);
        } finally {
            if (Urlconnection != null) {
                Urlconnection.disconnect();
            }
            if (inputstream != null) {
                inputstream.close();
            }
        }
        return jsonresponse;
    }

    private static String readFromStream(InputStream stream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (stream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }

        }

        return output.toString();
    }

    private List<Books> 
}
