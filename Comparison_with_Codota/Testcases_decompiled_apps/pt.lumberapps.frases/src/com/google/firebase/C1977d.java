package com.google.firebase;

import com.google.android.gms.common.internal.zzab;

/* renamed from: com.google.firebase.d */
public class C1977d extends Exception {
    @Deprecated
    protected C1977d() {
    }

    public C1977d(String str) {
        super(zzab.zzh(str, "Detail message must not be empty"));
    }

    public C1977d(String str, Throwable th) {
        super(zzab.zzh(str, "Detail message must not be empty"), th);
    }
}
