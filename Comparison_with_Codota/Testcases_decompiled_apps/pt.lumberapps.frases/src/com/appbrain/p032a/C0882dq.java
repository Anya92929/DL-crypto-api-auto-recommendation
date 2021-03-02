package com.appbrain.p032a;

import android.content.pm.PackageInfo;
import java.util.Comparator;

/* renamed from: com.appbrain.a.dq */
final class C0882dq implements Comparator {

    /* renamed from: a */
    final /* synthetic */ C0881dp f2347a;

    C0882dq(C0881dp dpVar) {
        this.f2347a = dpVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) ((-(((PackageInfo) obj).firstInstallTime - ((PackageInfo) obj2).firstInstallTime)) / 1000);
    }
}
