package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
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

public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new zzb();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();

    /* renamed from: dK */
    public static final Scope f4201dK = new Scope(Scopes.PROFILE);

    /* renamed from: dL */
    public static final Scope f4202dL = new Scope("email");

    /* renamed from: dM */
    public static final Scope f4203dM = new Scope("openid");

    /* renamed from: i */
    private static Comparator f4204i = new C1336b();

    /* renamed from: a */
    final int f4205a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final ArrayList f4206b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Account f4207c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f4208d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final boolean f4209e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final boolean f4210f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f4211g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f4212h;

    public final class Builder {

        /* renamed from: a */
        private Set f4213a = new HashSet();

        /* renamed from: b */
        private boolean f4214b;

        /* renamed from: c */
        private boolean f4215c;

        /* renamed from: d */
        private boolean f4216d;

        /* renamed from: e */
        private String f4217e;

        /* renamed from: f */
        private Account f4218f;

        /* renamed from: g */
        private String f4219g;

        public Builder(GoogleSignInOptions googleSignInOptions) {
            zzab.zzy(googleSignInOptions);
            this.f4213a = new HashSet(googleSignInOptions.f4206b);
            this.f4214b = googleSignInOptions.f4209e;
            this.f4215c = googleSignInOptions.f4210f;
            this.f4216d = googleSignInOptions.f4208d;
            this.f4217e = googleSignInOptions.f4211g;
            this.f4218f = googleSignInOptions.f4207c;
            this.f4219g = googleSignInOptions.f4212h;
        }

        /* renamed from: a */
        private String m5907a(String str) {
            zzab.zzhr(str);
            zzab.zzb(this.f4217e == null || this.f4217e.equals(str), (Object) "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions build() {
            if (this.f4216d && (this.f4218f == null || !this.f4213a.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(this.f4213a, this.f4218f, this.f4216d, this.f4214b, this.f4215c, this.f4217e, this.f4219g, (C1336b) null);
        }

        public Builder requestEmail() {
            this.f4213a.add(GoogleSignInOptions.f4202dL);
            return this;
        }

        public Builder requestId() {
            this.f4213a.add(GoogleSignInOptions.f4203dM);
            return this;
        }

        public Builder requestIdToken(String str) {
            this.f4216d = true;
            this.f4217e = m5907a(str);
            return this;
        }

        public Builder requestProfile() {
            this.f4213a.add(GoogleSignInOptions.f4201dK);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f4213a.add(scope);
            this.f4213a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public Builder requestServerAuthCode(String str, boolean z) {
            this.f4214b = true;
            this.f4217e = m5907a(str);
            this.f4215c = z;
            return this;
        }

        public Builder setAccountName(String str) {
            this.f4218f = new Account(zzab.zzhr(str), "com.google");
            return this;
        }

        public Builder setHostedDomain(String str) {
            this.f4219g = zzab.zzhr(str);
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this.f4205a = i;
        this.f4206b = arrayList;
        this.f4207c = account;
        this.f4208d = z;
        this.f4209e = z2;
        this.f4210f = z3;
        this.f4211g = str;
        this.f4212h = str2;
    }

    private GoogleSignInOptions(Set set, Account account, boolean z, boolean z2, boolean z3, String str, String str2) {
        this(2, new ArrayList(set), account, z, z2, z3, str, str2);
    }

    /* synthetic */ GoogleSignInOptions(Set set, Account account, boolean z, boolean z2, boolean z3, String str, String str2, C1336b bVar) {
        this(set, account, z, z2, z3, str, str2);
    }

    /* renamed from: a */
    private JSONObject m5900a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f4206b, f4204i);
            Iterator it = this.f4206b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).zzaok());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f4207c != null) {
                jSONObject.put("accountName", this.f4207c.name);
            }
            jSONObject.put("idTokenRequested", this.f4208d);
            jSONObject.put("forceCodeForRefreshToken", this.f4210f);
            jSONObject.put("serverAuthRequested", this.f4209e);
            if (!TextUtils.isEmpty(this.f4211g)) {
                jSONObject.put("serverClientId", this.f4211g);
            }
            if (!TextUtils.isEmpty(this.f4212h)) {
                jSONObject.put("hostedDomain", this.f4212h);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInOptions zzfq(String str) {
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

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f4206b.size() != googleSignInOptions.zzafq().size() || !this.f4206b.containsAll(googleSignInOptions.zzafq())) {
                return false;
            }
            if (this.f4207c == null) {
                if (googleSignInOptions.getAccount() != null) {
                    return false;
                }
            } else if (!this.f4207c.equals(googleSignInOptions.getAccount())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f4211g)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzafu())) {
                    return false;
                }
            } else if (!this.f4211g.equals(googleSignInOptions.zzafu())) {
                return false;
            }
            return this.f4210f == googleSignInOptions.zzaft() && this.f4208d == googleSignInOptions.zzafr() && this.f4209e == googleSignInOptions.zzafs();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public Account getAccount() {
        return this.f4207c;
    }

    public Scope[] getScopeArray() {
        return (Scope[]) this.f4206b.toArray(new Scope[this.f4206b.size()]);
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f4206b.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).zzaok());
        }
        Collections.sort(arrayList);
        return new zze().zzq(arrayList).zzq(this.f4207c).zzq(this.f4211g).zzba(this.f4210f).zzba(this.f4208d).zzba(this.f4209e).zzagc();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m5919a(this, parcel, i);
    }

    public String zzafn() {
        return m5900a().toString();
    }

    public ArrayList zzafq() {
        return new ArrayList(this.f4206b);
    }

    public boolean zzafr() {
        return this.f4208d;
    }

    public boolean zzafs() {
        return this.f4209e;
    }

    public boolean zzaft() {
        return this.f4210f;
    }

    public String zzafu() {
        return this.f4211g;
    }

    public String zzafv() {
        return this.f4212h;
    }
}
