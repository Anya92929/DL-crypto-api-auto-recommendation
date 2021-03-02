package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C2150u extends C1998aj {

    /* renamed from: ID */
    private static final String f4603ID = C0880a.CUSTOM_VAR.toString();
    private static final String NAME = C0929b.NAME.toString();
    private static final String aoE = C0929b.DEFAULT_VALUE.toString();
    private final DataLayer anS;

    public C2150u(DataLayer dataLayer) {
        super(f4603ID, NAME);
        this.anS = dataLayer;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        Object obj = this.anS.get(C2114di.m7106j(map.get(NAME)));
        if (obj != null) {
            return C2114di.m7124u(obj);
        }
        C1026d.C1027a aVar = map.get(aoE);
        return aVar != null ? aVar : C2114di.m7119pI();
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
