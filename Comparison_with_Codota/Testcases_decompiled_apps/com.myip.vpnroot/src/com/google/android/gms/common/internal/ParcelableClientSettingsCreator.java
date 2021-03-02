package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import java.util.ArrayList;

public class ParcelableClientSettingsCreator implements Parcelable.Creator<ClientSettings.ParcelableClientSettings> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m677a(ClientSettings.ParcelableClientSettings parcelableClientSettings, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m927a(parcel, 1, parcelableClientSettings.getAccountName(), false);
        C0354b.m939c(parcel, 1000, parcelableClientSettings.getVersionCode());
        C0354b.m938b(parcel, 2, parcelableClientSettings.getScopes(), false);
        C0354b.m939c(parcel, 3, parcelableClientSettings.getGravityForPopups());
        C0354b.m927a(parcel, 4, parcelableClientSettings.getRealClientPackageName(), false);
        C0354b.m915H(parcel, D);
    }

    public ClientSettings.ParcelableClientSettings createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int C = C0352a.m875C(parcel);
        ArrayList<String> arrayList = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    str2 = C0352a.m900o(parcel, B);
                    break;
                case 2:
                    arrayList = C0352a.m876C(parcel, B);
                    break;
                case 3:
                    i = C0352a.m892g(parcel, B);
                    break;
                case 4:
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
            return new ClientSettings.ParcelableClientSettings(i2, str2, arrayList, i, str);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    public ClientSettings.ParcelableClientSettings[] newArray(int size) {
        return new ClientSettings.ParcelableClientSettings[size];
    }
}
