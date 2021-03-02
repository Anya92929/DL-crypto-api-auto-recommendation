package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
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

public class zzd implements zzp {

    /* renamed from: a */
    private final Context f2673a;

    /* renamed from: b */
    private final zzj f2674b;

    /* renamed from: c */
    private final Looper f2675c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzl f2676d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final zzl f2677e;

    /* renamed from: f */
    private final Map<Api.zzc<?>, zzl> f2678f = new ArrayMap();

    /* renamed from: g */
    private final Set<zzu> f2679g = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: h */
    private final Api.zzb f2680h;

    /* renamed from: i */
    private Bundle f2681i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ConnectionResult f2682j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ConnectionResult f2683k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2684l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Lock f2685m;

    /* renamed from: n */
    private int f2686n = 0;

    public zzd(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zza, ArrayList<zzc> arrayList) {
        this.f2673a = context;
        this.f2674b = zzj;
        this.f2685m = lock;
        this.f2675c = looper;
        Api.zzb zzb = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Api.zzc next : map.keySet()) {
            Api.zzb zzb2 = map.get(next);
            zzb = zzb2.zznb() ? zzb2 : zzb;
            if (zzb2.zzmE()) {
                arrayMap.put(next, zzb2);
            } else {
                arrayMap2.put(next, zzb2);
            }
        }
        this.f2680h = zzb;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.zzc<?> zzoR = next2.zzoR();
            if (arrayMap.containsKey(zzoR)) {
                arrayMap3.put(next2, map2.get(next2));
            } else if (arrayMap2.containsKey(zzoR)) {
                arrayMap4.put(next2, map2.get(next2));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<zzc> it = arrayList.iterator();
        while (it.hasNext()) {
            zzc next3 = it.next();
            if (arrayMap3.containsKey(next3.zzagT)) {
                arrayList2.add(next3);
            } else if (arrayMap4.containsKey(next3.zzagT)) {
                arrayList3.add(next3);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        this.f2676d = new zzl(context, this.f2674b, lock, looper, zzc, arrayMap2, (zzf) null, arrayMap4, (Api.zza<? extends zzrn, zzro>) null, arrayList3, new zzp.zza() {
            public void zzc(int i, boolean z) {
                zzd.this.f2685m.lock();
                try {
                    if (zzd.this.f2684l || zzd.this.f2683k == null || !zzd.this.f2683k.isSuccess()) {
                        boolean unused = zzd.this.f2684l = false;
                        zzd.this.m3721a(i, z);
                        return;
                    }
                    boolean unused2 = zzd.this.f2684l = true;
                    zzd.this.f2677e.onConnectionSuspended(i);
                    zzd.this.f2685m.unlock();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.f2685m.lock();
                try {
                    ConnectionResult unused = zzd.this.f2682j = connectionResult;
                    zzd.this.m3729b();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                zzd.this.f2685m.lock();
                try {
                    zzd.this.m3722a(bundle);
                    ConnectionResult unused = zzd.this.f2682j = ConnectionResult.zzafB;
                    zzd.this.m3729b();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }
        });
        this.f2677e = new zzl(context, this.f2674b, lock, looper, zzc, arrayMap, zzf, arrayMap3, zza, arrayList2, new zzp.zza() {
            public void zzc(int i, boolean z) {
                zzd.this.f2685m.lock();
                try {
                    if (zzd.this.f2684l) {
                        boolean unused = zzd.this.f2684l = false;
                        zzd.this.m3721a(i, z);
                        return;
                    }
                    boolean unused2 = zzd.this.f2684l = true;
                    zzd.this.f2676d.onConnectionSuspended(i);
                    zzd.this.f2685m.unlock();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.f2685m.lock();
                try {
                    ConnectionResult unused = zzd.this.f2683k = connectionResult;
                    zzd.this.m3729b();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                zzd.this.f2685m.lock();
                try {
                    ConnectionResult unused = zzd.this.f2683k = ConnectionResult.zzafB;
                    zzd.this.m3729b();
                } finally {
                    zzd.this.f2685m.unlock();
                }
            }
        });
        for (Api.zzc put : arrayMap2.keySet()) {
            this.f2678f.put(put, this.f2676d);
        }
        for (Api.zzc put2 : arrayMap.keySet()) {
            this.f2678f.put(put2, this.f2677e);
        }
    }

    /* renamed from: a */
    private void m3720a() {
        this.f2683k = null;
        this.f2682j = null;
        this.f2676d.connect();
        this.f2677e.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3721a(int i, boolean z) {
        this.f2674b.zzc(i, z);
        this.f2683k = null;
        this.f2682j = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3722a(Bundle bundle) {
        if (this.f2681i == null) {
            this.f2681i = bundle;
        } else if (bundle != null) {
            this.f2681i.putAll(bundle);
        }
    }

    /* renamed from: a */
    private void m3723a(ConnectionResult connectionResult) {
        switch (this.f2686n) {
            case 1:
                break;
            case 2:
                this.f2674b.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m3735d();
        this.f2686n = 0;
    }

    /* renamed from: a */
    private boolean m3726a(zza.C2020zza<? extends Result, ? extends Api.zzb> zza) {
        Api.zzc<? extends Api.zzb> zzoR = zza.zzoR();
        zzx.zzb(this.f2678f.containsKey(zzoR), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return this.f2678f.get(zzoR).equals(this.f2677e);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3729b() {
        if (m3731b(this.f2682j)) {
            if (m3731b(this.f2683k) || m3737e()) {
                m3732c();
            } else if (this.f2683k == null) {
            } else {
                if (this.f2686n == 1) {
                    m3735d();
                    return;
                }
                m3723a(this.f2683k);
                this.f2676d.disconnect();
            }
        } else if (this.f2682j != null && m3731b(this.f2683k)) {
            this.f2677e.disconnect();
            m3723a(this.f2682j);
        } else if (this.f2682j != null && this.f2683k != null) {
            ConnectionResult connectionResult = this.f2682j;
            if (this.f2677e.f2782f < this.f2676d.f2782f) {
                connectionResult = this.f2683k;
            }
            m3723a(connectionResult);
        }
    }

    /* renamed from: b */
    private static boolean m3731b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    /* renamed from: c */
    private void m3732c() {
        switch (this.f2686n) {
            case 1:
                break;
            case 2:
                this.f2674b.zzi(this.f2681i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m3735d();
        this.f2686n = 0;
    }

    /* renamed from: d */
    private void m3735d() {
        for (zzu zzna : this.f2679g) {
            zzna.zzna();
        }
        this.f2679g.clear();
    }

    /* renamed from: e */
    private boolean m3737e() {
        return this.f2683k != null && this.f2683k.getErrorCode() == 4;
    }

    @Nullable
    /* renamed from: f */
    private PendingIntent m3738f() {
        if (this.f2680h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f2673a, this.f2674b.getSessionId(), this.f2680h.zznc(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.f2686n = 2;
        this.f2684l = false;
        m3720a();
    }

    public boolean disconnect() {
        this.f2683k = null;
        this.f2682j = null;
        this.f2686n = 0;
        boolean disconnect = this.f2676d.disconnect();
        boolean disconnect2 = this.f2677e.disconnect();
        m3735d();
        return disconnect && disconnect2;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f2677e.dump(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f2676d.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return this.f2678f.get(api.zzoR()).equals(this.f2677e) ? m3737e() ? new ConnectionResult(4, m3738f()) : this.f2677e.getConnectionResult(api) : this.f2676d.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.f2685m.lock();
        try {
            if (!this.f2676d.isConnected() || (!zzpk() && !m3737e() && this.f2686n != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.f2685m.unlock();
        }
    }

    public boolean isConnecting() {
        this.f2685m.lock();
        try {
            return this.f2686n == 2;
        } finally {
            this.f2685m.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(@NonNull T t) {
        if (!m3726a((zza.C2020zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.f2676d.zza(t);
        }
        if (!m3737e()) {
            return this.f2677e.zza(t);
        }
        t.zzw(new Status(4, (String) null, m3738f()));
        return t;
    }

    public boolean zza(zzu zzu) {
        this.f2685m.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzpk()) {
                this.f2679g.add(zzu);
                if (this.f2686n == 0) {
                    this.f2686n = 1;
                }
                this.f2683k = null;
                this.f2677e.connect();
                return true;
            }
            this.f2685m.unlock();
            return false;
        } finally {
            this.f2685m.unlock();
        }
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(@NonNull T t) {
        if (!m3726a((zza.C2020zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.f2676d.zzb(t);
        }
        if (!m3737e()) {
            return this.f2677e.zzb(t);
        }
        t.zzw(new Status(4, (String) null, m3738f()));
        return t;
    }

    public void zzoW() {
        this.f2685m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.f2677e.disconnect();
            this.f2683k = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.f2675c).post(new Runnable() {
                    public void run() {
                        zzd.this.f2685m.lock();
                        try {
                            zzd.this.m3729b();
                        } finally {
                            zzd.this.f2685m.unlock();
                        }
                    }
                });
            } else {
                m3735d();
            }
        } finally {
            this.f2685m.unlock();
        }
    }

    public void zzpj() {
        this.f2676d.zzpj();
        this.f2677e.zzpj();
    }

    public boolean zzpk() {
        return this.f2677e.isConnected();
    }
}
