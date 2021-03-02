package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.mq */
public class C1568mq implements SafeParcelable {
    public static final Parcelable.Creator<C1568mq> CREATOR = new C1569mr();

    /* renamed from: BR */
    final int f4289BR;

    /* renamed from: Ss */
    private final String f4290Ss;
    private final LatLng ahN;
    private final List<C1566mo> ahO;
    private final String ahP;
    private final String ahQ;
    private final String mName;

    C1568mq(int i, String str, LatLng latLng, String str2, List<C1566mo> list, String str3, String str4) {
        this.f4289BR = i;
        this.mName = str;
        this.ahN = latLng;
        this.f4290Ss = str2;
        this.ahO = new ArrayList(list);
        this.ahP = str3;
        this.ahQ = str4;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f4290Ss;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.ahP;
    }

    /* renamed from: mj */
    public LatLng mo9450mj() {
        return this.ahN;
    }

    /* renamed from: mk */
    public List<C1566mo> mo9451mk() {
        return this.ahO;
    }

    /* renamed from: ml */
    public String mo9452ml() {
        return this.ahQ;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1569mr.m5630a(this, parcel, flags);
    }
}
