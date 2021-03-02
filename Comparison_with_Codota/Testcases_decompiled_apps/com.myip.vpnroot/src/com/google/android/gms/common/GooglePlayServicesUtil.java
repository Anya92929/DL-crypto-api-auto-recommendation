package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.C0135R;
import com.google.android.gms.common.internal.C0331g;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.C1384jt;
import com.google.android.gms.internal.C1394kc;
import java.util.Arrays;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6111000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    /* renamed from: Id */
    public static boolean f545Id = false;

    /* renamed from: Ie */
    public static boolean f546Ie = false;

    /* renamed from: If */
    private static int f547If = -1;

    /* renamed from: Ig */
    private static final Object f548Ig = new Object();

    private GooglePlayServicesUtil() {
    }

    /* renamed from: D */
    public static void m460D(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent c = m472c(context, isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (c == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", c);
        }
    }

    /* renamed from: E */
    private static void m461E(Context context) {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.version");
            if (i != 6111000) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected 6111000 but found " + i + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
            }
            return;
        }
        throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }

    /* renamed from: F */
    private static String m462F(Context context) {
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

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0109  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.app.Dialog m463a(int r5, android.app.Activity r6, android.support.p000v4.app.Fragment r7, int r8, android.content.DialogInterface.OnCancelListener r9) {
        /*
            r2 = 0
            boolean r0 = com.google.android.gms.internal.C1384jt.m5212K(r6)
            if (r0 == 0) goto L_0x000c
            r0 = 2
            if (r5 != r0) goto L_0x000c
            r5 = 42
        L_0x000c:
            boolean r0 = com.google.android.gms.internal.C1394kc.m5241hE()
            if (r0 == 0) goto L_0x0116
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.res.Resources$Theme r1 = r6.getTheme()
            r3 = 16843529(0x1010309, float:2.3695736E-38)
            r4 = 1
            r1.resolveAttribute(r3, r0, r4)
            android.content.res.Resources r1 = r6.getResources()
            int r0 = r0.resourceId
            java.lang.String r0 = r1.getResourceEntryName(r0)
            java.lang.String r1 = "Theme.Dialog.Alert"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0116
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r1 = 5
            r0.<init>(r6, r1)
        L_0x003a:
            if (r0 != 0) goto L_0x0041
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r6)
        L_0x0041:
            java.lang.String r1 = m474d(r6, r5)
            r0.setMessage(r1)
            if (r9 == 0) goto L_0x004d
            r0.setOnCancelListener(r9)
        L_0x004d:
            android.content.Intent r3 = m472c(r6, r5)
            if (r7 != 0) goto L_0x0081
            com.google.android.gms.common.internal.b r1 = new com.google.android.gms.common.internal.b
            r1.<init>((android.app.Activity) r6, (android.content.Intent) r3, (int) r8)
        L_0x0058:
            java.lang.String r3 = m475e(r6, r5)
            if (r3 == 0) goto L_0x0061
            r0.setPositiveButton(r3, r1)
        L_0x0061:
            switch(r5) {
                case 0: goto L_0x0087;
                case 1: goto L_0x008e;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0099;
                case 4: goto L_0x0089;
                case 5: goto L_0x00f6;
                case 6: goto L_0x0089;
                case 7: goto L_0x00cc;
                case 8: goto L_0x00de;
                case 9: goto L_0x00ba;
                case 10: goto L_0x00ea;
                case 11: goto L_0x0109;
                case 42: goto L_0x00af;
                default: goto L_0x0064;
            }
        L_0x0064:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected error code "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            android.app.AlertDialog r0 = r0.create()
        L_0x0080:
            return r0
        L_0x0081:
            com.google.android.gms.common.internal.b r1 = new com.google.android.gms.common.internal.b
            r1.<init>((android.support.p000v4.app.Fragment) r7, (android.content.Intent) r3, (int) r8)
            goto L_0x0058
        L_0x0087:
            r0 = r2
            goto L_0x0080
        L_0x0089:
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x008e:
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_install_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x0099:
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_enable_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00a4:
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_update_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00af:
            int r1 = com.google.android.gms.C0135R.string.common_android_wear_update_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00ba:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "Google Play services is invalid. Cannot recover."
            android.util.Log.e(r1, r2)
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_unsupported_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00cc:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "Network error occurred. Please retry request later."
            android.util.Log.e(r1, r2)
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_network_error_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00de:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "Internal error occurred. Please see logs for detailed information"
            android.util.Log.e(r1, r2)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00ea:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "Developer error occurred. Please see logs for detailed information"
            android.util.Log.e(r1, r2)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x00f6:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "An invalid account was specified when connecting. Please provide a valid account."
            android.util.Log.e(r1, r2)
            int r1 = com.google.android.gms.C0135R.string.common_google_play_services_invalid_account_title
            android.app.AlertDialog$Builder r0 = r0.setTitle(r1)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x0109:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "The application is not licensed to the user."
            android.util.Log.e(r1, r2)
            android.app.AlertDialog r0 = r0.create()
            goto L_0x0080
        L_0x0116:
            r0 = r2
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtil.m463a(int, android.app.Activity, android.support.v4.app.Fragment, int, android.content.DialogInterface$OnCancelListener):android.app.Dialog");
    }

    /* renamed from: a */
    public static boolean m464a(PackageManager packageManager, PackageInfo packageInfo) {
        boolean z = true;
        boolean z2 = false;
        if (packageInfo == null) {
            return false;
        }
        if (m473c(packageManager)) {
            if (m466a(packageInfo, true) == null) {
                z = false;
            }
            return z;
        }
        if (m466a(packageInfo, false) != null) {
            z2 = true;
        }
        if (z2 || m466a(packageInfo, true) == null) {
            return z2;
        }
        Log.w("GooglePlayServicesUtil", "Test-keys aren't accepted on this build.");
        return z2;
    }

    /* renamed from: a */
    public static boolean m465a(Resources resources) {
        if (resources == null) {
            return false;
        }
        return (C1394kc.m5238hB() && ((resources.getConfiguration().screenLayout & 15) > 3)) || m471b(resources);
    }

    /* renamed from: a */
    private static byte[] m466a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        byte[] byteArray = packageInfo.signatures[0].toByteArray();
        if ((z ? C0290b.m587fZ() : C0290b.m588ga()).contains(byteArray)) {
            return byteArray;
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(byteArray, 0));
        }
        return null;
    }

    /* renamed from: a */
    private static byte[] m467a(PackageInfo packageInfo, byte[]... bArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
            return null;
        }
        byte[] byteArray = packageInfo.signatures[0].toByteArray();
        for (byte[] bArr2 : bArr) {
            if (Arrays.equals(bArr2, byteArray)) {
                return bArr2;
            }
        }
        if (Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(byteArray, 0));
        }
        return null;
    }

    /* renamed from: ai */
    public static Intent m468ai(int i) {
        switch (i) {
            case 1:
            case 2:
                return C0331g.m747aY(GOOGLE_PLAY_SERVICES_PACKAGE);
            case 3:
                return C0331g.m745aW(GOOGLE_PLAY_SERVICES_PACKAGE);
            case FitnessActivities.KICKBOXING /*42*/:
                return C0331g.m748gZ();
            default:
                return null;
        }
    }

    /* renamed from: b */
    public static boolean m469b(PackageManager packageManager) {
        synchronized (f548Ig) {
            if (f547If == -1) {
                try {
                    if (m467a(packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64), C0290b.f663HZ[1]) != null) {
                        f547If = 1;
                    } else {
                        f547If = 0;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    f547If = 0;
                }
            }
        }
        return f547If != 0;
    }

    /* renamed from: b */
    public static boolean m470b(PackageManager packageManager, String str) {
        try {
            return m464a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("GooglePlayServicesUtil", 3)) {
                Log.d("GooglePlayServicesUtil", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m471b(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        return C1394kc.m5240hD() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
    }

    @Deprecated
    /* renamed from: c */
    public static Intent m472c(Context context, int i) {
        return m468ai(i);
    }

    /* renamed from: c */
    public static boolean m473c(PackageManager packageManager) {
        return m469b(packageManager) || !m477gb();
    }

    /* renamed from: d */
    public static String m474d(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return m465a(context.getResources()) ? resources.getString(C0135R.string.common_google_play_services_install_text_tablet) : resources.getString(C0135R.string.common_google_play_services_install_text_phone);
            case 2:
                return resources.getString(C0135R.string.common_google_play_services_update_text);
            case 3:
                return resources.getString(C0135R.string.common_google_play_services_enable_text);
            case 5:
                return resources.getString(C0135R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0135R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0135R.string.common_google_play_services_unsupported_text);
            case FitnessActivities.KICKBOXING /*42*/:
                return resources.getString(C0135R.string.common_android_wear_update_text);
            default:
                return resources.getString(C0135R.string.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: e */
    public static String m475e(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0135R.string.common_google_play_services_install_button);
            case 2:
            case FitnessActivities.KICKBOXING /*42*/:
                return resources.getString(C0135R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0135R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    /* renamed from: f */
    public static String m476f(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0135R.string.f29x8f024ee1);
            case 2:
                return resources.getString(C0135R.string.common_google_play_services_notification_needs_update_title);
            case 3:
                return resources.getString(C0135R.string.common_google_play_services_needs_enabling_title);
            case 5:
                return resources.getString(C0135R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(C0135R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(C0135R.string.common_google_play_services_unsupported_text);
            case FitnessActivities.KICKBOXING /*42*/:
                return resources.getString(C0135R.string.common_android_wear_notification_needs_update_text);
            default:
                return resources.getString(C0135R.string.common_google_play_services_unknown_issue);
        }
    }

    /* renamed from: gb */
    public static boolean m477gb() {
        return f545Id ? f546Ie : "user".equals(Build.TYPE);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, (DialogInterface.OnCancelListener) null);
    }

    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return m463a(errorCode, activity, (Fragment) null, requestCode, cancelListener);
    }

    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent c = m472c(context, errorCode);
        if (c == null) {
            return null;
        }
        return PendingIntent.getActivity(context, requestCode, c, DriveFile.MODE_READ_ONLY);
    }

    public static String getErrorString(int errorCode) {
        switch (errorCode) {
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                return "UNKNOWN_ERROR_CODE";
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOpenSourceSoftwareLicenseInfo(android.content.Context r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(android.content.Context):java.lang.String");
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext(GOOGLE_PLAY_SERVICES_PACKAGE, 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication(GOOGLE_PLAY_SERVICES_PACKAGE);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0135R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        m461E(context);
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 64);
            if (C1384jt.m5215aP(packageInfo.versionCode)) {
                char c = m477gb() ? (char) 0 : 1;
                if (m467a(packageInfo, C0290b.f645HH[c], C0290b.f650HM[c]) == null) {
                    Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
                    return 9;
                }
                String packageName = context.getPackageName();
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(packageName, 64);
                    if (!m464a(packageManager, packageInfo2)) {
                        Log.w("GooglePlayServicesUtil", "Calling package " + packageInfo2.packageName + " signature invalid on Glass.");
                        return 9;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + packageName);
                    return 9;
                }
            } else if (!C1384jt.m5212K(context)) {
                try {
                    byte[] a = m467a(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), C0290b.f645HH);
                    if (a == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (m467a(packageInfo, a) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                    return 9;
                }
            } else if (m467a(packageInfo, C0290b.f645HH) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (C1384jt.m5213aN(packageInfo.versionCode) < C1384jt.m5213aN(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6111000 but found " + packageInfo.versionCode);
                return 2;
            }
            try {
                return !packageManager.getApplicationInfo(GOOGLE_PLAY_SERVICES_PACKAGE, 0).enabled ? 3 : 0;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                e3.printStackTrace();
                return 1;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    public static boolean isGoogleSignedUid(PackageManager packageManager, int uid) {
        if (packageManager == null) {
            throw new SecurityException("Unknown error: invalid Package Manager");
        }
        String[] packagesForUid = packageManager.getPackagesForUid(uid);
        if (packagesForUid.length != 0 && m470b(packageManager, packagesForUid[0])) {
            return true;
        }
        throw new SecurityException("Uid is not Google Signed");
    }

    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, (DialogInterface.OnCancelListener) null);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return showErrorDialogFragment(errorCode, activity, (Fragment) null, requestCode, cancelListener);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        boolean z = false;
        Dialog a = m463a(errorCode, activity, fragment, requestCode, cancelListener);
        if (a == null) {
            return false;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(a, cancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (C1394kc.m5238hB()) {
            ErrorDialogFragment.newInstance(a, cancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    public static void showErrorNotification(int errorCode, Context context) {
        Notification notification;
        boolean K = C1384jt.m5212K(context);
        if (K && errorCode == 2) {
            errorCode = 42;
        }
        Resources resources = context.getResources();
        String f = m476f(context, errorCode);
        String string = resources.getString(C0135R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{m462F(context)});
        PendingIntent errorPendingIntent = getErrorPendingIntent(errorCode, context, 0);
        if (K) {
            C0348n.m850I(C1394kc.m5242hF());
            notification = new Notification.Builder(context).setSmallIcon(C0135R.C0136drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(f + " " + string)).addAction(C0135R.C0136drawable.common_full_open_on_phone, resources.getString(C0135R.string.common_open_on_phone), errorPendingIntent).build();
        } else {
            Notification notification2 = new Notification(17301642, resources.getString(C0135R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
            notification2.flags |= 16;
            notification2.setLatestEventInfo(context, f, string, errorPendingIntent);
            notification = notification2;
        }
        ((NotificationManager) context.getSystemService("notification")).notify(39789, notification);
    }
}
