package p000;

/* renamed from: jf */
public final class C1316jf {

    /* renamed from: a */
    public final byte[] f4570a;

    /* renamed from: b */
    public int f4571b;

    /* renamed from: c */
    public int f4572c;

    /* renamed from: d */
    public boolean f4573d;

    /* renamed from: e */
    public boolean f4574e;

    /* renamed from: f */
    public C1316jf f4575f;

    /* renamed from: g */
    public C1316jf f4576g;

    C1316jf() {
        this.f4570a = new byte[2048];
        this.f4574e = true;
        this.f4573d = false;
    }

    public C1316jf(C1316jf jfVar) {
        this(jfVar.f4570a, jfVar.f4571b, jfVar.f4572c);
        jfVar.f4573d = true;
    }

    C1316jf(byte[] bArr, int i, int i2) {
        this.f4570a = bArr;
        this.f4571b = i;
        this.f4572c = i2;
        this.f4574e = false;
        this.f4573d = true;
    }

    /* renamed from: a */
    public C1316jf mo8800a() {
        C1316jf jfVar = this.f4575f != this ? this.f4575f : null;
        this.f4576g.f4575f = this.f4575f;
        this.f4575f.f4576g = this.f4576g;
        this.f4575f = null;
        this.f4576g = null;
        return jfVar;
    }

    /* renamed from: a */
    public C1316jf mo8802a(C1316jf jfVar) {
        jfVar.f4576g = this;
        jfVar.f4575f = this.f4575f;
        this.f4575f.f4576g = jfVar;
        this.f4575f = jfVar;
        return jfVar;
    }

    /* renamed from: a */
    public C1316jf mo8801a(int i) {
        if (i <= 0 || i > this.f4572c - this.f4571b) {
            throw new IllegalArgumentException();
        }
        C1316jf jfVar = new C1316jf(this);
        jfVar.f4572c = jfVar.f4571b + i;
        this.f4571b += i;
        this.f4576g.mo8802a(jfVar);
        return jfVar;
    }

    /* renamed from: b */
    public void mo8804b() {
        if (this.f4576g == this) {
            throw new IllegalStateException();
        } else if (this.f4576g.f4574e) {
            int i = this.f4572c - this.f4571b;
            if (i <= (this.f4576g.f4573d ? 0 : this.f4576g.f4571b) + (2048 - this.f4576g.f4572c)) {
                mo8803a(this.f4576g, i);
                mo8800a();
                C1317jg.m5701a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo8803a(C1316jf jfVar, int i) {
        if (!jfVar.f4574e) {
            throw new IllegalArgumentException();
        }
        if (jfVar.f4572c + i > 2048) {
            if (jfVar.f4573d) {
                throw new IllegalArgumentException();
            } else if ((jfVar.f4572c + i) - jfVar.f4571b > 2048) {
                throw new IllegalArgumentException();
            } else {
                System.arraycopy(jfVar.f4570a, jfVar.f4571b, jfVar.f4570a, 0, jfVar.f4572c - jfVar.f4571b);
                jfVar.f4572c -= jfVar.f4571b;
                jfVar.f4571b = 0;
            }
        }
        System.arraycopy(this.f4570a, this.f4571b, jfVar.f4570a, jfVar.f4572c, i);
        jfVar.f4572c += i;
        this.f4571b += i;
    }
}
