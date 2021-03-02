package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.C1071ds;
import com.google.android.gms.internal.C1234gw;

@C1130ez
/* renamed from: com.google.android.gms.internal.dk */
public class C1056dk extends C1071ds.C1072a {

    /* renamed from: ru */
    private static final int f3155ru = Color.argb(0, 0, 0, 0);

    /* renamed from: md */
    private C1232gv f3156md;

    /* renamed from: nr */
    private final Activity f3157nr;

    /* renamed from: rA */
    private boolean f3158rA = false;

    /* renamed from: rB */
    private FrameLayout f3159rB;

    /* renamed from: rC */
    private WebChromeClient.CustomViewCallback f3160rC;

    /* renamed from: rD */
    private boolean f3161rD = false;

    /* renamed from: rE */
    private boolean f3162rE = false;

    /* renamed from: rF */
    private boolean f3163rF = false;

    /* renamed from: rG */
    private RelativeLayout f3164rG;

    /* renamed from: rv */
    private C1062dm f3165rv;

    /* renamed from: rw */
    private C1064do f3166rw;

    /* renamed from: rx */
    private C1060c f3167rx;

    /* renamed from: ry */
    private C1067dp f3168ry;

    /* renamed from: rz */
    private boolean f3169rz;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.dk$a */
    private static final class C1058a extends Exception {
        public C1058a(String str) {
            super(str);
        }
    }

    @C1130ez
    /* renamed from: com.google.android.gms.internal.dk$b */
    private static final class C1059b extends RelativeLayout {

        /* renamed from: ly */
        private final C1218gm f3171ly;

        public C1059b(Context context, String str) {
            super(context);
            this.f3171ly = new C1218gm(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.f3171ly.mo8604c(event);
            return false;
        }
    }

    @C1130ez
    /* renamed from: com.google.android.gms.internal.dk$c */
    private static final class C1060c {
        public final int index;

        /* renamed from: rI */
        public final ViewGroup.LayoutParams f3172rI;

        /* renamed from: rJ */
        public final ViewGroup f3173rJ;

        public C1060c(C1232gv gvVar) throws C1058a {
            this.f3172rI = gvVar.getLayoutParams();
            ViewParent parent = gvVar.getParent();
            if (parent instanceof ViewGroup) {
                this.f3173rJ = (ViewGroup) parent;
                this.index = this.f3173rJ.indexOfChild(gvVar);
                this.f3173rJ.removeView(gvVar);
                gvVar.mo8643x(true);
                return;
            }
            throw new C1058a("Could not get the parent of the WebView for an overlay.");
        }
    }

