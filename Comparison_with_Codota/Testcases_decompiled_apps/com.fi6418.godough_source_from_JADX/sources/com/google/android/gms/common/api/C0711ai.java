package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.android.gms.common.api.ai */
class C0711ai extends C0712aj {

    /* renamed from: a */
    final /* synthetic */ C0758w f4441a;

    /* renamed from: c */
    private final ArrayList<C0743h> f4442c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0711ai(C0758w wVar, ArrayList<C0743h> arrayList) {
        super(wVar, (C0759x) null);
        this.f4441a = wVar;
        this.f4442c = arrayList;
    }

    /* renamed from: a */
    public void mo7357a() {
        Iterator<C0743h> it = this.f4442c.iterator();
        while (it.hasNext()) {
            it.next().mo7434a(this.f4441a.f4548p);
        }
    }
}
