package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: g */
    static final /* synthetic */ boolean f3694g = (!LinkedHashTreeMap.class.desiredAssertionStatus());

    /* renamed from: h */
    private static final Comparator<Comparable> f3695h = new Comparator<Comparable>() {
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a */
    Comparator<? super K> f3696a;

    /* renamed from: b */
    C0932f<K, V>[] f3697b;

    /* renamed from: c */
    final C0932f<K, V> f3698c;

    /* renamed from: d */
    int f3699d;

    /* renamed from: e */
    int f3700e;

    /* renamed from: f */
    int f3701f;

    /* renamed from: i */
    private LinkedHashTreeMap<K, V>.C0650c f3702i;

    /* renamed from: j */
    private LinkedHashTreeMap<K, V>.C1035d f3703j;

    public LinkedHashTreeMap() {
        this(f3695h);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.f3699d = 0;
        this.f3700e = 0;
        this.f3696a = comparator == null ? f3695h : comparator;
        this.f3698c = new C0932f<>();
        this.f3697b = new C0932f[16];
        this.f3701f = (this.f3697b.length / 2) + (this.f3697b.length / 4);
    }

    public int size() {
        return this.f3699d;
    }

    public V get(Object obj) {
        C0932f a = mo7514a(obj);
        if (a != null) {
            return a.f3724h;
        }
        return null;
    }

    public boolean containsKey(Object obj) {
        return mo7514a(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0932f a = mo7515a(k, true);
        V v2 = a.f3724h;
        a.f3724h = v;
        return v2;
    }

    public void clear() {
        Arrays.fill(this.f3697b, (Object) null);
        this.f3699d = 0;
        this.f3700e++;
        C0932f<K, V> fVar = this.f3698c;
        C0932f<K, V> fVar2 = fVar.f3720d;
        while (fVar2 != fVar) {
            C0932f<K, V> fVar3 = fVar2.f3720d;
            fVar2.f3721e = null;
            fVar2.f3720d = null;
            fVar2 = fVar3;
        }
        fVar.f3721e = fVar;
        fVar.f3720d = fVar;
    }

    public V remove(Object obj) {
        C0932f b = mo7518b(obj);
        if (b != null) {
            return b.f3724h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0932f<K, V> mo7515a(K k, boolean z) {
        int i;
        C0932f<K, V> fVar;
        int compare;
        Comparator<? super K> comparator = this.f3696a;
        C0932f<K, V>[] fVarArr = this.f3697b;
        int a = m4295a(k.hashCode());
        int length = a & (fVarArr.length - 1);
        C0932f<K, V> fVar2 = fVarArr[length];
        if (fVar2 != null) {
            Comparable comparable = comparator == f3695h ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(fVar2.f3722f);
                } else {
                    compare = comparator.compare(k, fVar2.f3722f);
                }
                if (compare == 0) {
                    return fVar2;
                }
                C0932f<K, V> fVar3 = compare < 0 ? fVar2.f3718b : fVar2.f3719c;
                if (fVar3 == null) {
                    i = compare;
                    break;
                }
                fVar2 = fVar3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        C0932f<K, V> fVar4 = this.f3698c;
        if (fVar2 != null) {
            fVar = new C0932f<>(fVar2, k, a, fVar4, fVar4.f3721e);
            if (i < 0) {
                fVar2.f3718b = fVar;
            } else {
                fVar2.f3719c = fVar;
            }
            m4302b(fVar2, true);
        } else if (comparator != f3695h || (k instanceof Comparable)) {
            fVar = new C0932f<>(fVar2, k, a, fVar4, fVar4.f3721e);
            fVarArr[length] = fVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i2 = this.f3699d;
        this.f3699d = i2 + 1;
        if (i2 > this.f3701f) {
            m4296a();
        }
        this.f3700e++;
        return fVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0932f<K, V> mo7514a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return mo7515a(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0932f<K, V> mo7516a(Map.Entry<?, ?> entry) {
        C0932f<K, V> a = mo7514a((Object) entry.getKey());
        if (a != null && m4299a((Object) a.f3724h, (Object) entry.getValue())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m4299a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    private static int m4295a(int i) {
        int i2 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7517a(C0932f<K, V> fVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            fVar.f3721e.f3720d = fVar.f3720d;
            fVar.f3720d.f3721e = fVar.f3721e;
            fVar.f3721e = null;
            fVar.f3720d = null;
        }
        C0932f<K, V> fVar2 = fVar.f3718b;
        C0932f<K, V> fVar3 = fVar.f3719c;
        C0932f<K, V> fVar4 = fVar.f3717a;
        if (fVar2 == null || fVar3 == null) {
            if (fVar2 != null) {
                m4298a(fVar, fVar2);
                fVar.f3718b = null;
            } else if (fVar3 != null) {
                m4298a(fVar, fVar3);
                fVar.f3719c = null;
            } else {
                m4298a(fVar, (C0932f<K, V>) null);
            }
            m4302b(fVar4, false);
            this.f3699d--;
            this.f3700e++;
            return;
        }
        C0932f<K, V> b = fVar2.f3725i > fVar3.f3725i ? fVar2.mo7551b() : fVar3.mo7550a();
        mo7517a(b, false);
        C0932f<K, V> fVar5 = fVar.f3718b;
        if (fVar5 != null) {
            i = fVar5.f3725i;
            b.f3718b = fVar5;
            fVar5.f3717a = b;
            fVar.f3718b = null;
        } else {
            i = 0;
        }
        C0932f<K, V> fVar6 = fVar.f3719c;
        if (fVar6 != null) {
            i2 = fVar6.f3725i;
            b.f3719c = fVar6;
            fVar6.f3717a = b;
            fVar.f3719c = null;
        }
        b.f3725i = Math.max(i, i2) + 1;
        m4298a(fVar, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0932f<K, V> mo7518b(Object obj) {
        C0932f<K, V> a = mo7514a(obj);
        if (a != null) {
            mo7517a(a, true);
        }
        return a;
    }

    /* renamed from: a */
    private void m4298a(C0932f<K, V> fVar, C0932f<K, V> fVar2) {
        C0932f<K, V> fVar3 = fVar.f3717a;
        fVar.f3717a = null;
        if (fVar2 != null) {
            fVar2.f3717a = fVar3;
        }
        if (fVar3 == null) {
            this.f3697b[fVar.f3723g & (this.f3697b.length - 1)] = fVar2;
        } else if (fVar3.f3718b == fVar) {
            fVar3.f3718b = fVar2;
        } else if (f3694g || fVar3.f3719c == fVar) {
            fVar3.f3719c = fVar2;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private void m4302b(C0932f<K, V> fVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (fVar != null) {
            C0932f<K, V> fVar2 = fVar.f3718b;
            C0932f<K, V> fVar3 = fVar.f3719c;
            int i5 = fVar2 != null ? fVar2.f3725i : 0;
            if (fVar3 != null) {
                i = fVar3.f3725i;
            } else {
                i = 0;
            }
            int i6 = i5 - i;
            if (i6 == -2) {
                C0932f<K, V> fVar4 = fVar3.f3718b;
                C0932f<K, V> fVar5 = fVar3.f3719c;
                if (fVar5 != null) {
                    i3 = fVar5.f3725i;
                } else {
                    i3 = 0;
                }
                if (fVar4 != null) {
                    i4 = fVar4.f3725i;
                } else {
                    i4 = 0;
                }
                int i7 = i4 - i3;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    m4297a(fVar);
                } else if (f3694g || i7 == 1) {
                    m4301b(fVar3);
                    m4297a(fVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                C0932f<K, V> fVar6 = fVar2.f3718b;
                C0932f<K, V> fVar7 = fVar2.f3719c;
                int i8 = fVar7 != null ? fVar7.f3725i : 0;
                if (fVar6 != null) {
                    i2 = fVar6.f3725i;
                } else {
                    i2 = 0;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    m4301b(fVar);
                } else if (f3694g || i9 == -1) {
                    m4297a(fVar2);
                    m4301b(fVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                fVar.f3725i = i5 + 1;
                if (z) {
                    return;
                }
            } else if (f3694g || i6 == -1 || i6 == 1) {
                fVar.f3725i = Math.max(i5, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            fVar = fVar.f3717a;
        }
    }

    /* renamed from: a */
    private void m4297a(C0932f<K, V> fVar) {
        int i;
        int i2 = 0;
        C0932f<K, V> fVar2 = fVar.f3718b;
        C0932f<K, V> fVar3 = fVar.f3719c;
        C0932f<K, V> fVar4 = fVar3.f3718b;
        C0932f<K, V> fVar5 = fVar3.f3719c;
        fVar.f3719c = fVar4;
        if (fVar4 != null) {
            fVar4.f3717a = fVar;
        }
        m4298a(fVar, fVar3);
        fVar3.f3718b = fVar;
        fVar.f3717a = fVar3;
        if (fVar2 != null) {
            i = fVar2.f3725i;
        } else {
            i = 0;
        }
        fVar.f3725i = Math.max(i, fVar4 != null ? fVar4.f3725i : 0) + 1;
        int i3 = fVar.f3725i;
        if (fVar5 != null) {
            i2 = fVar5.f3725i;
        }
        fVar3.f3725i = Math.max(i3, i2) + 1;
    }

    /* renamed from: b */
    private void m4301b(C0932f<K, V> fVar) {
        int i;
        int i2 = 0;
        C0932f<K, V> fVar2 = fVar.f3718b;
        C0932f<K, V> fVar3 = fVar.f3719c;
        C0932f<K, V> fVar4 = fVar2.f3718b;
        C0932f<K, V> fVar5 = fVar2.f3719c;
        fVar.f3718b = fVar5;
        if (fVar5 != null) {
            fVar5.f3717a = fVar;
        }
        m4298a(fVar, fVar2);
        fVar2.f3719c = fVar;
        fVar.f3717a = fVar2;
        if (fVar3 != null) {
            i = fVar3.f3725i;
        } else {
            i = 0;
        }
        fVar.f3725i = Math.max(i, fVar5 != null ? fVar5.f3725i : 0) + 1;
        int i3 = fVar.f3725i;
        if (fVar4 != null) {
            i2 = fVar4.f3725i;
        }
        fVar2.f3725i = Math.max(i3, i2) + 1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.C0650c cVar = this.f3702i;
        if (cVar != null) {
            return cVar;
        }
        LinkedHashTreeMap<K, V>.C0650c cVar2 = new C0927c();
        this.f3702i = cVar2;
        return cVar2;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.C1035d dVar = this.f3703j;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.C1035d dVar2 = new C0929d();
        this.f3703j = dVar2;
        return dVar2;
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$f */
    static final class C0932f<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        C0932f<K, V> f3717a;

        /* renamed from: b */
        C0932f<K, V> f3718b;

        /* renamed from: c */
        C0932f<K, V> f3719c;

        /* renamed from: d */
        C0932f<K, V> f3720d;

        /* renamed from: e */
        C0932f<K, V> f3721e;

        /* renamed from: f */
        final K f3722f;

        /* renamed from: g */
        final int f3723g;

        /* renamed from: h */
        V f3724h;

        /* renamed from: i */
        int f3725i;

        C0932f() {
            this.f3722f = null;
            this.f3723g = -1;
            this.f3721e = this;
            this.f3720d = this;
        }

        C0932f(C0932f<K, V> fVar, K k, int i, C0932f<K, V> fVar2, C0932f<K, V> fVar3) {
            this.f3717a = fVar;
            this.f3722f = k;
            this.f3723g = i;
            this.f3725i = 1;
            this.f3720d = fVar2;
            this.f3721e = fVar3;
            fVar3.f3720d = this;
            fVar2.f3721e = this;
        }

        public K getKey() {
            return this.f3722f;
        }

        public V getValue() {
            return this.f3724h;
        }

        public V setValue(V v) {
            V v2 = this.f3724h;
            this.f3724h = v;
            return v2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = 0
                boolean r1 = r4 instanceof java.util.Map.Entry
                if (r1 == 0) goto L_0x001c
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r1 = r3.f3722f
                if (r1 != 0) goto L_0x001d
                java.lang.Object r1 = r4.getKey()
                if (r1 != 0) goto L_0x001c
            L_0x0011:
                V r1 = r3.f3724h
                if (r1 != 0) goto L_0x002a
                java.lang.Object r1 = r4.getValue()
                if (r1 != 0) goto L_0x001c
            L_0x001b:
                r0 = 1
            L_0x001c:
                return r0
            L_0x001d:
                K r1 = r3.f3722f
                java.lang.Object r2 = r4.getKey()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x0011
            L_0x002a:
                V r1 = r3.f3724h
                java.lang.Object r2 = r4.getValue()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x001b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedHashTreeMap.C0932f.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f3722f == null ? 0 : this.f3722f.hashCode();
            if (this.f3724h != null) {
                i = this.f3724h.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f3722f + "=" + this.f3724h;
        }

        /* renamed from: a */
        public C0932f<K, V> mo7550a() {
            for (C0932f<K, V> fVar = this.f3718b; fVar != null; fVar = fVar.f3718b) {
                this = fVar;
            }
            return this;
        }

        /* renamed from: b */
        public C0932f<K, V> mo7551b() {
            for (C0932f<K, V> fVar = this.f3719c; fVar != null; fVar = fVar.f3719c) {
                this = fVar;
            }
            return this;
        }
    }

    /* renamed from: a */
    private void m4296a() {
        this.f3697b = m4300a(this.f3697b);
        this.f3701f = (this.f3697b.length / 2) + (this.f3697b.length / 4);
    }

    /* renamed from: a */
    static <K, V> C0932f<K, V>[] m4300a(C0932f<K, V>[] fVarArr) {
        C0932f<K, V> fVar;
        C0932f<K, V> fVar2;
        int length = fVarArr.length;
        C0932f<K, V>[] fVarArr2 = new C0932f[(length * 2)];
        C0926b bVar = new C0926b();
        C0925a aVar = new C0925a();
        C0925a aVar2 = new C0925a();
        for (int i = 0; i < length; i++) {
            C0932f<K, V> fVar3 = fVarArr[i];
            if (fVar3 != null) {
                bVar.mo7533a(fVar3);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    C0932f a = bVar.mo7532a();
                    if (a == null) {
                        break;
                    } else if ((a.f3723g & length) == 0) {
                        i3++;
                    } else {
                        i2++;
                    }
                }
                aVar.mo7530a(i3);
                aVar2.mo7530a(i2);
                bVar.mo7533a(fVar3);
                while (true) {
                    C0932f a2 = bVar.mo7532a();
                    if (a2 == null) {
                        break;
                    } else if ((a2.f3723g & length) == 0) {
                        aVar.mo7531a(a2);
                    } else {
                        aVar2.mo7531a(a2);
                    }
                }
                if (i3 > 0) {
                    fVar = aVar.mo7529a();
                } else {
                    fVar = null;
                }
                fVarArr2[i] = fVar;
                int i4 = i + length;
                if (i2 > 0) {
                    fVar2 = aVar2.mo7529a();
                } else {
                    fVar2 = null;
                }
                fVarArr2[i4] = fVar2;
            }
        }
        return fVarArr2;
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$b */
    static class C0926b<K, V> {

        /* renamed from: a */
        private C0932f<K, V> f3708a;

        C0926b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7533a(C0932f<K, V> fVar) {
            C0932f<K, V> fVar2 = null;
            while (fVar != null) {
                fVar.f3717a = fVar2;
                fVar2 = fVar;
                fVar = fVar.f3718b;
            }
            this.f3708a = fVar2;
        }

        /* renamed from: a */
        public C0932f<K, V> mo7532a() {
            C0932f<K, V> fVar = this.f3708a;
            if (fVar == null) {
                return null;
            }
            C0932f<K, V> fVar2 = fVar.f3717a;
            fVar.f3717a = null;
            for (C0932f<K, V> fVar3 = fVar.f3719c; fVar3 != null; fVar3 = fVar3.f3718b) {
                fVar3.f3717a = fVar2;
                fVar2 = fVar3;
            }
            this.f3708a = fVar2;
            return fVar;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$a */
    static final class C0925a<K, V> {

        /* renamed from: a */
        private C0932f<K, V> f3704a;

        /* renamed from: b */
        private int f3705b;

        /* renamed from: c */
        private int f3706c;

        /* renamed from: d */
        private int f3707d;

        C0925a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7530a(int i) {
            this.f3705b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f3707d = 0;
            this.f3706c = 0;
            this.f3704a = null;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo7531a(C0932f<K, V> fVar) {
            fVar.f3719c = null;
            fVar.f3717a = null;
            fVar.f3718b = null;
            fVar.f3725i = 1;
            if (this.f3705b > 0 && (this.f3707d & 1) == 0) {
                this.f3707d++;
                this.f3705b--;
                this.f3706c++;
            }
            fVar.f3717a = this.f3704a;
            this.f3704a = fVar;
            this.f3707d++;
            if (this.f3705b > 0 && (this.f3707d & 1) == 0) {
                this.f3707d++;
                this.f3705b--;
                this.f3706c++;
            }
            for (int i = 4; (this.f3707d & (i - 1)) == i - 1; i *= 2) {
                if (this.f3706c == 0) {
                    C0932f<K, V> fVar2 = this.f3704a;
                    C0932f<K, V> fVar3 = fVar2.f3717a;
                    C0932f<K, V> fVar4 = fVar3.f3717a;
                    fVar3.f3717a = fVar4.f3717a;
                    this.f3704a = fVar3;
                    fVar3.f3718b = fVar4;
                    fVar3.f3719c = fVar2;
                    fVar3.f3725i = fVar2.f3725i + 1;
                    fVar4.f3717a = fVar3;
                    fVar2.f3717a = fVar3;
                } else if (this.f3706c == 1) {
                    C0932f<K, V> fVar5 = this.f3704a;
                    C0932f<K, V> fVar6 = fVar5.f3717a;
                    this.f3704a = fVar6;
                    fVar6.f3719c = fVar5;
                    fVar6.f3725i = fVar5.f3725i + 1;
                    fVar5.f3717a = fVar6;
                    this.f3706c = 0;
                } else if (this.f3706c == 2) {
                    this.f3706c = 0;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0932f<K, V> mo7529a() {
            C0932f<K, V> fVar = this.f3704a;
            if (fVar.f3717a == null) {
                return fVar;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$e */
    abstract class C0931e<T> implements Iterator<T> {

        /* renamed from: b */
        C0932f<K, V> f3713b;

        /* renamed from: c */
        C0932f<K, V> f3714c;

        /* renamed from: d */
        int f3715d;

        private C0931e() {
            this.f3713b = LinkedHashTreeMap.this.f3698c.f3720d;
            this.f3714c = null;
            this.f3715d = LinkedHashTreeMap.this.f3700e;
        }

        public final boolean hasNext() {
            return this.f3713b != LinkedHashTreeMap.this.f3698c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final C0932f<K, V> mo7547b() {
            C0932f<K, V> fVar = this.f3713b;
            if (fVar == LinkedHashTreeMap.this.f3698c) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.f3700e != this.f3715d) {
                throw new ConcurrentModificationException();
            } else {
                this.f3713b = fVar.f3720d;
                this.f3714c = fVar;
                return fVar;
            }
        }

        public final void remove() {
            if (this.f3714c == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.mo7517a(this.f3714c, true);
            this.f3714c = null;
            this.f3715d = LinkedHashTreeMap.this.f3700e;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$c */
    final class C0927c extends AbstractSet<Map.Entry<K, V>> {
        C0927c() {
        }

        public int size() {
            return LinkedHashTreeMap.this.f3699d;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedHashTreeMap<K, V>.C1066e<Map.Entry<K, V>>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return mo7547b();
                }
            };
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.mo7516a((Map.Entry<?, ?>) (Map.Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            C0932f a;
            if (!(obj instanceof Map.Entry) || (a = LinkedHashTreeMap.this.mo7516a((Map.Entry<?, ?>) (Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.mo7517a(a, true);
            return true;
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedHashTreeMap$d */
    final class C0929d extends AbstractSet<K> {
        C0929d() {
        }

        public int size() {
            return LinkedHashTreeMap.this.f3699d;
        }

        public Iterator<K> iterator() {
            return new LinkedHashTreeMap<K, V>.C1066e<K>() {
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                public K next() {
                    return mo7547b().f3722f;
                }
            };
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.mo7518b(obj) != null;
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
