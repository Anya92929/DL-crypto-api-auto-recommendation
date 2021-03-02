package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.C0666R;
import com.google.android.gms.auth.api.credentials.IdentityProviders;

public enum zzd {
    GOOGLE("google.com", C0666R.string.auth_google_play_services_client_google_display_name, IdentityProviders.GOOGLE),
    FACEBOOK("facebook.com", C0666R.string.auth_google_play_services_client_facebook_display_name, IdentityProviders.FACEBOOK);
    

    /* renamed from: a */
    private final String f2531a;

    /* renamed from: b */
    private final int f2532b;

    /* renamed from: c */
    private final String f2533c;

    private zzd(String str, int i, String str2) {
        this.f2531a = str;
        this.f2532b = i;
        this.f2533c = str2;
    }

    public static zzd zzbL(String str) {
        if (str != null) {
            for (zzd zzd : values()) {
                if (zzd.zzmT().equals(str)) {
                    return zzd;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + str);
        }
        return null;
    }

    public String toString() {
        return this.f2531a;
    }

    public CharSequence zzae(Context context) {
        return context.getResources().getString(this.f2532b);
    }

    public String zzmT() {
        return this.f2531a;
    }
}
