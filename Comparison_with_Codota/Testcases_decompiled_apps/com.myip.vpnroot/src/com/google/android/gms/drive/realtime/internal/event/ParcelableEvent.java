package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new C0540b();

    /* renamed from: BR */
    final int f1185BR;

    /* renamed from: Re */
    final String f1186Re;

    /* renamed from: Rh */
    final String f1187Rh;

    /* renamed from: Rl */
    final List<String> f1188Rl;

    /* renamed from: Rm */
    final boolean f1189Rm;

    /* renamed from: Rn */
    final String f1190Rn;

    /* renamed from: Ro */
    final TextInsertedDetails f1191Ro;

    /* renamed from: Rp */
    final TextDeletedDetails f1192Rp;

    /* renamed from: Rq */
    final ValuesAddedDetails f1193Rq;

    /* renamed from: Rr */
    final ValuesRemovedDetails f1194Rr;

    /* renamed from: Rs */
    final ValuesSetDetails f1195Rs;

    /* renamed from: Rt */
    final ValueChangedDetails f1196Rt;

    /* renamed from: Ru */
    final ReferenceShiftedDetails f1197Ru;

    /* renamed from: Rv */
    final ObjectChangedDetails f1198Rv;

    /* renamed from: vL */
    final String f1199vL;

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails) {
        this.f1185BR = versionCode;
        this.f1199vL = sessionId;
        this.f1186Re = userId;
        this.f1188Rl = compoundOperationNames;
        this.f1189Rm = isLocal;
        this.f1187Rh = objectId;
        this.f1190Rn = objectType;
        this.f1191Ro = textInsertedDetails;
        this.f1192Rp = textDeletedDetails;
        this.f1193Rq = valuesAddedDetails;
        this.f1194Rr = valuesRemovedDetails;
        this.f1195Rs = valuesSetDetails;
        this.f1196Rt = valueChangedDetails;
        this.f1197Ru = referenceShiftedDetails;
        this.f1198Rv = objectChangedDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0540b.m1548a(this, dest, flags);
    }
}
