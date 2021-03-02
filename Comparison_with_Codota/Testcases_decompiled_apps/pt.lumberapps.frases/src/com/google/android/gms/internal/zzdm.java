package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzin
public class zzdm implements CustomRenderedAd {

    /* renamed from: a */
    private final zzdn f6129a;

    public zzdm(zzdn zzdn) {
        this.f6129a = zzdn;
    }

    public String getBaseUrl() {
        try {
            return this.f6129a.zzkk();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.f6129a.getContent();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.f6129a.zzi(view != null ? zze.zzac(view) : null);
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.f6129a.recordClick();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.f6129a.recordImpression();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
