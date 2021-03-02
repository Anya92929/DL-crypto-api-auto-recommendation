package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.internal.C0294bn;
import com.google.android.gms.internal.C0348cr;

/* renamed from: com.google.android.gms.internal.bf */
public final class C0280bf extends C0294bn.C0295a {

    /* renamed from: fD */
    private final Activity f846fD;

    /* renamed from: fE */
    private C0285bh f847fE;

    /* renamed from: fF */
    private C0287bj f848fF;

    /* renamed from: fG */
    private C0347cq f849fG;

    /* renamed from: fH */
    private C0283b f850fH;

    /* renamed from: fI */
    private C0290bk f851fI;

    /* renamed from: fJ */
    private FrameLayout f852fJ;

    /* renamed from: fK */
    private WebChromeClient.CustomViewCallback f853fK;

    /* renamed from: fL */
    private boolean f854fL = false;

    /* renamed from: fM */
    private boolean f855fM = false;

    /* renamed from: fN */
    private RelativeLayout f856fN;

    /* renamed from: com.google.android.gms.internal.bf$a */
    private static final class C0282a extends Exception {
        public C0282a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.bf$b */
    private static final class C0283b {

        /* renamed from: fP */
        public final ViewGroup.LayoutParams f858fP;

        /* renamed from: fQ */
        public final ViewGroup f859fQ;
        public final int index;

        public C0283b(C0347cq cqVar) throws C0282a {
            this.f858fP = cqVar.getLayoutParams();
            ViewParent parent = cqVar.getParent();
            if (parent instanceof ViewGroup) {
                this.f859fQ = (ViewGroup) parent;
                this.index = this.f859fQ.indexOfChild(cqVar);
                this.f859fQ.removeView(cqVar);
                cqVar.mo4216i(true);
                return;
            }
            throw new C0282a("Could not get the parent of the WebView for an overlay.");
        }
    }

    public C0280bf(Activity activity) {
        this.f846fD = activity;
    }

    /* renamed from: T */
    private void m564T() {
        if (this.f846fD.isFinishing() && !this.f855fM) {
            this.f855fM = true;
            if (this.f846fD.isFinishing()) {
                if (this.f849fG != null) {
                    this.f849fG.mo4208as();
                    this.f856fN.removeView(this.f849fG);
                    if (this.f850fH != null) {
                        this.f849fG.mo4216i(false);
                        this.f850fH.f859fQ.addView(this.f849fG, this.f850fH.index, this.f850fH.f858fP);
                    }
                }
                if (this.f847fE != null && this.f847fE.f863fT != null) {
                    this.f847fE.f863fT.mo4126B();
                }
            }
        }
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m565a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m566a(Context context, C0285bh bhVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bhVar.f860eg.f1017hS);
        C0285bh.m581a(intent, bhVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        context.startActivity(intent);
    }

    /* renamed from: e */
    private void m567e(boolean z) throws C0282a {
        this.f846fD.requestWindowFeature(1);
        Window window = this.f846fD.getWindow();
        window.setFlags(1024, 1024);
        setRequestedOrientation(this.f847fE.orientation);
        if (Build.VERSION.SDK_INT >= 11) {
            C0344cn.m733m("Enabling hardware acceleration on the AdActivity window.");
            C0340cj.m714a(window);
        }
        this.f856fN = new RelativeLayout(this.f846fD);
        this.f856fN.setBackgroundColor(-16777216);
        this.f846fD.setContentView(this.f856fN);
        boolean aD = this.f847fE.f864fU.mo4212aw().mo4229aD();
        if (z) {
            this.f849fG = C0347cq.m741a(this.f846fD, this.f847fE.f864fU.mo4211av(), true, aD, (C0599h) null, this.f847fE.f860eg);
            this.f849fG.mo4212aw().mo4224a((C0613q) null, (C0286bi) null, this.f847fE.f865fV, this.f847fE.f869fZ, true);
            this.f849fG.mo4212aw().mo4223a((C0348cr.C0350a) new C0348cr.C0350a() {
                /* renamed from: a */
                public void mo4114a(C0347cq cqVar) {
                    cqVar.mo4209at();
                }
            });
            if (this.f847fE.f870fz != null) {
                this.f849fG.loadUrl(this.f847fE.f870fz);
            } else if (this.f847fE.f868fY != null) {
                this.f849fG.loadDataWithBaseURL(this.f847fE.f866fW, this.f847fE.f868fY, "text/html", "UTF-8", (String) null);
            } else {
                throw new C0282a("No URL or HTML to display in ad overlay.");
            }
        } else {
            this.f849fG = this.f847fE.f864fU;
            this.f849fG.setContext(this.f846fD);
        }
        this.f849fG.mo4206a(this);
        this.f856fN.addView(this.f849fG, -1, -1);
        if (!z) {
            this.f849fG.mo4209at();
        }
        mo4102c(aD);
    }

    /* renamed from: Q */
    public C0287bj mo4096Q() {
        return this.f848fF;
    }

    /* renamed from: R */
    public void mo4097R() {
        if (this.f847fE != null) {
            setRequestedOrientation(this.f847fE.orientation);
        }
        if (this.f852fJ != null) {
            this.f846fD.setContentView(this.f856fN);
            this.f852fJ.removeAllViews();
            this.f852fJ = null;
        }
        if (this.f853fK != null) {
            this.f853fK.onCustomViewHidden();
            this.f853fK = null;
        }
    }

    /* renamed from: S */
    public void mo4098S() {
        this.f856fN.removeView(this.f851fI);
        mo4102c(true);
    }

    /* renamed from: a */
    public void mo4099a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f852fJ = new FrameLayout(this.f846fD);
        this.f852fJ.setBackgroundColor(-16777216);
        this.f852fJ.addView(view, -1, -1);
        this.f846fD.setContentView(this.f852fJ);
        this.f853fK = customViewCallback;
    }

