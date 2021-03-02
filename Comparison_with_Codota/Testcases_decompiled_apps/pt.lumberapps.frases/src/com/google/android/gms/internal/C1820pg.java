package com.google.android.gms.internal;

import com.google.android.gms.common.api.zzc;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* renamed from: com.google.android.gms.internal.pg */
final class C1820pg extends PhantomReference {

    /* renamed from: a */
    final /* synthetic */ zzqc f5477a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final int f5478b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1820pg(zzqc zzqc, zzc zzc, int i, ReferenceQueue referenceQueue) {
        super(zzc, referenceQueue);
        this.f5477a = zzqc;
        this.f5478b = i;
    }

    /* renamed from: a */
    public void mo7634a() {
        this.f5477a.f6890n.sendMessage(this.f5477a.f6890n.obtainMessage(2, this.f5478b, 2));
    }
}
