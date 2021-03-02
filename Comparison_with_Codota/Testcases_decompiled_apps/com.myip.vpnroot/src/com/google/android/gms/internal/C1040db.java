package com.google.android.gms.internal;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0139a;
import java.util.Date;
import java.util.HashSet;

@C1130ez
/* renamed from: com.google.android.gms.internal.db */
public final class C1040db {

    /* renamed from: com.google.android.gms.internal.db$1 */
    static /* synthetic */ class C10411 {

        /* renamed from: qK */
        static final /* synthetic */ int[] f3103qK = new int[AdRequest.Gender.values().length];

        static {
            f3104qL = new int[AdRequest.ErrorCode.values().length];
            try {
                f3104qL[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3104qL[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3104qL[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3104qL[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3103qK[AdRequest.Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3103qK[AdRequest.Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3103qK[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* renamed from: a */
    public static int m4188a(AdRequest.ErrorCode errorCode) {
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

    /* renamed from: b */
    public static AdSize m4189b(C0927ay ayVar) {
        AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
        for (int i = 0; i < adSizeArr.length; i++) {
            if (adSizeArr[i].getWidth() == ayVar.width && adSizeArr[i].getHeight() == ayVar.height) {
                return adSizeArr[i];
            }
        }
        return new AdSize(C0139a.m20a(ayVar.width, ayVar.height, ayVar.f2622of));
    }

    /* renamed from: d */
    public static MediationAdRequest m4190d(C0924av avVar) {
        return new MediationAdRequest(new Date(avVar.f2610nT), m4191k(avVar.f2611nU), avVar.f2612nV != null ? new HashSet(avVar.f2612nV) : null, avVar.f2613nW, avVar.f2618ob);
    }

    /* renamed from: k */
    public static AdRequest.Gender m4191k(int i) {
        switch (i) {
            case 1:
                return AdRequest.Gender.MALE;
            case 2:
                return AdRequest.Gender.FEMALE;
            default:
                return AdRequest.Gender.UNKNOWN;
        }
    }
}
