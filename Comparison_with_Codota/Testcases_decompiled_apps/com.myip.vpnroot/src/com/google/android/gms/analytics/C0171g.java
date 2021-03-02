package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: com.google.android.gms.analytics.g */
class C0171g implements C0178l {

    /* renamed from: xP */
    private static C0171g f172xP;

    /* renamed from: xz */
    private static Object f173xz = new Object();

    /* renamed from: xL */
    protected String f174xL;

    /* renamed from: xM */
    protected String f175xM;

    /* renamed from: xN */
    protected String f176xN;

    /* renamed from: xO */
    protected String f177xO;

    protected C0171g() {
    }

    private C0171g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.f176xN = context.getPackageName();
        this.f177xO = packageManager.getInstallerPackageName(this.f176xN);
        String str = this.f176xN;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            C0207z.m306T("Error retrieving package info: appName set to " + str);
        }
        this.f174xL = str;
        this.f175xM = str2;
    }

    /* renamed from: dQ */
    public static C0171g m175dQ() {
        return f172xP;
    }

    /* renamed from: y */
    public static void m176y(Context context) {
        synchronized (f173xz) {
            if (f172xP == null) {
                f172xP = new C0171g(context);
            }
        }
    }

    /* renamed from: ac */
    public boolean mo3700ac(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.f174xL;
        }
        if (field.equals("&av")) {
            return this.f175xM;
        }
        if (field.equals("&aid")) {
            return this.f176xN;
        }
        if (field.equals("&aiid")) {
            return this.f177xO;
        }
        return null;
    }
}
