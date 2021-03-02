package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0221g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;

public class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f644a;

    /* renamed from: b */
    private CustomEventBanner f645b = null;

    /* renamed from: c */
    private C0270a f646c = null;

    /* renamed from: d */
    private CustomEventInterstitial f647d = null;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private class C0270a implements CustomEventBannerListener {

        /* renamed from: b */
        private View f649b;

        /* renamed from: c */
        private final MediationBannerListener f650c;

        public C0270a(MediationBannerListener mediationBannerListener) {
            this.f650c = mediationBannerListener;
        }

        public synchronized void onReceivedAd(View view) {
            C0284b.m480a(m423b() + " called onReceivedAd.");
            this.f649b = view;
            this.f650c.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0284b.m480a(m423b() + " called onFailedToReceiveAd().");
            this.f650c.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onClick() {
            C0284b.m480a(m423b() + " called onClick().");
            this.f650c.onClick(CustomEventAdapter.this);
        }

        public void onPresentScreen() {
            C0284b.m480a(m423b() + " called onPresentScreen().");
            this.f650c.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0284b.m480a(m423b() + " called onDismissScreen().");
            this.f650c.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0284b.m480a(m423b() + " called onLeaveApplication().");
            this.f650c.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        public synchronized View mo3668a() {
            return this.f649b;
        }

        /* renamed from: b */
        private String m423b() {
            return "Banner custom event labeled '" + CustomEventAdapter.this.f644a + "'";
        }
    }

    public void requestBannerAd(MediationBannerListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0282a.m469a((Object) this.f644a);
        this.f644a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f645b = (CustomEventBanner) m420a(str, CustomEventBanner.class, this.f644a);
        if (this.f645b == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        C0282a.m469a((Object) this.f646c);
        this.f646c = new C0270a(mediationListener);
        try {
            this.f645b.requestBannerAd(this.f646c, activity, this.f644a, str2, adSize, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f644a));
        } catch (Throwable th) {
            m422a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public View getBannerView() {
        C0282a.m474b((Object) this.f646c);
        return this.f646c.mo3668a();
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0271b implements CustomEventInterstitialListener {

        /* renamed from: b */
        private final MediationInterstitialListener f652b;

        public C0271b(MediationInterstitialListener mediationInterstitialListener) {
            this.f652b = mediationInterstitialListener;
        }

        public void onReceivedAd() {
            C0284b.m480a(m425a() + " called onReceivedAd.");
            this.f652b.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0284b.m480a(m425a() + " called onFailedToReceiveAd().");
            this.f652b.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onPresentScreen() {
            C0284b.m480a(m425a() + " called onPresentScreen().");
            this.f652b.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0284b.m480a(m425a() + " called onDismissScreen().");
            this.f652b.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0284b.m480a(m425a() + " called onLeaveApplication().");
            this.f652b.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        private String m425a() {
            return "Interstitial custom event labeled '" + CustomEventAdapter.this.f644a + "'";
        }
    }

    public void showInterstitial() {
        C0282a.m474b((Object) this.f647d);
        try {
            this.f647d.showInterstitial();
        } catch (Throwable th) {
            C0284b.m485b("Exception when showing custom event labeled '" + this.f644a + "'.", th);
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0282a.m469a((Object) this.f644a);
        this.f644a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f647d = (CustomEventInterstitial) m420a(str, CustomEventInterstitial.class, this.f644a);
        if (this.f647d == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        try {
            this.f647d.requestInterstitialAd(new C0271b(mediationListener), activity, this.f644a, str2, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f644a));
        } catch (Throwable th) {
            m422a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void destroy() {
        if (this.f645b != null) {
            this.f645b.destroy();
        }
        if (this.f647d != null) {
            this.f647d.destroy();
        }
    }

    /* renamed from: a */
    private void m422a(String str, Throwable th) {
        C0284b.m485b("Error during processing of custom event with label: '" + this.f644a + "'. Skipping custom event. " + str, th);
    }

    /* renamed from: a */
    private <T> T m420a(String str, Class<T> cls, String str2) {
        try {
            return C0221g.m181a(str, cls);
        } catch (ClassNotFoundException e) {
            m422a("Make sure you created a visible class named: " + str + ". ", e);
        } catch (ClassCastException e2) {
            m422a("Make sure your custom event implements the " + cls.getName() + " interface.", e2);
        } catch (IllegalAccessException e3) {
            m422a("Make sure the default constructor for class " + str + " is visible. ", e3);
        } catch (InstantiationException e4) {
            m422a("Make sure the name " + str + " does not denote an abstract class or an interface.", e4);
        } catch (Throwable th) {
            m422a("", th);
        }
        return null;
    }
}
