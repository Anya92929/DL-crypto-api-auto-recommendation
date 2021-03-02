package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.C0165Ad;
import com.google.ads.C0170ae;
import com.google.ads.C0171af;
import com.google.ads.C0201at;
import com.google.ads.C0207b;
import com.google.ads.C0208c;
import com.google.ads.C0210d;
import com.google.ads.C0211e;
import com.google.ads.C0220f;
import com.google.ads.C0221g;
import com.google.ads.C0223h;
import com.google.ads.C0264l;
import com.google.ads.C0265m;
import com.google.ads.C0272n;
import com.google.ads.InterstitialAd;
import com.google.ads.doubleclick.SwipeableDfpAdView;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;
import com.google.ads.util.IcsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.ads.internal.d */
public class C0247d {

    /* renamed from: a */
    private static final Object f532a = new Object();

    /* renamed from: A */
    private String f533A = null;

    /* renamed from: B */
    private String f534B = null;

    /* renamed from: b */
    private final C0272n f535b;

    /* renamed from: c */
    private C0238c f536c;

    /* renamed from: d */
    private AdRequest f537d;

    /* renamed from: e */
    private C0252g f538e;

    /* renamed from: f */
    private AdWebView f539f;

    /* renamed from: g */
    private C0254i f540g;

    /* renamed from: h */
    private boolean f541h = false;

    /* renamed from: i */
    private long f542i;

    /* renamed from: j */
    private boolean f543j;

    /* renamed from: k */
    private boolean f544k;

    /* renamed from: l */
    private boolean f545l;

    /* renamed from: m */
    private boolean f546m;

    /* renamed from: n */
    private boolean f547n;

    /* renamed from: o */
    private SharedPreferences f548o;

    /* renamed from: p */
    private long f549p;

    /* renamed from: q */
    private C0171af f550q;

    /* renamed from: r */
    private boolean f551r;

    /* renamed from: s */
    private LinkedList<String> f552s;

    /* renamed from: t */
    private LinkedList<String> f553t;

    /* renamed from: u */
    private LinkedList<String> f554u;

    /* renamed from: v */
    private int f555v = -1;

    /* renamed from: w */
    private Boolean f556w;

    /* renamed from: x */
    private C0210d f557x;

    /* renamed from: y */
    private C0211e f558y;

    /* renamed from: z */
    private C0220f f559z;

    public C0247d(C0165Ad ad, Activity activity, AdSize adSize, String str, ViewGroup viewGroup, boolean z) {
        AdView adView;
        InterstitialAd interstitialAd;
        AdView adView2;
        InterstitialAd interstitialAd2;
        this.f551r = z;
        this.f538e = new C0252g();
        this.f536c = null;
        this.f537d = null;
        this.f544k = false;
        this.f549p = 60000;
        this.f545l = false;
        this.f547n = false;
        this.f546m = true;
        C0253h a = adSize == null ? C0253h.f584a : C0253h.m393a(adSize, activity.getApplicationContext());
        if (ad instanceof SwipeableDfpAdView) {
            a.mo3608a(true);
        }
        if (activity == null) {
            C0265m a2 = C0265m.m411a();
            if (ad instanceof AdView) {
                adView2 = (AdView) ad;
            } else {
                adView2 = null;
            }
            if (ad instanceof InterstitialAd) {
                interstitialAd2 = (InterstitialAd) ad;
            } else {
                interstitialAd2 = null;
            }
            this.f535b = new C0272n(a2, ad, adView2, interstitialAd2, str, (Activity) null, (Context) null, viewGroup, a, this);
            return;
        }
        synchronized (f532a) {
            this.f548o = activity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
            if (z) {
                long j = this.f548o.getLong("Timeout" + str, -1);
                if (j < 0) {
                    this.f542i = 5000;
                } else {
                    this.f542i = j;
                }
            } else {
                this.f542i = 60000;
            }
        }
        C0265m a3 = C0265m.m411a();
        if (ad instanceof AdView) {
            adView = (AdView) ad;
        } else {
            adView = null;
        }
        if (ad instanceof InterstitialAd) {
            interstitialAd = (InterstitialAd) ad;
        } else {
            interstitialAd = null;
        }
        this.f535b = new C0272n(a3, ad, adView, interstitialAd, str, activity, activity.getApplicationContext(), viewGroup, a, this);
        this.f550q = new C0171af(this);
        this.f552s = new LinkedList<>();
        this.f553t = new LinkedList<>();
        this.f554u = new LinkedList<>();
        mo3522a();
        AdUtil.m467h(this.f535b.f659f.mo3725a());
        this.f557x = new C0210d();
        this.f558y = new C0211e(this);
        this.f556w = null;
        this.f559z = null;
    }

