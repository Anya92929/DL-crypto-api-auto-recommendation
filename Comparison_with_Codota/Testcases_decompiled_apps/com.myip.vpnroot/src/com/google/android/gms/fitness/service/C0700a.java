package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0352a;
import com.google.android.gms.common.internal.safeparcel.C0354b;
import com.google.android.gms.fitness.data.DataSource;

/* renamed from: com.google.android.gms.fitness.service.a */
public class C0700a implements Parcelable.Creator<FitnessSensorServiceRequest> {
    /* renamed from: a */
    static void m2131a(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int D = C0354b.m912D(parcel);
        C0354b.m923a(parcel, 1, (Parcelable) fitnessSensorServiceRequest.getDataSource(), i, false);
        C0354b.m939c(parcel, 1000, fitnessSensorServiceRequest.getVersionCode());
        C0354b.m921a(parcel, 2, fitnessSensorServiceRequest.mo6317jq(), false);
        C0354b.m919a(parcel, 3, fitnessSensorServiceRequest.getSamplingRateMicros());
        C0354b.m919a(parcel, 4, fitnessSensorServiceRequest.getBatchIntervalMicros());
        C0354b.m915H(parcel, D);
    }

    /* renamed from: cc */
    public FitnessSensorServiceRequest createFromParcel(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int C = C0352a.m875C(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < C) {
            int B = C0352a.m873B(parcel);
            switch (C0352a.m884aD(B)) {
                case 1:
                    dataSource = (DataSource) C0352a.m880a(parcel, B, DataSource.CREATOR);
                    break;
                case 2:
                    iBinder = C0352a.m901p(parcel, B);
                    break;
                case 3:
                    j2 = C0352a.m894i(parcel, B);
                    break;
                case 4:
                    j = C0352a.m894i(parcel, B);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new C0352a.C0353a("Overread allowed size end=" + C, parcel);
    }

    /* renamed from: du */
    public FitnessSensorServiceRequest[] newArray(int i) {
        return new FitnessSensorServiceRequest[i];
    }
}
