package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.Intent;
import com.google.android.gms.internal.zzqk;

/* renamed from: com.google.android.gms.common.internal.s */
final class C1380s extends zzi {

    /* renamed from: a */
    final /* synthetic */ Intent f4502a;

    /* renamed from: b */
    final /* synthetic */ zzqk f4503b;

    /* renamed from: c */
    final /* synthetic */ int f4504c;

    C1380s(Intent intent, zzqk zzqk, int i) {
        this.f4502a = intent;
        this.f4503b = zzqk;
        this.f4504c = i;
    }

    @TargetApi(11)
    public void zzasr() {
        if (this.f4502a != null) {
            this.f4503b.startActivityForResult(this.f4502a, this.f4504c);
        }
    }
}
