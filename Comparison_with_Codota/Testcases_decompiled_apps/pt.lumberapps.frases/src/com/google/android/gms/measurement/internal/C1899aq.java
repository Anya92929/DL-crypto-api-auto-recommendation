package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.aq */
class C1899aq implements Runnable {

    /* renamed from: a */
    private final C1898ap f7100a;

    /* renamed from: b */
    private final int f7101b;

    /* renamed from: c */
    private final Throwable f7102c;

    /* renamed from: d */
    private final byte[] f7103d;

    /* renamed from: e */
    private final String f7104e;

    /* renamed from: f */
    private final Map f7105f;

    private C1899aq(String str, C1898ap apVar, int i, Throwable th, byte[] bArr, Map map) {
        zzab.zzy(apVar);
        this.f7100a = apVar;
        this.f7101b = i;
        this.f7102c = th;
        this.f7103d = bArr;
        this.f7104e = str;
        this.f7105f = map;
    }

    public void run() {
        this.f7100a.mo9248a(this.f7104e, this.f7101b, this.f7102c, this.f7103d, this.f7105f);
    }
}
