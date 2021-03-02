package com.google.android.gms.tagmanager;

import com.google.android.gms.p018c.C0611a;
import com.google.android.gms.p018c.C0647bi;
import com.google.android.gms.p018c.C0648bj;
import com.google.android.gms.p018c.C0649bk;
import com.google.android.gms.p018c.C0661c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.ap */
class C1283ap {

    /* renamed from: a */
    private static final C1275ah<C0661c> f5315a = new C1275ah<>(C1298bd.m5351a(), true);

    /* renamed from: b */
    private final C1326q f5316b;

    /* renamed from: c */
    private final Map<String, C1327r> f5317c;

    /* renamed from: d */
    private final Map<String, C1327r> f5318d;

    /* renamed from: e */
    private final Map<String, C1327r> f5319e;

    /* renamed from: f */
    private final C1301bg<C0648bj, C1275ah<C0661c>> f5320f;

    /* renamed from: g */
    private final C1301bg<String, C1287at> f5321g;

    /* renamed from: h */
    private final Set<C0649bk> f5322h;

    /* renamed from: i */
    private final C1294b f5323i;

    /* renamed from: j */
    private final Map<String, C1288au> f5324j;

    /* renamed from: k */
    private volatile String f5325k;

    /* renamed from: l */
    private int f5326l;

    /* renamed from: a */
    private C1275ah<C0661c> m5296a(C0661c cVar, Set<String> set, C1299be beVar) {
        if (!cVar.f4358l) {
            return new C1275ah<>(cVar, true);
        }
        switch (cVar.f4347a) {
            case 2:
                C0661c a = C0647bi.m3743a(cVar);
                a.f4349c = new C0661c[cVar.f4349c.length];
                for (int i = 0; i < cVar.f4349c.length; i++) {
                    C1275ah<C0661c> a2 = m5296a(cVar.f4349c[i], set, beVar.mo9087a(i));
                    if (a2 == f5315a) {
                        return f5315a;
                    }
                    a.f4349c[i] = a2.mo9092a();
                }
                return new C1275ah<>(a, false);
            case 3:
                C0661c a3 = C0647bi.m3743a(cVar);
                if (cVar.f4350d.length != cVar.f4351e.length) {
                    C1333x.m5440a("Invalid serving value: " + cVar.toString());
                    return f5315a;
                }
                a3.f4350d = new C0661c[cVar.f4350d.length];
                a3.f4351e = new C0661c[cVar.f4350d.length];
                for (int i2 = 0; i2 < cVar.f4350d.length; i2++) {
                    C1275ah<C0661c> a4 = m5296a(cVar.f4350d[i2], set, beVar.mo9089b(i2));
                    C1275ah<C0661c> a5 = m5296a(cVar.f4351e[i2], set, beVar.mo9090c(i2));
                    if (a4 == f5315a || a5 == f5315a) {
                        return f5315a;
                    }
                    a3.f4350d[i2] = a4.mo9092a();
                    a3.f4351e[i2] = a5.mo9092a();
                }
                return new C1275ah<>(a3, false);
            case 4:
                if (set.contains(cVar.f4352f)) {
                    C1333x.m5440a("Macro cycle detected.  Current macro reference: " + cVar.f4352f + "." + "  Previous macro references: " + set.toString() + ".");
                    return f5315a;
                }
                set.add(cVar.f4352f);
                C1275ah<C0661c> a6 = C1300bf.m5369a(m5297a(cVar.f4352f, set, beVar.mo9088a()), cVar.f4357k);
                set.remove(cVar.f4352f);
                return a6;
            case 7:
                C0661c a7 = C0647bi.m3743a(cVar);
                a7.f4356j = new C0661c[cVar.f4356j.length];
                for (int i3 = 0; i3 < cVar.f4356j.length; i3++) {
                    C1275ah<C0661c> a8 = m5296a(cVar.f4356j[i3], set, beVar.mo9091d(i3));
                    if (a8 == f5315a) {
                        return f5315a;
                    }
                    a7.f4356j[i3] = a8.mo9092a();
                }
                return new C1275ah<>(a7, false);
            default:
                C1333x.m5440a("Unknown type: " + cVar.f4347a);
                return f5315a;
        }
    }

