package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@C1130ez
/* renamed from: com.google.android.gms.internal.bj */
public final class C0948bj implements SafeParcelable {
    public static final C0949bk CREATOR = new C0949bk();
    public final int backgroundColor;

    /* renamed from: oH */
    public final int f2890oH;

    /* renamed from: oI */
    public final int f2891oI;

    /* renamed from: oJ */
    public final int f2892oJ;

    /* renamed from: oK */
    public final int f2893oK;

    /* renamed from: oL */
    public final int f2894oL;

    /* renamed from: oM */
    public final int f2895oM;

    /* renamed from: oN */
    public final int f2896oN;

    /* renamed from: oO */
    public final String f2897oO;

    /* renamed from: oP */
    public final int f2898oP;

    /* renamed from: oQ */
    public final String f2899oQ;

    /* renamed from: oR */
    public final int f2900oR;

    /* renamed from: oS */
    public final int f2901oS;

    /* renamed from: oT */
    public final String f2902oT;
    public final int versionCode;

    C0948bj(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.f2890oH = i2;
        this.backgroundColor = i3;
        this.f2891oI = i4;
        this.f2892oJ = i5;
        this.f2893oK = i6;
        this.f2894oL = i7;
        this.f2895oM = i8;
        this.f2896oN = i9;
        this.f2897oO = str;
        this.f2898oP = i10;
        this.f2899oQ = str2;
        this.f2900oR = i11;
        this.f2901oS = i12;
        this.f2902oT = str3;
    }

    public C0948bj(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.f2890oH = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.f2891oI = searchAdRequest.getBackgroundGradientBottom();
        this.f2892oJ = searchAdRequest.getBackgroundGradientTop();
        this.f2893oK = searchAdRequest.getBorderColor();
        this.f2894oL = searchAdRequest.getBorderThickness();
        this.f2895oM = searchAdRequest.getBorderType();
        this.f2896oN = searchAdRequest.getCallButtonColor();
        this.f2897oO = searchAdRequest.getCustomChannels();
        this.f2898oP = searchAdRequest.getDescriptionTextColor();
        this.f2899oQ = searchAdRequest.getFontFace();
        this.f2900oR = searchAdRequest.getHeaderTextColor();
        this.f2901oS = searchAdRequest.getHeaderTextSize();
        this.f2902oT = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0949bk.m3984a(this, out, flags);
    }
}
