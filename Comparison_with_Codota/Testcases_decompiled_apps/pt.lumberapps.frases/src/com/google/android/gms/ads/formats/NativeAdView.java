package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdt;

public abstract class NativeAdView extends FrameLayout {

    /* renamed from: a */
    private final FrameLayout f3414a;

    /* renamed from: b */
    private final zzdt f3415b = m5509a();

    public NativeAdView(Context context) {
        super(context);
        this.f3414a = m5510b(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3414a = m5510b(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3414a = m5510b(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3414a = m5510b(context);
    }

    /* renamed from: a */
    private zzdt m5509a() {
        zzab.zzb((Object) this.f3414a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzm.zzix().zza(this.f3414a.getContext(), (FrameLayout) this, this.f3414a);
    }

    /* renamed from: b */
    private FrameLayout m5510b(Context context) {
        FrameLayout a = mo4915a(context);
        a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(a);
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo4914a(String str) {
        try {
            zzd zzap = this.f3415b.zzap(str);
            if (zzap != null) {
                return (View) zze.zzad(zzap);
            }
        } catch (RemoteException e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FrameLayout mo4915a(Context context) {
        return new FrameLayout(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4916a(String str, View view) {
        try {
            this.f3415b.zzc(str, zze.zzac(view));
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f3414a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f3414a != view) {
            super.bringChildToFront(this.f3414a);
        }
    }

    public void destroy() {
        try {
            this.f3415b.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f3414a);
    }

    public void removeView(View view) {
        if (this.f3414a != view) {
            super.removeView(view);
        }
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f3415b.zze((zzd) nativeAd.mo4901a());
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }
}
