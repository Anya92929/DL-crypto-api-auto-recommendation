package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions implements Api.ApiOptions.Optional, SafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzc();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();

    /* renamed from: i */
    private static Comparator<Scope> f2491i = new Comparator<Scope>() {
        /* renamed from: a */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzpb().compareTo(scope2.zzpb());
        }
    };
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Scope zzWY = new Scope("openid");

    /* renamed from: a */
    final int f2492a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ArrayList<Scope> f2493b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Account f2494c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f2495d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final boolean f2496e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final boolean f2497f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f2498g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f2499h;

    public static final class Builder {

        /* renamed from: a */
        private Set<Scope> f2500a = new HashSet();

        /* renamed from: b */
        private boolean f2501b;

        /* renamed from: c */
        private boolean f2502c;

        /* renamed from: d */
        private boolean f2503d;

        /* renamed from: e */
        private String f2504e;

        /* renamed from: f */
        private Account f2505f;

        /* renamed from: g */
        private String f2506g;

        public Builder() {
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            zzx.zzz(googleSignInOptions);
            this.f2500a = new HashSet(googleSignInOptions.f2493b);
            this.f2501b = googleSignInOptions.f2496e;
            this.f2502c = googleSignInOptions.f2497f;
            this.f2503d = googleSignInOptions.f2495d;
            this.f2504e = googleSignInOptions.f2498g;
            this.f2505f = googleSignInOptions.f2494c;
            this.f2506g = googleSignInOptions.f2499h;
        }

        /* renamed from: a */
        private String m3629a(String str) {
            zzx.zzcM(str);
            zzx.zzb(this.f2504e == null || this.f2504e.equals(str), (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f2503d && (this.f2505f == null || !this.f2500a.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions((Set) this.f2500a, this.f2505f, this.f2503d, this.f2501b, this.f2502c, this.f2504e, this.f2506g);
        }

        public Builder requestEmail() {
            this.f2500a.add(GoogleSignInOptions.zzWX);
            return this;
        }

        public Builder requestId() {
            this.f2500a.add(GoogleSignInOptions.zzWY);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f2503d = true;
            this.f2504e = m3629a(str);
            return this;
        }

        public Builder requestProfile() {
            this.f2500a.add(GoogleSignInOptions.zzWW);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f2500a.add(scope);
            this.f2500a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f2501b = true;
            this.f2504e = m3629a(str);
            this.f2502c = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f2505f = new Account(zzx.zzcM(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f2506g = zzx.zzcM(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f2492a = i;
        this.f2493b = arrayList;
        this.f2494c = account;
        this.f2495d = z;
        this.f2496e = z2;
        this.f2497f = z3;
        this.f2498g = str;
        this.f2499h = str2;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, (ArrayList<Scope>) new ArrayList(set), account, z, z2, z3, str, str2);
    }

    /* renamed from: a */
    private JSONObject m3621a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f2493b, f2491i);
            Iterator<Scope> it = this.f2493b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().zzpb());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f2494c != null) {
                jSONObject.put("accountName", this.f2494c.name);
            }
            jSONObject.put("idTokenRequested", this.f2495d);
            jSONObject.put("forceCodeForRefreshToken", this.f2497f);
            jSONObject.put("serverAuthRequested", this.f2496e);
            if (!TextUtils.isEmpty(this.f2498g)) {
                jSONObject.put("serverClientId", this.f2498g);
            }
            if (!TextUtils.isEmpty(this.f2499h)) {
                jSONObject.put("hostedDomain", this.f2499h);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static GoogleSignInOptions zzbJ(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", (String) null);
        return new GoogleSignInOptions(hashSet, !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", (String) null), jSONObject.optString("hostedDomain", (String) null));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f2493b.size() != googleSignInOptions.zzmN().size() || !this.f2493b.containsAll(googleSignInOptions.zzmN())) {
                return false;
            }
            if (this.f2494c == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.f2494c.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f2498g)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzmR())) {
                    return false;
                }
            } else if (!this.f2498g.equals(googleSignInOptions.zzmR())) {
                return false;
            }
            return this.f2497f == googleSignInOptions.zzmQ() && this.f2495d == googleSignInOptions.zzmO() && this.f2496e == googleSignInOptions.zzmP();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f2494c;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.f2493b.toArray(new Scope[this.f2493b.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator<Scope> it = this.f2493b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzpb());
        }
        Collections.sort(arrayList);
        return new zze().zzp(arrayList).zzp(this.f2494c).zzp(this.f2498g).zzP(this.f2497f).zzP(this.f2495d).zzP(this.f2496e).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m3644a(this, parcel, i);
    }

    public String zzmI() {
        return m3621a().toString();
    }

    public ArrayList<Scope> zzmN() {
        return new ArrayList<>(this.f2493b);
    }

    public boolean zzmO() {
        return this.f2495d;
    }

    public boolean zzmP() {
        return this.f2496e;
    }

    public boolean zzmQ() {
        return this.f2497f;
    }

    public String zzmR() {
        return this.f2498g;
    }

    public String zzmS() {
        return this.f2499h;
    }
}
