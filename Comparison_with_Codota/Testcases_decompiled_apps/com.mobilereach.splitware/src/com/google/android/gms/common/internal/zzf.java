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
    private final Account zzTI;
    private final String zzUW;
    private final Set<Scope> zzagh;
    private final int zzagj;
    private final View zzagk;
    private final String zzagl;
    private final Set<Scope> zzalb;
    private final Map<Api<?>, zza> zzalc;
    private final zzro zzald;
    private Integer zzale;

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
        this.zzTI = account;
        this.zzagh = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.zzalc = map == null ? Collections.EMPTY_MAP : map;
        this.zzagk = view;
        this.zzagj = i;
        this.zzUW = str;
        this.zzagl = str2;
        this.zzald = zzro;
        HashSet hashSet = new HashSet(this.zzagh);
        for (zza zza2 : this.zzalc.values()) {
            hashSet.addAll(zza2.zzXf);
        }
        this.zzalb = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzat(Context context) {
        return new GoogleApiClient.Builder(context).zzoY();
    }

    public Account getAccount() {
        return this.zzTI;
    }

    @Deprecated
    public String getAccountName() {
        if (this.zzTI != null) {
            return this.zzTI.name;
        }
        return null;
    }

    public void zza(Integer num) {
        this.zzale = num;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zza2 = this.zzalc.get(api);
        if (zza2 == null || zza2.zzXf.isEmpty()) {
            return this.zzagh;
        }
        HashSet hashSet = new HashSet(this.zzagh);
        hashSet.addAll(zza2.zzXf);
        return hashSet;
    }

    public Account zzqq() {
        return this.zzTI != null ? this.zzTI : new Account("<<default account>>", "com.google");
    }

    public int zzqr() {
        return this.zzagj;
    }

    public Set<Scope> zzqs() {
        return this.zzagh;
    }

    public Set<Scope> zzqt() {
        return this.zzalb;
    }

    public Map<Api<?>, zza> zzqu() {
        return this.zzalc;
    }

    public String zzqv() {
        return this.zzUW;
    }

    public String zzqw() {
        return this.zzagl;
    }

    public View zzqx() {
        return this.zzagk;
    }

    public zzro zzqy() {
        return this.zzald;
    }

    public Integer zzqz() {
        return this.zzale;
    }
}
