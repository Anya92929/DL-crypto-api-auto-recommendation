package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C2157w extends C2112dg {

    /* renamed from: ID */
    private static final String f4606ID = C0880a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = C0929b.VALUE.toString();
    private static final String aoP = C0929b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer anS;

    public C2157w(DataLayer dataLayer) {
        super(f4606ID, VALUE);
        this.anS = dataLayer;
    }

    /* renamed from: a */
    private void m7271a(C1026d.C1027a aVar) {
        String j;
        if (aVar != null && aVar != C2114di.m7113pC() && (j = C2114di.m7106j(aVar)) != C2114di.m7118pH()) {
            this.anS.mo11497cs(j);
        }
    }

    /* renamed from: b */
    private void m7272b(C1026d.C1027a aVar) {
        if (aVar != null && aVar != C2114di.m7113pC()) {
            Object o = C2114di.m7111o(aVar);
            if (o instanceof List) {
                for (Object next : (List) o) {
                    if (next instanceof Map) {
                        this.anS.push((Map) next);
                    }
                }
            }
        }
    }

    /* renamed from: E */
    public void mo11732E(Map<String, C1026d.C1027a> map) {
        m7272b(map.get(VALUE));
        m7271a(map.get(aoP));
    }
}
