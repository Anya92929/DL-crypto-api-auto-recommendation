package com.google.ads;

import com.google.ads.util.i;

public class l extends i {
    private static final l b = new l();
    public final i.b<a> a = new i.b<>("constants", new a());

    public static final class a extends i {
        public final i.c<Integer> a = new i.c<>("minHwAccelerationVersionBanner", 16);
        public final i.c<Integer> b = new i.c<>("minHwAccelerationVersionOverlay", 14);
        public final i.c<String> c = new i.c<>("mraidBannerPath", "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        public final i.c<String> d = new i.c<>("mraidExpandedBannerPath", "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
        public final i.c<String> e = new i.c<>("mraidInterstitialPath", "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
        public final i.c<Long> f = new i.c<>("appCacheMaxSize", 0L);
        public final i.c<Long> g = new i.c<>("appCacheMaxSizePaddingInBytes", 131072L);
        public final i.c<Long> h = new i.c<>("maxTotalAppCacheQuotaInBytes", 5242880L);
        public final i.c<Long> i = new i.c<>("maxTotalDatabaseQuotaInBytes", 5242880L);
        public final i.c<Long> j = new i.c<>("maxDatabaseQuotaPerOriginInBytes", 1048576L);
        public final i.c<Long> k = new i.c<>("databaseQuotaIncreaseStepInBytes", 131072L);
        public final i.c<Boolean> l = new i.c<>("isInitialized", false);
    }

    public static l a() {
        return b;
    }

    private l() {
    }
}
