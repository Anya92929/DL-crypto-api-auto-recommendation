package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* renamed from: com.google.android.gms.internal.m */
public class C0607m {

    /* renamed from: bV */
    private static final Uri f1424bV = Uri.parse("http://plus.google.com/");

    /* renamed from: bW */
    private static final Uri f1425bW = f1424bV.buildUpon().appendPath("circles").appendPath("find").build();

    /* renamed from: i */
    public static Intent m1838i(String str) {
        Uri fromParts = Uri.fromParts("package", str, (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    /* renamed from: j */
    private static Uri m1839j(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }

    /* renamed from: k */
    public static Intent m1840k(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m1839j(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: l */
    public static Intent m1841l(String str) {
        Uri parse = Uri.parse("bazaar://search?q=pname:" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }
}
