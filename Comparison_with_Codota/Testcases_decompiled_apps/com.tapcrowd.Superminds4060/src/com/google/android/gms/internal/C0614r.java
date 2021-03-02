package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.dynamic.C0167c;
import com.google.android.gms.internal.C0202ac;
import com.google.android.gms.internal.C0300bp;
import com.google.android.gms.internal.C0313bu;

/* renamed from: com.google.android.gms.internal.r */
public final class C0614r extends C0202ac.C0203a implements C0212ag, C0230aq, C0286bi, C0291bl, C0300bp.C0301a, C0613q {

    /* renamed from: dZ */
    private final C0238aw f1557dZ;

    /* renamed from: ea */
    private final C0615a f1558ea;

    /* renamed from: eb */
    private final C0616s f1559eb = new C0616s(this);

    /* renamed from: com.google.android.gms.internal.r$a */
    private static final class C0615a {
        public final String adUnitId;

        /* renamed from: ec */
        public final ViewSwitcher f1560ec;

        /* renamed from: ed */
        public final C0622x f1561ed;

        /* renamed from: ee */
        public final Context f1562ee;

        /* renamed from: ef */
        public final C0599h f1563ef;

        /* renamed from: eg */
        public final C0345co f1564eg;

        /* renamed from: eh */
        public C0199ab f1565eh;

        /* renamed from: ei */
        public C0332cg f1566ei;

        /* renamed from: ej */
        public C0330ce f1567ej;

        /* renamed from: ek */
        public C0208ae f1568ek;

        public C0615a(Context context, C0622x xVar, String str, C0345co coVar) {
            if (xVar.f1582ex) {
                this.f1560ec = null;
            } else {
                this.f1560ec = new ViewSwitcher(context);
                this.f1560ec.setMinimumWidth(xVar.widthPixels);
                this.f1560ec.setMinimumHeight(xVar.heightPixels);
                this.f1560ec.setVisibility(4);
            }
            this.f1561ed = xVar;
            this.adUnitId = str;
            this.f1562ee = context;
            this.f1563ef = new C0599h(C0578g.m1809a(coVar.f1014hP, context));
            this.f1564eg = coVar;
        }
    }

    public C0614r(Context context, C0622x xVar, String str, C0238aw awVar, C0345co coVar) {
        this.f1558ea = new C0615a(context, xVar, str, coVar);
        this.f1557dZ = awVar;
        C0344cn.m735o("Use AdRequest.Builder.addTestDevice(\"" + C0343cm.m728l(context) + "\") to get test ads on this device.");
        C0337ci.m707i(context);
    }

