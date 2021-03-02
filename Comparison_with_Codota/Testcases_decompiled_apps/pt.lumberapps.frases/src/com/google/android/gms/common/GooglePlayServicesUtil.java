package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.p009v4.app.Fragment;
import android.support.p009v4.app.NotificationCompat;
import android.support.p009v4.app.NotificationCompatExtras;
import com.google.android.gms.C1204R;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzs;

public final class GooglePlayServicesUtil extends zze {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    /* renamed from: a */
    static void m5947a(int i, Context context, PendingIntent pendingIntent) {
        m5949a(i, context, (String) null, pendingIntent);
    }

    /* renamed from: a */
    private static void m5948a(int i, Context context, String str) {
        m5949a(i, context, str, GoogleApiAvailability.getInstance().zza(context, i, 0, "n"));
    }

    @TargetApi(20)
    /* renamed from: a */
    private static void m5949a(int i, Context context, String str, PendingIntent pendingIntent) {
        Notification build;
        Notification notification;
        int i2;
        Resources resources = context.getResources();
        String zzbv = zzbv(context);
        String zzg = zzh.zzg(context, i);
        if (zzg == null) {
            zzg = resources.getString(C1204R.string.common_google_play_services_notification_ticker);
        }
        String zzd = zzh.zzd(context, i, zzbv);
        if (zzi.zzck(context)) {
            zzab.zzbn(zzs.zzavr());
            build = new Notification.Builder(context).setSmallIcon(C1204R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(new StringBuilder(String.valueOf(zzg).length() + 1 + String.valueOf(zzd).length()).append(zzg).append(" ").append(zzd).toString())).addAction(C1204R.drawable.common_full_open_on_phone, resources.getString(C1204R.string.common_open_on_phone), pendingIntent).build();
        } else {
            String string = resources.getString(C1204R.string.common_google_play_services_notification_ticker);
            if (zzs.zzavn()) {
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzg).setContentText(zzd).setContentIntent(pendingIntent).setTicker(string).setAutoCancel(true);
                if (zzs.zzavv()) {
                    autoCancel.setLocalOnly(true);
                }
                if (zzs.zzavr()) {
                    autoCancel.setStyle(new Notification.BigTextStyle().bigText(zzd));
                    notification = autoCancel.build();
                } else {
                    notification = autoCancel.getNotification();
                }
                if (Build.VERSION.SDK_INT == 19) {
                    notification.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                build = notification;
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(zzg).setContentText(zzd).build();
            }
        }
        if (m6215a(i)) {
            f4750b.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, build);
        } else {
            notificationManager.notify(i2, build);
        }
    }

    /* renamed from: a */
    private static void m5950a(Context context) {
        C1338a aVar = new C1338a(context);
        aVar.sendMessageDelayed(aVar.obtainMessage(1), 120000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m5951b(int i, Context context) {
        m5948a(i, context, (String) null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzc(activity, i)) {
            i = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zze.getErrorString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public static Context getRemoteContext(Context context) {
        return zze.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zze.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zze.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zze.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, (Fragment) null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (zzc(activity, i)) {
            i = 18;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, i, i2, onCancelListener);
        }
        Dialog a = instance.mo6215a((Context) activity, i, com.google.android.gms.common.internal.zzi.zza(fragment, GoogleApiAvailability.getInstance().zza((Context) activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        instance.mo6216a(activity, a, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zzi.zzck(context) && i == 2) {
            i = 42;
        }
        if (zzc(context, i) || zzd(context, i)) {
            m5950a(context);
        } else {
            m5951b(i, context);
        }
    }

    @Deprecated
    public static boolean zzc(Context context, int i) {
        return zze.zzc(context, i);
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    @Deprecated
    public static Intent zzfd(int i) {
        return zze.zzfd(i);
    }
}