    /* renamed from: a */
    public synchronized void mo3522a() {
        AdSize c = this.f535b.f660g.mo3725a().mo3612c();
        this.f539f = AdUtil.f690a >= 14 ? new IcsUtil.IcsAdWebView(this.f535b, c) : new AdWebView(this.f535b, c);
        this.f539f.setVisibility(8);
        this.f540g = C0254i.m399a(this, C0232a.f477d, true, this.f535b.mo3684b());
        this.f539f.setWebViewClient(this.f540g);
        if (AdUtil.f690a < this.f535b.f657d.mo3725a().f616b.mo3725a().f619b.mo3726a().intValue() && !this.f535b.f660g.mo3725a().mo3609a()) {
            C0284b.m480a("Disabling hardware acceleration for a banner.");
            this.f539f.mo3457g();
        }
    }

    /* renamed from: b */
    public synchronized void mo3538b() {
        if (this.f558y != null) {
            this.f558y.mo3390b();
        }
        this.f535b.f668o.mo3727a(null);
        this.f535b.f669p.mo3727a(null);
        mo3518C();
        mo3547f();
        if (this.f539f != null) {
            this.f539f.destroy();
        }
        this.f541h = true;
    }

    /* renamed from: a */
    public void mo3534a(String str) {
        this.f534B = str;
        Uri build = new Uri.Builder().encodedQuery(str).build();
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> b = AdUtil.m457b(build);
        for (String next : b.keySet()) {
            sb.append(next).append(" = ").append(b.get(next)).append("\n");
        }
        this.f533A = sb.toString().trim();
        if (TextUtils.isEmpty(this.f533A)) {
            this.f533A = null;
        }
    }

    /* renamed from: c */
    public String mo3543c() {
        return this.f533A;
    }

    /* renamed from: d */
    public String mo3545d() {
        return this.f534B;
    }

    /* renamed from: e */
    public synchronized void mo3546e() {
        this.f546m = false;
        C0284b.m480a("Refreshing is no longer allowed on this AdView.");
    }

    /* renamed from: f */
    public synchronized void mo3547f() {
        if (this.f545l) {
            C0284b.m480a("Disabling refreshing.");
            C0265m.m411a().f617c.mo3725a().removeCallbacks(this.f550q);
            this.f545l = false;
        } else {
            C0284b.m480a("Refreshing is already disabled.");
        }
    }

    /* renamed from: g */
    public synchronized void mo3548g() {
        this.f547n = false;
        if (!this.f535b.mo3683a()) {
            C0284b.m480a("Tried to enable refreshing on something other than an AdView.");
        } else if (!this.f546m) {
            C0284b.m480a("Refreshing disabled on this AdView");
        } else if (!this.f545l) {
            C0284b.m480a("Enabling refreshing every " + this.f549p + " milliseconds.");
            C0265m.m411a().f617c.mo3725a().postDelayed(this.f550q, this.f549p);
            this.f545l = true;
        } else {
            C0284b.m480a("Refreshing is already enabled.");
        }
    }

    /* renamed from: h */
    public void mo3549h() {
        mo3548g();
        this.f547n = true;
    }

    /* renamed from: i */
    public C0272n mo3550i() {
        return this.f535b;
    }

    /* renamed from: j */
    public synchronized C0210d mo3551j() {
        return this.f557x;
    }

    /* renamed from: k */
    public synchronized C0238c mo3552k() {
        return this.f536c;
    }

    /* renamed from: l */
    public synchronized AdWebView mo3553l() {
        return this.f539f;
    }

    /* renamed from: m */
    public synchronized C0254i mo3554m() {
        return this.f540g;
    }

    /* renamed from: n */
    public C0252g mo3555n() {
        return this.f538e;
    }

    /* renamed from: a */
    public synchronized void mo3524a(int i) {
        this.f555v = i;
    }

    /* renamed from: o */
    public synchronized int mo3556o() {
        return this.f555v;
    }

    /* renamed from: p */
    public long mo3557p() {
        return this.f542i;
    }

    /* renamed from: q */
    public synchronized boolean mo3558q() {
        return this.f536c != null;
    }

    /* renamed from: r */
    public synchronized boolean mo3559r() {
        return this.f543j;
    }

    /* renamed from: s */
    public synchronized boolean mo3560s() {
        return this.f544k;
    }

