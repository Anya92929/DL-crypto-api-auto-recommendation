package android.support.p009v4.p019f;

import java.util.Map;

/* renamed from: android.support.v4.f.o */
public class C0150o {

    /* renamed from: b */
    static Object[] f223b;

    /* renamed from: c */
    static int f224c;

    /* renamed from: d */
    static Object[] f225d;

    /* renamed from: e */
    static int f226e;

    /* renamed from: f */
    int[] f227f;

    /* renamed from: g */
    Object[] f228g;

    /* renamed from: h */
    int f229h;

    public C0150o() {
        this.f227f = C0138c.f188a;
        this.f228g = C0138c.f190c;
        this.f229h = 0;
    }

    public C0150o(int i) {
        if (i == 0) {
            this.f227f = C0138c.f188a;
            this.f228g = C0138c.f190c;
        } else {
            m378e(i);
        }
        this.f229h = 0;
    }

    /* renamed from: a */
    private static void m377a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0136a.class) {
                if (f226e < 10) {
                    objArr[0] = f225d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f225d = objArr;
                    f226e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0136a.class) {
                if (f224c < 10) {
                    objArr[0] = f223b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f223b = objArr;
                    f224c++;
                }
            }
        }
    }

    /* renamed from: e */
    private void m378e(int i) {
        if (i == 8) {
            synchronized (C0136a.class) {
                if (f225d != null) {
                    Object[] objArr = f225d;
                    this.f228g = objArr;
                    f225d = (Object[]) objArr[0];
                    this.f227f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f226e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0136a.class) {
                if (f223b != null) {
                    Object[] objArr2 = f223b;
                    this.f228g = objArr2;
                    f223b = (Object[]) objArr2[0];
                    this.f227f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f224c--;
                    return;
                }
            }
        }
        this.f227f = new int[i];
        this.f228g = new Object[(i << 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo1145a() {
        int i = this.f229h;
        if (i == 0) {
            return -1;
        }
        int a = C0138c.m336a(this.f227f, i, 0);
        if (a < 0 || this.f228g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f227f[i2] == 0) {
            if (this.f228g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f227f[i3] == 0) {
            if (this.f228g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* renamed from: a */
    public int mo1146a(Object obj) {
        return obj == null ? mo1145a() : mo1147a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo1147a(Object obj, int i) {
        int i2 = this.f229h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0138c.m336a(this.f227f, i2, i);
        if (a < 0 || obj.equals(this.f228g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f227f[i3] == i) {
            if (obj.equals(this.f228g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f227f[i4] == i) {
            if (obj.equals(this.f228g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* renamed from: a */
    public Object mo1148a(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object obj2 = this.f228g[i2];
        this.f228g[i2] = obj;
        return obj2;
    }

    /* renamed from: a */
    public void mo1149a(int i) {
        if (this.f227f.length < i) {
            int[] iArr = this.f227f;
            Object[] objArr = this.f228g;
            m378e(i);
            if (this.f229h > 0) {
                System.arraycopy(iArr, 0, this.f227f, 0, this.f229h);
                System.arraycopy(objArr, 0, this.f228g, 0, this.f229h << 1);
            }
            m377a(iArr, objArr, this.f229h);
        }
    }

    /* renamed from: a */
    public void mo1150a(C0150o oVar) {
        int i = oVar.f229h;
        mo1149a(this.f229h + i);
        if (this.f229h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(oVar.mo1152b(i2), oVar.mo1153c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(oVar.f227f, 0, this.f227f, 0, i);
            System.arraycopy(oVar.f228g, 0, this.f228g, 0, i << 1);
            this.f229h = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo1151b(Object obj) {
        int i = 1;
        int i2 = this.f229h * 2;
        Object[] objArr = this.f228g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public Object mo1152b(int i) {
        return this.f228g[i << 1];
    }

    /* renamed from: c */
    public Object mo1153c(int i) {
        return this.f228g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f229h != 0) {
            m377a(this.f227f, this.f228g, this.f229h);
            this.f227f = C0138c.f188a;
            this.f228g = C0138c.f190c;
            this.f229h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return mo1146a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo1151b(obj) >= 0;
    }

    /* renamed from: d */
    public Object mo1157d(int i) {
        int i2 = 8;
        Object obj = this.f228g[(i << 1) + 1];
        if (this.f229h <= 1) {
            m377a(this.f227f, this.f228g, this.f229h);
            this.f227f = C0138c.f188a;
            this.f228g = C0138c.f190c;
            this.f229h = 0;
        } else if (this.f227f.length <= 8 || this.f229h >= this.f227f.length / 3) {
            this.f229h--;
            if (i < this.f229h) {
                System.arraycopy(this.f227f, i + 1, this.f227f, i, this.f229h - i);
                System.arraycopy(this.f228g, (i + 1) << 1, this.f228g, i << 1, (this.f229h - i) << 1);
            }
            this.f228g[this.f229h << 1] = null;
            this.f228g[(this.f229h << 1) + 1] = null;
        } else {
            if (this.f229h > 8) {
                i2 = this.f229h + (this.f229h >> 1);
            }
            int[] iArr = this.f227f;
            Object[] objArr = this.f228g;
            m378e(i2);
            this.f229h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f227f, 0, i);
                System.arraycopy(objArr, 0, this.f228g, 0, i << 1);
            }
            if (i < this.f229h) {
                System.arraycopy(iArr, i + 1, this.f227f, i, this.f229h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.f228g, i << 1, (this.f229h - i) << 1);
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0150o) {
            C0150o oVar = (C0150o) obj;
            if (size() != oVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f229h) {
                try {
                    Object b = mo1152b(i);
                    Object c = mo1153c(i);
                    Object obj2 = oVar.get(b);
                    if (c == null) {
                        if (obj2 != null || !oVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e) {
                    return false;
                } catch (ClassCastException e2) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f229h) {
                try {
                    Object b2 = mo1152b(i2);
                    Object c2 = mo1153c(i2);
                    Object obj3 = map.get(b2);
                    if (c2 == null) {
                        if (obj3 != null || !map.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public Object get(Object obj) {
        int a = mo1146a(obj);
        if (a >= 0) {
            return this.f228g[(a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f227f;
        Object[] objArr = this.f228g;
        int i = this.f229h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f229h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int hashCode;
        int a;
        int i = 8;
        if (obj == null) {
            a = mo1145a();
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
            a = mo1147a(obj, hashCode);
        }
        if (a >= 0) {
            int i2 = (a << 1) + 1;
            Object obj3 = this.f228g[i2];
            this.f228g[i2] = obj2;
            return obj3;
        }
        int i3 = a ^ -1;
        if (this.f229h >= this.f227f.length) {
            if (this.f229h >= 8) {
                i = this.f229h + (this.f229h >> 1);
            } else if (this.f229h < 4) {
                i = 4;
            }
            int[] iArr = this.f227f;
            Object[] objArr = this.f228g;
            m378e(i);
            if (this.f227f.length > 0) {
                System.arraycopy(iArr, 0, this.f227f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f228g, 0, objArr.length);
            }
            m377a(iArr, objArr, this.f229h);
        }
        if (i3 < this.f229h) {
            System.arraycopy(this.f227f, i3, this.f227f, i3 + 1, this.f229h - i3);
            System.arraycopy(this.f228g, i3 << 1, this.f228g, (i3 + 1) << 1, (this.f229h - i3) << 1);
        }
        this.f227f[i3] = hashCode;
        this.f228g[i3 << 1] = obj;
        this.f228g[(i3 << 1) + 1] = obj2;
        this.f229h++;
        return null;
    }

    public Object remove(Object obj) {
        int a = mo1146a(obj);
        if (a >= 0) {
            return mo1157d(a);
        }
        return null;
    }

    public int size() {
        return this.f229h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f229h * 28);
        sb.append('{');
        for (int i = 0; i < this.f229h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo1152b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c = mo1153c(i);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
