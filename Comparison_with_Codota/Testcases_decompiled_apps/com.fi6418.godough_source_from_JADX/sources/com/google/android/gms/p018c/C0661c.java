package com.google.android.gms.p018c;

/* renamed from: com.google.android.gms.c.c */
public final class C0661c extends C0652bn<C0661c> {

    /* renamed from: o */
    private static volatile C0661c[] f4346o;

    /* renamed from: a */
    public int f4347a;

    /* renamed from: b */
    public String f4348b;

    /* renamed from: c */
    public C0661c[] f4349c;

    /* renamed from: d */
    public C0661c[] f4350d;

    /* renamed from: e */
    public C0661c[] f4351e;

    /* renamed from: f */
    public String f4352f;

    /* renamed from: g */
    public String f4353g;

    /* renamed from: h */
    public long f4354h;

    /* renamed from: i */
    public boolean f4355i;

    /* renamed from: j */
    public C0661c[] f4356j;

    /* renamed from: k */
    public int[] f4357k;

    /* renamed from: l */
    public boolean f4358l;

    public C0661c() {
        mo7196b();
    }

    /* renamed from: a */
    public static C0661c[] m3840a() {
        if (f4346o == null) {
            synchronized (C0656br.f4334a) {
                if (f4346o == null) {
                    f4346o = new C0661c[0];
                }
            }
        }
        return f4346o;
    }

    /* renamed from: a */
    public void mo7163a(C0650bl blVar) {
        blVar.mo7147a(1, this.f4347a);
        if (!this.f4348b.equals("")) {
            blVar.mo7150a(2, this.f4348b);
        }
        if (this.f4349c != null && this.f4349c.length > 0) {
            for (C0661c cVar : this.f4349c) {
                if (cVar != null) {
                    blVar.mo7149a(3, (C0657bs) cVar);
                }
            }
        }
        if (this.f4350d != null && this.f4350d.length > 0) {
            for (C0661c cVar2 : this.f4350d) {
                if (cVar2 != null) {
                    blVar.mo7149a(4, (C0657bs) cVar2);
                }
            }
        }
        if (this.f4351e != null && this.f4351e.length > 0) {
            for (C0661c cVar3 : this.f4351e) {
                if (cVar3 != null) {
                    blVar.mo7149a(5, (C0657bs) cVar3);
                }
            }
        }
        if (!this.f4352f.equals("")) {
            blVar.mo7150a(6, this.f4352f);
        }
        if (!this.f4353g.equals("")) {
            blVar.mo7150a(7, this.f4353g);
        }
        if (this.f4354h != 0) {
            blVar.mo7148a(8, this.f4354h);
        }
        if (this.f4358l) {
            blVar.mo7151a(9, this.f4358l);
        }
        if (this.f4357k != null && this.f4357k.length > 0) {
            for (int a : this.f4357k) {
                blVar.mo7147a(10, a);
            }
        }
        if (this.f4356j != null && this.f4356j.length > 0) {
            for (C0661c cVar4 : this.f4356j) {
                if (cVar4 != null) {
                    blVar.mo7149a(11, (C0657bs) cVar4);
                }
            }
        }
        if (this.f4355i) {
            blVar.mo7151a(12, this.f4355i);
        }
        super.mo7163a(blVar);
    }

