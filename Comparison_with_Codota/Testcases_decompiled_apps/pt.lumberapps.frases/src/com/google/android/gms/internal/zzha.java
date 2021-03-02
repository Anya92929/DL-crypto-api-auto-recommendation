package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzf;
import java.util.Map;
import java.util.Set;

@zzin
public class zzha extends zzhf {

    /* renamed from: a */
    static final Set f6299a = zzf.zzc("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");

    /* renamed from: b */
    private String f6300b = "top-right";

    /* renamed from: c */
    private boolean f6301c = true;

    /* renamed from: d */
    private int f6302d = 0;

    /* renamed from: e */
    private int f6303e = 0;

    /* renamed from: f */
    private int f6304f = -1;

    /* renamed from: g */
    private int f6305g = 0;

    /* renamed from: h */
    private int f6306h = 0;

    /* renamed from: i */
    private int f6307i = -1;

    /* renamed from: j */
    private final Object f6308j = new Object();

    /* renamed from: k */
    private final zzlh f6309k;

    /* renamed from: l */
    private final Activity f6310l;

    /* renamed from: m */
    private AdSizeParcel f6311m;

    /* renamed from: n */
    private ImageView f6312n;

    /* renamed from: o */
    private LinearLayout f6313o;

    /* renamed from: p */
    private zzhg f6314p;

    /* renamed from: q */
    private PopupWindow f6315q;

    /* renamed from: r */
    private RelativeLayout f6316r;

    /* renamed from: s */
    private ViewGroup f6317s;

    public zzha(zzlh zzlh, zzhg zzhg) {
        super(zzlh, "resize");
        this.f6309k = zzlh;
        this.f6310l = zzlh.zzue();
        this.f6314p = zzhg;
    }

