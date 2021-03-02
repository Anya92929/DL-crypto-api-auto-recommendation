package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.C1326ik;
import java.util.Collection;
import java.util.Locale;

public final class CastMediaControlIntent {
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    @Deprecated
    public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    private CastMediaControlIntent() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m390a(java.lang.String r4, java.lang.String r5, java.util.Collection<java.lang.String> r6) throws java.lang.IllegalArgumentException {
        /*
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>(r4)
            if (r5 == 0) goto L_0x0035
            java.lang.String r0 = r5.toUpperCase()
            java.lang.String r2 = "[A-F0-9]+"
            boolean r2 = r0.matches(r2)
            if (r2 != 0) goto L_0x002c
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid application ID: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x002c:
            java.lang.String r2 = "/"
            java.lang.StringBuffer r2 = r1.append(r2)
            r2.append(r0)
        L_0x0035:
            if (r6 == 0) goto L_0x0085
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x0045
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must specify at least one namespace"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            java.util.Iterator r2 = r6.iterator()
        L_0x0049:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x006f
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0067
            java.lang.String r0 = r0.trim()
            java.lang.String r3 = ""
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0049
        L_0x0067:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Namespaces must not be null or empty"
            r0.<init>(r1)
            throw r0
        L_0x006f:
            if (r5 != 0) goto L_0x0076
            java.lang.String r0 = "/"
            r1.append(r0)
        L_0x0076:
            java.lang.String r0 = "/"
            java.lang.StringBuffer r0 = r1.append(r0)
            java.lang.String r2 = ","
            java.lang.String r2 = android.text.TextUtils.join(r2, r6)
            r0.append(r2)
        L_0x0085:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastMediaControlIntent.m390a(java.lang.String, java.lang.String, java.util.Collection):java.lang.String");
    }

    public static String categoryForCast(String applicationId) throws IllegalArgumentException {
        if (applicationId != null) {
            return m390a(CATEGORY_CAST, applicationId, (Collection<String>) null);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    public static String categoryForCast(String applicationId, Collection<String> namespaces) {
        if (applicationId == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        } else if (namespaces != null) {
            return m390a(CATEGORY_CAST, applicationId, namespaces);
        } else {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
    }

    public static String categoryForCast(Collection<String> namespaces) throws IllegalArgumentException {
        if (namespaces != null) {
            return m390a(CATEGORY_CAST, (String) null, namespaces);
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }

    public static String categoryForRemotePlayback() {
        return m390a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", (String) null, (Collection<String>) null);
    }

    public static String categoryForRemotePlayback(String applicationId) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(applicationId)) {
            return m390a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", applicationId, (Collection<String>) null);
        }
        throw new IllegalArgumentException("applicationId cannot be null or empty");
    }

    public static String languageTagForLocale(Locale locale) {
        return C1326ik.m4988b(locale);
    }
}
