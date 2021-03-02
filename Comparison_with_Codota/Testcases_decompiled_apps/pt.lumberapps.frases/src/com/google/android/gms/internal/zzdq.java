package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@zzin
public class zzdq implements zzaqc {

    /* renamed from: a */
    private CustomTabsSession f6131a;

    /* renamed from: b */
    private CustomTabsClient f6132b;

    /* renamed from: c */
    private CustomTabsServiceConnection f6133c;

    /* renamed from: d */
    private zza f6134d;

    public interface zza {
        void zzkn();

        void zzko();
    }

    public static boolean zzo(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(zzaqa.zzex(context));
            }
        }
        return false;
    }

    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List list) {
        CustomTabsSession zzkl;
        if (this.f6132b == null || (zzkl = zzkl()) == null) {
            return false;
        }
        return zzkl.mayLaunchUrl(uri, bundle, list);
    }

    public void zza(CustomTabsClient customTabsClient) {
        this.f6132b = customTabsClient;
        this.f6132b.warmup(0);
        if (this.f6134d != null) {
            this.f6134d.zzkn();
        }
    }

    public void zza(zza zza2) {
        this.f6134d = zza2;
    }

    public void zzd(Activity activity) {
        if (this.f6133c != null) {
            activity.unbindService(this.f6133c);
            this.f6132b = null;
            this.f6131a = null;
            this.f6133c = null;
        }
    }

    public void zze(Activity activity) {
        String zzex;
        if (this.f6132b == null && (zzex = zzaqa.zzex(activity)) != null) {
            this.f6133c = new zzaqb(this);
            CustomTabsClient.bindCustomTabsService(activity, zzex, this.f6133c);
        }
    }

    public CustomTabsSession zzkl() {
        if (this.f6132b == null) {
            this.f6131a = null;
        } else if (this.f6131a == null) {
            this.f6131a = this.f6132b.newSession((CustomTabsCallback) null);
        }
        return this.f6131a;
    }

    public void zzkm() {
        this.f6132b = null;
        this.f6131a = null;
        if (this.f6134d != null) {
            this.f6134d.zzko();
        }
    }
}
