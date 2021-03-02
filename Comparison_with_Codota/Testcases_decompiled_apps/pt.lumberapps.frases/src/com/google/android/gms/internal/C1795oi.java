package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p009v4.p019f.C0136a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzpm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.internal.oi */
final class C1795oi implements zzqh {

    /* renamed from: a */
    private final Context f5425a;

    /* renamed from: b */
    private final zzpy f5426b;

    /* renamed from: c */
    private final Looper f5427c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzqa f5428d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzqa f5429e;

    /* renamed from: f */
    private final Map f5430f;

    /* renamed from: g */
    private final Set f5431g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: h */
    private final Api.zze f5432h;

    /* renamed from: i */
    private Bundle f5433i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ConnectionResult f5434j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ConnectionResult f5435k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f5436l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Lock f5437m;

    /* renamed from: n */
    private int f5438n = 0;

    private C1795oi(Context context, zzpy zzpy, Lock lock, Looper looper, zzc zzc, Map map, Map map2, zzg zzg, Api.zza zza, Api.zze zze, ArrayList arrayList, ArrayList arrayList2, Map map3, Map map4) {
        this.f5425a = context;
        this.f5426b = zzpy;
        this.f5437m = lock;
        this.f5427c = looper;
        this.f5432h = zze;
        this.f5428d = new zzqa(context, this.f5426b, lock, looper, zzc, map2, (zzg) null, map4, (Api.zza) null, arrayList2, new C1797ok(this, (C1796oj) null));
        this.f5429e = new zzqa(context, this.f5426b, lock, looper, zzc, map, zzg, map3, zza, arrayList, new C1798ol(this, (C1796oj) null));
        C0136a aVar = new C0136a();
        for (Api.zzc put : map2.keySet()) {
            aVar.put(put, this.f5428d);
        }
        for (Api.zzc put2 : map.keySet()) {
            aVar.put(put2, this.f5429e);
        }
        this.f5430f = Collections.unmodifiableMap(aVar);
    }

