package com.google.android.gms.common.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.common.internal.i */
final class C1370i extends zzf {

    /* renamed from: a */
    final /* synthetic */ char[] f4492a;

    C1370i(char[] cArr) {
        this.f4492a = cArr;
    }

    public boolean zzd(char c) {
        return Arrays.binarySearch(this.f4492a, c) >= 0;
    }
}
