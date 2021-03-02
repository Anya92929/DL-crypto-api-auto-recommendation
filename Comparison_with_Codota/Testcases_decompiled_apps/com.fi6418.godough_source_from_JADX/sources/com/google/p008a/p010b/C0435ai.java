package com.google.p008a.p010b;

import java.io.Writer;

/* renamed from: com.google.a.b.ai */
final class C0435ai extends Writer {

    /* renamed from: a */
    private final Appendable f3507a;

    /* renamed from: b */
    private final C0436aj f3508b;

    private C0435ai(Appendable appendable) {
        this.f3508b = new C0436aj();
        this.f3507a = appendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int i) {
        this.f3507a.append((char) i);
    }

    public void write(char[] cArr, int i, int i2) {
        this.f3508b.f3509a = cArr;
        this.f3507a.append(this.f3508b, i, i + i2);
    }
}
