package com.google.ads.util;

import android.os.Build;

/* renamed from: com.google.ads.util.d */
class C0290d {

    /* renamed from: d */
    static final C0290d f724d = new C0290d();

    /* renamed from: e */
    static final C0290d f725e = new C0290d("unknown", "generic", "generic");

    /* renamed from: f */
    static final C0290d f726f = new C0290d("unknown", "generic_x86", "Android");

    /* renamed from: a */
    public final String f727a;

    /* renamed from: b */
    public final String f728b;

    /* renamed from: c */
    public final String f729c;

    C0290d() {
        this.f727a = Build.BOARD;
        this.f728b = Build.DEVICE;
        this.f729c = Build.BRAND;
    }

    C0290d(String str, String str2, String str3) {
        this.f727a = str;
        this.f728b = str2;
        this.f729c = str3;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C0290d)) {
            return false;
        }
        C0290d dVar = (C0290d) o;
        if (!m496a(this.f727a, dVar.f727a) || !m496a(this.f728b, dVar.f728b) || !m496a(this.f729c, dVar.f729c)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m496a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str == str2;
    }

    public int hashCode() {
        int i = 0;
        if (this.f727a != null) {
            i = 0 + this.f727a.hashCode();
        }
        if (this.f728b != null) {
            i += this.f728b.hashCode();
        }
        if (this.f729c != null) {
            return i + this.f729c.hashCode();
        }
        return i;
    }
}
