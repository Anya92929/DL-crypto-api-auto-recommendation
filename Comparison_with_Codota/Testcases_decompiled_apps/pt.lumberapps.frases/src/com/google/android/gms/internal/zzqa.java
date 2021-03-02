package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzqh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqa implements zzqh {

    /* renamed from: a */
    final Map f6861a;

    /* renamed from: b */
    final Map f6862b = new HashMap();

    /* renamed from: c */
    final zzg f6863c;

    /* renamed from: d */
    final Map f6864d;

    /* renamed from: e */
    final Api.zza f6865e;

    /* renamed from: f */
    int f6866f;

    /* renamed from: g */
    final zzpy f6867g;

    /* renamed from: h */
    final zzqh.zza f6868h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Lock f6869i;

    /* renamed from: j */
    private final Condition f6870j;

    /* renamed from: k */
    private final Context f6871k;

    /* renamed from: l */
    private final zzc f6872l;

    /* renamed from: m */
    private final C1819pf f6873m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile zzpz f6874n;

    /* renamed from: o */
    private ConnectionResult f6875o = null;

    public zzqa(Context context, zzpy zzpy, Lock lock, Looper looper, zzc zzc, Map map, zzg zzg, Map map2, Api.zza zza, ArrayList arrayList, zzqh.zza zza2) {
        this.f6871k = context;
        this.f6869i = lock;
        this.f6872l = zzc;
        this.f6861a = map;
        this.f6863c = zzg;
        this.f6864d = map2;
        this.f6865e = zza;
        this.f6867g = zzpy;
        this.f6868h = zza2;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzpp) it.next()).zza(this);
        }
        this.f6873m = new C1819pf(this, looper);
        this.f6870j = lock.newCondition();
        this.f6874n = new zzpx(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8956a() {
        this.f6869i.lock();
        try {
            this.f6874n = new zzpw(this, this.f6863c, this.f6864d, this.f6872l, this.f6865e, this.f6869i, this.f6871k);
            this.f6874n.begin();
            this.f6870j.signalAll();
        } finally {
            this.f6869i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8957a(ConnectionResult connectionResult) {
        this.f6869i.lock();
        try {
            this.f6875o = connectionResult;
            this.f6874n = new zzpx(this);
            this.f6874n.begin();
            this.f6870j.signalAll();
        } finally {
            this.f6869i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8958a(C1818pe peVar) {
        this.f6873m.sendMessage(this.f6873m.obtainMessage(1, peVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8959a(RuntimeException runtimeException) {
        this.f6873m.sendMessage(this.f6873m.obtainMessage(2, runtimeException));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8960b() {
        this.f6869i.lock();
        try {
            this.f6867g.mo8952d();
            this.f6874n = new zzpv(this);
            this.f6874n.begin();
            this.f6870j.signalAll();
        } finally {
            this.f6869i.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f6870j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        return isConnected() ? ConnectionResult.f4269rb : this.f6875o != null ? this.f6875o : new ConnectionResult(13, (PendingIntent) null);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.f6870j.awaitNanos(nanos);
            }
        }
        return isConnected() ? ConnectionResult.f4269rb : this.f6875o != null ? this.f6875o : new ConnectionResult(13, (PendingIntent) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8961c() {
        for (Api.zze disconnect : this.f6861a.values()) {
            disconnect.disconnect();
        }
    }

    public void connect() {
        this.f6874n.connect();
    }

    public void disconnect() {
        if (this.f6874n.disconnect()) {
            this.f6862b.clear();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f6874n);
        for (Api api : this.f6864d.keySet()) {
            printWriter.append(str).append(api.getName()).println(":");
            ((Api.zze) this.f6861a.get(api.zzans())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public ConnectionResult getConnectionResult(Api api) {
        Api.zzc zzans = api.zzans();
        if (this.f6861a.containsKey(zzans)) {
            if (((Api.zze) this.f6861a.get(zzans)).isConnected()) {
                return ConnectionResult.f4269rb;
            }
            if (this.f6862b.containsKey(zzans)) {
                return (ConnectionResult) this.f6862b.get(zzans);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.f6874n instanceof zzpv;
    }

    public boolean isConnecting() {
        return this.f6874n instanceof zzpw;
    }

    public void onConnected(Bundle bundle) {
        this.f6869i.lock();
        try {
            this.f6874n.onConnected(bundle);
        } finally {
            this.f6869i.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f6869i.lock();
        try {
            this.f6874n.onConnectionSuspended(i);
        } finally {
            this.f6869i.unlock();
        }
    }

    public void zza(ConnectionResult connectionResult, Api api, int i) {
        this.f6869i.lock();
        try {
            this.f6874n.zza(connectionResult, api, i);
        } finally {
            this.f6869i.unlock();
        }
    }

    public boolean zza(zzqt zzqt) {
        return false;
    }

    public void zzaof() {
    }

    public void zzapb() {
        if (isConnected()) {
            ((zzpv) this.f6874n).mo8940a();
        }
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        zza.zzaow();
        return this.f6874n.zzc(zza);
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        zza.zzaow();
        return this.f6874n.zzd(zza);
    }
}
