package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgn;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzgs extends zzgn.zza {

    /* renamed from: a */
    private final NativeAppInstallAdMapper f6274a;

    public zzgs(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f6274a = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.f6274a.getBody();
    }

    public String getCallToAction() {
        return this.f6274a.getCallToAction();
    }

    public Bundle getExtras() {
        return this.f6274a.getExtras();
    }

    public String getHeadline() {
        return this.f6274a.getHeadline();
    }

    public List getImages() {
        List<NativeAd.Image> images = this.f6274a.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public boolean getOverrideClickHandling() {
        return this.f6274a.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.f6274a.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.f6274a.getPrice();
    }

    public double getStarRating() {
        return this.f6274a.getStarRating();
    }

    public String getStore() {
        return this.f6274a.getStore();
    }

    public void recordImpression() {
        this.f6274a.recordImpression();
    }

    public void zzk(zzd zzd) {
        this.f6274a.handleClick((View) zze.zzad(zzd));
    }

    public zzdr zzku() {
        NativeAd.Image icon = this.f6274a.getIcon();
        if (icon != null) {
            return new zzc(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    public void zzl(zzd zzd) {
        this.f6274a.trackView((View) zze.zzad(zzd));
    }

    public void zzm(zzd zzd) {
        this.f6274a.untrackView((View) zze.zzad(zzd));
    }
}
