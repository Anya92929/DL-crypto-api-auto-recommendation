package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0136a implements ServiceConnection {

    /* renamed from: iN */
    boolean f364iN = false;

    /* renamed from: iO */
    private final BlockingQueue<IBinder> f365iO = new LinkedBlockingQueue();

    /* renamed from: aG */
    public IBinder mo3573aG() throws InterruptedException {
        if (this.f364iN) {
            throw new IllegalStateException();
        }
        this.f364iN = true;
        return this.f365iO.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.f365iO.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
