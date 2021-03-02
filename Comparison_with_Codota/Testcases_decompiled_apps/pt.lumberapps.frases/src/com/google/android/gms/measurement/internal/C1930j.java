package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
/* renamed from: com.google.android.gms.measurement.internal.j */
class C1930j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    final /* synthetic */ zzac f7214a;

    private C1930j(zzac zzac) {
        this.f7214a = zzac;
    }

    /* synthetic */ C1930j(zzac zzac, C1924d dVar) {
        this(zzac);
    }

    /* renamed from: a */
    private boolean m7713a(Uri uri) {
        String queryParameter = uri.getQueryParameter("utm_campaign");
        String queryParameter2 = uri.getQueryParameter("utm_source");
        String queryParameter3 = uri.getQueryParameter("utm_medium");
        String queryParameter4 = uri.getQueryParameter("gclid");
        if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4)) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(queryParameter)) {
            bundle.putString("campaign", queryParameter);
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            bundle.putString("source", queryParameter2);
        }
        if (!TextUtils.isEmpty(queryParameter3)) {
            bundle.putString("medium", queryParameter3);
        }
        if (!TextUtils.isEmpty(queryParameter4)) {
            bundle.putString("gclid", queryParameter4);
        }
        String queryParameter5 = uri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(queryParameter5)) {
            bundle.putString("term", queryParameter5);
        }
        String queryParameter6 = uri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(queryParameter6)) {
            bundle.putString("content", queryParameter6);
        }
        String queryParameter7 = uri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(queryParameter7)) {
            bundle.putString("aclid", queryParameter7);
        }
        String queryParameter8 = uri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(queryParameter8)) {
            bundle.putString("cp1", queryParameter8);
        }
        String queryParameter9 = uri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(queryParameter9)) {
            bundle.putString("anid", queryParameter9);
        }
        this.f7214a.zze("auto", "_cmp", bundle);
        return true;
    }

    /* renamed from: a */
    private boolean m7714a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f7214a.zzd("auto", "_ldl", str);
        return true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Uri data;
        try {
            this.f7214a.zzbsd().zzbtc().log("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null && (data = intent.getData()) != null && data.isHierarchical()) {
                if (bundle == null) {
                    m7713a(data);
                }
                String queryParameter = data.getQueryParameter("referrer");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!queryParameter.contains("gclid")) {
                        this.f7214a.zzbsd().zzbtb().log("Activity created with data 'referrer' param without gclid");
                        return;
                    }
                    this.f7214a.zzbsd().zzbtb().zzj("Activity created with referrer", queryParameter);
                    m7714a(queryParameter);
                }
            }
        } catch (Throwable th) {
            this.f7214a.zzbsd().zzbsv().zzj("Throwable caught in onActivityCreated", th);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.f7214a.zzbsb().mo9422f();
    }

    public void onActivityResumed(Activity activity) {
        this.f7214a.zzbsb().mo9421e();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
