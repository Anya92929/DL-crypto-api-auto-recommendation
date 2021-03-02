package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;

public class MilestoneEntityCreator implements Parcelable.Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3734a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        C0354b.m939c(parcel, 1000, milestoneEntity.getVersionCode());
        C0354b.m919a(parcel, 2, milestoneEntity.getCurrentProgress());
        C0354b.m919a(parcel, 3, milestoneEntity.getTargetProgress());
        C0354b.m931a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        C0354b.m939c(parcel, 5, milestoneEntity.getState());
        C0354b.m927a(parcel, 6, milestoneEntity.getEventId(), false);
        C0354b.m915H(parcel, D);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    bArr = C0352a.m903r(parcel, B);
                    break;
                case 5:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 1000:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                default:
                    C0352a.m885b(parcel, B);
                    break;
            }
        }
        if (parcel.dataPosition() == C) {
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
