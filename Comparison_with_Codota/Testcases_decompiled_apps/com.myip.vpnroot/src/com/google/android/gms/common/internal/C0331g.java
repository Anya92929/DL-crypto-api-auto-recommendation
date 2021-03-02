package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* renamed from: com.google.android.gms.common.internal.g */
public class C0331g {

    /* renamed from: LV */
    private static final Uri f787LV = Uri.parse("http://plus.google.com/");

    /* renamed from: LW */
    private static final Uri f788LW = f787LV.buildUpon().appendPath("circles").appendPath("find").build();

    /* renamed from: aW */
    public static Intent m745aW(String str) {
        Uri fromParts = Uri.fromParts("package", str, (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    /* renamed from: aX */
    private static Uri m746aX(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }

    /* renamed from: aY */
    public static Intent m747aY(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m746aX(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: gZ */
    public static Intent m748gZ() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
