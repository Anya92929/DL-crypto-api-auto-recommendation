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

    /* renamed from: k */
    private static Comparator<Scope> f2480k = new Comparator<Scope>() {
        /* renamed from: a */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzpb().compareTo(scope2.zzpb());
        }
    };
    public static zzmq zzWO = zzmt.zzsc();

    /* renamed from: a */
    final int f2481a;

    /* renamed from: b */
    List<Scope> f2482b;

    /* renamed from: c */
    private String f2483c;

    /* renamed from: d */
    private String f2484d;

    /* renamed from: e */
    private String f2485e;

    /* renamed from: f */
    private String f2486f;

    /* renamed from: g */
    private Uri f2487g;

    /* renamed from: h */
    private String f2488h;

    /* renamed from: i */
    private long f2489i;

    /* renamed from: j */
    private String f2490j;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list) {
        this.f2481a = i;
        this.f2483c = str;
        this.f2484d = str2;
        this.f2485e = str3;
        this.f2486f = str4;
        this.f2487g = uri;
        this.f2488h = str5;
        this.f2489i = j;
        this.f2490j = str6;
        this.f2482b = list;
    }

    /* renamed from: a */
    private JSONObject m3618a() {
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
            jSONObject.put("expirationTime", this.f2489i);
            jSONObject.put("obfuscatedIdentifier", zzmL());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2482b, f2480k);
            for (Scope zzpb : this.f2482b) {
                jSONArray.put(zzpb.zzpb());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
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
        return this.f2486f;
    }

    @Nullable
    public String getEmail() {
        return this.f2485e;
    }

    @NonNull
    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.f2482b);
    }

    @Nullable
    public String getId() {
        return this.f2483c;
    }

    @Nullable
    public String getIdToken() {
        return this.f2484d;
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.f2487g;
    }

    @Nullable
    public String getServerAuthCode() {
        return this.f2488h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m3643a(this, parcel, i);
    }

    public boolean zzb() {
        return zzWO.currentTimeMillis() / 1000 >= this.f2489i - 300;
    }

    public GoogleSignInAccount zzbI(String str) {
        this.f2488h = str;
        return this;
    }

    public String zzmI() {
        return m3618a().toString();
    }

    public long zzmK() {
        return this.f2489i;
    }

    @NonNull
    public String zzmL() {
        return this.f2490j;
    }

    public String zzmM() {
        JSONObject a = m3618a();
        a.remove("serverAuthCode");
        return a.toString();
    }
}
