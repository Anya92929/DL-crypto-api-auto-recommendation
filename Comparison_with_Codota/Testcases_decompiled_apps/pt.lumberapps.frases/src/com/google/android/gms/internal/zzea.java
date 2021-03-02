package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzin
public class zzea implements NativeCustomTemplateAd {

    /* renamed from: a */
    private final zzdz f6146a;

    public zzea(zzdz zzdz) {
        this.f6146a = zzdz;
    }

    public List getAvailableAssetNames() {
        try {
            return this.f6146a.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.f6146a.getCustomTemplateId();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public NativeAd.Image getImage(String str) {
        try {
            zzdr zzau = this.f6146a.zzau(str);
            if (zzau != null) {
                return new zzds(zzau);
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.f6146a.zzat(str);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.f6146a.performClick(str);
        } catch (RemoteException e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.f6146a.recordImpression();
        } catch (RemoteException e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
