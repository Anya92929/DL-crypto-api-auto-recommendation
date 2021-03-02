package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C1204R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzqf {

    /* renamed from: a */
    private static Object f6897a = new Object();

    /* renamed from: b */
    private static zzqf f6898b;

    /* renamed from: c */
    private final String f6899c;

    /* renamed from: d */
    private final String f6900d;

    /* renamed from: e */
    private final Status f6901e;

    /* renamed from: f */
    private final String f6902f;

    /* renamed from: g */
    private final String f6903g;

    /* renamed from: h */
    private final String f6904h;

    /* renamed from: i */
    private final boolean f6905i;

    /* renamed from: j */
    private final boolean f6906j;

    zzqf(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1204R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.f6906j = z2 ? false : z;
            z = z2;
        } else {
            this.f6906j = false;
        }
        this.f6905i = z;
        zzai zzai = new zzai(context);
        this.f6902f = zzai.getString("firebase_database_url");
        this.f6904h = zzai.getString("google_storage_bucket");
        this.f6903g = zzai.getString("gcm_defaultSenderId");
        this.f6900d = zzai.getString("google_api_key");
        String zzcf = zzz.zzcf(context);
        zzcf = zzcf == null ? zzai.getString("google_app_id") : zzcf;
        if (TextUtils.isEmpty(zzcf)) {
            this.f6901e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f6899c = null;
            return;
        }
        this.f6899c = zzcf;
        this.f6901e = Status.f4328sq;
    }

    zzqf(String str, boolean z) {
        this(str, z, (String) null, (String) null, (String) null);
    }

    zzqf(String str, boolean z, String str2, String str3, String str4) {
        this.f6899c = str;
        this.f6900d = null;
        this.f6901e = Status.f4328sq;
        this.f6905i = z;
        this.f6906j = !z;
        this.f6902f = str2;
        this.f6903g = str4;
        this.f6904h = str3;
    }

    /* renamed from: b */
    private static zzqf m7511b(String str) {
        zzqf zzqf;
        synchronized (f6897a) {
            if (f6898b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            zzqf = f6898b;
        }
        return zzqf;
    }

    public static String zzaqo() {
        return m7511b("getGoogleAppId").f6899c;
    }

    public static boolean zzaqp() {
        return m7511b("isMeasurementExplicitlyDisabled").f6906j;
    }

    public static Status zzc(Context context, String str, boolean z) {
        Status status;
        zzab.zzb((Object) context, (Object) "Context must not be null.");
        zzab.zzh(str, "App ID must be nonempty.");
        synchronized (f6897a) {
            if (f6898b != null) {
                status = f6898b.mo8977a(str);
            } else {
                f6898b = new zzqf(str, z);
                status = f6898b.f6901e;
            }
        }
        return status;
    }

    public static Status zzcb(Context context) {
        Status status;
        zzab.zzb((Object) context, (Object) "Context must not be null.");
        synchronized (f6897a) {
            if (f6898b == null) {
                f6898b = new zzqf(context);
            }
            status = f6898b.f6901e;
        }
        return status;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Status mo8977a(String str) {
        if (this.f6899c == null || this.f6899c.equals(str)) {
            return Status.f4328sq;
        }
        String str2 = this.f6899c;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
