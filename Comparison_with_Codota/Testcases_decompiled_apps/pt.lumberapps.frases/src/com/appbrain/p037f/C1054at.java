package com.appbrain.p037f;

import com.appbrain.p033b.C1014r;

/* renamed from: com.appbrain.f.at */
public enum C1054at {
    UNKNOWN_SOURCE(-1),
    DIRECT(0),
    INTERSTITIAL(1),
    MAYBE_INTERSTITIAL(2),
    BANNER(5),
    FRAGMENT(6),
    SKIPPED_INTERSTITIAL(7),
    APP_ALERT(8),
    DIRECT_CLICK(9),
    NO_PLAY_STORE(10),
    IN_STREAM_AD_LISTVIEW(16),
    SINGLE_APP_INTERSTITIAL(17),
    ADLIST_LISTVIEW(18),
    IN_STREAM_AD_RECYCLERVIEW(19),
    ADLIST_RECYCLERVIEW(20);
    

    /* renamed from: p */
    private static C1014r f2892p;

    /* renamed from: q */
    private final int f2894q;

    static {
        f2892p = new C1055au();
    }

    private C1054at(int i) {
        this.f2894q = i;
    }

    /* renamed from: a */
    public static C1054at m4682a(int i) {
        switch (i) {
            case -1:
                return UNKNOWN_SOURCE;
            case 0:
                return DIRECT;
            case 1:
                return INTERSTITIAL;
            case 2:
                return MAYBE_INTERSTITIAL;
            case 5:
                return BANNER;
            case 6:
                return FRAGMENT;
            case 7:
                return SKIPPED_INTERSTITIAL;
            case 8:
                return APP_ALERT;
            case 9:
                return DIRECT_CLICK;
            case 10:
                return NO_PLAY_STORE;
            case 16:
                return IN_STREAM_AD_LISTVIEW;
            case 17:
                return SINGLE_APP_INTERSTITIAL;
            case 18:
                return ADLIST_LISTVIEW;
            case 19:
                return IN_STREAM_AD_RECYCLERVIEW;
            case 20:
                return ADLIST_RECYCLERVIEW;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public final int mo4236a() {
        return this.f2894q;
    }
}
