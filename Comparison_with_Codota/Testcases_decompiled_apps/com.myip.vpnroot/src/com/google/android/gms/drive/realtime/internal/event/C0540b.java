package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.drive.realtime.internal.event.b */
public class C0540b implements Parcelable.Creator<ParcelableEvent> {
    /* renamed from: a */
    static void m1548a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, parcelableEvent.f1185BR);
        C0354b.m927a(parcel, 2, parcelableEvent.f1199vL, false);
        C0354b.m927a(parcel, 3, parcelableEvent.f1186Re, false);
        C0354b.m938b(parcel, 4, parcelableEvent.f1188Rl, false);
        C0354b.m930a(parcel, 5, parcelableEvent.f1189Rm);
        C0354b.m927a(parcel, 6, parcelableEvent.f1187Rh, false);
        C0354b.m927a(parcel, 7, parcelableEvent.f1190Rn, false);
        C0354b.m923a(parcel, 8, (Parcelable) parcelableEvent.f1191Ro, i, false);
        C0354b.m923a(parcel, 9, (Parcelable) parcelableEvent.f1192Rp, i, false);
        C0354b.m923a(parcel, 10, (Parcelable) parcelableEvent.f1193Rq, i, false);
        C0354b.m923a(parcel, 11, (Parcelable) parcelableEvent.f1194Rr, i, false);
        C0354b.m923a(parcel, 12, (Parcelable) parcelableEvent.f1195Rs, i, false);
        C0354b.m923a(parcel, 13, (Parcelable) parcelableEvent.f1196Rt, i, false);
        C0354b.m923a(parcel, 14, (Parcelable) parcelableEvent.f1197Ru, i, false);
        C0354b.m923a(parcel, 15, (Parcelable) parcelableEvent.f1198Rv, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: aZ */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 5:
                    z = C0352a.m888c(parcel, B);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) C0352a.m880a(parcel, B, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) C0352a.m880a(parcel, B, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) C0352a.m880a(parcel, B, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) C0352a.m880a(parcel, B, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) C0352a.m880a(parcel, B, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) C0352a.m880a(parcel, B, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) C0352a.m880a(parcel, B, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) C0352a.m880a(parcel, B, ObjectChangedDetails.CREATOR);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ParcelableEvent(i, str, str2, arrayList, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cm */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