    /* renamed from: b */
    public C0661c mo7196b() {
        this.f4347a = 1;
        this.f4348b = "";
        this.f4349c = m3840a();
        this.f4350d = m3840a();
        this.f4351e = m3840a();
        this.f4352f = "";
        this.f4353g = "";
        this.f4354h = 0;
        this.f4355i = false;
        this.f4356j = m3840a();
        this.f4357k = C0660bv.f4338a;
        this.f4358l = false;
        this.f4321m = null;
        this.f4335n = -1;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo7165c() {
        int c = super.mo7165c() + C0650bl.m3762b(1, this.f4347a);
        if (!this.f4348b.equals("")) {
            c += C0650bl.m3765b(2, this.f4348b);
        }
        if (this.f4349c != null && this.f4349c.length > 0) {
            int i = c;
            for (C0661c cVar : this.f4349c) {
                if (cVar != null) {
                    i += C0650bl.m3771c(3, (C0657bs) cVar);
                }
            }
            c = i;
        }
        if (this.f4350d != null && this.f4350d.length > 0) {
            int i2 = c;
            for (C0661c cVar2 : this.f4350d) {
                if (cVar2 != null) {
                    i2 += C0650bl.m3771c(4, (C0657bs) cVar2);
                }
            }
            c = i2;
        }
        if (this.f4351e != null && this.f4351e.length > 0) {
            int i3 = c;
            for (C0661c cVar3 : this.f4351e) {
                if (cVar3 != null) {
                    i3 += C0650bl.m3771c(5, (C0657bs) cVar3);
                }
            }
            c = i3;
        }
        if (!this.f4352f.equals("")) {
            c += C0650bl.m3765b(6, this.f4352f);
        }
        if (!this.f4353g.equals("")) {
            c += C0650bl.m3765b(7, this.f4353g);
        }
        if (this.f4354h != 0) {
            c += C0650bl.m3763b(8, this.f4354h);
        }
        if (this.f4358l) {
            c += C0650bl.m3766b(9, this.f4358l);
        }
        if (this.f4357k != null && this.f4357k.length > 0) {
            int i4 = 0;
            for (int b : this.f4357k) {
                i4 += C0650bl.m3761b(b);
            }
            c = c + i4 + (this.f4357k.length * 1);
        }
        if (this.f4356j != null && this.f4356j.length > 0) {
            for (C0661c cVar4 : this.f4356j) {
                if (cVar4 != null) {
                    c += C0650bl.m3771c(11, (C0657bs) cVar4);
                }
            }
        }
        return this.f4355i ? c + C0650bl.m3766b(12, this.f4355i) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0661c)) {
            return false;
        }
        C0661c cVar = (C0661c) obj;
        if (this.f4347a != cVar.f4347a) {
            return false;
        }
        if (this.f4348b == null) {
            if (cVar.f4348b != null) {
                return false;
            }
        } else if (!this.f4348b.equals(cVar.f4348b)) {
            return false;
        }
        if (!C0656br.m3824a((Object[]) this.f4349c, (Object[]) cVar.f4349c) || !C0656br.m3824a((Object[]) this.f4350d, (Object[]) cVar.f4350d) || !C0656br.m3824a((Object[]) this.f4351e, (Object[]) cVar.f4351e)) {
            return false;
        }
        if (this.f4352f == null) {
            if (cVar.f4352f != null) {
                return false;
            }
        } else if (!this.f4352f.equals(cVar.f4352f)) {
            return false;
        }
        if (this.f4353g == null) {
            if (cVar.f4353g != null) {
                return false;
            }
        } else if (!this.f4353g.equals(cVar.f4353g)) {
            return false;
        }
        if (this.f4354h == cVar.f4354h && this.f4355i == cVar.f4355i && C0656br.m3824a((Object[]) this.f4356j, (Object[]) cVar.f4356j) && C0656br.m3823a(this.f4357k, cVar.f4357k) && this.f4358l == cVar.f4358l) {
            return mo7164a(cVar);
        }
        return false;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = 0;
        int hashCode = ((this.f4352f == null ? 0 : this.f4352f.hashCode()) + (((((((((this.f4348b == null ? 0 : this.f4348b.hashCode()) + ((this.f4347a + 527) * 31)) * 31) + C0656br.m3821a((Object[]) this.f4349c)) * 31) + C0656br.m3821a((Object[]) this.f4350d)) * 31) + C0656br.m3821a((Object[]) this.f4351e)) * 31)) * 31;
        if (this.f4353g != null) {
            i2 = this.f4353g.hashCode();
        }
        int a = ((((((this.f4355i ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.f4354h ^ (this.f4354h >>> 32)))) * 31)) * 31) + C0656br.m3821a((Object[]) this.f4356j)) * 31) + C0656br.m3820a(this.f4357k)) * 31;
        if (!this.f4358l) {
            i = 1237;
        }
        return ((a + i) * 31) + mo7167d();
    }
}
