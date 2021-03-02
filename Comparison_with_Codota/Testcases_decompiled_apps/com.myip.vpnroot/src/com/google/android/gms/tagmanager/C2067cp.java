package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0976c;
import com.google.android.gms.tagmanager.C2135o;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.tagmanager.cp */
class C2067cp implements C2135o.C2142e {
    /* access modifiers changed from: private */
    public final String anR;
    private String aon;
    private C2026bg<C0976c.C0986j> aqi;
    private C2146r aqj;
    private final ScheduledExecutorService aql;
    private final C2070a aqm;
    private ScheduledFuture<?> aqn;
    private boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp$a */
    interface C2070a {
        /* renamed from: a */
        C2066co mo11641a(C2146r rVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp$b */
    interface C2071b {
        /* renamed from: oO */
        ScheduledExecutorService mo11640oO();
    }

    public C2067cp(Context context, String str, C2146r rVar) {
        this(context, str, rVar, (C2071b) null, (C2070a) null);
    }

    C2067cp(Context context, String str, C2146r rVar, C2071b bVar, C2070a aVar) {
        this.aqj = rVar;
        this.mContext = context;
        this.anR = str;
        this.aql = (bVar == null ? new C2071b() {
            /* renamed from: oO */
            public ScheduledExecutorService mo11640oO() {
                return Executors.newSingleThreadScheduledExecutor();
            }
        } : bVar).mo11640oO();
        if (aVar == null) {
            this.aqm = new C2070a() {
                /* renamed from: a */
                public C2066co mo11641a(C2146r rVar) {
                    return new C2066co(C2067cp.this.mContext, C2067cp.this.anR, rVar);
                }
            };
        } else {
            this.aqm = aVar;
        }
    }

    /* renamed from: cH */
    private C2066co m6937cH(String str) {
        C2066co a = this.aqm.mo11641a(this.aqj);
        a.mo11632a(this.aqi);
        a.mo11634cr(this.aon);
        a.mo11633cG(str);
        return a;
    }

    /* renamed from: oN */
    private synchronized void m6938oN() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo11637a(C2026bg<C0976c.C0986j> bgVar) {
        m6938oN();
        this.aqi = bgVar;
    }

    /* renamed from: cr */
    public synchronized void mo11638cr(String str) {
        m6938oN();
        this.aon = str;
    }

    /* renamed from: e */
    public synchronized void mo11639e(long j, String str) {
        C2028bh.m6818V("loadAfterDelay: containerId=" + this.anR + " delay=" + j);
        m6938oN();
        if (this.aqi == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.aqn != null) {
            this.aqn.cancel(false);
        }
        this.aqn = this.aql.schedule(m6937cH(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        m6938oN();
        if (this.aqn != null) {
            this.aqn.cancel(false);
        }
        this.aql.shutdown();
        this.mClosed = true;
    }
}
