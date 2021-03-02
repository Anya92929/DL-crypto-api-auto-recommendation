package com.appbrain.p032a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import cmn.C0708ac;
import com.appbrain.C1115i;

/* renamed from: com.appbrain.a.fj */
public abstract class C0929fj {

    /* renamed from: a */
    private static volatile Integer f2433a;

    /* renamed from: b */
    private static volatile C1115i f2434b;

    /* renamed from: c */
    private static volatile int f2435c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C0708ac f2436d;

    /* renamed from: e */
    private final C0930fk f2437e;

    /* renamed from: f */
    private final Context f2438f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f2439g;

    /* renamed from: h */
    private boolean f2440h;

    protected C0929fj(C0930fk fkVar) {
        this.f2437e = fkVar;
        this.f2438f = C0934fo.m3992a(fkVar.getContext());
        this.f2439g = fkVar.getArguments().getInt("aid", -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View m3940a(android.view.View r4) {
        /*
            r3 = -1
            r0 = 1133510656(0x43900000, float:288.0)
            int r0 = cmn.C0709ad.m3188b(r0)
            r4.setMinimumWidth(r0)
            r0 = 0
            int r1 = f2435c
            if (r1 == 0) goto L_0x003b
            android.widget.FrameLayout r0 = new android.widget.FrameLayout
            android.content.Context r1 = r4.getContext()
            r0.<init>(r1)
            int r1 = f2435c
            r0.setBackgroundResource(r1)
            r0.addView(r4, r3, r3)
        L_0x0020:
            if (r0 == 0) goto L_0x009b
            r4 = r0
        L_0x0023:
            android.content.Context r0 = r4.getContext()
            boolean r0 = cmn.C0725at.m3233b((android.content.Context) r0)
            if (r0 == 0) goto L_0x00e4
            r0 = 1107296256(0x42000000, float:32.0)
            int r0 = cmn.C0709ad.m3188b(r0)
        L_0x0033:
            android.view.View r1 = com.appbrain.p032a.C0934fo.m3993a((android.view.View) r4)
            r1.setPadding(r0, r0, r0, r0)
            return r1
        L_0x003b:
            r4.getContext()
            com.appbrain.i r1 = f2434b
            if (r1 == 0) goto L_0x0089
            com.appbrain.i r1 = f2434b
        L_0x0044:
            if (r1 == 0) goto L_0x0020
            com.appbrain.i r2 = com.appbrain.C1115i.NONE
            if (r1 == r2) goto L_0x0020
            r4.getContext()
            java.lang.Integer r0 = f2433a
            if (r0 == 0) goto L_0x0092
            java.lang.Integer r0 = f2433a
            int r0 = r0.intValue()
        L_0x0057:
            int r1 = r1.f3137e
            float r1 = (float) r1
            int r1 = cmn.C0709ad.m3188b(r1)
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r3, r3)
            r2.setMargins(r1, r1, r1, r1)
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            r3.setStroke(r1, r0)
            float r0 = (float) r1
            r1 = 1082130432(0x40800000, float:4.0)
            float r0 = r0 / r1
            r3.setCornerRadius(r0)
            android.widget.FrameLayout r0 = new android.widget.FrameLayout
            android.content.Context r1 = r4.getContext()
            r0.<init>(r1)
            cmn.a r1 = cmn.C0705a.m3174a()
            r1.mo3378a(r0, r3)
            r0.addView(r4, r2)
            goto L_0x0020
        L_0x0089:
            com.appbrain.a.bp r1 = com.appbrain.p032a.C0827bp.m3673b()
            com.appbrain.i r1 = r1.mo3691d()
            goto L_0x0044
        L_0x0092:
            com.appbrain.a.bp r0 = com.appbrain.p032a.C0827bp.m3673b()
            int r0 = r0.mo3692e()
            goto L_0x0057
        L_0x009b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x0023
            android.graphics.drawable.Drawable r1 = r4.getBackground()
            boolean r0 = r1 instanceof android.graphics.drawable.LayerDrawable
            if (r0 == 0) goto L_0x010c
            r0 = r1
            android.graphics.drawable.LayerDrawable r0 = (android.graphics.drawable.LayerDrawable) r0
            int r2 = r0.getNumberOfLayers()
            if (r2 <= 0) goto L_0x010c
            r1 = 0
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r0 = r1
        L_0x00b8:
            boolean r1 = r0 instanceof android.graphics.drawable.ColorDrawable
            if (r1 == 0) goto L_0x00d2
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            android.graphics.drawable.ColorDrawable r0 = (android.graphics.drawable.ColorDrawable) r0
            int r0 = r0.getColor()
            r1.setColor(r0)
            cmn.a r0 = cmn.C0705a.m3174a()
            r0.mo3378a(r4, r1)
            r0 = r1
        L_0x00d2:
            boolean r1 = r0 instanceof android.graphics.drawable.GradientDrawable
            if (r1 == 0) goto L_0x0023
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r1 = 1073741824(0x40000000, float:2.0)
            int r1 = cmn.C0709ad.m3188b(r1)
            float r1 = (float) r1
            r0.setCornerRadius(r1)
            goto L_0x0023
        L_0x00e4:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 13
            if (r0 < r1) goto L_0x0104
            android.content.Context r0 = r4.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.smallestScreenWidthDp
            r1 = 360(0x168, float:5.04E-43)
            if (r0 < r1) goto L_0x0104
            r0 = 1098907648(0x41800000, float:16.0)
            int r0 = cmn.C0709ad.m3188b(r0)
            goto L_0x0033
        L_0x0104:
            r0 = 1090519040(0x41000000, float:8.0)
            int r0 = cmn.C0709ad.m3188b(r0)
            goto L_0x0033
        L_0x010c:
            r0 = r1
            goto L_0x00b8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0929fj.m3940a(android.view.View):android.view.View");
    }

    /* renamed from: b */
    static /* synthetic */ void m3941b(C0929fj fjVar) {
        if (!fjVar.f2440h && fjVar.mo3829j()) {
            fjVar.f2440h = true;
            C0794aj.m3604a(fjVar.f2439g, C0799ao.DISMISSED);
            C0926fg.m3925a().mo3822f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo3661a() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract View mo3662a(Bundle bundle, Bundle bundle2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3825a(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3663b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo3664c() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo3665d() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo3699e() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo3727f() {
        if (!this.f2437e.mo3585c()) {
            this.f2437e.mo3584b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public final int mo3826g() {
        return this.f2439g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public final Context mo3827h() {
        return this.f2438f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final void mo3828i() {
        this.f2440h = true;
        mo3727f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final boolean mo3829j() {
        return this.f2437e.mo3585c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final boolean mo3830k() {
        return this.f2437e.mo3586d();
    }
}