    /* renamed from: a */
    public static C1795oi m6509a(Context context, zzpy zzpy, Lock lock, Looper looper, zzc zzc, Map map, zzg zzg, Map map2, Api.zza zza, ArrayList arrayList) {
        Api.zze zze = null;
        C0136a aVar = new C0136a();
        C0136a aVar2 = new C0136a();
        for (Map.Entry entry : map.entrySet()) {
            Api.zze zze2 = (Api.zze) entry.getValue();
            if (zze2.zzafz()) {
                zze = zze2;
            }
            if (zze2.zzafk()) {
                aVar.put((Api.zzc) entry.getKey(), zze2);
            } else {
                aVar2.put((Api.zzc) entry.getKey(), zze2);
            }
        }
        zzab.zza(!aVar.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        C0136a aVar3 = new C0136a();
        C0136a aVar4 = new C0136a();
        for (Api api : map2.keySet()) {
            Api.zzc zzans = api.zzans();
            if (aVar.containsKey(zzans)) {
                aVar3.put(api, (Integer) map2.get(api));
            } else if (aVar2.containsKey(zzans)) {
                aVar4.put(api, (Integer) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzpp zzpp = (zzpp) it.next();
            if (aVar3.containsKey(zzpp.f6808pN)) {
                arrayList2.add(zzpp);
            } else if (aVar4.containsKey(zzpp.f6808pN)) {
                arrayList3.add(zzpp);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new C1795oi(context, zzpy, lock, looper, zzc, aVar, aVar2, zzg, zza, zze, arrayList2, arrayList3, aVar3, aVar4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6511a(int i, boolean z) {
        this.f5426b.zzc(i, z);
        this.f5435k = null;
        this.f5434j = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6512a(Bundle bundle) {
        if (this.f5433i == null) {
            this.f5433i = bundle;
        } else if (bundle != null) {
            this.f5433i.putAll(bundle);
        }
    }

    /* renamed from: a */
    private void m6513a(ConnectionResult connectionResult) {
        switch (this.f5438n) {
            case 1:
                break;
            case 2:
                this.f5426b.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m6527e();
        this.f5438n = 0;
    }

    /* renamed from: a */
    private boolean m6517a(zzpm.zza zza) {
        Api.zzc zzans = zza.zzans();
        zzab.zzb(this.f5430f.containsKey(zzans), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzqa) this.f5430f.get(zzans)).equals(this.f5429e);
    }

    /* renamed from: b */
    private void m6519b() {
        this.f5435k = null;
        this.f5434j = null;
        this.f5428d.connect();
        this.f5429e.connect();
    }

    /* renamed from: b */
    private static boolean m6521b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6522c() {
        if (m6521b(this.f5434j)) {
            if (m6521b(this.f5435k) || m6529f()) {
                m6525d();
            } else if (this.f5435k == null) {
            } else {
                if (this.f5438n == 1) {
                    m6527e();
                    return;
                }
                m6513a(this.f5435k);
                this.f5428d.disconnect();
            }
        } else if (this.f5434j != null && m6521b(this.f5435k)) {
            this.f5429e.disconnect();
            m6513a(this.f5434j);
        } else if (this.f5434j != null && this.f5435k != null) {
            ConnectionResult connectionResult = this.f5434j;
            if (this.f5429e.f6866f < this.f5428d.f6866f) {
                connectionResult = this.f5435k;
            }
            m6513a(connectionResult);
        }
    }

    /* renamed from: d */
    private void m6525d() {
        switch (this.f5438n) {
            case 1:
                break;
            case 2:
                this.f5426b.zzm(this.f5433i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m6527e();
        this.f5438n = 0;
    }

    /* renamed from: e */
    private void m6527e() {
        for (zzqt zzafy : this.f5431g) {
            zzafy.zzafy();
        }
        this.f5431g.clear();
    }

    /* renamed from: f */
    private boolean m6529f() {
        return this.f5435k != null && this.f5435k.getErrorCode() == 4;
    }

    /* renamed from: g */
    private PendingIntent m6530g() {
        if (this.f5432h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f5425a, this.f5426b.getSessionId(), this.f5432h.zzaga(), 134217728);
    }

    /* renamed from: a */
    public boolean mo7607a() {
        return this.f5429e.isConnected();
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.f5438n = 2;
        this.f5436l = false;
        m6519b();
    }

    public void disconnect() {
        this.f5435k = null;
        this.f5434j = null;
        this.f5438n = 0;
        this.f5428d.disconnect();
        this.f5429e.disconnect();
        m6527e();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f5429e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f5428d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public ConnectionResult getConnectionResult(Api api) {
        return ((zzqa) this.f5430f.get(api.zzans())).equals(this.f5429e) ? m6529f() ? new ConnectionResult(4, m6530g()) : this.f5429e.getConnectionResult(api) : this.f5428d.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.f5437m.lock();
        try {
            if (!this.f5428d.isConnected() || (!mo7607a() && !m6529f() && this.f5438n != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.f5437m.unlock();
        }
    }

    public boolean isConnecting() {
        this.f5437m.lock();
        try {
            return this.f5438n == 2;
        } finally {
            this.f5437m.unlock();
        }
    }

    public boolean zza(zzqt zzqt) {
        this.f5437m.lock();
        try {
            if ((isConnecting() || isConnected()) && !mo7607a()) {
                this.f5431g.add(zzqt);
                if (this.f5438n == 0) {
                    this.f5438n = 1;
                }
                this.f5435k = null;
                this.f5429e.connect();
                return true;
            }
            this.f5437m.unlock();
            return false;
        } finally {
            this.f5437m.unlock();
        }
    }

    public void zzaof() {
        this.f5437m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.f5429e.disconnect();
            this.f5435k = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.f5427c).post(new C1796oj(this));
            } else {
                m6527e();
            }
        } finally {
            this.f5437m.unlock();
        }
    }

    public void zzapb() {
        this.f5428d.zzapb();
        this.f5429e.zzapb();
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        if (!m6517a(zza)) {
            return this.f5428d.zzc(zza);
        }
        if (!m6529f()) {
            return this.f5429e.zzc(zza);
        }
        zza.zzz(new Status(4, (String) null, m6530g()));
        return zza;
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        if (!m6517a(zza)) {
            return this.f5428d.zzd(zza);
        }
        if (!m6529f()) {
            return this.f5429e.zzd(zza);
        }
        zza.zzz(new Status(4, (String) null, m6530g()));
        return zza;
    }
}
