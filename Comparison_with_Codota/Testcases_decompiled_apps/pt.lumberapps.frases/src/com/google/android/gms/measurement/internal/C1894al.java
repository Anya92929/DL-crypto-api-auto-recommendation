package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;

/* renamed from: com.google.android.gms.measurement.internal.al */
class C1894al {

    /* renamed from: a */
    final String f7092a;

    /* renamed from: b */
    final String f7093b;

    /* renamed from: c */
    final long f7094c;

    /* renamed from: d */
    final long f7095d;

    /* renamed from: e */
    final long f7096e;

    C1894al(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzab.zzbo(j >= 0);
        zzab.zzbo(j2 < 0 ? false : z);
        this.f7092a = str;
        this.f7093b = str2;
        this.f7094c = j;
        this.f7095d = j2;
        this.f7096e = j3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1894al mo9237a() {
        return new C1894al(this.f7092a, this.f7093b, this.f7094c + 1, this.f7095d + 1, this.f7096e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1894al mo9238a(long j) {
        return new C1894al(this.f7092a, this.f7093b, this.f7094c, this.f7095d, j);
    }
}
