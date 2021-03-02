package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.internal.C1026d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.cr */
class C2075cr {

    /* renamed from: com.google.android.gms.tagmanager.cr$a */
    public static class C2077a {
        private final Map<String, C1026d.C1027a> aqs;
        private final C1026d.C1027a aqt;

        private C2077a(Map<String, C1026d.C1027a> map, C1026d.C1027a aVar) {
            this.aqs = map;
            this.aqt = aVar;
        }

        /* renamed from: oR */
        public static C2078b m6965oR() {
            return new C2078b();
        }

        /* renamed from: a */
        public void mo11651a(String str, C1026d.C1027a aVar) {
            this.aqs.put(str, aVar);
        }

        /* renamed from: oS */
        public Map<String, C1026d.C1027a> mo11652oS() {
            return Collections.unmodifiableMap(this.aqs);
        }

        /* renamed from: oT */
        public C1026d.C1027a mo11653oT() {
            return this.aqt;
        }

        public String toString() {
            return "Properties: " + mo11652oS() + " pushAfterEvaluate: " + this.aqt;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$b */
    public static class C2078b {
        private final Map<String, C1026d.C1027a> aqs;
        private C1026d.C1027a aqt;

        private C2078b() {
            this.aqs = new HashMap();
        }

        /* renamed from: b */
        public C2078b mo11655b(String str, C1026d.C1027a aVar) {
            this.aqs.put(str, aVar);
            return this;
        }

        /* renamed from: i */
        public C2078b mo11656i(C1026d.C1027a aVar) {
            this.aqt = aVar;
            return this;
        }

        /* renamed from: oU */
        public C2077a mo11657oU() {
            return new C2077a(this.aqs, this.aqt);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$c */
    public static class C2079c {

        /* renamed from: Sq */
        private final String f4571Sq;
        private final List<C2081e> aqu;
        private final Map<String, List<C2077a>> aqv;
        private final int aqw;

        private C2079c(List<C2081e> list, Map<String, List<C2077a>> map, String str, int i) {
            this.aqu = Collections.unmodifiableList(list);
            this.aqv = Collections.unmodifiableMap(map);
            this.f4571Sq = str;
            this.aqw = i;
        }

        /* renamed from: oV */
        public static C2080d m6972oV() {
            return new C2080d();
        }

        public String getVersion() {
            return this.f4571Sq;
        }

        /* renamed from: oW */
        public List<C2081e> mo11659oW() {
            return this.aqu;
        }

        /* renamed from: oX */
        public Map<String, List<C2077a>> mo11660oX() {
            return this.aqv;
        }

        public String toString() {
            return "Rules: " + mo11659oW() + "  Macros: " + this.aqv;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$d */
    public static class C2080d {

        /* renamed from: Sq */
        private String f4572Sq;
        private final List<C2081e> aqu;
        private final Map<String, List<C2077a>> aqv;
        private int aqw;

        private C2080d() {
            this.aqu = new ArrayList();
            this.aqv = new HashMap();
            this.f4572Sq = "";
            this.aqw = 0;
        }

        /* renamed from: a */
        public C2080d mo11662a(C2077a aVar) {
            String j = C2114di.m7106j(aVar.mo11652oS().get(C0929b.INSTANCE_NAME.toString()));
            List list = this.aqv.get(j);
            if (list == null) {
                list = new ArrayList();
                this.aqv.put(j, list);
            }
            list.add(aVar);
            return this;
        }

        /* renamed from: a */
        public C2080d mo11663a(C2081e eVar) {
            this.aqu.add(eVar);
            return this;
        }

        /* renamed from: cJ */
        public C2080d mo11664cJ(String str) {
            this.f4572Sq = str;
            return this;
        }

        /* renamed from: fl */
        public C2080d mo11665fl(int i) {
            this.aqw = i;
            return this;
        }

        /* renamed from: oY */
        public C2079c mo11666oY() {
            return new C2079c(this.aqu, this.aqv, this.f4572Sq, this.aqw);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$e */
    public static class C2081e {
        private final List<C2077a> aqA;
        private final List<C2077a> aqB;
        private final List<C2077a> aqC;
        private final List<String> aqD;
        private final List<String> aqE;
        private final List<String> aqF;
        private final List<String> aqG;
        private final List<C2077a> aqx;
        private final List<C2077a> aqy;
        private final List<C2077a> aqz;

        private C2081e(List<C2077a> list, List<C2077a> list2, List<C2077a> list3, List<C2077a> list4, List<C2077a> list5, List<C2077a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.aqx = Collections.unmodifiableList(list);
            this.aqy = Collections.unmodifiableList(list2);
            this.aqz = Collections.unmodifiableList(list3);
            this.aqA = Collections.unmodifiableList(list4);
            this.aqB = Collections.unmodifiableList(list5);
            this.aqC = Collections.unmodifiableList(list6);
            this.aqD = Collections.unmodifiableList(list7);
            this.aqE = Collections.unmodifiableList(list8);
            this.aqF = Collections.unmodifiableList(list9);
            this.aqG = Collections.unmodifiableList(list10);
        }

        /* renamed from: oZ */
        public static C2082f m6980oZ() {
            return new C2082f();
        }

        /* renamed from: pa */
        public List<C2077a> mo11667pa() {
            return this.aqx;
        }

        /* renamed from: pb */
        public List<C2077a> mo11668pb() {
            return this.aqy;
        }

        /* renamed from: pc */
        public List<C2077a> mo11669pc() {
            return this.aqz;
        }

        /* renamed from: pd */
        public List<C2077a> mo11670pd() {
            return this.aqA;
        }

        /* renamed from: pe */
        public List<C2077a> mo11671pe() {
            return this.aqB;
        }

        /* renamed from: pf */
        public List<String> mo11672pf() {
            return this.aqD;
        }

        /* renamed from: pg */
        public List<String> mo11673pg() {
            return this.aqE;
        }

        /* renamed from: ph */
        public List<String> mo11674ph() {
            return this.aqF;
        }

        /* renamed from: pi */
        public List<String> mo11675pi() {
            return this.aqG;
        }

        /* renamed from: pj */
        public List<C2077a> mo11676pj() {
            return this.aqC;
        }

        public String toString() {
            return "Positive predicates: " + mo11667pa() + "  Negative predicates: " + mo11668pb() + "  Add tags: " + mo11669pc() + "  Remove tags: " + mo11670pd() + "  Add macros: " + mo11671pe() + "  Remove macros: " + mo11676pj();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$f */
    public static class C2082f {
        private final List<C2077a> aqA;
        private final List<C2077a> aqB;
        private final List<C2077a> aqC;
        private final List<String> aqD;
        private final List<String> aqE;
        private final List<String> aqF;
        private final List<String> aqG;
        private final List<C2077a> aqx;
        private final List<C2077a> aqy;
        private final List<C2077a> aqz;

        private C2082f() {
            this.aqx = new ArrayList();
            this.aqy = new ArrayList();
            this.aqz = new ArrayList();
            this.aqA = new ArrayList();
            this.aqB = new ArrayList();
            this.aqC = new ArrayList();
            this.aqD = new ArrayList();
            this.aqE = new ArrayList();
            this.aqF = new ArrayList();
            this.aqG = new ArrayList();
        }

        /* renamed from: b */
        public C2082f mo11678b(C2077a aVar) {
            this.aqx.add(aVar);
            return this;
        }

        /* renamed from: c */
        public C2082f mo11679c(C2077a aVar) {
            this.aqy.add(aVar);
            return this;
        }

        /* renamed from: cK */
        public C2082f mo11680cK(String str) {
            this.aqF.add(str);
            return this;
        }

        /* renamed from: cL */
        public C2082f mo11681cL(String str) {
            this.aqG.add(str);
            return this;
        }

        /* renamed from: cM */
        public C2082f mo11682cM(String str) {
            this.aqD.add(str);
            return this;
        }

        /* renamed from: cN */
        public C2082f mo11683cN(String str) {
            this.aqE.add(str);
            return this;
        }

        /* renamed from: d */
        public C2082f mo11684d(C2077a aVar) {
            this.aqz.add(aVar);
            return this;
        }

        /* renamed from: e */
        public C2082f mo11685e(C2077a aVar) {
            this.aqA.add(aVar);
            return this;
        }

        /* renamed from: f */
        public C2082f mo11686f(C2077a aVar) {
            this.aqB.add(aVar);
            return this;
        }

        /* renamed from: g */
        public C2082f mo11687g(C2077a aVar) {
            this.aqC.add(aVar);
            return this;
        }

        /* renamed from: pk */
        public C2081e mo11688pk() {
            return new C2081e(this.aqx, this.aqy, this.aqz, this.aqA, this.aqB, this.aqC, this.aqD, this.aqE, this.aqF, this.aqG);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$g */
    public static class C2083g extends Exception {
        public C2083g(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static C1026d.C1027a m6956a(int i, C0976c.C0982f fVar, C1026d.C1027a[] aVarArr, Set<Integer> set) throws C2083g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            m6962cI("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C1026d.C1027a aVar = (C1026d.C1027a) m6959a(fVar.f2970fG, i, "values");
        if (aVarArr[i] != null) {
            return aVarArr[i];
        }
        C1026d.C1027a aVar2 = null;
        set.add(Integer.valueOf(i));
        switch (aVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                aVar2 = aVar;
                break;
            case 2:
                C0976c.C0984h h = m6964h(aVar);
                aVar2 = m6963g(aVar);
                aVar2.f3085gw = new C1026d.C1027a[h.f2997gh.length];
                int[] iArr = h.f2997gh;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    aVar2.f3085gw[i3] = m6956a(iArr[i2], fVar, aVarArr, set);
                    i2++;
                    i3++;
                }
                break;
            case 3:
                aVar2 = m6963g(aVar);
                C0976c.C0984h h2 = m6964h(aVar);
                if (h2.f2998gi.length != h2.f2999gj.length) {
                    m6962cI("Uneven map keys (" + h2.f2998gi.length + ") and map values (" + h2.f2999gj.length + ")");
                }
                aVar2.f3086gx = new C1026d.C1027a[h2.f2998gi.length];
                aVar2.f3087gy = new C1026d.C1027a[h2.f2998gi.length];
                int[] iArr2 = h2.f2998gi;
                int length2 = iArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2) {
                    aVar2.f3086gx[i5] = m6956a(iArr2[i4], fVar, aVarArr, set);
                    i4++;
                    i5++;
                }
                int[] iArr3 = h2.f2999gj;
                int length3 = iArr3.length;
                int i6 = 0;
                while (i2 < length3) {
                    aVar2.f3087gy[i6] = m6956a(iArr3[i2], fVar, aVarArr, set);
                    i2++;
                    i6++;
                }
                break;
            case 4:
                aVar2 = m6963g(aVar);
                aVar2.f3088gz = C2114di.m7106j(m6956a(m6964h(aVar).f3002gm, fVar, aVarArr, set));
                break;
            case 7:
                aVar2 = m6963g(aVar);
                C0976c.C0984h h3 = m6964h(aVar);
                aVar2.f3081gD = new C1026d.C1027a[h3.f3001gl.length];
                int[] iArr4 = h3.f3001gl;
                int length4 = iArr4.length;
                int i7 = 0;
                while (i2 < length4) {
                    aVar2.f3081gD[i7] = m6956a(iArr4[i2], fVar, aVarArr, set);
                    i2++;
                    i7++;
                }
                break;
        }
        if (aVar2 == null) {
            m6962cI("Invalid value: " + aVar);
        }
        aVarArr[i] = aVar2;
        set.remove(Integer.valueOf(i));
        return aVar2;
    }

    /* renamed from: a */
    private static C2077a m6957a(C0976c.C0978b bVar, C0976c.C0982f fVar, C1026d.C1027a[] aVarArr, int i) throws C2083g {
        C2078b oR = C2077a.m6965oR();
        for (int valueOf : bVar.f2954fq) {
            C0976c.C0981e eVar = (C0976c.C0981e) m6959a(fVar.f2971fH, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m6959a(fVar.f2969fF, eVar.key, "keys");
            C1026d.C1027a aVar = (C1026d.C1027a) m6959a(aVarArr, eVar.value, "values");
            if (C0929b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                oR.mo11656i(aVar);
            } else {
                oR.mo11655b(str, aVar);
            }
        }
        return oR.mo11657oU();
    }

    /* renamed from: a */
    private static C2081e m6958a(C0976c.C0983g gVar, List<C2077a> list, List<C2077a> list2, List<C2077a> list3, C0976c.C0982f fVar) {
        C2082f oZ = C2081e.m6980oZ();
        for (int valueOf : gVar.f2985fV) {
            oZ.mo11678b(list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : gVar.f2986fW) {
            oZ.mo11679c(list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf3 : gVar.f2987fX) {
            oZ.mo11684d(list.get(Integer.valueOf(valueOf3).intValue()));
        }
        for (int valueOf4 : gVar.f2989fZ) {
            oZ.mo11680cK(fVar.f2970fG[Integer.valueOf(valueOf4).intValue()].f3084gv);
        }
        for (int valueOf5 : gVar.f2988fY) {
            oZ.mo11685e(list.get(Integer.valueOf(valueOf5).intValue()));
        }
        for (int valueOf6 : gVar.f2990ga) {
            oZ.mo11681cL(fVar.f2970fG[Integer.valueOf(valueOf6).intValue()].f3084gv);
        }
        for (int valueOf7 : gVar.f2991gb) {
            oZ.mo11686f(list2.get(Integer.valueOf(valueOf7).intValue()));
        }
        for (int valueOf8 : gVar.f2993gd) {
            oZ.mo11682cM(fVar.f2970fG[Integer.valueOf(valueOf8).intValue()].f3084gv);
        }
        for (int valueOf9 : gVar.f2992gc) {
            oZ.mo11687g(list2.get(Integer.valueOf(valueOf9).intValue()));
        }
        for (int valueOf10 : gVar.f2994ge) {
            oZ.mo11683cN(fVar.f2970fG[Integer.valueOf(valueOf10).intValue()].f3084gv);
        }
        return oZ.mo11688pk();
    }

    /* renamed from: a */
    private static <T> T m6959a(T[] tArr, int i, String str) throws C2083g {
        if (i < 0 || i >= tArr.length) {
            m6962cI("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    /* renamed from: b */
    public static C2079c m6960b(C0976c.C0982f fVar) throws C2083g {
        C1026d.C1027a[] aVarArr = new C1026d.C1027a[fVar.f2970fG.length];
        for (int i = 0; i < fVar.f2970fG.length; i++) {
            m6956a(i, fVar, aVarArr, (Set<Integer>) new HashSet(0));
        }
        C2080d oV = C2079c.m6972oV();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < fVar.f2973fJ.length; i2++) {
            arrayList.add(m6957a(fVar.f2973fJ[i2], fVar, aVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < fVar.f2974fK.length; i3++) {
            arrayList2.add(m6957a(fVar.f2974fK[i3], fVar, aVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < fVar.f2972fI.length; i4++) {
            C2077a a = m6957a(fVar.f2972fI[i4], fVar, aVarArr, i4);
            oV.mo11662a(a);
            arrayList3.add(a);
        }
        for (C0976c.C0983g a2 : fVar.f2975fL) {
            oV.mo11663a(m6958a(a2, arrayList, arrayList3, arrayList2, fVar));
        }
        oV.mo11664cJ(fVar.version);
        oV.mo11665fl(fVar.f2983fT);
        return oV.mo11666oY();
    }

    /* renamed from: b */
    public static void m6961b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: cI */
    private static void m6962cI(String str) throws C2083g {
        C2028bh.m6816T(str);
        throw new C2083g(str);
    }

    /* renamed from: g */
    public static C1026d.C1027a m6963g(C1026d.C1027a aVar) {
        C1026d.C1027a aVar2 = new C1026d.C1027a();
        aVar2.type = aVar.type;
        aVar2.f3082gE = (int[]) aVar.f3082gE.clone();
        if (aVar.f3083gF) {
            aVar2.f3083gF = aVar.f3083gF;
        }
        return aVar2;
    }

    /* renamed from: h */
    private static C0976c.C0984h m6964h(C1026d.C1027a aVar) throws C2083g {
        if (((C0976c.C0984h) aVar.mo10079a(C0976c.C0984h.f2995gf)) == null) {
            m6962cI("Expected a ServingValue and didn't get one. Value is: " + aVar);
        }
        return (C0976c.C0984h) aVar.mo10079a(C0976c.C0984h.f2995gf);
    }
}
