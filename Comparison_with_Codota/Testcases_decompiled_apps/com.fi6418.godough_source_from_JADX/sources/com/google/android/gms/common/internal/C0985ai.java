package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C0752q;
import com.google.android.gms.common.api.C0753r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.ai */
public final class C0985ai implements Handler.Callback {

    /* renamed from: a */
    final ArrayList<C0752q> f4688a = new ArrayList<>();

    /* renamed from: b */
    private final C0986aj f4689b;

    /* renamed from: c */
    private final ArrayList<C0752q> f4690c = new ArrayList<>();

    /* renamed from: d */
    private final ArrayList<C0753r> f4691d = new ArrayList<>();

    /* renamed from: e */
    private volatile boolean f4692e = false;

    /* renamed from: f */
    private final AtomicInteger f4693f = new AtomicInteger(0);

    /* renamed from: g */
    private boolean f4694g = false;

    /* renamed from: h */
    private final Handler f4695h;

    /* renamed from: i */
    private final Object f4696i = new Object();

    public C0985ai(Looper looper, C0986aj ajVar) {
        this.f4689b = ajVar;
        this.f4695h = new Handler(looper, this);
    }

    /* renamed from: a */
    public void mo7517a() {
        this.f4692e = false;
        this.f4693f.incrementAndGet();
    }

    /* renamed from: a */
    public void mo7518a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f4695h.getLooper()) {
            z = true;
        }
        C1009bf.m4533a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f4695h.removeMessages(1);
        synchronized (this.f4696i) {
            this.f4694g = true;
            ArrayList arrayList = new ArrayList(this.f4690c);
            int i2 = this.f4693f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0752q qVar = (C0752q) it.next();
                if (!this.f4692e || this.f4693f.get() != i2) {
                    break;
                } else if (this.f4690c.contains(qVar)) {
                    qVar.onConnectionSuspended(i);
                }
            }
            this.f4688a.clear();
            this.f4694g = false;
        }
    }

    /* renamed from: a */
    public void mo7519a(Bundle bundle) {
        boolean z = true;
        C1009bf.m4533a(Looper.myLooper() == this.f4695h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f4696i) {
            C1009bf.m4532a(!this.f4694g);
            this.f4695h.removeMessages(1);
            this.f4694g = true;
            if (this.f4688a.size() != 0) {
                z = false;
            }
            C1009bf.m4532a(z);
            ArrayList arrayList = new ArrayList(this.f4690c);
            int i = this.f4693f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0752q qVar = (C0752q) it.next();
                if (!this.f4692e || !this.f4689b.mo7395b() || this.f4693f.get() != i) {
                    break;
                } else if (!this.f4688a.contains(qVar)) {
                    qVar.onConnected(bundle);
                }
            }
            this.f4688a.clear();
            this.f4694g = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7520a(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r1 = 1
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r2 = r5.f4695h
            android.os.Looper r2 = r2.getLooper()
            if (r0 != r2) goto L_0x0046
            r0 = r1
        L_0x000e:
            java.lang.String r2 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.C1009bf.m4533a((boolean) r0, (java.lang.Object) r2)
            android.os.Handler r0 = r5.f4695h
            r0.removeMessages(r1)
            java.lang.Object r1 = r5.f4696i
            monitor-enter(r1)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            java.util.ArrayList<com.google.android.gms.common.api.r> r2 = r5.f4691d     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f4693f     // Catch:{ all -> 0x0054 }
            int r2 = r2.get()     // Catch:{ all -> 0x0054 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x002c:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.api.r r0 = (com.google.android.gms.common.api.C0753r) r0     // Catch:{ all -> 0x0054 }
            boolean r4 = r5.f4692e     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f4693f     // Catch:{ all -> 0x0054 }
            int r4 = r4.get()     // Catch:{ all -> 0x0054 }
            if (r4 == r2) goto L_0x0048
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
        L_0x0045:
            return
        L_0x0046:
            r0 = 0
            goto L_0x000e
        L_0x0048:
            java.util.ArrayList<com.google.android.gms.common.api.r> r4 = r5.f4691d     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.contains(r0)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x002c
            r0.onConnectionFailed(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x002c
        L_0x0054:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.C0985ai.mo7520a(com.google.android.gms.common.ConnectionResult):void");
    }

    /* renamed from: a */
    public void mo7521a(C0752q qVar) {
        C1009bf.m4528a(qVar);
        synchronized (this.f4696i) {
            if (this.f4690c.contains(qVar)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + qVar + " is already registered");
            } else {
                this.f4690c.add(qVar);
            }
        }
        if (this.f4689b.mo7395b()) {
            this.f4695h.sendMessage(this.f4695h.obtainMessage(1, qVar));
        }
    }

    /* renamed from: a */
    public void mo7522a(C0753r rVar) {
        C1009bf.m4528a(rVar);
        synchronized (this.f4696i) {
            if (this.f4691d.contains(rVar)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + rVar + " is already registered");
            } else {
                this.f4691d.add(rVar);
            }
        }
    }

    /* renamed from: b */
    public void mo7523b() {
        this.f4692e = true;
    }

    /* renamed from: b */
    public void mo7524b(C0752q qVar) {
        C1009bf.m4528a(qVar);
        synchronized (this.f4696i) {
            if (!this.f4690c.remove(qVar)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + qVar + " not found");
            } else if (this.f4694g) {
                this.f4688a.add(qVar);
            }
        }
    }

    /* renamed from: b */
    public void mo7525b(C0753r rVar) {
        C1009bf.m4528a(rVar);
        synchronized (this.f4696i) {
            if (!this.f4691d.remove(rVar)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + rVar + " not found");
            }
        }
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            C0752q qVar = (C0752q) message.obj;
            synchronized (this.f4696i) {
                if (this.f4692e && this.f4689b.mo7395b() && this.f4690c.contains(qVar)) {
                    qVar.onConnected(this.f4689b.mo7394a_());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }
}
