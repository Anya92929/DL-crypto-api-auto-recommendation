package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f */
    static final /* synthetic */ boolean f3726f = (!LinkedTreeMap.class.desiredAssertionStatus());

    /* renamed from: g */
    private static final Comparator<Comparable> f3727g = new Comparator<Comparable>() {
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a */
    Comparator<? super K> f3728a;

    /* renamed from: b */
    C0939d<K, V> f3729b;

    /* renamed from: c */
    int f3730c;

    /* renamed from: d */
    int f3731d;

    /* renamed from: e */
    final C0939d<K, V> f3732e;

    /* renamed from: h */
    private LinkedTreeMap<K, V>.C0000a f3733h;

    /* renamed from: i */
    private LinkedTreeMap<K, V>.C0608b f3734i;

    public LinkedTreeMap() {
        this(f3727g);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.f3730c = 0;
        this.f3731d = 0;
        this.f3732e = new C0939d<>();
        this.f3728a = comparator == null ? f3727g : comparator;
    }

    public int size() {
        return this.f3730c;
    }

    public V get(Object obj) {
        C0939d a = mo7558a(obj);
        if (a != null) {
            return a.f3749g;
        }
        return null;
    }

    public boolean containsKey(Object obj) {
        return mo7558a(obj) != null;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0939d a = mo7559a(k, true);
        V v2 = a.f3749g;
        a.f3749g = v;
        return v2;
    }

    public void clear() {
        this.f3729b = null;
        this.f3730c = 0;
        this.f3731d++;
        C0939d<K, V> dVar = this.f3732e;
        dVar.f3747e = dVar;
        dVar.f3746d = dVar;
    }

    public V remove(Object obj) {
        C0939d b = mo7562b(obj);
        if (b != null) {
            return b.f3749g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0939d<K, V> mo7559a(K k, boolean z) {
        C0939d<K, V> dVar;
        int i;
        C0939d<K, V> dVar2;
        int compare;
        Comparator<? super K> comparator = this.f3728a;
        C0939d<K, V> dVar3 = this.f3729b;
        if (dVar3 != null) {
            Comparable comparable = comparator == f3727g ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(dVar3.f3748f);
                } else {
                    compare = comparator.compare(k, dVar3.f3748f);
                }
                if (compare == 0) {
                    return dVar3;
                }
                C0939d<K, V> dVar4 = compare < 0 ? dVar3.f3744b : dVar3.f3745c;
                if (dVar4 == null) {
                    int i2 = compare;
                    dVar = dVar3;
                    i = i2;
                    break;
                }
                dVar3 = dVar4;
            }
        } else {
            dVar = dVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C0939d<K, V> dVar5 = this.f3732e;
        if (dVar != null) {
            dVar2 = new C0939d<>(dVar, k, dVar5, dVar5.f3747e);
            if (i < 0) {
                dVar.f3744b = dVar2;
            } else {
                dVar.f3745c = dVar2;
            }
            m4322b(dVar, true);
        } else if (comparator != f3727g || (k instanceof Comparable)) {
            dVar2 = new C0939d<>(dVar, k, dVar5, dVar5.f3747e);
            this.f3729b = dVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f3730c++;
        this.f3731d++;
        return dVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0939d<K, V> mo7558a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return mo7559a(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0939d<K, V> mo7560a(Map.Entry<?, ?> entry) {
        C0939d<K, V> a = mo7558a((Object) entry.getKey());
        if (a != null && m4320a((Object) a.f3749g, (Object) entry.getValue())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private boolean m4320a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7561a(C0939d<K, V> dVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            dVar.f3747e.f3746d = dVar.f3746d;
            dVar.f3746d.f3747e = dVar.f3747e;
        }
        C0939d<K, V> dVar2 = dVar.f3744b;
        C0939d<K, V> dVar3 = dVar.f3745c;
        C0939d<K, V> dVar4 = dVar.f3743a;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                m4319a(dVar, dVar2);
                dVar.f3744b = null;
            } else if (dVar3 != null) {
                m4319a(dVar, dVar3);
                dVar.f3745c = null;
            } else {
                m4319a(dVar, (C0939d<K, V>) null);
            }
            m4322b(dVar4, false);
            this.f3730c--;
            this.f3731d++;
            return;
        }
        C0939d<K, V> b = dVar2.f3750h > dVar3.f3750h ? dVar2.mo7590b() : dVar3.mo7589a();
        mo7561a(b, false);
        C0939d<K, V> dVar5 = dVar.f3744b;
        if (dVar5 != null) {
            i = dVar5.f3750h;
            b.f3744b = dVar5;
            dVar5.f3743a = b;
            dVar.f3744b = null;
        } else {
            i = 0;
        }
        C0939d<K, V> dVar6 = dVar.f3745c;
        if (dVar6 != null) {
            i2 = dVar6.f3750h;
            b.f3745c = dVar6;
            dVar6.f3743a = b;
            dVar.f3745c = null;
        }
        b.f3750h = Math.max(i, i2) + 1;
        m4319a(dVar, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0939d<K, V> mo7562b(Object obj) {
        C0939d<K, V> a = mo7558a(obj);
        if (a != null) {
            mo7561a(a, true);
        }
        return a;
    }

    /* renamed from: a */
    private void m4319a(C0939d<K, V> dVar, C0939d<K, V> dVar2) {
        C0939d<K, V> dVar3 = dVar.f3743a;
        dVar.f3743a = null;
        if (dVar2 != null) {
            dVar2.f3743a = dVar3;
        }
        if (dVar3 == null) {
            this.f3729b = dVar2;
        } else if (dVar3.f3744b == dVar) {
            dVar3.f3744b = dVar2;
        } else if (f3726f || dVar3.f3745c == dVar) {
            dVar3.f3745c = dVar2;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private void m4322b(C0939d<K, V> dVar, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (dVar != null) {
            C0939d<K, V> dVar2 = dVar.f3744b;
            C0939d<K, V> dVar3 = dVar.f3745c;
            int i5 = dVar2 != null ? dVar2.f3750h : 0;
            if (dVar3 != null) {
                i = dVar3.f3750h;
            } else {
                i = 0;
            }
            int i6 = i5 - i;
            if (i6 == -2) {
                C0939d<K, V> dVar4 = dVar3.f3744b;
                C0939d<K, V> dVar5 = dVar3.f3745c;
                if (dVar5 != null) {
                    i3 = dVar5.f3750h;
                } else {
                    i3 = 0;
                }
                if (dVar4 != null) {
                    i4 = dVar4.f3750h;
                } else {
                    i4 = 0;
                }
                int i7 = i4 - i3;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    m4318a(dVar);
                } else if (f3726f || i7 == 1) {
                    m4321b(dVar3);
                    m4318a(dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                C0939d<K, V> dVar6 = dVar2.f3744b;
                C0939d<K, V> dVar7 = dVar2.f3745c;
                int i8 = dVar7 != null ? dVar7.f3750h : 0;
                if (dVar6 != null) {
                    i2 = dVar6.f3750h;
                } else {
                    i2 = 0;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    m4321b(dVar);
                } else if (f3726f || i9 == -1) {
                    m4318a(dVar2);
                    m4321b(dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                dVar.f3750h = i5 + 1;
                if (z) {
                    return;
                }
            } else if (f3726f || i6 == -1 || i6 == 1) {
                dVar.f3750h = Math.max(i5, i) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            dVar = dVar.f3743a;
        }
    }

    /* renamed from: a */
    private void m4318a(C0939d<K, V> dVar) {
        int i;
        int i2 = 0;
        C0939d<K, V> dVar2 = dVar.f3744b;
        C0939d<K, V> dVar3 = dVar.f3745c;
        C0939d<K, V> dVar4 = dVar3.f3744b;
        C0939d<K, V> dVar5 = dVar3.f3745c;
        dVar.f3745c = dVar4;
        if (dVar4 != null) {
            dVar4.f3743a = dVar;
        }
        m4319a(dVar, dVar3);
        dVar3.f3744b = dVar;
        dVar.f3743a = dVar3;
        if (dVar2 != null) {
            i = dVar2.f3750h;
        } else {
            i = 0;
        }
        dVar.f3750h = Math.max(i, dVar4 != null ? dVar4.f3750h : 0) + 1;
        int i3 = dVar.f3750h;
        if (dVar5 != null) {
            i2 = dVar5.f3750h;
        }
        dVar3.f3750h = Math.max(i3, i2) + 1;
    }

    /* renamed from: b */
    private void m4321b(C0939d<K, V> dVar) {
        int i;
        int i2 = 0;
        C0939d<K, V> dVar2 = dVar.f3744b;
        C0939d<K, V> dVar3 = dVar.f3745c;
        C0939d<K, V> dVar4 = dVar2.f3744b;
        C0939d<K, V> dVar5 = dVar2.f3745c;
        dVar.f3744b = dVar5;
        if (dVar5 != null) {
            dVar5.f3743a = dVar;
        }
        m4319a(dVar, dVar2);
        dVar2.f3745c = dVar;
        dVar.f3743a = dVar2;
        if (dVar3 != null) {
            i = dVar3.f3750h;
        } else {
            i = 0;
        }
        dVar.f3750h = Math.max(i, dVar5 != null ? dVar5.f3750h : 0) + 1;
        int i3 = dVar.f3750h;
        if (dVar4 != null) {
            i2 = dVar4.f3750h;
        }
        dVar2.f3750h = Math.max(i3, i2) + 1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.C0000a aVar = this.f3733h;
        if (aVar != null) {
            return aVar;
        }
        LinkedTreeMap<K, V>.C0000a aVar2 = new C0934a();
        this.f3733h = aVar2;
        return aVar2;
    }

    public Set<K> keySet() {
        LinkedTreeMap<K, V>.C0608b bVar = this.f3734i;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.C0608b bVar2 = new C0936b();
        this.f3734i = bVar2;
        return bVar2;
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$d */
    static final class C0939d<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        C0939d<K, V> f3743a;

        /* renamed from: b */
        C0939d<K, V> f3744b;

        /* renamed from: c */
        C0939d<K, V> f3745c;

        /* renamed from: d */
        C0939d<K, V> f3746d;

        /* renamed from: e */
        C0939d<K, V> f3747e;

        /* renamed from: f */
        final K f3748f;

        /* renamed from: g */
        V f3749g;

        /* renamed from: h */
        int f3750h;

        C0939d() {
            this.f3748f = null;
            this.f3747e = this;
            this.f3746d = this;
        }

        C0939d(C0939d<K, V> dVar, K k, C0939d<K, V> dVar2, C0939d<K, V> dVar3) {
            this.f3743a = dVar;
            this.f3748f = k;
            this.f3750h = 1;
            this.f3746d = dVar2;
            this.f3747e = dVar3;
            dVar3.f3746d = this;
            dVar2.f3747e = this;
        }

        public K getKey() {
            return this.f3748f;
        }

        public V getValue() {
            return this.f3749g;
        }

        public V setValue(V v) {
            V v2 = this.f3749g;
            this.f3749g = v;
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
                K r1 = r3.f3748f
                if (r1 != 0) goto L_0x001d
                java.lang.Object r1 = r4.getKey()
                if (r1 != 0) goto L_0x001c
            L_0x0011:
                V r1 = r3.f3749g
                if (r1 != 0) goto L_0x002a
                java.lang.Object r1 = r4.getValue()
                if (r1 != 0) goto L_0x001c
            L_0x001b:
                r0 = 1
            L_0x001c:
                return r0
            L_0x001d:
                K r1 = r3.f3748f
                java.lang.Object r2 = r4.getKey()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x0011
            L_0x002a:
                V r1 = r3.f3749g
                java.lang.Object r2 = r4.getValue()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x001b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.C0939d.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f3748f == null ? 0 : this.f3748f.hashCode();
            if (this.f3749g != null) {
                i = this.f3749g.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.f3748f + "=" + this.f3749g;
        }

        /* renamed from: a */
        public C0939d<K, V> mo7589a() {
            for (C0939d<K, V> dVar = this.f3744b; dVar != null; dVar = dVar.f3744b) {
                this = dVar;
            }
            return this;
        }

        /* renamed from: b */
        public C0939d<K, V> mo7590b() {
            for (C0939d<K, V> dVar = this.f3745c; dVar != null; dVar = dVar.f3745c) {
                this = dVar;
            }
            return this;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$c */
    abstract class C0938c<T> implements Iterator<T> {

        /* renamed from: b */
        C0939d<K, V> f3739b;

        /* renamed from: c */
        C0939d<K, V> f3740c;

        /* renamed from: d */
        int f3741d;

        private C0938c() {
            this.f3739b = LinkedTreeMap.this.f3732e.f3746d;
            this.f3740c = null;
            this.f3741d = LinkedTreeMap.this.f3731d;
        }

        public final boolean hasNext() {
            return this.f3739b != LinkedTreeMap.this.f3732e;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final C0939d<K, V> mo7586b() {
            C0939d<K, V> dVar = this.f3739b;
            if (dVar == LinkedTreeMap.this.f3732e) {
                throw new NoSuchElementException();
            } else if (LinkedTreeMap.this.f3731d != this.f3741d) {
                throw new ConcurrentModificationException();
            } else {
                this.f3739b = dVar.f3746d;
                this.f3740c = dVar;
                return dVar;
            }
        }

        public final void remove() {
            if (this.f3740c == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.mo7561a(this.f3740c, true);
            this.f3740c = null;
            this.f3741d = LinkedTreeMap.this.f3731d;
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$a */
    class C0934a extends AbstractSet<Map.Entry<K, V>> {
        C0934a() {
        }

        public int size() {
            return LinkedTreeMap.this.f3730c;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.C0650c<Map.Entry<K, V>>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return mo7586b();
                }
            };
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.mo7560a((Map.Entry<?, ?>) (Map.Entry) obj) != null;
        }

        public boolean remove(Object obj) {
            C0939d a;
            if (!(obj instanceof Map.Entry) || (a = LinkedTreeMap.this.mo7560a((Map.Entry<?, ?>) (Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.mo7561a(a, true);
            return true;
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    /* renamed from: com.google.gson.internal.LinkedTreeMap$b */
    final class C0936b extends AbstractSet<K> {
        C0936b() {
        }

        public int size() {
            return LinkedTreeMap.this.f3730c;
        }

        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.C0650c<K>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public K next() {
                    return mo7586b().f3748f;
                }
            };
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return LinkedTreeMap.this.mo7562b(obj) != null;
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
