package com.appbrain.p032a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import com.appbrain.p037f.C1078f;
import com.appbrain.p037f.C1082j;
import com.appbrain.p037f.C1094v;
import com.appbrain.p037f.C1096x;

/* renamed from: com.appbrain.a.de */
public class C0870de {

    /* renamed from: a */
    private static final String f2314a = C0870de.class.getSimpleName();

    /* renamed from: b */
    private static C0870de f2315b;

    /* renamed from: c */
    private final Handler f2316c;

    /* renamed from: d */
    private final Context f2317d;

    /* renamed from: e */
    private long f2318e = Long.MAX_VALUE;

    /* renamed from: f */
    private long f2319f = 60000;

    /* renamed from: g */
    private final Runnable f2320g = new C0875dj(this);

    /* renamed from: h */
    private final Runnable f2321h = new C0876dk(this);

    private C0870de(Context context) {
        this.f2317d = context.getApplicationContext();
        this.f2316c = C0949gc.m4031a();
    }

    /* renamed from: a */
    public static synchronized C0870de m3790a(Context context) {
        C0870de deVar;
        synchronized (C0870de.class) {
            if (f2315b == null) {
                f2315b = new C0870de(context);
            }
            deVar = f2315b;
        }
        return deVar;
    }

    /* renamed from: a */
    static /* synthetic */ C1096x m3791a(C0870de deVar) {
        C1094v g = deVar.m3802g();
        return g == null ? C1094v.m5048m() : g.mo4027d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3792a(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (currentTimeMillis < m3800e()) {
            m3796b(currentTimeMillis);
            m3799d();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m3795a(com.appbrain.p037f.C1094v r5) {
        /*
            r4 = this;
            r0 = 4096(0x1000, float:5.74E-42)
            android.content.Context r1 = r4.f2317d     // Catch:{ Exception -> 0x0026 }
            java.lang.String r2 = "com.appbrain.ping"
            r3 = 0
            java.io.FileOutputStream r2 = r1.openFileOutput(r2, r3)     // Catch:{ Exception -> 0x0026 }
            int r1 = r5.mo4026c()     // Catch:{ all -> 0x0021 }
            if (r1 <= r0) goto L_0x001f
        L_0x0011:
            com.appbrain.b.l r0 = com.appbrain.p033b.C1008l.m4212a((java.io.OutputStream) r2, (int) r0)     // Catch:{ all -> 0x0021 }
            r5.mo4025a(r0)     // Catch:{ all -> 0x0021 }
            r0.mo3992a()     // Catch:{ all -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0026 }
        L_0x001e:
            return
        L_0x001f:
            r0 = r1
            goto L_0x0011
        L_0x0021:
            r0 = move-exception
            r2.close()     // Catch:{ Exception -> 0x0026 }
            throw r0     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            r0 = move-exception
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0870de.m3795a(com.appbrain.f.v):void");
    }

    /* renamed from: b */
    private static void m3796b(long j) {
        SharedPreferences.Editor edit = C0932fm.m3968a().mo3843b().edit();
        edit.putLong("update_ping_deadline", j);
        edit.apply();
    }

    /* renamed from: c */
    static /* synthetic */ void m3798c(C0870de deVar) {
        C1082j jVar;
        m3796b(Long.MAX_VALUE);
        deVar.f2318e = Long.MAX_VALUE;
        C1094v f = deVar.m3801f();
        if (f != null) {
            try {
                jVar = C0877dl.m3808a(deVar.f2317d).mo3754a(f);
            } catch (Exception e) {
                Log.e(f2314a, "Error during update ping", e);
                jVar = null;
            }
            if (jVar == null) {
                deVar.m3795a(f);
                deVar.m3792a(deVar.f2319f);
                deVar.f2319f = Math.min((long) (((double) deVar.f2319f) * 1.1d), 86400000);
                return;
            }
            deVar.f2319f = 60000;
            try {
                C0932fm.m3970a(deVar.f2317d, jVar.mo4342h());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (f.mo4366l()) {
                C0932fm.m3968a().mo3848g();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m3799d() {
        long e = m3800e();
        if (e < this.f2318e) {
            this.f2318e = e;
            long max = Math.max(1000, e - System.currentTimeMillis());
            this.f2316c.removeCallbacks(this.f2321h);
            this.f2316c.postDelayed(this.f2321h, max);
        }
    }

    /* renamed from: e */
    private static long m3800e() {
        return C0932fm.m3968a().mo3843b().getLong("update_ping_deadline", Long.MAX_VALUE);
    }

    /* renamed from: f */
    private C1094v m3801f() {
        C1094v g = m3802g();
        try {
            this.f2317d.deleteFile("com.appbrain.ping");
        } catch (Exception e) {
        }
        return g;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.appbrain.p037f.C1094v m3802g() {
        /*
            r2 = this;
            android.content.Context r0 = r2.f2317d     // Catch:{ Exception -> 0x0015 }
            java.lang.String r1 = "com.appbrain.ping"
            java.io.FileInputStream r1 = r0.openFileInput(r1)     // Catch:{ Exception -> 0x0015 }
            com.appbrain.f.v r0 = com.appbrain.p037f.C1094v.m5039a((java.io.InputStream) r1)     // Catch:{ all -> 0x0010 }
            r1.close()     // Catch:{ Exception -> 0x0015 }
        L_0x000f:
            return r0
        L_0x0010:
            r0 = move-exception
            r1.close()     // Catch:{ Exception -> 0x0015 }
            throw r0     // Catch:{ Exception -> 0x0015 }
        L_0x0015:
            r0 = move-exception
            r0 = 0
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appbrain.p032a.C0870de.m3802g():com.appbrain.f.v");
    }

    /* renamed from: a */
    public final void mo3743a() {
        this.f2316c.post(this.f2320g);
    }

    /* renamed from: a */
    public final void mo3744a(C1078f fVar) {
        this.f2316c.post(new C0872dg(this, fVar));
    }

    /* renamed from: a */
    public final void mo3745a(String str, int i) {
        this.f2316c.post(new C0873dh(this, str, i));
    }

    /* renamed from: b */
    public final void mo3746b() {
        this.f2316c.post(new C0871df(this));
    }

    /* renamed from: c */
    public final void mo3747c() {
        this.f2316c.post(new C0874di(this));
    }
}
