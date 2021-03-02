package com.p046c.p048b;

/* renamed from: com.c.b.c */
public abstract class C1199c {

    /* renamed from: a */
    private final String f3322a;

    /* renamed from: b */
    private final Class f3323b;

    public C1199c(Class cls, String str) {
        this.f3322a = str;
        this.f3323b = cls;
    }

    /* renamed from: a */
    public abstract Object mo4502a(Object obj);

    /* renamed from: a */
    public String mo4605a() {
        return this.f3322a;
    }

    /* renamed from: a */
    public void mo4603a(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Property " + mo4605a() + " is read-only");
    }
}
