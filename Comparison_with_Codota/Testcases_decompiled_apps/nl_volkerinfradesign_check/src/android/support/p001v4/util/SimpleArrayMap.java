package android.support.p001v4.util;

import java.util.Map;

/* renamed from: android.support.v4.util.SimpleArrayMap */
public class SimpleArrayMap<K, V> {

    /* renamed from: b */
    static Object[] f875b;

    /* renamed from: c */
    static int f876c;

    /* renamed from: d */
    static Object[] f877d;

    /* renamed from: e */
    static int f878e;

    /* renamed from: f */
    int[] f879f;

    /* renamed from: g */
    Object[] f880g;

    /* renamed from: h */
    int f881h;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo1644a(Object obj, int i) {
        int i2 = this.f881h;
        if (i2 == 0) {
            return -1;
        }
        int a = C1018cq.m4569a(this.f879f, i2, i);
        if (a < 0 || obj.equals(this.f880g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f879f[i3] == i) {
            if (obj.equals(this.f880g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f879f[i4] == i) {
            if (obj.equals(this.f880g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo1642a() {
        int i = this.f881h;
        if (i == 0) {
            return -1;
        }
        int a = C1018cq.m4569a(this.f879f, i, 0);
        if (a < 0 || this.f880g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f879f[i2] == 0) {
            if (this.f880g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f879f[i3] == 0) {
            if (this.f880g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* renamed from: a */
    private void m990a(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f877d != null) {
                    Object[] objArr = f877d;
                    this.f880g = objArr;
                    f877d = (Object[]) objArr[0];
                    this.f879f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f878e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f875b != null) {
                    Object[] objArr2 = f875b;
                    this.f880g = objArr2;
                    f875b = (Object[]) objArr2[0];
                    this.f879f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f876c--;
                    return;
                }
            }
        }
        this.f879f = new int[i];
        this.f880g = new Object[(i << 1)];
    }

    /* renamed from: a */
    private static void m991a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f878e < 10) {
                    objArr[0] = f877d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f877d = objArr;
                    f878e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f876c < 10) {
                    objArr[0] = f875b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f875b = objArr;
                    f876c++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.f879f = C1018cq.f4033a;
        this.f880g = C1018cq.f4035c;
        this.f881h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f879f = C1018cq.f4033a;
            this.f880g = C1018cq.f4035c;
        } else {
            m990a(i);
        }
        this.f881h = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    public void clear() {
        if (this.f881h != 0) {
            m991a(this.f879f, this.f880g, this.f881h);
            this.f879f = C1018cq.f4033a;
            this.f880g = C1018cq.f4035c;
            this.f881h = 0;
        }
    }

    public void ensureCapacity(int i) {
        if (this.f879f.length < i) {
            int[] iArr = this.f879f;
            Object[] objArr = this.f880g;
            m990a(i);
            if (this.f881h > 0) {
                System.arraycopy(iArr, 0, this.f879f, 0, this.f881h);
                System.arraycopy(objArr, 0, this.f880g, 0, this.f881h << 1);
            }
            m991a(iArr, objArr, this.f881h);
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? mo1642a() : mo1644a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo1643a(Object obj) {
        int i = 1;
        int i2 = this.f881h * 2;
        Object[] objArr = this.f880g;
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

    public boolean containsValue(Object obj) {
        return mo1643a(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.f880g[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public K keyAt(int i) {
        return this.f880g[i << 1];
    }

    public V valueAt(int i) {
        return this.f880g[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f880g[i2];
        this.f880g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f881h <= 0;
    }

    public V put(K k, V v) {
        int hashCode;
        int a;
        int i = 8;
        if (k == null) {
            a = mo1642a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            a = mo1644a(k, hashCode);
        }
        if (a >= 0) {
            int i2 = (a << 1) + 1;
            V v2 = this.f880g[i2];
            this.f880g[i2] = v;
            return v2;
        }
        int i3 = a ^ -1;
        if (this.f881h >= this.f879f.length) {
            if (this.f881h >= 8) {
                i = this.f881h + (this.f881h >> 1);
            } else if (this.f881h < 4) {
                i = 4;
            }
            int[] iArr = this.f879f;
            Object[] objArr = this.f880g;
            m990a(i);
            if (this.f879f.length > 0) {
                System.arraycopy(iArr, 0, this.f879f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f880g, 0, objArr.length);
            }
            m991a(iArr, objArr, this.f881h);
        }
        if (i3 < this.f881h) {
            System.arraycopy(this.f879f, i3, this.f879f, i3 + 1, this.f881h - i3);
            System.arraycopy(this.f880g, i3 << 1, this.f880g, (i3 + 1) << 1, (this.f881h - i3) << 1);
        }
        this.f879f[i3] = hashCode;
        this.f880g[i3 << 1] = k;
        this.f880g[(i3 << 1) + 1] = v;
        this.f881h++;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f881h;
        ensureCapacity(this.f881h + i);
        if (this.f881h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f879f, 0, this.f879f, 0, i);
            System.arraycopy(simpleArrayMap.f880g, 0, this.f880g, 0, i << 1);
            this.f881h = i;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2 = 8;
        V v = this.f880g[(i << 1) + 1];
        if (this.f881h <= 1) {
            m991a(this.f879f, this.f880g, this.f881h);
            this.f879f = C1018cq.f4033a;
            this.f880g = C1018cq.f4035c;
            this.f881h = 0;
        } else if (this.f879f.length <= 8 || this.f881h >= this.f879f.length / 3) {
            this.f881h--;
            if (i < this.f881h) {
                System.arraycopy(this.f879f, i + 1, this.f879f, i, this.f881h - i);
                System.arraycopy(this.f880g, (i + 1) << 1, this.f880g, i << 1, (this.f881h - i) << 1);
            }
            this.f880g[this.f881h << 1] = null;
            this.f880g[(this.f881h << 1) + 1] = null;
        } else {
            if (this.f881h > 8) {
                i2 = this.f881h + (this.f881h >> 1);
            }
            int[] iArr = this.f879f;
            Object[] objArr = this.f880g;
            m990a(i2);
            this.f881h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f879f, 0, i);
                System.arraycopy(objArr, 0, this.f880g, 0, i << 1);
            }
            if (i < this.f881h) {
                System.arraycopy(iArr, i + 1, this.f879f, i, this.f881h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.f880g, i << 1, (this.f881h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f881h;
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
        while (i < this.f881h) {
            try {
                Object keyAt = keyAt(i);
                Object valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
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

    public int hashCode() {
        int[] iArr = this.f879f;
        Object[] objArr = this.f880g;
        int i = this.f881h;
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

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f881h * 28);
        sb.append('{');
        for (int i = 0; i < this.f881h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
