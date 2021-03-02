package com.google.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.util.C0304i;

/* renamed from: com.google.ads.m */
public class C0265m extends C0304i {

    /* renamed from: d */
    private static final C0265m f614d = new C0265m();

    /* renamed from: a */
    public final C0304i.C0308c<String> f615a = new C0304i.C0308c<>("marketPackages", null);

    /* renamed from: b */
    public final C0304i.C0307b<C0266a> f616b = new C0304i.C0307b<>("constants", new C0266a());

    /* renamed from: c */
    public final C0304i.C0307b<Handler> f617c = new C0304i.C0307b<>("uiHandler", new Handler(Looper.getMainLooper()));

    /* renamed from: com.google.ads.m$a */
    public static final class C0266a extends C0304i {

        /* renamed from: a */
        public final C0304i.C0308c<String> f618a = new C0304i.C0308c<>("ASDomains", null);

        /* renamed from: b */
        public final C0304i.C0308c<Integer> f619b = new C0304i.C0308c<>("minHwAccelerationVersionBanner", 18);

        /* renamed from: c */
        public final C0304i.C0308c<Integer> f620c = new C0304i.C0308c<>("minHwAccelerationVersionOverlay", 18);

        /* renamed from: d */
        public final C0304i.C0308c<Integer> f621d = new C0304i.C0308c<>("minHwAccelerationVersionOverlay", 14);

        /* renamed from: e */
        public final C0304i.C0308c<String> f622e = new C0304i.C0308c<>("mraidBannerPath", "http://media.admob.com/mraid/v1/mraid_app_banner.js");

        /* renamed from: f */
        public final C0304i.C0308c<String> f623f = new C0304i.C0308c<>("mraidExpandedBannerPath", "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");

        /* renamed from: g */
        public final C0304i.C0308c<String> f624g = new C0304i.C0308c<>("mraidInterstitialPath", "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");

        /* renamed from: h */
        public final C0304i.C0308c<String> f625h = new C0304i.C0308c<>("badAdReportPath", "https://badad.googleplex.com/s/reportAd");

        /* renamed from: i */
        public final C0304i.C0308c<Long> f626i = new C0304i.C0308c<>("appCacheMaxSize", 0L);

        /* renamed from: j */
        public final C0304i.C0308c<Long> f627j = new C0304i.C0308c<>("appCacheMaxSizePaddingInBytes", 131072L);

        /* renamed from: k */
        public final C0304i.C0308c<Long> f628k = new C0304i.C0308c<>("maxTotalAppCacheQuotaInBytes", 5242880L);

        /* renamed from: l */
        public final C0304i.C0308c<Long> f629l = new C0304i.C0308c<>("maxTotalDatabaseQuotaInBytes", 5242880L);

        /* renamed from: m */
        public final C0304i.C0308c<Long> f630m = new C0304i.C0308c<>("maxDatabaseQuotaPerOriginInBytes", 1048576L);

        /* renamed from: n */
        public final C0304i.C0308c<Long> f631n = new C0304i.C0308c<>("databaseQuotaIncreaseStepInBytes", 131072L);

        /* renamed from: o */
        public final C0304i.C0308c<Boolean> f632o = new C0304i.C0308c<>("isInitialized", false);
    }

    /* renamed from: a */
    public static C0265m m411a() {
        return f614d;
    }

    private C0265m() {
    }
}
