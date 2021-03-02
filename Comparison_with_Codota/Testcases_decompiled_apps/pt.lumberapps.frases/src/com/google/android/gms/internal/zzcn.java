package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

@TargetApi(14)
@zzin
public class zzcn implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Activity f6060a;

    /* renamed from: b */
    private Context f6061b;

    /* renamed from: c */
    private final Object f6062c = new Object();

    public zzcn(Application application, Context context) {
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            m6955a((Activity) context);
        }
        this.f6061b = context;
    }

    /* renamed from: a */
    private void m6955a(Activity activity) {
        synchronized (this.f6062c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f6060a = activity;
            }
        }
    }

    public Activity getActivity() {
        return this.f6060a;
    }

    public Context getContext() {
        return this.f6061b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r3) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f6062c
            monitor-enter(r1)
            android.app.Activity r0 = r2.f6060a     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
        L_0x0008:
            return
        L_0x0009:
            android.app.Activity r0 = r2.f6060a     // Catch:{ all -> 0x0016 }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            r2.f6060a = r0     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0008
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcn.onActivityDestroyed(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        m6955a(activity);
    }

    public void onActivityResumed(Activity activity) {
        m6955a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        m6955a(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
