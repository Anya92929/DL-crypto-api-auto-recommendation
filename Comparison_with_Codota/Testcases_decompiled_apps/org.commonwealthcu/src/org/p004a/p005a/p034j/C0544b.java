package org.p004a.p005a.p034j;

/* renamed from: org.a.a.j.b */
public abstract class C0544b {
    protected C0544b() {
    }

    /* renamed from: a */
    public int mo5389a(String str, int i) {
        Object a = mo5196a(str);
        return a == null ? i : ((Integer) a).intValue();
    }

    /* renamed from: a */
    public abstract Object mo5196a(String str);

    /* renamed from: a */
    public abstract C0544b mo5197a(String str, Object obj);

    /* renamed from: a */
    public boolean mo5390a(String str, boolean z) {
        Object a = mo5196a(str);
        return a == null ? z : ((Boolean) a).booleanValue();
    }

    /* renamed from: b */
    public C0544b mo5391b(String str, int i) {
        mo5197a(str, (Object) Integer.valueOf(i));
        return this;
    }

    /* renamed from: b */
    public C0544b mo5392b(String str, boolean z) {
        mo5197a(str, (Object) z ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }
}
