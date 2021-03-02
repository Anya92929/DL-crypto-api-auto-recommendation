package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cf */
class C2057cf extends C1998aj {

    /* renamed from: ID */
    private static final String f4567ID = C0880a.RANDOM.toString();
    private static final String aqa = C0929b.MIN.toString();
    private static final String aqb = C0929b.MAX.toString();

    public C2057cf() {
        super(f4567ID, new String[0]);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        double d;
        double d2;
        C1026d.C1027a aVar = map.get(aqa);
        C1026d.C1027a aVar2 = map.get(aqb);
        if (!(aVar == null || aVar == C2114di.m7119pI() || aVar2 == null || aVar2 == C2114di.m7119pI())) {
            C2113dh k = C2114di.m7107k(aVar);
            C2113dh k2 = C2114di.m7107k(aVar2);
            if (!(k == C2114di.m7117pG() || k2 == C2114di.m7117pG())) {
                double doubleValue = k.doubleValue();
                d = k2.doubleValue();
                if (doubleValue <= d) {
                    d2 = doubleValue;
                    return C2114di.m7124u(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
                }
            }
        }
        d = 2.147483647E9d;
        d2 = 0.0d;
        return C2114di.m7124u(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
