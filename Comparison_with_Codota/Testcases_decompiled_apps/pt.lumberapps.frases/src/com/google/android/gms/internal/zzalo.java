package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.C1975b;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class zzalo implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a */
    private static final zzalo f5760a = new zzalo();

    /* renamed from: b */
    private final AtomicBoolean f5761b = new AtomicBoolean();

    /* renamed from: c */
    private boolean f5762c;

    private zzalo() {
    }

    public static void zza(Application application) {
        application.registerActivityLifecycleCallbacks(f5760a);
        application.registerComponentCallbacks(f5760a);
        f5760a.f5762c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f5761b.compareAndSet(true, false)) {
            C1975b.m8083a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f5761b.compareAndSet(true, false)) {
            C1975b.m8083a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f5761b.compareAndSet(false, true)) {
            C1975b.m8083a(true);
        }
    }
}
