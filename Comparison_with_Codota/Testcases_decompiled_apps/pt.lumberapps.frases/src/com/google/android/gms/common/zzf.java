package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;

public class zzf {

    /* renamed from: a */
    private static zzf f4757a;

    /* renamed from: b */
    private final Context f4758b;

    private zzf(Context context) {
        this.f4758b = context.getApplicationContext();
    }

    /* renamed from: a */
    private boolean m6219a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        C1345d dVar = new C1345d(packageInfo.signatures[0].toByteArray());
        for (zzs equals : z ? C1343b.m5981a() : C1343b.m5984b()) {
            if (dVar.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static zzf zzbz(Context context) {
        zzab.zzy(context);
        synchronized (zzf.class) {
            if (f4757a == null) {
                C1343b.m5983a(context);
                f4757a = new zzf(context);
            }
        }
        return f4757a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1344c mo6931a(PackageInfo packageInfo, C1344c... cVarArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1345d dVar = new C1345d(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < cVarArr.length; i++) {
            if (cVarArr[i].equals(dVar)) {
                return cVarArr[i];
            }
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        C1344c a;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                a = mo6931a(packageInfo, C1348f.f4401a);
            } else {
                a = mo6931a(packageInfo, C1348f.f4401a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zze.zzbu(this.f4758b)) {
            return m6219a(packageInfo, true);
        }
        boolean a = m6219a(packageInfo, false);
        if (a || !m6219a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }

    public boolean zzb(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (!zza(packageInfo, true)) {
            return false;
        }
        if (zze.zzbu(this.f4758b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean zzb(PackageManager packageManager, String str) {
        try {
            return zza(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
