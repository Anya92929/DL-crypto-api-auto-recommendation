package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ca */
class C2049ca extends C1998aj {

    /* renamed from: ID */
    private static final String f4558ID = C0880a.OS_VERSION.toString();

    public C2049ca() {
        super(f4558ID, new String[0]);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        return C2114di.m7124u(Build.VERSION.RELEASE);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
