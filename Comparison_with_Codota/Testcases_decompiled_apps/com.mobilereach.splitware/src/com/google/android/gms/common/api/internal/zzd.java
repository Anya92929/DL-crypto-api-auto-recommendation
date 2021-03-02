package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
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
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Lock zzXG;
    private final zzj zzagW;
    /* access modifiers changed from: private */
    public final zzl zzagX;
    /* access modifiers changed from: private */
    public final zzl zzagY;
    private final Map<Api.zzc<?>, zzl> zzagZ = new ArrayMap();
    private final Looper zzagr;
    private final Set<zzu> zzaha = Collections.newSetFromMap(new WeakHashMap());
    private final Api.zzb zzahb;
    private Bundle zzahc;
    /* access modifiers changed from: private */
    public ConnectionResult zzahd = null;
    /* access modifiers changed from: private */
    public ConnectionResult zzahe = null;
    /* access modifiers changed from: private */
    public boolean zzahf = false;
    private int zzahg = 0;

    public zzd(Context context, zzj zzj, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zzb> map, zzf zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zza, ArrayList<zzc> arrayList) {
        this.mContext = context;
        this.zzagW = zzj;
        this.zzXG = lock;
        this.zzagr = looper;
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
        this.zzahb = zzb;
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
        this.zzagX = new zzl(context, this.zzagW, lock, looper, zzc, arrayMap2, (zzf) null, arrayMap4, (Api.zza<? extends zzrn, zzro>) null, arrayList3, new zzp.zza() {
            public void zzc(int i, boolean z) {
                zzd.this.zzXG.lock();
                try {
                    if (zzd.this.zzahf || zzd.this.zzahe == null || !zzd.this.zzahe.isSuccess()) {
                        boolean unused = zzd.this.zzahf = false;
                        zzd.this.zzb(i, z);
                        return;
                    }
                    boolean unused2 = zzd.this.zzahf = true;
                    zzd.this.zzagY.onConnectionSuspended(i);
                    zzd.this.zzXG.unlock();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.zzXG.lock();
                try {
                    ConnectionResult unused = zzd.this.zzahd = connectionResult;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                zzd.this.zzXG.lock();
                try {
                    zzd.this.zzh(bundle);
                    ConnectionResult unused = zzd.this.zzahd = ConnectionResult.zzafB;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }
        });
        this.zzagY = new zzl(context, this.zzagW, lock, looper, zzc, arrayMap, zzf, arrayMap3, zza, arrayList2, new zzp.zza() {
            public void zzc(int i, boolean z) {
                zzd.this.zzXG.lock();
                try {
                    if (zzd.this.zzahf) {
                        boolean unused = zzd.this.zzahf = false;
                        zzd.this.zzb(i, z);
                        return;
                    }
                    boolean unused2 = zzd.this.zzahf = true;
                    zzd.this.zzagX.onConnectionSuspended(i);
                    zzd.this.zzXG.unlock();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.zzXG.lock();
                try {
                    ConnectionResult unused = zzd.this.zzahe = connectionResult;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            public void zzi(@Nullable Bundle bundle) {
                zzd.this.zzXG.lock();
                try {
                    ConnectionResult unused = zzd.this.zzahe = ConnectionResult.zzafB;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }
        });
        for (Api.zzc put : arrayMap2.keySet()) {
            this.zzagZ.put(put, this.zzagX);
        }
        for (Api.zzc put2 : arrayMap.keySet()) {
            this.zzagZ.put(put2, this.zzagY);
        }
    }

    /* access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.zzagW.zzc(i, z);
        this.zzahe = null;
        this.zzahd = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.zzahg) {
            case 1:
                break;
            case 2:
                this.zzagW.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzpo();
        this.zzahg = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zzc(zza.C0426zza<? extends Result, ? extends Api.zzb> zza) {
        Api.zzc<? extends Api.zzb> zzoR = zza.zzoR();
        zzx.zzb(this.zzagZ.containsKey(zzoR), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzagZ.get(zzoR).equals(this.zzagY);
    }

    /* access modifiers changed from: private */
    public void zzh(Bundle bundle) {
        if (this.zzahc == null) {
            this.zzahc = bundle;
        } else if (bundle != null) {
            this.zzahc.putAll(bundle);
        }
    }

    private void zzpl() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzagX.connect();
        this.zzagY.connect();
    }

    /* access modifiers changed from: private */
    public void zzpm() {
        if (zzc(this.zzahd)) {
            if (zzc(this.zzahe) || zzpp()) {
                zzpn();
            } else if (this.zzahe == null) {
            } else {
                if (this.zzahg == 1) {
                    zzpo();
                    return;
                }
                zzb(this.zzahe);
                this.zzagX.disconnect();
            }
        } else if (this.zzahd != null && zzc(this.zzahe)) {
            this.zzagY.disconnect();
            zzb(this.zzahd);
        } else if (this.zzahd != null && this.zzahe != null) {
            ConnectionResult connectionResult = this.zzahd;
            if (this.zzagY.zzair < this.zzagX.zzair) {
                connectionResult = this.zzahe;
            }
            zzb(connectionResult);
        }
    }

    private void zzpn() {
        switch (this.zzahg) {
            case 1:
                break;
            case 2:
                this.zzagW.zzi(this.zzahc);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        zzpo();
        this.zzahg = 0;
    }

    private void zzpo() {
        for (zzu zzna : this.zzaha) {
            zzna.zzna();
        }
        this.zzaha.clear();
    }

    private boolean zzpp() {
        return this.zzahe != null && this.zzahe.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzpq() {
        if (this.zzahb == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzagW.getSessionId(), this.zzahb.zznc(), 134217728);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.zzahg = 2;
        this.zzahf = false;
        zzpl();
    }

    public boolean disconnect() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzahg = 0;
        boolean disconnect = this.zzagX.disconnect();
        boolean disconnect2 = this.zzagY.disconnect();
        zzpo();
        return disconnect && disconnect2;
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("authClient").println(":");
        this.zzagY.dump(prefix + "  ", fd, writer, args);
        writer.append(prefix).append("anonClient").println(":");
        this.zzagX.dump(prefix + "  ", fd, writer, args);
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        if (this.zzagZ.get(api.zzoR()).equals(this.zzagY)) {
            return zzpp() ? new ConnectionResult(4, zzpq()) : this.zzagY.getConnectionResult(api);
        }
        return this.zzagX.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.zzXG.lock();
        try {
            if (!this.zzagX.isConnected() || (!zzpk() && !zzpp() && this.zzahg != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    public boolean isConnecting() {
        this.zzXG.lock();
        try {
            return this.zzahg == 2;
        } finally {
            this.zzXG.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0426zza<R, A>> T zza(@NonNull T t) {
        if (!zzc((zza.C0426zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzagX.zza(t);
        }
        if (!zzpp()) {
            return this.zzagY.zza(t);
        }
        t.zzw(new Status(4, (String) null, zzpq()));
        return t;
    }

    public boolean zza(zzu zzu) {
        this.zzXG.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzpk()) {
                this.zzaha.add(zzu);
                if (this.zzahg == 0) {
                    this.zzahg = 1;
                }
                this.zzahe = null;
                this.zzagY.connect();
                return true;
            }
            this.zzXG.unlock();
            return false;
        } finally {
            this.zzXG.unlock();
        }
    }

    public <A extends Api.zzb, T extends zza.C0426zza<? extends Result, A>> T zzb(@NonNull T t) {
        if (!zzc((zza.C0426zza<? extends Result, ? extends Api.zzb>) t)) {
            return this.zzagX.zzb(t);
        }
        if (!zzpp()) {
            return this.zzagY.zzb(t);
        }
        t.zzw(new Status(4, (String) null, zzpq()));
        return t;
    }

    public void zzoW() {
        this.zzXG.lock();
        try {
            boolean isConnecting = isConnecting();
            this.zzagY.disconnect();
            this.zzahe = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzagr).post(new Runnable() {
                    public void run() {
                        zzd.this.zzXG.lock();
                        try {
                            zzd.this.zzpm();
                        } finally {
                            zzd.this.zzXG.unlock();
                        }
                    }
                });
            } else {
                zzpo();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public void zzpj() {
        this.zzagX.zzpj();
        this.zzagY.zzpj();
    }

    public boolean zzpk() {
        return this.zzagY.isConnected();
    }
}