    /* renamed from: I */
    private void m1919I() {
        C0344cn.m735o("Ad closing.");
        if (this.f1558ea.f1565eh != null) {
            try {
                this.f1558ea.f1565eh.onAdClosed();
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    /* renamed from: J */
    private void m1920J() {
        C0344cn.m735o("Ad leaving application.");
        if (this.f1558ea.f1565eh != null) {
            try {
                this.f1558ea.f1565eh.onAdLeftApplication();
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    /* renamed from: K */
    private void m1921K() {
        C0344cn.m735o("Ad opening.");
        if (this.f1558ea.f1565eh != null) {
            try {
                this.f1558ea.f1565eh.onAdOpened();
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    /* renamed from: L */
    private void m1922L() {
        C0344cn.m735o("Ad finished loading.");
        if (this.f1558ea.f1565eh != null) {
            try {
                this.f1558ea.f1565eh.onAdLoaded();
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    /* renamed from: M */
    private boolean m1923M() {
        boolean z = true;
        if (!C0337ci.m698a(this.f1558ea.f1562ee.getPackageManager(), this.f1558ea.f1562ee.getPackageName(), "android.permission.INTERNET")) {
            if (!this.f1558ea.f1561ed.f1582ex) {
                C0343cm.m723a(this.f1558ea.f1560ec, this.f1558ea.f1561ed, "Missing internet permission in AndroidManifest.xml.");
            }
            z = false;
        }
        if (!C0337ci.m705h(this.f1558ea.f1562ee)) {
            if (!this.f1558ea.f1561ed.f1582ex) {
                C0343cm.m723a(this.f1558ea.f1560ec, this.f1558ea.f1561ed, "Missing AdActivity with android:configChanges in AndroidManifest.xml.");
            }
            z = false;
        }
        if (!z) {
            this.f1558ea.f1560ec.setVisibility(0);
        }
        return z;
    }

    /* renamed from: N */
    private void m1924N() {
        if (this.f1558ea.f1567ej == null) {
            C0344cn.m737q("Ad state was null when trying to ping click URLs.");
            return;
        }
        C0344cn.m733m("Pinging click URLs.");
        if (this.f1558ea.f1567ej.f981eW != null) {
            C0337ci.m693a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, this.f1558ea.f1567ej.f981eW);
        }
        if (this.f1558ea.f1567ej.f995hA != null && this.f1558ea.f1567ej.f995hA.f587eW != null) {
            C0236au.m521a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, this.f1558ea.f1567ej, this.f1558ea.adUnitId, false, this.f1558ea.f1567ej.f995hA.f587eW);
        }
    }

    /* renamed from: O */
    private void m1925O() {
        if (this.f1558ea.f1567ej != null) {
            this.f1558ea.f1567ej.f983fU.destroy();
            this.f1558ea.f1567ej = null;
        }
    }

    /* renamed from: a */
    private void m1926a(int i) {
        C0344cn.m737q("Failed to load ad: " + i);
        if (this.f1558ea.f1565eh != null) {
            try {
                this.f1558ea.f1565eh.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    /* renamed from: b */
    private void m1927b(View view) {
        this.f1558ea.f1560ec.addView(view, new ViewGroup.LayoutParams(-2, -2));
    }

    /* renamed from: b */
    private void m1928b(boolean z) {
        if (this.f1558ea.f1567ej == null) {
            C0344cn.m737q("Ad state was null when trying to ping impression URLs.");
            return;
        }
        C0344cn.m733m("Pinging Impression URLs.");
        if (this.f1558ea.f1567ej.f982eX != null) {
            C0337ci.m693a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, this.f1558ea.f1567ej.f982eX);
        }
        if (!(this.f1558ea.f1567ej.f995hA == null || this.f1558ea.f1567ej.f995hA.f588eX == null)) {
            C0236au.m521a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, this.f1558ea.f1567ej, this.f1558ea.adUnitId, z, this.f1558ea.f1567ej.f995hA.f588eX);
        }
        if (this.f1558ea.f1567ej.f985fm != null && this.f1558ea.f1567ej.f985fm.f584eT != null) {
            C0236au.m521a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, this.f1558ea.f1567ej, this.f1558ea.adUnitId, z, this.f1558ea.f1567ej.f985fm.f584eT);
        }
    }

    /* renamed from: b */
    private boolean m1929b(C0330ce ceVar) {
        if (ceVar.f992gI) {
            try {
                View view = (View) C0167c.m378b(ceVar.f986fn.getView());
                View nextView = this.f1558ea.f1560ec.getNextView();
                if (nextView != null) {
                    this.f1558ea.f1560ec.removeView(nextView);
                }
                try {
                    m1927b(view);
                } catch (Throwable th) {
                    C0344cn.m731b("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (RemoteException e) {
                C0344cn.m731b("Could not get View from mediation adapter.", e);
                return false;
            }
        }
        if (this.f1558ea.f1560ec.getChildCount() > 1) {
            this.f1558ea.f1560ec.showNext();
        }
        if (this.f1558ea.f1567ej != null) {
            View nextView2 = this.f1558ea.f1560ec.getNextView();
            if (nextView2 instanceof C0347cq) {
                ((C0347cq) nextView2).mo4205a(this.f1558ea.f1562ee, this.f1558ea.f1561ed);
            } else if (nextView2 != null) {
                this.f1558ea.f1560ec.removeView(nextView2);
            }
            if (this.f1558ea.f1567ej.f986fn != null) {
                try {
                    this.f1558ea.f1567ej.f986fn.destroy();
                } catch (RemoteException e2) {
                    C0344cn.m737q("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.f1558ea.f1560ec.setVisibility(0);
        return true;
    }

    /* renamed from: c */
    private C0313bu.C0314a m1930c(C0620v vVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.f1558ea.f1562ee.getApplicationInfo();
        try {
            packageInfo = this.f1558ea.f1562ee.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.f1558ea.f1561ed.f1582ex || this.f1558ea.f1560ec.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.f1558ea.f1560ec.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.f1558ea.f1562ee.getResources().getDisplayMetrics();
            int width = this.f1558ea.f1560ec.getWidth();
            int height = this.f1558ea.f1560ec.getHeight();
            int i3 = (!this.f1558ea.f1560ec.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        return new C0313bu.C0314a(bundle, vVar, this.f1558ea.f1561ed, this.f1558ea.adUnitId, applicationInfo, packageInfo, C0331cf.m685al(), C0331cf.f997hB, this.f1558ea.f1564eg);
    }

    /* renamed from: A */
    public void mo4145A() {
        m1920J();
    }

    /* renamed from: B */
    public void mo4126B() {
        if (this.f1558ea.f1561ed.f1582ex) {
            m1925O();
        }
        m1919I();
    }

    /* renamed from: C */
    public void mo4127C() {
        if (this.f1558ea.f1561ed.f1582ex) {
            m1928b(false);
        }
        m1921K();
    }

    /* renamed from: D */
    public void mo4044D() {
        mo5320y();
    }

    /* renamed from: E */
    public void mo4045E() {
        mo4126B();
    }

    /* renamed from: F */
    public void mo4046F() {
        mo4145A();
    }

    /* renamed from: G */
    public void mo4047G() {
        mo4127C();
    }

    /* renamed from: H */
    public void mo4048H() {
        if (this.f1558ea.f1567ej != null) {
            C0344cn.m737q("Mediation adapter " + this.f1558ea.f1567ej.f987fo + " refreshed, but mediation adapters should never refresh.");
        }
        m1928b(true);
        m1922L();
    }

    /* renamed from: a */
    public void mo4017a(C0199ab abVar) {
        C0411dm.m947w("setAdListener must be called on the main UI thread.");
        this.f1558ea.f1565eh = abVar;
    }

    /* renamed from: a */
    public void mo4018a(C0208ae aeVar) {
        C0411dm.m947w("setAppEventListener must be called on the main UI thread.");
        this.f1558ea.f1568ek = aeVar;
    }

    /* renamed from: a */
    public void mo4153a(C0330ce ceVar) {
        this.f1558ea.f1566ei = null;
        if (ceVar.errorCode != -1) {
            boolean z = ceVar.f989gB.extras != null ? ceVar.f989gB.extras.getBoolean("_noRefresh", false) : false;
            if (this.f1558ea.f1561ed.f1582ex) {
                C0337ci.m695a((WebView) ceVar.f983fU);
            } else if (!z) {
                if (ceVar.f984fa > 0) {
                    this.f1559eb.mo5322a(ceVar.f989gB, ceVar.f984fa);
                } else if (ceVar.f995hA != null && ceVar.f995hA.f591fa > 0) {
                    this.f1559eb.mo5322a(ceVar.f989gB, ceVar.f995hA.f591fa);
                } else if (!ceVar.f992gI && ceVar.errorCode == 2) {
                    this.f1559eb.mo5324d(ceVar.f989gB);
                }
            }
            if (!(ceVar.errorCode != 3 || ceVar.f995hA == null || ceVar.f995hA.f589eY == null)) {
                C0344cn.m733m("Pinging no fill URLs.");
                C0236au.m521a(this.f1558ea.f1562ee, this.f1558ea.f1564eg.f1014hP, ceVar, this.f1558ea.adUnitId, false, ceVar.f995hA.f589eY);
            }
            if (ceVar.errorCode != -2) {
                m1926a(ceVar.errorCode);
            } else if (this.f1558ea.f1561ed.f1582ex || m1929b(ceVar)) {
                if (!(this.f1558ea.f1567ej == null || this.f1558ea.f1567ej.f988fp == null)) {
                    this.f1558ea.f1567ej.f988fp.mo4049a((C0230aq) null);
                }
                if (ceVar.f988fp != null) {
                    ceVar.f988fp.mo4049a((C0230aq) this);
                }
                this.f1558ea.f1567ej = ceVar;
                if (!this.f1558ea.f1561ed.f1582ex) {
                    m1928b(false);
                }
                m1922L();
            } else {
                m1926a(0);
            }
        }
    }

    /* renamed from: a */
    public void mo4038a(String str, String str2) {
        if (this.f1558ea.f1568ek != null) {
            try {
                this.f1558ea.f1568ek.mo4033a(str, str2);
            } catch (RemoteException e) {
                C0344cn.m731b("Could not call the AppEventListener.", e);
            }
        }
    }

    /* renamed from: a */
    public boolean mo4019a(C0620v vVar) {
        C0347cq a;
        C0347cq cqVar;
        C0411dm.m947w("loadAd must be called on the main UI thread.");
        if (this.f1558ea.f1566ei != null) {
            C0344cn.m737q("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.f1558ea.f1561ed.f1582ex && this.f1558ea.f1567ej != null) {
            C0344cn.m737q("An interstitial is already loading. Aborting.");
            return false;
        } else if (!m1923M()) {
            return false;
        } else {
            C0344cn.m735o("Starting ad request.");
            this.f1559eb.cancel();
            C0313bu.C0314a c = m1930c(vVar);
            if (this.f1558ea.f1561ed.f1582ex) {
                C0347cq a2 = C0347cq.m741a(this.f1558ea.f1562ee, this.f1558ea.f1561ed, false, false, this.f1558ea.f1563ef, this.f1558ea.f1564eg);
                a2.mo4212aw().mo4224a(this, (C0286bi) null, this, this, true);
                cqVar = a2;
            } else {
                View nextView = this.f1558ea.f1560ec.getNextView();
                if (nextView instanceof C0347cq) {
                    a = (C0347cq) nextView;
                    a.mo4205a(this.f1558ea.f1562ee, this.f1558ea.f1561ed);
                } else {
                    if (nextView != null) {
                        this.f1558ea.f1560ec.removeView(nextView);
                    }
                    a = C0347cq.m741a(this.f1558ea.f1562ee, this.f1558ea.f1561ed, false, false, this.f1558ea.f1563ef, this.f1558ea.f1564eg);
                    m1927b((View) a);
                }
                a.mo4212aw().mo4224a(this, this, this, this, false);
                cqVar = a;
            }
            this.f1558ea.f1566ei = C0300bp.m611a(this.f1558ea.f1562ee, c, this.f1558ea.f1563ef, cqVar, this.f1557dZ, this);
            return true;
        }
    }

    /* renamed from: b */
    public void mo5321b(C0620v vVar) {
        ViewParent parent = this.f1558ea.f1560ec.getParent();
        if (!(parent instanceof View) || !((View) parent).isShown() || !C0337ci.m699am()) {
            C0344cn.m735o("Ad is not visible. Not refreshing ad.");
            this.f1559eb.mo5324d(vVar);
            return;
        }
        mo4019a(vVar);
    }

    public void destroy() {
        C0411dm.m947w("destroy must be called on the main UI thread.");
        this.f1558ea.f1565eh = null;
        this.f1558ea.f1568ek = null;
        this.f1559eb.cancel();
        stopLoading();
        if (this.f1558ea.f1560ec != null) {
            this.f1558ea.f1560ec.removeAllViews();
        }
        if (this.f1558ea.f1567ej != null && this.f1558ea.f1567ej.f983fU != null) {
            this.f1558ea.f1567ej.f983fU.destroy();
        }
    }

    public boolean isReady() {
        C0411dm.m947w("isReady must be called on the main UI thread.");
        return this.f1558ea.f1566ei == null && this.f1558ea.f1567ej != null;
    }

    public void pause() {
        C0411dm.m947w("pause must be called on the main UI thread.");
        if (this.f1558ea.f1567ej != null) {
            C0337ci.m695a((WebView) this.f1558ea.f1567ej.f983fU);
        }
    }

    public void resume() {
        C0411dm.m947w("resume must be called on the main UI thread.");
        if (this.f1558ea.f1567ej != null) {
            C0337ci.m704b(this.f1558ea.f1567ej.f983fU);
        }
    }

    public void showInterstitial() {
        C0411dm.m947w("showInterstitial must be called on the main UI thread.");
        if (!this.f1558ea.f1561ed.f1582ex) {
            C0344cn.m737q("Cannot call showInterstitial on a banner ad.");
        } else if (this.f1558ea.f1567ej == null) {
            C0344cn.m737q("The interstitial has not loaded.");
        } else if (this.f1558ea.f1567ej.f983fU.mo4215az()) {
            C0344cn.m737q("The interstitial is already showing.");
        } else {
            this.f1558ea.f1567ej.f983fU.mo4216i(true);
            if (this.f1558ea.f1567ej.f992gI) {
                try {
                    this.f1558ea.f1567ej.f986fn.showInterstitial();
                } catch (RemoteException e) {
                    C0344cn.m731b("Could not show interstitial.", e);
                    m1925O();
                }
            } else {
                C0280bf.m566a(this.f1558ea.f1562ee, new C0285bh(this, this, this, this.f1558ea.f1567ej.f983fU, this.f1558ea.f1567ej.orientation, this.f1558ea.f1564eg));
            }
        }
    }

    public void stopLoading() {
        C0411dm.m947w("stopLoading must be called on the main UI thread.");
        if (this.f1558ea.f1567ej != null) {
            this.f1558ea.f1567ej.f983fU.stopLoading();
            this.f1558ea.f1567ej = null;
        }
        if (this.f1558ea.f1566ei != null) {
            this.f1558ea.f1566ei.cancel();
        }
    }

    /* renamed from: y */
    public void mo5320y() {
        m1924N();
    }

    /* renamed from: z */
    public C0164b mo4026z() {
        C0411dm.m947w("getAdFrame must be called on the main UI thread.");
        return C0167c.m379g(this.f1558ea.f1560ec);
    }
}
