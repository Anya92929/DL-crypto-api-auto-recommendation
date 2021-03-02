package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzvv;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzg {

    /* renamed from: a */
    private final Account f4572a;

    /* renamed from: b */
    private final Set f4573b;

    /* renamed from: c */
    private final Set f4574c;

    /* renamed from: d */
    private final Map f4575d;

    /* renamed from: e */
    private final int f4576e;

    /* renamed from: f */
    private final View f4577f;

    /* renamed from: g */
    private final String f4578g;

    /* renamed from: h */
    private final String f4579h;

    /* renamed from: i */
    private final zzvv f4580i;

    /* renamed from: j */
    private Integer f4581j;

    public final class zza {

        /* renamed from: dT */
        public final Set f4582dT;

        /* renamed from: yn */
        public final boolean f4583yn;

        public zza(Set set, boolean z) {
            zzab.zzy(set);
            this.f4582dT = Collections.unmodifiableSet(set);
            this.f4583yn = z;
        }
    }

    public zzg(Account account, Set set, Map map, int i, View view, String str, String str2, zzvv zzvv) {
        this.f4572a = account;
        this.f4573b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f4575d = map == null ? Collections.EMPTY_MAP : map;
        this.f4577f = view;
        this.f4576e = i;
        this.f4578g = str;
        this.f4579h = str2;
        this.f4580i = zzvv;
        HashSet hashSet = new HashSet(this.f4573b);
        for (zza zza2 : this.f4575d.values()) {
            hashSet.addAll(zza2.f4582dT);
        }
        this.f4574c = Collections.unmodifiableSet(hashSet);
    }

    public static zzg zzcd(Context context) {
        return new GoogleApiClient.Builder(context).zzaoh();
    }

    public Account getAccount() {
        return this.f4572a;
    }

    @Deprecated
    public String getAccountName() {
        if (this.f4572a != null) {
            return this.f4572a.name;
        }
        return null;
    }

    public Account zzary() {
        return this.f4572a != null ? this.f4572a : new Account("<<default account>>", "com.google");
    }

    public int zzasi() {
        return this.f4576e;
    }

    public Set zzasj() {
        return this.f4573b;
    }

    public Set zzask() {
        return this.f4574c;
    }

    public Map zzasl() {
        return this.f4575d;
    }

    public String zzasm() {
        return this.f4578g;
    }

    public String zzasn() {
        return this.f4579h;
    }

    public View zzaso() {
        return this.f4577f;
    }

    public zzvv zzasp() {
        return this.f4580i;
    }

    public Integer zzasq() {
        return this.f4581j;
    }

    public Set zzb(Api api) {
        zza zza2 = (zza) this.f4575d.get(api);
        if (zza2 == null || zza2.f4582dT.isEmpty()) {
            return this.f4573b;
        }
        HashSet hashSet = new HashSet(this.f4573b);
        hashSet.addAll(zza2.f4582dT);
        return hashSet;
    }

    public void zzc(Integer num) {
        this.f4581j = num;
    }
}
