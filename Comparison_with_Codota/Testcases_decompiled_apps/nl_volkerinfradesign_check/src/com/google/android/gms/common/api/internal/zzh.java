package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.SignInResponse;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzh implements zzk {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzl f2695a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Lock f2696b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f2697c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzc f2698d;

    /* renamed from: e */
    private ConnectionResult f2699e;

    /* renamed from: f */
    private int f2700f;

    /* renamed from: g */
    private int f2701g = 0;

    /* renamed from: h */
    private int f2702h;

    /* renamed from: i */
    private final Bundle f2703i = new Bundle();

    /* renamed from: j */
    private final Set<Api.zzc> f2704j = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzrn f2705k;

    /* renamed from: l */
    private int f2706l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2707m;

    /* renamed from: n */
    private boolean f2708n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzp f2709o;

    /* renamed from: p */
    private boolean f2710p;

    /* renamed from: q */
    private boolean f2711q;

    /* renamed from: r */
    private final zzf f2712r;

    /* renamed from: s */
    private final Map<Api<?>, Integer> f2713s;

    /* renamed from: t */
    private final Api.zza<? extends zzrn, zzro> f2714t;

    /* renamed from: u */
    private ArrayList<Future<?>> f2715u = new ArrayList<>();

    /* renamed from: com.google.android.gms.common.api.internal.zzh$a */
    static class C0693a implements GoogleApiClient.zza {

        /* renamed from: a */
        private final WeakReference<zzh> f2717a;

        /* renamed from: b */
        private final Api<?> f2718b;

        /* renamed from: c */
        private final int f2719c;

        public C0693a(zzh zzh, Api<?> api, int i) {
            this.f2717a = new WeakReference<>(zzh);
            this.f2718b = api;
            this.f2719c = i;
        }

        public void zza(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzh zzh = (zzh) this.f2717a.get();
            if (zzh != null) {
                if (Looper.myLooper() == zzh.f2695a.f2783g.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzh.f2696b.lock();
                try {
                    if (zzh.m3753a(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzh.m3746a(connectionResult, this.f2718b, this.f2719c);
                        }
                        if (zzh.m3752a()) {
                            zzh.m3759b();
                        }
                        zzh.f2696b.unlock();
                    }
                } finally {
                    zzh.f2696b.unlock();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzh$b */
    class C0694b extends C0700f {

        /* renamed from: c */
        private final Map<Api.zzb, GoogleApiClient.zza> f2721c;

        public C0694b(Map<Api.zzb, GoogleApiClient.zza> map) {
            super();
            this.f2721c = map;
        }

        @WorkerThread
        /* renamed from: a */
        public void mo5186a() {
            int isGooglePlayServicesAvailable = zzh.this.f2698d.isGooglePlayServicesAvailable(zzh.this.f2697c);
            if (isGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null);
                zzh.this.f2695a.mo5211a((zzl.C0712a) new zzl.C0712a(zzh.this) {
                    /* renamed from: a */
                    public void mo5184a() {
                        zzh.this.m3764c(connectionResult);
                    }
                });
                return;
            }
            if (zzh.this.f2707m) {
                zzh.this.f2705k.connect();
            }
            for (Api.zzb next : this.f2721c.keySet()) {
                next.zza(this.f2721c.get(next));
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzh$c */
    class C0696c extends C0700f {

        /* renamed from: c */
        private final ArrayList<Api.zzb> f2725c;

        public C0696c(ArrayList<Api.zzb> arrayList) {
            super();
            this.f2725c = arrayList;
        }

        @WorkerThread
        /* renamed from: a */
        public void mo5186a() {
            zzh.this.f2695a.f2783g.f2736d = zzh.this.m3771g();
            Iterator<Api.zzb> it = this.f2725c.iterator();
            while (it.hasNext()) {
                it.next().zza(zzh.this.f2709o, zzh.this.f2695a.f2783g.f2736d);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzh$d */
    static class C0697d extends zzb {

        /* renamed from: a */
        private final WeakReference<zzh> f2726a;

        C0697d(zzh zzh) {
            this.f2726a = new WeakReference<>(zzh);
        }

        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzh zzh = (zzh) this.f2726a.get();
            if (zzh != null) {
                zzh.f2695a.mo5211a((zzl.C0712a) new zzl.C0712a(zzh) {
                    /* renamed from: a */
                    public void mo5184a() {
                        zzh.m3750a(signInResponse);
                    }
                });
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzh$e */
    class C0699e implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private C0699e() {
        }

        public void onConnected(Bundle bundle) {
            zzh.this.f2705k.zza(new C0697d(zzh.this));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzh.this.f2696b.lock();
            try {
                if (zzh.this.m3760b(connectionResult)) {
                    zzh.this.m3767e();
                    zzh.this.m3759b();
                } else {
                    zzh.this.m3764c(connectionResult);
                }
            } finally {
                zzh.this.f2696b.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.zzh$f */
    abstract class C0700f implements Runnable {
        private C0700f() {
        }

        /* access modifiers changed from: protected */
        @WorkerThread
        /* renamed from: a */
        public abstract void mo5186a();

        @WorkerThread
        public void run() {
            zzh.this.f2696b.lock();
            try {
                if (!Thread.interrupted()) {
                    mo5186a();
                    zzh.this.f2696b.unlock();
                }
            } catch (RuntimeException e) {
                zzh.this.f2695a.mo5212a(e);
            } finally {
                zzh.this.f2696b.unlock();
            }
        }
    }

    public zzh(zzl zzl, zzf zzf, Map<Api<?>, Integer> map, zzc zzc, Api.zza<? extends zzrn, zzro> zza, Lock lock, Context context) {
        this.f2695a = zzl;
        this.f2712r = zzf;
        this.f2713s = map;
        this.f2698d = zzc;
        this.f2714t = zza;
        this.f2696b = lock;
        this.f2697c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3746a(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzoP().getPriority();
            if (m3754a(priority, i, connectionResult)) {
                this.f2699e = connectionResult;
                this.f2700f = priority;
            }
        }
        this.f2695a.f2778b.put(api.zzoR(), connectionResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3750a(SignInResponse signInResponse) {
        if (m3753a(0)) {
            ConnectionResult zzqY = signInResponse.zzqY();
            if (zzqY.isSuccess()) {
                ResolveAccountResponse zzFP = signInResponse.zzFP();
                ConnectionResult zzqY2 = zzFP.zzqY();
                if (!zzqY2.isSuccess()) {
                    Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + zzqY2, new Exception());
                    m3764c(zzqY2);
                    return;
                }
                this.f2708n = true;
                this.f2709o = zzFP.zzqX();
                this.f2710p = zzFP.zzqZ();
                this.f2711q = zzFP.zzra();
                m3759b();
            } else if (m3760b(zzqY)) {
                m3767e();
                m3759b();
            } else {
                m3764c(zzqY);
            }
        }
    }

    /* renamed from: a */
    private void m3751a(boolean z) {
        if (this.f2705k != null) {
            if (this.f2705k.isConnected() && z) {
                this.f2705k.zzFG();
            }
            this.f2705k.disconnect();
            this.f2709o = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3752a() {
        this.f2702h--;
        if (this.f2702h > 0) {
            return false;
        }
        if (this.f2702h < 0) {
            Log.i("GoogleApiClientConnecting", this.f2695a.f2783g.mo5195f());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m3764c(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.f2699e == null) {
            return true;
        } else {
            this.f2695a.f2782f = this.f2700f;
            m3764c(this.f2699e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m3753a(int i) {
        if (this.f2701g == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.f2695a.f2783g.mo5195f());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + m3758b(this.f2701g) + " but received callback for step " + m3758b(i), new Exception());
        m3764c(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* renamed from: a */
    private boolean m3754a(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || m3755a(connectionResult)) {
            return this.f2699e == null || i < this.f2700f;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3755a(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f2698d.zzbu(connectionResult.getErrorCode()) != null;
    }

    /* renamed from: b */
    private String m3758b(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3759b() {
        if (this.f2702h == 0) {
            if (!this.f2707m || this.f2708n) {
                m3763c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m3760b(ConnectionResult connectionResult) {
        if (this.f2706l != 2) {
            return this.f2706l == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* renamed from: c */
    private void m3763c() {
        ArrayList arrayList = new ArrayList();
        this.f2701g = 1;
        this.f2702h = this.f2695a.f2777a.size();
        for (Api.zzc next : this.f2695a.f2777a.keySet()) {
            if (!this.f2695a.f2778b.containsKey(next)) {
                arrayList.add(this.f2695a.f2777a.get(next));
            } else if (m3752a()) {
                m3766d();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f2715u.add(zzm.zzpN().submit(new C0696c(arrayList)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m3764c(ConnectionResult connectionResult) {
        m3770f();
        m3751a(!connectionResult.hasResolution());
        this.f2695a.mo5210a(connectionResult);
        this.f2695a.f2784h.zzd(connectionResult);
    }

    /* renamed from: d */
    private void m3766d() {
        this.f2695a.mo5213b();
        zzm.zzpN().execute(new Runnable() {
            public void run() {
                zzh.this.f2698d.zzal(zzh.this.f2697c);
            }
        });
        if (this.f2705k != null) {
            if (this.f2710p) {
                this.f2705k.zza(this.f2709o, this.f2711q);
            }
            m3751a(false);
        }
        for (Api.zzc<?> zzc : this.f2695a.f2778b.keySet()) {
            this.f2695a.f2777a.get(zzc).disconnect();
        }
        this.f2695a.f2784h.zzi(this.f2703i.isEmpty() ? null : this.f2703i);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m3767e() {
        this.f2707m = false;
        this.f2695a.f2783g.f2736d = Collections.emptySet();
        for (Api.zzc next : this.f2704j) {
            if (!this.f2695a.f2778b.containsKey(next)) {
                this.f2695a.f2778b.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    /* renamed from: f */
    private void m3770f() {
        Iterator<Future<?>> it = this.f2715u.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.f2715u.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Set<Scope> m3771g() {
        if (this.f2712r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f2712r.zzqs());
        Map<Api<?>, zzf.zza> zzqu = this.f2712r.zzqu();
        for (Api next : zzqu.keySet()) {
            if (!this.f2695a.f2778b.containsKey(next.zzoR())) {
                hashSet.addAll(zzqu.get(next).zzXf);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.f2695a.f2778b.clear();
        this.f2707m = false;
        this.f2699e = null;
        this.f2701g = 0;
        this.f2706l = 2;
        this.f2708n = false;
        this.f2710p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.f2713s.keySet()) {
            Api.zzb zzb = this.f2695a.f2777a.get(next.zzoR());
            int intValue = this.f2713s.get(next).intValue();
            boolean z2 = (next.zzoP().getPriority() == 1) | z;
            if (zzb.zzmE()) {
                this.f2707m = true;
                if (intValue < this.f2706l) {
                    this.f2706l = intValue;
                }
                if (intValue != 0) {
                    this.f2704j.add(next.zzoR());
                }
            }
            hashMap.put(zzb, new C0693a(this, next, intValue));
            z = z2;
        }
        if (z) {
            this.f2707m = false;
        }
        if (this.f2707m) {
            this.f2712r.zza(Integer.valueOf(this.f2695a.f2783g.getSessionId()));
            C0699e eVar = new C0699e();
            this.f2705k = (zzrn) this.f2714t.zza(this.f2697c, this.f2695a.f2783g.getLooper(), this.f2712r, this.f2712r.zzqy(), eVar, eVar);
        }
        this.f2702h = this.f2695a.f2777a.size();
        this.f2715u.add(zzm.zzpN().submit(new C0694b(hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        m3770f();
        m3751a(true);
        this.f2695a.mo5210a((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (m3753a(1)) {
            if (bundle != null) {
                this.f2703i.putAll(bundle);
            }
            if (m3752a()) {
                m3766d();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        m3764c(new ConnectionResult(8, (PendingIntent) null));
    }

    public <A extends Api.zzb, R extends Result, T extends zza.C2020zza<R, A>> T zza(T t) {
        this.f2695a.f2783g.f2733a.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (m3753a(1)) {
            m3746a(connectionResult, api, i);
            if (m3752a()) {
                m3766d();
            }
        }
    }

    public <A extends Api.zzb, T extends zza.C2020zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
