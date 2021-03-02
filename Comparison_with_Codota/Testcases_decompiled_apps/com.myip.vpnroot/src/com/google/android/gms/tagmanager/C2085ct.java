package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.internal.C1026d;
import com.google.android.gms.tagmanager.C2075cr;
import com.google.android.gms.tagmanager.C2128l;
import com.google.android.gms.tagmanager.C2147s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.ct */
class C2085ct {
    private static final C2047bz<C1026d.C1027a> aqH = new C2047bz<>(C2114di.m7119pI(), true);
    private final DataLayer anS;
    private final C2075cr.C2079c aqI;
    private final C1995ag aqJ;
    private final Map<String, C1998aj> aqK;
    private final Map<String, C1998aj> aqL;
    private final Map<String, C1998aj> aqM;
    private final C2127k<C2075cr.C2077a, C2047bz<C1026d.C1027a>> aqN;
    private final C2127k<String, C2091b> aqO;
    private final Set<C2075cr.C2081e> aqP;
    private final Map<String, C2092c> aqQ;
    private volatile String aqR;
    private int aqS;

    /* renamed from: com.google.android.gms.tagmanager.ct$a */
    interface C2090a {
        /* renamed from: a */
        void mo11704a(C2075cr.C2081e eVar, Set<C2075cr.C2077a> set, Set<C2075cr.C2077a> set2, C2065cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$b */
    private static class C2091b {
        private C2047bz<C1026d.C1027a> aqY;
        private C1026d.C1027a aqt;

        public C2091b(C2047bz<C1026d.C1027a> bzVar, C1026d.C1027a aVar) {
            this.aqY = bzVar;
            this.aqt = aVar;
        }

        public int getSize() {
            return (this.aqt == null ? 0 : this.aqt.mo10105qF()) + this.aqY.getObject().mo10105qF();
        }

        /* renamed from: oT */
        public C1026d.C1027a mo11706oT() {
            return this.aqt;
        }

        /* renamed from: pn */
        public C2047bz<C1026d.C1027a> mo11707pn() {
            return this.aqY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$c */
    private static class C2092c {
        private final Set<C2075cr.C2081e> aqP = new HashSet();
        private final Map<C2075cr.C2081e, List<C2075cr.C2077a>> aqZ = new HashMap();
        private final Map<C2075cr.C2081e, List<C2075cr.C2077a>> ara = new HashMap();
        private final Map<C2075cr.C2081e, List<String>> arb = new HashMap();
        private final Map<C2075cr.C2081e, List<String>> arc = new HashMap();
        private C2075cr.C2077a ard;

        /* renamed from: a */
        public void mo11708a(C2075cr.C2081e eVar, C2075cr.C2077a aVar) {
            List list = this.aqZ.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.aqZ.put(eVar, list);
            }
            list.add(aVar);
        }

        /* renamed from: a */
        public void mo11709a(C2075cr.C2081e eVar, String str) {
            List list = this.arb.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.arb.put(eVar, list);
            }
            list.add(str);
        }

        /* renamed from: b */
        public void mo11710b(C2075cr.C2081e eVar) {
            this.aqP.add(eVar);
        }

        /* renamed from: b */
        public void mo11711b(C2075cr.C2081e eVar, C2075cr.C2077a aVar) {
            List list = this.ara.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.ara.put(eVar, list);
            }
            list.add(aVar);
        }

        /* renamed from: b */
        public void mo11712b(C2075cr.C2081e eVar, String str) {
            List list = this.arc.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.arc.put(eVar, list);
            }
            list.add(str);
        }

        /* renamed from: i */
        public void mo11713i(C2075cr.C2077a aVar) {
            this.ard = aVar;
        }

        /* renamed from: po */
        public Set<C2075cr.C2081e> mo11714po() {
            return this.aqP;
        }

        /* renamed from: pp */
        public Map<C2075cr.C2081e, List<C2075cr.C2077a>> mo11715pp() {
            return this.aqZ;
        }

        /* renamed from: pq */
        public Map<C2075cr.C2081e, List<String>> mo11716pq() {
            return this.arb;
        }

