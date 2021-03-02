package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* renamed from: com.google.android.gms.auth.api.signin.a */
final class C1335a implements Comparator {
    C1335a() {
    }

    /* renamed from: a */
    public int compare(Scope scope, Scope scope2) {
        return scope.zzaok().compareTo(scope2.zzaok());
    }
}