    /* renamed from: t */
    public synchronized boolean mo3561t() {
        return this.f545l;
    }

    /* renamed from: a */
    public synchronized void mo3530a(AdRequest adRequest) {
        C0284b.m488d("v6.4.1 RC00");
        if (this.f541h) {
            C0284b.m490e("loadAd called after ad was destroyed.");
        } else if (mo3558q()) {
            C0284b.m490e("loadAd called while the ad is already loading, so aborting.");
        } else if (AdActivity.isShowing()) {
            C0284b.m490e("loadAd called while an interstitial or landing page is displayed, so aborting");
        } else if (AdUtil.m461c(this.f535b.f659f.mo3725a()) && AdUtil.m459b(this.f535b.f659f.mo3725a())) {
            if (C0201at.m113a(this.f535b.f659f.mo3725a(), this.f548o.getLong("GoogleAdMobDoritosLife", 60000))) {
                C0201at.m112a(this.f535b.f656c.mo3728a());
            }
            this.f544k = false;
            this.f552s.clear();
            this.f553t.clear();
            this.f537d = adRequest;
            if (this.f557x.mo3373a()) {
                this.f558y.mo3385a(this.f557x.mo3374b(), adRequest);
            } else {
                C0264l lVar = new C0264l(this.f535b);
                this.f535b.f666m.mo3727a(lVar);
                this.f536c = lVar.f612b.mo3726a();
                this.f536c.mo3493a(adRequest);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3529a(AdRequest.ErrorCode errorCode) {
        this.f536c = null;
        if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
            mo3523a(60.0f);
            if (!mo3561t()) {
                mo3549h();
            }
        }
        if (this.f535b.mo3684b()) {
            if (errorCode == AdRequest.ErrorCode.NO_FILL) {
                this.f538e.mo3577B();
            } else if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
                this.f538e.mo3607z();
            }
        }
        C0284b.m486c("onFailedToReceiveAd(" + errorCode + ")");
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onFailedToReceiveAd(this.f535b.f654a.mo3725a(), errorCode);
        }
    }

    /* renamed from: a */
    public synchronized void mo3531a(C0208c cVar) {
        this.f536c = null;
        this.f558y.mo3385a(cVar, this.f537d);
    }

