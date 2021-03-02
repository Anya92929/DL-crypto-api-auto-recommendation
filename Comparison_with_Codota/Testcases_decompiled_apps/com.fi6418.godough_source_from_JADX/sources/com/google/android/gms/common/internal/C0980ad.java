package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.gms.common.internal.ad */
public final class C0980ad implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C1037y f4681a;

    /* renamed from: b */
    private final int f4682b;

    public C0980ad(C1037y yVar, int i) {
        this.f4681a = yVar;
        this.f4682b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1009bf.m4529a(iBinder, (Object) "Expecting a valid IBinder");
        C0999aw unused = this.f4681a.f4775j = C1000ax.m4472a(iBinder);
        this.f4681a.mo7651c(this.f4682b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f4681a.f4767a.sendMessage(this.f4681a.f4767a.obtainMessage(4, this.f4682b, 1));
    }
}
