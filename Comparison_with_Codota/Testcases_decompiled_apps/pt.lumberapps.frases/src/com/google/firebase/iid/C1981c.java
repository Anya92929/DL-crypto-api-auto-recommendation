package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.p009v4.p010a.C0060z;
import com.google.android.gms.iid.MessengerCompat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.google.firebase.iid.c */
public abstract class C1981c extends Service {

    /* renamed from: a */
    MessengerCompat f7514a = new MessengerCompat((Handler) new C1982d(this, Looper.getMainLooper()));

    /* renamed from: b */
    final ExecutorService f7515b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private final Object f7516c = new Object();

    /* renamed from: d */
    private int f7517d;

    /* renamed from: e */
    private int f7518e = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo9865a(Intent intent) {
        this.f7515b.execute(new C1983e(this, intent));
        return 3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Intent mo9867b(Intent intent);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9871b() {
        synchronized (this.f7516c) {
            this.f7518e--;
            if (this.f7518e == 0) {
                mo9872b(this.f7517d);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo9872b(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.firebase.INSTANCE_ID_EVENT".equals(intent.getAction())) {
            return null;
        }
        return this.f7514a.getBinder();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        String str;
        synchronized (this.f7516c) {
            this.f7517d = i2;
            this.f7518e++;
        }
        Intent b = mo9867b(intent);
        if (b == null) {
            mo9871b();
            return 2;
        }
        try {
            int a = mo9865a(b);
        } finally {
            str = "from";
            if (b.getStringExtra(str) != null) {
                C0060z.m189a(b);
            }
        }
    }

    public abstract void zzm(Intent intent);
}
