package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.common.a */
public class C0265a implements ServiceConnection {

    /* renamed from: HC */
    boolean f552HC = false;

    /* renamed from: HD */
    private final BlockingQueue<IBinder> f553HD = new LinkedBlockingQueue();

    /* renamed from: fX */
    public IBinder mo4180fX() throws InterruptedException {
        if (this.f552HC) {
            throw new IllegalStateException();
        }
        this.f552HC = true;
        return this.f553HD.take();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        this.f553HD.add(service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
