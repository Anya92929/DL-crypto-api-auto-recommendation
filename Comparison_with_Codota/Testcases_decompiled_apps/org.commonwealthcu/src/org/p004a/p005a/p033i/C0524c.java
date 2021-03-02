package org.p004a.p005a.p033i;

import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.i.c */
public final class C0524c implements Cloneable, C0360f {

    /* renamed from: a */
    private final String f567a;

    /* renamed from: b */
    private final String f568b;

    /* renamed from: c */
    private final C0576y[] f569c;

    public C0524c(String str, String str2) {
        this(str, str2, (C0576y[]) null);
    }

    public C0524c(String str, String str2, C0576y[] yVarArr) {
        this.f567a = (String) C0250b.m84a((Object) str, "Name");
        this.f568b = str2;
        if (yVarArr != null) {
            this.f569c = yVarArr;
        } else {
            this.f569c = new C0576y[0];
        }
    }

    /* renamed from: a */
    public final String mo5080a() {
        return this.f567a;
    }

    /* renamed from: a */
    public final C0576y mo5081a(int i) {
        return this.f569c[i];
    }

    /* renamed from: a */
    public final C0576y mo5082a(String str) {
        C0250b.m84a((Object) str, "Name");
        for (C0576y yVar : this.f569c) {
            if (yVar.mo5357a().equalsIgnoreCase(str)) {
                return yVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final String mo5083b() {
        return this.f568b;
    }

    /* renamed from: c */
    public final C0576y[] mo5084c() {
        return (C0576y[]) this.f569c.clone();
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final int mo5085d() {
        return this.f569c.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0360f)) {
            return false;
        }
        C0524c cVar = (C0524c) obj;
        return this.f567a.equals(cVar.f567a) && C0250b.m97a((Object) this.f568b, (Object) cVar.f568b) && C0250b.m98a((Object[]) this.f569c, (Object[]) cVar.f569c);
    }

    public final int hashCode() {
        int a = C0250b.m77a(C0250b.m77a(17, (Object) this.f567a), (Object) this.f568b);
        for (C0576y a2 : this.f569c) {
            a = C0250b.m77a(a, (Object) a2);
        }
        return a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f567a);
        if (this.f568b != null) {
            sb.append("=");
            sb.append(this.f568b);
        }
        for (C0576y append : this.f569c) {
            sb.append("; ");
            sb.append(append);
        }
        return sb.toString();
    }
}
