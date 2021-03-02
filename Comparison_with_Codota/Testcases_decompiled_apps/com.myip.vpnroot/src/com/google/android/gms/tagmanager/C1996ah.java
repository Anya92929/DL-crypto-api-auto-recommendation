package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ah */
class C1996ah extends C1998aj {

    /* renamed from: ID */
    private static final String f4531ID = C0880a.EVENT.toString();
    private final C2085ct anT;

    public C1996ah(C2085ct ctVar) {
        super(f4531ID, new String[0]);
        this.anT = ctVar;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String pl = this.anT.mo11700pl();
        return pl == null ? C2114di.m7119pI() : C2114di.m7124u(pl);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
