package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C2119e extends C1998aj {

    /* renamed from: ID */
    private static final String f4586ID = C0880a.ADWORDS_CLICK_REFERRER.toString();
    private static final String anI = C0929b.COMPONENT.toString();
    private static final String anJ = C0929b.CONVERSION_ID.toString();

    /* renamed from: lB */
    private final Context f4587lB;

    public C2119e(Context context) {
        super(f4586ID, anJ);
        this.f4587lB = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        C1026d.C1027a aVar = map.get(anJ);
        if (aVar == null) {
            return C2114di.m7119pI();
        }
        String j = C2114di.m7106j(aVar);
        C1026d.C1027a aVar2 = map.get(anI);
        String f = C2014ay.m6793f(this.f4587lB, j, aVar2 != null ? C2114di.m7106j(aVar2) : null);
        return f != null ? C2114di.m7124u(f) : C2114di.m7119pI();
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
