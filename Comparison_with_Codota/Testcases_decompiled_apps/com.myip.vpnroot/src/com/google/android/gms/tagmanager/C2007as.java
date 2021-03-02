package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.tagmanager.as */
class C2007as extends Thread implements C2006ar {
    private static C2007as ape;
    private final LinkedBlockingQueue<Runnable> apd = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public volatile C2009at apf;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: yU */
    private volatile boolean f4538yU = false;

    private C2007as(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: Y */
    static C2007as m6770Y(Context context) {
        if (ape == null) {
            ape = new C2007as(context);
        }
        return ape;
    }

    /* renamed from: g */
    private String m6774g(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: b */
    public void mo11557b(Runnable runnable) {
        this.apd.add(runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo11559b(String str, long j) {
        final long j2 = j;
        final String str2 = str;
        mo11557b((Runnable) new Runnable() {
            public void run() {
                if (C2007as.this.apf == null) {
                    C2097cy pu = C2097cy.m7060pu();
                    pu.mo11723a(C2007as.this.mContext, this);
                    C2009at unused = C2007as.this.apf = pu.mo11725pv();
                }
                C2007as.this.apf.mo11563f(j2, str2);
            }
        });
    }

    /* renamed from: cz */
    public void mo11558cz(String str) {
        mo11559b(str, System.currentTimeMillis());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable take = this.apd.take();
                if (!this.f4538yU) {
                    take.run();
                }
            } catch (InterruptedException e) {
                C2028bh.m6817U(e.toString());
            } catch (Throwable th) {
                C2028bh.m6816T("Error on Google TagManager Thread: " + m6774g(th));
                C2028bh.m6816T("Google TagManager is shutting down.");
                this.f4538yU = true;
            }
        }
    }
}
