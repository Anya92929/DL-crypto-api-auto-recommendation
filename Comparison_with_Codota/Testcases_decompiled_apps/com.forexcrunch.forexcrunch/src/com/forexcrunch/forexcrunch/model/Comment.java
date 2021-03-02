package com.forexcrunch.forexcrunch.model;

import java.util.ArrayList;

public class Comment {
    private String content;
    private String date;

    /* renamed from: id */
    private int f71id;
    private String name;
    private int parent;
    private ArrayList<Comment> replies;
    private String url;

    public int getId() {
        return this.f71id;
    }

    public void setId(int id) {
        this.f71id = id;
    }

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent2) {
        this.parent = parent2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public ArrayList<Comment> getReplies() {
        if (this.replies == null) {
            this.replies = new ArrayList<>();
        }
        return this.replies;
    }

    public void setReplies(ArrayList<Comment> replies2) {
        this.replies = replies2;
    }
}
