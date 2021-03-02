package com.google.android.gms.tagmanager;

import android.os.Build;

/* renamed from: com.google.android.gms.tagmanager.bn */
class C2034bn {
    C2034bn() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: nN */
    public int mo11587nN() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: ov */
    public C2033bm mo11588ov() {
        return mo11587nN() < 8 ? new C2011av() : new C2012aw();
    }
}
