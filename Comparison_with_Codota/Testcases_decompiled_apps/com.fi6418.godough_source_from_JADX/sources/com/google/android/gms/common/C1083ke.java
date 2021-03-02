package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.util.Log;

/* renamed from: com.google.android.gms.common.ke */
public class C1083ke {

    /* renamed from: a */
    private static final C1083ke f4808a = new C1083ke();

    private C1083ke() {
    }

    /* renamed from: a */
    public static C1083ke m4727a() {
        return f4808a;
    }

    /* renamed from: a */
    private boolean m4728a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        C0811cl clVar = new C0811cl(packageInfo.signatures[0].toByteArray());
        if ((z ? C1051j.m4701a() : C1051j.m4704b()).contains(clVar)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(clVar.mo7461a(), 0));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1078k mo7669a(PackageInfo packageInfo, C1078k... kVarArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        C0811cl clVar = new C0811cl(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < kVarArr.length; i++) {
            if (kVarArr[i].equals(clVar)) {
                return kVarArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(clVar.mo7461a(), 0));
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo7670a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (C0853e.m4252b(packageManager)) {
            return m4728a(packageInfo, true);
        }
        boolean a = m4728a(packageInfo, false);
        if (a || !m4728a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }

    /* renamed from: a */
    public boolean mo7671a(PackageManager packageManager, String str) {
        try {
            return mo7670a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }
}
