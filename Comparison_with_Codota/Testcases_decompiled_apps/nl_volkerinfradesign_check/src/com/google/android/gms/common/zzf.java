package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;
import p000.C1193he;

public class zzf {

    /* renamed from: a */
    private static final zzf f3118a = new zzf();

    private zzf() {
    }

    public static zzf zzoO() {
        return f3118a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1193he.C1194a mo5770a(PackageInfo packageInfo, C1193he.C1194a... aVarArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C1193he.C1195b bVar = new C1193he.C1195b(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < aVarArr.length; i++) {
            if (aVarArr[i].equals(bVar)) {
                return aVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(bVar.mo8272a(), 0));
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        C1193he.C1194a a;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                a = mo5770a(packageInfo, C1193he.C1197d.f4258a);
            } else {
                a = mo5770a(packageInfo, C1193he.C1197d.f4258a[0]);
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
        if (zze.zzc(packageManager)) {
            return zza(packageInfo, true);
        }
        boolean zza = zza(packageInfo, false);
        if (zza || !zza(packageInfo, true)) {
            return zza;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zza;
    }
}
