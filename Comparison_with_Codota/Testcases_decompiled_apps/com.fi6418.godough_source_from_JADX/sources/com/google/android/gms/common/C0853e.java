package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0595b;
import com.google.android.gms.common.internal.C0992ap;
import com.google.android.gms.common.internal.C1015f;
import com.google.android.gms.common.internal.C1034v;
import com.google.android.gms.common.internal.C1035w;
import com.google.android.gms.p018c.C0613ab;
import com.google.android.gms.p018c.C0618ag;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.e */
public final class C0853e {
    @Deprecated

    /* renamed from: a */
    public static final int f4594a = m4247b();

    /* renamed from: b */
    public static boolean f4595b = false;

    /* renamed from: c */
    public static boolean f4596c = false;

    /* renamed from: d */
    static final AtomicBoolean f4597d = new AtomicBoolean();

    /* renamed from: e */
    private static int f4598e = -1;

    /* renamed from: f */
    private static final Object f4599f = new Object();

    /* renamed from: g */
    private static String f4600g = null;

    /* renamed from: h */
    private static Integer f4601h = null;

    @Deprecated
    /* renamed from: a */
    public static int m4237a(Context context) {
        if (C1015f.f4727a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0595b.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            m4257g(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            C1083ke a = C1083ke.m4727a();
            if (!C0613ab.m3552c(packageInfo.versionCode) && !C0613ab.m3550a(context)) {
                try {
                    C1078k a2 = a.mo7669a(packageManager.getPackageInfo("com.android.vending", 64), C0873et.f4608a);
                    if (a2 == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (a.mo7669a(packageInfo, a2) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    if (m4244a(context, "com.android.vending")) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                        if (a.mo7669a(packageInfo, C0873et.f4608a) == null) {
                            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                            return 9;
                        }
                    } else {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                        return 9;
                    }
                }
            } else if (a.mo7669a(packageInfo, C0873et.f4608a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C0613ab.m3549a(packageInfo.versionCode) < C0613ab.m3549a(f4594a)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f4594a + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    e2.printStackTrace();
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static Dialog m4238a(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m4248b(i, activity, (Fragment) null, i2, onCancelListener);
    }

    @Deprecated
    /* renamed from: a */
    public static Intent m4239a(int i) {
        switch (i) {
            case 1:
            case 2:
                return C0992ap.m4417b("com.google.android.gms");
            case 3:
                return C0992ap.m4416a("com.google.android.gms");
            case 42:
                return C0992ap.m4415a();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static boolean m4240a() {
        return f4595b ? f4596c : "user".equals(Build.TYPE);
    }

    /* renamed from: a */
    public static boolean m4241a(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        boolean z = false;
        Dialog b = m4248b(i, activity, fragment, i2, onCancelListener);
        if (b == null) {
            return false;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            C0880f.m4275a(b, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), "GooglePlayServicesErrorDialog");
        } else if (C0618ag.m3562a()) {
            C0685a.m3946a(b, onCancelListener).show(activity.getFragmentManager(), "GooglePlayServicesErrorDialog");
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m4242a(Context context, int i) {
        return m4243a(context, i, "com.google.android.gms") && m4246a(context.getPackageManager(), "com.google.android.gms");
    }

    /* renamed from: a */
    public static boolean m4243a(Context context, int i, String str) {
        if (C0618ag.m3567e()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        } else {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
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

    /* renamed from: a */
    public static boolean m4244a(Context context, String str) {
        if (C0618ag.m3569g()) {
            for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        } else {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192).enabled) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m4245a(PackageManager packageManager) {
        synchronized (f4599f) {
            if (f4598e == -1) {
                try {
                    if (C1083ke.m4727a().mo7669a(packageManager.getPackageInfo("com.google.android.gms", 64), C1051j.f4794b[1]) != null) {
                        f4598e = 1;
                    } else {
                        f4598e = 0;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    f4598e = 0;
                }
            }
        }
        return f4598e != 0;
    }

    @Deprecated
    /* renamed from: a */
    public static boolean m4246a(PackageManager packageManager, String str) {
        return C1083ke.m4727a().mo7671a(packageManager, str);
    }

    /* renamed from: b */
    private static int m4247b() {
        return 7895000;
    }

    /* renamed from: b */
    private static Dialog m4248b(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (C0613ab.m3550a((Context) activity) && i == 2) {
            i = 42;
        }
        if (C0618ag.m3565c()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(C1034v.m4641a(activity, i, m4256f(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent a = m4239a(i);
        C1035w wVar = fragment == null ? new C1035w(activity, a, i2) : new C1035w(fragment, a, i2);
        String b = C1034v.m4642b(activity, i);
        if (b != null) {
            builder.setPositiveButton(b, wVar);
        }
        String a2 = C1034v.m4640a(activity, i);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        return builder.create();
    }

    @Deprecated
    /* renamed from: b */
    public static void m4249b(Context context) {
        int a = m4237a(context);
        if (a != 0) {
            Intent a2 = m4239a(a);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a);
            if (a2 == null) {
                throw new C0799c(a);
            }
            throw new C0826d(a, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m4250b(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    /* renamed from: b */
    public static boolean m4251b(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return m4244a(context, "com.google.android.gms");
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m4252b(PackageManager packageManager) {
        return m4245a(packageManager) || !m4240a();
    }

    @Deprecated
    /* renamed from: c */
    public static void m4253c(Context context) {
        if (!f4597d.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @java.lang.Deprecated
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4254d(android.content.Context r4) {
        /*
            r1 = 0
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r2 = "android.resource"
            android.net.Uri$Builder r0 = r0.scheme(r2)
            java.lang.String r2 = "com.google.android.gms"
            android.net.Uri$Builder r0 = r0.authority(r2)
            java.lang.String r2 = "raw"
            android.net.Uri$Builder r0 = r0.appendPath(r2)
            java.lang.String r2 = "oss_notice"
            android.net.Uri$Builder r0 = r0.appendPath(r2)
            android.net.Uri r0 = r0.build()
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ Exception -> 0x004e }
            java.io.InputStream r2 = r2.openInputStream(r0)     // Catch:{ Exception -> 0x004e }
            java.util.Scanner r0 = new java.util.Scanner     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            r0.<init>(r2)     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            java.lang.String r3 = "\\A"
            java.util.Scanner r0 = r0.useDelimiter(r3)     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            java.lang.String r0 = r0.next()     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x003e:
            return r0
        L_0x003f:
            r0 = move-exception
            if (r2 == 0) goto L_0x0045
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x0045:
            r0 = r1
            goto L_0x003e
        L_0x0047:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x004d:
            throw r0     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            r0 = move-exception
            r0 = r1
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.C0853e.m4254d(android.content.Context):java.lang.String");
    }

    /* renamed from: e */
    public static Context m4255e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: f */
    public static String m4256f(Context context) {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    /* renamed from: g */
    private static void m4257g(Context context) {
        Integer num;
        synchronized (f4599f) {
            if (f4600g == null) {
                f4600g = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f4601h = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        f4601h = null;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                }
            } else if (!f4600g.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + f4600g + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = f4601h;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        } else if (num.intValue() != f4594a) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f4594a + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
        }
    }
}
