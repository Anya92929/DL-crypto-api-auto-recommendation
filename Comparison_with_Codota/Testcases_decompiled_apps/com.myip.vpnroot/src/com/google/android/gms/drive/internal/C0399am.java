package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;

/* renamed from: com.google.android.gms.drive.internal.am */
public class C0399am implements Parcelable.Creator<OnEventResponse> {
    /* renamed from: a */
    static void m1152a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m939c(parcel, 1, onEventResponse.f938BR);
        C0354b.m939c(parcel, 2, onEventResponse.f939NS);
        C0354b.m923a(parcel, 3, (Parcelable) onEventResponse.f940Pk, i, false);
        C0354b.m923a(parcel, 5, (Parcelable) onEventResponse.f941Pl, i, false);
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ao */
    public OnEventResponse createFromParcel(Parcel parcel) {
        CompletionEvent completionEvent;
        ChangeEvent changeEvent;
        int i;
        int i2;
        CompletionEvent completionEvent2 = null;
        int i3 = 0;
        int C = C0352a.m875C(parcel);
        ChangeEvent changeEvent2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    CompletionEvent completionEvent3 = completionEvent2;
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = C0352a.m892g(parcel, B);
                    completionEvent = completionEvent3;
                    break;
                case 2:
                    i2 = i4;
                    ChangeEvent changeEvent3 = changeEvent2;
                    i = C0352a.m892g(parcel, B);
                    completionEvent = completionEvent2;
                    changeEvent = changeEvent3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    CompletionEvent completionEvent4 = completionEvent2;
                    changeEvent = (ChangeEvent) C0352a.m880a(parcel, B, ChangeEvent.CREATOR);
                    completionEvent = completionEvent4;
                    break;
                case 5:
                    completionEvent = (CompletionEvent) C0352a.m880a(parcel, B, CompletionEvent.CREATOR);
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    completionEvent = completionEvent2;
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            changeEvent2 = changeEvent;
            completionEvent2 = completionEvent;
        }
        if (parcel.dataPosition() == C) {
            return new OnEventResponse(i4, i3, changeEvent2, completionEvent2);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: bA */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
