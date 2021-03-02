package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.support.p009v4.p019f.C0150o;
import android.support.p021v7.p023b.C0515k;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C1204R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.zzi;

public final class zzh {

    /* renamed from: a */
    private static final C0150o f4584a = new C0150o();

    /* renamed from: a */
    private static String m6112a(Context context, String str) {
        synchronized (f4584a) {
            String str2 = (String) f4584a.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            f4584a.put(str, string);
            return string;
        }
    }

    /* renamed from: a */
    private static String m6113a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String a = m6112a(context, str);
        if (a == null) {
            a = resources.getString(C1204R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, a, new Object[]{str2});
    }

    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                if (zzi.zzb(resources)) {
                    return resources.getString(C1204R.string.common_google_play_services_install_text_tablet, new Object[]{str});
                }
                return resources.getString(C1204R.string.common_google_play_services_install_text_phone, new Object[]{str});
            case 2:
                return resources.getString(C1204R.string.common_google_play_services_update_text, new Object[]{str});
            case 3:
                return resources.getString(C1204R.string.common_google_play_services_enable_text, new Object[]{str});
            case 5:
                return m6113a(context, "common_google_play_services_invalid_account_text", str);
            case 7:
                return m6113a(context, "common_google_play_services_network_error_text", str);
            case 9:
                return resources.getString(C1204R.string.common_google_play_services_unsupported_text, new Object[]{str});
            case 16:
                return m6113a(context, "common_google_play_services_api_unavailable_text", str);
            case 17:
                return m6113a(context, "common_google_play_services_sign_in_failed_text", str);
            case 18:
                return resources.getString(C1204R.string.common_google_play_services_updating_text, new Object[]{str});
            case 20:
                return m6113a(context, "common_google_play_services_restricted_profile_text", str);
            case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                return resources.getString(C1204R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C1204R.string.common_google_play_services_unknown_issue, new Object[]{str});
        }
    }

    public static String zzd(Context context, int i, String str) {
        return i == 6 ? m6113a(context, "common_google_play_services_resolution_required_text", str) : zzc(context, i, str);
    }

    public static String zzf(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C1204R.string.common_google_play_services_install_title);
            case 2:
            case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                return resources.getString(C1204R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(C1204R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return m6112a(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return m6112a(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C1204R.string.common_google_play_services_unsupported_title);
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
                return m6112a(context, "common_google_play_services_sign_in_failed_title");
            case 18:
                return resources.getString(C1204R.string.common_google_play_services_updating_title);
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return m6112a(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", new StringBuilder(33).append("Unexpected error code ").append(i).toString());
                return null;
        }
    }

    public static String zzg(Context context, int i) {
        return i == 6 ? m6112a(context, "common_google_play_services_resolution_required_title") : zzf(context, i);
    }

    public static String zzh(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C1204R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C1204R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C1204R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }
}
