package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class NativeContentAdMapper extends NativeAdMapper {
    private String zzbfg;
    private List zzbfh;
    private String zzbfi;
    private String zzbfk;
    private String zzbfr;
    private NativeAd.Image zzcqq;

    public final String getAdvertiser() {
        return this.zzbfr;
    }

    public final String getBody() {
        return this.zzbfi;
    }

    public final String getCallToAction() {
        return this.zzbfk;
    }

    public final String getHeadline() {
        return this.zzbfg;
    }

    public final List getImages() {
        return this.zzbfh;
    }

    public final NativeAd.Image getLogo() {
        return this.zzcqq;
    }

    public final void setAdvertiser(String str) {
        this.zzbfr = str;
    }

    public final void setBody(String str) {
        this.zzbfi = str;
    }

    public final void setCallToAction(String str) {
        this.zzbfk = str;
    }

    public final void setHeadline(String str) {
        this.zzbfg = str;
    }

    public final void setImages(List list) {
        this.zzbfh = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.zzcqq = image;
    }
}
