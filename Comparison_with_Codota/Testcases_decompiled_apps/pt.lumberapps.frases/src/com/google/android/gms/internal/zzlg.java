package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzab;

@zzin
public class zzlg {

    /* renamed from: a */
    private final zzlh f6675a;

    /* renamed from: b */
    private final Context f6676b;

    /* renamed from: c */
    private final ViewGroup f6677c;

    /* renamed from: d */
    private zzk f6678d;

    public zzlg(Context context, ViewGroup viewGroup, zzlh zzlh) {
        this(context, viewGroup, zzlh, (zzk) null);
    }

    zzlg(Context context, ViewGroup viewGroup, zzlh zzlh, zzk zzk) {
        this.f6676b = context;
        this.f6677c = viewGroup;
        this.f6675a = zzlh;
        this.f6678d = zzk;
    }

    public void onDestroy() {
        zzab.zzhi("onDestroy must be called from the UI thread.");
        if (this.f6678d != null) {
            this.f6678d.destroy();
            this.f6677c.removeView(this.f6678d);
            this.f6678d = null;
        }
    }

    public void onPause() {
        zzab.zzhi("onPause must be called from the UI thread.");
        if (this.f6678d != null) {
            this.f6678d.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.f6678d == null) {
            zzdg.zza(this.f6675a.zzus().zzkf(), this.f6675a.zzur(), "vpr");
            zzdi zzb = zzdg.zzb(this.f6675a.zzus().zzkf());
            this.f6678d = new zzk(this.f6676b, this.f6675a, i5, z, this.f6675a.zzus().zzkf(), zzb);
            this.f6677c.addView(this.f6678d, 0, new ViewGroup.LayoutParams(-1, -1));
            this.f6678d.zzd(i, i2, i3, i4);
            this.f6675a.zzuj().zzak(false);
        }
    }

    public void zze(int i, int i2, int i3, int i4) {
        zzab.zzhi("The underlay may only be modified from the UI thread.");
        if (this.f6678d != null) {
            this.f6678d.zzd(i, i2, i3, i4);
        }
    }

    public zzk zzub() {
        zzab.zzhi("getAdVideoUnderlay must be called from the UI thread.");
        return this.f6678d;
    }
}
