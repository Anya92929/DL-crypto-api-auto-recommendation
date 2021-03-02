package android.support.p009v4.p019f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.f.h */
abstract class C0143h {

    /* renamed from: b */
    C0145j f206b;

    /* renamed from: c */
    C0146k f207c;

    /* renamed from: d */
    C0148m f208d;

    C0143h() {
    }

    /* renamed from: a */
    public static boolean m356a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m357a(Set set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m358b(Map map, Collection collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static boolean m359c(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo1041a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo1042a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo1043a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo1044a(int i, Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo1045a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo1046a(Object obj, Object obj2);

    /* renamed from: a */
    public Object[] mo1081a(Object[] objArr, int i) {
        int a = mo1041a();
        Object[] objArr2 = objArr.length < a ? (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a) : objArr;
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = mo1043a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo1047b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map mo1048b();

    /* renamed from: b */
    public Object[] mo1082b(int i) {
        int a = mo1041a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo1043a(i2, i);
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo1049c();

    /* renamed from: d */
    public Set mo1083d() {
        if (this.f206b == null) {
            this.f206b = new C0145j(this);
        }
        return this.f206b;
    }

    /* renamed from: e */
    public Set mo1084e() {
        if (this.f207c == null) {
            this.f207c = new C0146k(this);
        }
        return this.f207c;
    }

    /* renamed from: f */
    public Collection mo1085f() {
        if (this.f208d == null) {
            this.f208d = new C0148m(this);
        }
        return this.f208d;
    }
}
