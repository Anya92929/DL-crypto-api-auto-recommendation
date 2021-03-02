package android.support.p009v4.p019f;

/* renamed from: android.support.v4.f.f */
public class C0141f implements Cloneable {

    /* renamed from: a */
    private static final Object f193a = new Object();

    /* renamed from: b */
    private boolean f194b;

    /* renamed from: c */
    private long[] f195c;

    /* renamed from: d */
    private Object[] f196d;

    /* renamed from: e */
    private int f197e;

    public C0141f() {
        this(10);
    }

    public C0141f(int i) {
        this.f194b = false;
        if (i == 0) {
            this.f195c = C0138c.f189b;
            this.f196d = C0138c.f190c;
        } else {
            int b = C0138c.m339b(i);
            this.f195c = new long[b];
            this.f196d = new Object[b];
        }
        this.f197e = 0;
    }

    /* renamed from: c */
    private void m343c() {
        int i = this.f197e;
        long[] jArr = this.f195c;
        Object[] objArr = this.f196d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f193a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f194b = false;
        this.f197e = i2;
    }

    /* renamed from: a */
    public long mo1053a(int i) {
        if (this.f194b) {
            m343c();
        }
        return this.f195c[i];
    }

    /* renamed from: a */
    public C0141f clone() {
        try {
            C0141f fVar = (C0141f) super.clone();
            try {
                fVar.f195c = (long[]) this.f195c.clone();
                fVar.f196d = (Object[]) this.f196d.clone();
                return fVar;
            } catch (CloneNotSupportedException e) {
                return fVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public Object mo1055a(long j) {
        return mo1056a(j, (Object) null);
    }

    /* renamed from: a */
    public Object mo1056a(long j, Object obj) {
        int a = C0138c.m337a(this.f195c, this.f197e, j);
        return (a < 0 || this.f196d[a] == f193a) ? obj : this.f196d[a];
    }

    /* renamed from: b */
    public int mo1057b() {
        if (this.f194b) {
            m343c();
        }
        return this.f197e;
    }

    /* renamed from: b */
    public Object mo1058b(int i) {
        if (this.f194b) {
            m343c();
        }
        return this.f196d[i];
    }

    /* renamed from: b */
    public void mo1059b(long j) {
        int a = C0138c.m337a(this.f195c, this.f197e, j);
        if (a >= 0 && this.f196d[a] != f193a) {
            this.f196d[a] = f193a;
            this.f194b = true;
        }
    }

    /* renamed from: b */
    public void mo1060b(long j, Object obj) {
        int a = C0138c.m337a(this.f195c, this.f197e, j);
        if (a >= 0) {
            this.f196d[a] = obj;
            return;
        }
        int i = a ^ -1;
        if (i >= this.f197e || this.f196d[i] != f193a) {
            if (this.f194b && this.f197e >= this.f195c.length) {
                m343c();
                i = C0138c.m337a(this.f195c, this.f197e, j) ^ -1;
            }
            if (this.f197e >= this.f195c.length) {
                int b = C0138c.m339b(this.f197e + 1);
                long[] jArr = new long[b];
                Object[] objArr = new Object[b];
                System.arraycopy(this.f195c, 0, jArr, 0, this.f195c.length);
                System.arraycopy(this.f196d, 0, objArr, 0, this.f196d.length);
                this.f195c = jArr;
                this.f196d = objArr;
            }
            if (this.f197e - i != 0) {
                System.arraycopy(this.f195c, i, this.f195c, i + 1, this.f197e - i);
                System.arraycopy(this.f196d, i, this.f196d, i + 1, this.f197e - i);
            }
            this.f195c[i] = j;
            this.f196d[i] = obj;
            this.f197e++;
            return;
        }
        this.f195c[i] = j;
        this.f196d[i] = obj;
    }

    public String toString() {
        if (mo1057b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f197e * 28);
        sb.append('{');
        for (int i = 0; i < this.f197e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo1053a(i));
            sb.append('=');
            Object b = mo1058b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
