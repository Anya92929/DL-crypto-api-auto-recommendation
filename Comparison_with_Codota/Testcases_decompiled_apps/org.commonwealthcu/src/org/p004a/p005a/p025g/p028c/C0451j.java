package org.p004a.p005a.p025g.p028c;

import org.p004a.p005a.C0297c;
import org.p004a.p005a.p032h.C0515b;
import org.p004a.p005a.p032h.C0518e;
import org.p004a.p005a.p032h.C0519f;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.c.j */
public final class C0451j implements C0515b, C0519f {

    /* renamed from: a */
    private final C0519f f438a;

    /* renamed from: b */
    private final C0515b f439b;

    /* renamed from: c */
    private final C0455n f440c;

    /* renamed from: d */
    private final String f441d;

    public C0451j(C0519f fVar, C0455n nVar, String str) {
        this.f438a = fVar;
        this.f439b = fVar instanceof C0515b ? (C0515b) fVar : null;
        this.f440c = nVar;
        this.f441d = str == null ? C0297c.f130b.name() : str;
    }

    /* renamed from: a */
    public final int mo5233a() {
        int a = this.f438a.mo5233a();
        if (this.f440c.mo5255a() && a != -1) {
            this.f440c.mo5256b(new byte[]{(byte) a});
        }
        return a;
    }

    /* renamed from: a */
    public final int mo5234a(C0563b bVar) {
        int a = this.f438a.mo5234a(bVar);
        if (this.f440c.mo5255a() && a >= 0) {
            this.f440c.mo5256b((new String(bVar.mo5434b(), bVar.mo5435c() - a, a) + "\r\n").getBytes(this.f441d));
        }
        return a;
    }

    /* renamed from: a */
    public final int mo5235a(byte[] bArr, int i, int i2) {
        int a = this.f438a.mo5235a(bArr, i, i2);
        if (this.f440c.mo5255a() && a > 0) {
            this.f440c.mo5257b(bArr, i, a);
        }
        return a;
    }

    /* renamed from: a */
    public final boolean mo5236a(int i) {
        return this.f438a.mo5236a(i);
    }

    /* renamed from: b */
    public final C0518e mo5237b() {
        return this.f438a.mo5237b();
    }

    /* renamed from: c */
    public final boolean mo5238c() {
        if (this.f439b != null) {
            return this.f439b.mo5238c();
        }
        return false;
    }
}
