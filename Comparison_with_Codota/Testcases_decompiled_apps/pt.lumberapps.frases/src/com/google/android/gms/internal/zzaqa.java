package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class zzaqa {

    /* renamed from: a */
    private static String f5918a;

    /* renamed from: a */
    private static boolean m6877a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                return false;
            }
            for (ResolveInfo next : queryIntentActivities) {
                IntentFilter intentFilter = next.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && next.activityInfo != null) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
    }

    public static String zzex(Context context) {
        if (f5918a != null) {
            return f5918a;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        String str = resolveActivity != null ? resolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo next : queryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(next.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(next.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            f5918a = null;
        } else if (arrayList.size() == 1) {
            f5918a = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str) && !m6877a(context, intent) && arrayList.contains(str)) {
            f5918a = str;
        } else if (arrayList.contains("com.android.chrome")) {
            f5918a = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            f5918a = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            f5918a = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            f5918a = "com.google.android.apps.chrome";
        }
        return f5918a;
    }
}
