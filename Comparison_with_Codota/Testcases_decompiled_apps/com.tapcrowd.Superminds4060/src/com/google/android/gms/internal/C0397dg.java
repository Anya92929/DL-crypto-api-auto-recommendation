package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;

/* renamed from: com.google.android.gms.internal.dg */
public class C0397dg {

    /* renamed from: lg */
    private static final Uri f1129lg = Uri.parse("http://plus.google.com/");

    /* renamed from: lh */
    private static final Uri f1130lh = f1129lg.buildUpon().appendPath("circles").appendPath("find").build();

    /* renamed from: A */
    private static Uri m890A(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter(DBFavorites.KEY_EVENT_ID, str).build();
    }

    /* renamed from: B */
    public static Intent m891B(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m890A(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: C */
    public static Intent m892C(String str) {
        Uri parse = Uri.parse("bazaar://search?q=pname:" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.setFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    /* renamed from: bj */
    public static Intent m893bj() {
        return new Intent("android.settings.DATE_SETTINGS");
    }

    /* renamed from: z */
    public static Intent m894z(String str) {
        Uri fromParts = Uri.fromParts("package", str, (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
}
