package com.google.android.gms.tagmanager;

import com.google.android.gms.p018c.C0648bj;
import com.google.android.gms.p018c.C0649bk;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.aq */
class C1284aq implements C1286as {

    /* renamed from: a */
    final /* synthetic */ Map f5327a;

    /* renamed from: b */
    final /* synthetic */ Map f5328b;

    /* renamed from: c */
    final /* synthetic */ Map f5329c;

    /* renamed from: d */
    final /* synthetic */ Map f5330d;

    /* renamed from: e */
    final /* synthetic */ C1283ap f5331e;

    C1284aq(C1283ap apVar, Map map, Map map2, Map map3, Map map4) {
        this.f5331e = apVar;
        this.f5327a = map;
        this.f5328b = map2;
        this.f5329c = map3;
        this.f5330d = map4;
    }

    /* renamed from: a */
    public void mo9105a(C0649bk bkVar, Set<C0648bj> set, Set<C0648bj> set2, C1281an anVar) {
        List list = (List) this.f5327a.get(bkVar);
        List list2 = (List) this.f5328b.get(bkVar);
        if (list != null) {
            set.addAll(list);
            anVar.mo9080c().mo9084a(list, list2);
        }
        List list3 = (List) this.f5329c.get(bkVar);
        List list4 = (List) this.f5330d.get(bkVar);
        if (list3 != null) {
            set2.addAll(list3);
            anVar.mo9081d().mo9084a(list3, list4);
        }
    }
}
