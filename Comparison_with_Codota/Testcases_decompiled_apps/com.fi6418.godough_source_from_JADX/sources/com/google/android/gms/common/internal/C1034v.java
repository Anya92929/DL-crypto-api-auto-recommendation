package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.C0595b;
import com.google.android.gms.p018c.C0617af;

/* renamed from: com.google.android.gms.common.internal.v */
public final class C1034v {
    /* renamed from: a */
    public static final String m4640a(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0595b.common_google_play_services_install_title);
            case 2:
                return resources.getString(C0595b.common_google_play_services_update_title);
            case 3:
                return resources.getString(C0595b.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return resources.getString(C0595b.common_google_play_services_invalid_account_title);
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return resources.getString(C0595b.common_google_play_services_network_error_title);
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0595b.common_google_play_services_unsupported_title);
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return resources.getString(C0595b.common_google_play_services_sign_in_failed_title);
            case 18:
                return resources.getString(C0595b.common_google_play_services_updating_title);
            case 42:
                return resources.getString(C0595b.common_android_wear_update_title);
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
        }
    }

    /* renamed from: a */
    public static String m4641a(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                if (C0617af.m3560a(resources)) {
                    return resources.getString(C0595b.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C0595b.common_google_play_services_install_text_phone, new Object[]{str});
            case 2:
                return resources.getString(C0595b.common_google_play_services_update_text, new Object[]{str});
            case 3:
                return resources.getString(C0595b.common_google_play_services_enable_text, new Object[]{str});
            case 5:
                return resources.getString(C0595b.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0595b.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0595b.common_google_play_services_unsupported_text, new Object[]{str});
            case 16:
                return resources.getString(C0595b.common_google_play_services_api_unavailable_text, new Object[]{str});
            case 17:
                return resources.getString(C0595b.common_google_play_services_sign_in_failed_text);
            case 18:
                return resources.getString(C0595b.common_google_play_services_updating_text, new Object[]{str});
            case 42:
                return resources.getString(C0595b.common_android_wear_update_text, new Object[]{str});
            default:
                return resources.getString(C0595b.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: b */
    public static String m4642b(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0595b.common_google_play_services_install_button);
            case 2:
            case 42:
                return resources.getString(C0595b.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0595b.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
