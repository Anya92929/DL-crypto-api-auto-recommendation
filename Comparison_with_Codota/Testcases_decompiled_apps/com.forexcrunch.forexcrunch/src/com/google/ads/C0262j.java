package com.google.ads;

import com.google.ads.AdRequest;
import com.google.ads.C0221g;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;

/* renamed from: com.google.ads.j */
class C0262j implements MediationBannerListener {

    /* renamed from: a */
    private final C0223h f608a;

    /* renamed from: b */
    private boolean f609b;

    public C0262j(C0223h hVar) {
        this.f608a = hVar;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedAd(com.google.ads.mediation.MediationBannerAdapter<?, ?> r5) {
        /*
            r4 = this;
            com.google.ads.h r1 = r4.f608a
            monitor-enter(r1)
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            com.google.ads.mediation.MediationAdapter r0 = r0.mo3420i()     // Catch:{ all -> 0x005f }
            com.google.ads.util.C0282a.m470a((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f608a     // Catch:{ Throwable -> 0x002a }
            android.view.View r2 = r5.getBannerView()     // Catch:{ Throwable -> 0x002a }
            r0.mo3410a((android.view.View) r2)     // Catch:{ Throwable -> 0x002a }
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo3414c()     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0062
            r0 = 0
            r4.f609b = r0     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            r2 = 1
            com.google.ads.g$a r3 = com.google.ads.C0221g.C0222a.AD     // Catch:{ all -> 0x005f }
            r0.mo3412a(r2, r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
        L_0x0029:
            return
        L_0x002a:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r2.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "Error while getting banner View from adapter ("
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            com.google.ads.h r3 = r4.f608a     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r3.mo3419h()     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "): "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005f }
            com.google.ads.util.C0284b.m485b(r2, r0)     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo3414c()     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x005d
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            r2 = 0
            com.google.ads.g$a r3 = com.google.ads.C0221g.C0222a.EXCEPTION     // Catch:{ all -> 0x005f }
            r0.mo3412a(r2, r3)     // Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            goto L_0x0029
        L_0x005f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r0
        L_0x0062:
            r0 = 1
            r4.f609b = r0     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f608a     // Catch:{ all -> 0x005f }
            com.google.ads.e r0 = r0.mo3421j()     // Catch:{ all -> 0x005f }
            com.google.ads.h r2 = r4.f608a     // Catch:{ all -> 0x005f }
            com.google.ads.h r3 = r4.f608a     // Catch:{ all -> 0x005f }
            android.view.View r3 = r3.mo3417f()     // Catch:{ all -> 0x005f }
            r0.mo3387a((com.google.ads.C0223h) r2, (android.view.View) r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0262j.onReceivedAd(com.google.ads.mediation.MediationBannerAdapter):void");
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> adapter, AdRequest.ErrorCode error) {
        synchronized (this.f608a) {
            C0282a.m470a((Object) adapter, (Object) this.f608a.mo3420i());
            C0284b.m480a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (!this.f608a.mo3414c()) {
                this.f608a.mo3412a(false, error == AdRequest.ErrorCode.NO_FILL ? C0221g.C0222a.NO_FILL : C0221g.C0222a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f608a) {
            this.f608a.mo3421j().mo3386a(this.f608a);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f608a) {
            this.f608a.mo3421j().mo3391b(this.f608a);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f608a) {
            this.f608a.mo3421j().mo3392c(this.f608a);
        }
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f608a) {
            C0282a.m472a(this.f608a.mo3414c());
            this.f608a.mo3421j().mo3388a(this.f608a, this.f609b);
        }
    }
}
