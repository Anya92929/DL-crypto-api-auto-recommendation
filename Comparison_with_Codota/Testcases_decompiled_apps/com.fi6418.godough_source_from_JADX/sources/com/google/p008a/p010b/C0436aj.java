package com.google.p008a.p010b;

/* renamed from: com.google.a.b.aj */
class C0436aj implements CharSequence {

    /* renamed from: a */
    char[] f3509a;

    C0436aj() {
    }

    public char charAt(int i) {
        return this.f3509a[i];
    }

    public int length() {
        return this.f3509a.length;
    }

    public CharSequence subSequence(int i, int i2) {
        return new String(this.f3509a, i, i2 - i);
    }
}
