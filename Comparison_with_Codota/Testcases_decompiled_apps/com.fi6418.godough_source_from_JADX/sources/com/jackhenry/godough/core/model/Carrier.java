package com.jackhenry.godough.core.model;

public class Carrier implements GoDoughType {

    /* renamed from: id */
    private int f6502id;
    private String name;

    public Carrier() {
    }

    public Carrier(int i, String str) {
        this.f6502id = i;
        this.name = str;
    }

    public int getId() {
        return this.f6502id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int i) {
        this.f6502id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
