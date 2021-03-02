package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.google.android.gms.C0171R;

public class GoogleApiAvailability extends zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailability zzafE = new GoogleApiAvailability();

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzafE;
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode);
    }

    public Dialog getErrorDialog(Activity activity, int errorCode, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.getErrorDialog(errorCode, activity, requestCode, cancelListener);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int errorCode, int requestCode) {
        return super.getErrorResolutionPendingIntent(context, errorCode, requestCode);
    }

    public final String getErrorString(int errorCode) {
        return super.getErrorString(errorCode);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return super.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public final boolean isUserResolvableError(int errorCode) {
        return super.isUserResolvableError(errorCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode);
    }

    public boolean showErrorDialogFragment(Activity activity, int errorCode, int requestCode, DialogInterface.OnCancelListener cancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(errorCode, activity, requestCode, cancelListener);
    }

    public void showErrorNotification(Context context, int errorCode) {
        GooglePlayServicesUtil.showErrorNotification(errorCode, context);
    }

    public Dialog zza(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        String zzao = GooglePlayServicesUtil.zzao(activity);
        builder.setMessage(activity.getResources().getString(C0171R.string.common_google_play_services_updating_text, new Object[]{zzao}));
        builder.setTitle(C0171R.string.common_google_play_services_updating_title);
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        GooglePlayServicesUtil.zza(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        return super.zza(context, i, i2, str);
    }

    @Nullable
    public Intent zza(Context context, int i, @Nullable String str) {
        return super.zza(context, i, str);
    }

    public int zzaj(Context context) {
        return super.zzaj(context);
    }

    @Nullable
    @Deprecated
    public Intent zzbu(int i) {
        return super.zzbu(i);
    }

    public boolean zzd(Context context, int i) {
        return super.zzd(context, i);
    }
}
