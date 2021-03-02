package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.gms.internal.av */
class C1430av implements zzanu {

    /* renamed from: a */
    final /* synthetic */ Constructor f4854a;

    /* renamed from: b */
    final /* synthetic */ zzanp f4855b;

    C1430av(zzanp zzanp, Constructor constructor) {
        this.f4855b = zzanp;
        this.f4854a = constructor;
    }

    public Object zzczu() {
        try {
            return this.f4854a.newInstance((Object[]) null);
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(this.f4854a);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
        } catch (InvocationTargetException e2) {
            String valueOf2 = String.valueOf(this.f4854a);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf2).length() + 30).append("Failed to invoke ").append(valueOf2).append(" with no args").toString(), e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
