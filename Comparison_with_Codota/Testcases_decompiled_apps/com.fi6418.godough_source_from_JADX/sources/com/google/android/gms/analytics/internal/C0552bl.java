package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1015f;
import com.google.android.gms.p018c.C0669k;

/* renamed from: com.google.android.gms.analytics.internal.bl */
public final class C0552bl<V> {

    /* renamed from: a */
    private final V f3843a;

    /* renamed from: b */
    private final C0669k<V> f3844b;

    /* renamed from: c */
    private V f3845c;

    private C0552bl(C0669k<V> kVar, V v) {
        C1009bf.m4528a(kVar);
        this.f3844b = kVar;
        this.f3843a = v;
    }

    /* renamed from: a */
    static C0552bl<Float> m3208a(String str, float f) {
        return m3209a(str, f, f);
    }

    /* renamed from: a */
    static C0552bl<Float> m3209a(String str, float f, float f2) {
        return new C0552bl<>(C0669k.m3883a(str, Float.valueOf(f2)), Float.valueOf(f));
    }

    /* renamed from: a */
    static C0552bl<Integer> m3210a(String str, int i) {
        return m3211a(str, i, i);
    }

    /* renamed from: a */
    static C0552bl<Integer> m3211a(String str, int i, int i2) {
        return new C0552bl<>(C0669k.m3884a(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* renamed from: a */
    static C0552bl<Long> m3212a(String str, long j) {
        return m3213a(str, j, j);
    }

    /* renamed from: a */
    static C0552bl<Long> m3213a(String str, long j, long j2) {
        return new C0552bl<>(C0669k.m3885a(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* renamed from: a */
    static C0552bl<String> m3214a(String str, String str2) {
        return m3215a(str, str2, str2);
    }

    /* renamed from: a */
    static C0552bl<String> m3215a(String str, String str2, String str3) {
        return new C0552bl<>(C0669k.m3886a(str, str3), str2);
    }

    /* renamed from: a */
    static C0552bl<Boolean> m3216a(String str, boolean z) {
        return m3217a(str, z, z);
    }

    /* renamed from: a */
    static C0552bl<Boolean> m3217a(String str, boolean z, boolean z2) {
        return new C0552bl<>(C0669k.m3887a(str, z2), Boolean.valueOf(z));
    }

    /* renamed from: a */
    public V mo6775a() {
        return this.f3845c != null ? this.f3845c : (!C1015f.f4727a || !C0669k.m3888b()) ? this.f3843a : this.f3844b.mo7235d();
    }
}
