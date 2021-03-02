package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzb();
    public static zzmq zzWO = zzmt.zzsc();
    private static Comparator<Scope> zzWV = new Comparator<Scope>() {
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzpb().compareTo(scope2.zzpb());
        }
    };
    final int versionCode;
    List<Scope> zzVs;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWS;
    private long zzWT;
    private String zzWU;
    private String zzWk;
    private String zzyv;

    GoogleSignInAccount(int versionCode2, String id, String idToken, String email, String displayName, Uri photoUrl, String serverAuthCode, long expirationTimeSecs, String obfuscatedIdentifier, List<Scope> grantedScopes) {
        this.versionCode = versionCode2;
        this.zzyv = id;
        this.zzWk = idToken;
        this.zzWP = email;
        this.zzWQ = displayName;
        this.zzWR = photoUrl;
        this.zzWS = serverAuthCode;
        this.zzWT = expirationTimeSecs;
        this.zzWU = obfuscatedIdentifier;
        this.zzVs = grantedScopes;
    }

    public static GoogleSignInAccount zza(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable Long l, @NonNull String str5, @NonNull Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(zzWO.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, (String) null, l.longValue(), zzx.zzcM(str5), new ArrayList((Collection) zzx.zzz(set)));
    }

    @Nullable
    public static GoogleSignInAccount zzbH(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzbI(jSONObject.optString("serverAuthCode", (String) null));
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzWT);
            jSONObject.put("obfuscatedIdentifier", zzmL());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzVs, zzWV);
            for (Scope zzpb : this.zzVs) {
                jSONArray.put(zzpb.zzpb());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).zzmI().equals(zzmI());
    }

    @Nullable
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Nullable
    public String getEmail() {
        return this.zzWP;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzVs);
    }

    @Nullable
    public String getId() {
        return this.zzyv;
    }

    @Nullable
    public String getIdToken() {
        return this.zzWk;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.zzWS;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public boolean zzb() {
        return zzWO.currentTimeMillis() / 1000 >= this.zzWT - 300;
    }

    public GoogleSignInAccount zzbI(String str) {
        this.zzWS = str;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public long zzmK() {
        return this.zzWT;
    }

    @NonNull
    public String zzmL() {
        return this.zzWU;
    }

    public String zzmM() {
        JSONObject zzmJ = zzmJ();
        zzmJ.remove("serverAuthCode");
        return zzmJ.toString();
    }
}
