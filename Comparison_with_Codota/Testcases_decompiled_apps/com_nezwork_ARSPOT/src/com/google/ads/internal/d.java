package com.google.ads.internal;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AppEventListener;
import com.google.ads.ab;
import com.google.ads.ac;
import com.google.ads.af;
import com.google.ads.c;
import com.google.ads.e;
import com.google.ads.f;
import com.google.ads.g;
import com.google.ads.h;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.a;
import com.google.ads.util.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class d {
    private static final Object a = new Object();
    private final m b;
    private c c;
    private AdRequest d;
    private g e;
    private AdWebView f;
    private i g;
    private Handler h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private SharedPreferences o;
    private long p;
    private ac q;
    private boolean r;
    private LinkedList<String> s;
    private LinkedList<String> t;
    private int u = -1;
    private Boolean v;
    private com.google.ads.d w;
    private e x;
    private f y;
    private String z = null;

    public d(m mVar, boolean z2) {
        this.b = mVar;
        this.r = z2;
        this.e = new g();
        this.c = null;
        this.d = null;
        this.k = false;
        this.h = new Handler();
        this.p = 60000;
        this.l = false;
        this.n = false;
        this.m = true;
        if (mVar != null && mVar.d.a() != null) {
            synchronized (a) {
                this.o = mVar.d.a().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
                if (z2) {
                    long j2 = this.o.getLong("Timeout" + mVar.b, -1);
                    if (j2 < 0) {
                        this.i = 5000;
                    } else {
                        this.i = j2;
                    }
                } else {
                    this.i = 60000;
                }
            }
            this.q = new ac(this);
            this.s = new LinkedList<>();
            this.t = new LinkedList<>();
            a();
            AdUtil.h(mVar.d.a());
            this.w = new com.google.ads.d();
            this.x = new e(this);
            this.v = null;
            this.y = null;
        }
    }

    public synchronized void a() {
        this.f = new AdWebView(this.b, this.b.i.a().b());
        this.f.setVisibility(8);
        this.g = i.a(this, a.c, true, this.b.b());
        this.f.setWebViewClient(this.g);
        if (AdUtil.a < this.b.a.a().a.a().a.a().intValue() && !this.b.i.a().a()) {
            b.a("Disabling hardware acceleration for a banner.");
            this.f.b();
        }
    }

    public synchronized void b() {
        if (this.x != null) {
            this.x.b();
        }
        this.b.k.a(null);
        this.b.l.a(null);
        A();
        if (this.f != null) {
            this.f.destroy();
        }
    }

    public void a(String str) {
        Uri build = new Uri.Builder().encodedQuery(str).build();
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> b2 = AdUtil.b(build);
        for (String next : b2.keySet()) {
            sb.append(next).append(" = ").append(b2.get(next)).append("\n");
        }
        this.z = sb.toString().trim();
        if (TextUtils.isEmpty(this.z)) {
            this.z = null;
        }
    }

    public String c() {
        return this.z;
    }

    public synchronized void d() {
        this.m = false;
        b.a("Refreshing is no longer allowed on this AdView.");
    }

    public synchronized void e() {
        if (this.l) {
            b.a("Disabling refreshing.");
            this.h.removeCallbacks(this.q);
            this.l = false;
        } else {
            b.a("Refreshing is already disabled.");
        }
    }

    public synchronized void f() {
        this.n = false;
        if (!this.b.a()) {
            b.a("Tried to enable refreshing on something other than an AdView.");
        } else if (!this.m) {
            b.a("Refreshing disabled on this AdView");
        } else if (!this.l) {
            b.a("Enabling refreshing every " + this.p + " milliseconds.");
            this.h.postDelayed(this.q, this.p);
            this.l = true;
        } else {
            b.a("Refreshing is already enabled.");
        }
    }

    public void g() {
        f();
        this.n = true;
    }

    public m h() {
        return this.b;
    }

    public synchronized com.google.ads.d i() {
        return this.w;
    }

    public synchronized c j() {
        return this.c;
    }

    public synchronized AdWebView k() {
        return this.f;
    }

    public synchronized i l() {
        return this.g;
    }

    public g m() {
        return this.e;
    }

    public synchronized void a(int i2) {
        this.u = i2;
    }

    public synchronized int n() {
        return this.u;
    }

    public long o() {
        return this.i;
    }

    public synchronized boolean p() {
        return this.c != null;
    }

    public synchronized boolean q() {
        return this.j;
    }

    public synchronized boolean r() {
        return this.k;
    }

    public synchronized boolean s() {
        return this.l;
    }

    public synchronized void a(AdRequest adRequest) {
        if (p()) {
            b.e("loadAd called while the ad is already loading, so aborting.");
        } else if (AdActivity.isShowing()) {
            b.e("loadAd called while an interstitial or landing page is displayed, so aborting");
        } else if (AdUtil.c(this.b.d.a()) && AdUtil.b(this.b.d.a())) {
            if (af.a(this.b.d.a(), this.o.getLong("GoogleAdMobDoritosLife", 60000))) {
                af.a(this.b.c.a());
            }
            this.k = false;
            this.s.clear();
            this.d = adRequest;
            if (this.w.a()) {
                this.x.a(this.w.b(), adRequest);
            } else {
                this.c = new c(this);
                this.c.a(adRequest);
            }
        }
    }

    public synchronized void a(AdRequest.ErrorCode errorCode) {
        this.c = null;
        if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
            m().q();
            a(60.0f);
            if (!s()) {
                g();
            }
        }
        if (this.b.b()) {
            if (errorCode == AdRequest.ErrorCode.NO_FILL) {
                this.e.v();
            } else if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
                this.e.t();
            }
        }
        b.c("onFailedToReceiveAd(" + errorCode + ")");
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onFailedToReceiveAd(this.b.f.a(), errorCode);
        }
    }

    public synchronized void a(c cVar) {
        this.c = null;
        if (cVar.d()) {
            a((float) cVar.e());
            if (!this.l) {
                f();
            }
        } else if (this.l) {
            e();
        }
        this.x.a(cVar, this.d);
    }

    public synchronized void a(View view, h hVar, f fVar, boolean z2) {
        b.a("AdManager.onReceiveGWhirlAd() called.");
        this.k = true;
        this.y = fVar;
        if (this.b.a()) {
            a(view);
            a(fVar, Boolean.valueOf(z2));
        }
        this.x.d(hVar);
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onReceiveAd(this.b.f.a());
        }
    }

    public synchronized void a(f fVar, boolean z2) {
        b.a(String.format(Locale.US, "AdManager.onGWhirlAdClicked(%b) called.", new Object[]{Boolean.valueOf(z2)}));
        b(fVar, Boolean.valueOf(z2));
    }

    public synchronized void b(c cVar) {
        b.a("AdManager.onGWhirlNoFill() called.");
        a(cVar.i(), cVar.c());
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onFailedToReceiveAd(this.b.f.a(), AdRequest.ErrorCode.NO_FILL);
        }
    }

    public synchronized void t() {
        this.e.w();
        b.c("onDismissScreen()");
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onDismissScreen(this.b.f.a());
        }
    }

    public synchronized void u() {
        b.c("onPresentScreen()");
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onPresentScreen(this.b.f.a());
        }
    }

    public synchronized void v() {
        b.c("onLeaveApplication()");
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onLeaveApplication(this.b.f.a());
        }
    }

    public synchronized void a(String str, String str2) {
        AppEventListener a2 = this.b.l.a();
        if (a2 != null) {
            a2.onAppEvent(str, str2);
        }
    }

    public void w() {
        this.e.f();
        B();
    }

    private void a(f fVar, Boolean bool) {
        List d2 = fVar.d();
        if (d2 == null) {
            d2 = new ArrayList();
            d2.add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
        }
        String b2 = fVar.b();
        a(d2, fVar.a(), b2, fVar.c(), bool, this.e.d(), this.e.e());
    }

    private void b(f fVar, Boolean bool) {
        List e2 = fVar.e();
        if (e2 == null) {
            e2 = new ArrayList();
            e2.add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
        }
        a(e2, fVar.a(), fVar.b(), fVar.c(), bool, (String) null, (String) null);
    }

    private void a(List<String> list, String str) {
        List<String> list2;
        if (list == null) {
            list2 = new ArrayList<>();
            list2.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        } else {
            list2 = list;
        }
        a(list2, (String) null, (String) null, str, (Boolean) null, this.e.d(), this.e.e());
    }

    private void a(List<String> list, String str, String str2, String str3, Boolean bool, String str4, String str5) {
        String a2 = AdUtil.a(this.b.d.a());
        com.google.ads.b a3 = com.google.ads.b.a();
        String bigInteger = a3.b().toString();
        String bigInteger2 = a3.c().toString();
        for (String a4 : list) {
            new Thread(new ab(g.a(a4, this.b.b.a(), bool, a2, str, str2, str3, bigInteger, bigInteger2, str4, str5), this.b.d.a())).start();
        }
        this.e.b();
    }

    public synchronized void x() {
        Activity a2 = this.b.c.a();
        if (a2 == null) {
            b.e("activity was null while trying to ping tracking URLs.");
        } else {
            Iterator it = this.s.iterator();
            while (it.hasNext()) {
                new Thread(new ab((String) it.next(), a2.getApplicationContext())).start();
            }
        }
    }

    public void a(Runnable runnable) {
        this.h.post(runnable);
    }

    public synchronized void y() {
        if (this.d == null) {
            b.a("Tried to refresh before calling loadAd().");
        } else if (this.b.a()) {
            if (!this.b.g.a().isShown() || !AdUtil.d()) {
                b.a("Not refreshing because the ad is not visible.");
            } else {
                b.c("Refreshing ad.");
                a(this.d);
            }
            if (this.n) {
                e();
            } else {
                this.h.postDelayed(this.q, this.p);
            }
        } else {
            b.a("Tried to refresh an ad that wasn't an AdView.");
        }
    }

    public void a(long j2) {
        synchronized (a) {
            SharedPreferences.Editor edit = this.o.edit();
            edit.putLong("Timeout" + this.b.b, j2);
            edit.commit();
            if (this.r) {
                this.i = j2;
            }
        }
    }

    public synchronized void a(boolean z2) {
        this.j = z2;
    }

    public void a(View view) {
        this.b.e.a().removeAllViews();
        this.b.e.a().addView(view);
    }

    public synchronized void a(float f2) {
        long j2 = this.p;
        this.p = (long) (1000.0f * f2);
        if (s() && this.p != j2) {
            e();
            f();
        }
    }

    public synchronized void b(long j2) {
        if (j2 > 0) {
            this.o.edit().putLong("GoogleAdMobDoritosLife", j2).commit();
        }
    }

    public synchronized void z() {
        a.a(this.b.b());
        if (this.k) {
            this.k = false;
            if (this.v == null) {
                b.b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
            } else if (!this.v.booleanValue()) {
                AdActivity.launchAdActivity(this, new e("interstitial"));
                x();
            } else if (this.x.c()) {
                a(this.y, (Boolean) false);
            }
        } else {
            b.c("Cannot show interstitial because it is not loaded and ready.");
        }
    }

    public synchronized void A() {
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        if (this.f != null) {
            this.f.stopLoading();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void B() {
        Activity a2 = this.b.c.a();
        if (a2 == null) {
            b.e("activity was null while trying to ping click tracking URLs.");
        } else {
            Iterator it = this.t.iterator();
            while (it.hasNext()) {
                new Thread(new ab((String) it.next(), a2.getApplicationContext())).start();
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void C() {
        this.c = null;
        this.k = true;
        this.f.setVisibility(0);
        if (this.b.a()) {
            a((View) this.f);
        }
        this.e.g();
        if (this.b.a()) {
            x();
        }
        b.c("onReceiveAd()");
        AdListener a2 = this.b.k.a();
        if (a2 != null) {
            a2.onReceiveAd(this.b.f.a());
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void b(String str) {
        b.a("Adding a tracking URL: " + str);
        this.s.add(str);
    }

    /* access modifiers changed from: protected */
    public synchronized void a(LinkedList<String> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b.a("Adding a click tracking URL: " + ((String) it.next()));
        }
        this.t = linkedList;
    }

    public void b(boolean z2) {
        this.v = Boolean.valueOf(z2);
    }
}
