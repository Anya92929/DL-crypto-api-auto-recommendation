package com.google.android.gms.internal;

import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.internal.bw */
class C1458bw extends C1459bx {

    /* renamed from: a */
    final zzanh f4898a = this.f4903f.m6715a(this.f4899b, this.f4900c, this.f4901d);

    /* renamed from: b */
    final /* synthetic */ zzamp f4899b;

    /* renamed from: c */
    final /* synthetic */ Field f4900c;

    /* renamed from: d */
    final /* synthetic */ zzaol f4901d;

    /* renamed from: e */
    final /* synthetic */ boolean f4902e;

    /* renamed from: f */
    final /* synthetic */ zzaog f4903f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1458bw(zzaog zzaog, String str, boolean z, boolean z2, zzamp zzamp, Field field, zzaol zzaol, boolean z3) {
        super(str, z, z2);
        this.f4903f = zzaog;
        this.f4899b = zzamp;
        this.f4900c = field;
        this.f4901d = zzaol;
        this.f4902e = z3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7120a(zzaom zzaom, Object obj) {
        Object zzb = this.f4898a.zzb(zzaom);
        if (zzb != null || !this.f4902e) {
            this.f4900c.set(obj, zzb);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7121a(zzaoo zzaoo, Object obj) {
        new C1463ca(this.f4899b, this.f4898a, this.f4901d.mo7940n()).zza(zzaoo, this.f4900c.get(obj));
    }

    /* renamed from: a */
    public boolean mo7122a(Object obj) {
        return this.f4905h && this.f4900c.get(obj) != obj;
    }
}
