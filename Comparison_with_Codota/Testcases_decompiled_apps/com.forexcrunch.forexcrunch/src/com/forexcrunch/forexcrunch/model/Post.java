package com.forexcrunch.forexcrunch.model;

import java.util.ArrayList;

public class Post {
    private Author author;
    private ArrayList<Category> categories;
    private int comment_count;
    private String comment_status;
    private ArrayList<Comment> comments;
    private String content;
    private String date;
    private String excerpt;
    private String formattedContent;

    /* renamed from: id */
    private int f73id;
    private boolean isRead = false;
    private String modified;
    private String slug;
    private String status;
    private ArrayList<Tags> tags;
    private String thumbnail;
    private String title;
    private String title_plain;
    private String type;
    private String url;

    public int getId() {
        return this.f73id;
    }

    public void setId(int id) {
        this.f73id = id;
    }

    public int getComment_count() {
        return this.comments.size();
    }

    public void setComment_count(int comment_count2) {
        this.comment_count = comment_count2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug2) {
        this.slug = slug2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getTitle_plain() {
        return this.title_plain;
    }

    public void setTitle_plain(String title_plain2) {
        this.title_plain = title_plain2;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public String getExcerpt() {
        return this.excerpt;
    }

    public void setExcerpt(String excerpt2) {
        this.excerpt = excerpt2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date2) {
        this.date = date2;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified2) {
        this.modified = modified2;
    }

    public String getComment_status() {
        return this.comment_status;
    }

    public void setComment_status(String comment_status2) {
        this.comment_status = comment_status2;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public void setRead(boolean isRead2) {
        this.isRead = isRead2;
    }

    public void setCategories(ArrayList<Category> categories2) {
        this.categories = categories2;
    }

    public ArrayList<Tags> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<Tags> tags2) {
        this.tags = tags2;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author2) {
        this.author = author2;
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public void setComments(ArrayList<Comment> comments2) {
        this.comments = comments2;
    }

    public String getFormattedContent() {
        return this.formattedContent;
    }

    public void setFormattedContent(String formattedContent2) {
        this.formattedContent = formattedContent2;
    }
}
