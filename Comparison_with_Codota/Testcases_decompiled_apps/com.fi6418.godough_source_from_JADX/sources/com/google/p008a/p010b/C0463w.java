package com.google.p008a.p010b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.a.b.w */
public final class C0463w<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: f */
    static final /* synthetic */ boolean f3559f = (!C0463w.class.desiredAssertionStatus());

    /* renamed from: g */
    private static final Comparator<Comparable> f3560g = new C0464x();

    /* renamed from: a */
    Comparator<? super K> f3561a;

    /* renamed from: b */
    C0430ad<K, V> f3562b;

    /* renamed from: c */
    int f3563c;

    /* renamed from: d */
    int f3564d;

    /* renamed from: e */
    final C0430ad<K, V> f3565e;

    /* renamed from: h */
    private C0463w<K, V>.C0465y f3566h;

    /* renamed from: i */
    private C0463w<K, V>.C0427aa f3567i;

    public C0463w() {
        this(f3560g);
    }

    public C0463w(Comparator<? super K> comparator) {
        this.f3563c = 0;
        this.f3564d = 0;
        this.f3565e = new C0430ad<>();
        this.f3561a = comparator == null ? f3560g : comparator;
    }

    /* renamed from: a */
    private void m2782a(C0430ad<K, V> adVar) {
        int i = 0;
        C0430ad<K, V> adVar2 = adVar.f3498b;
        C0430ad<K, V> adVar3 = adVar.f3499c;
        C0430ad<K, V> adVar4 = adVar3.f3498b;
        C0430ad<K, V> adVar5 = adVar3.f3499c;
        adVar.f3499c = adVar4;
        if (adVar4 != null) {
            adVar4.f3497a = adVar;
        }
        m2783a(adVar, adVar3);
        adVar3.f3498b = adVar;
        adVar.f3497a = adVar3;
        adVar.f3504h = Math.max(adVar2 != null ? adVar2.f3504h : 0, adVar4 != null ? adVar4.f3504h : 0) + 1;
        int i2 = adVar.f3504h;
        if (adVar5 != null) {
            i = adVar5.f3504h;
        }
        adVar3.f3504h = Math.max(i2, i) + 1;
    }

    /* renamed from: a */
    private void m2783a(C0430ad<K, V> adVar, C0430ad<K, V> adVar2) {
        C0430ad<K, V> adVar3 = adVar.f3497a;
        adVar.f3497a = null;
        if (adVar2 != null) {
            adVar2.f3497a = adVar3;
        }
        if (adVar3 == null) {
            this.f3562b = adVar2;
        } else if (adVar3.f3498b == adVar) {
            adVar3.f3498b = adVar2;
        } else if (f3559f || adVar3.f3499c == adVar) {
            adVar3.f3499c = adVar2;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m2784a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    private void m2785b(C0430ad<K, V> adVar) {
        int i = 0;
        C0430ad<K, V> adVar2 = adVar.f3498b;
        C0430ad<K, V> adVar3 = adVar.f3499c;
        C0430ad<K, V> adVar4 = adVar2.f3498b;
        C0430ad<K, V> adVar5 = adVar2.f3499c;
        adVar.f3498b = adVar5;
        if (adVar5 != null) {
            adVar5.f3497a = adVar;
        }
        m2783a(adVar, adVar2);
        adVar2.f3499c = adVar;
        adVar.f3497a = adVar2;
        adVar.f3504h = Math.max(adVar3 != null ? adVar3.f3504h : 0, adVar5 != null ? adVar5.f3504h : 0) + 1;
        int i2 = adVar.f3504h;
        if (adVar4 != null) {
            i = adVar4.f3504h;
        }
        adVar2.f3504h = Math.max(i2, i) + 1;
    }

    /* renamed from: b */
    private void m2786b(C0430ad<K, V> adVar, boolean z) {
        while (adVar != null) {
            C0430ad<K, V> adVar2 = adVar.f3498b;
            C0430ad<K, V> adVar3 = adVar.f3499c;
            int i = adVar2 != null ? adVar2.f3504h : 0;
            int i2 = adVar3 != null ? adVar3.f3504h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C0430ad<K, V> adVar4 = adVar3.f3498b;
                C0430ad<K, V> adVar5 = adVar3.f3499c;
                int i4 = (adVar4 != null ? adVar4.f3504h : 0) - (adVar5 != null ? adVar5.f3504h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m2782a(adVar);
                } else if (f3559f || i4 == 1) {
                    m2785b(adVar3);
                    m2782a(adVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C0430ad<K, V> adVar6 = adVar2.f3498b;
                C0430ad<K, V> adVar7 = adVar2.f3499c;
                int i5 = (adVar6 != null ? adVar6.f3504h : 0) - (adVar7 != null ? adVar7.f3504h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m2785b(adVar);
                } else if (f3559f || i5 == -1) {
                    m2782a(adVar2);
                    m2785b(adVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                adVar.f3504h = i + 1;
                if (z) {
                    return;
                }
            } else if (f3559f || i3 == -1 || i3 == 1) {
                adVar.f3504h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            adVar = adVar.f3497a;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0430ad<K, V> mo6472a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return mo6473a(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0430ad<K, V> mo6473a(K k, boolean z) {
        C0430ad<K, V> adVar;
        int i;
        C0430ad<K, V> adVar2;
        Comparator<? super K> comparator = this.f3561a;
        C0430ad<K, V> adVar3 = this.f3562b;
        if (adVar3 != null) {
            Comparable comparable = comparator == f3560g ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(adVar3.f3502f) : comparator.compare(k, adVar3.f3502f);
                if (compareTo == 0) {
                    return adVar3;
                }
                C0430ad<K, V> adVar4 = compareTo < 0 ? adVar3.f3498b : adVar3.f3499c;
                if (adVar4 == null) {
                    int i2 = compareTo;
                    adVar = adVar3;
                    i = i2;
                    break;
                }
                adVar3 = adVar4;
            }
        } else {
            adVar = adVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C0430ad<K, V> adVar5 = this.f3565e;
        if (adVar != null) {
            adVar2 = new C0430ad<>(adVar, k, adVar5, adVar5.f3501e);
            if (i < 0) {
                adVar.f3498b = adVar2;
            } else {
                adVar.f3499c = adVar2;
            }
            m2786b(adVar, true);
        } else if (comparator != f3560g || (k instanceof Comparable)) {
            adVar2 = new C0430ad<>(adVar, k, adVar5, adVar5.f3501e);
            this.f3562b = adVar2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.f3563c++;
        this.f3564d++;
        return adVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0430ad<K, V> mo6474a(Map.Entry<?, ?> entry) {
        C0430ad<K, V> a = mo6472a((Object) entry.getKey());
        if (a != null && m2784a((Object) a.f3503g, (Object) entry.getValue())) {
            return a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6475a(C0430ad<K, V> adVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            adVar.f3501e.f3500d = adVar.f3500d;
            adVar.f3500d.f3501e = adVar.f3501e;
        }
        C0430ad<K, V> adVar2 = adVar.f3498b;
        C0430ad<K, V> adVar3 = adVar.f3499c;
        C0430ad<K, V> adVar4 = adVar.f3497a;
        if (adVar2 == null || adVar3 == null) {
            if (adVar2 != null) {
                m2783a(adVar, adVar2);
                adVar.f3498b = null;
            } else if (adVar3 != null) {
                m2783a(adVar, adVar3);
                adVar.f3499c = null;
            } else {
                m2783a(adVar, (C0430ad<K, V>) null);
            }
            m2786b(adVar4, false);
            this.f3563c--;
            this.f3564d++;
            return;
        }
        C0430ad<K, V> b = adVar2.f3504h > adVar3.f3504h ? adVar2.mo6429b() : adVar3.mo6428a();
        mo6475a(b, false);
        C0430ad<K, V> adVar5 = adVar.f3498b;
        if (adVar5 != null) {
            i = adVar5.f3504h;
            b.f3498b = adVar5;
            adVar5.f3497a = b;
            adVar.f3498b = null;
        } else {
            i = 0;
        }
        C0430ad<K, V> adVar6 = adVar.f3499c;
        if (adVar6 != null) {
            i2 = adVar6.f3504h;
            b.f3499c = adVar6;
            adVar6.f3497a = b;
            adVar.f3499c = null;
        }
        b.f3504h = Math.max(i, i2) + 1;
        m2783a(adVar, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0430ad<K, V> mo6476b(Object obj) {
        C0430ad<K, V> a = mo6472a(obj);
        if (a != null) {
            mo6475a(a, true);
        }
        return a;
    }

    public void clear() {
        this.f3562b = null;
        this.f3563c = 0;
        this.f3564d++;
        C0430ad<K, V> adVar = this.f3565e;
        adVar.f3501e = adVar;
        adVar.f3500d = adVar;
    }

    public boolean containsKey(Object obj) {
        return mo6472a(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        C0463w<K, V>.C0465y yVar = this.f3566h;
        if (yVar != null) {
            return yVar;
        }
        C0465y yVar2 = new C0465y(this);
        this.f3566h = yVar2;
        return yVar2;
    }

    public V get(Object obj) {
        C0430ad a = mo6472a(obj);
        if (a != null) {
            return a.f3503g;
        }
        return null;
    }

    public Set<K> keySet() {
        C0463w<K, V>.C0427aa aaVar = this.f3567i;
        if (aaVar != null) {
            return aaVar;
        }
        C0427aa aaVar2 = new C0427aa(this);
        this.f3567i = aaVar2;
        return aaVar2;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        C0430ad a = mo6473a(k, true);
        V v2 = a.f3503g;
        a.f3503g = v;
        return v2;
    }

    public V remove(Object obj) {
        C0430ad b = mo6476b(obj);
        if (b != null) {
            return b.f3503g;
        }
        return null;
    }

    public int size() {
        return this.f3563c;
    }
}