    public C1056dk(Activity activity) {
        this.f3157nr = activity;
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m4232a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m4233a(Context context, C1062dm dmVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", dmVar.f3174lD.f3780wG);
        C1062dm.m4251a(intent, dmVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        context.startActivity(intent);
    }

    /* renamed from: U */
    public void mo8306U() {
        this.f3169rz = true;
    }

    /* renamed from: a */
    public void mo8307a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f3159rB = new FrameLayout(this.f3157nr);
        this.f3159rB.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3159rB.addView(view, -1, -1);
        this.f3157nr.setContentView(this.f3159rB);
        mo8306U();
        this.f3160rC = customViewCallback;
        this.f3158rA = true;
    }

    /* renamed from: b */
    public void mo8308b(int i, int i2, int i3, int i4) {
        if (this.f3166rw != null) {
            this.f3166rw.setLayoutParams(m4232a(i, i2, i3, i4));
        }
    }

    /* renamed from: bW */
    public C1064do mo8309bW() {
        return this.f3166rw;
    }

    /* renamed from: bX */
    public void mo8310bX() {
        if (this.f3165rv != null && this.f3158rA) {
            setRequestedOrientation(this.f3165rv.orientation);
        }
        if (this.f3159rB != null) {
            this.f3157nr.setContentView(this.f3164rG);
            mo8306U();
            this.f3159rB.removeAllViews();
            this.f3159rB = null;
        }
        if (this.f3160rC != null) {
            this.f3160rC.onCustomViewHidden();
            this.f3160rC = null;
        }
        this.f3158rA = false;
    }

    /* renamed from: bY */
    public void mo8311bY() {
        this.f3164rG.removeView(this.f3168ry);
        mo8317n(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: bZ */
    public void mo8312bZ() {
        if (this.f3157nr.isFinishing() && !this.f3162rE) {
            this.f3162rE = true;
            if (this.f3157nr.isFinishing()) {
                if (this.f3156md != null) {
                    mo8315cb();
                    this.f3164rG.removeView(this.f3156md);
                    if (this.f3167rx != null) {
                        this.f3156md.mo8643x(false);
                        this.f3167rx.f3173rJ.addView(this.f3156md, this.f3167rx.index, this.f3167rx.f3172rI);
                    }
                }
                if (this.f3165rv != null && this.f3165rv.f3177rM != null) {
                    this.f3165rv.f3177rM.mo8342ac();
                }
            }
        }
    }

    /* renamed from: c */
    public void mo8313c(int i, int i2, int i3, int i4) {
        if (this.f3166rw == null) {
            this.f3166rw = new C1064do(this.f3157nr, this.f3156md);
            this.f3164rG.addView(this.f3166rw, 0, m4232a(i, i2, i3, i4));
            this.f3156md.mo8631dv().mo8664y(false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ca */
    public void mo8314ca() {
        this.f3156md.mo8626ca();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cb */
    public void mo8315cb() {
        this.f3156md.mo8627cb();
    }

    public void close() {
        this.f3157nr.finish();
    }

    /* renamed from: n */
    public void mo8317n(boolean z) {
        this.f3168ry = new C1067dp(this.f3157nr, z ? 50 : 32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f3168ry.mo8359o(this.f3165rv.f3181rQ);
        this.f3164rG.addView(this.f3168ry, layoutParams);
    }

    /* renamed from: o */
    public void mo8318o(boolean z) {
        if (this.f3168ry != null) {
            this.f3168ry.mo8359o(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f3161rD = z;
        try {
            this.f3165rv = C1062dm.m4252b(this.f3157nr.getIntent());
            if (this.f3165rv == null) {
                throw new C1058a("Could not get info for ad overlay.");
            }
            if (this.f3165rv.f3187rW != null) {
                this.f3163rF = this.f3165rv.f3187rW.f4409lX;
            } else {
                this.f3163rF = false;
            }
            if (savedInstanceState == null) {
                if (this.f3165rv.f3177rM != null) {
                    this.f3165rv.f3177rM.mo8343ad();
                }
                if (!(this.f3165rv.f3184rT == 1 || this.f3165rv.f3176rL == null)) {
                    this.f3165rv.f3176rL.onAdClicked();
                }
            }
            switch (this.f3165rv.f3184rT) {
                case 1:
                    mo8327p(false);
                    return;
                case 2:
                    this.f3167rx = new C1060c(this.f3165rv.f3178rN);
                    mo8327p(false);
                    return;
                case 3:
                    mo8327p(true);
                    return;
                case 4:
                    if (this.f3161rD) {
                        this.f3157nr.finish();
                        return;
                    } else if (!C1053dh.m4228a(this.f3157nr, this.f3165rv.f3175rK, this.f3165rv.f3183rS)) {
                        this.f3157nr.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C1058a("Could not determine ad overlay type.");
            }
        } catch (C1058a e) {
            C1229gs.m4679W(e.getMessage());
            this.f3157nr.finish();
        }
    }

    public void onDestroy() {
        if (this.f3166rw != null) {
            this.f3166rw.destroy();
        }
        if (this.f3156md != null) {
            this.f3164rG.removeView(this.f3156md);
        }
        mo8312bZ();
    }

    public void onPause() {
        if (this.f3166rw != null) {
            this.f3166rw.pause();
        }
        mo8310bX();
        if (this.f3156md != null && (!this.f3157nr.isFinishing() || this.f3167rx == null)) {
            C1213gj.m4622a((WebView) this.f3156md);
        }
        mo8312bZ();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f3165rv != null && this.f3165rv.f3184rT == 4) {
            if (this.f3161rD) {
                this.f3157nr.finish();
            } else {
                this.f3161rD = true;
            }
        }
        if (this.f3156md != null) {
            C1213gj.m4627b(this.f3156md);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f3161rD);
    }

    public void onStart() {
    }

    public void onStop() {
        mo8312bZ();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo8327p(boolean z) throws C1058a {
        if (!this.f3169rz) {
            this.f3157nr.requestWindowFeature(1);
        }
        Window window = this.f3157nr.getWindow();
        if (!this.f3163rF || this.f3165rv.f3187rW.f4410mh) {
            window.setFlags(1024, 1024);
        }
        setRequestedOrientation(this.f3165rv.orientation);
        if (Build.VERSION.SDK_INT >= 11) {
            C1229gs.m4675S("Enabling hardware acceleration on the AdActivity window.");
            C1221gn.m4652a(window);
        }
        this.f3164rG = new C1059b(this.f3157nr, this.f3165rv.f3186rV);
        if (!this.f3163rF) {
            this.f3164rG.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            this.f3164rG.setBackgroundColor(f3155ru);
        }
        this.f3157nr.setContentView(this.f3164rG);
        mo8306U();
        boolean dF = this.f3165rv.f3178rN.mo8631dv().mo8658dF();
        if (z) {
            this.f3156md = C1232gv.m4688a(this.f3157nr, this.f3165rv.f3178rN.mo8618Y(), true, dF, (C1391k) null, this.f3165rv.f3174lD);
            this.f3156md.mo8631dv().mo8651a((C1734t) null, (C1063dn) null, this.f3165rv.f3179rO, this.f3165rv.f3183rS, true, this.f3165rv.f3185rU, this.f3165rv.f3178rN.mo8631dv().mo8657dE());
            this.f3156md.mo8631dv().mo8649a((C1234gw.C1236a) new C1234gw.C1236a() {
                /* renamed from: a */
                public void mo7957a(C1232gv gvVar) {
                    gvVar.mo8626ca();
                }
            });
            if (this.f3165rv.f3188rq != null) {
                this.f3156md.loadUrl(this.f3165rv.f3188rq);
            } else if (this.f3165rv.f3182rR != null) {
                this.f3156md.loadDataWithBaseURL(this.f3165rv.f3180rP, this.f3165rv.f3182rR, "text/html", "UTF-8", (String) null);
            } else {
                throw new C1058a("No URL or HTML to display in ad overlay.");
            }
        } else {
            this.f3156md = this.f3165rv.f3178rN;
            this.f3156md.setContext(this.f3157nr);
        }
        this.f3156md.mo8621a(this);
        ViewParent parent = this.f3156md.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.f3156md);
        }
        if (this.f3163rF) {
            this.f3156md.setBackgroundColor(f3155ru);
        }
        this.f3164rG.addView(this.f3156md, -1, -1);
        if (!z) {
            mo8314ca();
        }
        mo8317n(dF);
        if (this.f3156md.mo8632dw()) {
            mo8318o(true);
        }
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.f3157nr.setRequestedOrientation(requestedOrientation);
    }
}
