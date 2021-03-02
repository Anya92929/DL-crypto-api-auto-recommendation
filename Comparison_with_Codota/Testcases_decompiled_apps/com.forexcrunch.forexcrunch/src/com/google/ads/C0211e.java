package com.google.ads;

import android.app.Activity;
import android.view.View;
import com.google.ads.C0221g;
import com.google.ads.internal.C0247d;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.ads.e */
public class C0211e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0247d f391a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0223h f392b;

    /* renamed from: c */
    private final Object f393c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Thread f394d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f395e;

    /* renamed from: f */
    private boolean f396f;

    /* renamed from: g */
    private final Object f397g;

    public C0211e(C0247d dVar) {
        this.f392b = null;
        this.f393c = new Object();
        this.f394d = null;
        this.f395e = new Object();
        this.f396f = false;
        this.f397g = new Object();
        C0282a.m474b((Object) dVar);
        this.f391a = dVar;
    }

    /* renamed from: a */
    public boolean mo3389a() {
        boolean z;
        synchronized (this.f395e) {
            z = this.f394d != null;
        }
        return z;
    }

    /* renamed from: b */
    public void mo3390b() {
        synchronized (this.f397g) {
            this.f396f = true;
            mo3394d((C0223h) null);
            synchronized (this.f395e) {
                if (this.f394d != null) {
                    this.f394d.interrupt();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3385a(final C0208c cVar, final AdRequest adRequest) {
        synchronized (this.f395e) {
            if (mo3389a()) {
                C0284b.m486c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
                return;
            }
            if (cVar.mo3365d()) {
                this.f391a.mo3523a((float) cVar.mo3366e());
                if (!this.f391a.mo3561t()) {
                    this.f391a.mo3548g();
                }
            } else if (this.f391a.mo3561t()) {
                this.f391a.mo3547f();
            }
            m156a(cVar, this.f391a);
            this.f394d = new Thread(new Runnable() {
                public void run() {
                    C0211e.this.m161b(cVar, adRequest);
                    synchronized (C0211e.this.f395e) {
                        Thread unused = C0211e.this.f394d = null;
                    }
                }
            });
            this.f394d.start();
        }
    }

    /* renamed from: a */
    public static boolean m156a(C0208c cVar, C0247d dVar) {
        if (cVar.mo3371j() == null) {
            return true;
        }
        if (!dVar.mo3550i().mo3684b()) {
            AdSize c = dVar.mo3550i().f660g.mo3725a().mo3612c();
            if (cVar.mo3371j().mo3609a()) {
                C0284b.m490e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + c + ") in the ad-type field in the mediation UI.");
                return false;
            }
            AdSize c2 = cVar.mo3371j().mo3612c();
            if (c2 == c) {
                return true;
            }
            C0284b.m490e("Mediation server returned ad size: '" + c2 + "', while the AdView was created with ad size: '" + c + "'. Using the ad-size passed to the AdView on creation.");
            return false;
        } else if (cVar.mo3371j().mo3609a()) {
            return true;
        } else {
            C0284b.m490e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
            return false;
        }
    }

    /* renamed from: a */
    private boolean m158a(C0223h hVar, String str) {
        if (m164e() == hVar) {
            return true;
        }
        C0284b.m486c("GWController: ignoring callback to " + str + " from non showing ambassador with adapter class: '" + hVar.mo3419h() + "'.");
        return false;
    }

    /* renamed from: a */
    public void mo3388a(C0223h hVar, final boolean z) {
        if (m158a(hVar, "onAdClicked()")) {
            final C0220f a = hVar.mo3408a();
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    C0211e.this.f391a.mo3532a(a, z);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo3387a(C0223h hVar, final View view) {
        if (m164e() != hVar) {
            C0284b.m486c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + hVar.mo3419h() + "').");
            return;
        }
        this.f391a.mo3555n().mo3581a(C0221g.C0222a.AD);
        final C0220f a = this.f392b.mo3408a();
        C0265m.m411a().f617c.mo3725a().post(new Runnable() {
            public void run() {
                C0211e.this.f391a.mo3528a(view, C0211e.this.f392b, a, true);
            }
        });
    }

    /* renamed from: a */
    public void mo3386a(C0223h hVar) {
        if (m158a(hVar, "onPresentScreen")) {
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    C0211e.this.f391a.mo3563v();
                }
            });
        }
    }

    /* renamed from: b */
    public void mo3391b(C0223h hVar) {
        if (m158a(hVar, "onDismissScreen")) {
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    C0211e.this.f391a.mo3562u();
                }
            });
        }
    }

    /* renamed from: c */
    public void mo3392c(C0223h hVar) {
        if (m158a(hVar, "onLeaveApplication")) {
            C0265m.m411a().f617c.mo3725a().post(new Runnable() {
                public void run() {
                    C0211e.this.f391a.mo3564w();
                }
            });
        }
    }

    /* renamed from: c */
    public boolean mo3393c() {
        C0282a.m472a(this.f391a.mo3550i().mo3684b());
        C0223h e = m164e();
        if (e != null) {
            e.mo3418g();
            return true;
        }
        C0284b.m484b("There is no ad ready to show.");
        return false;
    }

    protected C0211e() {
        this.f392b = null;
        this.f393c = new Object();
        this.f394d = null;
        this.f395e = new Object();
        this.f396f = false;
        this.f397g = new Object();
        this.f391a = null;
    }

    /* renamed from: d */
    private boolean m163d() {
        boolean z;
        synchronized (this.f397g) {
            z = this.f396f;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m161b(final C0208c cVar, AdRequest adRequest) {
        synchronized (this.f395e) {
            C0282a.m470a((Object) Thread.currentThread(), (Object) this.f394d);
        }
        List<C0166a> f = cVar.mo3367f();
        long b = cVar.mo3362a() ? (long) cVar.mo3363b() : 10000;
        for (C0166a next : f) {
            C0284b.m480a("Looking to fetch ads from network: " + next.mo3321b());
            List<String> c = next.mo3322c();
            HashMap<String, String> e = next.mo3324e();
            List<String> d = next.mo3323d();
            String a = next.mo3320a();
            String b2 = next.mo3321b();
            String c2 = cVar.mo3364c();
            if (d == null) {
                d = cVar.mo3368g();
            }
            C0220f fVar = new C0220f(a, b2, c2, d, cVar.mo3369h(), cVar.mo3370i());
            Iterator<String> it = c.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next2 = it.next();
                    Activity a2 = this.f391a.mo3550i().f656c.mo3728a();
                    if (a2 == null) {
                        C0284b.m480a("Activity is null while mediating.  Terminating mediation thread.");
                        return;
                    }
                    this.f391a.mo3555n().mo3584c();
                    if (m159a(next2, a2, adRequest, fVar, e, b)) {
                        return;
                    }
                    if (m163d()) {
                        C0284b.m480a("GWController.destroy() called. Terminating mediation thread.");
                        return;
                    }
                }
            }
        }
        C0265m.m411a().f617c.mo3725a().post(new Runnable() {
            public void run() {
                C0211e.this.f391a.mo3540b(cVar);
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m159a(java.lang.String r8, android.app.Activity r9, com.google.ads.AdRequest r10, final com.google.ads.C0220f r11, java.util.HashMap<java.lang.String, java.lang.String> r12, long r13) {
        /*
            r7 = this;
            com.google.ads.h r0 = new com.google.ads.h
            com.google.ads.internal.d r1 = r7.f391a
            com.google.ads.n r1 = r1.mo3550i()
            com.google.ads.util.i$b<com.google.ads.internal.h> r1 = r1.f660g
            java.lang.Object r2 = r1.mo3725a()
            com.google.ads.internal.h r2 = (com.google.ads.internal.C0253h) r2
            r1 = r7
            r3 = r11
            r4 = r8
            r5 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            monitor-enter(r0)
            r0.mo3409a((android.app.Activity) r9)     // Catch:{ all -> 0x00ba }
        L_0x001c:
            boolean r1 = r0.mo3414c()     // Catch:{ InterruptedException -> 0x0037 }
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
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r1.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Interrupted while waiting for ad network to load ad using adapter class: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.C0284b.m480a((java.lang.String) r1)     // Catch:{ all -> 0x00ba }
        L_0x004e:
            com.google.ads.internal.d r1 = r7.f391a     // Catch:{ all -> 0x00ba }
            com.google.ads.internal.g r1 = r1.mo3555n()     // Catch:{ all -> 0x00ba }
            com.google.ads.g$a r2 = r0.mo3416e()     // Catch:{ all -> 0x00ba }
            r1.mo3581a((com.google.ads.C0221g.C0222a) r2)     // Catch:{ all -> 0x00ba }
            boolean r1 = r0.mo3414c()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0093
            boolean r1 = r0.mo3415d()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0093
            com.google.ads.internal.d r1 = r7.f391a     // Catch:{ all -> 0x00ba }
            com.google.ads.n r1 = r1.mo3550i()     // Catch:{ all -> 0x00ba }
            boolean r1 = r1.mo3684b()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x008d
            r1 = 0
            r2 = r1
        L_0x0075:
            com.google.ads.m r1 = com.google.ads.C0265m.m411a()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.i$b<android.os.Handler> r1 = r1.f617c     // Catch:{ all -> 0x00ba }
            java.lang.Object r1 = r1.mo3725a()     // Catch:{ all -> 0x00ba }
            android.os.Handler r1 = (android.os.Handler) r1     // Catch:{ all -> 0x00ba }
            com.google.ads.e$8 r3 = new com.google.ads.e$8     // Catch:{ all -> 0x00ba }
            r3.<init>(r0, r2, r11)     // Catch:{ all -> 0x00ba }
            r1.post(r3)     // Catch:{ all -> 0x00ba }
            r1 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            r0 = r1
        L_0x008c:
            return r0
        L_0x008d:
            android.view.View r1 = r0.mo3417f()     // Catch:{ all -> 0x00ba }
            r2 = r1
            goto L_0x0075
        L_0x0093:
            boolean r1 = r0.mo3414c()     // Catch:{ all -> 0x00ba }
            if (r1 != 0) goto L_0x00b3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r1.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Timeout occurred in adapter class: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = r0.mo3419h()     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.C0284b.m480a((java.lang.String) r1)     // Catch:{ all -> 0x00ba }
        L_0x00b3:
            r0.mo3413b()     // Catch:{ all -> 0x00ba }
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            r0 = r1
            goto L_0x008c
        L_0x00ba:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0211e.m159a(java.lang.String, android.app.Activity, com.google.ads.AdRequest, com.google.ads.f, java.util.HashMap, long):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m165e(C0223h hVar) {
        boolean z;
        synchronized (this.f397g) {
            if (m163d()) {
                hVar.mo3413b();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: e */
    private C0223h m164e() {
        C0223h hVar;
        synchronized (this.f393c) {
            hVar = this.f392b;
        }
        return hVar;
    }

    /* renamed from: d */
    public void mo3394d(C0223h hVar) {
        synchronized (this.f393c) {
            if (this.f392b != hVar) {
                if (this.f392b != null) {
                    this.f392b.mo3413b();
                }
                this.f392b = hVar;
            }
        }
    }
}
