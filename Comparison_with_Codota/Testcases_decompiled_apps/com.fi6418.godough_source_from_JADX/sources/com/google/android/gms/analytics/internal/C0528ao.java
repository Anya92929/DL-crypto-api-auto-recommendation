package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.C0501a;
import com.google.android.gms.analytics.C0505b;
import com.google.android.gms.analytics.C0508e;
import com.google.android.gms.analytics.C0509f;
import com.google.android.gms.analytics.C0592w;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0624am;
import com.google.android.gms.p018c.C0626ao;
import com.google.android.gms.p018c.C0628aq;
import com.google.android.gms.p018c.C0636ay;
import com.google.android.gms.p018c.C0637az;
import com.google.android.gms.p018c.C0667i;
import com.google.android.gms.p018c.C0668j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.internal.ao */
class C0528ao extends C0514aa {

    /* renamed from: a */
    private boolean f3746a;

    /* renamed from: b */
    private final C0525al f3747b;

    /* renamed from: c */
    private final C0564l f3748c;

    /* renamed from: d */
    private final C0563k f3749d;

    /* renamed from: e */
    private final C0520ag f3750e;

    /* renamed from: f */
    private long f3751f = Long.MIN_VALUE;

    /* renamed from: g */
    private final C0545be f3752g;

    /* renamed from: h */
    private final C0545be f3753h;

    /* renamed from: i */
    private final C0569q f3754i;

    /* renamed from: j */
    private long f3755j;

    /* renamed from: k */
    private boolean f3756k;

    protected C0528ao(C0516ac acVar, C0518ae aeVar) {
        super(acVar);
        C1009bf.m4528a(aeVar);
        this.f3749d = aeVar.mo6632k(acVar);
        this.f3747b = aeVar.mo6634m(acVar);
        this.f3748c = aeVar.mo6635n(acVar);
        this.f3750e = aeVar.mo6636o(acVar);
        this.f3754i = new C0569q(mo6885n());
        this.f3752g = new C0529ap(this, acVar);
        this.f3753h = new C0530aq(this, acVar);
    }

