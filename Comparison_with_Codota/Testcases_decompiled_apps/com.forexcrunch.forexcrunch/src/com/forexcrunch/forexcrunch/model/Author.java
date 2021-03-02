package com.forexcrunch.forexcrunch.model;

public class Author {
    private String description;
    private String first_name;

    /* renamed from: id */
    private int f69id;
    private String last_name;
    private String name;
    private String nickname;
    private String slug;
    private String url;

    public int getId() {
        return this.f69id;
    }

    public void setId(int id) {
        this.f69id = id;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug2) {
        this.slug = slug2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name2) {
        this.first_name = first_name2;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name2) {
        this.last_name = last_name2;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname2) {
        this.nickname = nickname2;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url2) {
        this.url = url2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }
}
