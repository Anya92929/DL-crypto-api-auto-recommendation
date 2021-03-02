package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Parcelable.Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3746a(QuestEntity questEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) questEntity.getGame(), i, false);
        C0354b.m927a(parcel, 2, questEntity.getQuestId(), false);
        C0354b.m919a(parcel, 3, questEntity.getAcceptedTimestamp());
        C0354b.m923a(parcel, 4, (Parcelable) questEntity.getBannerImageUri(), i, false);
        C0354b.m927a(parcel, 5, questEntity.getBannerImageUrl(), false);
        C0354b.m927a(parcel, 6, questEntity.getDescription(), false);
        C0354b.m919a(parcel, 7, questEntity.getEndTimestamp());
        C0354b.m919a(parcel, 8, questEntity.getLastUpdatedTimestamp());
        C0354b.m923a(parcel, 9, (Parcelable) questEntity.getIconImageUri(), i, false);
        C0354b.m927a(parcel, 10, questEntity.getIconImageUrl(), false);
        C0354b.m927a(parcel, 12, questEntity.getName(), false);
        C0354b.m919a(parcel, 13, questEntity.mo7731lI());
        C0354b.m919a(parcel, 14, questEntity.getStartTimestamp());
        C0354b.m939c(parcel, 15, questEntity.getState());
        C0354b.m940c(parcel, 17, questEntity.mo7730lH(), false);
        C0354b.m939c(parcel, 16, questEntity.getType());
        C0354b.m939c(parcel, 1000, questEntity.getVersionCode());
        C0354b.m915H(parcel, D);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    gameEntity = (GameEntity) C0352a.m880a(parcel, B, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 7:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 8:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 9:
                    uri2 = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 10:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 12:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 13:
                    j4 = C0352a.m894i(parcel, B);
                    break;
                case 14:
                    j5 = C0352a.m894i(parcel, B);
                    break;
                case 15:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 16:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 17:
                    arrayList = C0352a.m887c(parcel, B, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public QuestEntity[] newArray(int size) {
        return new QuestEntity[size];
    }
}
