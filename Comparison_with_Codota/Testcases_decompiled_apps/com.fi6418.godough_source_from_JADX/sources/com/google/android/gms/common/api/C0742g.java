package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0743h;
import com.google.android.gms.common.internal.C1032t;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.common.api.g */
public abstract class C0742g<T extends C0743h, O> {
    /* renamed from: a */
    public int mo7429a() {
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    public abstract T mo7430a(Context context, Looper looper, C1032t tVar, O o, C0752q qVar, C0753r rVar);

    /* renamed from: a */
    public List<Scope> mo7431a(O o) {
        return Collections.emptyList();
    }
}
