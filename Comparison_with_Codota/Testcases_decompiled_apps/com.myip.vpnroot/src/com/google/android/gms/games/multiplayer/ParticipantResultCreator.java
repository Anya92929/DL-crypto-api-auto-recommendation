package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class ParticipantResultCreator implements Parcelable.Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3697a(ParticipantResult participantResult, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, participantResult.getParticipantId(), false);
        C0354b.m939c(parcel, 1000, participantResult.getVersionCode());
        C0354b.m939c(parcel, 2, participantResult.getResult());
        C0354b.m939c(parcel, 3, participantResult.getPlacing());
        C0354b.m915H(parcel, D);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int C = C0352a.m875C(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 1000:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
