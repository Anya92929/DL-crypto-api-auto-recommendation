package com.appbrain.p032a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.appbrain.a.dv */
final class C0887dv implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ LinkedBlockingQueue f2356a;

    /* renamed from: b */
    final /* synthetic */ C0885dt f2357b;

    C0887dv(C0885dt dtVar, LinkedBlockingQueue linkedBlockingQueue) {
        this.f2357b = dtVar;
        this.f2356a = linkedBlockingQueue;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f2356a.put(iBinder);
        } catch (InterruptedException e) {
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