    /* renamed from: a */
    private C1275ah<C0661c> m5297a(String str, Set<String> set, C1335z zVar) {
        C0648bj bjVar;
        this.f5326l++;
        C1287at a = this.f5321g.mo9140a(str);
        if (a == null || this.f5316b.mo9179a()) {
            C1288au auVar = this.f5324j.get(str);
            if (auVar == null) {
                C1333x.m5440a(m5300a() + "Invalid macro: " + str);
                this.f5326l--;
                return f5315a;
            }
            C1275ah<Set<C0648bj>> a2 = mo9101a(str, auVar.mo9108a(), auVar.mo9109b(), auVar.mo9110c(), auVar.mo9112e(), auVar.mo9111d(), set, zVar.mo9073b());
            if (a2.mo9092a().isEmpty()) {
                bjVar = auVar.mo9113f();
            } else {
                if (a2.mo9092a().size() > 1) {
                    C1333x.m5442b(m5300a() + "Multiple macros active for macroName " + str);
                }
                bjVar = (C0648bj) a2.mo9092a().iterator().next();
            }
            if (bjVar == null) {
                this.f5326l--;
                return f5315a;
            }
            C1275ah<C0661c> a3 = m5298a(this.f5319e, bjVar, set, zVar.mo9072a());
            C1275ah<C0661c> ahVar = a3 == f5315a ? f5315a : new C1275ah<>(a3.mo9092a(), a2.mo9093b() && a3.mo9093b());
            C0661c b = bjVar.mo7134b();
            if (ahVar.mo9093b()) {
                this.f5321g.mo9141a(str, new C1287at(ahVar, b));
            }
            m5301a(b, set);
            this.f5326l--;
            return ahVar;
        }
        m5301a(a.mo9107b(), set);
        this.f5326l--;
        return a.mo9106a();
    }

    /* renamed from: a */
    private C1275ah<C0661c> m5298a(Map<String, C1327r> map, C0648bj bjVar, Set<String> set, C1278ak akVar) {
        boolean z;
        boolean z2 = true;
        C0661c cVar = bjVar.mo7132a().get(C0611a.FUNCTION.toString());
        if (cVar == null) {
            C1333x.m5440a("No function id in properties");
            return f5315a;
        }
        String str = cVar.f4353g;
        C1327r rVar = map.get(str);
        if (rVar == null) {
            C1333x.m5440a(str + " has no backing implementation.");
            return f5315a;
        }
        C1275ah<C0661c> a = this.f5320f.mo9140a(bjVar);
        if (a != null && !this.f5316b.mo9179a()) {
            return a;
        }
        HashMap hashMap = new HashMap();
        boolean z3 = true;
        for (Map.Entry next : bjVar.mo7132a().entrySet()) {
            C1275ah<C0661c> a2 = m5296a((C0661c) next.getValue(), set, akVar.mo9074a((String) next.getKey()).mo9076a((C0661c) next.getValue()));
            if (a2 == f5315a) {
                return f5315a;
            }
            if (a2.mo9093b()) {
                bjVar.mo7133a((String) next.getKey(), a2.mo9092a());
                z = z3;
            } else {
                z = false;
            }
            hashMap.put(next.getKey(), a2.mo9092a());
            z3 = z;
        }
        if (!rVar.mo9182a((Set<String>) hashMap.keySet())) {
            C1333x.m5440a("Incorrect keys for function " + str + " required " + rVar.mo9183b() + " had " + hashMap.keySet());
            return f5315a;
        }
        if (!z3 || !rVar.mo9181a()) {
            z2 = false;
        }
        C1275ah<C0661c> ahVar = new C1275ah<>(rVar.mo9180a((Map<String, C0661c>) hashMap), z2);
        if (z2) {
            this.f5320f.mo9141a(bjVar, ahVar);
        }
        akVar.mo9075a(ahVar.mo9092a());
        return ahVar;
    }

