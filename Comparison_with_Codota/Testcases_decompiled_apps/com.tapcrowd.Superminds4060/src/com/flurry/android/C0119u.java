package com.flurry.android;

/* renamed from: com.flurry.android.u */
final class C0119u {

    /* renamed from: a */
    long f226a;

    /* renamed from: b */
    C0114p f227b;

    /* renamed from: c */
    String f228c;

    /* renamed from: d */
    String f229d;

    /* renamed from: e */
    int f230e;

    /* renamed from: f */
    AdImage f231f;

    C0119u(long j, C0114p pVar, AdImage adImage, String str, String str2, int i) {
        this.f226a = j;
        this.f227b = pVar;
        this.f228c = str;
        this.f231f = adImage;
        this.f229d = str2;
        this.f230e = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[id=" + this.f226a).append(",name=" + this.f228c + "]");
        return sb.toString();
    }
}
