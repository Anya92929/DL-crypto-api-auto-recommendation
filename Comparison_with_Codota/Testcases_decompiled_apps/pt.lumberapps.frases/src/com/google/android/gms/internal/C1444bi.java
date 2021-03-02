package com.google.android.gms.internal;

import java.io.Writer;

/* renamed from: com.google.android.gms.internal.bi */
final class C1444bi extends Writer {

    /* renamed from: a */
    private final Appendable f4883a;

    /* renamed from: b */
    private final C1445bj f4884b;

    private C1444bi(Appendable appendable) {
        this.f4884b = new C1445bj();
        this.f4883a = appendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int i) {
        this.f4883a.append((char) i);
    }

    public void write(char[] cArr, int i, int i2) {
        this.f4884b.f4885a = cArr;
        this.f4883a.append(this.f4884b, i, i + i2);
    }
}
