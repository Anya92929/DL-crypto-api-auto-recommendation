package com.google.android.gms.internal;

import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.internal.bl */
final class C1447bl extends zzanx {

    /* renamed from: a */
    final /* synthetic */ Method f4888a;

    /* renamed from: b */
    final /* synthetic */ int f4889b;

    C1447bl(Method method, int i) {
        this.f4888a = method;
        this.f4889b = i;
    }

    public Object zzf(Class cls) {
        return this.f4888a.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f4889b)});
    }
}
