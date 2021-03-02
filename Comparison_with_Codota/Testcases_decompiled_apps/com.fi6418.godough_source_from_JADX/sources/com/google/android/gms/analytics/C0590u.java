package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.C0515ab;
import com.google.android.gms.analytics.internal.C0519af;
import com.google.android.gms.analytics.internal.C0540b;
import com.google.android.gms.analytics.internal.C0556d;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.p018c.C0636ay;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.u */
class C0590u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map f3933a;

    /* renamed from: b */
    final /* synthetic */ boolean f3934b;

    /* renamed from: c */
    final /* synthetic */ String f3935c;

    /* renamed from: d */
    final /* synthetic */ long f3936d;

    /* renamed from: e */
    final /* synthetic */ boolean f3937e;

    /* renamed from: f */
    final /* synthetic */ boolean f3938f;

    /* renamed from: g */
    final /* synthetic */ String f3939g;

    /* renamed from: h */
    final /* synthetic */ C0589t f3940h;

    C0590u(C0589t tVar, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.f3940h = tVar;
        this.f3933a = map;
        this.f3934b = z;
        this.f3935c = str;
        this.f3936d = j;
        this.f3937e = z2;
        this.f3938f = z3;
        this.f3939g = str2;
    }

    public void run() {
        boolean z = true;
        if (this.f3940h.f3932e.mo6933b()) {
            this.f3933a.put("sc", "start");
        }
        C0570r.m3337b(this.f3933a, "cid", this.f3940h.mo6890s().mo6910h());
        String str = (String) this.f3933a.get("sf");
        if (str != null) {
            double a = C0570r.m3324a(str, 100.0d);
            if (C0570r.m3332a(a, (String) this.f3933a.get("cid"))) {
                this.f3940h.mo6870b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(a));
                return;
            }
        }
        C0540b b = this.f3940h.mo6896y();
        if (this.f3934b) {
            C0570r.m3331a((Map<String, String>) this.f3933a, "ate", b.mo6714b());
            C0570r.m3329a((Map<String, String>) this.f3933a, "adid", b.mo6715c());
        } else {
            this.f3933a.remove("ate");
            this.f3933a.remove("adid");
        }
        C0636ay c = this.f3940h.mo6897z().mo6681c();
        C0570r.m3329a((Map<String, String>) this.f3933a, "an", c.mo7028a());
        C0570r.m3329a((Map<String, String>) this.f3933a, "av", c.mo7031b());
        C0570r.m3329a((Map<String, String>) this.f3933a, "aid", c.mo7033c());
        C0570r.m3329a((Map<String, String>) this.f3933a, "aiid", c.mo7035d());
        this.f3933a.put("v", "1");
        this.f3933a.put("_v", C0515ab.f3701b);
        C0570r.m3329a((Map<String, String>) this.f3933a, "ul", this.f3940h.mo6864A().mo6769b().mo7072f());
        C0570r.m3329a((Map<String, String>) this.f3933a, "sr", this.f3940h.mo6864A().mo6770c());
        if ((this.f3935c.equals("transaction") || this.f3935c.equals("item")) || this.f3940h.f3931d.mo6801a()) {
            long a2 = C0570r.m3325a((String) this.f3933a.get("ht"));
            if (a2 == 0) {
                a2 = this.f3936d;
            }
            if (this.f3937e) {
                this.f3940h.mo6887p().mo6874c("Dry run enabled. Would have sent hit", new C0556d(this.f3940h, this.f3933a, a2, this.f3938f));
                return;
            }
            String str2 = (String) this.f3933a.get("cid");
            HashMap hashMap = new HashMap();
            C0570r.m3330a((Map<String, String>) hashMap, "uid", (Map<String, String>) this.f3933a);
            C0570r.m3330a((Map<String, String>) hashMap, "an", (Map<String, String>) this.f3933a);
            C0570r.m3330a((Map<String, String>) hashMap, "aid", (Map<String, String>) this.f3933a);
            C0570r.m3330a((Map<String, String>) hashMap, "av", (Map<String, String>) this.f3933a);
            C0570r.m3330a((Map<String, String>) hashMap, "aiid", (Map<String, String>) this.f3933a);
            String str3 = this.f3939g;
            if (TextUtils.isEmpty((CharSequence) this.f3933a.get("adid"))) {
                z = false;
            }
            this.f3933a.put("_s", String.valueOf(this.f3940h.mo6891t().mo6846a(new C0519af(0, str2, str3, z, 0, hashMap))));
            this.f3940h.mo6891t().mo6848a(new C0556d(this.f3940h, this.f3933a, a2, this.f3938f));
            return;
        }
        this.f3940h.mo6887p().mo6805a((Map<String, String>) this.f3933a, "Too many hits sent too quickly, rate limiting invoked");
    }
}
