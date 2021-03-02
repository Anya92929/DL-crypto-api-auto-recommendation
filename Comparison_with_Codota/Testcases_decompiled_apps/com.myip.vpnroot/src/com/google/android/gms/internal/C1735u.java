package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;
import com.google.android.gms.internal.C0935bd;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C1146fa;
import com.google.android.gms.internal.C1154fd;
import com.google.android.gms.internal.C1168fi;
import com.google.android.gms.internal.C1196fz;
import com.google.android.gms.internal.C1741v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.u */
public class C1735u extends C0935bd.C0936a implements C0881aa, C0964bw, C0975bz, C0988cb, C1005cn, C1063dn, C1068dq, C1146fa.C1147a, C1154fd.C1155a, C1203gd, C1734t {

    /* renamed from: lp */
    private C0924av f4361lp;

    /* renamed from: lq */
    private final C1013ct f4362lq;
    /* access modifiers changed from: private */

    /* renamed from: lr */
    public final C1740b f4363lr;

    /* renamed from: ls */
    private final C0882ab f4364ls;

    /* renamed from: lt */
    private final C0887ae f4365lt;

    /* renamed from: lu */
    private boolean f4366lu;

    /* renamed from: lv */
    private final ComponentCallbacks f4367lv;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.u$a */
    private static final class C1739a extends ViewSwitcher {
        /* access modifiers changed from: private */

        /* renamed from: ly */
        public final C1218gm f4373ly;

        public C1739a(Context context) {
            super(context);
            this.f4373ly = new C1218gm(context);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.f4373ly.mo8604c(event);
            return false;
        }
    }

    @C1130ez
    /* renamed from: com.google.android.gms.internal.u$b */
    static class C1740b {

        /* renamed from: lA */
        public final String f4374lA;

        /* renamed from: lB */
        public final Context f4375lB;

        /* renamed from: lC */
        public final C1391k f4376lC;

        /* renamed from: lD */
        public final C1230gt f4377lD;

        /* renamed from: lE */
        public C0932bc f4378lE;

        /* renamed from: lF */
        public C1206gg f4379lF;

        /* renamed from: lG */
        public C1206gg f4380lG;

        /* renamed from: lH */
        public C0927ay f4381lH;

        /* renamed from: lI */
        public C1196fz f4382lI;

        /* renamed from: lJ */
        public C1196fz.C1197a f4383lJ;

        /* renamed from: lK */
        public C1199ga f4384lK;

        /* renamed from: lL */
        public C0941bf f4385lL;

        /* renamed from: lM */
        public C1107el f4386lM;

        /* renamed from: lN */
        public C1095eh f4387lN;

        /* renamed from: lO */
        public C1120et f4388lO;

        /* renamed from: lP */
        public C1123eu f4389lP;

        /* renamed from: lQ */
        public C0961bt f4390lQ;

        /* renamed from: lR */
        public C0962bu f4391lR;

        /* renamed from: lS */
        public List<String> f4392lS;

        /* renamed from: lT */
        public C1090ee f4393lT;

        /* renamed from: lU */
        public C1204ge f4394lU = null;

        /* renamed from: lV */
        public View f4395lV = null;

        /* renamed from: lW */
        public int f4396lW = 0;

        /* renamed from: lX */
        public boolean f4397lX = false;

        /* renamed from: lY */
        private HashSet<C1199ga> f4398lY = null;

        /* renamed from: lz */
        public final C1739a f4399lz;

        public C1740b(Context context, C0927ay ayVar, String str, C1230gt gtVar) {
            if (ayVar.f2623og) {
                this.f4399lz = null;
            } else {
                this.f4399lz = new C1739a(context);
                this.f4399lz.setMinimumWidth(ayVar.widthPixels);
                this.f4399lz.setMinimumHeight(ayVar.heightPixels);
                this.f4399lz.setVisibility(4);
            }
            this.f4381lH = ayVar;
            this.f4374lA = str;
            this.f4375lB = context;
            this.f4377lD = gtVar;
            this.f4376lC = new C1391k(new C1744w(this));
        }

        /* renamed from: a */
        public void mo10150a(HashSet<C1199ga> hashSet) {
            this.f4398lY = hashSet;
        }

        /* renamed from: au */
        public HashSet<C1199ga> mo10151au() {
            return this.f4398lY;
        }
    }

    public C1735u(Context context, C0927ay ayVar, String str, C1013ct ctVar, C1230gt gtVar) {
        this(new C1740b(context, ayVar, str, gtVar), ctVar, (C0882ab) null);
    }

