package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.C0745j;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;

/* renamed from: com.google.android.gms.common.internal.c */
public class C1012c<T extends IInterface> extends C1037y<T> {

    /* renamed from: d */
    private final C0745j<T> f4726d;

    public C1012c(Context context, Looper looper, int i, C0752q qVar, C0753r rVar, C1032t tVar, C0745j jVar) {
        super(context, looper, i, tVar, qVar, rVar);
        this.f4726d = jVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public T mo7614a(IBinder iBinder) {
        return this.f4726d.mo7439a(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7615a(int i, T t) {
        this.f4726d.mo7441a(i, t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo7616d() {
        return this.f4726d.mo7440a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo7617e() {
        return this.f4726d.mo7442b();
    }
}
