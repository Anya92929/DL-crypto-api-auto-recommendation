package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0739d;
import com.google.android.gms.common.api.C0742g;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.signin.internal.C1263n;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.signin.d */
final class C1244d extends C0742g<C1263n, C0739d> {
    C1244d() {
    }

    /* renamed from: a */
    public C1263n mo7430a(Context context, Looper looper, C1032t tVar, C0739d dVar, C0752q qVar, C0753r rVar) {
        return new C1263n(context, looper, false, tVar, C1247g.f5267a, qVar, rVar, Executors.newSingleThreadExecutor());
    }
}
