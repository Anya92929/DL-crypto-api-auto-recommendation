package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0153a;
import com.google.android.gms.common.internal.safeparcel.C0155b;

public class RecoveryDecisionCreator implements Parcelable.Creator<RecoveryDecision> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m216a(RecoveryDecision recoveryDecision, Parcel parcel, int i) {
        int k = C0155b.m361k(parcel);
        C0155b.m359c(parcel, 1, recoveryDecision.f345iM);
        C0155b.m348a(parcel, 2, (Parcelable) recoveryDecision.recoveryIntent, i, false);
        C0155b.m352a(parcel, 3, recoveryDecision.showRecoveryInterstitial);
        C0155b.m352a(parcel, 4, recoveryDecision.isRecoveryInfoNeeded);
        C0155b.m352a(parcel, 5, recoveryDecision.isRecoveryInterstitialAllowed);
        C0155b.m348a(parcel, 6, (Parcelable) recoveryDecision.recoveryIntentWithoutIntro, i, false);
        C0155b.m340C(parcel, k);
    }

    public RecoveryDecision createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        boolean z = false;
        int j = C0153a.m320j(parcel);
        boolean z2 = false;
        boolean z3 = false;
        PendingIntent pendingIntent2 = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0153a.m318i(parcel);
            switch (C0153a.m335y(i2)) {
                case 1:
                    i = C0153a.m314f(parcel, i2);
                    break;
                case 2:
                    pendingIntent2 = (PendingIntent) C0153a.m305a(parcel, i2, PendingIntent.CREATOR);
                    break;
                case 3:
                    z3 = C0153a.m311c(parcel, i2);
                    break;
                case 4:
                    z2 = C0153a.m311c(parcel, i2);
                    break;
                case 5:
                    z = C0153a.m311c(parcel, i2);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) C0153a.m305a(parcel, i2, PendingIntent.CREATOR);
                    break;
                default:
                    C0153a.m308b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new RecoveryDecision(i, pendingIntent2, z3, z2, z, pendingIntent);
        }
        throw new C0153a.C0154a("Overread allowed size end=" + j, parcel);
    }

    public RecoveryDecision[] newArray(int size) {
        return new RecoveryDecision[size];
    }
}
