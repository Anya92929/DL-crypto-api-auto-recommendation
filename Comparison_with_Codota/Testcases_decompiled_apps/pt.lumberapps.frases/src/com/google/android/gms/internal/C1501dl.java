package com.google.android.gms.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.dl */
final class C1501dl {

    /* renamed from: a */
    final int f4935a;

    /* renamed from: b */
    final byte[] f4936b;

    C1501dl(int i, byte[] bArr) {
        this.f4935a = i;
        this.f4936b = bArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7188a() {
        return zzapo.zzagc(this.f4935a) + 0 + this.f4936b.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7189a(zzapo zzapo) {
        zzapo.zzagb(this.f4935a);
        zzapo.zzbh(this.f4936b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1501dl)) {
            return false;
        }
        C1501dl dlVar = (C1501dl) obj;
        return this.f4935a == dlVar.f4935a && Arrays.equals(this.f4936b, dlVar.f4936b);
    }

    public int hashCode() {
        return ((this.f4935a + 527) * 31) + Arrays.hashCode(this.f4936b);
    }
}
