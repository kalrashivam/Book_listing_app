package com.example.engineers_workbook.book_listing;

/**
 * Created by hp on 01-11-2017.
 */

public class Books {

    private String ntitle;

    private String nprice;

    private String nurl;


        Books(String name, String price ,String url){
        ntitle=name;
        nprice=price;
        nurl=url;
    }


    public String getNtitle(){
        return ntitle;
    }

    public String getNprice(){
        return nprice;
    }

    public String getNurl(){
        return nurl;
    }
}
