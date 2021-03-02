package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzbfg;
    private List zzbfh;
    private String zzbfi;
    private String zzbfk;
    private double zzbfl;
    private String zzbfm;
    private String zzbfn;
    private NativeAd.Image zzcqp;

    public final String getBody() {
        return this.zzbfi;
    }

    public final String getCallToAction() {
        return this.zzbfk;
    }

    public final String getHeadline() {
        return this.zzbfg;
    }

    public final NativeAd.Image getIcon() {
        return this.zzcqp;
    }

    public final List getImages() {
        return this.zzbfh;
    }

    public final String getPrice() {
        return this.zzbfn;
    }

    public final double getStarRating() {
        return this.zzbfl;
    }

    public final String getStore() {
        return this.zzbfm;
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

    public final void setIcon(NativeAd.Image image) {
        this.zzcqp = image;
    }

    public final void setImages(List list) {
        this.zzbfh = list;
    }

    public final void setPrice(String str) {
        this.zzbfn = str;
    }

    public final void setStarRating(double d) {
        this.zzbfl = d;
    }

    public final void setStore(String str) {
        this.zzbfm = str;
    }
}
