package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public final class zzant extends AbstractMap implements Serializable {

    /* renamed from: f */
    static final /* synthetic */ boolean f5803f = (!zzant.class.desiredAssertionStatus());

    /* renamed from: g */
    private static final Comparator f5804g = new C1436ba();

    /* renamed from: a */
    Comparator f5805a;

    /* renamed from: b */
    C1442bg f5806b;

    /* renamed from: c */
    int f5807c;

    /* renamed from: d */
    int f5808d;

    /* renamed from: e */
    final C1442bg f5809e;

    /* renamed from: h */
    private C1437bb f5810h;

    /* renamed from: i */
    private C1439bd f5811i;

    public zzant() {
        this(f5804g);
    }

    public zzant(Comparator comparator) {
        this.f5807c = 0;
        this.f5808d = 0;
        this.f5809e = new C1442bg();
        this.f5805a = comparator == null ? f5804g : comparator;
    }

    /* renamed from: a */
    private void m6680a(C1442bg bgVar) {
        int i = 0;
        C1442bg bgVar2 = bgVar.f4876b;
        C1442bg bgVar3 = bgVar.f4877c;
        C1442bg bgVar4 = bgVar3.f4876b;
        C1442bg bgVar5 = bgVar3.f4877c;
        bgVar.f4877c = bgVar4;
        if (bgVar4 != null) {
            bgVar4.f4875a = bgVar;
        }
        m6681a(bgVar, bgVar3);
        bgVar3.f4876b = bgVar;
        bgVar.f4875a = bgVar3;
        bgVar.f4882h = Math.max(bgVar2 != null ? bgVar2.f4882h : 0, bgVar4 != null ? bgVar4.f4882h : 0) + 1;
        int i2 = bgVar.f4882h;
        if (bgVar5 != null) {
            i = bgVar5.f4882h;
        }
        bgVar3.f4882h = Math.max(i2, i) + 1;
    }

    /* renamed from: a */
    private void m6681a(C1442bg bgVar, C1442bg bgVar2) {
        C1442bg bgVar3 = bgVar.f4875a;
        bgVar.f4875a = null;
        if (bgVar2 != null) {
            bgVar2.f4875a = bgVar3;
        }
        if (bgVar3 == null) {
            this.f5806b = bgVar2;
        } else if (bgVar3.f4876b == bgVar) {
            bgVar3.f4876b = bgVar2;
        } else if (f5803f || bgVar3.f4877c == bgVar) {
            bgVar3.f4877c = bgVar2;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m6682a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: b */
    private void m6683b(C1442bg bgVar) {
        int i = 0;
        C1442bg bgVar2 = bgVar.f4876b;
        C1442bg bgVar3 = bgVar.f4877c;
        C1442bg bgVar4 = bgVar2.f4876b;
        C1442bg bgVar5 = bgVar2.f4877c;
        bgVar.f4876b = bgVar5;
        if (bgVar5 != null) {
            bgVar5.f4875a = bgVar;
        }
        m6681a(bgVar, bgVar2);
        bgVar2.f4877c = bgVar;
        bgVar.f4875a = bgVar2;
        bgVar.f4882h = Math.max(bgVar3 != null ? bgVar3.f4882h : 0, bgVar5 != null ? bgVar5.f4882h : 0) + 1;
        int i2 = bgVar.f4882h;
        if (bgVar4 != null) {
            i = bgVar4.f4882h;
        }
        bgVar2.f4882h = Math.max(i2, i) + 1;
    }

    /* renamed from: b */
    private void m6684b(C1442bg bgVar, boolean z) {
        while (bgVar != null) {
            C1442bg bgVar2 = bgVar.f4876b;
            C1442bg bgVar3 = bgVar.f4877c;
            int i = bgVar2 != null ? bgVar2.f4882h : 0;
            int i2 = bgVar3 != null ? bgVar3.f4882h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C1442bg bgVar4 = bgVar3.f4876b;
                C1442bg bgVar5 = bgVar3.f4877c;
                int i4 = (bgVar4 != null ? bgVar4.f4882h : 0) - (bgVar5 != null ? bgVar5.f4882h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m6680a(bgVar);
                } else if (f5803f || i4 == 1) {
                    m6683b(bgVar3);
                    m6680a(bgVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                C1442bg bgVar6 = bgVar2.f4876b;
                C1442bg bgVar7 = bgVar2.f4877c;
                int i5 = (bgVar6 != null ? bgVar6.f4882h : 0) - (bgVar7 != null ? bgVar7.f4882h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m6683b(bgVar);
                } else if (f5803f || i5 == -1) {
                    m6680a(bgVar2);
                    m6683b(bgVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                bgVar.f4882h = i + 1;
                if (z) {
                    return;
                }
            } else if (f5803f || i3 == -1 || i3 == 1) {
                bgVar.f4882h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            bgVar = bgVar.f4875a;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1442bg mo7885a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return mo7886a(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1442bg mo7886a(Object obj, boolean z) {
        C1442bg bgVar;
        int i;
        C1442bg bgVar2;
        Comparator comparator = this.f5805a;
        C1442bg bgVar3 = this.f5806b;
        if (bgVar3 != null) {
            Comparable comparable = comparator == f5804g ? (Comparable) obj : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(bgVar3.f4880f) : comparator.compare(obj, bgVar3.f4880f);
                if (compareTo == 0) {
                    return bgVar3;
                }
                C1442bg bgVar4 = compareTo < 0 ? bgVar3.f4876b : bgVar3.f4877c;
                if (bgVar4 == null) {
                    int i2 = compareTo;
                    bgVar = bgVar3;
                    i = i2;
                    break;
                }
                bgVar3 = bgVar4;
            }
        } else {
            bgVar = bgVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        C1442bg bgVar5 = this.f5809e;
        if (bgVar != null) {
            bgVar2 = new C1442bg(bgVar, obj, bgVar5, bgVar5.f4879e);
            if (i < 0) {
                bgVar.f4876b = bgVar2;
            } else {
                bgVar.f4877c = bgVar2;
            }
            m6684b(bgVar, true);
        } else if (comparator != f5804g || (obj instanceof Comparable)) {
            bgVar2 = new C1442bg(bgVar, obj, bgVar5, bgVar5.f4879e);
            this.f5806b = bgVar2;
        } else {
            throw new ClassCastException(String.valueOf(obj.getClass().getName()).concat(" is not Comparable"));
        }
        this.f5807c++;
        this.f5808d++;
        return bgVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1442bg mo7887a(Map.Entry entry) {
        C1442bg a = mo7885a(entry.getKey());
        if (a != null && m6682a(a.f4881g, entry.getValue())) {
            return a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7888a(C1442bg bgVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            bgVar.f4879e.f4878d = bgVar.f4878d;
            bgVar.f4878d.f4879e = bgVar.f4879e;
        }
        C1442bg bgVar2 = bgVar.f4876b;
        C1442bg bgVar3 = bgVar.f4877c;
        C1442bg bgVar4 = bgVar.f4875a;
        if (bgVar2 == null || bgVar3 == null) {
            if (bgVar2 != null) {
                m6681a(bgVar, bgVar2);
                bgVar.f4876b = null;
            } else if (bgVar3 != null) {
                m6681a(bgVar, bgVar3);
                bgVar.f4877c = null;
            } else {
                m6681a(bgVar, (C1442bg) null);
            }
            m6684b(bgVar4, false);
            this.f5807c--;
            this.f5808d++;
            return;
        }
        C1442bg b = bgVar2.f4882h > bgVar3.f4882h ? bgVar2.mo7096b() : bgVar3.mo7095a();
        mo7888a(b, false);
        C1442bg bgVar5 = bgVar.f4876b;
        if (bgVar5 != null) {
            i = bgVar5.f4882h;
            b.f4876b = bgVar5;
            bgVar5.f4875a = b;
            bgVar.f4876b = null;
        } else {
            i = 0;
        }
        C1442bg bgVar6 = bgVar.f4877c;
        if (bgVar6 != null) {
            i2 = bgVar6.f4882h;
            b.f4877c = bgVar6;
            bgVar6.f4875a = b;
            bgVar.f4877c = null;
        }
        b.f4882h = Math.max(i, i2) + 1;
        m6681a(bgVar, b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1442bg mo7889b(Object obj) {
        C1442bg a = mo7885a(obj);
        if (a != null) {
            mo7888a(a, true);
        }
        return a;
    }

    public void clear() {
        this.f5806b = null;
        this.f5807c = 0;
        this.f5808d++;
        C1442bg bgVar = this.f5809e;
        bgVar.f4879e = bgVar;
        bgVar.f4878d = bgVar;
    }

    public boolean containsKey(Object obj) {
        return mo7885a(obj) != null;
    }

    public Set entrySet() {
        C1437bb bbVar = this.f5810h;
        if (bbVar != null) {
            return bbVar;
        }
        C1437bb bbVar2 = new C1437bb(this);
        this.f5810h = bbVar2;
        return bbVar2;
    }

    public Object get(Object obj) {
        C1442bg a = mo7885a(obj);
        if (a != null) {
            return a.f4881g;
        }
        return null;
    }

    public Set keySet() {
        C1439bd bdVar = this.f5811i;
        if (bdVar != null) {
            return bdVar;
        }
        C1439bd bdVar2 = new C1439bd(this);
        this.f5811i = bdVar2;
        return bdVar2;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        C1442bg a = mo7886a(obj, true);
        Object obj3 = a.f4881g;
        a.f4881g = obj2;
        return obj3;
    }

    public Object remove(Object obj) {
        C1442bg b = mo7889b(obj);
        if (b != null) {
            return b.f4881g;
        }
        return null;
    }

    public int size() {
        return this.f5807c;
    }
}
