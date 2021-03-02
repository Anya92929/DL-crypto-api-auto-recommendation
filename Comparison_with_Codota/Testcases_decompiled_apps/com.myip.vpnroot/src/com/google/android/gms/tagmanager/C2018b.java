package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C2018b extends C1998aj {

    /* renamed from: ID */
    private static final String f4543ID = C0880a.ADVERTISER_ID.toString();
    private final C1985a anH;

    public C2018b(Context context) {
        this(C1985a.m6721V(context));
    }

    C2018b(C1985a aVar) {
        super(f4543ID, new String[0]);
        this.anH = aVar;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String nH = this.anH.mo11533nH();
        return nH == null ? C2114di.m7119pI() : C2114di.m7124u(nH);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
