package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.p009v4.p019f.C0150o;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzas;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@zzin
public final class zzv implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: A */
    private boolean f4107A;

    /* renamed from: B */
    private boolean f4108B;

    /* renamed from: C */
    private boolean f4109C;

    /* renamed from: a */
    final String f4110a;

    /* renamed from: b */
    final zzas f4111b;

    /* renamed from: c */
    zza f4112c;

    /* renamed from: d */
    zzp f4113d;

    /* renamed from: e */
    zzq f4114e;

    /* renamed from: f */
    zzw f4115f;

    /* renamed from: g */
    zzy f4116g;

    /* renamed from: h */
    zzho f4117h;

    /* renamed from: i */
    zzhs f4118i;

    /* renamed from: j */
    zzeb f4119j;

    /* renamed from: k */
    zzec f4120k;

    /* renamed from: l */
    C0150o f4121l;

    /* renamed from: m */
    C0150o f4122m;

    /* renamed from: n */
    NativeAdOptionsParcel f4123n;

    /* renamed from: o */
    VideoOptionsParcel f4124o;

    /* renamed from: p */
    zzdo f4125p;

    /* renamed from: q */
    zzd f4126q;

    /* renamed from: r */
    List f4127r;

    /* renamed from: s */
    zzk f4128s;

    /* renamed from: t */
    View f4129t;

    /* renamed from: u */
    boolean f4130u;

    /* renamed from: v */
    boolean f4131v;

    /* renamed from: w */
    private HashSet f4132w;

    /* renamed from: x */
    private int f4133x;

    /* renamed from: y */
    private int f4134y;

    /* renamed from: z */
    private zzkr f4135z;
    public final Context zzagf;
    public String zzaou;
    public final VersionInfoParcel zzaow;
    public zzkc zzaoy;
    public zzkj zzaoz;
    public AdSizeParcel zzapa;
    public zzju zzapb;
    public zzju.zza zzapc;
    public zzjv zzapd;
    public zzka zzapu;
    public int zzapw;

    public class zza extends ViewSwitcher {

        /* renamed from: a */
        private final zzkk f4136a;

        /* renamed from: b */
        private final zzku f4137b;

        public zza(Context context, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.f4136a = new zzkk(context);
            if (context instanceof Activity) {
                this.f4137b = new zzku((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.f4137b = new zzku((Activity) null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.f4137b.zzts();
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f4137b != null) {
                this.f4137b.onAttachedToWindow();
            }
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f4137b != null) {
                this.f4137b.onDetachedFromWindow();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.f4136a.zze(motionEvent);
            return false;
        }

        public void removeAllViews() {
            ArrayList<zzlh> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof zzlh)) {
                    arrayList.add((zzlh) childAt);
                }
                i = i2 + 1;
            }
            super.removeAllViews();
            for (zzlh destroy : arrayList) {
                destroy.destroy();
            }
        }

        public void zzgr() {
            zzkd.m7303v("Disable position monitoring on adFrame.");
            if (this.f4137b != null) {
                this.f4137b.zztt();
            }
        }

        public zzkk zzgv() {
            return this.f4136a;
        }
    }

    public zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, (zzas) null);
    }

    zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzas zzas) {
        this.zzapu = null;
        this.f4129t = null;
        this.zzapw = 0;
        this.f4130u = false;
        this.f4131v = false;
        this.f4132w = null;
        this.f4133x = -1;
        this.f4134y = -1;
        this.f4107A = true;
        this.f4108B = true;
        this.f4109C = false;
        zzdc.initialize(context);
        if (zzu.zzft().zzsl() != null) {
            List zzjy = zzdc.zzjy();
            if (versionInfoParcel.zzcnk != 0) {
                zzjy.add(Integer.toString(versionInfoParcel.zzcnk));
            }
            zzu.zzft().zzsl().zzc(zzjy);
        }
        this.f4110a = UUID.randomUUID().toString();
        if (adSizeParcel.zzaus || adSizeParcel.zzauu) {
            this.f4112c = null;
        } else {
            this.f4112c = new zza(context, this, this);
            this.f4112c.setMinimumWidth(adSizeParcel.widthPixels);
            this.f4112c.setMinimumHeight(adSizeParcel.heightPixels);
            this.f4112c.setVisibility(4);
        }
        this.zzapa = adSizeParcel;
        this.zzaou = str;
        this.zzagf = context;
        this.zzaow = versionInfoParcel;
        this.f4111b = zzas == null ? new zzas(new C1295p(this)) : zzas;
        this.f4135z = new zzkr(200);
        this.f4122m = new C0150o();
    }

    /* renamed from: a */
    private void m5874a() {
        View findViewById;
        if (this.f4112c != null && (findViewById = this.f4112c.getRootView().findViewById(16908290)) != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.f4112c.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.f4107A = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.f4108B = false;
            }
        }
    }

    /* renamed from: a */
    private void m5875a(boolean z) {
        boolean z2 = true;
        if (this.f4112c != null && this.zzapb != null && this.zzapb.zzbtm != null && this.zzapb.zzbtm.zzuj() != null) {
            if (!z || this.f4135z.tryAcquire()) {
                if (this.zzapb.zzbtm.zzuj().zzho()) {
                    int[] iArr = new int[2];
                    this.f4112c.getLocationOnScreen(iArr);
                    int zzb = zzm.zziw().zzb(this.zzagf, iArr[0]);
                    int zzb2 = zzm.zziw().zzb(this.zzagf, iArr[1]);
                    if (!(zzb == this.f4133x && zzb2 == this.f4134y)) {
                        this.f4133x = zzb;
                        this.f4134y = zzb2;
                        zzli zzuj = this.zzapb.zzbtm.zzuj();
                        int i = this.f4133x;
                        int i2 = this.f4134y;
                        if (z) {
                            z2 = false;
                        }
                        zzuj.zza(i, i2, z2);
                    }
                }
                m5874a();
            }
        }
    }

    public void destroy() {
        zzgr();
        this.f4114e = null;
        this.f4115f = null;
        this.f4118i = null;
        this.f4117h = null;
        this.f4125p = null;
        this.f4116g = null;
        zzi(false);
        if (this.f4112c != null) {
            this.f4112c.removeAllViews();
        }
        zzgm();
        zzgo();
        this.zzapb = null;
    }

    public void onGlobalLayout() {
        m5875a(false);
    }

    public void onScrollChanged() {
        m5875a(true);
        this.f4109C = true;
    }

    public void zza(HashSet hashSet) {
        this.f4132w = hashSet;
    }

    public HashSet zzgl() {
        return this.f4132w;
    }

    public void zzgm() {
        if (this.zzapb != null && this.zzapb.zzbtm != null) {
            this.zzapb.zzbtm.destroy();
        }
    }

    public void zzgn() {
        if (this.zzapb != null && this.zzapb.zzbtm != null) {
            this.zzapb.zzbtm.stopLoading();
        }
    }

    public void zzgo() {
        if (this.zzapb != null && this.zzapb.zzboo != null) {
            try {
                this.zzapb.zzboo.destroy();
            } catch (RemoteException e) {
                zzkd.zzcx("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzgp() {
        return this.zzapw == 0;
    }

    public boolean zzgq() {
        return this.zzapw == 1;
    }

    public void zzgr() {
        if (this.f4112c != null) {
            this.f4112c.zzgr();
        }
    }

    public String zzgt() {
        return (!this.f4107A || !this.f4108B) ? this.f4107A ? this.f4109C ? "top-scrollable" : "top-locked" : this.f4108B ? this.f4109C ? "bottom-scrollable" : "bottom-locked" : "" : "";
    }

    public void zzgu() {
        if (this.zzapb != null) {
            this.zzapd.zzl(this.zzapb.zzcik);
            this.zzapd.zzm(this.zzapb.zzcil);
            this.zzapd.zzad(this.zzapb.zzcby);
        }
        this.zzapd.zzac(this.zzapa.zzaus);
    }

    public void zzi(boolean z) {
        if (this.zzapw == 0) {
            zzgn();
        }
        if (this.zzaoy != null) {
            this.zzaoy.cancel();
        }
        if (this.zzaoz != null) {
            this.zzaoz.cancel();
        }
        if (z) {
            this.zzapb = null;
        }
    }
}
