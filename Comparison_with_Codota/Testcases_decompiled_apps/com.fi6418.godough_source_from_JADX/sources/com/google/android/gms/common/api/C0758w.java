package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C0993aq;
import com.google.android.gms.common.internal.C1032t;
import com.google.android.gms.common.internal.C1033u;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.C1246f;
import com.google.android.gms.signin.C1247g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* renamed from: com.google.android.gms.common.api.w */
public class C0758w implements C0724av {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0714al f4533a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Lock f4534b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f4535c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0772b f4536d;

    /* renamed from: e */
    private ConnectionResult f4537e;

    /* renamed from: f */
    private int f4538f;

    /* renamed from: g */
    private int f4539g = 0;

    /* renamed from: h */
    private boolean f4540h = false;

    /* renamed from: i */
    private int f4541i;

    /* renamed from: j */
    private final Bundle f4542j = new Bundle();

    /* renamed from: k */
    private final Set<C0744i> f4543k = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public C1246f f4544l;

    /* renamed from: m */
    private int f4545m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f4546n;

    /* renamed from: o */
    private boolean f4547o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public C0993aq f4548p;

    /* renamed from: q */
    private boolean f4549q;

    /* renamed from: r */
    private boolean f4550r;

    /* renamed from: s */
    private final C1032t f4551s;

    /* renamed from: t */
    private final Map<C0702a<?>, Integer> f4552t;

    /* renamed from: u */
    private final C0742g<? extends C1246f, C1247g> f4553u;

    /* renamed from: v */
    private ArrayList<Future<?>> f4554v = new ArrayList<>();

