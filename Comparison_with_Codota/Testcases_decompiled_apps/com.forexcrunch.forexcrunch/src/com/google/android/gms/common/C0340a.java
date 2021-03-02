package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0340a implements ServiceConnection {

    /* renamed from: A */
    private final BlockingQueue<IBinder> f790A = new LinkedBlockingQueue();

    /* renamed from: z */
    boolean f791z = false;

    /* renamed from: e */
    public IBinder mo4026e() throws InterruptedException {
        if (this.f791z) {
            throw new IllegalStateException();
        }
        this.f791z = true;
        return this.f790A.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.f790A.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