    /* renamed from: J */
    private void m3080J() {
        Context b = mo6882k().mo6600b();
        if (!C0501a.m2952a(b)) {
            mo6879e("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!C0505b.m2961a(b)) {
            mo6881f("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!C0508e.m2963a(b)) {
            mo6879e("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!C0509f.m2967a(b)) {
            mo6879e("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public void m3081K() {
        mo6688a((C0549bi) new C0532as(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m3082L() {
        try {
            this.f3747b.mo6672g();
            mo6683G();
        } catch (SQLiteException e) {
            mo6877d("Failed to delete stale hits", e);
        }
        this.f3753h.mo6763a(mo6888q().mo6726C());
    }

    /* renamed from: M */
    private boolean m3083M() {
        if (this.f3756k) {
            return false;
        }
        return (!mo6888q().mo6731a() || mo6888q().mo6732b()) && mo6684H() > 0;
    }

    /* renamed from: N */
    private void m3084N() {
        C0548bh u = mo6892u();
        if (u.mo6771b() && !u.mo6772c()) {
            long F = mo6682F();
            if (F != 0 && Math.abs(mo6885n().mo6990a() - F) <= mo6888q().mo6741k()) {
                mo6866a("Dispatch alarm scheduled (ms)", Long.valueOf(mo6888q().mo6740j()));
                u.mo6773d();
            }
        }
    }

    /* renamed from: O */
    private void m3085O() {
        long min;
        m3084N();
        long H = mo6684H();
        long d = mo6894w().mo6826d();
        if (d != 0) {
            min = H - Math.abs(mo6885n().mo6990a() - d);
            if (min <= 0) {
                min = Math.min(mo6888q().mo6738h(), H);
            }
        } else {
            min = Math.min(mo6888q().mo6738h(), H);
        }
        mo6866a("Dispatch scheduled (ms)", Long.valueOf(min));
        if (this.f3752g.mo6766c()) {
            this.f3752g.mo6765b(Math.max(1, min + this.f3752g.mo6764b()));
            return;
        }
        this.f3752g.mo6763a(min);
    }

    /* renamed from: P */
    private void m3086P() {
        m3087Q();
        m3088R();
    }

    /* renamed from: Q */
    private void m3087Q() {
        if (this.f3752g.mo6766c()) {
            mo6869b("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f3752g.mo6767d();
    }

    /* renamed from: R */
    private void m3088R() {
        C0548bh u = mo6892u();
        if (u.mo6772c()) {
            u.mo6774e();
        }
    }

    /* renamed from: a */
    private void m3089a(C0519af afVar, C0637az azVar) {
        C1009bf.m4528a(afVar);
        C1009bf.m4528a(azVar);
        C0592w wVar = new C0592w(mo6882k());
        wVar.mo6935b(afVar.mo6642c());
        wVar.mo6936b(afVar.mo6643d());
        C0624am l = wVar.mo6939l();
        C0668j jVar = (C0668j) l.mo6998b(C0668j.class);
        jVar.mo7218a("data");
        jVar.mo7222b(true);
        l.mo6997a((C0626ao) azVar);
        C0667i iVar = (C0667i) l.mo6998b(C0667i.class);
        C0636ay ayVar = (C0636ay) l.mo6998b(C0636ay.class);
        for (Map.Entry next : afVar.mo6645f().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if ("an".equals(str)) {
                ayVar.mo7030a(str2);
            } else if ("av".equals(str)) {
                ayVar.mo7032b(str2);
            } else if ("aid".equals(str)) {
                ayVar.mo7034c(str2);
            } else if ("aiid".equals(str)) {
                ayVar.mo7036d(str2);
            } else if ("uid".equals(str)) {
                jVar.mo7224c(str2);
            } else {
                iVar.mo7213a(str, str2);
            }
        }
        mo6871b("Sending installation campaign to", afVar.mo6642c(), azVar);
        l.mo6996a(mo6894w().mo6824b());
        l.mo7002e();
    }

    /* renamed from: g */
    private boolean m3092g(String str) {
        return mo6886o().checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: F */
    public long mo6682F() {
        C0628aq.m3622d();
        mo6596D();
        try {
            return this.f3747b.mo6674h();
        } catch (SQLiteException e) {
            mo6880e("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    /* renamed from: G */
    public void mo6683G() {
        boolean z;
        mo6882k().mo6617s();
        mo6596D();
        if (!m3083M()) {
            this.f3749d.mo6808b();
            m3086P();
        } else if (this.f3747b.mo6671f()) {
            this.f3749d.mo6808b();
            m3086P();
        } else {
            if (!C0551bk.f3809J.mo6775a().booleanValue()) {
                this.f3749d.mo6807a();
                z = this.f3749d.mo6811e();
            } else {
                z = true;
            }
            if (z) {
                m3085O();
                return;
            }
            m3086P();
            m3084N();
        }
    }

    /* renamed from: H */
    public long mo6684H() {
        if (this.f3751f != Long.MIN_VALUE) {
            return this.f3751f;
        }
        return mo6893v().mo6841f() ? ((long) mo6893v().mo6842g()) * 1000 : mo6888q().mo6739i();
    }

    /* renamed from: I */
    public void mo6685I() {
        mo6596D();
        mo6884m();
        this.f3756k = true;
        this.f3750e.mo6649d();
        mo6683G();
    }

    /* renamed from: a */
    public long mo6686a(C0519af afVar, boolean z) {
        long j;
        C1009bf.m4528a(afVar);
        mo6596D();
        mo6884m();
        try {
            this.f3747b.mo6664b();
            this.f3747b.mo6659a(afVar.mo6639a(), afVar.mo6641b());
            j = this.f3747b.mo6656a(afVar.mo6639a(), afVar.mo6641b(), afVar.mo6642c());
            if (!z) {
                afVar.mo6640a(j);
            } else {
                afVar.mo6640a(1 + j);
            }
            this.f3747b.mo6660a(afVar);
            this.f3747b.mo6665c();
            try {
                this.f3747b.mo6669d();
            } catch (SQLiteException e) {
                mo6880e("Failed to end transaction", e);
            }
        } catch (SQLiteException e2) {
            mo6880e("Failed to update Analytics property", e2);
            j = -1;
            try {
                this.f3747b.mo6669d();
            } catch (SQLiteException e3) {
                mo6880e("Failed to end transaction", e3);
            }
        } catch (Throwable th) {
            try {
                this.f3747b.mo6669d();
            } catch (SQLiteException e4) {
                mo6880e("Failed to end transaction", e4);
            }
            throw th;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        this.f3747b.mo6597E();
        this.f3748c.mo6597E();
        this.f3750e.mo6597E();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6687a(C0519af afVar) {
        mo6884m();
        mo6870b("Sending first hit to property", afVar.mo6642c());
        if (!mo6894w().mo6825c().mo6834a(mo6888q().mo6729F())) {
            String f = mo6894w().mo6828f();
            if (!TextUtils.isEmpty(f)) {
                C0637az a = C0570r.m3326a(mo6887p(), f);
                mo6870b("Found relevant installation campaign", a);
                m3089a(afVar, a);
            }
        }
    }

    /* renamed from: a */
    public void mo6688a(C0549bi biVar) {
        mo6689a(biVar, this.f3755j);
    }

    /* renamed from: a */
    public void mo6689a(C0549bi biVar, long j) {
        C0628aq.m3622d();
        mo6596D();
        long j2 = -1;
        long d = mo6894w().mo6826d();
        if (d != 0) {
            j2 = Math.abs(mo6885n().mo6990a() - d);
        }
        mo6870b("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!mo6888q().mo6731a()) {
            mo6699g();
        }
        try {
            if (mo6701i()) {
                mo6889r().mo7018a((Runnable) new C0533at(this, biVar, j));
                return;
            }
            mo6894w().mo6827e();
            mo6683G();
            if (biVar != null) {
                biVar.mo6574a((Throwable) null);
            }
            if (this.f3755j != j) {
                this.f3749d.mo6809c();
            }
        } catch (Throwable th) {
            mo6880e("Local dispatch failed", th);
            mo6894w().mo6827e();
            mo6683G();
            if (biVar != null) {
                biVar.mo6574a(th);
            }
        }
    }

    /* renamed from: a */
    public void mo6690a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        C0628aq.m3622d();
        mo6596D();
        if (this.f3756k) {
            mo6873c("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            mo6866a("Delivering hit", dVar);
        }
        C0556d b = mo6693b(dVar);
        mo6699g();
        if (this.f3750e.mo6646a(b)) {
            mo6873c("Hit sent to the device AnalyticsService for delivery");
        } else if (mo6888q().mo6731a()) {
            mo6887p().mo6804a(b, "Service unavailable on package side");
        } else {
            try {
                this.f3747b.mo6661a(b);
                mo6683G();
            } catch (SQLiteException e) {
                mo6880e("Delivery failed to save hit to a database", e);
                mo6887p().mo6804a(b, "deliver: failed to insert hit to database");
            }
        }
    }

    /* renamed from: a */
    public void mo6691a(String str) {
        C1009bf.m4530a(str);
        mo6884m();
        mo6883l();
        C0637az a = C0570r.m3326a(mo6887p(), str);
        if (a == null) {
            mo6877d("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String f = mo6894w().mo6828f();
        if (str.equals(f)) {
            mo6879e("Ignoring duplicate install campaign");
        } else if (!TextUtils.isEmpty(f)) {
            mo6878d("Ignoring multiple install campaigns. original, new", f, str);
        } else {
            mo6894w().mo6823a(str);
            if (mo6894w().mo6825c().mo6834a(mo6888q().mo6729F())) {
                mo6877d("Campaign received too late, ignoring", a);
                return;
            }
            mo6870b("Received installation campaign", a);
            for (C0519af a2 : this.f3747b.mo6668d(0)) {
                m3089a(a2, a);
            }
        }
    }

    /* renamed from: a */
    public void mo6692a(boolean z) {
        mo6683G();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0556d mo6693b(C0556d dVar) {
        Pair<String, Long> a;
        if (!TextUtils.isEmpty(dVar.mo6794h()) || (a = mo6894w().mo6829g().mo6830a()) == null) {
            return dVar;
        }
        String str = ((Long) a.second) + ":" + ((String) a.first);
        HashMap hashMap = new HashMap(dVar.mo6788b());
        hashMap.put("_m", str);
        return C0556d.m3235a(this, dVar, hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6694b() {
        mo6596D();
        C1009bf.m4533a(!this.f3746a, (Object) "Analytics backend already started");
        this.f3746a = true;
        if (!mo6888q().mo6731a()) {
            m3080J();
        }
        mo6889r().mo7018a((Runnable) new C0531ar(this));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6695c() {
        mo6596D();
        mo6894w().mo6824b();
        if (!m3092g("android.permission.ACCESS_NETWORK_STATE")) {
            mo6881f("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            mo6685I();
        }
        if (!m3092g("android.permission.INTERNET")) {
            mo6881f("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            mo6685I();
        }
        if (C0505b.m2961a(mo6886o())) {
            mo6869b("AnalyticsService registered in the app manifest and enabled");
        } else if (mo6888q().mo6731a()) {
            mo6881f("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            mo6879e("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.f3756k && !mo6888q().mo6731a() && !this.f3747b.mo6671f()) {
            mo6699g();
        }
        mo6683G();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo6696d() {
        mo6884m();
        this.f3755j = mo6885n().mo6990a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo6697e() {
        mo6884m();
        if (!mo6888q().mo6731a()) {
            mo6700h();
        }
    }

    /* renamed from: f */
    public void mo6698f() {
        C0628aq.m3622d();
        mo6596D();
        mo6869b("Service disconnected");
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo6699g() {
        if (!this.f3756k && mo6888q().mo6733c() && !this.f3750e.mo6647b()) {
            if (this.f3754i.mo6834a(mo6888q().mo6754x())) {
                this.f3754i.mo6833a();
                mo6869b("Connecting to service");
                if (this.f3750e.mo6648c()) {
                    mo6869b("Connected to service");
                    this.f3754i.mo6835b();
                    mo6697e();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[LOOP:1: B:18:0x0062->B:17:?, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC] */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6700h() {
        /*
            r6 = this;
            com.google.android.gms.p018c.C0628aq.m3622d()
            r6.mo6596D()
            r6.mo6883l()
            com.google.android.gms.analytics.internal.bc r0 = r6.mo6888q()
            boolean r0 = r0.mo6733c()
            if (r0 != 0) goto L_0x0018
            java.lang.String r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService"
            r6.mo6879e(r0)
        L_0x0018:
            com.google.android.gms.analytics.internal.ag r0 = r6.f3750e
            boolean r0 = r0.mo6647b()
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "Service not connected"
            r6.mo6869b(r0)
        L_0x0025:
            return
        L_0x0026:
            com.google.android.gms.analytics.internal.al r0 = r6.f3747b
            boolean r0 = r0.mo6671f()
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = "Dispatching local hits to device AnalyticsService"
            r6.mo6869b(r0)
        L_0x0033:
            com.google.android.gms.analytics.internal.al r0 = r6.f3747b     // Catch:{ SQLiteException -> 0x004c }
            com.google.android.gms.analytics.internal.bc r1 = r6.mo6888q()     // Catch:{ SQLiteException -> 0x004c }
            int r1 = r1.mo6742l()     // Catch:{ SQLiteException -> 0x004c }
            long r2 = (long) r1     // Catch:{ SQLiteException -> 0x004c }
            java.util.List r1 = r0.mo6663b((long) r2)     // Catch:{ SQLiteException -> 0x004c }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x004c }
            if (r0 == 0) goto L_0x0062
            r6.mo6683G()     // Catch:{ SQLiteException -> 0x004c }
            goto L_0x0025
        L_0x004c:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from store"
            r6.mo6880e(r1, r0)
            r6.m3086P()
            goto L_0x0025
        L_0x0056:
            r1.remove(r0)
            com.google.android.gms.analytics.internal.al r2 = r6.f3747b     // Catch:{ SQLiteException -> 0x007b }
            long r4 = r0.mo6789c()     // Catch:{ SQLiteException -> 0x007b }
            r2.mo6666c((long) r4)     // Catch:{ SQLiteException -> 0x007b }
        L_0x0062:
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0033
            r0 = 0
            java.lang.Object r0 = r1.get(r0)
            com.google.android.gms.analytics.internal.d r0 = (com.google.android.gms.analytics.internal.C0556d) r0
            com.google.android.gms.analytics.internal.ag r2 = r6.f3750e
            boolean r2 = r2.mo6646a((com.google.android.gms.analytics.internal.C0556d) r0)
            if (r2 != 0) goto L_0x0056
            r6.mo6683G()
            goto L_0x0025
        L_0x007b:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r6.mo6880e(r1, r0)
            r6.m3086P()
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0528ao.mo6700h():void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0205, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f9, code lost:
        if (r12.f3750e.mo6647b() == false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0103, code lost:
        if (mo6888q().mo6731a() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        mo6869b("Service connected, sending hits to the service");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010e, code lost:
        if (r8.isEmpty() != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0110, code lost:
        r0 = r8.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011d, code lost:
        if (r12.f3750e.mo6646a(r0) != false) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011f, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0126, code lost:
        if (r12.f3748c.mo6819b() == false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0128, code lost:
        r9 = r12.f3748c.mo6816a(r8);
        r10 = r9.iterator();
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0137, code lost:
        if (r10.hasNext() == false) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0139, code lost:
        r4 = java.lang.Math.max(r4, r10.next().longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0148, code lost:
        r4 = java.lang.Math.max(r4, r0.mo6789c());
        r8.remove(r0);
        mo6870b("Hit sent do device AnalyticsService for delivery", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r12.f3747b.mo6666c(r0.mo6789c());
        r3.add(java.lang.Long.valueOf(r0.mo6789c()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        mo6880e("Failed to remove hit that was send for delivery", r0);
        m3086P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r12.f3747b.mo6665c();
        r12.f3747b.mo6669d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0182, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0183, code lost:
        mo6880e("Failed to commit local dispatch transaction", r0);
        m3086P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r8.removeAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.f3747b.mo6662a(r9);
        r3.addAll(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0198, code lost:
        r0 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019d, code lost:
        if (r3.isEmpty() == false) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r12.f3747b.mo6665c();
        r12.f3747b.mo6669d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ac, code lost:
        mo6880e("Failed to commit local dispatch transaction", r0);
        m3086P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01b6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        mo6880e("Failed to remove successfully uploaded hits", r0);
        m3086P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        r12.f3747b.mo6665c();
        r12.f3747b.mo6669d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01cc, code lost:
        mo6880e("Failed to commit local dispatch transaction", r0);
        m3086P();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r12.f3747b.mo6665c();
        r12.f3747b.mo6669d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01e4, code lost:
        mo6880e("Failed to commit local dispatch transaction", r0);
        m3086P();
     */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo6701i() {
        /*
            r12 = this;
            r1 = 1
            r2 = 0
            com.google.android.gms.p018c.C0628aq.m3622d()
            r12.mo6596D()
            java.lang.String r0 = "Dispatching a batch of local hits"
            r12.mo6869b(r0)
            com.google.android.gms.analytics.internal.ag r0 = r12.f3750e
            boolean r0 = r0.mo6647b()
            if (r0 != 0) goto L_0x0032
            com.google.android.gms.analytics.internal.bc r0 = r12.mo6888q()
            boolean r0 = r0.mo6731a()
            if (r0 != 0) goto L_0x0032
            r0 = r1
        L_0x0020:
            com.google.android.gms.analytics.internal.l r3 = r12.f3748c
            boolean r3 = r3.mo6819b()
            if (r3 != 0) goto L_0x0034
        L_0x0028:
            if (r0 == 0) goto L_0x0036
            if (r1 == 0) goto L_0x0036
            java.lang.String r0 = "No network or service available. Will retry later"
            r12.mo6869b(r0)
        L_0x0031:
            return r2
        L_0x0032:
            r0 = r2
            goto L_0x0020
        L_0x0034:
            r1 = r2
            goto L_0x0028
        L_0x0036:
            com.google.android.gms.analytics.internal.bc r0 = r12.mo6888q()
            int r0 = r0.mo6742l()
            com.google.android.gms.analytics.internal.bc r1 = r12.mo6888q()
            int r1 = r1.mo6743m()
            int r0 = java.lang.Math.max(r0, r1)
            long r6 = (long) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
        L_0x0052:
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ all -> 0x01ee }
            r0.mo6664b()     // Catch:{ all -> 0x01ee }
            r3.clear()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.List r8 = r0.mo6663b((long) r6)     // Catch:{ SQLiteException -> 0x00d3 }
            boolean r0 = r8.isEmpty()     // Catch:{ SQLiteException -> 0x00d3 }
            if (r0 == 0) goto L_0x0083
            java.lang.String r0 = "Store is empty, nothing to dispatch"
            r12.mo6869b(r0)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.m3086P()     // Catch:{ SQLiteException -> 0x00d3 }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x0079 }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x0079 }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x0079 }
            goto L_0x0031
        L_0x0079:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x0083:
            java.lang.String r0 = "Hits loaded from store. count"
            int r1 = r8.size()     // Catch:{ SQLiteException -> 0x00d3 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ SQLiteException -> 0x00d3 }
            r12.mo6866a(r0, r1)     // Catch:{ SQLiteException -> 0x00d3 }
            java.util.Iterator r1 = r8.iterator()     // Catch:{ all -> 0x01ee }
        L_0x0094:
            boolean r0 = r1.hasNext()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x00f3
            java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.d r0 = (com.google.android.gms.analytics.internal.C0556d) r0     // Catch:{ all -> 0x01ee }
            long r10 = r0.mo6789c()     // Catch:{ all -> 0x01ee }
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0094
            java.lang.String r0 = "Database contains successfully uploaded hit"
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01ee }
            int r3 = r8.size()     // Catch:{ all -> 0x01ee }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01ee }
            r12.mo6878d(r0, r1, r3)     // Catch:{ all -> 0x01ee }
            r12.m3086P()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x00c8 }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x00c8 }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x00c8 }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x00c8 }
            goto L_0x0031
        L_0x00c8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Failed to read hits from persisted store"
            r12.mo6877d(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.m3086P()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x00e8 }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x00e8 }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x00e8 }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x00e8 }
            goto L_0x0031
        L_0x00e8:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x00f3:
            com.google.android.gms.analytics.internal.ag r0 = r12.f3750e     // Catch:{ all -> 0x01ee }
            boolean r0 = r0.mo6647b()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x0205
            com.google.android.gms.analytics.internal.bc r0 = r12.mo6888q()     // Catch:{ all -> 0x01ee }
            boolean r0 = r0.mo6731a()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x0205
            java.lang.String r0 = "Service connected, sending hits to the service"
            r12.mo6869b(r0)     // Catch:{ all -> 0x01ee }
        L_0x010a:
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x0205
            r0 = 0
            java.lang.Object r0 = r8.get(r0)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.d r0 = (com.google.android.gms.analytics.internal.C0556d) r0     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.ag r1 = r12.f3750e     // Catch:{ all -> 0x01ee }
            boolean r1 = r1.mo6646a((com.google.android.gms.analytics.internal.C0556d) r0)     // Catch:{ all -> 0x01ee }
            if (r1 != 0) goto L_0x0148
            r0 = r4
        L_0x0120:
            com.google.android.gms.analytics.internal.l r4 = r12.f3748c     // Catch:{ all -> 0x01ee }
            boolean r4 = r4.mo6819b()     // Catch:{ all -> 0x01ee }
            if (r4 == 0) goto L_0x0199
            com.google.android.gms.analytics.internal.l r4 = r12.f3748c     // Catch:{ all -> 0x01ee }
            java.util.List r9 = r4.mo6816a((java.util.List<com.google.android.gms.analytics.internal.C0556d>) r8)     // Catch:{ all -> 0x01ee }
            java.util.Iterator r10 = r9.iterator()     // Catch:{ all -> 0x01ee }
            r4 = r0
        L_0x0133:
            boolean r0 = r10.hasNext()     // Catch:{ all -> 0x01ee }
            if (r0 == 0) goto L_0x018d
            java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x01ee }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x01ee }
            long r0 = r0.longValue()     // Catch:{ all -> 0x01ee }
            long r4 = java.lang.Math.max(r4, r0)     // Catch:{ all -> 0x01ee }
            goto L_0x0133
        L_0x0148:
            long r10 = r0.mo6789c()     // Catch:{ all -> 0x01ee }
            long r4 = java.lang.Math.max(r4, r10)     // Catch:{ all -> 0x01ee }
            r8.remove(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r1 = "Hit sent do device AnalyticsService for delivery"
            r12.mo6870b(r1, r0)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r1 = r12.f3747b     // Catch:{ SQLiteException -> 0x016d }
            long r10 = r0.mo6789c()     // Catch:{ SQLiteException -> 0x016d }
            r1.mo6666c((long) r10)     // Catch:{ SQLiteException -> 0x016d }
            long r0 = r0.mo6789c()     // Catch:{ SQLiteException -> 0x016d }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x016d }
            r3.add(r0)     // Catch:{ SQLiteException -> 0x016d }
            goto L_0x010a
        L_0x016d:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove hit that was send for delivery"
            r12.mo6880e(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.m3086P()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x0182 }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x0182 }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x0182 }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x0182 }
            goto L_0x0031
        L_0x0182:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x018d:
            r8.removeAll(r9)     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x01b6 }
            r0.mo6662a((java.util.List<java.lang.Long>) r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r3.addAll(r9)     // Catch:{ SQLiteException -> 0x01b6 }
            r0 = r4
        L_0x0199:
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x01ee }
            if (r4 == 0) goto L_0x01d6
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x01ab }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x01ab }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x01ab }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x01ab }
            goto L_0x0031
        L_0x01ab:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x01b6:
            r0 = move-exception
            java.lang.String r1 = "Failed to remove successfully uploaded hits"
            r12.mo6880e(r1, r0)     // Catch:{ all -> 0x01ee }
            r12.m3086P()     // Catch:{ all -> 0x01ee }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x01cb }
            r0.mo6665c()     // Catch:{ SQLiteException -> 0x01cb }
            com.google.android.gms.analytics.internal.al r0 = r12.f3747b     // Catch:{ SQLiteException -> 0x01cb }
            r0.mo6669d()     // Catch:{ SQLiteException -> 0x01cb }
            goto L_0x0031
        L_0x01cb:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x01d6:
            com.google.android.gms.analytics.internal.al r4 = r12.f3747b     // Catch:{ SQLiteException -> 0x01e3 }
            r4.mo6665c()     // Catch:{ SQLiteException -> 0x01e3 }
            com.google.android.gms.analytics.internal.al r4 = r12.f3747b     // Catch:{ SQLiteException -> 0x01e3 }
            r4.mo6669d()     // Catch:{ SQLiteException -> 0x01e3 }
            r4 = r0
            goto L_0x0052
        L_0x01e3:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x01ee:
            r0 = move-exception
            com.google.android.gms.analytics.internal.al r1 = r12.f3747b     // Catch:{ SQLiteException -> 0x01fa }
            r1.mo6665c()     // Catch:{ SQLiteException -> 0x01fa }
            com.google.android.gms.analytics.internal.al r1 = r12.f3747b     // Catch:{ SQLiteException -> 0x01fa }
            r1.mo6669d()     // Catch:{ SQLiteException -> 0x01fa }
            throw r0
        L_0x01fa:
            r0 = move-exception
            java.lang.String r1 = "Failed to commit local dispatch transaction"
            r12.mo6880e(r1, r0)
            r12.m3086P()
            goto L_0x0031
        L_0x0205:
            r0 = r4
            goto L_0x0120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0528ao.mo6701i():boolean");
    }

    /* renamed from: j */
    public void mo6702j() {
        C0628aq.m3622d();
        mo6596D();
        mo6873c("Sync dispatching local hits");
        long j = this.f3755j;
        if (!mo6888q().mo6731a()) {
            mo6699g();
        }
        do {
            try {
            } catch (Throwable th) {
                mo6880e("Sync local dispatch failed", th);
                mo6683G();
                return;
            }
        } while (mo6701i());
        mo6894w().mo6827e();
        mo6683G();
        if (this.f3755j != j) {
            this.f3749d.mo6809c();
        }
    }
}
