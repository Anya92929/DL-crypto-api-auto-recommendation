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
import android.support.p001v4.app.FragmentActivity;
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
import com.google.android.gms.common.zzc;
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

    /* renamed from: a */
    final Queue<zza.C2020zza<?, ?>> f2733a = new LinkedList();

    /* renamed from: b */
    C0709c f2734b;

    /* renamed from: c */
    final Map<Api.zzc<?>, Api.zzb> f2735c;

    /* renamed from: d */
    Set<Scope> f2736d = new HashSet();

    /* renamed from: e */
    final zzf f2737e;

    /* renamed from: f */
    final Map<Api<?>, Integer> f2738f;

    /* renamed from: g */
    final Api.zza<? extends zzrn, zzro> f2739g;

    /* renamed from: h */
    final Set<C0711e<?>> f2740h = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));

    /* renamed from: i */
    Set<zzx> f2741i = null;

    /* renamed from: j */
    private final Lock f2742j;

    /* renamed from: k */
    private final zzk f2743k;

    /* renamed from: l */
    private zzp f2744l = null;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final int f2745m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Context f2746n;

    /* renamed from: o */
    private final Looper f2747o;

    /* renamed from: p */
    private volatile boolean f2748p;

    /* renamed from: q */
    private long f2749q = 120000;

    /* renamed from: r */
    private long f2750r = 5000;

    /* renamed from: s */
    private final C0707a f2751s;

    /* renamed from: t */
    private final zzc f2752t;

    /* renamed from: u */
    private final Set<zzq<?>> f2753u = Collections.newSetFromMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: v */
    public com.google.android.gms.common.api.zza f2754v;

    /* renamed from: w */
    private final ArrayList<zzc> f2755w;

    /* renamed from: x */
    private Integer f2756x = null;

    /* renamed from: y */
    private final C0710d f2757y = new C0710d() {
        /* renamed from: a */
        public void mo5197a(C0711e<?> eVar) {
            zzj.this.f2740h.remove(eVar);
            if (eVar.zzpa() != null && zzj.this.f2754v != null) {
                zzj.this.f2754v.remove(eVar.zzpa().intValue());
            }
        }
    };

    /* renamed from: z */
    private final zzk.zza f2758z = new zzk.zza() {
        public boolean isConnected() {
            return zzj.this.isConnected();
        }

        public Bundle zzoi() {
            return null;
        }
    };

    /* renamed from: com.google.android.gms.common.api.internal.zzj$a */
    final class C0707a extends Handler {
        C0707a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzj.this.m3794i();
                    return;
                case 2:
                    zzj.this.m3793h();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzj$b */
    static class C0708b implements IBinder.DeathRecipient, C0710d {

        /* renamed from: a */
        private final WeakReference<C0711e<?>> f2773a;

        /* renamed from: b */
        private final WeakReference<com.google.android.gms.common.api.zza> f2774b;

        /* renamed from: c */
        private final WeakReference<IBinder> f2775c;

        private C0708b(C0711e eVar, com.google.android.gms.common.api.zza zza, IBinder iBinder) {
            this.f2774b = new WeakReference<>(zza);
            this.f2773a = new WeakReference<>(eVar);
            this.f2775c = new WeakReference<>(iBinder);
        }

        /* renamed from: a */
        private void m3804a() {
            C0711e eVar = (C0711e) this.f2773a.get();
            com.google.android.gms.common.api.zza zza = (com.google.android.gms.common.api.zza) this.f2774b.get();
            if (!(zza == null || eVar == null)) {
                zza.remove(eVar.zzpa().intValue());
            }
            IBinder iBinder = (IBinder) this.f2775c.get();
            if (this.f2775c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        /* renamed from: a */
        public void mo5197a(C0711e<?> eVar) {
            m3804a();
        }

        public void binderDied() {
            m3804a();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzj$c */
    static class C0709c extends C1192hd {

        /* renamed from: a */
        private WeakReference<zzj> f2776a;

        C0709c(zzj zzj) {
            this.f2776a = new WeakReference<>(zzj);
        }

        /* renamed from: a */
        public void mo5134a() {
            zzj zzj = (zzj) this.f2776a.get();
            if (zzj != null) {
                zzj.m3793h();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzj$d */
    interface C0710d {
        /* renamed from: a */
        void mo5197a(C0711e<?> eVar);
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzj$e */
    interface C0711e<A extends Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(C0710d dVar);

        void zzb(A a) throws DeadObjectException;

        Api.zzc<A> zzoR();

        Integer zzpa();

        void zzpe();

        void zzpg();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzj(Context context, Lock lock, Looper looper, zzf zzf, zzc zzc, Api.zza<? extends zzrn, zzro> zza, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zzb> map2, int i, int i2, ArrayList<zzc> arrayList) {
        this.f2746n = context;
        this.f2742j = lock;
        this.f2743k = new zzk(looper, this.f2758z);
        this.f2747o = looper;
        this.f2751s = new C0707a(looper);
        this.f2752t = zzc;
        this.f2745m = i;
        if (this.f2745m >= 0) {
            this.f2756x = Integer.valueOf(i2);
        }
        this.f2738f = map;
        this.f2735c = map2;
        this.f2755w = arrayList;
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.f2743k.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.f2743k.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.f2737e = zzf;
        this.f2739g = zza;
    }

    /* renamed from: a */
    static String m3783a(int i) {
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

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3784a(final GoogleApiClient googleApiClient, final zzv zzv, final boolean z) {
        zzmf.zzamA.zzf(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: a */
            public void onResult(@NonNull Status status) {
                zzq.zzaf(zzj.this.f2746n).zznr();
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

    /* renamed from: a */
    private static void m3785a(C0711e<?> eVar, com.google.android.gms.common.api.zza zza, IBinder iBinder) {
        if (eVar.isReady()) {
            eVar.zza(new C0708b(eVar, zza, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            eVar.zza((C0710d) null);
            eVar.cancel();
            zza.remove(eVar.zzpa().intValue());
        } else {
            C0708b bVar = new C0708b(eVar, zza, iBinder);
            eVar.zza(bVar);
            try {
                iBinder.linkToDeath(bVar, 0);
            } catch (RemoteException e) {
                eVar.cancel();
                zza.remove(eVar.zzpa().intValue());
            }
        }
    }

    /* renamed from: b */
    private void m3787b(int i) {
        if (this.f2756x == null) {
            this.f2756x = Integer.valueOf(i);
        } else if (this.f2756x.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + m3783a(i) + ". Mode was already set to " + m3783a(this.f2756x.intValue()));
        }
        if (this.f2744l == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zzb next : this.f2735c.values()) {
                if (next.zzmE()) {
                    z2 = true;
                }
                z = next.zznb() ? true : z;
            }
            switch (this.f2756x.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        this.f2744l = new zzd(this.f2746n, this, this.f2742j, this.f2747o, this.f2752t, this.f2735c, this.f2737e, this.f2738f, this.f2739g, this.f2755w);
                        return;
                    }
                    break;
            }
            this.f2744l = new zzl(this.f2746n, this, this.f2742j, this.f2747o, this.f2752t, this.f2735c, this.f2737e, this.f2738f, this.f2739g, this.f2755w, this);
        }
    }

    /* renamed from: g */
    private void m3792g() {
        this.f2743k.zzqR();
        this.f2744l.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m3793h() {
        this.f2742j.lock();
        try {
            if (mo5191b()) {
                m3792g();
            }
        } finally {
            this.f2742j.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m3794i() {
        this.f2742j.lock();
        try {
            if (mo5193d()) {
                m3792g();
            }
        } finally {
            this.f2742j.unlock();
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

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public <A extends Api.zzb> void mo5189a(C0711e<A> eVar) {
        this.f2740h.add(eVar);
        eVar.zza(this.f2757y);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5190a(boolean z) {
        for (C0711e next : this.f2740h) {
            if (next.zzpa() != null) {
                next.zzpe();
                m3785a((C0711e<?>) next, this.f2754v, zza(next.zzoR()).zzoT());
                this.f2740h.remove(next);
            } else if (z) {
                next.zzpg();
            } else {
                next.cancel();
                this.f2740h.remove(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5191b() {
        return this.f2748p;
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f2742j.lock();
        try {
            if (this.f2745m >= 0) {
                if (this.f2756x == null) {
                    z = false;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f2756x == null) {
                this.f2756x = Integer.valueOf(zza(this.f2735c.values(), false));
            } else if (this.f2756x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m3787b(this.f2756x.intValue());
            this.f2743k.zzqR();
            return this.f2744l.blockingConnect();
        } finally {
            this.f2742j.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzx.zzb(timeUnit, (Object) "TimeUnit must not be null");
        this.f2742j.lock();
        try {
            if (this.f2756x == null) {
                this.f2756x = Integer.valueOf(zza(this.f2735c.values(), false));
            } else if (this.f2756x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m3787b(this.f2756x.intValue());
            this.f2743k.zzqR();
            return this.f2744l.blockingConnect(j, timeUnit);
        } finally {
            this.f2742j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5192c() {
        if (!mo5191b()) {
            this.f2748p = true;
            if (this.f2734b == null) {
                this.f2734b = (C0709c) C1192hd.m5261a(this.f2746n.getApplicationContext(), new C0709c(this), this.f2752t);
            }
            this.f2751s.sendMessageDelayed(this.f2751s.obtainMessage(1), this.f2749q);
            this.f2751s.sendMessageDelayed(this.f2751s.obtainMessage(2), this.f2750r);
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzx.zza(this.f2756x.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzv zzv = new zzv((GoogleApiClient) this);
        if (this.f2735c.containsKey(zzmf.zzUI)) {
            m3784a((GoogleApiClient) this, zzv, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.f2746n).addApi(zzmf.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                public void onConnected(Bundle bundle) {
                    zzj.this.m3784a((GoogleApiClient) atomicReference.get(), zzv, true);
                }

                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzv.zza(new Status(8));
                }
            }).setHandler(this.f2751s).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzv;
    }

    public void connect() {
        boolean z = false;
        this.f2742j.lock();
        try {
            if (this.f2745m >= 0) {
                if (this.f2756x != null) {
                    z = true;
                }
                zzx.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f2756x == null) {
                this.f2756x = Integer.valueOf(zza(this.f2735c.values(), false));
            } else if (this.f2756x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f2756x.intValue());
        } finally {
            this.f2742j.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.f2742j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzx.zzb(z, (Object) "Illegal sign-in mode: " + i);
            m3787b(i);
            m3792g();
        } finally {
            this.f2742j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5193d() {
        if (!mo5191b()) {
            return false;
        }
        this.f2748p = false;
        this.f2751s.removeMessages(2);
        this.f2751s.removeMessages(1);
        if (this.f2734b != null) {
            this.f2734b.mo8270b();
            this.f2734b = null;
        }
        return true;
    }

    public void disconnect() {
        this.f2742j.lock();
        try {
            mo5190a(this.f2744l != null && !this.f2744l.disconnect());
            for (zzq<?> clear : this.f2753u) {
                clear.clear();
            }
            this.f2753u.clear();
            for (C0711e eVar : this.f2733a) {
                eVar.zza((C0710d) null);
                eVar.cancel();
            }
            this.f2733a.clear();
            if (this.f2744l != null) {
                mo5193d();
                this.f2743k.zzqQ();
                this.f2742j.unlock();
            }
        } finally {
            this.f2742j.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f2746n);
        printWriter.append(str).append("mResuming=").print(this.f2748p);
        printWriter.append(" mWorkQueue.size()=").print(this.f2733a.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.f2740h.size());
        if (this.f2744l != null) {
            this.f2744l.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5194e() {
        boolean z = false;
        this.f2742j.lock();
        try {
            if (this.f2741i != null) {
                if (!this.f2741i.isEmpty()) {
                    z = true;
                }
                this.f2742j.unlock();
            }
            return z;
        } finally {
            this.f2742j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo5195f() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.f2742j.lock();
        try {
            if (!isConnected() && !mo5191b()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.f2735c.containsKey(api.zzoR())) {
                ConnectionResult connectionResult = this.f2744l.getConnectionResult(api);
                if (connectionResult != null) {
                    this.f2742j.unlock();
                } else if (mo5191b()) {
                    connectionResult = ConnectionResult.zzafB;
                } else {
                    Log.i("GoogleApiClientImpl", mo5195f());
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed " + " connections map", new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.f2742j.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.f2742j.unlock();
        }
    }

    public Context getContext() {
        return this.f2746n;
    }

    public Looper getLooper() {
        return this.f2747o;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zzb zzb = this.f2735c.get(api.zzoR());
        return zzb != null && zzb.isConnected();
    }

    public boolean isConnected() {
        return this.f2744l != null && this.f2744l.isConnected();
    }

    public boolean isConnecting() {
        return this.f2744l != null && this.f2744l.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f2743k.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f2743k.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f2743k.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f2743k.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(@NonNull final FragmentActivity fragmentActivity) {
        if (this.f2745m >= 0) {
            zzw zza = zzw.zza(fragmentActivity);
            if (zza == null) {
                new Handler(this.f2746n.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!fragmentActivity.isFinishing() && !fragmentActivity.getSupportFragmentManager().isDestroyed()) {
                            zzw.zzb(fragmentActivity).zzbD(zzj.this.f2745m);
                        }
                    }
                });
            } else {
                zza.zzbD(this.f2745m);
            }
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f2743k.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f2743k.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> zzc) {
        C c = (Api.zzb) this.f2735c.get(zzc);
        zzx.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(@NonNull T t) {
        zzx.zzb(t.zzoR() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.f2735c.containsKey(t.zzoR()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.f2742j.lock();
        try {
            if (this.f2744l == null) {
                this.f2733a.add(t);
            } else {
                t = this.f2744l.zza(t);
                this.f2742j.unlock();
            }
            return t;
        } finally {
            this.f2742j.unlock();
        }
    }

    public void zza(zzx zzx) {
        this.f2742j.lock();
        try {
            if (this.f2741i == null) {
                this.f2741i = new HashSet();
            }
            this.f2741i.add(zzx);
        } finally {
            this.f2742j.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.f2735c.containsKey(api.zzoR());
    }

    public boolean zza(zzu zzu) {
        return this.f2744l != null && this.f2744l.zza(zzu);
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(@NonNull T t) {
        zzx.zzb(t.zzoR() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.f2742j.lock();
        try {
            if (this.f2744l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (mo5191b()) {
                this.f2733a.add(t);
                while (!this.f2733a.isEmpty()) {
                    C0711e remove = this.f2733a.remove();
                    mo5189a(remove);
                    remove.zzw(Status.zzagE);
                }
            } else {
                t = this.f2744l.zzb(t);
                this.f2742j.unlock();
            }
            return t;
        } finally {
            this.f2742j.unlock();
        }
    }

    public void zzb(zzx zzx) {
        this.f2742j.lock();
        try {
            if (this.f2741i == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f2741i.remove(zzx)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!mo5194e()) {
                this.f2744l.zzpj();
            }
        } finally {
            this.f2742j.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            mo5192c();
        }
        for (C0711e next : this.f2740h) {
            if (z) {
                next.zzpe();
            }
            next.zzx(new Status(8, "The connection to Google Play services was lost"));
        }
        this.f2740h.clear();
        this.f2743k.zzbT(i);
        this.f2743k.zzqQ();
        if (i == 2) {
            m3792g();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.f2752t.zzd(this.f2746n, connectionResult.getErrorCode())) {
            mo5193d();
        }
        if (!mo5191b()) {
            this.f2743k.zzk(connectionResult);
            this.f2743k.zzqQ();
        }
    }

    public void zzi(Bundle bundle) {
        while (!this.f2733a.isEmpty()) {
            zzb(this.f2733a.remove());
        }
        this.f2743k.zzk(bundle);
    }

    public void zzoW() {
        if (this.f2744l != null) {
            this.f2744l.zzoW();
        }
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        zzx.zzb(l, (Object) "Listener must not be null");
        this.f2742j.lock();
        try {
            zzq<L> zzq = new zzq<>(this.f2747o, l);
            this.f2753u.add(zzq);
            return zzq;
        } finally {
            this.f2742j.unlock();
        }
    }
}
