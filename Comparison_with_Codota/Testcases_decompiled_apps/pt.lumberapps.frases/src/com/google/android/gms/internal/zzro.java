package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.util.zzs;

public class zzro {

    /* renamed from: a */
    protected final Context f6975a;

    public zzro(Context context) {
        this.f6975a = context;
    }

    public ApplicationInfo getApplicationInfo(String str, int i) {
        return this.f6975a.getPackageManager().getApplicationInfo(str, i);
    }

    public PackageInfo getPackageInfo(String str, int i) {
        return this.f6975a.getPackageManager().getPackageInfo(str, i);
    }

    @TargetApi(19)
    public boolean zzg(int i, String str) {
        if (zzs.zzavu()) {
            try {
                ((AppOpsManager) this.f6975a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f6975a.getPackageManager().getPackagesForUid(i);
            if (str == null || packagesForUid == null) {
                return false;
            }
            for (String equals : packagesForUid) {
                if (str.equals(equals)) {
                    return true;
                }
            }
            return false;
        }
    }
}
