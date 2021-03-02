package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* renamed from: com.google.android.gms.internal.eo */
public final class C0488eo {
    /* renamed from: c */
    public static final Intent m1238c(Intent intent) {
        intent.setData(Uri.fromParts("version", Integer.toString(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), (String) null));
        return intent;
    }
}
