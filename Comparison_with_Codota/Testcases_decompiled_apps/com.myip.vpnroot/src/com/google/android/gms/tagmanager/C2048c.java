package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C2048c extends C1998aj {

    /* renamed from: ID */
    private static final String f4557ID = C0880a.ADVERTISING_TRACKING_ENABLED.toString();
    private final C1985a anH;

    public C2048c(Context context) {
        this(C1985a.m6721V(context));
    }

    C2048c(C1985a aVar) {
        super(f4557ID, new String[0]);
        this.anH = aVar;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return C2114di.m7124u(Boolean.valueOf(!this.anH.isLimitAdTrackingEnabled()));
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return false;
    }
}
