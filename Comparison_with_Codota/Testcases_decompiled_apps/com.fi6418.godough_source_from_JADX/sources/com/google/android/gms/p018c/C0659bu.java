package com.google.android.gms.p018c;

import java.util.Arrays;

/* renamed from: com.google.android.gms.c.bu */
final class C0659bu {

    /* renamed from: a */
    final int f4336a;

    /* renamed from: b */
    final byte[] f4337b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo7192a() {
        return 0 + C0650bl.m3776f(this.f4336a) + this.f4337b.length;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7193a(C0650bl blVar) {
        blVar.mo7162e(this.f4336a);
        blVar.mo7157b(this.f4337b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0659bu)) {
            return false;
        }
        C0659bu buVar = (C0659bu) obj;
        return this.f4336a == buVar.f4336a && Arrays.equals(this.f4337b, buVar.f4337b);
    }

    public int hashCode() {
        return ((this.f4336a + 527) * 31) + Arrays.hashCode(this.f4337b);
    }
}
