package com.google.android.gms.p018c;

import java.util.Comparator;

/* renamed from: com.google.android.gms.c.al */
class C0623al implements Comparator<C0626ao> {

    /* renamed from: a */
    final /* synthetic */ C0622ak f4227a;

    C0623al(C0622ak akVar) {
        this.f4227a = akVar;
    }

    /* renamed from: a */
    public int compare(C0626ao aoVar, C0626ao aoVar2) {
        return aoVar.getClass().getCanonicalName().compareTo(aoVar2.getClass().getCanonicalName());
    }
}
