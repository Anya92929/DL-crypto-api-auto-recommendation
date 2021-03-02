package com.jackhenry.godough.core.model;

public class CheckImageData implements GoDoughType {
    private long amount;

    /* renamed from: id */
    private String f6503id;

    public CheckImageData() {
    }

    public CheckImageData(String str, long j) {
        this.f6503id = str;
        this.amount = j;
    }

    public long getAmount() {
        return this.amount;
    }

    public String getId() {
        return this.f6503id;
    }

    public void setAmount(long j) {
        this.amount = j;
    }

    public void setId(String str) {
        this.f6503id = str;
    }
}
