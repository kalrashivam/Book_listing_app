package com.example.engineers_workbook.book_listing;

/**
 * Created by hp on 01-11-2017.
 */

public class Books {

    private String ntitle;

    private String nprice;

    private String nurl;

    private int imageid;

    private String Nsubtitle;


        Books(String name, String price ,String url, int id, String sub){
        ntitle=name;
        nprice=price;
        nurl=url;
        imageid=id;
        Nsubtitle=sub;
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

    public int getimage(){
        return imageid;
    }

    public String getNsubtitle(){
        return Nsubtitle;
    }
}
