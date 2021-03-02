package org.p004a.p005a.p025g.p028c;

import org.p004a.p005a.C0297c;
import org.p004a.p005a.p032h.C0518e;
import org.p004a.p005a.p032h.C0520g;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.c.k */
public final class C0452k implements C0520g {

    /* renamed from: a */
    private final C0520g f442a;

    /* renamed from: b */
    private final C0455n f443b;

    /* renamed from: c */
    private final String f444c;

    public C0452k(C0520g gVar, C0455n nVar, String str) {
        this.f442a = gVar;
        this.f443b = nVar;
        this.f444c = str == null ? C0297c.f130b.name() : str;
    }

    /* renamed from: a */
    public final void mo5239a() {
        this.f442a.mo5239a();
    }

    /* renamed from: a */
    public final void mo5240a(int i) {
        this.f442a.mo5240a(i);
        if (this.f443b.mo5255a()) {
            this.f443b.mo5253a(new byte[]{(byte) i});
        }
    }

    /* renamed from: a */
    public final void mo5241a(String str) {
        this.f442a.mo5241a(str);
        if (this.f443b.mo5255a()) {
            this.f443b.mo5253a((str + "\r\n").getBytes(this.f444c));
        }
    }

    /* renamed from: a */
    public final void mo5242a(C0563b bVar) {
        this.f442a.mo5242a(bVar);
        if (this.f443b.mo5255a()) {
            this.f443b.mo5253a((new String(bVar.mo5434b(), 0, bVar.mo5435c()) + "\r\n").getBytes(this.f444c));
        }
    }

    /* renamed from: a */
    public final void mo5243a(byte[] bArr, int i, int i2) {
        this.f442a.mo5243a(bArr, i, i2);
        if (this.f443b.mo5255a()) {
            this.f443b.mo5254a(bArr, i, i2);
        }
    }

    /* renamed from: b */
    public final C0518e mo5244b() {
        return this.f442a.mo5244b();
    }
}
