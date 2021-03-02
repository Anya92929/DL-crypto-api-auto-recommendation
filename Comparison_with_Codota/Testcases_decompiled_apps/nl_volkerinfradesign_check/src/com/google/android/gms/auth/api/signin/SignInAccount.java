package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zze();

    /* renamed from: a */
    final int f2509a;

    /* renamed from: b */
    private String f2510b;

    /* renamed from: c */
    private String f2511c;

    /* renamed from: d */
    private String f2512d;

    /* renamed from: e */
    private String f2513e;

    /* renamed from: f */
    private Uri f2514f;

    /* renamed from: g */
    private GoogleSignInAccount f2515g;

    /* renamed from: h */
    private String f2516h;

    /* renamed from: i */
    private String f2517i;

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.f2509a = i;
        this.f2512d = zzx.zzh(str3, "Email cannot be empty.");
        this.f2513e = str4;
        this.f2514f = uri;
        this.f2510b = str;
        this.f2511c = str2;
        this.f2515g = googleSignInAccount;
        this.f2516h = zzx.zzcM(str5);
        this.f2517i = str6;
    }

    /* renamed from: b */
    private JSONObject m3630b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", getEmail());
            if (!TextUtils.isEmpty(this.f2513e)) {
                jSONObject.put("displayName", this.f2513e);
            }
            if (this.f2514f != null) {
                jSONObject.put("photoUrl", this.f2514f.toString());
            }
            if (!TextUtils.isEmpty(this.f2510b)) {
                jSONObject.put("providerId", this.f2510b);
            }
            if (!TextUtils.isEmpty(this.f2511c)) {
                jSONObject.put("tokenId", this.f2511c);
            }
            if (this.f2515g != null) {
                jSONObject.put("googleSignInAccount", this.f2515g.zzmI());
            }
            if (!TextUtils.isEmpty(this.f2517i)) {
                jSONObject.put("refreshToken", this.f2517i);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static SignInAccount zza(zzd zzd, String str, String str2, String str3, Uri uri, String str4, String str5) {
        String str6 = null;
        if (zzd != null) {
            str6 = zzd.zzmT();
        }
        return new SignInAccount(2, str6, str, str2, str3, uri, (GoogleSignInAccount) null, str4, str5);
    }

    public static SignInAccount zzbM(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        return zza(zzd.zzbL(jSONObject.optString("providerId", (String) null)), jSONObject.optString("tokenId", (String) null), jSONObject.getString("email"), jSONObject.optString("displayName", (String) null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbH(jSONObject.optString("googleSignInAccount")));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo4836a() {
        return this.f2510b;
    }

    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.f2513e;
    }

    public String getEmail() {
        return this.f2512d;
    }

    public String getIdToken() {
        return this.f2511c;
    }

    public Uri getPhotoUrl() {
        return this.f2514f;
    }

    public String getUserId() {
        return this.f2516h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m3645a(this, parcel, i);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.f2515g = googleSignInAccount;
        return this;
    }

    public String zzmI() {
        return m3630b().toString();
    }

    public zzd zzmU() {
        return zzd.zzbL(this.f2510b);
    }

    public GoogleSignInAccount zzmV() {
        return this.f2515g;
    }

    public String zzmW() {
        return this.f2517i;
    }
}
