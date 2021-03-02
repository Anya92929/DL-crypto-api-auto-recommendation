package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Parcelable.Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m2194a(EventEntity eventEntity, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, eventEntity.getEventId(), false);
        C0354b.m939c(parcel, 1000, eventEntity.getVersionCode());
        C0354b.m927a(parcel, 2, eventEntity.getName(), false);
        C0354b.m927a(parcel, 3, eventEntity.getDescription(), false);
        C0354b.m923a(parcel, 4, (Parcelable) eventEntity.getIconImageUri(), i, false);
        C0354b.m927a(parcel, 5, eventEntity.getIconImageUrl(), false);
        C0354b.m923a(parcel, 6, (Parcelable) eventEntity.getPlayer(), i, false);
        C0354b.m919a(parcel, 7, eventEntity.getValue());
        C0354b.m927a(parcel, 8, eventEntity.getFormattedValue(), false);
        C0354b.m930a(parcel, 9, eventEntity.isVisible());
        C0354b.m915H(parcel, D);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int C = C0352a.m875C(parcel);
        long j = 0;
        PlayerEntity playerEntity = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str5 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    str4 = C0352a.m900o(parcel, B);
                    break;
                case 3:
                    str3 = C0352a.m900o(parcel, B);
                    break;
                case 4:
                    uri = (Uri) C0352a.m880a(parcel, B, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 6:
                    playerEntity = (PlayerEntity) C0352a.m880a(parcel, B, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 8:
                    str = C0352a.m900o(parcel, B);
                    break;
                case 9:
                    z = C0352a.m888c(parcel, B);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, playerEntity, j, str, z);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