    /* renamed from: a */
    private void m7118a(Map map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.f6307i = zzu.zzfq().zzcp((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.f6304f = zzu.zzfq().zzcp((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.f6305g = zzu.zzfq().zzcp((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.f6306h = zzu.zzfq().zzcp((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.f6301c = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.f6300b = str;
        }
    }

    /* renamed from: c */
    private int[] m7119c() {
        if (!mo8435b()) {
            return null;
        }
        if (this.f6301c) {
            return new int[]{this.f6302d + this.f6305g, this.f6303e + this.f6306h};
        }
        int[] zzi = zzu.zzfq().zzi(this.f6310l);
        int[] zzk = zzu.zzfq().zzk(this.f6310l);
        int i = zzi[0];
        int i2 = this.f6302d + this.f6305g;
        int i3 = this.f6303e + this.f6306h;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.f6307i + i2 > i) {
            i2 = i - this.f6307i;
        }
        if (i3 < zzk[0]) {
            i3 = zzk[0];
        } else if (this.f6304f + i3 > zzk[1]) {
            i3 = zzk[1] - this.f6304f;
        }
        return new int[]{i2, i3};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8432a(int i, int i2) {
        if (this.f6314p != null) {
            this.f6314p.zza(i, i2, this.f6307i, this.f6304f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo8433a() {
        return this.f6307i > -1 && this.f6304f > -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8434b(int i, int i2) {
        zzb(i, i2 - zzu.zzfq().zzk(this.f6310l)[0], this.f6307i, this.f6304f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8435b() {
        int i;
        int i2;
        int[] zzi = zzu.zzfq().zzi(this.f6310l);
        int[] zzk = zzu.zzfq().zzk(this.f6310l);
        int i3 = zzi[0];
        int i4 = zzi[1];
        if (this.f6307i < 50 || this.f6307i > i3) {
            zzkd.zzcx("Width is too small or too large.");
            return false;
        } else if (this.f6304f < 50 || this.f6304f > i4) {
            zzkd.zzcx("Height is too small or too large.");
            return false;
        } else if (this.f6304f == i4 && this.f6307i == i3) {
            zzkd.zzcx("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.f6301c) {
                String str = this.f6300b;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i = this.f6305g + this.f6302d;
                        i2 = this.f6303e + this.f6306h;
                        break;
                    case 1:
                        i = ((this.f6302d + this.f6305g) + (this.f6307i / 2)) - 25;
                        i2 = this.f6303e + this.f6306h;
                        break;
                    case 2:
                        i = ((this.f6302d + this.f6305g) + (this.f6307i / 2)) - 25;
                        i2 = ((this.f6303e + this.f6306h) + (this.f6304f / 2)) - 25;
                        break;
                    case 3:
                        i = this.f6305g + this.f6302d;
                        i2 = ((this.f6303e + this.f6306h) + this.f6304f) - 50;
                        break;
                    case 4:
                        i = ((this.f6302d + this.f6305g) + (this.f6307i / 2)) - 25;
                        i2 = ((this.f6303e + this.f6306h) + this.f6304f) - 50;
                        break;
                    case 5:
                        i = ((this.f6302d + this.f6305g) + this.f6307i) - 50;
                        i2 = ((this.f6303e + this.f6306h) + this.f6304f) - 50;
                        break;
                    default:
                        i = ((this.f6302d + this.f6305g) + this.f6307i) - 50;
                        i2 = this.f6303e + this.f6306h;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzk[0] || i2 + 50 > zzk[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(java.util.Map r13) {
        /*
            r12 = this;
            r4 = -1
            r5 = 1
            r3 = 0
            java.lang.Object r6 = r12.f6308j
            monitor-enter(r6)
            android.app.Activity r1 = r12.f6310l     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0011
            java.lang.String r1 = "Not an activity context. Cannot resize."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzdn()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "Webview is not yet available, size is not set."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            throw r1
        L_0x0023:
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzdn()     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzaus     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "Is interstitial. Cannot resize an interstitial."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0034:
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzun()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0043
            java.lang.String r1 = "Cannot resize an expanded banner."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0043:
            r12.m7118a(r13)     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.mo8433a()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "Invalid width and height options. Cannot resize."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0053:
            android.app.Activity r1 = r12.f6310l     // Catch:{ all -> 0x0020 }
            android.view.Window r7 = r1.getWindow()     // Catch:{ all -> 0x0020 }
            if (r7 == 0) goto L_0x0061
            android.view.View r1 = r7.getDecorView()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0068
        L_0x0061:
            java.lang.String r1 = "Activity context is not ready, cannot get window or decor view."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0068:
            int[] r8 = r12.m7119c()     // Catch:{ all -> 0x0020 }
            if (r8 != 0) goto L_0x0075
            java.lang.String r1 = "Resize location out of screen or close button is not visible."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0075:
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.f6310l     // Catch:{ all -> 0x0020 }
            int r9 = r12.f6307i     // Catch:{ all -> 0x0020 }
            int r9 = r1.zza((android.content.Context) r2, (int) r9)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.f6310l     // Catch:{ all -> 0x0020 }
            int r10 = r12.f6304f     // Catch:{ all -> 0x0020 }
            int r10 = r1.zza((android.content.Context) r2, (int) r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r1 = r1.getView()     // Catch:{ all -> 0x0020 }
            android.view.ViewParent r2 = r1.getParent()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x01d5
            boolean r1 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x01d5
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0020 }
            r1 = r0
            com.google.android.gms.internal.zzlh r11 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r11 = r11.getView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r11)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.f6315q     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01ce
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0020 }
            r12.f6317s = r2     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzkh r1 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r2 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            android.graphics.Bitmap r1 = r1.zzk((android.view.View) r2)     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = new android.widget.ImageView     // Catch:{ all -> 0x0020 }
            android.app.Activity r11 = r12.f6310l     // Catch:{ all -> 0x0020 }
            r2.<init>(r11)     // Catch:{ all -> 0x0020 }
            r12.f6312n = r2     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.f6312n     // Catch:{ all -> 0x0020 }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzdn()     // Catch:{ all -> 0x0020 }
            r12.f6311m = r1     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.f6317s     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.f6312n     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
        L_0x00dd:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.f6310l     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.f6316r = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.f6316r     // Catch:{ all -> 0x0020 }
            r2 = 0
            r1.setBackgroundColor(r2)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.f6316r     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0020 }
            r2.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            r1.setLayoutParams(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzkh r1 = com.google.android.gms.ads.internal.zzu.zzfq()     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r2 = r12.f6316r     // Catch:{ all -> 0x0020 }
            r11 = 0
            android.widget.PopupWindow r1 = r1.zza((android.view.View) r2, (int) r9, (int) r10, (boolean) r11)     // Catch:{ all -> 0x0020 }
            r12.f6315q = r1     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.f6315q     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setOutsideTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.f6315q     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r2 = r12.f6315q     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.f6301c     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01dd
            r1 = r5
        L_0x0116:
            r2.setClippingEnabled(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.f6316r     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r2 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r9 = -1
            r10 = -1
            r1.addView(r2, r9, r10)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.f6310l     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.f6313o = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ all -> 0x0020 }
            android.app.Activity r9 = r12.f6310l     // Catch:{ all -> 0x0020 }
            r10 = 50
            int r1 = r1.zza((android.content.Context) r9, (int) r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r9 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ all -> 0x0020 }
            android.app.Activity r10 = r12.f6310l     // Catch:{ all -> 0x0020 }
            r11 = 50
            int r9 = r9.zza((android.content.Context) r10, (int) r11)     // Catch:{ all -> 0x0020 }
            r2.<init>(r1, r9)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r12.f6300b     // Catch:{ all -> 0x0020 }
            int r9 = r1.hashCode()     // Catch:{ all -> 0x0020 }
            switch(r9) {
                case -1364013995: goto L_0x01f6;
                case -1012429441: goto L_0x01e0;
                case -655373719: goto L_0x0201;
                case 1163912186: goto L_0x0217;
                case 1288627767: goto L_0x020c;
                case 1755462605: goto L_0x01eb;
                default: goto L_0x0155;
            }     // Catch:{ all -> 0x0020 }
        L_0x0155:
            r1 = r4
        L_0x0156:
            switch(r1) {
                case 0: goto L_0x0222;
                case 1: goto L_0x022e;
                case 2: goto L_0x023a;
                case 3: goto L_0x0241;
                case 4: goto L_0x024d;
                case 5: goto L_0x0259;
                default: goto L_0x0159;
            }     // Catch:{ all -> 0x0020 }
        L_0x0159:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
        L_0x0163:
            android.widget.LinearLayout r1 = r12.f6313o     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.jm r3 = new com.google.android.gms.internal.jm     // Catch:{ all -> 0x0020 }
            r3.<init>(r12)     // Catch:{ all -> 0x0020 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = r12.f6313o     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "Close button"
            r1.setContentDescription(r3)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.f6316r     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r3 = r12.f6313o     // Catch:{ all -> 0x0020 }
            r1.addView(r3, r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.f6315q     // Catch:{ RuntimeException -> 0x0265 }
            android.view.View r2 = r7.getDecorView()     // Catch:{ RuntimeException -> 0x0265 }
            r3 = 0
            com.google.android.gms.ads.internal.util.client.zza r4 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r5 = r12.f6310l     // Catch:{ RuntimeException -> 0x0265 }
            r7 = 0
            r7 = r8[r7]     // Catch:{ RuntimeException -> 0x0265 }
            int r4 = r4.zza((android.content.Context) r5, (int) r7)     // Catch:{ RuntimeException -> 0x0265 }
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzm.zziw()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r7 = r12.f6310l     // Catch:{ RuntimeException -> 0x0265 }
            r9 = 1
            r9 = r8[r9]     // Catch:{ RuntimeException -> 0x0265 }
            int r5 = r5.zza((android.content.Context) r7, (int) r9)     // Catch:{ RuntimeException -> 0x0265 }
            r1.showAtLocation(r2, r3, r4, r5)     // Catch:{ RuntimeException -> 0x0265 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.mo8432a(r1, r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel     // Catch:{ all -> 0x0020 }
            android.app.Activity r3 = r12.f6310l     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.AdSize r4 = new com.google.android.gms.ads.AdSize     // Catch:{ all -> 0x0020 }
            int r5 = r12.f6307i     // Catch:{ all -> 0x0020 }
            int r7 = r12.f6304f     // Catch:{ all -> 0x0020 }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x0020 }
            r2.<init>((android.content.Context) r3, (com.google.android.gms.ads.AdSize) r4)     // Catch:{ all -> 0x0020 }
            r1.zza((com.google.android.gms.ads.internal.client.AdSizeParcel) r2)     // Catch:{ all -> 0x0020 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.mo8434b(r1, r2)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "resized"
            r12.zzbv(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01ce:
            android.widget.PopupWindow r1 = r12.f6315q     // Catch:{ all -> 0x0020 }
            r1.dismiss()     // Catch:{ all -> 0x0020 }
            goto L_0x00dd
        L_0x01d5:
            java.lang.String r1 = "Webview is detached, probably in the middle of a resize or expand."
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01dd:
            r1 = r3
            goto L_0x0116
        L_0x01e0:
            java.lang.String r5 = "top-left"
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r3
            goto L_0x0156
        L_0x01eb:
            java.lang.String r3 = "top-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r5
            goto L_0x0156
        L_0x01f6:
            java.lang.String r3 = "center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 2
            goto L_0x0156
        L_0x0201:
            java.lang.String r3 = "bottom-left"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 3
            goto L_0x0156
        L_0x020c:
            java.lang.String r3 = "bottom-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 4
            goto L_0x0156
        L_0x0217:
            java.lang.String r3 = "bottom-right"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 5
            goto L_0x0156
        L_0x0222:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x022e:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x023a:
            r1 = 13
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0241:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x024d:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0259:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0265:
            r1 = move-exception
            java.lang.String r2 = "Cannot show popup window: "
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0020 }
            int r3 = r1.length()     // Catch:{ all -> 0x0020 }
            if (r3 == 0) goto L_0x02a8
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x0020 }
        L_0x027a:
            r12.zzbt(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.f6316r     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r2 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.f6317s     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x02a5
            android.view.ViewGroup r1 = r12.f6317s     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.f6312n     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.f6317s     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r2 = r12.f6309k     // Catch:{ all -> 0x0020 }
            android.view.View r2 = r2.getView()     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzlh r1 = r12.f6309k     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r12.f6311m     // Catch:{ all -> 0x0020 }
            r1.zza((com.google.android.gms.ads.internal.client.AdSizeParcel) r2)     // Catch:{ all -> 0x0020 }
        L_0x02a5:
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x02a8:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            goto L_0x027a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzha.execute(java.util.Map):void");
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.f6308j) {
            this.f6302d = i;
            this.f6303e = i2;
            if (this.f6315q != null && z) {
                int[] c = m7119c();
                if (c != null) {
                    this.f6315q.update(zzm.zziw().zza((Context) this.f6310l, c[0]), zzm.zziw().zza((Context) this.f6310l, c[1]), this.f6315q.getWidth(), this.f6315q.getHeight());
                    mo8434b(c[0], c[1]);
                } else {
                    zzs(true);
                }
            }
        }
    }

    public void zzd(int i, int i2) {
        this.f6302d = i;
        this.f6303e = i2;
    }

    public boolean zzmw() {
        boolean z;
        synchronized (this.f6308j) {
            z = this.f6315q != null;
        }
        return z;
    }

    public void zzs(boolean z) {
        synchronized (this.f6308j) {
            if (this.f6315q != null) {
                this.f6315q.dismiss();
                this.f6316r.removeView(this.f6309k.getView());
                if (this.f6317s != null) {
                    this.f6317s.removeView(this.f6312n);
                    this.f6317s.addView(this.f6309k.getView());
                    this.f6309k.zza(this.f6311m);
                }
                if (z) {
                    zzbv("default");
                    if (this.f6314p != null) {
                        this.f6314p.zzej();
                    }
                }
                this.f6315q = null;
                this.f6316r = null;
                this.f6317s = null;
                this.f6313o = null;
            }
        }
    }
}
