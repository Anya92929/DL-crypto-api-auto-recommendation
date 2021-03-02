package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzp();

    /* renamed from: a */
    final int f2518a;

    /* renamed from: b */
    private final String f2519b;

    /* renamed from: c */
    private String f2520c;

    /* renamed from: d */
    private EmailSignInOptions f2521d;

    /* renamed from: e */
    private GoogleSignInOptions f2522e;

    /* renamed from: f */
    private String f2523f;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        this.f2518a = i;
        this.f2519b = zzx.zzcM(str);
        this.f2520c = str2;
        this.f2521d = emailSignInOptions;
        this.f2522e = googleSignInOptions;
        this.f2523f = str3;
    }

    public SignInConfiguration(String str) {
        this(2, str, (String) null, (EmailSignInOptions) null, (GoogleSignInOptions) null, (String) null);
    }

    /* renamed from: a */
    private JSONObject m3632a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.f2519b);
            if (!TextUtils.isEmpty(this.f2520c)) {
                jSONObject.put("serverClientId", this.f2520c);
            }
            if (this.f2521d != null) {
                jSONObject.put("emailSignInOptions", this.f2521d.zzmI());
            }
            if (this.f2522e != null) {
                jSONObject.put("googleSignInOptions", this.f2522e.zzmI());
            }
            if (!TextUtils.isEmpty(this.f2523f)) {
                jSONObject.put("apiKey", this.f2523f);
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
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.f2519b.equals(signInConfiguration.zznk())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2520c)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzmR())) {
                    return false;
                }
            } else if (!this.f2520c.equals(signInConfiguration.zzmR())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2523f)) {
                if (!TextUtils.isEmpty(signInConfiguration.zznn())) {
                    return false;
                }
            } else if (!this.f2523f.equals(signInConfiguration.zznn())) {
                return false;
            }
            if (this.f2521d == null) {
                if (signInConfiguration.zznl() != null) {
                    return false;
                }
            } else if (!this.f2521d.equals(signInConfiguration.zznl())) {
                return false;
            }
            if (this.f2522e == null) {
                if (signInConfiguration.zznm() != null) {
                    return false;
                }
            } else if (!this.f2522e.equals(signInConfiguration.zznm())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzp(this.f2519b).zzp(this.f2520c).zzp(this.f2523f).zzp(this.f2521d).zzp(this.f2522e).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.m3633a(this, parcel, i);
    }

    public SignInConfiguration zzj(GoogleSignInOptions googleSignInOptions) {
        this.f2522e = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmI() {
        return m3632a().toString();
    }

    public String zzmR() {
        return this.f2520c;
    }

    public String zznk() {
        return this.f2519b;
    }

    public EmailSignInOptions zznl() {
        return this.f2521d;
    }

    public GoogleSignInOptions zznm() {
        return this.f2522e;
    }

    public String zznn() {
        return this.f2523f;
    }
}
