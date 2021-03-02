package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
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

public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new zza();

    /* renamed from: dA */
    public static zze f4187dA = zzh.zzavm();

    /* renamed from: m */
    private static Comparator f4188m = new C1335a();

    /* renamed from: a */
    final int f4189a;

    /* renamed from: b */
    List f4190b;

    /* renamed from: c */
    private String f4191c;

    /* renamed from: d */
    private String f4192d;

    /* renamed from: e */
    private String f4193e;

    /* renamed from: f */
    private String f4194f;

    /* renamed from: g */
    private Uri f4195g;

    /* renamed from: h */
    private String f4196h;

    /* renamed from: i */
    private long f4197i;

    /* renamed from: j */
    private String f4198j;

    /* renamed from: k */
    private String f4199k;

    /* renamed from: l */
    private String f4200l;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.f4189a = i;
        this.f4191c = str;
        this.f4192d = str2;
        this.f4193e = str3;
        this.f4194f = str4;
        this.f4195g = uri;
        this.f4196h = str5;
        this.f4197i = j;
        this.f4198j = str6;
        this.f4190b = list;
        this.f4199k = str7;
        this.f4200l = str8;
    }

    /* renamed from: a */
    private JSONObject m5898a() {
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
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.f4197i);
            jSONObject.put("obfuscatedIdentifier", zzafm());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f4190b, f4188m);
            for (Scope zzaok : this.f4190b) {
                jSONArray.put(zzaok.zzaok());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInAccount zza(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        if (l == null) {
            l = Long.valueOf(f4187dA.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l.longValue(), zzab.zzhr(str7), new ArrayList((Collection) zzab.zzy(set)), str5, str6);
    }

    public static GoogleSignInAccount zzfo(String str) {
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
        return zza(jSONObject.optString("id"), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), jSONObject.optString("givenName", (String) null), jSONObject.optString("familyName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzfp(jSONObject.optString("serverAuthCode", (String) null));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).zzafn().equals(zzafn());
    }

    public String getDisplayName() {
        return this.f4194f;
    }

    public String getEmail() {
        return this.f4193e;
    }

    public String getFamilyName() {
        return this.f4200l;
    }

    public String getGivenName() {
        return this.f4199k;
    }

    public Set getGrantedScopes() {
        return new HashSet(this.f4190b);
    }

    public String getId() {
        return this.f4191c;
    }

    public String getIdToken() {
        return this.f4192d;
    }

    public Uri getPhotoUrl() {
        return this.f4195g;
    }

    public String getServerAuthCode() {
        return this.f4196h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m5918a(this, parcel, i);
    }

    public boolean zza() {
        return f4187dA.currentTimeMillis() / 1000 >= this.f4197i - 300;
    }

    public long zzafl() {
        return this.f4197i;
    }

    public String zzafm() {
        return this.f4198j;
    }

    public String zzafn() {
        return m5898a().toString();
    }

    public String zzafo() {
        JSONObject a = m5898a();
        a.remove("serverAuthCode");
        return a.toString();
    }

    public GoogleSignInAccount zzfp(String str) {
        this.f4196h = str;
        return this;
    }
}
