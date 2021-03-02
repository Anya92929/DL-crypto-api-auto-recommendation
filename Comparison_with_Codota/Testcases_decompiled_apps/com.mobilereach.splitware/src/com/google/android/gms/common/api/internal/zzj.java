package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzj extends GoogleApiClient implements zzp.zza {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Lock zzXG;
    /* access modifiers changed from: private */
    public final int zzagp;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    final Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    private final zzk zzahL;
    private zzp zzahM = null;
    final Queue<zza.C0426zza<?, ?>> zzahN = new LinkedList();
    private volatile boolean zzahO;
    private long zzahP = 120000;
    private long zzahQ = 5000;
    private final zza zzahR;
    zzc zzahS;
    final Map<Api.zzc<?>, Api.zzb> zzahT;
    Set<Scope> zzahU = new HashSet();
    private final Set<zzq<?>> zzahV = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzahW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.zza zzahX;
    private final ArrayList<zzc> zzahY;
    private Integer zzahZ = null;
    final zzf zzahz;
    Set<zzx> zzaia = null;
    private final zzd zzaib = new zzd() {
        public void zzc(zze<?> zze) {
            zzj.this.zzahW.remove(zze);
            if (zze.zzpa() != null && zzj.this.zzahX != null) {
                zzj.this.zzahX.remove(zze.zzpa().intValue());
            }
        }
    };
    private final zzk.zza zzaic = new zzk.zza() {
        public boolean isConnected() {
            return zzj.this.isConnected();
        }

        public Bundle zzoi() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzj.this.zzpD();
                    return;
                case 2:
                    zzj.this.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    private static class zzb implements IBinder.DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzaii;
        private final WeakReference<com.google.android.gms.common.api.zza> zzaij;
        private final WeakReference<IBinder> zzaik;

        private zzb(zze zze, com.google.android.gms.common.api.zza zza, IBinder iBinder) {
            this.zzaij = new WeakReference<>(zza);
            this.zzaii = new WeakReference<>(zze);
            this.zzaik = new WeakReference<>(iBinder);
        }

        private void zzpI() {
            zze zze = (zze) this.zzaii.get();
            com.google.android.gms.common.api.zza zza = (com.google.android.gms.common.api.zza) this.zzaij.get();
            if (!(zza == null || zze == null)) {
                zza.remove(zze.zzpa().intValue());
            }
            IBinder iBinder = (IBinder) this.zzaik.get();
            if (this.zzaik != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzpI();
        }

        public void zzc(zze<?> zze) {
            zzpI();
        }
    }

    static class zzc extends zzn {
        private WeakReference<zzj> zzail;

        zzc(zzj zzj) {
            this.zzail = new WeakReference<>(zzj);
        }

        public void zzpJ() {
            zzj zzj = (zzj) this.zzail.get();
            if (zzj != null) {
                zzj.resume();
            }
        }
    }

    interface zzd {
        void zzc(zze<?> zze);
    }

    interface zze<A extends Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zzd zzd);

        void zzb(A a) throws DeadObjectException;

        Api.zzc<A> zzoR();

        Integer zzpa();

        void zzpe();

        void zzpg();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzj(Context context, Lock lock, Looper looper, zzf zzf, com.google.android.gms.common.zzc zzc2, Api.zza<? extends zzrn, zzro> zza2, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zzb> map2, int i, int i2, ArrayList<zzc> arrayList) {
        this.mContext = context;
        this.zzXG = lock;
        this.zzahL = new zzk(looper, this.zzaic);
        this.zzagr = looper;
        this.zzahR = new zza(looper);
        this.zzags = zzc2;
        this.zzagp = i;
        if (this.zzagp >= 0) {
            this.zzahZ = Integer.valueOf(i2);
        }
        this.zzahA = map;
        this.zzahT = map2;
        this.zzahY = arrayList;
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzahL.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzahL.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzahz = zzf;
        this.zzagt = zza2;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.zzXG.lock();
        try {
            if (zzpB()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public static int zza(Iterable<Api.zzb> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zzb next : iterable) {
            if (next.zzmE()) {
                z3 = true;
            }
            z2 = next.zznb() ? true : z2;
        }
        if (z3) {
            return (!z2 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzv zzv, final boolean z) {
        zzmf.zzamA.zzf(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzp */
            public void onResult(@NonNull Status status) {
                zzq.zzaf(zzj.this.mContext).zznr();
                if (status.isSuccess() && zzj.this.isConnected()) {
                    zzj.this.reconnect();
                }
                zzv.zza(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze<?> zze2, com.google.android.gms.common.api.zza zza2, IBinder iBinder) {
        if (zze2.isReady()) {
            zze2.zza(new zzb(zze2, zza2, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zze2.zza((zzd) null);
            zze2.cancel();
            zza2.remove(zze2.zzpa().intValue());
        } else {
            zzb zzb2 = new zzb(zze2, zza2, iBinder);
            zze2.zza(zzb2);
            try {
                iBinder.linkToDeath(zzb2, 0);
            } catch (RemoteException e) {
                zze2.cancel();
                zza2.remove(zze2.zzpa().intValue());
            }
        }
    }

    private void zzbB(int i) {
        if (this.zzahZ == null) {
            this.zzahZ = Integer.valueOf(i);
        } else if (this.zzahZ.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzbC(i) + ". Mode was already set to " + zzbC(this.zzahZ.intValue()));
        }
        if (this.zzahM == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zzb next : this.zzahT.values()) {
                if (next.zzmE()) {
                    z2 = true;
                }
                z = next.zznb() ? true : z;
            }
            switch (this.zzahZ.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        this.zzahM = new zzd(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY);
                        return;
                    }
                    break;
            }
            this.zzahM = new zzl(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY, this);
        }
    }

    static String zzbC(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpC() {
        this.zzahL.zzqR();
        this.zzahM.connect();
    }

    /* access modifiers changed from: private */
    public void zzpD() {
        this.zzXG.lock();
        try {
            if (zzpF()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                if (this.zzahZ == null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            return this.zzahM.blockingConnect();
        } finally {
            this.zzXG.unlock();
        }
    }

    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzx.zzb(unit, (Object) "TimeUnit must not be null");
        this.zzXG.lock();
        try {
            if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            return this.zzahM.blockingConnect(timeout, unit);
        } finally {
            this.zzXG.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzx.zza(this.zzahZ.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzv zzv = new zzv((GoogleApiClient) this);
        if (this.zzahT.containsKey(zzmf.zzUI)) {
            zza((GoogleApiClient) this, zzv, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzmf.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                public void onConnected(Bundle connectionHint) {
                    zzj.this.zza((GoogleApiClient) atomicReference.get(), zzv, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(@NonNull ConnectionResult result) {
                    zzv.zza(new Status(8));
                }
            }).setHandler(this.zzahR).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzv;
    }

    public void connect() {
        boolean z = false;
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                if (this.zzahZ != null) {
                    z = true;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzahZ.intValue());
        } finally {
            this.zzXG.unlock();
        }
    }

    public void connect(int signInMode) {
        boolean z = true;
        this.zzXG.lock();
        if (!(signInMode == 3 || signInMode == 1 || signInMode == 2)) {
            z = false;
        }
        try {
            zzx.zzb(z, (Object) "Illegal sign-in mode: " + signInMode);
            zzbB(signInMode);
            zzpC();
        } finally {
            this.zzXG.unlock();
        }
    }

    public void disconnect() {
        this.zzXG.lock();
        try {
            zzaa(this.zzahM != null && !this.zzahM.disconnect());
            for (zzq<?> clear : this.zzahV) {
                clear.clear();
            }
            this.zzahV.clear();
            for (zze zze2 : this.zzahN) {
                zze2.zza((zzd) null);
                zze2.cancel();
            }
            this.zzahN.clear();
            if (this.zzahM != null) {
                zzpF();
                this.zzahL.zzqQ();
                this.zzXG.unlock();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mContext=").println(this.mContext);
        writer.append(prefix).append("mResuming=").print(this.zzahO);
        writer.append(" mWorkQueue.size()=").print(this.zzahN.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzahW.size());
        if (this.zzahM != null) {
            this.zzahM.dump(prefix, fd, writer, args);
        }
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzXG.lock();
        try {
            if (!isConnected() && !zzpB()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzahT.containsKey(api.zzoR())) {
                ConnectionResult connectionResult = this.zzahM.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzXG.unlock();
                } else if (zzpB()) {
                    connectionResult = ConnectionResult.zzafB;
                } else {
                    Log.i("GoogleApiClientImpl", zzpH());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed " + " connections map", new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.zzXG.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzagr;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zzb zzb2 = this.zzahT.get(api.zzoR());
        return zzb2 != null && zzb2.isConnected();
    }

    public boolean isConnected() {
        return this.zzahM != null && this.zzahM.isConnected();
    }

    public boolean isConnecting() {
        return this.zzahM != null && this.zzahM.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        return this.zzahL.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        return this.zzahL.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        this.zzahL.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzahL.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(@NonNull final FragmentActivity lifecycleActivity) {
        if (this.zzagp >= 0) {
            zzw zza2 = zzw.zza(lifecycleActivity);
            if (zza2 == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!lifecycleActivity.isFinishing() && !lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                            zzw.zzb(lifecycleActivity).zzbD(zzj.this.zzagp);
                        }
                    }
                });
            } else {
                zza2.zzbD(this.zzagp);
            }
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        this.zzahL.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzahL.unregisterConnectionFailedListener(listener);
    }

    @NonNull
    public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> zzc2) {
        C c = (Api.zzb) this.zzahT.get(zzc2);
        zzx.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C0426zza<R, A>> T zza(@NonNull T t) {
        zzx.zzb(t.zzoR() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzahT.containsKey(t.zzoR()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                this.zzahN.add(t);
            } else {
                t = this.zzahM.zza(t);
                this.zzXG.unlock();
            }
            return t;
        } finally {
            this.zzXG.unlock();
        }
    }

    public void zza(zzx zzx) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                this.zzaia = new HashSet();
            }
            this.zzaia.add(zzx);
        } finally {
            this.zzXG.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.zzahT.containsKey(api.zzoR());
    }

    public boolean zza(zzu zzu) {
        return this.zzahM != null && this.zzahM.zza(zzu);
    }

    /* access modifiers changed from: package-private */
    public void zzaa(boolean z) {
        for (zze next : this.zzahW) {
            if (next.zzpa() != null) {
                next.zzpe();
                zza((zze<?>) next, this.zzahX, zza(next.zzoR()).zzoT());
                this.zzahW.remove(next);
            } else if (z) {
                next.zzpg();
            } else {
                next.cancel();
                this.zzahW.remove(next);
            }
        }
    }

    public <A extends Api.zzb, T extends zza.C0426zza<? extends Result, A>> T zzb(@NonNull T t) {
        zzx.zzb(t.zzoR() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpB()) {
                this.zzahN.add(t);
                while (!this.zzahN.isEmpty()) {
                    zze remove = this.zzahN.remove();
                    zzb(remove);
                    remove.zzw(Status.zzagE);
                }
            } else {
                t = this.zzahM.zzb(t);
                this.zzXG.unlock();
            }
            return t;
        } finally {
            this.zzXG.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public <A extends Api.zzb> void zzb(zze<A> zze2) {
        this.zzahW.add(zze2);
        zze2.zza(this.zzaib);
    }

    public void zzb(zzx zzx) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzaia.remove(zzx)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzpG()) {
                this.zzahM.zzpj();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzpE();
        }
        for (zze next : this.zzahW) {
            if (z) {
                next.zzpe();
            }
            next.zzx(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzahW.clear();
        this.zzahL.zzbT(i);
        this.zzahL.zzqQ();
        if (i == 2) {
            zzpC();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.zzags.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzpF();
        }
        if (!zzpB()) {
            this.zzahL.zzk(connectionResult);
            this.zzahL.zzqQ();
        }
    }

    public void zzi(Bundle bundle) {
        while (!this.zzahN.isEmpty()) {
            zzb(this.zzahN.remove());
        }
        this.zzahL.zzk(bundle);
    }

    public void zzoW() {
        if (this.zzahM != null) {
            this.zzahM.zzoW();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzpB() {
        return this.zzahO;
    }

    /* access modifiers changed from: package-private */
    public void zzpE() {
        if (!zzpB()) {
            this.zzahO = true;
            if (this.zzahS == null) {
                this.zzahS = (zzc) zzn.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzags);
            }
            this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(1), this.zzahP);
            this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(2), this.zzahQ);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzpF() {
        if (!zzpB()) {
            return false;
        }
        this.zzahO = false;
        this.zzahR.removeMessages(2);
        this.zzahR.removeMessages(1);
        if (this.zzahS != null) {
            this.zzahS.unregister();
            this.zzahS = null;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zzpG() {
        boolean z = false;
        this.zzXG.lock();
        try {
            if (this.zzaia != null) {
                if (!this.zzaia.isEmpty()) {
                    z = true;
                }
                this.zzXG.unlock();
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public String zzpH() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        zzx.zzb(l, (Object) "Listener must not be null");
        this.zzXG.lock();
        try {
            zzq<L> zzq = new zzq<>(this.zzagr, l);
            this.zzahV.add(zzq);
            return zzq;
        } finally {
            this.zzXG.unlock();
        }
    }
}
