package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cv */
class C2094cv extends C1998aj {

    /* renamed from: ID */
    private static final String f4574ID = C0880a.SDK_VERSION.toString();

    public C2094cv() {
        super(f4574ID, new String[0]);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return C2114di.m7124u(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
