package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzpw implements zzpz {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final zzqa f6815a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Lock f6816b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f6817c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final zzc f6818d;

    /* renamed from: e */
    private ConnectionResult f6819e;

    /* renamed from: f */
    private int f6820f;

    /* renamed from: g */
    private int f6821g = 0;

    /* renamed from: h */
    private int f6822h;

    /* renamed from: i */
    private final Bundle f6823i = new Bundle();

    /* renamed from: j */
    private final Set f6824j = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public zzvu f6825k;

    /* renamed from: l */
    private int f6826l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f6827m;

    /* renamed from: n */
    private boolean f6828n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public zzq f6829o;

    /* renamed from: p */
    private boolean f6830p;

    /* renamed from: q */
    private boolean f6831q;

    /* renamed from: r */
    private final zzg f6832r;

    /* renamed from: s */
    private final Map f6833s;

    /* renamed from: t */
    private final Api.zza f6834t;

    /* renamed from: u */
    private ArrayList f6835u = new ArrayList();

    public zzpw(zzqa zzqa, zzg zzg, Map map, zzc zzc, Api.zza zza, Lock lock, Context context) {
        this.f6815a = zzqa;
        this.f6832r = zzg;
        this.f6833s = map;
        this.f6818d = zzc;
        this.f6834t = zza;
        this.f6816b = lock;
        this.f6817c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7435a(ConnectionResult connectionResult, Api api, int i) {
        if (i != 2) {
            int priority = api.zzanp().getPriority();
            if (m7443a(priority, i, connectionResult)) {
                this.f6819e = connectionResult;
                this.f6820f = priority;
            }
        }
        this.f6815a.f6862b.put(api.zzans(), connectionResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7439a(SignInResponse signInResponse) {
        if (m7442a(0)) {
            ConnectionResult zzath = signInResponse.zzath();
            if (zzath.isSuccess()) {
                ResolveAccountResponse zzbzz = signInResponse.zzbzz();
                ConnectionResult zzath2 = zzbzz.zzath();
                if (!zzath2.isSuccess()) {
                    String valueOf = String.valueOf(zzath2);
                    Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                    m7453c(zzath2);
                    return;
                }
                this.f6828n = true;
                this.f6829o = zzbzz.zzatg();
                this.f6830p = zzbzz.zzati();
                this.f6831q = zzbzz.zzatj();
                m7448b();
            } else if (m7449b(zzath)) {
                m7456e();
                m7448b();
            } else {
                m7453c(zzath);
            }
        }
    }

    /* renamed from: a */
    private void m7440a(boolean z) {
        if (this.f6825k != null) {
            if (this.f6825k.isConnected() && z) {
                this.f6825k.zzbzo();
            }
            this.f6825k.disconnect();
            this.f6829o = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7441a() {
        this.f6822h--;
        if (this.f6822h > 0) {
            return false;
        }
        if (this.f6822h < 0) {
            Log.w("GoogleApiClientConnecting", this.f6815a.f6867g.mo8954f());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m7453c(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.f6819e == null) {
            return true;
        } else {
            this.f6815a.f6866f = this.f6820f;
            m7453c(this.f6819e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7442a(int i) {
        if (this.f6821g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f6815a.f6867g.mo8954f());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.f6822h).toString());
        String valueOf2 = String.valueOf(m7447b(this.f6821g));
        String valueOf3 = String.valueOf(m7447b(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf2).length() + 70 + String.valueOf(valueOf3).length()).append("GoogleApiClient connecting is in step ").append(valueOf2).append(" but received callback for step ").append(valueOf3).toString(), new Exception());
        m7453c(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* renamed from: a */
    private boolean m7443a(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || m7444a(connectionResult)) {
            return this.f6819e == null || i < this.f6820f;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m7444a(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f6818d.zzfc(connectionResult.getErrorCode()) != null;
    }

    /* renamed from: b */
    private String m7447b(int i) {
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
    public void m7448b() {
        if (this.f6822h == 0) {
            if (!this.f6827m || this.f6828n) {
                m7452c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m7449b(ConnectionResult connectionResult) {
        if (this.f6826l != 2) {
            return this.f6826l == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* renamed from: c */
    private void m7452c() {
        ArrayList arrayList = new ArrayList();
        this.f6821g = 1;
        this.f6822h = this.f6815a.f6861a.size();
        for (Api.zzc zzc : this.f6815a.f6861a.keySet()) {
            if (!this.f6815a.f6862b.containsKey(zzc)) {
                arrayList.add((Api.zze) this.f6815a.f6861a.get(zzc));
            } else if (m7441a()) {
                m7455d();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f6835u.add(zzqb.zzaqc().submit(new C1806ot(this, arrayList)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7453c(ConnectionResult connectionResult) {
        m7459f();
        m7440a(!connectionResult.hasResolution());
        this.f6815a.mo8957a(connectionResult);
        this.f6815a.f6868h.zzd(connectionResult);
    }

    /* renamed from: d */
    private void m7455d() {
        this.f6815a.mo8960b();
        zzqb.zzaqc().execute(new C1801oo(this));
        if (this.f6825k != null) {
            if (this.f6830p) {
                this.f6825k.zza(this.f6829o, this.f6831q);
            }
            m7440a(false);
        }
        for (Api.zzc zzc : this.f6815a.f6862b.keySet()) {
            ((Api.zze) this.f6815a.f6861a.get(zzc)).disconnect();
        }
        this.f6815a.f6868h.zzm(this.f6823i.isEmpty() ? null : this.f6823i);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7456e() {
        this.f6827m = false;
        this.f6815a.f6867g.f6840d = Collections.emptySet();
        for (Api.zzc zzc : this.f6824j) {
            if (!this.f6815a.f6862b.containsKey(zzc)) {
                this.f6815a.f6862b.put(zzc, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    /* renamed from: f */
    private void m7459f() {
        Iterator it = this.f6835u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f6835u.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public Set m7460g() {
        if (this.f6832r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f6832r.zzasj());
        Map zzasl = this.f6832r.zzasl();
        for (Api api : zzasl.keySet()) {
            if (!this.f6815a.f6862b.containsKey(api.zzans())) {
                hashSet.addAll(((zzg.zza) zzasl.get(api)).f4582dT);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.f6815a.f6862b.clear();
        this.f6827m = false;
        this.f6819e = null;
        this.f6821g = 0;
        this.f6826l = 2;
        this.f6828n = false;
        this.f6830p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api api : this.f6833s.keySet()) {
            Api.zze zze = (Api.zze) this.f6815a.f6861a.get(api.zzans());
            int intValue = ((Integer) this.f6833s.get(api)).intValue();
            boolean z2 = (api.zzanp().getPriority() == 1) | z;
            if (zze.zzafk()) {
                this.f6827m = true;
                if (intValue < this.f6826l) {
                    this.f6826l = intValue;
                }
                if (intValue != 0) {
                    this.f6824j.add(api.zzans());
                }
            }
            hashMap.put(zze, new C1802op(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.f6827m = false;
        }
        if (this.f6827m) {
            this.f6832r.zzc(Integer.valueOf(this.f6815a.f6867g.getSessionId()));
            C1809ow owVar = new C1809ow(this, (C1801oo) null);
            this.f6825k = (zzvu) this.f6834t.zza(this.f6817c, this.f6815a.f6867g.getLooper(), this.f6832r, this.f6832r.zzasp(), owVar, owVar);
        }
        this.f6822h = this.f6815a.f6861a.size();
        this.f6835u.add(zzqb.zzaqc().submit(new C1803oq(this, hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        m7459f();
        m7440a(true);
        this.f6815a.mo8957a((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (m7442a(1)) {
            if (bundle != null) {
                this.f6823i.putAll(bundle);
            }
            if (m7441a()) {
                m7455d();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        m7453c(new ConnectionResult(8, (PendingIntent) null));
    }

    public void zza(ConnectionResult connectionResult, Api api, int i) {
        if (m7442a(1)) {
            m7435a(connectionResult, api, i);
            if (m7441a()) {
                m7455d();
            }
        }
    }

    public zzpm.zza zzc(zzpm.zza zza) {
        this.f6815a.f6867g.f6837a.add(zza);
        return zza;
    }

    public zzpm.zza zzd(zzpm.zza zza) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
