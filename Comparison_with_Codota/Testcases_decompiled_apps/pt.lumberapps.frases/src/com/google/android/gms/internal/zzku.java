package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzu;

@zzin
public final class zzku {

    /* renamed from: a */
    private final View f6646a;

    /* renamed from: b */
    private Activity f6647b;

    /* renamed from: c */
    private boolean f6648c;

    /* renamed from: d */
    private boolean f6649d;

    /* renamed from: e */
    private boolean f6650e;

    /* renamed from: f */
    private ViewTreeObserver.OnGlobalLayoutListener f6651f;

    /* renamed from: g */
    private ViewTreeObserver.OnScrollChangedListener f6652g;

    public zzku(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f6647b = activity;
        this.f6646a = view;
        this.f6651f = onGlobalLayoutListener;
        this.f6652g = onScrollChangedListener;
    }

    /* renamed from: a */
    private void m7332a() {
        if (!this.f6648c) {
            if (this.f6651f != null) {
                if (this.f6647b != null) {
                    zzu.zzfq().zza(this.f6647b, this.f6651f);
                }
                zzu.zzgk().zza(this.f6646a, this.f6651f);
            }
            if (this.f6652g != null) {
                if (this.f6647b != null) {
                    zzu.zzfq().zza(this.f6647b, this.f6652g);
                }
                zzu.zzgk().zza(this.f6646a, this.f6652g);
            }
            this.f6648c = true;
        }
    }

    /* renamed from: b */
    private void m7333b() {
        if (this.f6647b != null && this.f6648c) {
            if (!(this.f6651f == null || this.f6647b == null)) {
                zzu.zzfs().zzb(this.f6647b, this.f6651f);
            }
            if (!(this.f6652g == null || this.f6647b == null)) {
                zzu.zzfq().zzb(this.f6647b, this.f6652g);
            }
            this.f6648c = false;
        }
    }

    public void onAttachedToWindow() {
        this.f6649d = true;
        if (this.f6650e) {
            m7332a();
        }
    }

    public void onDetachedFromWindow() {
        this.f6649d = false;
        m7333b();
    }

    public void zzl(Activity activity) {
        this.f6647b = activity;
    }

    public void zzts() {
        this.f6650e = true;
        if (this.f6649d) {
            m7332a();
        }
    }

    public void zztt() {
        this.f6650e = false;
        m7333b();
    }
}
