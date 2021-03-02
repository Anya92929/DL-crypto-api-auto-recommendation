package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.internal.eo */
final class C1531eo implements Callable {

    /* renamed from: a */
    final /* synthetic */ Context f4973a;

    C1531eo(Context context) {
        this.f4973a = context;
    }

    /* renamed from: a */
    public Void call() {
        zzu.zzfz().initialize(this.f4973a);
        return null;
    }
}
