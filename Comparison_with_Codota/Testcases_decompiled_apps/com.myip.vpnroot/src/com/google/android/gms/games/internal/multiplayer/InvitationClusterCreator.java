package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Parcelable.Creator<ZInvitationCluster> {
    /* renamed from: a */
    static void m3594a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m940c(parcel, 1, zInvitationCluster.mo7396lh(), false);
        C0354b.m939c(parcel, 1000, zInvitationCluster.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: ci */
    public ZInvitationCluster createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        ArrayList<InvitationEntity> arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    arrayList = C0352a.m887c(parcel, B, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: dN */
    public ZInvitationCluster[] newArray(int i) {
        return new ZInvitationCluster[i];
    }
}