    /* renamed from: a */
    private C1275ah<Set<C0648bj>> m5299a(Set<C0649bk> set, Set<String> set2, C1286as asVar, C1282ao aoVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = true;
        for (C0649bk next : set) {
            C1281an a = aoVar.mo9085a();
            C1275ah<Boolean> a2 = mo9100a(next, set2, a);
            if (a2.mo9092a().booleanValue()) {
                asVar.mo9105a(next, hashSet, hashSet2, a);
            }
            z = z && a2.mo9093b();
        }
        hashSet.removeAll(hashSet2);
        aoVar.mo9086a(hashSet);
        return new C1275ah<>(hashSet, z);
    }

    /* renamed from: a */
    private String m5300a() {
        if (this.f5326l <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.f5326l));
        for (int i = 2; i < this.f5326l; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    /* renamed from: a */
    private void m5301a(C0661c cVar, Set<String> set) {
        C1275ah<C0661c> a;
        if (cVar != null && (a = m5296a(cVar, set, (C1299be) new C1274ag())) != f5315a) {
            Object c = C1298bd.m5358c(a.mo9092a());
            if (c instanceof Map) {
                this.f5323i.mo9119a((Map<String, Object>) (Map) c);
            } else if (c instanceof List) {
                for (Object next : (List) c) {
                    if (next instanceof Map) {
                        this.f5323i.mo9119a((Map<String, Object>) (Map) next);
                    } else {
                        C1333x.m5442b("pushAfterEvaluate: value not a Map");
                    }
                }
            } else {
                C1333x.m5442b("pushAfterEvaluate: value not a Map or List");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1275ah<Boolean> mo9099a(C0648bj bjVar, Set<String> set, C1278ak akVar) {
        C1275ah<C0661c> a = m5298a(this.f5318d, bjVar, set, akVar);
        Boolean b = C1298bd.m5355b(a.mo9092a());
        akVar.mo9075a(C1298bd.m5357c((Object) b));
        return new C1275ah<>(b, a.mo9093b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1275ah<Boolean> mo9100a(C0649bk bkVar, Set<String> set, C1281an anVar) {
        boolean z;
        boolean z2 = true;
        for (C0648bj a : bkVar.mo7137b()) {
            C1275ah<Boolean> a2 = mo9099a(a, set, anVar.mo9077a());
            if (a2.mo9092a().booleanValue()) {
                anVar.mo9078a(C1298bd.m5357c((Object) false));
                return new C1275ah<>(false, a2.mo9093b());
            }
            z2 = z && a2.mo9093b();
        }
        for (C0648bj a3 : bkVar.mo7136a()) {
            C1275ah<Boolean> a4 = mo9099a(a3, set, anVar.mo9079b());
            if (!a4.mo9092a().booleanValue()) {
                anVar.mo9078a(C1298bd.m5357c((Object) false));
                return new C1275ah<>(false, a4.mo9093b());
            }
            z = z && a4.mo9093b();
        }
        anVar.mo9078a(C1298bd.m5357c((Object) true));
        return new C1275ah<>(true, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1275ah<Set<C0648bj>> mo9101a(String str, Set<C0649bk> set, Map<C0649bk, List<C0648bj>> map, Map<C0649bk, List<String>> map2, Map<C0649bk, List<C0648bj>> map3, Map<C0649bk, List<String>> map4, Set<String> set2, C1282ao aoVar) {
        return m5299a(set, set2, (C1286as) new C1284aq(this, map, map2, map3, map4), aoVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1275ah<Set<C0648bj>> mo9102a(Set<C0649bk> set, C1282ao aoVar) {
        return m5299a(set, (Set<String>) new HashSet(), (C1286as) new C1285ar(this), aoVar);
    }

    /* renamed from: a */
    public synchronized void mo9103a(String str) {
        mo9104b(str);
        C1325p a = this.f5316b.mo9178a(str);
        C1305bk a2 = a.mo9176a();
        for (C0648bj a3 : mo9102a(this.f5322h, a2.mo9151b()).mo9092a()) {
            m5298a(this.f5317c, a3, (Set<String>) new HashSet(), a2.mo9150a());
        }
        a.mo9177b();
        mo9104b((String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo9104b(String str) {
        this.f5325k = str;
    }
}
