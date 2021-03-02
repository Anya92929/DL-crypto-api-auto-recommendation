package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0742g;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.signin.internal.C1263n;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.signin.c */
final class C1243c extends C0742g<C1263n, C1247g> {
    C1243c() {
    }

    /* renamed from: a */
    public C1263n mo7430a(Context context, Looper looper, C1032t tVar, C1247g gVar, C0752q qVar, C0753r rVar) {
        return new C1263n(context, looper, true, tVar, gVar, qVar, rVar, Executors.newSingleThreadExecutor());
    }

    /* renamed from: a */
    public List<Scope> mo7431a(C1247g gVar) {
        return Arrays.asList(new Scope[]{C1242b.f5262e, C1242b.f5263f});
    }
}
