package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgo;
import java.util.ArrayList;
import java.util.List;

@zzin
public class zzgt extends zzgo.zza {

    /* renamed from: a */
    private final NativeContentAdMapper f6275a;

    public zzgt(NativeContentAdMapper nativeContentAdMapper) {
        this.f6275a = nativeContentAdMapper;
    }

    public String getAdvertiser() {
        return this.f6275a.getAdvertiser();
    }

    public String getBody() {
        return this.f6275a.getBody();
    }

    public String getCallToAction() {
        return this.f6275a.getCallToAction();
    }

    public Bundle getExtras() {
        return this.f6275a.getExtras();
    }

    public String getHeadline() {
        return this.f6275a.getHeadline();
    }

    public List getImages() {
        List<NativeAd.Image> images = this.f6275a.getImages();
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
        return this.f6275a.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.f6275a.getOverrideImpressionRecording();
    }

    public void recordImpression() {
        this.f6275a.recordImpression();
    }

    public void zzk(zzd zzd) {
        this.f6275a.handleClick((View) zze.zzad(zzd));
    }

    public zzdr zzky() {
        NativeAd.Image logo = this.f6275a.getLogo();
        if (logo != null) {
            return new zzc(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    public void zzl(zzd zzd) {
        this.f6275a.trackView((View) zze.zzad(zzd));
    }

    public void zzm(zzd zzd) {
        this.f6275a.untrackView((View) zze.zzad(zzd));
    }
}
