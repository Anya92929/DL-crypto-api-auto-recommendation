package com.google.android.gms.tagmanager;

import java.util.Arrays;

/* renamed from: com.google.android.gms.tagmanager.e */
final class C1314e {

    /* renamed from: a */
    public final String f5397a;

    /* renamed from: b */
    public final Object f5398b;

    C1314e(String str, Object obj) {
        this.f5397a = str;
        this.f5398b = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1314e)) {
            return false;
        }
        C1314e eVar = (C1314e) obj;
        return this.f5397a.equals(eVar.f5397a) && this.f5398b.equals(eVar.f5398b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f5397a.hashCode()), Integer.valueOf(this.f5398b.hashCode())});
    }

    public String toString() {
        return "Key: " + this.f5397a + " value: " + this.f5398b.toString();
    }
}
