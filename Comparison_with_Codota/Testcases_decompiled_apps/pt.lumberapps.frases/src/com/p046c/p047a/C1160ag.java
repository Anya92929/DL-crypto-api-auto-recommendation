package com.p046c.p047a;

import android.util.Log;
import com.p046c.p048b.C1199c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.c.a.ag */
public class C1160ag implements Cloneable {

    /* renamed from: i */
    private static final C1163aj f3211i = new C1183m();

    /* renamed from: j */
    private static final C1163aj f3212j = new C1181k();

    /* renamed from: k */
    private static Class[] f3213k = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};

    /* renamed from: l */
    private static Class[] f3214l = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};

    /* renamed from: m */
    private static Class[] f3215m = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};

    /* renamed from: n */
    private static final HashMap f3216n = new HashMap();

    /* renamed from: o */
    private static final HashMap f3217o = new HashMap();

    /* renamed from: a */
    String f3218a;

    /* renamed from: b */
    protected C1199c f3219b;

    /* renamed from: c */
    Method f3220c;

    /* renamed from: d */
    Class f3221d;

    /* renamed from: e */
    C1186p f3222e;

    /* renamed from: f */
    final ReentrantReadWriteLock f3223f;

    /* renamed from: g */
    final Object[] f3224g;

    /* renamed from: h */
    private Method f3225h;

    /* renamed from: p */
    private C1163aj f3226p;

    /* renamed from: q */
    private Object f3227q;

    private C1160ag(C1199c cVar) {
        this.f3220c = null;
        this.f3225h = null;
        this.f3222e = null;
        this.f3223f = new ReentrantReadWriteLock();
        this.f3224g = new Object[1];
        this.f3219b = cVar;
        if (cVar != null) {
            this.f3218a = cVar.mo4605a();
        }
    }

    private C1160ag(String str) {
        this.f3220c = null;
        this.f3225h = null;
        this.f3222e = null;
        this.f3223f = new ReentrantReadWriteLock();
        this.f3224g = new Object[1];
        this.f3218a = str;
    }

    /* renamed from: a */
    public static C1160ag m5286a(C1199c cVar, float... fArr) {
        return new C1162ai(cVar, fArr);
    }

    /* renamed from: a */
    public static C1160ag m5287a(String str, float... fArr) {
        return new C1162ai(str, fArr);
    }

    /* renamed from: a */
    static String m5288a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        return str + upperCase + str2.substring(1);
    }

    /* renamed from: a */
    private Method m5289a(Class cls, String str, Class cls2) {
        Method method;
        Method method2 = null;
        String a = m5288a(str, this.f3218a);
        if (cls2 == null) {
            try {
                return cls.getMethod(a, (Class[]) null);
            } catch (NoSuchMethodException e) {
                try {
                    method = cls.getDeclaredMethod(a, (Class[]) null);
                    try {
                        method.setAccessible(true);
                        return method;
                    } catch (NoSuchMethodException e2) {
                    }
                } catch (NoSuchMethodException e3) {
                    method = null;
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f3218a + ": " + e);
                    return method;
                }
            }
        } else {
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = this.f3221d.equals(Float.class) ? f3213k : this.f3221d.equals(Integer.class) ? f3214l : this.f3221d.equals(Double.class) ? f3215m : new Class[]{this.f3221d};
            int length = clsArr2.length;
            int i = 0;
            while (i < length) {
                Class cls3 = clsArr2[i];
                clsArr[0] = cls3;
                try {
                    method2 = cls.getMethod(a, clsArr);
                    this.f3221d = cls3;
                    return method2;
                } catch (NoSuchMethodException e4) {
                    try {
                        method2 = cls.getDeclaredMethod(a, clsArr);
                        method2.setAccessible(true);
                        this.f3221d = cls3;
                        return method2;
                    } catch (NoSuchMethodException e5) {
                        i++;
                    }
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f3218a + " with value type " + this.f3221d);
            return method2;
        }
    }

    /* renamed from: a */
    private Method m5290a(Class cls, HashMap hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f3223f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f3218a);
            }
            if (method == null) {
                method = m5289a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f3218a, method);
            }
            Method method2 = method;
            return method2;
        } finally {
            this.f3223f.writeLock().unlock();
        }
    }

    /* renamed from: b */
    private void m5291b(Class cls) {
        this.f3225h = m5290a(cls, f3217o, "get", (Class) null);
    }

    /* renamed from: a */
    public C1160ag clone() {
        try {
            C1160ag agVar = (C1160ag) super.clone();
            agVar.f3218a = this.f3218a;
            agVar.f3219b = this.f3219b;
            agVar.f3222e = this.f3222e.clone();
            agVar.f3226p = this.f3226p;
            return agVar;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4516a(float f) {
        this.f3227q = this.f3222e.mo4567a(f);
    }

    /* renamed from: a */
    public void mo4517a(C1199c cVar) {
        this.f3219b = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4518a(Class cls) {
        this.f3220c = m5290a(cls, f3216n, "set", this.f3221d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4519a(Object obj) {
        if (this.f3219b != null) {
            try {
                this.f3219b.mo4502a(obj);
                Iterator it = this.f3222e.f3302e.iterator();
                while (it.hasNext()) {
                    C1184n nVar = (C1184n) it.next();
                    if (!nVar.mo4574a()) {
                        nVar.mo4573a(this.f3219b.mo4502a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f3219b.mo4605a() + ") on target object " + obj + ". Trying reflection instead");
                this.f3219b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f3220c == null) {
            mo4518a((Class) cls);
        }
        Iterator it2 = this.f3222e.f3302e.iterator();
        while (it2.hasNext()) {
            C1184n nVar2 = (C1184n) it2.next();
            if (!nVar2.mo4574a()) {
                if (this.f3225h == null) {
                    m5291b((Class) cls);
                }
                try {
                    nVar2.mo4573a(this.f3225h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4520a(String str) {
        this.f3218a = str;
    }

    /* renamed from: a */
    public void mo4521a(float... fArr) {
        this.f3221d = Float.TYPE;
        this.f3222e = C1186p.m5411a(fArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4522b() {
        if (this.f3226p == null) {
            this.f3226p = this.f3221d == Integer.class ? f3211i : this.f3221d == Float.class ? f3212j : null;
        }
        if (this.f3226p != null) {
            this.f3222e.mo4582a(this.f3226p);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4523b(Object obj) {
        if (this.f3219b != null) {
            this.f3219b.mo4603a(obj, mo4526d());
        }
        if (this.f3220c != null) {
            try {
                this.f3224g[0] = mo4526d();
                this.f3220c.invoke(obj, this.f3224g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    /* renamed from: c */
    public String mo4524c() {
        return this.f3218a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Object mo4526d() {
        return this.f3227q;
    }

    public String toString() {
        return this.f3218a + ": " + this.f3222e.toString();
    }
}
