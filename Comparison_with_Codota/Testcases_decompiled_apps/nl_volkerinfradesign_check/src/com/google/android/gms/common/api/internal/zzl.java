package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzl implements zzp {

    /* renamed from: a */
    final Map<Api.zzc<?>, Api.zzb> f2777a;

    /* renamed from: b */
    final Map<Api.zzc<?>, ConnectionResult> f2778b = new HashMap();

    /* renamed from: c */
    final zzf f2779c;

    /* renamed from: d */
    final Map<Api<?>, Integer> f2780d;

    /* renamed from: e */
    final Api.zza<? extends zzrn, zzro> f2781e;

    /* renamed from: f */
    int f2782f;

    /* renamed from: g */
    final zzj f2783g;

    /* renamed from: h */
    final zzp.zza f2784h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Lock f2785i;

    /* renamed from: j */
    private final Condition f2786j;

    /* renamed from: k */
    private final Context f2787k;

    /* renamed from: l */
    private final zzc f2788l;

    /* renamed from: m */
    private final C0713b f2789m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public volatile zzk f2790n;

    /* renamed from: o */
    private ConnectionResult f2791o = null;

    /* renamed from: com.google.android.gms.common.api.internal.zzl$a */
    static abstract class C0712a {

        /* renamed from: a */
        private final zzk f2792a;

        protected C0712a(zzk zzk) {
            this.f2792a = zzk;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5184a();

        /* renamed from: a */
        public final void mo5218a(zzl zzl) {
            zzl.f2785i.lock();
            try {
                if (zzl.f2790n == this.f2792a) {
                    mo5184a();
                    zzl.f2785i.unlock();
                }
            } finally {
                zzl.f2785i.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzl$b */
    final class C0713b extends Handler {
        C0713b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((C0712a) message.obj).mo5218a(zzl.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzl(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zza, ArrayList<zzc> arrayList, zzp.zza zza2) {
        this.f2787k = context;
        this.f2785i = lock;
        this.f2788l = zzc;
        this.f2777a = map;
        this.f2779c = zzf;
        this.f2780d = map2;
        this.f2781e = zza;
        this.f2783g = zzj;
        this.f2784h = zza2;
        Iterator<zzc> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.f2789m = new C0713b(looper);
        this.f2786j = lock.newCondition();
        this.f2790n = new zzi(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5209a() {
        this.f2785i.lock();
        try {
            this.f2790n = new zzh(this, this.f2779c, this.f2780d, this.f2788l, this.f2781e, this.f2785i, this.f2787k);
            this.f2790n.begin();
            this.f2786j.signalAll();
        } finally {
            this.f2785i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5210a(ConnectionResult connectionResult) {
        this.f2785i.lock();
        try {
            this.f2791o = connectionResult;
            this.f2790n = new zzi(this);
            this.f2790n.begin();
            this.f2786j.signalAll();
        } finally {
            this.f2785i.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5211a(C0712a aVar) {
        this.f2789m.sendMessage(this.f2789m.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5212a(RuntimeException runtimeException) {
        this.f2789m.sendMessage(this.f2789m.obtainMessage(2, runtimeException));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5213b() {
        this.f2785i.lock();
        try {
            this.f2783g.mo5193d();
            this.f2790n = new zzg(this);
            this.f2790n.begin();
            this.f2786j.signalAll();
        } finally {
            this.f2785i.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f2786j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        return isConnected() ? ConnectionResult.zzafB : this.f2791o != null ? this.f2791o : new ConnectionResult(13, (PendingIntent) null);
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
                nanos = this.f2786j.awaitNanos(nanos);
            }
        }
        return isConnected() ? ConnectionResult.zzafB : this.f2791o != null ? this.f2791o : new ConnectionResult(13, (PendingIntent) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5214c() {
        for (Api.zzb disconnect : this.f2777a.values()) {
            disconnect.disconnect();
        }
    }

    public void connect() {
        this.f2790n.connect();
    }

    public boolean disconnect() {
        boolean disconnect = this.f2790n.disconnect();
        if (disconnect) {
            this.f2778b.clear();
        }
        return disconnect;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (Api next : this.f2780d.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.f2777a.get(next.zzoR()).dump(str2, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzoR = api.zzoR();
        if (this.f2777a.containsKey(zzoR)) {
            if (this.f2777a.get(zzoR).isConnected()) {
                return ConnectionResult.zzafB;
            }
            if (this.f2778b.containsKey(zzoR)) {
                return this.f2778b.get(zzoR);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.f2790n instanceof zzg;
    }

    public boolean isConnecting() {
        return this.f2790n instanceof zzh;
    }

    public void onConnected(@Nullable Bundle bundle) {
        this.f2785i.lock();
        try {
            this.f2790n.onConnected(bundle);
        } finally {
            this.f2785i.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f2785i.lock();
        try {
            this.f2790n.onConnectionSuspended(i);
        } finally {
            this.f2785i.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(@NonNull T t) {
        return this.f2790n.zza(t);
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.f2785i.lock();
        try {
            this.f2790n.zza(connectionResult, api, i);
        } finally {
            this.f2785i.unlock();
        }
    }

    public boolean zza(zzu zzu) {
        return false;
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(@NonNull T t) {
        return this.f2790n.zzb(t);
    }

    public void zzoW() {
    }

    public void zzpj() {
        if (isConnected()) {
            ((zzg) this.f2790n).mo5175a();
        }
    }
}
