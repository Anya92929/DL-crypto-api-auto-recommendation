package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.p009v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzpy extends GoogleApiClient implements zzqh.zza {

    /* renamed from: a */
    final Queue f6837a = new LinkedList();

    /* renamed from: b */
    zzqe f6838b;

    /* renamed from: c */
    final Map f6839c;

    /* renamed from: d */
    Set f6840d = new HashSet();

    /* renamed from: e */
    final zzg f6841e;

    /* renamed from: f */
    final Map f6842f;

    /* renamed from: g */
    final Api.zza f6843g;

    /* renamed from: h */
    Set f6844h = null;

    /* renamed from: i */
    final zzqy f6845i;

    /* renamed from: j */
    private final Lock f6846j;

    /* renamed from: k */
    private final zzl f6847k;

    /* renamed from: l */
    private zzqh f6848l = null;

    /* renamed from: m */
    private final int f6849m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Context f6850n;

    /* renamed from: o */
    private final Looper f6851o;

    /* renamed from: p */
    private volatile boolean f6852p;

    /* renamed from: q */
    private long f6853q = 120000;

    /* renamed from: r */
    private long f6854r = 5000;

    /* renamed from: s */
    private final C1816pc f6855s;

    /* renamed from: t */
    private final GoogleApiAvailability f6856t;

    /* renamed from: u */
    private final zzqo f6857u = new zzqo();

    /* renamed from: v */
    private final ArrayList f6858v;

    /* renamed from: w */
    private Integer f6859w = null;

    /* renamed from: x */
    private final zzl.zza f6860x = new C1811oy(this);

    public zzpy(Context context, Lock lock, Looper looper, zzg zzg, GoogleApiAvailability googleApiAvailability, Api.zza zza, Map map, List list, List list2, Map map2, int i, int i2, ArrayList arrayList) {
        this.f6850n = context;
        this.f6846j = lock;
        this.f6847k = new zzl(looper, this.f6860x);
        this.f6851o = looper;
        this.f6855s = new C1816pc(this, looper);
        this.f6856t = googleApiAvailability;
        this.f6849m = i;
        if (this.f6849m >= 0) {
            this.f6859w = Integer.valueOf(i2);
        }
        this.f6842f = map;
        this.f6839c = map2;
        this.f6858v = arrayList;
        this.f6845i = new zzqy(this.f6839c);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f6847k.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) it.next());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f6847k.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) it2.next());
        }
        this.f6841e = zzg;
        this.f6843g = zza;
    }

    /* renamed from: a */
    static String m7466a(int i) {
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
    public void m7467a(GoogleApiClient googleApiClient, zzqu zzqu, boolean z) {
        zzre.f6966zt.zzg(googleApiClient).setResultCallback(new C1815pb(this, zzqu, z, googleApiClient));
    }

    /* renamed from: a */
    private void m7470a(zzqi zzqi) {
        if (this.f6849m >= 0) {
            zzpk.zza(zzqi).zzfh(this.f6849m);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    /* renamed from: b */
    private void m7471b(int i) {
        if (this.f6859w == null) {
            this.f6859w = Integer.valueOf(i);
        } else if (this.f6859w.intValue() != i) {
            String valueOf = String.valueOf(m7466a(i));
            String valueOf2 = String.valueOf(m7466a(this.f6859w.intValue()));
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f6848l == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zze zze : this.f6839c.values()) {
                if (zze.zzafk()) {
                    z2 = true;
                }
                z = zze.zzafz() ? true : z;
            }
            switch (this.f6859w.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        this.f6848l = C1795oi.m6509a(this.f6850n, this, this.f6846j, this.f6851o, this.f6856t, this.f6839c, this.f6841e, this.f6842f, this.f6843g, this.f6858v);
                        return;
                    }
                    break;
            }
            this.f6848l = new zzqa(this.f6850n, this, this.f6846j, this.f6851o, this.f6856t, this.f6839c, this.f6841e, this.f6842f, this.f6843g, this.f6858v, this);
        }
    }

    /* renamed from: g */
    private void m7474g() {
        this.f6847k.zzasx();
        this.f6848l.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7475h() {
        this.f6846j.lock();
        try {
            if (mo8950b()) {
                m7474g();
            }
        } finally {
            this.f6846j.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7476i() {
        this.f6846j.lock();
        try {
            if (mo8952d()) {
                m7474g();
            }
        } finally {
            this.f6846j.unlock();
        }
    }

    public static int zza(Iterable iterable, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        boolean z3 = false;
        while (it.hasNext()) {
            Api.zze zze = (Api.zze) it.next();
            if (zze.zzafk()) {
                z3 = true;
            }
            z2 = zze.zzafz() ? true : z2;
        }
        if (z3) {
            return (!z2 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Api.zze mo8949a(Api.zzc zzc) {
        Api.zze zze = (Api.zze) this.f6839c.get(zzc);
        zzab.zzb((Object) zze, (Object) "Appropriate Api was not requested.");
        return zze;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8950b() {
        return this.f6852p;
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f6846j.lock();
        try {
            if (this.f6849m >= 0) {
                if (this.f6859w == null) {
                    z = false;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f6859w == null) {
                this.f6859w = Integer.valueOf(zza(this.f6839c.values(), false));
            } else if (this.f6859w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7471b(this.f6859w.intValue());
            this.f6847k.zzasx();
            return this.f6848l.blockingConnect();
        } finally {
            this.f6846j.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzab.zzb((Object) timeUnit, (Object) "TimeUnit must not be null");
        this.f6846j.lock();
        try {
            if (this.f6859w == null) {
                this.f6859w = Integer.valueOf(zza(this.f6839c.values(), false));
            } else if (this.f6859w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7471b(this.f6859w.intValue());
            this.f6847k.zzasx();
            return this.f6848l.blockingConnect(j, timeUnit);
        } finally {
            this.f6846j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8951c() {
        if (!mo8950b()) {
            this.f6852p = true;
            if (this.f6838b == null) {
                this.f6838b = this.f6856t.zza(this.f6850n.getApplicationContext(), (zzqe.zza) new C1817pd(this));
            }
            this.f6855s.sendMessageDelayed(this.f6855s.obtainMessage(1), this.f6853q);
            this.f6855s.sendMessageDelayed(this.f6855s.obtainMessage(2), this.f6854r);
        }
    }

    public PendingResult clearDefaultAccountAndReconnect() {
        zzab.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzab.zza(this.f6859w.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        zzqu zzqu = new zzqu((GoogleApiClient) this);
        if (this.f6839c.containsKey(zzre.f6965bJ)) {
            m7467a(this, zzqu, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.f6850n).addApi(zzre.API).addConnectionCallbacks(new C1812oz(this, atomicReference, zzqu)).addOnConnectionFailedListener(new C1814pa(this, zzqu)).setHandler(this.f6855s).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzqu;
    }

    public void connect() {
        boolean z = false;
        this.f6846j.lock();
        try {
            if (this.f6849m >= 0) {
                if (this.f6859w != null) {
                    z = true;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f6859w == null) {
                this.f6859w = Integer.valueOf(zza(this.f6839c.values(), false));
            } else if (this.f6859w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f6859w.intValue());
        } finally {
            this.f6846j.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.f6846j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzab.zzb(z, (Object) new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            m7471b(i);
            m7474g();
        } finally {
            this.f6846j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo8952d() {
        if (!mo8950b()) {
            return false;
        }
        this.f6852p = false;
        this.f6855s.removeMessages(2);
        this.f6855s.removeMessages(1);
        if (this.f6838b != null) {
            this.f6838b.unregister();
            this.f6838b = null;
        }
        return true;
    }

    public void disconnect() {
        this.f6846j.lock();
        try {
            this.f6845i.release();
            if (this.f6848l != null) {
                this.f6848l.disconnect();
            }
            this.f6857u.release();
            for (zzpm.zza zza : this.f6837a) {
                zza.zza((C1833pt) null);
                zza.cancel();
            }
            this.f6837a.clear();
            if (this.f6848l != null) {
                mo8952d();
                this.f6847k.zzasw();
                this.f6846j.unlock();
            }
        } finally {
            this.f6846j.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f6850n);
        printWriter.append(str).append("mResuming=").print(this.f6852p);
        printWriter.append(" mWorkQueue.size()=").print(this.f6837a.size());
        this.f6845i.dump(printWriter);
        if (this.f6848l != null) {
            this.f6848l.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo8953e() {
        boolean z = false;
        this.f6846j.lock();
        try {
            if (this.f6844h != null) {
                if (!this.f6844h.isEmpty()) {
                    z = true;
                }
                this.f6846j.unlock();
            }
            return z;
        } finally {
            this.f6846j.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo8954f() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    public ConnectionResult getConnectionResult(Api api) {
        this.f6846j.lock();
        try {
            if (!isConnected() && !mo8950b()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.f6839c.containsKey(api.zzans())) {
                ConnectionResult connectionResult = this.f6848l.getConnectionResult(api);
                if (connectionResult != null) {
                    this.f6846j.unlock();
                } else if (mo8950b()) {
                    connectionResult = ConnectionResult.f4269rb;
                } else {
                    Log.w("GoogleApiClientImpl", mo8954f());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.f6846j.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.f6846j.unlock();
        }
    }

    public Context getContext() {
        return this.f6850n;
    }

    public Looper getLooper() {
        return this.f6851o;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api api) {
        Api.zze zze = (Api.zze) this.f6839c.get(api.zzans());
        return zze != null && zze.isConnected();
    }

    public boolean isConnected() {
        return this.f6848l != null && this.f6848l.isConnected();
    }

    public boolean isConnecting() {
        return this.f6848l != null && this.f6848l.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f6847k.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f6847k.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f6847k.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6847k.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        m7470a(new zzqi(fragmentActivity));
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f6847k.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6847k.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public Api.zze zza(Api.zzc zzc) {
        Api.zze zze = (Api.zze) this.f6839c.get(zzc);
        zzab.zzb((Object) zze, (Object) "Appropriate Api was not requested.");
        return zze;
    }

    public void zza(zzqx zzqx) {
        this.f6846j.lock();
        try {
            if (this.f6844h == null) {
                this.f6844h = new HashSet();
            }
            this.f6844h.add(zzqx);
        } finally {
            this.f6846j.unlock();
        }
    }

    public boolean zza(Api api) {
        return this.f6839c.containsKey(api.zzans());
    }

    public boolean zza(zzqt zzqt) {
        return this.f6848l != null && this.f6848l.zza(zzqt);
    }

    public void zzaof() {
        if (this.f6848l != null) {
            this.f6848l.zzaof();
        }
    }

    public void zzb(zzqx zzqx) {
        this.f6846j.lock();
        try {
            if (this.f6844h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f6844h.remove(zzqx)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!mo8953e()) {
                this.f6848l.zzapb();
            }
        } finally {
            this.f6846j.unlock();
        }
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        zzab.zzb(zza.zzans() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f6839c.containsKey(zza.zzans());
        String name = zza.zzanz() != null ? zza.zzanz().getName() : "the API";
        zzab.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f6846j.lock();
        try {
            if (this.f6848l == null) {
                this.f6837a.add(zza);
            } else {
                zza = this.f6848l.zzc(zza);
                this.f6846j.unlock();
            }
            return zza;
        } finally {
            this.f6846j.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            mo8951c();
        }
        this.f6845i.zzaqz();
        this.f6847k.zzgf(i);
        this.f6847k.zzasw();
        if (i == 2) {
            m7474g();
        }
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        zzab.zzb(zza.zzans() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f6839c.containsKey(zza.zzans());
        String name = zza.zzanz() != null ? zza.zzanz().getName() : "the API";
        zzab.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f6846j.lock();
        try {
            if (this.f6848l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (mo8950b()) {
                this.f6837a.add(zza);
                while (!this.f6837a.isEmpty()) {
                    zzpm.zza zza2 = (zzpm.zza) this.f6837a.remove();
                    this.f6845i.mo9008a(zza2);
                    zza2.zzz(Status.f4330ss);
                }
            } else {
                zza = this.f6848l.zzd(zza);
                this.f6846j.unlock();
            }
            return zza;
        } finally {
            this.f6846j.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.f6856t.zzc(this.f6850n, connectionResult.getErrorCode())) {
            mo8952d();
        }
        if (!mo8950b()) {
            this.f6847k.zzm(connectionResult);
            this.f6847k.zzasw();
        }
    }

    public void zzm(Bundle bundle) {
        while (!this.f6837a.isEmpty()) {
            zzd((zzpm.zza) this.f6837a.remove());
        }
        this.f6847k.zzo(bundle);
    }

    public zzqn zzs(Object obj) {
        this.f6846j.lock();
        try {
            return this.f6857u.zzb(obj, this.f6851o);
        } finally {
            this.f6846j.unlock();
        }
    }
}
