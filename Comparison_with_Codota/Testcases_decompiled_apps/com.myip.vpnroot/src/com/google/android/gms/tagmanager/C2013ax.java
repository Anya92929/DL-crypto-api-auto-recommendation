package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C0929b;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ax */
class C2013ax extends C1998aj {

    /* renamed from: ID */
    private static final String f4540ID = C0880a.INSTALL_REFERRER.toString();
    private static final String anI = C0929b.COMPONENT.toString();

    /* renamed from: lB */
    private final Context f4541lB;

    public C2013ax(Context context) {
        super(f4540ID, new String[0]);
        this.f4541lB = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String e = C2014ay.m6792e(this.f4541lB, map.get(anI) != null ? C2114di.m7106j(map.get(anI)) : null);
        return e != null ? C2114di.m7124u(e) : C2114di.m7119pI();
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
