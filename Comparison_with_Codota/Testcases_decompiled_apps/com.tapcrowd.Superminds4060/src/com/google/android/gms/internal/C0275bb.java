package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.bb */
public final class C0275bb {
    /* renamed from: a */
    public static int m554a(AdRequest.ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static int m555a(AdRequest.Gender gender) {
        switch (gender) {
            case FEMALE:
                return 2;
            case MALE:
                return 1;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static AdSize m556a(C0622x xVar) {
        return new AdSize(new com.google.android.gms.ads.AdSize(xVar.width, xVar.height, xVar.f1581ew));
    }

    /* renamed from: e */
    public static AdRequest.Gender m557e(int i) {
        switch (i) {
            case 1:
                return AdRequest.Gender.MALE;
            case 2:
                return AdRequest.Gender.FEMALE;
            default:
                return AdRequest.Gender.UNKNOWN;
        }
    }

    /* renamed from: e */
    public static MediationAdRequest m558e(C0620v vVar) {
        return new MediationAdRequest(new Date(vVar.f1577es), m557e(vVar.f1578et), vVar.f1579eu != null ? new HashSet(vVar.f1579eu) : null, vVar.f1580ev);
    }

    /* renamed from: f */
    public static final AdRequest.ErrorCode m559f(int i) {
        switch (i) {
            case 1:
                return AdRequest.ErrorCode.INVALID_REQUEST;
            case 2:
                return AdRequest.ErrorCode.NETWORK_ERROR;
            case 3:
                return AdRequest.ErrorCode.NO_FILL;
            default:
                return AdRequest.ErrorCode.INTERNAL_ERROR;
        }
    }
}
