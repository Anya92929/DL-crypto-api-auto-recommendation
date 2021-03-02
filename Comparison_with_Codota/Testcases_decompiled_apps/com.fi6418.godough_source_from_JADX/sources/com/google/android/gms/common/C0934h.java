package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.h */
public class C0934h implements ServiceConnection {

    /* renamed from: a */
    boolean f4634a = false;

    /* renamed from: b */
    private final BlockingQueue<IBinder> f4635b = new LinkedBlockingQueue();

    /* renamed from: a */
    public IBinder mo7462a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
        } else if (this.f4634a) {
            throw new IllegalStateException();
        } else {
            this.f4634a = true;
            return this.f4635b.take();
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4635b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
