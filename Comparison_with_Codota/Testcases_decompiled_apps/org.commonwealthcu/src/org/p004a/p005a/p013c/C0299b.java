package org.p004a.p005a.p013c;

/* renamed from: org.a.a.c.b */
public final class C0299b implements Cloneable {

    /* renamed from: a */
    private final int f132a;

    /* renamed from: b */
    private final int f133b;

    static {
        new C0300c().mo4946a();
    }

    C0299b(int i, int i2) {
        this.f132a = i;
        this.f133b = i2;
    }

    /* renamed from: c */
    public static C0300c m208c() {
        return new C0300c();
    }

    /* renamed from: a */
    public final int mo4942a() {
        return this.f132a;
    }

    /* renamed from: b */
    public final int mo4943b() {
        return this.f133b;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object clone() {
        return (C0299b) super.clone();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[maxLineLength=").append(this.f132a).append(", maxHeaderCount=").append(this.f133b).append("]");
        return sb.toString();
    }
}
