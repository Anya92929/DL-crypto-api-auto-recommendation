package android.support.p009v4.p019f;

/* renamed from: android.support.v4.f.p */
public class C0151p implements Cloneable {

    /* renamed from: a */
    private static final Object f230a = new Object();

    /* renamed from: b */
    private boolean f231b;

    /* renamed from: c */
    private int[] f232c;

    /* renamed from: d */
    private Object[] f233d;

    /* renamed from: e */
    private int f234e;

    public C0151p() {
        this(10);
    }

    public C0151p(int i) {
        this.f231b = false;
        if (i == 0) {
            this.f232c = C0138c.f188a;
            this.f233d = C0138c.f190c;
        } else {
            int a = C0138c.m335a(i);
            this.f232c = new int[a];
            this.f233d = new Object[a];
        }
        this.f234e = 0;
    }

    /* renamed from: d */
    private void m389d() {
        int i = this.f234e;
        int[] iArr = this.f232c;
        Object[] objArr = this.f233d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f230a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f231b = false;
        this.f234e = i2;
    }

    /* renamed from: a */
    public C0151p clone() {
        try {
            C0151p pVar = (C0151p) super.clone();
            try {
                pVar.f232c = (int[]) this.f232c.clone();
                pVar.f233d = (Object[]) this.f233d.clone();
                return pVar;
            } catch (CloneNotSupportedException e) {
                return pVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public Object mo1167a(int i) {
        return mo1168a(i, (Object) null);
    }

    /* renamed from: a */
    public Object mo1168a(int i, Object obj) {
        int a = C0138c.m336a(this.f232c, this.f234e, i);
        return (a < 0 || this.f233d[a] == f230a) ? obj : this.f233d[a];
    }

    /* renamed from: b */
    public int mo1169b() {
        if (this.f231b) {
            m389d();
        }
        return this.f234e;
    }

    /* renamed from: b */
    public void mo1170b(int i) {
        int a = C0138c.m336a(this.f232c, this.f234e, i);
        if (a >= 0 && this.f233d[a] != f230a) {
            this.f233d[a] = f230a;
            this.f231b = true;
        }
    }

    /* renamed from: b */
    public void mo1171b(int i, Object obj) {
        int a = C0138c.m336a(this.f232c, this.f234e, i);
        if (a >= 0) {
            this.f233d[a] = obj;
            return;
        }
        int i2 = a ^ -1;
        if (i2 >= this.f234e || this.f233d[i2] != f230a) {
            if (this.f231b && this.f234e >= this.f232c.length) {
                m389d();
                i2 = C0138c.m336a(this.f232c, this.f234e, i) ^ -1;
            }
            if (this.f234e >= this.f232c.length) {
                int a2 = C0138c.m335a(this.f234e + 1);
                int[] iArr = new int[a2];
                Object[] objArr = new Object[a2];
                System.arraycopy(this.f232c, 0, iArr, 0, this.f232c.length);
                System.arraycopy(this.f233d, 0, objArr, 0, this.f233d.length);
                this.f232c = iArr;
                this.f233d = objArr;
            }
            if (this.f234e - i2 != 0) {
                System.arraycopy(this.f232c, i2, this.f232c, i2 + 1, this.f234e - i2);
                System.arraycopy(this.f233d, i2, this.f233d, i2 + 1, this.f234e - i2);
            }
            this.f232c[i2] = i;
            this.f233d[i2] = obj;
            this.f234e++;
            return;
        }
        this.f232c[i2] = i;
        this.f233d[i2] = obj;
    }

    /* renamed from: c */
    public void mo1172c() {
        int i = this.f234e;
        Object[] objArr = this.f233d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f234e = 0;
        this.f231b = false;
    }

    /* renamed from: c */
    public void mo1173c(int i) {
        mo1170b(i);
    }

    /* renamed from: d */
    public void mo1175d(int i) {
        if (this.f233d[i] != f230a) {
            this.f233d[i] = f230a;
            this.f231b = true;
        }
    }

    /* renamed from: e */
    public int mo1176e(int i) {
        if (this.f231b) {
            m389d();
        }
        return this.f232c[i];
    }

    /* renamed from: f */
    public Object mo1177f(int i) {
        if (this.f231b) {
            m389d();
        }
        return this.f233d[i];
    }

    /* renamed from: g */
    public int mo1178g(int i) {
        if (this.f231b) {
            m389d();
        }
        return C0138c.m336a(this.f232c, this.f234e, i);
    }

    public String toString() {
        if (mo1169b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f234e * 28);
        sb.append('{');
        for (int i = 0; i < this.f234e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo1176e(i));
            sb.append('=');
            Object f = mo1177f(i);
            if (f != this) {
                sb.append(f);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
