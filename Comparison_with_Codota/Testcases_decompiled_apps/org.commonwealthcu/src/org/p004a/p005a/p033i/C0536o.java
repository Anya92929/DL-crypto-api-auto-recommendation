package org.p004a.p005a.p033i;

import java.io.Serializable;
import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.o */
public final class C0536o implements Serializable, Cloneable, C0301d {

    /* renamed from: a */
    private final String f600a;

    /* renamed from: b */
    private final C0563b f601b;

    /* renamed from: c */
    private final int f602c;

    public C0536o(C0563b bVar) {
        C0250b.m84a((Object) bVar, "Char array buffer");
        int c = bVar.mo5436c(58);
        if (c == -1) {
            throw new C0239aa("Invalid header: " + bVar.toString());
        }
        String b = bVar.mo5432b(0, c);
        if (b.length() == 0) {
            throw new C0239aa("Invalid header: " + bVar.toString());
        }
        this.f601b = bVar;
        this.f600a = b;
        this.f602c = c + 1;
    }

    /* renamed from: a */
    public final C0563b mo4949a() {
        return this.f601b;
    }

    /* renamed from: b */
    public final int mo4950b() {
        return this.f602c;
    }

    /* renamed from: c */
    public final String mo5040c() {
        return this.f600a;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final String mo5041d() {
        return this.f601b.mo5432b(this.f602c, this.f601b.mo5435c());
    }

    /* renamed from: e */
    public final C0360f[] mo5042e() {
        C0541t tVar = new C0541t(0, this.f601b.mo5435c());
        tVar.mo5384a(this.f602c);
        return C0526e.f571a.mo5342a(this.f601b, tVar);
    }

    public final String toString() {
        return this.f601b.toString();
    }
}
