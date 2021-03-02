package com.forexcrunch.forexcrunch.model;

import java.util.ArrayList;

public class News {
    public static final int ALL = -1;
    public static final int AUD_USD_DAILY = 516;
    public static final int BASICS_INDUSTRY = 1117;
    public static final int CANADIAN_DOLAR = 511;
    public static final int DAILY = 21;
    public static final int EUR_USD_DAILY = 1091;
    public static final int EUR_USD_FORECAST = 518;
    public static final int FOREX_BASICS = 3;
    public static final int FOREX_BINARY = 948;
    public static final int FOREX_BITS = 1003;
    public static final int FOREX_INDUSTRY = 1051;
    public static final int FOREX_LINKS = 470;
    public static final int FOREX_NEWS = 53;
    public static final int FOREX_SOFTWARE = 193;
    public static final int FOREX_STUFF = 1;
    public static final int GBP_USD_FORECAST = 512;
    public static final int GUEST_POST = 489;
    public static final int LATEST = 0;
    public static final int MAJORS = 1102;
    public static final int MAJOR_EVENTS = 1132;
    public static final int MINORS = 1103;
    public static final int NEWS = 53;
    public static final int NZR_USD_FORECAST = 522;
    public static final int OPNIONS = 38;
    public static final int TRENDING = 99999;
    public static final int USD_CHF_FORECAST = 554;
    public static final int USD_JPY_FORECAST = 932;
    public static final int US_DOLLAR_FORECAST = 1132;
    public static final int WEEKLY_FOREX_FORECAST = 422;
    private Category category;
    private int count;
    private int pages;
    private ArrayList<Post> postsList;
    private String status;

    public News(String status2, int count2, int pages2, Category category2, ArrayList<Post> posts) {
        this.status = status2;
        this.count = count2;
        this.pages = pages2;
        this.category = category2;
        this.postsList = posts;
    }

    public News() {
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count2) {
        this.count = count2;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages2) {
        this.pages = pages2;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category2) {
        this.category = category2;
    }

    public ArrayList<Post> getPostsList() {
        return this.postsList;
    }

    public void setPostsList(ArrayList<Post> posts) {
        this.postsList = posts;
    }

    public boolean isEmptyOrNullPostList() {
        return getPostsList() == null || getPostsList().isEmpty();
    }
}
