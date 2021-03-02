package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.common.internal.C1037y;

/* renamed from: com.google.android.gms.location.internal.a */
public class C1121a extends C1037y<C1129i> {

    /* renamed from: d */
    protected final C1142v<C1129i> f4967d = new C1122b(this);

    /* renamed from: e */
    private final String f4968e;

    public C1121a(Context context, Looper looper, C0752q qVar, C0753r rVar, String str, C1032t tVar) {
        super(context, looper, 23, tVar, qVar, rVar);
        this.f4968e = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1129i mo7614a(IBinder iBinder) {
        return C1130j.m4915a(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo7616d() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo7617e() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public Bundle mo7657k() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f4968e);
        return bundle;
    }
}
