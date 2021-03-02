package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzin;

@zzin
public final class SearchAdRequestParcel extends AbstractSafeParcelable {
    public static final zzao CREATOR = new zzao();
    public final int backgroundColor;
    public final int versionCode;
    public final int zzawz;
    public final int zzaxa;
    public final int zzaxb;
    public final int zzaxc;
    public final int zzaxd;
    public final int zzaxe;
    public final int zzaxf;
    public final String zzaxg;
    public final int zzaxh;
    public final String zzaxi;
    public final int zzaxj;
    public final int zzaxk;
    public final String zzaxl;

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zzawz = i2;
        this.backgroundColor = i3;
        this.zzaxa = i4;
        this.zzaxb = i5;
        this.zzaxc = i6;
        this.zzaxd = i7;
        this.zzaxe = i8;
        this.zzaxf = i9;
        this.zzaxg = str;
        this.zzaxh = i10;
        this.zzaxi = str2;
        this.zzaxj = i11;
        this.zzaxk = i12;
        this.zzaxl = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zzawz = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzaxa = searchAdRequest.getBackgroundGradientBottom();
        this.zzaxb = searchAdRequest.getBackgroundGradientTop();
        this.zzaxc = searchAdRequest.getBorderColor();
        this.zzaxd = searchAdRequest.getBorderThickness();
        this.zzaxe = searchAdRequest.getBorderType();
        this.zzaxf = searchAdRequest.getCallButtonColor();
        this.zzaxg = searchAdRequest.getCustomChannels();
        this.zzaxh = searchAdRequest.getDescriptionTextColor();
        this.zzaxi = searchAdRequest.getFontFace();
        this.zzaxj = searchAdRequest.getHeaderTextColor();
        this.zzaxk = searchAdRequest.getHeaderTextSize();
        this.zzaxl = searchAdRequest.getQuery();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzao.m5596a(this, parcel, i);
    }
}
