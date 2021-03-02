package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.common.api.ag */
class C0709ag extends C0712aj {

    /* renamed from: a */
    final /* synthetic */ C0758w f4438a;

    /* renamed from: c */
    private final ArrayList<C0743h> f4439c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0709ag(C0758w wVar, ArrayList<C0743h> arrayList) {
        super(wVar, (C0759x) null);
        this.f4438a = wVar;
        this.f4439c = arrayList;
    }

    /* renamed from: a */
    public void mo7357a() {
        Set<Scope> set = this.f4438a.f4533a.f4451f;
        Set<Scope> h = set.isEmpty() ? this.f4438a.m4162m() : set;
        Iterator<C0743h> it = this.f4439c.iterator();
        while (it.hasNext()) {
            it.next().mo7435a(this.f4438a.f4548p, h);
        }
    }
}
