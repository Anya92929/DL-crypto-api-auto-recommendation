package org.p004a.p005a.p025g.p028c;

import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p014d.C0342p;
import org.p004a.p005a.p014d.C0343q;

/* renamed from: org.a.a.g.c.h */
public final class C0449h implements C0342p {

    /* renamed from: a */
    public static final C0449h f435a = new C0449h();

    /* renamed from: a */
    public final int mo5039a(C0565n nVar) {
        C0250b.m84a((Object) nVar, "HTTP host");
        int b = nVar.mo5442b();
        if (b > 0) {
            return b;
        }
        String c = nVar.mo5443c();
        if (c.equalsIgnoreCase("http")) {
            return 80;
        }
        if (c.equalsIgnoreCase("https")) {
            return 443;
        }
        throw new C0343q(c + " protocol is not supported");
    }
}
