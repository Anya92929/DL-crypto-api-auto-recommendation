package com.google.android.gms.internal;

import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.internal.bk */
final class C1446bk extends zzanx {

    /* renamed from: a */
    final /* synthetic */ Method f4886a;

    /* renamed from: b */
    final /* synthetic */ Object f4887b;

    C1446bk(Method method, Object obj) {
        this.f4886a = method;
        this.f4887b = obj;
    }

    public Object zzf(Class cls) {
        return this.f4886a.invoke(this.f4887b, new Object[]{cls});
    }
}
