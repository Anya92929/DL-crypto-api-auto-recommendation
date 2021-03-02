package com.jackhenry.godough.core.model;

public class Payee implements GoDoughType {

    /* renamed from: id */
    private String f6507id;
    private String name;
    private String nickname;

    public Payee() {
    }

    public Payee(String str, String str2, String str3) {
        this.f6507id = str;
        this.name = str2;
        this.nickname = str3;
    }

    public String getId() {
        return this.f6507id;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setId(String str) {
        this.f6507id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public String toString() {
        return this.nickname;
    }
}
