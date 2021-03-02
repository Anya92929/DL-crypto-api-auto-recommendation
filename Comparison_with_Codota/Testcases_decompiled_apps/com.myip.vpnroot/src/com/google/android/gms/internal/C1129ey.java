package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@C1130ez
/* renamed from: com.google.android.gms.internal.ey */
public class C1129ey implements Thread.UncaughtExceptionHandler {
    private Context mContext;

    /* renamed from: sR */
    private Thread.UncaughtExceptionHandler f3269sR;

    /* renamed from: sS */
    private Thread.UncaughtExceptionHandler f3270sS;

    /* renamed from: sT */
    private C1230gt f3271sT;

    public C1129ey(Context context, C1230gt gtVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.f3269sR = uncaughtExceptionHandler;
        this.f3270sS = uncaughtExceptionHandler2;
        this.mContext = context;
        this.f3271sT = gtVar;
    }

    /* renamed from: a */
    public static C1129ey m4380a(Context context, Thread thread, C1230gt gtVar) {
        if (context == null || thread == null || gtVar == null) {
            return null;
        }
        C1201gb.m4562bD();
        if (!m4383k(context)) {
            return null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        C1129ey eyVar = new C1129ey(context, gtVar, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof C1129ey)) {
            return (C1129ey) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(eyVar);
            return eyVar;
        } catch (SecurityException e) {
            C1229gs.m4682c("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    /* renamed from: cx */
    private String m4381cx() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? str2 : str + " " + str2;
    }

    /* renamed from: d */
    private Throwable m4382d(Throwable th) {
        Throwable th2;
        Bundle bD = C1201gb.m4562bD();
        if (bD != null && bD.getBoolean("gads:sdk_crash_report_full_stacktrace", false)) {
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
                if (mo8459G(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (mo8460H(stackTraceElement.getClassName())) {
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

    /* renamed from: k */
    private static boolean m4383k(Context context) {
        Bundle bD = C1201gb.m4562bD();
        return bD != null && bD.getBoolean("gads:sdk_crash_report_enabled", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public boolean mo8459G(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(C1130ez.class);
        } catch (Exception e) {
            C1229gs.m4680a("Fail to check class type for class " + str, e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public boolean mo8460H(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo8461a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (mo8459G(stackTraceElement.getClassName())) {
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

    /* renamed from: b */
    public void mo8462b(Throwable th) {
        Throwable d;
        if (m4383k(this.mContext) && (d = m4382d(th)) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(mo8463c(d));
            C1213gj.m4618a(this.mContext, this.f3271sT.f3777wD, (List<String>) arrayList, C1201gb.m4569df());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo8463c(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", m4381cx()).appendQueryParameter("js", this.f3271sT.f3777wD).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", stringWriter.toString()).toString();
    }

    public void uncaughtException(Thread thread, Throwable exception) {
        if (mo8461a(exception)) {
            mo8462b(exception);
            if (Looper.getMainLooper().getThread() != thread) {
                return;
            }
        }
        if (this.f3269sR != null) {
            this.f3269sR.uncaughtException(thread, exception);
        } else if (this.f3270sS != null) {
            this.f3270sS.uncaughtException(thread, exception);
        }
    }
}
