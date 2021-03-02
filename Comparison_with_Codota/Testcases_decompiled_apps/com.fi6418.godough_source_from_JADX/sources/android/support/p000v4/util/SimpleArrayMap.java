package android.support.p000v4.util;

import java.util.Map;

/* renamed from: android.support.v4.util.SimpleArrayMap */
public class SimpleArrayMap<K, V> {

    /* renamed from: b */
    static Object[] f1130b;

    /* renamed from: c */
    static int f1131c;

    /* renamed from: d */
    static Object[] f1132d;

    /* renamed from: e */
    static int f1133e;

    /* renamed from: f */
    int[] f1134f;

    /* renamed from: g */
    Object[] f1135g;

    /* renamed from: h */
    int f1136h;

    public SimpleArrayMap() {
        this.f1134f = ContainerHelpers.f1094a;
        this.f1135g = ContainerHelpers.f1096c;
        this.f1136h = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f1134f = ContainerHelpers.f1094a;
            this.f1135g = ContainerHelpers.f1096c;
        } else {
            m837a(i);
        }
        this.f1136h = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    /* renamed from: a */
    private void m837a(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f1132d != null) {
                    Object[] objArr = f1132d;
                    this.f1135g = objArr;
                    f1132d = (Object[]) objArr[0];
                    this.f1134f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1133e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f1130b != null) {
                    Object[] objArr2 = f1130b;
                    this.f1135g = objArr2;
                    f1130b = (Object[]) objArr2[0];
                    this.f1134f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1131c--;
                    return;
                }
            }
        }
        this.f1134f = new int[i];
        this.f1135g = new Object[(i << 1)];
    }

    /* renamed from: a */
    private static void m838a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f1133e < 10) {
                    objArr[0] = f1132d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1132d = objArr;
                    f1133e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f1131c < 10) {
                    objArr[0] = f1130b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1130b = objArr;
                    f1131c++;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2059a() {
        int i = this.f1136h;
        if (i == 0) {
            return -1;
        }
        int a = ContainerHelpers.m818a(this.f1134f, i, 0);
        if (a < 0 || this.f1135g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1134f[i2] == 0) {
            if (this.f1135g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f1134f[i3] == 0) {
            if (this.f1135g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2060a(Object obj) {
        int i = 1;
        int i2 = this.f1136h * 2;
        Object[] objArr = this.f1135g;
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
    public int mo2061a(Object obj, int i) {
        int i2 = this.f1136h;
        if (i2 == 0) {
            return -1;
        }
        int a = ContainerHelpers.m818a(this.f1134f, i2, i);
        if (a < 0 || obj.equals(this.f1135g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1134f[i3] == i) {
            if (obj.equals(this.f1135g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f1134f[i4] == i) {
            if (obj.equals(this.f1135g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    public void clear() {
        if (this.f1136h != 0) {
            m838a(this.f1134f, this.f1135g, this.f1136h);
            this.f1134f = ContainerHelpers.f1094a;
            this.f1135g = ContainerHelpers.f1096c;
            this.f1136h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo2060a(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        if (this.f1134f.length < i) {
            int[] iArr = this.f1134f;
            Object[] objArr = this.f1135g;
            m837a(i);
            if (this.f1136h > 0) {
                System.arraycopy(iArr, 0, this.f1134f, 0, this.f1136h);
                System.arraycopy(objArr, 0, this.f1135g, 0, this.f1136h << 1);
            }
            m838a(iArr, objArr, this.f1136h);
        }
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
        while (i < this.f1136h) {
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

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return this.f1135g[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f1134f;
        Object[] objArr = this.f1135g;
        int i = this.f1136h;
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

    public int indexOfKey(Object obj) {
        return obj == null ? mo2059a() : mo2061a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1136h <= 0;
    }

    public K keyAt(int i) {
        return this.f1135g[i << 1];
    }

    public V put(K k, V v) {
        int hashCode;
        int a;
        int i = 8;
        if (k == null) {
            a = mo2059a();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            a = mo2061a(k, hashCode);
        }
        if (a >= 0) {
            int i2 = (a << 1) + 1;
            V v2 = this.f1135g[i2];
            this.f1135g[i2] = v;
            return v2;
        }
        int i3 = a ^ -1;
        if (this.f1136h >= this.f1134f.length) {
            if (this.f1136h >= 8) {
                i = this.f1136h + (this.f1136h >> 1);
            } else if (this.f1136h < 4) {
                i = 4;
            }
            int[] iArr = this.f1134f;
            Object[] objArr = this.f1135g;
            m837a(i);
            if (this.f1134f.length > 0) {
                System.arraycopy(iArr, 0, this.f1134f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1135g, 0, objArr.length);
            }
            m838a(iArr, objArr, this.f1136h);
        }
        if (i3 < this.f1136h) {
            System.arraycopy(this.f1134f, i3, this.f1134f, i3 + 1, this.f1136h - i3);
            System.arraycopy(this.f1135g, i3 << 1, this.f1135g, (i3 + 1) << 1, (this.f1136h - i3) << 1);
        }
        this.f1134f[i3] = hashCode;
        this.f1135g[i3 << 1] = k;
        this.f1135g[(i3 << 1) + 1] = v;
        this.f1136h++;
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f1136h;
        ensureCapacity(this.f1136h + i);
        if (this.f1136h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f1134f, 0, this.f1134f, 0, i);
            System.arraycopy(simpleArrayMap.f1135g, 0, this.f1135g, 0, i << 1);
            this.f1136h = i;
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
        V v = this.f1135g[(i << 1) + 1];
        if (this.f1136h <= 1) {
            m838a(this.f1134f, this.f1135g, this.f1136h);
            this.f1134f = ContainerHelpers.f1094a;
            this.f1135g = ContainerHelpers.f1096c;
            this.f1136h = 0;
        } else if (this.f1134f.length <= 8 || this.f1136h >= this.f1134f.length / 3) {
            this.f1136h--;
            if (i < this.f1136h) {
                System.arraycopy(this.f1134f, i + 1, this.f1134f, i, this.f1136h - i);
                System.arraycopy(this.f1135g, (i + 1) << 1, this.f1135g, i << 1, (this.f1136h - i) << 1);
            }
            this.f1135g[this.f1136h << 1] = null;
            this.f1135g[(this.f1136h << 1) + 1] = null;
        } else {
            if (this.f1136h > 8) {
                i2 = this.f1136h + (this.f1136h >> 1);
            }
            int[] iArr = this.f1134f;
            Object[] objArr = this.f1135g;
            m837a(i2);
            this.f1136h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f1134f, 0, i);
                System.arraycopy(objArr, 0, this.f1135g, 0, i << 1);
            }
            if (i < this.f1136h) {
                System.arraycopy(iArr, i + 1, this.f1134f, i, this.f1136h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.f1135g, i << 1, (this.f1136h - i) << 1);
            }
        }
        return v;
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f1135g[i2];
        this.f1135g[i2] = v;
        return v2;
    }

    public int size() {
        return this.f1136h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1136h * 28);
        sb.append('{');
        for (int i = 0; i < this.f1136h; i++) {
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

    public V valueAt(int i) {
        return this.f1135g[(i << 1) + 1];
    }
}