    /* renamed from: b */
    public void mo4100b(int i, int i2, int i3, int i4) {
        if (this.f848fF != null) {
            this.f848fF.setLayoutParams(m565a(i, i2, i3, i4));
        }
    }

    /* renamed from: c */
    public void mo4101c(int i, int i2, int i3, int i4) {
        if (this.f848fF == null) {
            this.f848fF = new C0287bj(this.f846fD, this.f849fG);
            this.f856fN.addView(this.f848fF, 0, m565a(i, i2, i3, i4));
            this.f849fG.mo4212aw().mo4230j(false);
        }
    }

    /* renamed from: c */
    public void mo4102c(boolean z) {
        this.f851fI = new C0290bk(this.f846fD, z ? 50 : 32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f851fI.mo4143d(this.f847fE.f867fX);
        this.f856fN.addView(this.f851fI, layoutParams);
    }

    public void close() {
        this.f846fD.finish();
    }

    /* renamed from: d */
    public void mo4104d(boolean z) {
        if (this.f851fI != null) {
            this.f851fI.mo4143d(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f854fL = z;
        try {
            this.f847fE = C0285bh.m580a(this.f846fD.getIntent());
            if (this.f847fE == null) {
                throw new C0282a("Could not get info for ad overlay.");
            }
            if (savedInstanceState == null) {
                if (this.f847fE.f863fT != null) {
                    this.f847fE.f863fT.mo4127C();
                }
                if (!(this.f847fE.f871ga == 1 || this.f847fE.f862fS == null)) {
                    this.f847fE.f862fS.mo5320y();
                }
            }
            switch (this.f847fE.f871ga) {
                case 1:
                    m567e(false);
                    return;
                case 2:
                    this.f850fH = new C0283b(this.f847fE.f864fU);
                    m567e(false);
                    return;
                case 3:
                    m567e(true);
                    return;
                case 4:
                    if (this.f854fL) {
                        this.f846fD.finish();
                        return;
                    } else if (!C0277bc.m560a(this.f846fD, this.f847fE.f861fR, this.f847fE.f869fZ)) {
                        this.f846fD.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C0282a("Could not determine ad overlay type.");
            }
        } catch (C0282a e) {
            C0344cn.m737q(e.getMessage());
            this.f846fD.finish();
        }
    }

    public void onDestroy() {
        if (this.f848fF != null) {
            this.f848fF.destroy();
        }
        if (this.f849fG != null) {
            this.f856fN.removeView(this.f849fG);
        }
        m564T();
    }

    public void onPause() {
        if (this.f848fF != null) {
            this.f848fF.pause();
        }
        mo4097R();
        if (this.f849fG != null && (!this.f846fD.isFinishing() || this.f850fH == null)) {
            C0337ci.m695a((WebView) this.f849fG);
        }
        m564T();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f847fE != null && this.f847fE.f871ga == 4) {
            if (this.f854fL) {
                this.f846fD.finish();
            } else {
                this.f854fL = true;
            }
        }
        if (this.f849fG != null) {
            C0337ci.m704b(this.f849fG);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f854fL);
    }

    public void onStart() {
    }

    public void onStop() {
        m564T();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.f846fD.setRequestedOrientation(requestedOrientation);
    }
}
