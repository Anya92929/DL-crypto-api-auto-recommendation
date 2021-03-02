package com.flurry.android;

public final class Offer {

    /* renamed from: a */
    private long f75a;

    /* renamed from: b */
    private String f76b;

    /* renamed from: c */
    private String f77c;

    /* renamed from: d */
    private int f78d;

    /* renamed from: e */
    private AdImage f79e;

    Offer(long j, AdImage adImage, String str, String str2, int i) {
        this.f75a = j;
        this.f76b = str;
        this.f79e = adImage;
        this.f77c = str2;
        this.f78d = i;
    }

    public final long getId() {
        return this.f75a;
    }

    public final String getName() {
        return this.f76b;
    }

    public final String getDescription() {
        return this.f77c;
    }

    public final int getPrice() {
        return this.f78d;
    }

    public final String getUrl() {
        return "";
    }

    public final AdImage getImage() {
        return this.f79e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id=" + this.f75a + ",name=" + this.f76b + ",price=" + this.f78d + ", image size: " + this.f79e.f7e.length);
        return sb.toString();
    }
}
