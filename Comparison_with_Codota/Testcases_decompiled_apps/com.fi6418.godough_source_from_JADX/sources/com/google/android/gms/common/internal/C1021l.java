package com.google.android.gms.common.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.l */
final class C1021l extends C1016g {

    /* renamed from: p */
    final /* synthetic */ char[] f4746p;

    C1021l(char[] cArr) {
        this.f4746p = cArr;
    }

    /* renamed from: b */
    public boolean mo7627b(char c) {
        return Arrays.binarySearch(this.f4746p, c) >= 0;
    }
}
