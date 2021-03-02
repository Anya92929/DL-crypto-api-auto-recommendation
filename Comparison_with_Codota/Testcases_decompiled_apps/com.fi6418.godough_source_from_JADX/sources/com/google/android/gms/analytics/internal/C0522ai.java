package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.stats.C1093b;

/* renamed from: com.google.android.gms.analytics.internal.ai */
public class C0522ai implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C0520ag f3732a;

    /* renamed from: b */
    private volatile C0557e f3733b;

    /* renamed from: c */
    private volatile boolean f3734c;

    protected C0522ai(C0520ag agVar) {
        this.f3732a = agVar;
    }

    /* renamed from: a */
    public C0557e mo6651a() {
        C0557e eVar = null;
        this.f3732a.mo6884m();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context o = this.f3732a.mo6886o();
        intent.putExtra("app_package_name", o.getPackageName());
        C1093b a = C1093b.m4761a();
        synchronized (this) {
            this.f3733b = null;
            this.f3734c = true;
            boolean a2 = a.mo7703a(o, intent, (ServiceConnection) this.f3732a.f3727a, 129);
            this.f3732a.mo6866a("Bind to service requested", Boolean.valueOf(a2));
            if (!a2) {
                this.f3734c = false;
            } else {
                try {
                    wait(this.f3732a.mo6888q().mo6753w());
                } catch (InterruptedException e) {
                    this.f3732a.mo6879e("Wait for service connect was interrupted");
                }
                this.f3734c = false;
                eVar = this.f3733b;
                this.f3733b = null;
                if (eVar == null) {
                    this.f3732a.mo6881f("Successfully bound to service but never got onServiceConnected callback");
                }
            }
        }
        return eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.f3732a.mo6881f("Service connect failed to get IAnalyticsService");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0008, B:9:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
            r4 = this;
            java.lang.String r0 = "AnalyticsServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.C1009bf.m4535b((java.lang.String) r0)
            monitor-enter(r4)
            if (r6 != 0) goto L_0x0014
            com.google.android.gms.analytics.internal.ag r0 = r4.f3732a     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "Service connected with null binder"
            r0.mo6881f(r1)     // Catch:{ all -> 0x005a }
            r4.notifyAll()     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
        L_0x0013:
            return
        L_0x0014:
            r0 = 0
            java.lang.String r1 = r6.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0051 }
            java.lang.String r2 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049
            com.google.android.gms.analytics.internal.e r0 = com.google.android.gms.analytics.internal.C0558f.m3252a(r6)     // Catch:{ RemoteException -> 0x0051 }
            com.google.android.gms.analytics.internal.ag r1 = r4.f3732a     // Catch:{ RemoteException -> 0x0051 }
            java.lang.String r2 = "Bound to IAnalyticsService interface"
            r1.mo6869b(r2)     // Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f
            com.google.android.gms.common.stats.b r0 = com.google.android.gms.common.stats.C1093b.m4761a()     // Catch:{ IllegalArgumentException -> 0x007c }
            com.google.android.gms.analytics.internal.ag r1 = r4.f3732a     // Catch:{ IllegalArgumentException -> 0x007c }
            android.content.Context r1 = r1.mo6886o()     // Catch:{ IllegalArgumentException -> 0x007c }
            com.google.android.gms.analytics.internal.ag r2 = r4.f3732a     // Catch:{ IllegalArgumentException -> 0x007c }
            com.google.android.gms.analytics.internal.ai r2 = r2.f3727a     // Catch:{ IllegalArgumentException -> 0x007c }
            r0.mo7701a((android.content.Context) r1, (android.content.ServiceConnection) r2)     // Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll()     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            goto L_0x0013
        L_0x0046:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r0
        L_0x0049:
            com.google.android.gms.analytics.internal.ag r2 = r4.f3732a     // Catch:{ RemoteException -> 0x0051 }
            java.lang.String r3 = "Got binder with a wrong descriptor"
            r2.mo6880e(r3, r1)     // Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c
        L_0x0051:
            r1 = move-exception
            com.google.android.gms.analytics.internal.ag r1 = r4.f3732a     // Catch:{ all -> 0x005a }
            java.lang.String r2 = "Service connect failed to get IAnalyticsService"
            r1.mo6881f(r2)     // Catch:{ all -> 0x005a }
            goto L_0x002c
        L_0x005a:
            r0 = move-exception
            r4.notifyAll()     // Catch:{ all -> 0x0046 }
            throw r0     // Catch:{ all -> 0x0046 }
        L_0x005f:
            boolean r1 = r4.f3734c     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079
            com.google.android.gms.analytics.internal.ag r1 = r4.f3732a     // Catch:{ all -> 0x005a }
            java.lang.String r2 = "onServiceConnected received after the timeout limit"
            r1.mo6879e(r2)     // Catch:{ all -> 0x005a }
            com.google.android.gms.analytics.internal.ag r1 = r4.f3732a     // Catch:{ all -> 0x005a }
            com.google.android.gms.c.aq r1 = r1.mo6889r()     // Catch:{ all -> 0x005a }
            com.google.android.gms.analytics.internal.aj r2 = new com.google.android.gms.analytics.internal.aj     // Catch:{ all -> 0x005a }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x005a }
            r1.mo7018a((java.lang.Runnable) r2)     // Catch:{ all -> 0x005a }
            goto L_0x0041
        L_0x0079:
            r4.f3733b = r0     // Catch:{ all -> 0x005a }
            goto L_0x0041
        L_0x007c:
            r0 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.C0522ai.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1009bf.m4535b("AnalyticsServiceConnection.onServiceDisconnected");
        this.f3732a.mo6889r().mo7018a((Runnable) new C0524ak(this, componentName));
    }
}
