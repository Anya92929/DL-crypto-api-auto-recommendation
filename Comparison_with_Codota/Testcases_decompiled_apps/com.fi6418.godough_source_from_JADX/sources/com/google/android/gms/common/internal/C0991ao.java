package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.google.android.gms.common.internal.ao */
public class C0991ao implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C0990an f4714a;

    public C0991ao(C0990an anVar) {
        this.f4714a = anVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4714a.f4706a.f4699a) {
            IBinder unused = this.f4714a.f4711f = iBinder;
            ComponentName unused2 = this.f4714a.f4713h = componentName;
            for (ServiceConnection onServiceConnected : this.f4714a.f4708c) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            int unused3 = this.f4714a.f4709d = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f4714a.f4706a.f4699a) {
            IBinder unused = this.f4714a.f4711f = null;
            ComponentName unused2 = this.f4714a.f4713h = componentName;
            for (ServiceConnection onServiceDisconnected : this.f4714a.f4708c) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            int unused3 = this.f4714a.f4709d = 2;
        }
    }
}
