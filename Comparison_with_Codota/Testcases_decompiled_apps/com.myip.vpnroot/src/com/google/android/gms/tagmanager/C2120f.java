package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C2120f extends C1998aj {

    /* renamed from: ID */
    private static final String f4588ID = C0880a.APP_ID.toString();
    private final Context mContext;

    public C2120f(Context context) {
        super(f4588ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return C2114di.m7124u(this.mContext.getPackageName());
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
