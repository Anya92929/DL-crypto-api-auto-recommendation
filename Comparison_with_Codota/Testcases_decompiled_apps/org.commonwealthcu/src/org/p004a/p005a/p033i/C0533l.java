package org.p004a.p005a.p033i;

import java.io.Serializable;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0243ae;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.l */
public final class C0533l implements Serializable, Cloneable, C0243ae {

    /* renamed from: a */
    private final C0241ac f590a;

    /* renamed from: b */
    private final String f591b;

    /* renamed from: c */
    private final String f592c;

    public C0533l(String str, String str2, C0241ac acVar) {
        this.f591b = (String) C0250b.m84a((Object) str, "Method");
        this.f592c = (String) C0250b.m84a((Object) str2, "URI");
        this.f590a = (C0241ac) C0250b.m84a((Object) acVar, "Version");
    }

    /* renamed from: a */
    public final String mo4863a() {
        return this.f591b;
    }

    /* renamed from: b */
    public final C0241ac mo4864b() {
        return this.f590a;
    }

    /* renamed from: c */
    public final String mo4865c() {
        return this.f592c;
    }

    public final Object clone() {
        return super.clone();
    }

    public final String toString() {
        return C0529h.f581a.mo5349a((C0563b) null, (C0243ae) this).toString();
    }
}
