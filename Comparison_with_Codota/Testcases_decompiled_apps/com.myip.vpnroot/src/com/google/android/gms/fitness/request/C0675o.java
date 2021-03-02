package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.fitness.request.o */
public class C0675o implements Parcelable.Creator<C0674n> {
    /* renamed from: a */
    static void m2044a(C0674n nVar, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) nVar.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, nVar.getVersionCode());
        C0354b.m923a(parcel, 2, (Parcelable) nVar.getDataType(), i, false);
        C0354b.m921a(parcel, 3, nVar.mo6138jq(), false);
        C0354b.m939c(parcel, 4, nVar.f1539Uq);
        C0354b.m939c(parcel, 5, nVar.f1540Ur);
        C0354b.m919a(parcel, 6, nVar.getSamplingRateMicros());
        C0354b.m919a(parcel, 7, nVar.mo6135jn());
        C0354b.m923a(parcel, 8, (Parcelable) nVar.mo6133jl(), i, false);
        C0354b.m919a(parcel, 9, nVar.mo6134jm());
        C0354b.m939c(parcel, 10, nVar.mo6132iQ());
        C0354b.m940c(parcel, 11, nVar.mo6136jo(), false);
        C0354b.m919a(parcel, 12, nVar.mo6137jp());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: bI */
    public C0674n createFromParcel(Parcel parcel) {
        int C = C0352a.m875C(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        ArrayList arrayList = null;
        long j4 = 0;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) C0352a.m880a(parcel, B, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 4:
                    i2 = C0352a.m892g(parcel, B);
                    break;
                case 5:
                    i3 = C0352a.m892g(parcel, B);
                    break;
                case 6:
                    j = C0352a.m894i(parcel, B);
                    break;
                case 7:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) C0352a.m880a(parcel, B, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = C0352a.m894i(parcel, B);
                    break;
                case 10:
                    i4 = C0352a.m892g(parcel, B);
                    break;
                case 11:
                    arrayList = C0352a.m887c(parcel, B, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = C0352a.m894i(parcel, B);
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
            return new C0674n(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, arrayList, j4);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: cZ */
    public C0674n[] newArray(int i) {
        return new C0674n[i];
    }
}
