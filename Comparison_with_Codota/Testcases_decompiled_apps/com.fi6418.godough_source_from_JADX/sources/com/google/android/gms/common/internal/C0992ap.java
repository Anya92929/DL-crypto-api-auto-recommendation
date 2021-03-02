package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;

/* renamed from: com.google.android.gms.common.internal.ap */
public class C0992ap {

    /* renamed from: a */
    private static final Uri f4715a = Uri.parse("http://plus.google.com/");

    /* renamed from: b */
    private static final Uri f4716b = f4715a.buildUpon().appendPath("circles").appendPath("find").build();

    /* renamed from: a */
    public static Intent m4415a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    /* renamed from: a */
    public static Intent m4416a(String str) {
        Uri fromParts = Uri.fromParts("package", str, (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    /* renamed from: b */
    public static Intent m4417b(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(m4418c(str));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    /* renamed from: c */
    private static Uri m4418c(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", str).build();
    }
}
