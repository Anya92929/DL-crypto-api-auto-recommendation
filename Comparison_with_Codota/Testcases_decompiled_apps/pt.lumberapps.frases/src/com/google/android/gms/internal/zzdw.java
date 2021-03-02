package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdr;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzdw extends NativeAppInstallAd {

    /* renamed from: a */
    private final zzdv f6139a;

    /* renamed from: b */
    private final List f6140b = new ArrayList();

    /* renamed from: c */
    private final zzds f6141c;

    public zzdw(zzdv zzdv) {
        zzds zzds;
        this.f6139a = zzdv;
        try {
            List<Object> images = this.f6139a.getImages();
            if (images != null) {
                for (Object a : images) {
                    zzdr a2 = mo8312a(a);
                    if (a2 != null) {
                        this.f6140b.add(new zzds(a2));
                    }
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzdr zzku = this.f6139a.zzku();
            if (zzku != null) {
                zzds = new zzds(zzku);
                this.f6141c = zzds;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzds = null;
        this.f6141c = zzds;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzdr mo8312a(Object obj) {
        if (obj instanceof IBinder) {
            return zzdr.zza.zzy((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzd mo4901a() {
        try {
            return this.f6139a.zzkv();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f6139a.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.f6139a.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f6139a.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f6139a.getExtras();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f6139a.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public NativeAd.Image getIcon() {
        return this.f6141c;
    }

    public List getImages() {
        return this.f6140b;
    }

    public CharSequence getPrice() {
        try {
            return this.f6139a.getPrice();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        try {
            double starRating = this.f6139a.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    public CharSequence getStore() {
        try {
            return this.f6139a.getStore();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }
}
