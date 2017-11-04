package com.example.engineers_workbook.book_listing;

/**
 * Created by hp on 01-11-2017.
 */

public class Books {

    private String ntitle;

    private String nurl;

    private String Nsubtitle;


        Books(String name ,String url, String sub){
        ntitle=name;
        nurl=url;
        Nsubtitle=sub;
    }


    public String getNtitle(){
        return ntitle;
    }

    public String getNurl(){
        return nurl;
    }

    public String getNsubtitle(){
        return Nsubtitle;
    }
}
