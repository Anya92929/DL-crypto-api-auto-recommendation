package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zzin
public class zzim implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f6428a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f6429b;

    /* renamed from: c */
    private Context f6430c;

    /* renamed from: d */
    private VersionInfoParcel f6431d;

    public zzim(Context context, VersionInfoParcel versionInfoParcel, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.f6428a = uncaughtExceptionHandler;
        this.f6429b = uncaughtExceptionHandler2;
        this.f6430c = context;
        this.f6431d = versionInfoParcel;
    }

    /* renamed from: a */
    private static boolean m7206a(Context context) {
        return ((Boolean) zzdc.zzayd.get()).booleanValue();
    }

    /* renamed from: b */
    private Throwable m7207b(Throwable th) {
        Throwable th2;
        if (((Boolean) zzdc.zzaye.get()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th3 = null;
        while (!linkedList.isEmpty()) {
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (mo8533a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (mo8535b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (z) {
                th2 = th3 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th3);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th2 = th3;
            }
            th3 = th2;
        }
        return th3;
    }

    public static zzim zza(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!m7206a(context)) {
            return null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        zzim zzim = new zzim(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzim)) {
            return (zzim) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(zzim);
            return zzim;
        } catch (SecurityException e) {
            zzkd.zzc("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo8532a(Class cls, Throwable th, boolean z) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", zzu.zzfq().zztg()).appendQueryParameter("js", this.f6431d.zzcs).appendQueryParameter("appid", this.f6430c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzdc.zzjx())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8533a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) zzdc.zzayf.get())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zzin.class);
        } catch (Exception e) {
            Exception exc = e;
            String valueOf = String.valueOf(str);
            zzkd.zza(valueOf.length() != 0 ? "Fail to check class type for class ".concat(valueOf) : new String("Fail to check class type for class "), exc);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8534a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (mo8533a(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || z2) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8535b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (mo8534a(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                zza(th, true);
                return;
            }
            zza(th, false);
        }
        if (this.f6428a != null) {
            this.f6428a.uncaughtException(thread, th);
        } else if (this.f6429b != null) {
            this.f6429b.uncaughtException(thread, th);
        }
    }

    public void zza(Throwable th, boolean z) {
        Throwable b;
        if (m7206a(this.f6430c) && (b = m7207b(th)) != null) {
            Class<?> cls = th.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add(mo8532a(cls, b, z));
            zzu.zzfq().zza((List) arrayList, zzu.zzft().zzso());
        }
    }
}
