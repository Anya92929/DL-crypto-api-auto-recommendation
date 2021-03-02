package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

public final class zzvt {
    public static final Api API = new Api("SignIn.API", f7030bK, f7029bJ);

    /* renamed from: Dz */
    public static final Api f7027Dz = new Api("SignIn.INTERNAL_API", f7028a, atP);

    /* renamed from: a */
    static final Api.zza f7028a = new C1872re();
    public static final Api.zzf atP = new Api.zzf();

    /* renamed from: bJ */
    public static final Api.zzf f7029bJ = new Api.zzf();

    /* renamed from: bK */
    public static final Api.zza f7030bK = new C1871rd();

    /* renamed from: dK */
    public static final Scope f7031dK = new Scope(Scopes.PROFILE);

    /* renamed from: dL */
    public static final Scope f7032dL = new Scope("email");

    public class zza implements Api.ApiOptions.HasOptions {
        public Bundle zzbzn() {
            return null;
        }
    }
}
