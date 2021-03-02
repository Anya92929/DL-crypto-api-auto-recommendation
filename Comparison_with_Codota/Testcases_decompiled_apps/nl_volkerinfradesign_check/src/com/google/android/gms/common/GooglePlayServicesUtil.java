package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.app.NotificationCompat;
import android.support.p001v4.app.NotificationCompatExtras;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0666R;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzne;

public final class GooglePlayServicesUtil extends zze {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    /* renamed from: com.google.android.gms.common.GooglePlayServicesUtil$a */
    static class C0680a extends Handler {

        /* renamed from: a */
        private final Context f2597a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0680a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f2597a = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f2597a);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.m3688b(isGooglePlayServicesAvailable, this.f2597a);
                        return;
                    }
                    return;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                    return;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @TargetApi(14)
    /* renamed from: a */
    private static Dialog m3684a(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzmu.zzaw(activity) && i == 2) {
            i = 42;
        }
        if (zzd(activity, i)) {
            i = 18;
        }
        if (zzne.zzsg()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zzg.zzc(activity, i, zzao(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent zza = GoogleApiAvailability.getInstance().zza(activity, i, "d");
        zzh zzh = fragment == null ? new zzh(activity, zza, i2) : new zzh(fragment, zza, i2);
        String zzh2 = zzg.zzh(activity, i);
        if (zzh2 != null) {
            builder.setPositiveButton(zzh2, zzh);
        }
        String zzg = zzg.zzg(activity, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    @TargetApi(21)
    /* renamed from: a */
    private static void m3686a(int i, Context context, String str) {
        Notification build;
        Notification notification;
        int i2;
        Resources resources = context.getResources();
        String zzao = zzao(context);
        String zzg = zzg.zzg(context, i);
        if (zzg == null) {
            zzg = resources.getString(C0666R.string.common_google_play_services_notification_ticker);
        }
        String zzc = zzg.zzc(context, i, zzao);
        PendingIntent zza = GoogleApiAvailability.getInstance().zza(context, i, 0, "n");
        if (zzmu.zzaw(context)) {
            zzx.zzab(zzne.zzsh());
            build = new Notification.Builder(context).setSmallIcon(C0666R.C0667drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(zzg + " " + zzc)).addAction(C0666R.C0667drawable.common_full_open_on_phone, resources.getString(C0666R.string.common_open_on_phone), zza).build();
        } else {
            String string = resources.getString(C0666R.string.common_google_play_services_notification_ticker);
            if (zzne.zzsd()) {
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzg).setContentText(zzc).setContentIntent(zza).setTicker(string).setAutoCancel(true);
                if (zzne.zzsl()) {
                    autoCancel.setLocalOnly(true);
                }
                if (zzne.zzsh()) {
                    autoCancel.setStyle(new Notification.BigTextStyle().bigText(zzc));
                    notification = autoCancel.build();
                } else {
                    notification = autoCancel.getNotification();
                }
                if (Build.VERSION.SDK_INT == 19) {
                    notification.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                build = notification;
            } else {
                build = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(zza).setContentTitle(zzg).setContentText(zzc).build();
            }
        }
        if (m4008a(i)) {
            f3113b.set(false);
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
    private static void m3687a(Context context) {
        C0680a aVar = new C0680a(context);
        aVar.sendMessageDelayed(aVar.obtainMessage(1), 120000);
    }

    /* access modifiers changed from: private */
    @TargetApi(21)
    /* renamed from: b */
    public static void m3688b(int i, Context context) {
        m3686a(i, context, (String) null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return m3684a(i, activity, (Fragment) null, i2, onCancelListener);
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
        Dialog a = m3684a(i, activity, fragment, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        zza(activity, onCancelListener, GMS_ERROR_DIALOG, a);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zzmu.zzaw(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zze(context, i)) {
            m3687a(context);
        } else {
            m3688b(i, context);
        }
    }

    @TargetApi(11)
    public static void zza(Activity activity, DialogInterface.OnCancelListener onCancelListener, String str, @NonNull Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (zzne.zzsd()) {
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return zze.zzbv(i);
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return zze.zze(context, i);
    }
}
