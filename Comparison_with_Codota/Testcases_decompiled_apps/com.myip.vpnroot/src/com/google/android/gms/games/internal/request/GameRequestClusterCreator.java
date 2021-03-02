package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Parcelable.Creator<GameRequestCluster> {
    /* renamed from: a */
    static void m3634a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, gameRequestCluster.mo7445lu(), false);
        C0354b.m939c(parcel, 1000, gameRequestCluster.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ck */
    public GameRequestCluster createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, GameRequestEntity.CREATOR);
                    break;
                case 1000:
                    i = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new GameRequestCluster(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dQ */
    public GameRequestCluster[] newArray(int i) {
        return new GameRequestCluster[i];
    }
}
