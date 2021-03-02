package com.google.android.gms.p018c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.C0570r;
import com.google.android.gms.common.internal.C1009bf;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.c.aq */
public final class C0628aq {

    /* renamed from: a */
    private static volatile C0628aq f4242a;

    /* renamed from: b */
    private final Context f4243b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<C0634aw> f4244c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private final C0622ak f4245d = new C0622ak();

    /* renamed from: e */
    private final C0630as f4246e = new C0630as(this);

    /* renamed from: f */
    private volatile C0636ay f4247f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Thread.UncaughtExceptionHandler f4248g;

    C0628aq(Context context) {
        Context applicationContext = context.getApplicationContext();
        C1009bf.m4528a(applicationContext);
        this.f4243b = applicationContext;
    }

    /* renamed from: a */
    public static C0628aq m3617a(Context context) {
        C1009bf.m4528a(context);
        if (f4242a == null) {
            synchronized (C0628aq.class) {
                if (f4242a == null) {
                    f4242a = new C0628aq(context);
                }
            }
        }
        return f4242a;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m3621b(C0624am amVar) {
        C1009bf.m4538c("deliver should be called from worker thread");
        C1009bf.m4537b(amVar.mo7003f(), "Measurement must be submitted");
        List<C0635ax> c = amVar.mo7000c();
        if (!c.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (C0635ax next : c) {
                Uri a = next.mo6940a();
                if (!hashSet.contains(a)) {
                    hashSet.add(a);
                    next.mo6941a(amVar);
                }
            }
        }
    }

    /* renamed from: d */
    public static void m3622d() {
        if (!(Thread.currentThread() instanceof C0633av)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* renamed from: a */
    public C0636ay mo7015a() {
        if (this.f4247f == null) {
            synchronized (this) {
                if (this.f4247f == null) {
                    C0636ay ayVar = new C0636ay();
                    PackageManager packageManager = this.f4243b.getPackageManager();
                    String packageName = this.f4243b.getPackageName();
                    ayVar.mo7034c(packageName);
                    ayVar.mo7036d(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f4243b.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    ayVar.mo7030a(packageName);
                    ayVar.mo7032b(str);
                    this.f4247f = ayVar;
                }
            }
        }
        return this.f4247f;
    }

    /* renamed from: a */
    public <V> Future<V> mo7016a(Callable<V> callable) {
        C1009bf.m4528a(callable);
        if (!(Thread.currentThread() instanceof C0633av)) {
            return this.f4246e.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7017a(C0624am amVar) {
        if (amVar.mo7007j()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (amVar.mo7003f()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            C0624am a = amVar.mo6994a();
            a.mo7004g();
            this.f4246e.execute(new C0629ar(this, a));
        }
    }

    /* renamed from: a */
    public void mo7018a(Runnable runnable) {
        C1009bf.m4528a(runnable);
        this.f4246e.submit(runnable);
    }

    /* renamed from: a */
    public void mo7019a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f4248g = uncaughtExceptionHandler;
    }

    /* renamed from: b */
    public C0639ba mo7020b() {
        DisplayMetrics displayMetrics = this.f4243b.getResources().getDisplayMetrics();
        C0639ba baVar = new C0639ba();
        baVar.mo7063a(C0570r.m3327a(Locale.getDefault()));
        baVar.mo7065b(displayMetrics.widthPixels);
        baVar.mo7067c(displayMetrics.heightPixels);
        return baVar;
    }

    /* renamed from: c */
    public Context mo7021c() {
        return this.f4243b;
    }
}
