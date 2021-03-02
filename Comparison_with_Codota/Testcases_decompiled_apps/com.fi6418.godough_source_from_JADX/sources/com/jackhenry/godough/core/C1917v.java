package com.jackhenry.godough.core;

import com.jackhenry.godough.core.p038e.C1574c;
import com.jackhenry.godough.core.p038e.C1578g;
import java.util.ArrayList;

/* renamed from: com.jackhenry.godough.core.v */
class C1917v implements C1578g {

    /* renamed from: a */
    final /* synthetic */ ArrayList f6845a;

    /* renamed from: b */
    final /* synthetic */ int f6846b;

    /* renamed from: c */
    final /* synthetic */ C1916u f6847c;

    C1917v(C1916u uVar, ArrayList arrayList, int i) {
        this.f6847c = uVar;
        this.f6845a = arrayList;
        this.f6846b = i;
    }

    public void onDialogButtonClicked(int i, C1574c cVar) {
        if (cVar.mo9788a() == -1) {
            this.f6847c.f6844a.mo9537a((String[]) this.f6845a.toArray(new String[this.f6845a.size()]), this.f6846b);
        }
    }
}
