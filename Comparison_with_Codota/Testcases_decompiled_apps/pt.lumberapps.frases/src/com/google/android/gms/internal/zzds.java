package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzin
public class zzds extends NativeAd.Image {

    /* renamed from: a */
    private final zzdr f6135a;

    /* renamed from: b */
    private final Drawable f6136b;

    /* renamed from: c */
    private final Uri f6137c;

    /* renamed from: d */
    private final double f6138d;

    public zzds(zzdr zzdr) {
        Drawable drawable;
        Uri uri = null;
        this.f6135a = zzdr;
        try {
            zzd zzkt = this.f6135a.zzkt();
            if (zzkt != null) {
                drawable = (Drawable) zze.zzad(zzkt);
                this.f6136b = drawable;
                uri = this.f6135a.getUri();
                this.f6137c = uri;
                double d = 1.0d;
                d = this.f6135a.getScale();
                this.f6138d = d;
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        drawable = null;
        this.f6136b = drawable;
        try {
            uri = this.f6135a.getUri();
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get uri.", e2);
        }
        this.f6137c = uri;
        double d2 = 1.0d;
        try {
            d2 = this.f6135a.getScale();
        } catch (RemoteException e3) {
            zzb.zzb("Failed to get scale.", e3);
        }
        this.f6138d = d2;
    }

    public Drawable getDrawable() {
        return this.f6136b;
    }

    public double getScale() {
        return this.f6138d;
    }

    public Uri getUri() {
        return this.f6137c;
    }
}
