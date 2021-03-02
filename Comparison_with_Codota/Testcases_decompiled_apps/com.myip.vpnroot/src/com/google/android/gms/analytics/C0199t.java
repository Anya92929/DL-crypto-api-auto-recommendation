package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.t */
class C0199t {

    /* renamed from: ze */
    private static final C0199t f249ze = new C0199t();

    /* renamed from: zb */
    private SortedSet<C0200a> f250zb = new TreeSet();

    /* renamed from: zc */
    private StringBuilder f251zc = new StringBuilder();

    /* renamed from: zd */
    private boolean f252zd = false;

    /* renamed from: com.google.android.gms.analytics.t$a */
    public enum C0200a {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    private C0199t() {
    }

    /* renamed from: eq */
    public static C0199t m276eq() {
        return f249ze;
    }

    /* renamed from: B */
    public synchronized void mo3730B(boolean z) {
        this.f252zd = z;
    }

    /* renamed from: a */
    public synchronized void mo3731a(C0200a aVar) {
        if (!this.f252zd) {
            this.f250zb.add(aVar);
            this.f251zc.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(aVar.ordinal()));
        }
    }

    /* renamed from: er */
    public synchronized String mo3732er() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.f250zb.size() > 0) {
            C0200a first = this.f250zb.first();
            this.f250zb.remove(first);
            int ordinal = first.ordinal();
            while (ordinal >= i) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (first.ordinal() % 6);
        }
        if (i2 > 0 || sb.length() == 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.f250zb.clear();
        return sb.toString();
    }

    /* renamed from: es */
    public synchronized String mo3733es() {
        String sb;
        if (this.f251zc.length() > 0) {
            this.f251zc.insert(0, ".");
        }
        sb = this.f251zc.toString();
        this.f251zc = new StringBuilder();
        return sb;
    }
}