    C1735u(C1740b bVar, C1013ct ctVar, C0882ab abVar) {
        this.f4367lv = new ComponentCallbacks() {
            public void onConfigurationChanged(Configuration newConfig) {
                if (C1735u.this.f4363lr != null && C1735u.this.f4363lr.f4382lI != null && C1735u.this.f4363lr.f4382lI.f3672rN != null) {
                    C1735u.this.f4363lr.f4382lI.f3672rN.mo8625bT();
                }
            }

            public void onLowMemory() {
            }
        };
        this.f4363lr = bVar;
        this.f4362lq = ctVar;
        this.f4364ls = abVar == null ? new C0882ab(this) : abVar;
        this.f4365lt = new C0887ae();
        C1213gj.m4639q(this.f4363lr.f4375lB);
        C1201gb.m4559a(this.f4363lr.f4375lB, this.f4363lr.f4377lD);
        m6164Z();
    }

    /* renamed from: Z */
    private void m6164Z() {
        if (Build.VERSION.SDK_INT >= 14 && this.f4363lr != null && this.f4363lr.f4375lB != null) {
            this.f4363lr.f4375lB.registerComponentCallbacks(this.f4367lv);
        }
    }

    /* renamed from: a */
    private C1168fi.C1169a m6165a(C0924av avVar, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.f4363lr.f4375lB.getApplicationInfo();
        try {
            packageInfo = this.f4363lr.f4375lB.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        Bundle bundle2 = null;
        if (!this.f4363lr.f4381lH.f2623og && this.f4363lr.f4399lz.getParent() != null) {
            int[] iArr = new int[2];
            this.f4363lr.f4399lz.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.f4363lr.f4375lB.getResources().getDisplayMetrics();
            int width = this.f4363lr.f4399lz.getWidth();
            int height = this.f4363lr.f4399lz.getHeight();
            int i3 = 0;
            if (this.f4363lr.f4399lz.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String cX = C1201gb.m4565cX();
        this.f4363lr.f4384lK = new C1199ga(cX, this.f4363lr.f4374lA);
        this.f4363lr.f4384lK.mo8547e(avVar);
        return new C1168fi.C1169a(bundle2, avVar, this.f4363lr.f4381lH, this.f4363lr.f4374lA, applicationInfo, packageInfo, cX, C1201gb.f3708vK, this.f4363lr.f4377lD, C1201gb.m4558a(this.f4363lr.f4375lB, this, cX), this.f4363lr.f4392lS, bundle, C1201gb.m4568dd());
    }

    /* renamed from: a */
    private C1232gv m6166a(C1741v vVar) {
        C1232gv a;
        if (this.f4363lr.f4381lH.f2623og) {
            C1232gv a2 = C1232gv.m4688a(this.f4363lr.f4375lB, this.f4363lr.f4381lH, false, false, this.f4363lr.f4376lC, this.f4363lr.f4377lD);
            a2.mo8631dv().mo8650a(this, (C1063dn) null, this, this, true, this, this, vVar);
            return a2;
        }
        View nextView = this.f4363lr.f4399lz.getNextView();
        if (nextView instanceof C1232gv) {
            a = (C1232gv) nextView;
            a.mo8619a(this.f4363lr.f4375lB, this.f4363lr.f4381lH);
        } else {
            if (nextView != null) {
                this.f4363lr.f4399lz.removeView(nextView);
            }
            a = C1232gv.m4688a(this.f4363lr.f4375lB, this.f4363lr.f4381lH, false, false, this.f4363lr.f4376lC, this.f4363lr.f4377lD);
            if (this.f4363lr.f4381lH.f2624oh == null) {
                m6178c((View) a);
            }
        }
        a.mo8631dv().mo8651a(this, this, this, this, false, this, vVar);
        return a;
    }

    /* renamed from: a */
    private void m6168a(int i) {
        C1229gs.m4679W("Failed to load ad: " + i);
        if (this.f4363lr.f4378lE != null) {
            try {
                this.f4363lr.f4378lE.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    /* renamed from: aa */
    private void m6169aa() {
        if (Build.VERSION.SDK_INT >= 14 && this.f4363lr != null && this.f4363lr.f4375lB != null) {
            this.f4363lr.f4375lB.unregisterComponentCallbacks(this.f4367lv);
        }
    }

    /* renamed from: ak */
    private void m6170ak() {
        C1229gs.m4677U("Ad closing.");
        if (this.f4363lr.f4378lE != null) {
            try {
                this.f4363lr.f4378lE.onAdClosed();
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    /* renamed from: al */
    private void m6171al() {
        C1229gs.m4677U("Ad leaving application.");
        if (this.f4363lr.f4378lE != null) {
            try {
                this.f4363lr.f4378lE.onAdLeftApplication();
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    /* renamed from: am */
    private void m6172am() {
        C1229gs.m4677U("Ad opening.");
        if (this.f4363lr.f4378lE != null) {
            try {
                this.f4363lr.f4378lE.onAdOpened();
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    /* renamed from: an */
    private void m6173an() {
        C1229gs.m4677U("Ad finished loading.");
        if (this.f4363lr.f4378lE != null) {
            try {
                this.f4363lr.f4378lE.onAdLoaded();
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    /* renamed from: ao */
    private void m6174ao() {
        try {
            if ((this.f4363lr.f4382lI.f3685vu instanceof C0953bo) && this.f4363lr.f4390lQ != null) {
                this.f4363lr.f4390lQ.mo8162a((C0953bo) this.f4363lr.f4382lI.f3685vu);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }

    /* renamed from: ap */
    private void m6175ap() {
        try {
            if ((this.f4363lr.f4382lI.f3685vu instanceof C0954bp) && this.f4363lr.f4391lR != null) {
                this.f4363lr.f4391lR.mo8163a((C0954bp) this.f4363lr.f4382lI.f3685vu);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }

    /* renamed from: at */
    private void m6176at() {
        if (this.f4363lr.f4382lI != null) {
            if (this.f4363lr.f4396lW == 0) {
                this.f4363lr.f4382lI.f3672rN.destroy();
            }
            this.f4363lr.f4382lI = null;
            this.f4363lr.f4397lX = false;
        }
    }

    /* renamed from: b */
    private boolean m6177b(C1196fz fzVar) {
        if (fzVar.f3675tI) {
            try {
                View view = (View) C0597e.m1742f(fzVar.f3671qz.getView());
                View nextView = this.f4363lr.f4399lz.getNextView();
                if (nextView != null) {
                    this.f4363lr.f4399lz.removeView(nextView);
                }
                try {
                    m6178c(view);
                } catch (Throwable th) {
                    C1229gs.m4683d("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not get View from mediation adapter.", e);
                return false;
            }
        } else if (fzVar.f3682vr != null) {
            fzVar.f3672rN.mo8620a(fzVar.f3682vr);
            this.f4363lr.f4399lz.removeAllViews();
            this.f4363lr.f4399lz.setMinimumWidth(fzVar.f3682vr.widthPixels);
            this.f4363lr.f4399lz.setMinimumHeight(fzVar.f3682vr.heightPixels);
            m6178c((View) fzVar.f3672rN);
        }
        if (this.f4363lr.f4399lz.getChildCount() > 1) {
            this.f4363lr.f4399lz.showNext();
        }
        if (this.f4363lr.f4382lI != null) {
            View nextView2 = this.f4363lr.f4399lz.getNextView();
            if (nextView2 instanceof C1232gv) {
                ((C1232gv) nextView2).mo8619a(this.f4363lr.f4375lB, this.f4363lr.f4381lH);
            } else if (nextView2 != null) {
                this.f4363lr.f4399lz.removeView(nextView2);
            }
            if (this.f4363lr.f4382lI.f3671qz != null) {
                try {
                    this.f4363lr.f4382lI.f3671qz.destroy();
                } catch (RemoteException e2) {
                    C1229gs.m4679W("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.f4363lr.f4399lz.setVisibility(0);
        return true;
    }

    /* renamed from: c */
    private void m6178c(View view) {
        this.f4363lr.f4399lz.addView(view, new ViewGroup.LayoutParams(-2, -2));
    }

    /* renamed from: c */
    private void m6179c(boolean z) {
        if (this.f4363lr.f4382lI == null) {
            C1229gs.m4679W("Ad state was null when trying to ping impression URLs.");
            return;
        }
        C1229gs.m4675S("Pinging Impression URLs.");
        this.f4363lr.f4384lK.mo8544cP();
        if (this.f4363lr.f4382lI.f3668qg != null) {
            C1213gj.m4617a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI.f3668qg);
        }
        if (!(this.f4363lr.f4382lI.f3681vq == null || this.f4363lr.f4382lI.f3681vq.f3037qg == null)) {
            C1011cr.m4151a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI, this.f4363lr.f4374lA, z, this.f4363lr.f4382lI.f3681vq.f3037qg);
        }
        if (this.f4363lr.f4382lI.f3670qy != null && this.f4363lr.f4382lI.f3670qy.f3032qb != null) {
            C1011cr.m4151a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI, this.f4363lr.f4374lA, z, this.f4363lr.f4382lI.f3670qy.f3032qb);
        }
    }

    /* renamed from: X */
    public C0594d mo8036X() {
        C0348n.m854aT("getAdFrame must be called on the main UI thread.");
        return C0597e.m1743k(this.f4363lr.f4399lz);
    }

    /* renamed from: Y */
    public C0927ay mo8037Y() {
        C0348n.m854aT("getAdSize must be called on the main UI thread.");
        return this.f4363lr.f4381lH;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo10140a(C0909an anVar) {
        String str;
        if (anVar == null) {
            return null;
        }
        if (anVar.mo7991aZ()) {
            anVar.wakeup();
        }
        C0906ak aX = anVar.mo7989aX();
        if (aX != null) {
            str = aX.mo7960aO();
            C1229gs.m4675S("In AdManger: loadAd, " + aX.toString());
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", str);
        return bundle;
    }

    /* renamed from: a */
    public void mo8038a(C0927ay ayVar) {
        C0348n.m854aT("setAdSize must be called on the main UI thread.");
        this.f4363lr.f4381lH = ayVar;
        if (this.f4363lr.f4382lI != null && this.f4363lr.f4396lW == 0) {
            this.f4363lr.f4382lI.f3672rN.mo8620a(ayVar);
        }
        if (this.f4363lr.f4399lz.getChildCount() > 1) {
            this.f4363lr.f4399lz.removeView(this.f4363lr.f4399lz.getNextView());
        }
        this.f4363lr.f4399lz.setMinimumWidth(ayVar.widthPixels);
        this.f4363lr.f4399lz.setMinimumHeight(ayVar.heightPixels);
        this.f4363lr.f4399lz.requestLayout();
    }

    /* renamed from: a */
    public void mo8039a(C0932bc bcVar) {
        C0348n.m854aT("setAdListener must be called on the main UI thread.");
        this.f4363lr.f4378lE = bcVar;
    }

    /* renamed from: a */
    public void mo8040a(C0941bf bfVar) {
        C0348n.m854aT("setAppEventListener must be called on the main UI thread.");
        this.f4363lr.f4385lL = bfVar;
    }

    /* renamed from: a */
    public void mo8041a(C1095eh ehVar) {
        C0348n.m854aT("setInAppPurchaseListener must be called on the main UI thread.");
        this.f4363lr.f4387lN = ehVar;
    }

    /* renamed from: a */
    public void mo8042a(C1107el elVar, String str) {
        C0348n.m854aT("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f4363lr.f4393lT = new C1090ee(str);
        this.f4363lr.f4386lM = elVar;
        if (!C1201gb.m4567db() && elVar != null) {
            new C1080dx(this.f4363lr.f4375lB, this.f4363lr.f4386lM, this.f4363lr.f4393lT).start();
        }
    }

    /* renamed from: a */
    public void mo8043a(C1120et etVar) {
        C0348n.m854aT("setRawHtmlPublisherAdViewListener must be called on the main UI thread.");
        this.f4363lr.f4388lO = etVar;
    }

    /* renamed from: a */
    public void mo8044a(C1123eu euVar) {
        C0348n.m854aT("setRawHtmlPublisherInterstitialAdListener must be called on the main UI thread.");
        this.f4363lr.f4389lP = euVar;
    }

    /* renamed from: a */
    public void mo8467a(C1196fz.C1197a aVar) {
        C1232gv gvVar;
        String str = null;
        this.f4363lr.f4379lF = null;
        this.f4363lr.f4383lJ = aVar;
        mo10141a((List<String>) null);
        if (!aVar.f3692vw.f3572tS) {
            final C1741v vVar = new C1741v();
            gvVar = m6166a(vVar);
            vVar.mo10152a(new C1741v.C1743b(aVar, gvVar));
            gvVar.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    vVar.mo10153ar();
                    return false;
                }
            });
            gvVar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    vVar.mo10153ar();
                }
            });
        } else {
            gvVar = null;
        }
        if (aVar.f3686lH != null) {
            this.f4363lr.f4381lH = aVar.f3686lH;
        }
        if (aVar.errorCode != -2) {
            mo8484a(new C1196fz(aVar, gvVar, (C1003cl) null, (C1016cu) null, (String) null, (C1006co) null, (C0955bq.C0956a) null));
            return;
        }
        if (!aVar.f3692vw.f3562tI && aVar.f3692vw.f3571tR) {
            if (aVar.f3692vw.f3558rP != null) {
                str = Uri.parse(aVar.f3692vw.f3558rP).buildUpon().query((String) null).build().toString();
            }
            C1116er erVar = new C1116er(this, str, aVar.f3692vw.f3560tG);
            try {
                if (this.f4363lr.f4388lO != null && !this.f4363lr.f4381lH.f2623og && this.f4363lr.f4388lO.mo8450e(str, aVar.f3692vw.f3560tG)) {
                    this.f4363lr.f4396lW = 1;
                    this.f4363lr.f4388lO.mo8449a(erVar);
                    return;
                }
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call the rawHtmlPublisherAdViewListener.", e);
            }
            try {
                if (this.f4363lr.f4389lP != null && this.f4363lr.f4381lH.f2623og && this.f4363lr.f4389lP.mo8455e(str, aVar.f3692vw.f3560tG)) {
                    this.f4363lr.f4396lW = 1;
                    this.f4363lr.f4389lP.mo8454a(erVar);
                    return;
                }
            } catch (RemoteException e2) {
                C1229gs.m4683d("Could not call the RawHtmlPublisherInterstitialAdListener.", e2);
            }
        }
        this.f4363lr.f4396lW = 0;
        this.f4363lr.f4380lG = C1154fd.m4429a(this.f4363lr.f4375lB, this, aVar, gvVar, this.f4362lq, this);
    }

    /* renamed from: a */
    public void mo8484a(C1196fz fzVar) {
        int i;
        int i2;
        this.f4363lr.f4380lG = null;
        boolean z = fzVar.f3685vu != null;
        if (!(fzVar.errorCode == -2 || fzVar.errorCode == 3)) {
            C1201gb.m4561b(this.f4363lr.mo10151au());
        }
        if (fzVar.errorCode != -1) {
            if (mo10142a(fzVar, z)) {
                C1229gs.m4675S("Ad refresh scheduled.");
            }
            if (!(fzVar.errorCode != 3 || fzVar.f3681vq == null || fzVar.f3681vq.f3038qh == null)) {
                C1229gs.m4675S("Pinging no fill URLs.");
                C1011cr.m4151a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, fzVar, this.f4363lr.f4374lA, false, fzVar.f3681vq.f3038qh);
            }
            if (fzVar.errorCode != -2) {
                m6168a(fzVar.errorCode);
                return;
            }
            if (!this.f4363lr.f4381lH.f2623og && !z && this.f4363lr.f4396lW == 0) {
                if (!m6177b(fzVar)) {
                    m6168a(0);
                    return;
                } else if (this.f4363lr.f4399lz != null) {
                    this.f4363lr.f4399lz.f4373ly.mo8603Q(fzVar.f3678tN);
                }
            }
            if (!(this.f4363lr.f4382lI == null || this.f4363lr.f4382lI.f3666qB == null)) {
                this.f4363lr.f4382lI.f3666qB.mo8224a((C1005cn) null);
            }
            if (fzVar.f3666qB != null) {
                fzVar.f3666qB.mo8224a((C1005cn) this);
            }
            this.f4365lt.mo7906d(this.f4363lr.f4382lI);
            this.f4363lr.f4382lI = fzVar;
            this.f4363lr.f4384lK.mo8548j(fzVar.f3683vs);
            this.f4363lr.f4384lK.mo8549k(fzVar.f3684vt);
            this.f4363lr.f4384lK.mo8550t(this.f4363lr.f4381lH.f2623og);
            this.f4363lr.f4384lK.mo8552u(fzVar.f3675tI);
            if (!this.f4363lr.f4381lH.f2623og && !z && this.f4363lr.f4396lW == 0) {
                m6179c(false);
            }
            if (this.f4363lr.f4394lU == null) {
                this.f4363lr.f4394lU = new C1204ge(this.f4363lr.f4374lA);
            }
            if (fzVar.f3681vq != null) {
                i2 = fzVar.f3681vq.f3041qk;
                i = fzVar.f3681vq.f3042ql;
            } else {
                i = 0;
                i2 = 0;
            }
            this.f4363lr.f4394lU.mo8581d(i2, i);
            if (this.f4363lr.f4396lW == 0) {
                if (!this.f4363lr.f4381lH.f2623og && fzVar.f3672rN != null && (fzVar.f3672rN.mo8631dv().mo8658dF() || fzVar.f3680vp != null)) {
                    C0888af a = this.f4365lt.mo7903a(this.f4363lr.f4381lH, this.f4363lr.f4382lI);
                    if (fzVar.f3672rN.mo8631dv().mo8658dF() && a != null) {
                        a.mo7912a((C0885ac) new C1747z(fzVar.f3672rN));
                    }
                }
                if (this.f4363lr.f4382lI.f3672rN != null) {
                    this.f4363lr.f4382lI.f3672rN.mo8625bT();
                    this.f4363lr.f4382lI.f3672rN.mo8631dv().mo8659dG();
                }
                if (z) {
                    C0955bq.C0956a aVar = fzVar.f3685vu;
                    if ((aVar instanceof C0954bp) && this.f4363lr.f4391lR != null) {
                        m6175ap();
                    } else if (!(aVar instanceof C0953bo) || this.f4363lr.f4390lQ == null) {
                        C1229gs.m4679W("No matching listener for retrieved native ad template.");
                        m6168a(0);
                        return;
                    } else {
                        m6174ao();
                    }
                }
                m6173an();
            } else if (this.f4363lr.f4395lV != null && fzVar.f3680vp != null) {
                this.f4365lt.mo7902a(this.f4363lr.f4375lB, this.f4363lr.f4381lH, this.f4363lr.f4382lI, this.f4363lr.f4395lV, this.f4363lr.f4377lD);
            }
        }
    }

    /* renamed from: a */
    public void mo8165a(String str, ArrayList<String> arrayList) {
        C1082dy dyVar = new C1082dy(str, arrayList, this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD);
        if (this.f4363lr.f4387lN == null) {
            C1229gs.m4679W("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f4363lr.f4375lB) != 0) {
                C1229gs.m4679W("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if (this.f4363lr.f4386lM == null) {
                C1229gs.m4679W("PlayStorePurchaseListener is not set.");
            } else if (this.f4363lr.f4393lT == null) {
                C1229gs.m4679W("PlayStorePurchaseVerifier is not initialized.");
            } else {
                try {
                    if (!this.f4363lr.f4386lM.isValidPurchase(str)) {
                        return;
                    }
                } catch (RemoteException e) {
                    C1229gs.m4679W("Could not start In-App purchase.");
                }
                C1083dz.m4309a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3780wG, new C1078dv(dyVar, this.f4363lr.f4386lM, this.f4363lr.f4393lT, this.f4363lr.f4375lB));
            }
        } else {
            try {
                this.f4363lr.f4387lN.mo8422a(dyVar);
            } catch (RemoteException e2) {
                C1229gs.m4679W("Could not start In-App purchase.");
            }
        }
    }

    /* renamed from: a */
    public void mo8580a(HashSet<C1199ga> hashSet) {
        this.f4363lr.mo10150a(hashSet);
    }

    /* renamed from: a */
    public void mo10141a(List<String> list) {
        C0348n.m854aT("setNativeTemplates must be called on the main UI thread.");
        this.f4363lr.f4392lS = list;
    }

    /* renamed from: a */
    public boolean mo8045a(C0924av avVar) {
        C0348n.m854aT("loadAd must be called on the main UI thread.");
        if (this.f4363lr.f4379lF != null || this.f4363lr.f4380lG != null) {
            if (this.f4361lp != null) {
                C1229gs.m4679W("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
            }
            this.f4361lp = avVar;
            return false;
        } else if (this.f4363lr.f4381lH.f2623og && this.f4363lr.f4382lI != null) {
            C1229gs.m4679W("An interstitial is already loading. Aborting.");
            return false;
        } else if (!mo10143aq()) {
            return false;
        } else {
            C1229gs.m4677U("Starting ad request.");
            if (!avVar.f2613nW) {
                C1229gs.m4677U("Use AdRequest.Builder.addTestDevice(\"" + C1228gr.m4674v(this.f4363lr.f4375lB) + "\") to get test ads on this device.");
            }
            Bundle a = mo10140a(C1201gb.m4564cV().mo8573l(this.f4363lr.f4375lB));
            this.f4364ls.cancel();
            this.f4363lr.f4396lW = 0;
            C1168fi.C1169a a2 = m6165a(avVar, a);
            this.f4363lr.f4379lF = C1146fa.m4403a(this.f4363lr.f4375lB, a2, this.f4363lr.f4376lC, this);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10142a(C1196fz fzVar, boolean z) {
        C0924av avVar;
        boolean z2 = false;
        if (this.f4361lp != null) {
            avVar = this.f4361lp;
            this.f4361lp = null;
        } else {
            avVar = fzVar.f3679tx;
            if (avVar.extras != null) {
                z2 = avVar.extras.getBoolean("_noRefresh", false);
            }
        }
        boolean z3 = z2 | z;
        if (this.f4363lr.f4381lH.f2623og) {
            if (this.f4363lr.f4396lW == 0) {
                C1213gj.m4622a((WebView) fzVar.f3672rN);
            }
        } else if (!z3 && this.f4363lr.f4396lW == 0) {
            if (fzVar.f3669qj > 0) {
                this.f4364ls.mo7888a(avVar, fzVar.f3669qj);
            } else if (fzVar.f3681vq != null && fzVar.f3681vq.f3040qj > 0) {
                this.f4364ls.mo7888a(avVar, fzVar.f3681vq.f3040qj);
            } else if (!fzVar.f3675tI && fzVar.errorCode == 2) {
                this.f4364ls.mo7890c(avVar);
            }
        }
        return this.f4364ls.mo7889ay();
    }

    /* renamed from: ab */
    public void mo8361ab() {
        m6171al();
    }

    /* renamed from: ac */
    public void mo8342ac() {
        this.f4365lt.mo7906d(this.f4363lr.f4382lI);
        if (this.f4363lr.f4381lH.f2623og) {
            m6176at();
        }
        this.f4366lu = false;
        m6170ak();
        this.f4363lr.f4384lK.mo8546cR();
    }

    /* renamed from: ad */
    public void mo8343ad() {
        if (this.f4363lr.f4381lH.f2623og) {
            m6179c(false);
        }
        this.f4366lu = true;
        m6172am();
    }

    /* renamed from: ae */
    public void mo8219ae() {
        onAdClicked();
    }

    /* renamed from: af */
    public void mo8220af() {
        mo8342ac();
    }

    /* renamed from: ag */
    public void mo8221ag() {
        mo8361ab();
    }

    /* renamed from: ah */
    public void mo8222ah() {
        mo8343ad();
    }

    /* renamed from: ai */
    public void mo8223ai() {
        if (this.f4363lr.f4382lI != null) {
            C1229gs.m4679W("Mediation adapter " + this.f4363lr.f4382lI.f3665qA + " refreshed, but mediation adapters should never refresh.");
        }
        m6179c(true);
        m6173an();
    }

    /* renamed from: aj */
    public void mo8046aj() {
        C0348n.m854aT("recordManualImpression must be called on the main UI thread.");
        if (this.f4363lr.f4382lI == null) {
            C1229gs.m4679W("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        C1229gs.m4675S("Pinging manual tracking URLs.");
        if (this.f4363lr.f4382lI.f3677tK != null) {
            C1213gj.m4617a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI.f3677tK);
        }
    }

    /* renamed from: aq */
    public boolean mo10143aq() {
        boolean z = true;
        if (!C1213gj.m4625a(this.f4363lr.f4375lB.getPackageManager(), this.f4363lr.f4375lB.getPackageName(), "android.permission.INTERNET")) {
            if (!this.f4363lr.f4381lH.f2623og) {
                C1228gr.m4671a(this.f4363lr.f4399lz, this.f4363lr.f4381lH, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!C1213gj.m4638p(this.f4363lr.f4375lB)) {
            if (!this.f4363lr.f4381lH.f2623og) {
                C1228gr.m4671a(this.f4363lr.f4399lz, this.f4363lr.f4381lH, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!z && !this.f4363lr.f4381lH.f2623og) {
            this.f4363lr.f4399lz.setVisibility(0);
        }
        return z;
    }

    /* renamed from: ar */
    public void mo7885ar() {
        if (this.f4363lr.f4382lI == null) {
            C1229gs.m4679W("Ad state was null when trying to ping click URLs.");
            return;
        }
        C1229gs.m4675S("Pinging click URLs.");
        this.f4363lr.f4384lK.mo8545cQ();
        if (this.f4363lr.f4382lI.f3667qf != null) {
            C1213gj.m4617a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI.f3667qf);
        }
        if (this.f4363lr.f4382lI.f3681vq != null && this.f4363lr.f4382lI.f3681vq.f3036qf != null) {
            C1011cr.m4151a(this.f4363lr.f4375lB, this.f4363lr.f4377lD.f3777wD, this.f4363lr.f4382lI, this.f4363lr.f4374lA, false, this.f4363lr.f4382lI.f3681vq.f3036qf);
        }
    }

    /* renamed from: as */
    public void mo7886as() {
        m6179c(false);
    }

    /* renamed from: b */
    public void mo7887b(View view) {
        this.f4363lr.f4395lV = view;
        mo8484a(new C1196fz(this.f4363lr.f4383lJ, (C1232gv) null, (C1003cl) null, (C1016cu) null, (String) null, (C1006co) null, (C0955bq.C0956a) null));
    }

    /* renamed from: b */
    public void mo10144b(C0924av avVar) {
        ViewParent parent = this.f4363lr.f4399lz.getParent();
        if (!(parent instanceof View) || !((View) parent).isShown() || !C1213gj.m4632dl() || this.f4366lu) {
            C1229gs.m4677U("Ad is not visible. Not refreshing ad.");
            this.f4364ls.mo7890c(avVar);
            return;
        }
        mo8045a(avVar);
    }

    /* renamed from: b */
    public void mo8206b(boolean z) {
        this.f4363lr.f4397lX = z;
    }

    public void destroy() {
        C0348n.m854aT("destroy must be called on the main UI thread.");
        m6169aa();
        this.f4363lr.f4378lE = null;
        this.f4363lr.f4385lL = null;
        this.f4363lr.f4386lM = null;
        this.f4363lr.f4387lN = null;
        this.f4363lr.f4388lO = null;
        this.f4363lr.f4389lP = null;
        this.f4364ls.cancel();
        this.f4365lt.stop();
        stopLoading();
        if (this.f4363lr.f4399lz != null) {
            this.f4363lr.f4399lz.removeAllViews();
        }
        if (!(this.f4363lr.f4382lI == null || this.f4363lr.f4382lI.f3672rN == null)) {
            this.f4363lr.f4382lI.f3672rN.destroy();
        }
        if (this.f4363lr.f4382lI != null && this.f4363lr.f4382lI.f3671qz != null) {
            try {
                this.f4363lr.f4382lI.f3671qz.destroy();
            } catch (RemoteException e) {
                C1229gs.m4679W("Could not destroy mediation adapter.");
            }
        }
    }

    public String getMediationAdapterClassName() {
        if (this.f4363lr.f4382lI != null) {
            return this.f4363lr.f4382lI.f3665qA;
        }
        return null;
    }

    public boolean isReady() {
        C0348n.m854aT("isLoaded must be called on the main UI thread.");
        return this.f4363lr.f4379lF == null && this.f4363lr.f4380lG == null && this.f4363lr.f4382lI != null;
    }

    public void onAdClicked() {
        mo7885ar();
    }

    public void onAppEvent(String name, String info) {
        if (this.f4363lr.f4385lL != null) {
            try {
                this.f4363lr.f4385lL.onAppEvent(name, info);
            } catch (RemoteException e) {
                C1229gs.m4683d("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        C0348n.m854aT("pause must be called on the main UI thread.");
        if (this.f4363lr.f4382lI != null && this.f4363lr.f4396lW == 0) {
            C1213gj.m4622a((WebView) this.f4363lr.f4382lI.f3672rN);
        }
        if (!(this.f4363lr.f4382lI == null || this.f4363lr.f4382lI.f3671qz == null)) {
            try {
                this.f4363lr.f4382lI.f3671qz.pause();
            } catch (RemoteException e) {
                C1229gs.m4679W("Could not pause mediation adapter.");
            }
        }
        this.f4365lt.pause();
        this.f4364ls.pause();
    }

    public void resume() {
        C0348n.m854aT("resume must be called on the main UI thread.");
        if (this.f4363lr.f4382lI != null && this.f4363lr.f4396lW == 0) {
            C1213gj.m4627b(this.f4363lr.f4382lI.f3672rN);
        }
        if (!(this.f4363lr.f4382lI == null || this.f4363lr.f4382lI.f3671qz == null)) {
            try {
                this.f4363lr.f4382lI.f3671qz.resume();
            } catch (RemoteException e) {
                C1229gs.m4679W("Could not resume mediation adapter.");
            }
        }
        this.f4364ls.resume();
        this.f4365lt.resume();
    }

    public void showInterstitial() {
        C0348n.m854aT("showInterstitial must be called on the main UI thread.");
        if (!this.f4363lr.f4381lH.f2623og) {
            C1229gs.m4679W("Cannot call showInterstitial on a banner ad.");
        } else if (this.f4363lr.f4382lI == null) {
            C1229gs.m4679W("The interstitial has not loaded.");
        } else if (this.f4363lr.f4396lW == 1) {
        } else {
            if (this.f4363lr.f4382lI.f3672rN.mo8635dz()) {
                C1229gs.m4679W("The interstitial is already showing.");
                return;
            }
            this.f4363lr.f4382lI.f3672rN.mo8643x(true);
            if (this.f4363lr.f4382lI.f3672rN.mo8631dv().mo8658dF() || this.f4363lr.f4382lI.f3680vp != null) {
                C0888af a = this.f4365lt.mo7903a(this.f4363lr.f4381lH, this.f4363lr.f4382lI);
                if (this.f4363lr.f4382lI.f3672rN.mo8631dv().mo8658dF() && a != null) {
                    a.mo7912a((C0885ac) new C1747z(this.f4363lr.f4382lI.f3672rN));
                }
            }
            if (this.f4363lr.f4382lI.f3675tI) {
                try {
                    this.f4363lr.f4382lI.f3671qz.showInterstitial();
                } catch (RemoteException e) {
                    C1229gs.m4683d("Could not show interstitial.", e);
                    m6176at();
                }
            } else {
                C1745x xVar = new C1745x(this.f4363lr.f4397lX, false);
                if (this.f4363lr.f4375lB instanceof Activity) {
                    Window window = ((Activity) this.f4363lr.f4375lB).getWindow();
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    window.getDecorView().getGlobalVisibleRect(rect);
                    window.getDecorView().getWindowVisibleDisplayFrame(rect2);
                    if (!(rect.bottom == 0 || rect2.bottom == 0)) {
                        xVar = new C1745x(this.f4363lr.f4397lX, rect.top == rect2.top);
                    }
                }
                C1056dk.m4233a(this.f4363lr.f4375lB, new C1062dm(this, this, this, this.f4363lr.f4382lI.f3672rN, this.f4363lr.f4382lI.orientation, this.f4363lr.f4377lD, this.f4363lr.f4382lI.f3678tN, xVar));
            }
        }
    }

    public void stopLoading() {
        C0348n.m854aT("stopLoading must be called on the main UI thread.");
        if (this.f4363lr.f4382lI != null && this.f4363lr.f4396lW == 0) {
            this.f4363lr.f4382lI.f3672rN.stopLoading();
            this.f4363lr.f4382lI = null;
        }
        if (this.f4363lr.f4379lF != null) {
            this.f4363lr.f4379lF.cancel();
        }
        if (this.f4363lr.f4380lG != null) {
            this.f4363lr.f4380lG.cancel();
        }
    }
}
