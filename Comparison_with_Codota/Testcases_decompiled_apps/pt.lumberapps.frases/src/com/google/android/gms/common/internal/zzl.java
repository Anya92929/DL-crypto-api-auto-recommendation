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

public final class zzl implements Handler.Callback {

    /* renamed from: a */
    final ArrayList f4588a = new ArrayList();

    /* renamed from: b */
    private final zza f4589b;

    /* renamed from: c */
    private final ArrayList f4590c = new ArrayList();

    /* renamed from: d */
    private final ArrayList f4591d = new ArrayList();

    /* renamed from: e */
    private volatile boolean f4592e = false;

    /* renamed from: f */
    private final AtomicInteger f4593f = new AtomicInteger(0);

    /* renamed from: g */
    private boolean f4594g = false;

    /* renamed from: h */
    private final Handler f4595h;

    /* renamed from: i */
    private final Object f4596i = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzamh();
    }

    public zzl(Looper looper, zza zza2) {
        this.f4589b = zza2;
        this.f4595h = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.f4596i) {
                if (this.f4592e && this.f4589b.isConnected() && this.f4590c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f4589b.zzamh());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzab.zzy(connectionCallbacks);
        synchronized (this.f4596i) {
            contains = this.f4590c.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f4596i) {
            contains = this.f4591d.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzab.zzy(connectionCallbacks);
        synchronized (this.f4596i) {
            if (this.f4590c.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f4590c.add(connectionCallbacks);
            }
        }
        if (this.f4589b.isConnected()) {
            this.f4595h.sendMessage(this.f4595h.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f4596i) {
            if (this.f4591d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f4591d.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzab.zzy(connectionCallbacks);
        synchronized (this.f4596i) {
            if (!this.f4590c.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.f4594g) {
                this.f4588a.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f4596i) {
            if (!this.f4591d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public void zzasw() {
        this.f4592e = false;
        this.f4593f.incrementAndGet();
    }

    public void zzasx() {
        this.f4592e = true;
    }

    public void zzgf(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f4595h.getLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f4595h.removeMessages(1);
        synchronized (this.f4596i) {
            this.f4594g = true;
            ArrayList arrayList = new ArrayList(this.f4590c);
            int i2 = this.f4593f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f4592e || this.f4593f.get() != i2) {
                    break;
                } else if (this.f4590c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f4588a.clear();
            this.f4594g = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r1 = 1
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r2 = r5.f4595h
            android.os.Looper r2 = r2.getLooper()
            if (r0 != r2) goto L_0x0046
            r0 = r1
        L_0x000e:
            java.lang.String r2 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzab.zza((boolean) r0, (java.lang.Object) r2)
            android.os.Handler r0 = r5.f4595h
            r0.removeMessages(r1)
            java.lang.Object r1 = r5.f4596i
            monitor-enter(r1)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            java.util.ArrayList r2 = r5.f4591d     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f4593f     // Catch:{ all -> 0x0054 }
            int r2 = r2.get()     // Catch:{ all -> 0x0054 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x002c:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0     // Catch:{ all -> 0x0054 }
            boolean r4 = r5.f4592e     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f4593f     // Catch:{ all -> 0x0054 }
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
            java.util.ArrayList r4 = r5.f4591d     // Catch:{ all -> 0x0054 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzl.zzm(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzo(Bundle bundle) {
        boolean z = true;
        zzab.zza(Looper.myLooper() == this.f4595h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f4596i) {
            zzab.zzbn(!this.f4594g);
            this.f4595h.removeMessages(1);
            this.f4594g = true;
            if (this.f4588a.size() != 0) {
                z = false;
            }
            zzab.zzbn(z);
            ArrayList arrayList = new ArrayList(this.f4590c);
            int i = this.f4593f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f4592e || !this.f4589b.isConnected() || this.f4593f.get() != i) {
                    break;
                } else if (!this.f4588a.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f4588a.clear();
            this.f4594g = false;
        }
    }
}
