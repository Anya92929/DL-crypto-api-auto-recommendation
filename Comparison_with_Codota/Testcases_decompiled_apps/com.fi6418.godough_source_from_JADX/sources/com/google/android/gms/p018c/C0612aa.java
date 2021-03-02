package com.google.android.gms.p018c;

import java.util.Map;

/* renamed from: com.google.android.gms.c.aa */
public class C0612aa<K, V> {

    /* renamed from: b */
    static Object[] f4210b;

    /* renamed from: c */
    static int f4211c;

    /* renamed from: d */
    static Object[] f4212d;

    /* renamed from: e */
    static int f4213e;

    /* renamed from: f */
    int[] f4214f = C0678t.f4380a;

    /* renamed from: g */
    Object[] f4215g = C0678t.f4382c;

    /* renamed from: h */
    int f4216h = 0;

    /* renamed from: a */
    private static void m3539a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0676r.class) {
                if (f4213e < 10) {
                    objArr[0] = f4212d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f4212d = objArr;
                    f4213e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0676r.class) {
                if (f4211c < 10) {
                    objArr[0] = f4210b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f4210b = objArr;
                    f4211c++;
                }
            }
        }
    }

    /* renamed from: e */
    private void m3540e(int i) {
        if (i == 8) {
            synchronized (C0676r.class) {
                if (f4212d != null) {
                    Object[] objArr = f4212d;
                    this.f4215g = objArr;
                    f4212d = (Object[]) objArr[0];
                    this.f4214f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f4213e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0676r.class) {
                if (f4210b != null) {
                    Object[] objArr2 = f4210b;
                    this.f4215g = objArr2;
                    f4210b = (Object[]) objArr2[0];
                    this.f4214f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f4211c--;
                    return;
                }
            }
        }
        this.f4214f = new int[i];
        this.f4215g = new Object[(i << 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6971a() {
        int i = this.f4216h;
        if (i == 0) {
            return -1;
        }
        int a = C0678t.m3918a(this.f4214f, i, 0);
        if (a < 0 || this.f4215g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f4214f[i2] == 0) {
            if (this.f4215g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f4214f[i3] == 0) {
            if (this.f4215g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6972a(Object obj) {
        int i = 1;
        int i2 = this.f4216h * 2;
        Object[] objArr = this.f4215g;
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

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6973a(Object obj, int i) {
        int i2 = this.f4216h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0678t.m3918a(this.f4214f, i2, i);
        if (a < 0 || obj.equals(this.f4215g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f4214f[i3] == i) {
            if (obj.equals(this.f4215g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f4214f[i4] == i) {
            if (obj.equals(this.f4215g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* renamed from: a */
    public V mo6974a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f4215g[i2];
        this.f4215g[i2] = v;
        return v2;
    }

    /* renamed from: a */
    public void mo6975a(int i) {
        if (this.f4214f.length < i) {
            int[] iArr = this.f4214f;
            Object[] objArr = this.f4215g;
            m3540e(i);
            if (this.f4216h > 0) {
                System.arraycopy(iArr, 0, this.f4214f, 0, this.f4216h);
                System.arraycopy(objArr, 0, this.f4215g, 0, this.f4216h << 1);
            }
            m3539a(iArr, objArr, this.f4216h);
        }
    }

    /* renamed from: b */
    public K mo6976b(int i) {
        return this.f4215g[i << 1];
    }

    /* renamed from: c */
    public V mo6977c(int i) {
        return this.f4215g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f4216h != 0) {
            m3539a(this.f4214f, this.f4215g, this.f4216h);
            this.f4214f = C0678t.f4380a;
            this.f4215g = C0678t.f4382c;
            this.f4216h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? mo6971a() >= 0 : mo6973a(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo6972a(obj) >= 0;
    }

    /* renamed from: d */
    public V mo6981d(int i) {
        int i2 = 8;
        V v = this.f4215g[(i << 1) + 1];
        if (this.f4216h <= 1) {
            m3539a(this.f4214f, this.f4215g, this.f4216h);
            this.f4214f = C0678t.f4380a;
            this.f4215g = C0678t.f4382c;
            this.f4216h = 0;
        } else if (this.f4214f.length <= 8 || this.f4216h >= this.f4214f.length / 3) {
            this.f4216h--;
            if (i < this.f4216h) {
                System.arraycopy(this.f4214f, i + 1, this.f4214f, i, this.f4216h - i);
                System.arraycopy(this.f4215g, (i + 1) << 1, this.f4215g, i << 1, (this.f4216h - i) << 1);
            }
            this.f4215g[this.f4216h << 1] = null;
            this.f4215g[(this.f4216h << 1) + 1] = null;
        } else {
            if (this.f4216h > 8) {
                i2 = this.f4216h + (this.f4216h >> 1);
            }
            int[] iArr = this.f4214f;
            Object[] objArr = this.f4215g;
            m3540e(i2);
            this.f4216h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f4214f, 0, i);
                System.arraycopy(objArr, 0, this.f4215g, 0, i << 1);
            }
            if (i < this.f4216h) {
                System.arraycopy(iArr, i + 1, this.f4214f, i, this.f4216h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.f4215g, i << 1, (this.f4216h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f4216h) {
            try {
                Object b = mo6976b(i);
                Object c = mo6977c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
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
    }

    public V get(Object obj) {
        int a = obj == null ? mo6971a() : mo6973a(obj, obj.hashCode());
        if (a >= 0) {
            return this.f4215g[(a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f4214f;
        Object[] objArr = this.f4215g;
        int i = this.f4216h;
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
        return this.f4216h <= 0;
    }

    public V put(K k, V v) {
        int hashCode;
        int a;
        int i = 8;
        if (k == null) {
            a = mo6971a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            a = mo6973a((Object) k, hashCode);
        }
        if (a >= 0) {
            int i2 = (a << 1) + 1;
            V v2 = this.f4215g[i2];
            this.f4215g[i2] = v;
            return v2;
        }
        int i3 = a ^ -1;
        if (this.f4216h >= this.f4214f.length) {
            if (this.f4216h >= 8) {
                i = this.f4216h + (this.f4216h >> 1);
            } else if (this.f4216h < 4) {
                i = 4;
            }
            int[] iArr = this.f4214f;
            Object[] objArr = this.f4215g;
            m3540e(i);
            if (this.f4214f.length > 0) {
                System.arraycopy(iArr, 0, this.f4214f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f4215g, 0, objArr.length);
            }
            m3539a(iArr, objArr, this.f4216h);
        }
        if (i3 < this.f4216h) {
            System.arraycopy(this.f4214f, i3, this.f4214f, i3 + 1, this.f4216h - i3);
            System.arraycopy(this.f4215g, i3 << 1, this.f4215g, (i3 + 1) << 1, (this.f4216h - i3) << 1);
        }
        this.f4214f[i3] = hashCode;
        this.f4215g[i3 << 1] = k;
        this.f4215g[(i3 << 1) + 1] = v;
        this.f4216h++;
        return null;
    }

    public V remove(Object obj) {
        int a = obj == null ? mo6971a() : mo6973a(obj, obj.hashCode());
        if (a >= 0) {
            return mo6981d(a);
        }
        return null;
    }

    public int size() {
        return this.f4216h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f4216h * 28);
        sb.append('{');
        for (int i = 0; i < this.f4216h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo6976b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c = mo6977c(i);
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
