package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Handler.Callback {

    /* renamed from: a */
    final ArrayList<GoogleApiClient.ConnectionCallbacks> f2997a = new ArrayList<>();

    /* renamed from: b */
    private final zza f2998b;

    /* renamed from: c */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f2999c = new ArrayList<>();

    /* renamed from: d */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f3000d = new ArrayList<>();

    /* renamed from: e */
    private volatile boolean f3001e = false;

    /* renamed from: f */
    private final AtomicInteger f3002f = new AtomicInteger(0);

    /* renamed from: g */
    private boolean f3003g = false;

    /* renamed from: h */
    private final Handler f3004h;

    /* renamed from: i */
    private final Object f3005i = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzoi();
    }

    public zzk(Looper looper, zza zza2) {
        this.f2998b = zza2;
        this.f3004h = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.f3005i) {
                if (this.f3001e && this.f2998b.isConnected() && this.f2999c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f2998b.zzoi());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzx.zzz(connectionCallbacks);
        synchronized (this.f3005i) {
            contains = this.f2999c.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.f3005i) {
            contains = this.f3000d.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.f3005i) {
            if (this.f2999c.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.f2999c.add(connectionCallbacks);
            }
        }
        if (this.f2998b.isConnected()) {
            this.f3004h.sendMessage(this.f3004h.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.f3005i) {
            if (this.f3000d.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.f3000d.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzx.zzz(connectionCallbacks);
        synchronized (this.f3005i) {
            if (!this.f2999c.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.f3003g) {
                this.f2997a.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzz(onConnectionFailedListener);
        synchronized (this.f3005i) {
            if (!this.f3000d.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public void zzbT(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f3004h.getLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f3004h.removeMessages(1);
        synchronized (this.f3005i) {
            this.f3003g = true;
            ArrayList arrayList = new ArrayList(this.f2999c);
            int i2 = this.f3002f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f3001e || this.f3002f.get() != i2) {
                    break;
                } else if (this.f2999c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f2997a.clear();
            this.f3003g = false;
        }
    }

    public void zzk(Bundle bundle) {
        boolean z = true;
        zzx.zza(Looper.myLooper() == this.f3004h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f3005i) {
            zzx.zzab(!this.f3003g);
            this.f3004h.removeMessages(1);
            this.f3003g = true;
            if (this.f2997a.size() != 0) {
                z = false;
            }
            zzx.zzab(z);
            ArrayList arrayList = new ArrayList(this.f2999c);
            int i = this.f3002f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f3001e || !this.f2998b.isConnected() || this.f3002f.get() != i) {
                    break;
                } else if (!this.f2997a.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f2997a.clear();
            this.f3003g = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzk(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r1 = 1
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r2 = r5.f3004h
            android.os.Looper r2 = r2.getLooper()
            if (r0 != r2) goto L_0x0046
            r0 = r1
        L_0x000e:
            java.lang.String r2 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzx.zza((boolean) r0, (java.lang.Object) r2)
            android.os.Handler r0 = r5.f3004h
            r0.removeMessages(r1)
            java.lang.Object r1 = r5.f3005i
            monitor-enter(r1)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.f3000d     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f3002f     // Catch:{ all -> 0x0054 }
            int r2 = r2.get()     // Catch:{ all -> 0x0054 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x002c:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0     // Catch:{ all -> 0x0054 }
            boolean r4 = r5.f3001e     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f3002f     // Catch:{ all -> 0x0054 }
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
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.f3000d     // Catch:{ all -> 0x0054 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzk.zzk(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzqQ() {
        this.f3001e = false;
        this.f3002f.incrementAndGet();
    }

    public void zzqR() {
        this.f3001e = true;
    }
}
