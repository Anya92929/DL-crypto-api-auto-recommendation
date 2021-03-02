package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.maps.internal.t */
public final class C1867t {
    private C1867t() {
    }

    /* renamed from: a */
    public static void m6387a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(C1867t.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(C1867t.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