    public C0758w(C0714al alVar, C1032t tVar, Map<C0702a<?>, Integer> map, C0772b bVar, C0742g<? extends C1246f, C1247g> gVar, Lock lock, Context context) {
        this.f4533a = alVar;
        this.f4551s = tVar;
        this.f4552t = map;
        this.f4536d = bVar;
        this.f4553u = gVar;
        this.f4534b = lock;
        this.f4535c = context;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4127a(ConnectionResult connectionResult) {
        if (m4137b(2)) {
            if (connectionResult.mo7323b()) {
                m4154i();
            } else if (m4143c(connectionResult)) {
                m4158k();
                m4154i();
            } else {
                m4145d(connectionResult);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4131a(ResolveAccountResponse resolveAccountResponse) {
        if (m4137b(0)) {
            ConnectionResult b = resolveAccountResponse.mo7485b();
            if (b.mo7323b()) {
                this.f4548p = resolveAccountResponse.mo7484a();
                this.f4547o = true;
                this.f4549q = resolveAccountResponse.mo7486c();
                this.f4550r = resolveAccountResponse.mo7487d();
                m4149f();
            } else if (m4143c(b)) {
                m4158k();
                m4149f();
            } else {
                m4145d(b);
            }
        }
    }

    /* renamed from: a */
    private void m4132a(boolean z) {
        if (this.f4544l != null) {
            if (this.f4544l.mo7437b() && z) {
                this.f4544l.mo9017p();
            }
            this.f4544l.mo7432a();
            this.f4548p = null;
        }
    }

    /* renamed from: a */
    private boolean m4133a(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || m4138b(connectionResult)) {
            return this.f4537e == null || i < this.f4538f;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4136b(ConnectionResult connectionResult, C0702a<?> aVar, int i) {
        if (i != 2) {
            int a = aVar.mo7350a().mo7429a();
            if (m4133a(a, i, connectionResult)) {
                this.f4537e = connectionResult;
                this.f4538f = a;
            }
        }
        this.f4533a.f4450e.put(aVar.mo7352c(), connectionResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m4137b(int i) {
        if (this.f4539g == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + m4140c(this.f4539g) + " but received callback for step " + m4140c(i));
        m4145d(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* renamed from: b */
    private boolean m4138b(ConnectionResult connectionResult) {
        return connectionResult.mo7322a() || this.f4536d.mo7458a(connectionResult.mo7324c()) != null;
    }

    /* renamed from: c */
    private String m4140c(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m4143c(ConnectionResult connectionResult) {
        if (this.f4545m != 2) {
            return this.f4545m == 1 && !connectionResult.mo7322a();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m4145d(ConnectionResult connectionResult) {
        boolean z = false;
        this.f4540h = false;
        m4160l();
        if (!connectionResult.mo7322a()) {
            z = true;
        }
        m4132a(z);
        this.f4533a.f4450e.clear();
        this.f4533a.mo7373a(connectionResult);
        if (!this.f4533a.mo7389i() || !this.f4536d.mo7459a(this.f4535c, connectionResult.mo7324c())) {
            this.f4533a.mo7391k();
            this.f4533a.f4446a.mo7520a(connectionResult);
        }
        this.f4533a.f4446a.mo7517a();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m4146e() {
        this.f4541i--;
        if (this.f4541i > 0) {
            return false;
        }
        if (this.f4541i < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            m4145d(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.f4537e == null) {
            return true;
        } else {
            m4145d(this.f4537e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m4149f() {
        if (this.f4541i == 0) {
            if (!this.f4546n) {
                m4154i();
            } else if (this.f4547o) {
                m4151g();
            }
        }
    }

    /* renamed from: g */
    private void m4151g() {
        ArrayList arrayList = new ArrayList();
        this.f4539g = 1;
        this.f4541i = this.f4533a.f4449d.size();
        for (C0744i next : this.f4533a.f4449d.keySet()) {
            if (!this.f4533a.f4450e.containsKey(next)) {
                arrayList.add(this.f4533a.f4449d.get(next));
            } else if (m4146e()) {
                m4153h();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f4554v.add(C0725aw.m4035a().submit(new C0711ai(this, arrayList)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m4153h() {
        this.f4539g = 2;
        this.f4533a.f4451f = m4162m();
        this.f4554v.add(C0725aw.m4035a().submit(new C0705ac(this, (C0759x) null)));
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m4154i() {
        ArrayList arrayList = new ArrayList();
        this.f4539g = 3;
        this.f4541i = this.f4533a.f4449d.size();
        for (C0744i next : this.f4533a.f4449d.keySet()) {
            if (!this.f4533a.f4450e.containsKey(next)) {
                arrayList.add(this.f4533a.f4449d.get(next));
            } else if (m4146e()) {
                m4156j();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f4554v.add(C0725aw.m4035a().submit(new C0709ag(this, arrayList)));
        }
    }

    /* renamed from: j */
    private void m4156j() {
        this.f4533a.mo7388h();
        C0725aw.m4035a().execute(new C0759x(this));
        if (this.f4544l != null) {
            if (this.f4549q) {
                this.f4544l.mo9015a(this.f4548p, this.f4550r);
            }
            m4132a(false);
        }
        for (C0744i<?> iVar : this.f4533a.f4450e.keySet()) {
            this.f4533a.f4449d.get(iVar).mo7432a();
        }
        if (this.f4540h) {
            this.f4540h = false;
            mo7368b();
            return;
        }
        this.f4533a.f4446a.mo7519a(this.f4542j.isEmpty() ? null : this.f4542j);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m4158k() {
        this.f4546n = false;
        this.f4533a.f4451f = Collections.emptySet();
        for (C0744i next : this.f4543k) {
            if (!this.f4533a.f4450e.containsKey(next)) {
                this.f4533a.f4450e.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    /* renamed from: l */
    private void m4160l() {
        Iterator<Future<?>> it = this.f4554v.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.f4554v.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public Set<Scope> m4162m() {
        HashSet hashSet = new HashSet(this.f4551s.mo7633d());
        Map<C0702a<?>, C1033u> f = this.f4551s.mo7635f();
        for (C0702a next : f.keySet()) {
            if (!this.f4533a.f4450e.containsKey(next.mo7352c())) {
                hashSet.addAll(f.get(next).f4760a);
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public void mo7364a() {
        this.f4533a.f4446a.mo7523b();
        this.f4533a.f4450e.clear();
        this.f4540h = false;
        this.f4546n = false;
        this.f4537e = null;
        this.f4539g = 0;
        this.f4545m = 2;
        this.f4547o = false;
        this.f4549q = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (C0702a next : this.f4552t.keySet()) {
            C0743h hVar = this.f4533a.f4449d.get(next.mo7352c());
            int intValue = this.f4552t.get(next).intValue();
            boolean z2 = (next.mo7350a().mo7429a() == 1) | z;
            if (hVar.mo7438c()) {
                this.f4546n = true;
                if (intValue < this.f4545m) {
                    this.f4545m = intValue;
                }
                if (intValue != 0) {
                    this.f4543k.add(next.mo7352c());
                }
            }
            hashMap.put(hVar, new C0706ad(this, next, intValue));
            z = z2;
        }
        if (z) {
            this.f4546n = false;
        }
        if (this.f4546n) {
            this.f4551s.mo7630a(Integer.valueOf(this.f4533a.mo7393m()));
            C0710ah ahVar = new C0710ah(this, (C0759x) null);
            this.f4544l = (C1246f) this.f4553u.mo7430a(this.f4535c, this.f4533a.mo7392l(), this.f4551s, this.f4551s.mo7638i(), ahVar, ahVar);
        }
        this.f4541i = this.f4533a.f4449d.size();
        this.f4554v.add(C0725aw.m4035a().submit(new C0707ae(this, hashMap)));
    }

    /* renamed from: a */
    public void mo7365a(int i) {
        m4145d(new ConnectionResult(8, (PendingIntent) null));
    }

    /* renamed from: a */
    public void mo7366a(Bundle bundle) {
        if (m4137b(3)) {
            if (bundle != null) {
                this.f4542j.putAll(bundle);
            }
            if (m4146e()) {
                m4156j();
            }
        }
    }

    /* renamed from: a */
    public void mo7367a(ConnectionResult connectionResult, C0702a<?> aVar, int i) {
        if (m4137b(3)) {
            m4136b(connectionResult, aVar, i);
            if (m4146e()) {
                m4156j();
            }
        }
    }

    /* renamed from: b */
    public void mo7368b() {
        Iterator it = this.f4533a.f4447b.iterator();
        while (it.hasNext()) {
            C0723au auVar = (C0723au) it.next();
            if (auVar.mo7405c() != 1) {
                auVar.mo7399a();
                it.remove();
            }
        }
        this.f4533a.mo7385e();
        if (this.f4537e != null || this.f4533a.f4447b.isEmpty()) {
            m4160l();
            m4132a(true);
            this.f4533a.f4450e.clear();
            this.f4533a.mo7373a((ConnectionResult) null);
            this.f4533a.f4446a.mo7517a();
            return;
        }
        this.f4540h = true;
    }

    /* renamed from: c */
    public void mo7369c() {
        this.f4540h = false;
    }

    /* renamed from: d */
    public String mo7370d() {
        return "CONNECTING";
    }
}
