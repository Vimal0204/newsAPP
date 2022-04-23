package com.example.newsnaut;

import java.util.ArrayList;

public class interNews {

    private String status1;
    private  String totalResult1;
    private ArrayList<ModelClass1>articles;

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getTotalResult1() {
        return totalResult1;
    }

    public void setTotalResult1(String totalResult1) {
        this.totalResult1 = totalResult1;
    }

    public ArrayList<ModelClass1> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass1> articles) {
        this.articles = articles;
    }

    public interNews(String status1, String totalResult1, ArrayList<ModelClass1> articles) {
        this.status1 = status1;
        this.totalResult1 = totalResult1;
        this.articles = articles;
    }
}
