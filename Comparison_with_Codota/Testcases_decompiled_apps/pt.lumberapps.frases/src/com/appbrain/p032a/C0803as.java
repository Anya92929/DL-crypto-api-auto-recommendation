package com.appbrain.p032a;

/* renamed from: com.appbrain.a.as */
final class C0803as {

    /* renamed from: a */
    private final StringBuilder f2112a = new StringBuilder();

    C0803as() {
    }

    /* renamed from: a */
    private C0803as m3610a(String str, String str2) {
        this.f2112a.append("&");
        this.f2112a.append(str);
        this.f2112a.append("=");
        this.f2112a.append(str2);
        return this;
    }

    /* renamed from: a */
    public final C0803as mo3645a(int i) {
        return m3610a("it", String.valueOf(i));
    }

    /* renamed from: a */
    public final C0803as mo3646a(String str) {
        return m3610a("ic", str);
    }

    /* renamed from: a */
    public final C0803as mo3647a(boolean z) {
        return m3610a("sm", z ? "1" : "0");
    }

    /* renamed from: b */
    public final C0803as mo3648b(int i) {
        return m3610a("bt", String.valueOf(i));
    }

    /* renamed from: b */
    public final C0803as mo3649b(boolean z) {
        return m3610a("mb", z ? "1" : "0");
    }

    /* renamed from: c */
    public final C0803as mo3650c(int i) {
        return m3610a("id", String.valueOf(i));
    }

    public final String toString() {
        return this.f2112a.toString();
    }
}
