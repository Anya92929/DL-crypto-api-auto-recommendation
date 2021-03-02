package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.C0561i;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.k */
public class C0580k implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private final Thread.UncaughtExceptionHandler f3911a;

    /* renamed from: b */
    private final C0589t f3912b;

    /* renamed from: c */
    private final Context f3913c;

    /* renamed from: d */
    private C0579j f3914d;

    /* renamed from: e */
    private C0581l f3915e;

    public C0580k(C0589t tVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tVar == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.f3911a = uncaughtExceptionHandler;
            this.f3912b = tVar;
            this.f3914d = new C0588s(context, new ArrayList());
            this.f3913c = context.getApplicationContext();
            C0561i.m3262b("ExceptionReporter created, original handler is " + (uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0581l mo6899a() {
        if (this.f3915e == null) {
            this.f3915e = C0581l.m3407a(this.f3913c);
        }
        return this.f3915e;
    }

    /* renamed from: a */
    public void mo6900a(C0579j jVar) {
        this.f3914d = jVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.f3914d != null) {
            str = this.f3914d.mo6898a(thread != null ? thread.getName() : null, th);
        }
        C0561i.m3262b("Reporting uncaught exception: " + str);
        this.f3912b.mo6930a((Map<String, String>) new C0584o().mo6917a(str).mo6918a(true).mo6914a());
        C0581l a = mo6899a();
        a.mo6911i();
        a.mo6912j();
        if (this.f3911a != null) {
            C0561i.m3262b("Passing exception to the original handler");
            this.f3911a.uncaughtException(thread, th);
        }
    }
}
