package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzro;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {

    /* renamed from: a */
    private final Account f2947a;

    /* renamed from: b */
    private final Set<Scope> f2948b;

    /* renamed from: c */
    private final Set<Scope> f2949c;

    /* renamed from: d */
    private final Map<Api<?>, zza> f2950d;

    /* renamed from: e */
    private final int f2951e;

    /* renamed from: f */
    private final View f2952f;

    /* renamed from: g */
    private final String f2953g;

    /* renamed from: h */
    private final String f2954h;

    /* renamed from: i */
    private final zzro f2955i;

    /* renamed from: j */
    private Integer f2956j;

    public static final class zza {
        public final Set<Scope> zzXf;
        public final boolean zzalf;

        public zza(Set<Scope> set, boolean z) {
            zzx.zzz(set);
            this.zzXf = Collections.unmodifiableSet(set);
            this.zzalf = z;
        }
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzro zzro) {
        this.f2947a = account;
        this.f2948b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f2950d = map == null ? Collections.EMPTY_MAP : map;
        this.f2952f = view;
        this.f2951e = i;
        this.f2953g = str;
        this.f2954h = str2;
        this.f2955i = zzro;
        HashSet hashSet = new HashSet(this.f2948b);
        for (zza zza2 : this.f2950d.values()) {
            hashSet.addAll(zza2.zzXf);
        }
        this.f2949c = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzat(Context context) {
        return new GoogleApiClient.Builder(context).zzoY();
    }

    public Account getAccount() {
        return this.f2947a;
    }

    @Deprecated
    public String getAccountName() {
        if (this.f2947a != null) {
            return this.f2947a.name;
        }
        return null;
    }

    public void zza(Integer num) {
        this.f2956j = num;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zza2 = this.f2950d.get(api);
        if (zza2 == null || zza2.zzXf.isEmpty()) {
            return this.f2948b;
        }
        HashSet hashSet = new HashSet(this.f2948b);
        hashSet.addAll(zza2.zzXf);
        return hashSet;
    }

    public Account zzqq() {
        return this.f2947a != null ? this.f2947a : new Account("<<default account>>", "com.google");
    }

    public int zzqr() {
        return this.f2951e;
    }

    public Set<Scope> zzqs() {
        return this.f2948b;
    }

    public Set<Scope> zzqt() {
        return this.f2949c;
    }

    public Map<Api<?>, zza> zzqu() {
        return this.f2950d;
    }

    public String zzqv() {
        return this.f2953g;
    }

    public String zzqw() {
        return this.f2954h;
    }

    public View zzqx() {
        return this.f2952f;
    }

    public zzro zzqy() {
        return this.f2955i;
    }

    public Integer zzqz() {
        return this.f2956j;
    }
}
