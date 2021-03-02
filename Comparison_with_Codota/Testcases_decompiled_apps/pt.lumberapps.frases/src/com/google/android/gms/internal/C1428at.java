package com.google.android.gms.internal;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.at */
class C1428at implements zzanu {

    /* renamed from: a */
    final /* synthetic */ Class f4847a;

    /* renamed from: b */
    final /* synthetic */ Type f4848b;

    /* renamed from: c */
    final /* synthetic */ zzanp f4849c;

    /* renamed from: d */
    private final zzanx f4850d = zzanx.zzczz();

    C1428at(zzanp zzanp, Class cls, Type type) {
        this.f4849c = zzanp;
        this.f4847a = cls;
        this.f4848b = type;
    }

    public Object zzczu() {
        try {
            return this.f4850d.zzf(this.f4847a);
        } catch (Exception e) {
            String valueOf = String.valueOf(this.f4848b);
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
        }
    }
}
