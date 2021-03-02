package com.google.ads;

import android.app.Activity;
import android.view.View;
import com.google.ads.g;
import com.google.ads.internal.d;
import com.google.ads.util.a;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class e {
    /* access modifiers changed from: private */
    public final d a;
    /* access modifiers changed from: private */
    public h b;
    private Object c;
    /* access modifiers changed from: private */
    public Thread d;
    /* access modifiers changed from: private */
    public Object e;
    private boolean f;
    private Object g;

    public e(d dVar) {
        this.b = null;
        this.c = new Object();
        this.d = null;
        this.e = new Object();
        this.f = false;
        this.g = new Object();
        a.b((Object) dVar);
        this.a = dVar;
    }

    public boolean a() {
        boolean z;
        synchronized (this.e) {
            z = this.d != null;
        }
        return z;
    }

    public void b() {
        synchronized (this.g) {
            this.f = true;
            d((h) null);
            synchronized (this.e) {
                if (this.d != null) {
                    this.d.interrupt();
                }
            }
        }
    }

    public void a(final c cVar, final AdRequest adRequest) {
        synchronized (this.e) {
            if (a()) {
                b.c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
                return;
            }
            a(cVar, this.a);
            this.d = new Thread(new Runnable() {
                public void run() {
                    e.this.b(cVar, adRequest);
                    synchronized (e.this.e) {
                        Thread unused = e.this.d = null;
                    }
                }
            });
            this.d.start();
        }
    }

    public static boolean a(c cVar, d dVar) {
        if (cVar.j() == null) {
            return true;
        }
        if (!dVar.h().b()) {
            AdSize b2 = dVar.h().i.a().b();
            if (cVar.j().a()) {
                b.e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + b2 + ") in the ad-type field in the mediation UI.");
                return false;
            }
            AdSize b3 = cVar.j().b();
            if (b3 == b2) {
                return true;
            }
            b.e("Mediation server returned ad size: '" + b3 + "', while the AdView was created with ad size: '" + b2 + "'. Using the ad-size passed to the AdView on creation.");
            return false;
        } else if (cVar.j().a()) {
            return true;
        } else {
            b.e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
            return false;
        }
    }

    private boolean a(h hVar, String str) {
        if (e() == hVar) {
            return true;
        }
        b.c("GWController: ignoring callback to " + str + " from non showing ambassador with adapter class: '" + hVar.h() + "'.");
        return false;
    }

    public void a(h hVar, final boolean z) {
        if (a(hVar, "onAdClicked()")) {
            final f a2 = hVar.a();
            this.a.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.a(a2, z);
                }
            });
        }
    }

    public void a(h hVar, final View view) {
        if (e() != hVar) {
            b.c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + hVar.h() + "').");
            return;
        }
        this.a.m().a(g.a.AD);
        final f a2 = this.b.a();
        this.a.a((Runnable) new Runnable() {
            public void run() {
                e.this.a.a(view, e.this.b, a2, true);
            }
        });
    }

    public void a(h hVar) {
        if (a(hVar, "onPresentScreen")) {
            this.a.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.u();
                }
            });
        }
    }

    public void b(h hVar) {
        if (a(hVar, "onDismissScreen")) {
            this.a.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.t();
                }
            });
        }
    }

    public void c(h hVar) {
        if (a(hVar, "onLeaveApplication")) {
            this.a.a((Runnable) new Runnable() {
                public void run() {
                    e.this.a.v();
                }
            });
        }
    }

    public boolean c() {
        a.a(this.a.h().b());
        h e2 = e();
        if (e2 != null) {
            e2.g();
            return true;
        }
        b.b("There is no ad ready to show.");
        return false;
    }

    protected e() {
        this.b = null;
        this.c = new Object();
        this.d = null;
        this.e = new Object();
        this.f = false;
        this.g = new Object();
        this.a = null;
    }

    private boolean d() {
        boolean z;
        synchronized (this.g) {
            z = this.f;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public void b(final c cVar, AdRequest adRequest) {
        synchronized (this.e) {
            a.a((Object) Thread.currentThread(), (Object) this.d);
        }
        List<a> f2 = cVar.f();
        long b2 = cVar.a() ? (long) cVar.b() : 10000;
        for (a next : f2) {
            b.a("Looking to fetch ads from network: " + next.b());
            List<String> c2 = next.c();
            HashMap<String, String> d2 = next.d();
            f fVar = new f(next.a(), next.b(), cVar.c(), cVar.g(), cVar.h(), cVar.i());
            Iterator<String> it = c2.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next2 = it.next();
                    Activity a2 = this.a.h().c.a();
                    if (a2 == null) {
                        b.a("Activity is null while mediating.  Terminating mediation thread.");
                        return;
                    }
                    this.a.m().c();
                    if (a(next2, a2, adRequest, fVar, d2, b2)) {
                        return;
                    }
                    if (d()) {
                        b.a("GWController.destroy() called. Terminating mediation thread.");
                        return;
                    }
                }
            }
        }
        this.a.a((Runnable) new Runnable() {
            public void run() {
                e.this.a.b(cVar);
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r8, android.app.Activity r9, com.google.ads.AdRequest r10, final com.google.ads.f r11, java.util.HashMap<java.lang.String, java.lang.String> r12, long r13) {
        /*
            r7 = this;
            com.google.ads.h r0 = new com.google.ads.h
            com.google.ads.internal.d r1 = r7.a
            com.google.ads.m r1 = r1.h()
            com.google.ads.util.i$b<com.google.ads.internal.h> r1 = r1.i
            java.lang.Object r2 = r1.a()
            com.google.ads.internal.h r2 = (com.google.ads.internal.h) r2
            r1 = r7
            r3 = r11
            r4 = r8
            r5 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            monitor-enter(r0)
            r0.a((android.app.Activity) r9)     // Catch:{ all -> 0x008e }
        L_0x001c:
            boolean r1 = r0.c()     // Catch:{ InterruptedException -> 0x0037 }
            if (r1 != 0) goto L_0x004e
            r1 = 0
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x0037 }
            r0.wait(r13)     // Catch:{ InterruptedException -> 0x0037 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x0037 }
            long r1 = r3 - r1
            long r13 = r13 - r1
            goto L_0x001c
        L_0x0037:
            r1 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r1.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r2 = "Interrupted while waiting for ad network to load ad using adapter class: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x008e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x008e }
            com.google.ads.util.b.a((java.lang.String) r1)     // Catch:{ all -> 0x008e }
        L_0x004e:
            com.google.ads.internal.d r1 = r7.a     // Catch:{ all -> 0x008e }
            com.google.ads.internal.g r1 = r1.m()     // Catch:{ all -> 0x008e }
            com.google.ads.g$a r2 = r0.e()     // Catch:{ all -> 0x008e }
            r1.a((com.google.ads.g.a) r2)     // Catch:{ all -> 0x008e }
            boolean r1 = r0.c()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0087
            boolean r1 = r0.d()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0087
            com.google.ads.internal.d r1 = r7.a     // Catch:{ all -> 0x008e }
            com.google.ads.m r1 = r1.h()     // Catch:{ all -> 0x008e }
            boolean r1 = r1.b()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0082
            r1 = 0
        L_0x0074:
            com.google.ads.internal.d r2 = r7.a     // Catch:{ all -> 0x008e }
            com.google.ads.e$8 r3 = new com.google.ads.e$8     // Catch:{ all -> 0x008e }
            r3.<init>(r0, r1, r11)     // Catch:{ all -> 0x008e }
            r2.a((java.lang.Runnable) r3)     // Catch:{ all -> 0x008e }
            r1 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            r0 = r1
        L_0x0081:
            return r0
        L_0x0082:
            android.view.View r1 = r0.f()     // Catch:{ all -> 0x008e }
            goto L_0x0074
        L_0x0087:
            r0.b()     // Catch:{ all -> 0x008e }
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            r0 = r1
            goto L_0x0081
        L_0x008e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.e.a(java.lang.String, android.app.Activity, com.google.ads.AdRequest, com.google.ads.f, java.util.HashMap, long):boolean");
    }

    /* access modifiers changed from: private */
    public boolean e(h hVar) {
        boolean z;
        synchronized (this.g) {
            if (d()) {
                hVar.b();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private h e() {
        h hVar;
        synchronized (this.c) {
            hVar = this.b;
        }
        return hVar;
    }

    public void d(h hVar) {
        synchronized (this.c) {
            if (this.b != hVar) {
                if (this.b != null) {
                    this.b.b();
                }
                this.b = hVar;
            }
        }
    }
}
