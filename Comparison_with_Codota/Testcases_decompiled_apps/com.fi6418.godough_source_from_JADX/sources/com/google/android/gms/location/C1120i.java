package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0739d;
import com.google.android.gms.common.api.C0742g;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.location.internal.C1138r;

/* renamed from: com.google.android.gms.location.i */
final class C1120i extends C0742g<C1138r, C0739d> {
    C1120i() {
    }

    /* renamed from: a */
    public C1138r mo7430a(Context context, Looper looper, C1032t tVar, C0739d dVar, C0752q qVar, C0753r rVar) {
        return new C1138r(context, looper, qVar, rVar, "locationServices", tVar);
    }
}
