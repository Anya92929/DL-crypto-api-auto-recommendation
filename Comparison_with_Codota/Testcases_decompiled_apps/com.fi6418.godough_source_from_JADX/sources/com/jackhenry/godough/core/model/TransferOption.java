package com.jackhenry.godough.core.model;

public class TransferOption implements GoDoughType {
    private static final long serialVersionUID = 1;
    private String description;

    /* renamed from: id */
    private int f6509id;

    public TransferOption() {
    }

    public TransferOption(int i, String str) {
        this.f6509id = i;
        this.description = str;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.f6509id;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i) {
        this.f6509id = i;
    }

    public String toString() {
        return this.description;
    }
}