        /* renamed from: pr */
        public Map<C2075cr.C2081e, List<String>> mo11717pr() {
            return this.arc;
        }

        /* renamed from: ps */
        public Map<C2075cr.C2081e, List<C2075cr.C2077a>> mo11718ps() {
            return this.ara;
        }

        /* renamed from: pt */
        public C2075cr.C2077a mo11719pt() {
            return this.ard;
        }
    }

    public C2085ct(Context context, C2075cr.C2079c cVar, DataLayer dataLayer, C2147s.C2148a aVar, C2147s.C2148a aVar2, C1995ag agVar) {
        if (cVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.aqI = cVar;
        this.aqP = new HashSet(cVar.mo11659oW());
        this.anS = dataLayer;
        this.aqJ = agVar;
        this.aqN = new C2128l().mo11752a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C2128l.C2130a<C2075cr.C2077a, C2047bz<C1026d.C1027a>>() {
            /* renamed from: a */
            public int sizeOf(C2075cr.C2077a aVar, C2047bz<C1026d.C1027a> bzVar) {
                return bzVar.getObject().mo10105qF();
            }
        });
        this.aqO = new C2128l().mo11752a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C2128l.C2130a<String, C2091b>() {
            /* renamed from: a */
            public int sizeOf(String str, C2091b bVar) {
                return str.length() + bVar.getSize();
            }
        });
        this.aqK = new HashMap();
        mo11694b(new C2123i(context));
        mo11694b(new C2147s(aVar2));
        mo11694b(new C2157w(dataLayer));
        mo11694b(new C2115dj(context, dataLayer));
        this.aqL = new HashMap();
        mo11695c(new C2145q());
        mo11695c(new C1992ad());
        mo11695c(new C1993ae());
        mo11695c(new C2000al());
        mo11695c(new C2001am());
        mo11695c(new C2023bd());
        mo11695c(new C2024be());
        mo11695c(new C2060ci());
        mo11695c(new C2107dc());
        this.aqM = new HashMap();
        mo11693a(new C2018b(context));
        mo11693a(new C2048c(context));
        mo11693a(new C2119e(context));
        mo11693a(new C2120f(context));
        mo11693a(new C2121g(context));
        mo11693a(new C2122h(context));
        mo11693a(new C2131m());
        mo11693a(new C2144p(this.aqI.getVersion()));
        mo11693a(new C2147s(aVar));
        mo11693a(new C2150u(dataLayer));
        mo11693a(new C2160z(context));
        mo11693a(new C1989aa());
        mo11693a(new C1991ac());
        mo11693a(new C1996ah(this));
        mo11693a(new C2002an());
        mo11693a(new C2003ao());
        mo11693a(new C2013ax(context));
        mo11693a(new C2015az());
        mo11693a(new C2022bc());
        mo11693a(new C2030bj());
        mo11693a(new C2032bl(context));
        mo11693a(new C2049ca());
        mo11693a(new C2053cc());
        mo11693a(new C2057cf());
        mo11693a(new C2059ch());
        mo11693a(new C2061cj(context));
        mo11693a(new C2093cu());
        mo11693a(new C2094cv());
        mo11693a(new C2109de());
        mo11693a(new C2116dk());
        this.aqQ = new HashMap();
        for (C2075cr.C2081e next : this.aqP) {
            if (agVar.mo11547oo()) {
                m7009a(next.mo11671pe(), next.mo11672pf(), "add macro");
                m7009a(next.mo11676pj(), next.mo11673pg(), "remove macro");
                m7009a(next.mo11669pc(), next.mo11674ph(), "add tag");
                m7009a(next.mo11670pd(), next.mo11675pi(), "remove tag");
            }
            for (int i = 0; i < next.mo11671pe().size(); i++) {
                C2075cr.C2077a aVar3 = next.mo11671pe().get(i);
                String str = "Unknown";
                if (agVar.mo11547oo() && i < next.mo11672pf().size()) {
                    str = next.mo11672pf().get(i);
                }
                C2092c e = m7011e(this.aqQ, m7012h(aVar3));
                e.mo11710b(next);
                e.mo11708a(next, aVar3);
                e.mo11709a(next, str);
            }
            for (int i2 = 0; i2 < next.mo11676pj().size(); i2++) {
                C2075cr.C2077a aVar4 = next.mo11676pj().get(i2);
                String str2 = "Unknown";
                if (agVar.mo11547oo() && i2 < next.mo11673pg().size()) {
                    str2 = next.mo11673pg().get(i2);
                }
                C2092c e2 = m7011e(this.aqQ, m7012h(aVar4));
                e2.mo11710b(next);
                e2.mo11711b(next, aVar4);
                e2.mo11712b(next, str2);
            }
        }
        for (Map.Entry next2 : this.aqI.mo11660oX().entrySet()) {
            for (C2075cr.C2077a aVar5 : (List) next2.getValue()) {
                if (!C2114di.m7110n(aVar5.mo11652oS().get(C0929b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m7011e(this.aqQ, (String) next2.getKey()).mo11713i(aVar5);
                }
            }
        }
    }

    /* renamed from: a */
    private C2047bz<C1026d.C1027a> m7004a(C1026d.C1027a aVar, Set<String> set, C2117dl dlVar) {
        if (!aVar.f3083gF) {
            return new C2047bz<>(aVar, true);
        }
        switch (aVar.type) {
            case 2:
                C1026d.C1027a g = C2075cr.m6963g(aVar);
                g.f3085gw = new C1026d.C1027a[aVar.f3085gw.length];
                for (int i = 0; i < aVar.f3085gw.length; i++) {
                    C2047bz<C1026d.C1027a> a = m7004a(aVar.f3085gw[i], set, dlVar.mo11606fh(i));
                    if (a == aqH) {
                        return aqH;
                    }
                    g.f3085gw[i] = a.getObject();
                }
                return new C2047bz<>(g, false);
            case 3:
                C1026d.C1027a g2 = C2075cr.m6963g(aVar);
                if (aVar.f3086gx.length != aVar.f3087gy.length) {
                    C2028bh.m6816T("Invalid serving value: " + aVar.toString());
                    return aqH;
                }
                g2.f3086gx = new C1026d.C1027a[aVar.f3086gx.length];
                g2.f3087gy = new C1026d.C1027a[aVar.f3086gx.length];
                for (int i2 = 0; i2 < aVar.f3086gx.length; i2++) {
                    C2047bz<C1026d.C1027a> a2 = m7004a(aVar.f3086gx[i2], set, dlVar.mo11607fi(i2));
                    C2047bz<C1026d.C1027a> a3 = m7004a(aVar.f3087gy[i2], set, dlVar.mo11608fj(i2));
                    if (a2 == aqH || a3 == aqH) {
                        return aqH;
                    }
                    g2.f3086gx[i2] = a2.getObject();
                    g2.f3087gy[i2] = a3.getObject();
                }
                return new C2047bz<>(g2, false);
            case 4:
                if (set.contains(aVar.f3088gz)) {
                    C2028bh.m6816T("Macro cycle detected.  Current macro reference: " + aVar.f3088gz + "." + "  Previous macro references: " + set.toString() + ".");
                    return aqH;
                }
                set.add(aVar.f3088gz);
                C2047bz<C1026d.C1027a> a4 = C2118dm.m7153a(m7005a(aVar.f3088gz, set, dlVar.mo11610oD()), aVar.f3082gE);
                set.remove(aVar.f3088gz);
                return a4;
            case 7:
                C1026d.C1027a g3 = C2075cr.m6963g(aVar);
                g3.f3081gD = new C1026d.C1027a[aVar.f3081gD.length];
                for (int i3 = 0; i3 < aVar.f3081gD.length; i3++) {
                    C2047bz<C1026d.C1027a> a5 = m7004a(aVar.f3081gD[i3], set, dlVar.mo11609fk(i3));
                    if (a5 == aqH) {
                        return aqH;
                    }
                    g3.f3081gD[i3] = a5.getObject();
                }
                return new C2047bz<>(g3, false);
            default:
                C2028bh.m6816T("Unknown type: " + aVar.type);
                return aqH;
        }
    }

    /* renamed from: a */
    private C2047bz<C1026d.C1027a> m7005a(String str, Set<String> set, C2031bk bkVar) {
        C2075cr.C2077a aVar;
        this.aqS++;
        C2091b bVar = this.aqO.get(str);
        if (bVar == null || this.aqJ.mo11547oo()) {
            C2092c cVar = this.aqQ.get(str);
            if (cVar == null) {
                C2028bh.m6816T(m7013pm() + "Invalid macro: " + str);
                this.aqS--;
                return aqH;
            }
            C2047bz<Set<C2075cr.C2077a>> a = mo11691a(str, cVar.mo11714po(), cVar.mo11715pp(), cVar.mo11716pq(), cVar.mo11718ps(), cVar.mo11717pr(), set, bkVar.mo11584of());
            if (a.getObject().isEmpty()) {
                aVar = cVar.mo11719pt();
            } else {
                if (a.getObject().size() > 1) {
                    C2028bh.m6819W(m7013pm() + "Multiple macros active for macroName " + str);
                }
                aVar = (C2075cr.C2077a) a.getObject().iterator().next();
            }
            if (aVar == null) {
                this.aqS--;
                return aqH;
            }
            C2047bz<C1026d.C1027a> a2 = m7006a(this.aqM, aVar, set, bkVar.mo11585ou());
            C2047bz<C1026d.C1027a> bzVar = a2 == aqH ? aqH : new C2047bz<>(a2.getObject(), a.mo11613oE() && a2.mo11613oE());
            C1026d.C1027a oT = aVar.mo11653oT();
            if (bzVar.mo11613oE()) {
                this.aqO.mo11569e(str, new C2091b(bzVar, oT));
            }
            m7008a(oT, set);
            this.aqS--;
            return bzVar;
        }
        m7008a(bVar.mo11706oT(), set);
        this.aqS--;
        return bVar.mo11707pn();
    }

    /* renamed from: a */
    private C2047bz<C1026d.C1027a> m7006a(Map<String, C1998aj> map, C2075cr.C2077a aVar, Set<String> set, C2062ck ckVar) {
        boolean z;
        boolean z2 = true;
        C1026d.C1027a aVar2 = aVar.mo11652oS().get(C0929b.FUNCTION.toString());
        if (aVar2 == null) {
            C2028bh.m6816T("No function id in properties");
            return aqH;
        }
        String str = aVar2.f3078gA;
        C1998aj ajVar = map.get(str);
        if (ajVar == null) {
            C2028bh.m6816T(str + " has no backing implementation.");
            return aqH;
        }
        C2047bz<C1026d.C1027a> bzVar = this.aqN.get(aVar);
        if (bzVar != null && !this.aqJ.mo11547oo()) {
            return bzVar;
        }
        HashMap hashMap = new HashMap();
        boolean z3 = true;
        for (Map.Entry next : aVar.mo11652oS().entrySet()) {
            C2047bz<C1026d.C1027a> a = m7004a((C1026d.C1027a) next.getValue(), set, ckVar.mo11593cE((String) next.getKey()).mo11595e((C1026d.C1027a) next.getValue()));
            if (a == aqH) {
                return aqH;
            }
            if (a.mo11613oE()) {
                aVar.mo11651a((String) next.getKey(), a.getObject());
                z = z3;
            } else {
                z = false;
            }
            hashMap.put(next.getKey(), a.getObject());
            z3 = z;
        }
        if (!ajVar.mo11548a(hashMap.keySet())) {
            C2028bh.m6816T("Incorrect keys for function " + str + " required " + ajVar.mo11550oq() + " had " + hashMap.keySet());
            return aqH;
        }
        if (!z3 || !ajVar.mo11538nL()) {
            z2 = false;
        }
        C2047bz<C1026d.C1027a> bzVar2 = new C2047bz<>(ajVar.mo11537C(hashMap), z2);
        if (z2) {
            this.aqN.mo11569e(aVar, bzVar2);
        }
        ckVar.mo11594d(bzVar2.getObject());
        return bzVar2;
    }

    /* renamed from: a */
    private C2047bz<Set<C2075cr.C2077a>> m7007a(Set<C2075cr.C2081e> set, Set<String> set2, C2090a aVar, C2084cs csVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = true;
        for (C2075cr.C2081e next : set) {
            C2065cn oC = csVar.mo11605oC();
            C2047bz<Boolean> a = mo11690a(next, set2, oC);
            if (a.getObject().booleanValue()) {
                aVar.mo11704a(next, hashSet, hashSet2, oC);
            }
            z = z && a.mo11613oE();
        }
        hashSet.removeAll(hashSet2);
        csVar.mo11604b(hashSet);
        return new C2047bz<>(hashSet, z);
    }

    /* renamed from: a */
    private void m7008a(C1026d.C1027a aVar, Set<String> set) {
        C2047bz<C1026d.C1027a> a;
        if (aVar != null && (a = m7004a(aVar, set, (C2117dl) new C2045bx())) != aqH) {
            Object o = C2114di.m7111o(a.getObject());
            if (o instanceof Map) {
                this.anS.push((Map) o);
            } else if (o instanceof List) {
                for (Object next : (List) o) {
                    if (next instanceof Map) {
                        this.anS.push((Map) next);
                    } else {
                        C2028bh.m6819W("pushAfterEvaluate: value not a Map");
                    }
                }
            } else {
                C2028bh.m6819W("pushAfterEvaluate: value not a Map or List");
            }
        }
    }

    /* renamed from: a */
    private static void m7009a(List<C2075cr.C2077a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            C2028bh.m6817U("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    /* renamed from: a */
    private static void m7010a(Map<String, C1998aj> map, C1998aj ajVar) {
        if (map.containsKey(ajVar.mo11549op())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.mo11549op());
        }
        map.put(ajVar.mo11549op(), ajVar);
    }

    /* renamed from: e */
    private static C2092c m7011e(Map<String, C2092c> map, String str) {
        C2092c cVar = map.get(str);
        if (cVar != null) {
            return cVar;
        }
        C2092c cVar2 = new C2092c();
        map.put(str, cVar2);
        return cVar2;
    }

    /* renamed from: h */
    private static String m7012h(C2075cr.C2077a aVar) {
        return C2114di.m7106j(aVar.mo11652oS().get(C0929b.INSTANCE_NAME.toString()));
    }

    /* renamed from: pm */
    private String m7013pm() {
        if (this.aqS <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.aqS));
        for (int i = 2; i < this.aqS; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2047bz<Boolean> mo11689a(C2075cr.C2077a aVar, Set<String> set, C2062ck ckVar) {
        C2047bz<C1026d.C1027a> a = m7006a(this.aqL, aVar, set, ckVar);
        Boolean n = C2114di.m7110n(a.getObject());
        ckVar.mo11594d(C2114di.m7124u(n));
        return new C2047bz<>(n, a.mo11613oE());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2047bz<Boolean> mo11690a(C2075cr.C2081e eVar, Set<String> set, C2065cn cnVar) {
        boolean z;
        boolean z2 = true;
        for (C2075cr.C2077a a : eVar.mo11668pb()) {
            C2047bz<Boolean> a2 = mo11689a(a, set, cnVar.mo11599ow());
            if (a2.getObject().booleanValue()) {
                cnVar.mo11596f(C2114di.m7124u(false));
                return new C2047bz<>(false, a2.mo11613oE());
            }
            z2 = z && a2.mo11613oE();
        }
        for (C2075cr.C2077a a3 : eVar.mo11667pa()) {
            C2047bz<Boolean> a4 = mo11689a(a3, set, cnVar.mo11600ox());
            if (!a4.getObject().booleanValue()) {
                cnVar.mo11596f(C2114di.m7124u(false));
                return new C2047bz<>(false, a4.mo11613oE());
            }
            z = z && a4.mo11613oE();
        }
        cnVar.mo11596f(C2114di.m7124u(true));
        return new C2047bz<>(true, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2047bz<Set<C2075cr.C2077a>> mo11691a(String str, Set<C2075cr.C2081e> set, Map<C2075cr.C2081e, List<C2075cr.C2077a>> map, Map<C2075cr.C2081e, List<String>> map2, Map<C2075cr.C2081e, List<C2075cr.C2077a>> map3, Map<C2075cr.C2081e, List<String>> map4, Set<String> set2, C2084cs csVar) {
        final Map<C2075cr.C2081e, List<C2075cr.C2077a>> map5 = map;
        final Map<C2075cr.C2081e, List<String>> map6 = map2;
        final Map<C2075cr.C2081e, List<C2075cr.C2077a>> map7 = map3;
        final Map<C2075cr.C2081e, List<String>> map8 = map4;
        return m7007a(set, set2, (C2090a) new C2090a() {
            /* renamed from: a */
            public void mo11704a(C2075cr.C2081e eVar, Set<C2075cr.C2077a> set, Set<C2075cr.C2077a> set2, C2065cn cnVar) {
                List list = (List) map5.get(eVar);
                List list2 = (List) map6.get(eVar);
                if (list != null) {
                    set.addAll(list);
                    cnVar.mo11601oy().mo11603c(list, list2);
                }
                List list3 = (List) map7.get(eVar);
                List list4 = (List) map8.get(eVar);
                if (list3 != null) {
                    set2.addAll(list3);
                    cnVar.mo11602oz().mo11603c(list3, list4);
                }
            }
        }, csVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2047bz<Set<C2075cr.C2077a>> mo11692a(Set<C2075cr.C2081e> set, C2084cs csVar) {
        return m7007a(set, (Set<String>) new HashSet(), (C2090a) new C2090a() {
            /* renamed from: a */
            public void mo11704a(C2075cr.C2081e eVar, Set<C2075cr.C2077a> set, Set<C2075cr.C2077a> set2, C2065cn cnVar) {
                set.addAll(eVar.mo11669pc());
                set2.addAll(eVar.mo11670pd());
                cnVar.mo11597oA().mo11603c(eVar.mo11669pc(), eVar.mo11674ph());
                cnVar.mo11598oB().mo11603c(eVar.mo11670pd(), eVar.mo11675pi());
            }
        }, csVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo11693a(C1998aj ajVar) {
        m7010a(this.aqM, ajVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11694b(C1998aj ajVar) {
        m7010a(this.aqK, ajVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo11695c(C1998aj ajVar) {
        m7010a(this.aqL, ajVar);
    }

    /* renamed from: cO */
    public C2047bz<C1026d.C1027a> mo11696cO(String str) {
        this.aqS = 0;
        C1994af cx = this.aqJ.mo11545cx(str);
        C2047bz<C1026d.C1027a> a = m7005a(str, (Set<String>) new HashSet(), cx.mo11542ol());
        cx.mo11544on();
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cP */
    public synchronized void mo11697cP(String str) {
        this.aqR = str;
    }

    /* renamed from: cm */
    public synchronized void mo11698cm(String str) {
        mo11697cP(str);
        C1994af cy = this.aqJ.mo11546cy(str);
        C2149t om = cy.mo11543om();
        for (C2075cr.C2077a a : mo11692a(this.aqP, om.mo11592of()).getObject()) {
            m7006a(this.aqK, a, (Set<String>) new HashSet(), om.mo11591oe());
        }
        cy.mo11544on();
        mo11697cP((String) null);
    }

    /* renamed from: k */
    public synchronized void mo11699k(List<C0976c.C0985i> list) {
        for (C0976c.C0985i next : list) {
            if (next.name == null || !next.name.startsWith("gaExperiment:")) {
                C2028bh.m6818V("Ignored supplemental: " + next);
            } else {
                C1997ai.m6746a(this.anS, next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: pl */
    public synchronized String mo11700pl() {
        return this.aqR;
    }
}
