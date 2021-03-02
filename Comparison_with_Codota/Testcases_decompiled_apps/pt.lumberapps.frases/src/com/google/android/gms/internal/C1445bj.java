package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.bj */
class C1445bj implements CharSequence {

    /* renamed from: a */
    char[] f4885a;

    C1445bj() {
    }

    public char charAt(int i) {
        return this.f4885a[i];
    }

    public int length() {
        return this.f4885a.length;
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.f4885a, i, i2 - i);
    }
}
