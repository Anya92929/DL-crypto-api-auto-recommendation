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
    final int versionCode;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWk;
    private String zzXj;
    private GoogleSignInAccount zzXm;
    private String zzXn;
    private String zzrG;

    SignInAccount(int versionCode2, String providerId, String idToken, String email, String displayName, Uri photoUrl, GoogleSignInAccount googleSignInAccount, String userId, String refreshToken) {
        this.versionCode = versionCode2;
        this.zzWP = zzx.zzh(email, "Email cannot be empty.");
        this.zzWQ = displayName;
        this.zzWR = photoUrl;
        this.zzXj = providerId;
        this.zzWk = idToken;
        this.zzXm = googleSignInAccount;
        this.zzrG = zzx.zzcM(userId);
        this.zzXn = refreshToken;
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

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", getEmail());
            if (!TextUtils.isEmpty(this.zzWQ)) {
                jSONObject.put("displayName", this.zzWQ);
            }
            if (this.zzWR != null) {
                jSONObject.put("photoUrl", this.zzWR.toString());
            }
            if (!TextUtils.isEmpty(this.zzXj)) {
                jSONObject.put("providerId", this.zzXj);
            }
            if (!TextUtils.isEmpty(this.zzWk)) {
                jSONObject.put("tokenId", this.zzWk);
            }
            if (this.zzXm != null) {
                jSONObject.put("googleSignInAccount", this.zzXm.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXn)) {
                jSONObject.put("refreshToken", this.zzXn);
            }
            jSONObject.put("localId", getUserId());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public String getEmail() {
        return this.zzWP;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    public String getUserId() {
        return this.zzrG;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    public SignInAccount zza(GoogleSignInAccount googleSignInAccount) {
        this.zzXm = googleSignInAccount;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    /* access modifiers changed from: package-private */
    public String zzmT() {
        return this.zzXj;
    }

    public zzd zzmU() {
        return zzd.zzbL(this.zzXj);
    }

    public GoogleSignInAccount zzmV() {
        return this.zzXm;
    }

    public String zzmW() {
        return this.zzXn;
    }
}
