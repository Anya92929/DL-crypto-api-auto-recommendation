package com.google.android.gms.internal;

import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.jg */
/* synthetic */ class C1658jg {

    /* renamed from: a */
    static final /* synthetic */ int[] f5170a = new int[AdRequest.Gender.values().length];

    /* renamed from: b */
    static final /* synthetic */ int[] f5171b = new int[AdRequest.ErrorCode.values().length];

    static {
        try {
            f5171b[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5171b[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5171b[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5171b[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5170a[AdRequest.Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5170a[AdRequest.Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f5170a[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
