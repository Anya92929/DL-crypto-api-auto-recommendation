package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import java.lang.Thread;
import java.util.ArrayList;

public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Context mContext;

    /* renamed from: xX */
    private final Thread.UncaughtExceptionHandler f88xX;

    /* renamed from: xY */
    private final Tracker f89xY;

    /* renamed from: xZ */
    private ExceptionParser f90xZ;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler originalHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.f88xX = originalHandler;
            this.f89xY = tracker;
            this.f90xZ = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            C0207z.m308V("ExceptionReporter created, original handler is " + (originalHandler == null ? "null" : originalHandler.getClass().getName()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dZ */
    public Thread.UncaughtExceptionHandler mo3477dZ() {
        return this.f88xX;
    }

    public ExceptionParser getExceptionParser() {
        return this.f90xZ;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.f90xZ = exceptionParser;
    }

    public void uncaughtException(Thread t, Throwable e) {
        String str = "UncaughtException";
        if (this.f90xZ != null) {
            str = this.f90xZ.getDescription(t != null ? t.getName() : null, e);
        }
        C0207z.m308V("Tracking Exception: " + str);
        this.f89xY.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
        if (this.f88xX != null) {
            C0207z.m308V("Passing exception to original handler.");
            this.f88xX.uncaughtException(t, e);
        }
    }
}
