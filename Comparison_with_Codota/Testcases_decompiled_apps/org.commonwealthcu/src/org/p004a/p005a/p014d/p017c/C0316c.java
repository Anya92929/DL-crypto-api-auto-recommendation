package org.p004a.p005a.p014d.p017c;

import java.util.Locale;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.d.c.c */
public final class C0316c {

    /* renamed from: a */
    private final String f157a;

    /* renamed from: b */
    private final C0320g f158b;

    /* renamed from: c */
    private final int f159c;

    /* renamed from: d */
    private final boolean f160d;

    /* renamed from: e */
    private String f161e;

    public C0316c(String str, int i, C0320g gVar) {
        C0250b.m84a((Object) str, "Scheme name");
        C0250b.m95a(i > 0 && i <= 65535, "Port is invalid");
        C0250b.m84a((Object) gVar, "Socket factory");
        this.f157a = str.toLowerCase(Locale.ENGLISH);
        this.f159c = i;
        if (gVar instanceof C0317d) {
            this.f160d = true;
            this.f158b = gVar;
        } else if (gVar instanceof C0314a) {
            this.f160d = true;
            this.f158b = new C0318e((C0314a) gVar);
        } else {
            this.f160d = false;
            this.f158b = gVar;
        }
    }

    /* renamed from: a */
    public final int mo4995a() {
        return this.f159c;
    }

    /* renamed from: a */
    public final int mo4996a(int i) {
        return i <= 0 ? this.f159c : i;
    }

    /* renamed from: b */
    public final C0320g mo4997b() {
        return this.f158b;
    }

    /* renamed from: c */
    public final String mo4998c() {
        return this.f157a;
    }

    /* renamed from: d */
    public final boolean mo4999d() {
        return this.f160d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0316c)) {
            return false;
        }
        C0316c cVar = (C0316c) obj;
        return this.f157a.equals(cVar.f157a) && this.f159c == cVar.f159c && this.f160d == cVar.f160d;
    }

    public final int hashCode() {
        return C0250b.m79a(C0250b.m77a(this.f159c + 629, (Object) this.f157a), this.f160d);
    }

    public final String toString() {
        if (this.f161e == null) {
            this.f161e = this.f157a + ':' + Integer.toString(this.f159c);
        }
        return this.f161e;
    }
}