    /* renamed from: a */
    public synchronized void mo3528a(View view, C0223h hVar, C0220f fVar, boolean z) {
        C0284b.m480a("AdManager.onReceiveGWhirlAd() called.");
        this.f544k = true;
        this.f559z = fVar;
        if (this.f535b.mo3683a()) {
            mo3527a(view);
            m277a(fVar, Boolean.valueOf(z));
        }
        this.f558y.mo3394d(hVar);
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onReceiveAd(this.f535b.f654a.mo3725a());
        }
    }

    /* renamed from: a */
    public synchronized void mo3532a(C0220f fVar, boolean z) {
        C0284b.m480a(String.format(Locale.US, "AdManager.onGWhirlAdClicked(%b) called.", new Object[]{Boolean.valueOf(z)}));
        m280b(fVar, Boolean.valueOf(z));
    }

    /* renamed from: b */
    public synchronized void mo3540b(C0208c cVar) {
        C0284b.m480a("AdManager.onGWhirlNoFill() called.");
        m278a(cVar.mo3370i(), cVar.mo3364c());
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onFailedToReceiveAd(this.f535b.f654a.mo3725a(), AdRequest.ErrorCode.NO_FILL);
        }
    }

    /* renamed from: u */
    public synchronized void mo3562u() {
        this.f538e.mo3578C();
        C0284b.m486c("onDismissScreen()");
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onDismissScreen(this.f535b.f654a.mo3725a());
        }
    }

    /* renamed from: v */
    public synchronized void mo3563v() {
        C0284b.m486c("onPresentScreen()");
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onPresentScreen(this.f535b.f654a.mo3725a());
        }
    }

    /* renamed from: w */
    public synchronized void mo3564w() {
        C0284b.m486c("onLeaveApplication()");
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onLeaveApplication(this.f535b.f654a.mo3725a());
        }
    }

    /* renamed from: a */
    public synchronized void mo3535a(String str, String str2) {
        AppEventListener a = this.f535b.f669p.mo3726a();
        if (a != null) {
            a.onAppEvent(this.f535b.f654a.mo3725a(), str, str2);
        }
    }

    /* renamed from: x */
    public void mo3565x() {
        this.f538e.mo3587f();
        mo3519D();
    }

    /* renamed from: a */
    private void m277a(C0220f fVar, Boolean bool) {
        List d = fVar.mo3406d();
        if (d == null) {
            d = new ArrayList();
            d.add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
        }
        String b = fVar.mo3404b();
        m279a(d, fVar.mo3403a(), b, fVar.mo3405c(), bool, this.f538e.mo3585d(), this.f538e.mo3586e());
    }

    /* renamed from: b */
    private void m280b(C0220f fVar, Boolean bool) {
        List e = fVar.mo3407e();
        if (e == null) {
            e = new ArrayList();
            e.add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
        }
        m279a(e, fVar.mo3403a(), fVar.mo3404b(), fVar.mo3405c(), bool, (String) null, (String) null);
    }

    /* renamed from: a */
    private void m278a(List<String> list, String str) {
        List<String> list2;
        if (list == null) {
            list2 = new ArrayList<>();
            list2.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        } else {
            list2 = list;
        }
        m279a(list2, (String) null, (String) null, str, (Boolean) null, this.f538e.mo3585d(), this.f538e.mo3586e());
    }

    /* renamed from: a */
    private void m279a(List<String> list, String str, String str2, String str3, Boolean bool, String str4, String str5) {
        String a = AdUtil.m441a(this.f535b.f659f.mo3725a());
        C0207b a2 = C0207b.m132a();
        String bigInteger = a2.mo3360b().toString();
        String bigInteger2 = a2.mo3361c().toString();
        for (String a3 : list) {
            new Thread(new C0170ae(C0221g.m182a(a3, this.f535b.f661h.mo3725a(), bool, a, str, str2, str3, bigInteger, bigInteger2, str4, str5), this.f535b.f659f.mo3725a())).start();
        }
        this.f538e.mo3583b();
    }

    /* renamed from: y */
    public synchronized void mo3566y() {
        Activity a = this.f535b.f656c.mo3728a();
        if (a == null) {
            C0284b.m490e("activity was null while trying to ping tracking URLs.");
        } else {
            Iterator it = this.f552s.iterator();
            while (it.hasNext()) {
                new Thread(new C0170ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* renamed from: z */
    public synchronized void mo3567z() {
        Activity a = this.f535b.f656c.mo3728a();
        if (a == null) {
            C0284b.m490e("activity was null while trying to ping manual tracking URLs.");
        } else {
            Iterator it = this.f553t.iterator();
            while (it.hasNext()) {
                new Thread(new C0170ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* renamed from: A */
    public synchronized void mo3516A() {
        if (!this.f541h) {
            if (this.f537d == null) {
                C0284b.m480a("Tried to refresh before calling loadAd().");
            } else if (this.f535b.mo3683a()) {
                if (!this.f535b.f663j.mo3725a().isShown() || !AdUtil.m463d()) {
                    C0284b.m480a("Not refreshing because the ad is not visible.");
                } else {
                    C0284b.m486c("Refreshing ad.");
                    mo3530a(this.f537d);
                }
                if (this.f547n) {
                    mo3547f();
                } else {
                    C0265m.m411a().f617c.mo3725a().postDelayed(this.f550q, this.f549p);
                }
            } else {
                C0284b.m480a("Tried to refresh an ad that wasn't an AdView.");
            }
        }
    }

    /* renamed from: a */
    public void mo3526a(long j) {
        synchronized (f532a) {
            SharedPreferences.Editor edit = this.f548o.edit();
            edit.putLong("Timeout" + this.f535b.f661h, j);
            edit.commit();
            if (this.f551r) {
                this.f542i = j;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3537a(boolean z) {
        this.f543j = z;
    }

    /* renamed from: a */
    public void mo3527a(View view) {
        this.f535b.f662i.mo3725a().setVisibility(0);
        this.f535b.f662i.mo3725a().removeAllViews();
        this.f535b.f662i.mo3725a().addView(view);
        if (this.f535b.f660g.mo3725a().mo3611b()) {
            this.f535b.f655b.mo3725a().mo3533a(this.f535b.f665l.mo3726a(), false, -1, -1, -1, -1);
            if (this.f535b.f658e.mo3725a().mo3427a()) {
                this.f535b.f662i.mo3725a().addView(this.f535b.f658e.mo3725a(), AdUtil.m437a(this.f535b.f659f.mo3725a(), this.f535b.f660g.mo3725a().mo3612c().getWidth()), AdUtil.m437a(this.f535b.f659f.mo3725a(), this.f535b.f660g.mo3725a().mo3612c().getHeight()));
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3523a(float f) {
        long j = this.f549p;
        this.f549p = (long) (1000.0f * f);
        if (mo3561t() && this.f549p != j) {
            mo3547f();
            mo3548g();
        }
    }

    /* renamed from: b */
    public synchronized void mo3539b(long j) {
        if (j > 0) {
            this.f548o.edit().putLong("GoogleAdMobDoritosLife", j).commit();
        }
    }

    /* renamed from: B */
    public synchronized void mo3517B() {
        C0282a.m472a(this.f535b.mo3684b());
        if (this.f544k) {
            this.f544k = false;
            if (this.f556w == null) {
                C0284b.m484b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
            } else if (!this.f556w.booleanValue()) {
                AdActivity.launchAdActivity(this, new C0248e("interstitial"));
                mo3566y();
            } else if (this.f558y.mo3393c()) {
                m277a(this.f559z, (Boolean) false);
            }
        } else {
            C0284b.m486c("Cannot show interstitial because it is not loaded and ready.");
        }
    }

    /* renamed from: C */
    public synchronized void mo3518C() {
        if (this.f536c != null) {
            this.f536c.mo3489a();
            this.f536c = null;
        }
        if (this.f539f != null) {
            this.f539f.stopLoading();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public synchronized void mo3519D() {
        Activity a = this.f535b.f656c.mo3728a();
        if (a == null) {
            C0284b.m490e("activity was null while trying to ping click tracking URLs.");
        } else {
            Iterator it = this.f554u.iterator();
            while (it.hasNext()) {
                new Thread(new C0170ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public synchronized void mo3520E() {
        this.f536c = null;
        this.f544k = true;
        this.f539f.setVisibility(0);
        if (this.f535b.mo3683a()) {
            mo3527a((View) this.f539f);
        }
        this.f538e.mo3588g();
        if (this.f535b.mo3683a()) {
            mo3566y();
        }
        C0284b.m486c("onReceiveAd()");
        AdListener a = this.f535b.f668o.mo3726a();
        if (a != null) {
            a.onReceiveAd(this.f535b.f654a.mo3725a());
        }
        this.f535b.f665l.mo3727a(this.f535b.f666m.mo3726a());
        this.f535b.f666m.mo3727a(null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3541b(String str) {
        C0284b.m480a("Adding a tracking URL: " + str);
        this.f552s.add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3544c(String str) {
        C0284b.m480a("Adding a manual tracking URL: " + str);
        mo3521F().add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3536a(LinkedList<String> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C0284b.m480a("Adding a click tracking URL: " + ((String) it.next()));
        }
        this.f554u = linkedList;
    }

    /* renamed from: b */
    public void mo3542b(boolean z) {
        this.f556w = Boolean.valueOf(z);
    }

    /* renamed from: a */
    public void mo3533a(C0264l lVar, boolean z, int i, int i2, int i3, int i4) {
        this.f535b.f658e.mo3725a().setOverlayActivated(!z);
        mo3525a(i, i2, i3, i4);
        if (this.f535b.f670q.mo3726a() == null) {
            return;
        }
        if (z) {
            this.f535b.f670q.mo3726a().onAdActivated(this.f535b.f654a.mo3725a());
        } else {
            this.f535b.f670q.mo3726a().onAdDeactivated(this.f535b.f654a.mo3725a());
        }
    }

    /* renamed from: a */
    public void mo3525a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        ActivationOverlay a = this.f535b.f658e.mo3725a();
        int a2 = AdUtil.m437a(this.f535b.f659f.mo3725a(), i3 < 0 ? this.f535b.f660g.mo3725a().mo3612c().getWidth() : i3);
        Context a3 = this.f535b.f659f.mo3725a();
        if (i4 < 0) {
            i4 = this.f535b.f660g.mo3725a().mo3612c().getHeight();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, AdUtil.m437a(a3, i4));
        if (i3 < 0) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = i2;
            i6 = i;
        }
        if (i6 < 0) {
            i7 = this.f535b.f658e.mo3725a().mo3432d();
        } else {
            i7 = i6;
        }
        if (i5 < 0) {
            i5 = this.f535b.f658e.mo3725a().mo3429c();
        }
        this.f535b.f658e.mo3725a().setXPosition(i7);
        this.f535b.f658e.mo3725a().setYPosition(i5);
        layoutParams.setMargins(AdUtil.m437a(this.f535b.f659f.mo3725a(), i7), AdUtil.m437a(this.f535b.f659f.mo3725a(), i5), 0, 0);
        a.setLayoutParams(layoutParams);
    }

    /* renamed from: F */
    public LinkedList<String> mo3521F() {
        return this.f553t;
    }
}
