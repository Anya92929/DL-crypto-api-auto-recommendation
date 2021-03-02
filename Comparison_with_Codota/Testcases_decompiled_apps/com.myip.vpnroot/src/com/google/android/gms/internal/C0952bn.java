package com.google.android.gms.internal;

import android.os.Bundle;

@C1130ez
/* renamed from: com.google.android.gms.internal.bn */
public final class C0952bn {

    /* renamed from: oX */
    public static C1342iv<String> f2906oX = m3998a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");

    /* renamed from: oY */
    public static C1342iv<String> f2907oY = m3998a("gads:sdk_core_experiment_id", (String) null);

    /* renamed from: oZ */
    public static C1342iv<Boolean> f2908oZ = m4000c("gads:sdk_crash_report_enabled", false);

    /* renamed from: pa */
    public static C1342iv<Boolean> f2909pa = m4000c("gads:sdk_crash_report_full_stacktrace", false);

    /* renamed from: pb */
    public static C1342iv<Boolean> f2910pb = m4000c("gads:block_autoclicks", false);

    /* renamed from: pc */
    public static C1342iv<String> f2911pc = m3998a("gads:block_autoclicks_experiment_id", (String) null);

    /* renamed from: pd */
    public static C1342iv<Boolean> f2912pd = m4000c("gads:enable_content_fetching", false);

    /* renamed from: pe */
    public static C1342iv<Integer> f2913pe = m3997a("gads:content_length_weight", 1);

    /* renamed from: pf */
    public static C1342iv<Integer> f2914pf = m3997a("gads:content_age_weight", 1);

    /* renamed from: pg */
    public static C1342iv<Integer> f2915pg = m3997a("gads:min_content_len", 11);

    /* renamed from: ph */
    public static C1342iv<Integer> f2916ph = m3997a("gads:fingerprint_number", 10);

    /* renamed from: pi */
    public static C1342iv<Integer> f2917pi = m3997a("gads:sleep_sec", 10);

    /* renamed from: pj */
    private static final Bundle f2918pj = new Bundle();

    /* renamed from: pk */
    private static boolean f2919pk;

    static {
        f2919pk = false;
        f2919pk = true;
    }

    /* renamed from: a */
    private static C1342iv<Integer> m3997a(String str, int i) {
        f2918pj.putInt(str, i);
        return C1342iv.m5083a(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    private static C1342iv<String> m3998a(String str, String str2) {
        f2918pj.putString(str, str2);
        return C1342iv.m5085m(str, str2);
    }

    /* renamed from: bs */
    public static Bundle m3999bs() {
        return f2918pj;
    }

    /* renamed from: c */
    private static C1342iv<Boolean> m4000c(String str, boolean z) {
        f2918pj.putBoolean(str, z);
        return C1342iv.m5084g(str, z);
    }
}
