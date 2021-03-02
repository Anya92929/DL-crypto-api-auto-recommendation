package com.jackhenry.godough.core.login;

import com.jackhenry.godough.core.model.Redirect;

/* renamed from: com.jackhenry.godough.core.login.af */
/* synthetic */ class C1634af {

    /* renamed from: a */
    static final /* synthetic */ int[] f6377a = new int[Redirect.RedirectType.values().length];

    static {
        try {
            f6377a[Redirect.RedirectType.MFA.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6377a[Redirect.RedirectType.SELFENROLLMENT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6377a[Redirect.RedirectType.TERMSANDCONDITIONS.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f6377a[Redirect.RedirectType.EMAILCHANGE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f6377a[Redirect.RedirectType.CREDENTIALS.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f6377a[Redirect.RedirectType.RDATERMSANDCONDITIONS.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f6377a[Redirect.RedirectType.RDACOLLECTTERMSANDCONDITIONS.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f6377a[Redirect.RedirectType.RDAREGISTRATION.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f6377a[Redirect.RedirectType.OFFLINE.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
    }
}
