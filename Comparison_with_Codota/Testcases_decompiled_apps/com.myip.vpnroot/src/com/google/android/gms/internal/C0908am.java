package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

@C1130ez
/* renamed from: com.google.android.gms.internal.am */
public class C0908am implements Application.ActivityLifecycleCallbacks {
    private Context mContext;

    /* renamed from: mw */
    private final Object f2574mw = new Object();

    /* renamed from: nr */
    private Activity f2575nr;

    public C0908am(Application application, Activity activity) {
        application.registerActivityLifecycleCallbacks(this);
        setActivity(activity);
        this.mContext = application.getApplicationContext();
    }

    private void setActivity(Activity activity) {
        synchronized (this.f2574mw) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f2575nr = activity;
            }
        }
    }

    public Activity getActivity() {
        return this.f2575nr;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r3) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f2574mw
            monitor-enter(r1)
            android.app.Activity r0 = r2.f2575nr     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
        L_0x0008:
            return
        L_0x0009:
            android.app.Activity r0 = r2.f2575nr     // Catch:{ all -> 0x0016 }
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            r2.f2575nr = r0     // Catch:{ all -> 0x0016 }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0008
        L_0x0016:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0908am.onActivityDestroyed(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        setActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setActivity(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle savedInstanceState) {
    }

    public void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
