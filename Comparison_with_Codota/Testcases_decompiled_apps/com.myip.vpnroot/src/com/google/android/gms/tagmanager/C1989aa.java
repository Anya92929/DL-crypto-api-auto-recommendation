package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C0880a;
import com.google.android.gms.internal.C1026d;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.aa */
class C1989aa extends C1998aj {

    /* renamed from: ID */
    private static final String f4527ID = C0880a.DEVICE_NAME.toString();

    public C1989aa() {
        super(f4527ID, new String[0]);
    }

    /* renamed from: C */
    public C1026d.C1027a mo11537C(Map<String, C1026d.C1027a> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            str2 = str + " " + str2;
        }
        return C2114di.m7124u(str2);
    }

    /* renamed from: nL */
    public boolean mo11538nL() {
        return true;
    }
}
