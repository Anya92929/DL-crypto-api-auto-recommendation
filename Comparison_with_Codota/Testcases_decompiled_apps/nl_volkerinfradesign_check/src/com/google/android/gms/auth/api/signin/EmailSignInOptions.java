package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();

    /* renamed from: a */
    final int f2476a;

    /* renamed from: b */
    private final Uri f2477b;

    /* renamed from: c */
    private String f2478c;

    /* renamed from: d */
    private Uri f2479d;

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        zzx.zzb(uri, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), (Object) "Invalid server widget url");
        this.f2476a = i;
        this.f2477b = uri;
        this.f2478c = str;
        this.f2479d = uri2;
    }

    /* renamed from: a */
    private JSONObject m3617a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.f2477b.toString());
            if (!TextUtils.isEmpty(this.f2478c)) {
                jSONObject.put("modeQueryName", this.f2478c);
            }
            if (this.f2479d != null) {
                jSONObject.put("tosUrl", this.f2479d.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.f2477b.equals(emailSignInOptions.zzmF())) {
                return false;
            }
            if (this.f2479d == null) {
                if (emailSignInOptions.zzmG() != null) {
                    return false;
                }
            } else if (!this.f2479d.equals(emailSignInOptions.zzmG())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2478c)) {
                if (!TextUtils.isEmpty(emailSignInOptions.zzmH())) {
                    return false;
                }
            } else if (!this.f2478c.equals(emailSignInOptions.zzmH())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzp(this.f2477b).zzp(this.f2479d).zzp(this.f2478c).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m3642a(this, parcel, i);
    }

    public Uri zzmF() {
        return this.f2477b;
    }

    public Uri zzmG() {
        return this.f2479d;
    }

    public String zzmH() {
        return this.f2478c;
    }

    public String zzmI() {
        return m3617a().toString();
    }
}
