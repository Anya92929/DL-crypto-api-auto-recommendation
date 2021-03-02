package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdr;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzdy extends NativeContentAd {

    /* renamed from: a */
    private final zzdx f6142a;

    /* renamed from: b */
    private final List f6143b = new ArrayList();

    /* renamed from: c */
    private final zzds f6144c;

    public zzdy(zzdx zzdx) {
        zzds zzds;
        this.f6142a = zzdx;
        try {
            List<Object> images = this.f6142a.getImages();
            if (images != null) {
                for (Object a : images) {
                    zzdr a2 = mo8316a(a);
                    if (a2 != null) {
                        this.f6143b.add(new zzds(a2));
                    }
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzdr zzky = this.f6142a.zzky();
            if (zzky != null) {
                zzds = new zzds(zzky);
                this.f6144c = zzds;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzds = null;
        this.f6144c = zzds;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzdr mo8316a(Object obj) {
        if (obj instanceof IBinder) {
            return zzdr.zza.zzy((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzd mo4901a() {
        try {
            return this.f6142a.zzkv();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }

    public void destroy() {
        try {
            this.f6142a.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.f6142a.getAdvertiser();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.f6142a.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.f6142a.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.f6142a.getExtras();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.f6142a.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List getImages() {
        return this.f6143b;
    }

    public NativeAd.Image getLogo() {
        return this.f6144c;
    }
}
