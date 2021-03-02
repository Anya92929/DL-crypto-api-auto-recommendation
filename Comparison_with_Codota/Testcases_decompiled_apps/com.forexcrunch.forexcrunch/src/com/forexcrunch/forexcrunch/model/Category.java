package com.forexcrunch.forexcrunch.model;

public class Category {
    private String description;

    /* renamed from: id */
    private int f70id;
    private int parent;
    private int post_count;
    private String slug;
    private String title;

    public int getId() {
        return this.f70id;
    }

    public void setId(int id) {
        this.f70id = id;
    }

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent2) {
        this.parent = parent2;
    }

    public int getPost_count() {
        return this.post_count;
    }

    public void setPost_count(int post_count2) {
        this.post_count = post_count2;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug2) {
        this.slug = slug2;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }
}
