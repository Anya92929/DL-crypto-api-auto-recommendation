package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.C0313a;
import com.google.android.gms.common.internal.C0316d;
import com.google.android.gms.common.internal.C0339k;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.internal.C1600ng;
import com.google.android.gms.internal.C1604ni;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.nn */
public class C1611nn extends C0316d<C1600ng> {

    /* renamed from: BZ */
    private final String f4303BZ;
    private final C1608nk akL;
    private final C1604ni akM = new C1604ni();
    private boolean akN = true;

    /* renamed from: mw */
    private final Object f4304mw = new Object();

    public C1611nn(Context context, C1608nk nkVar) {
        super(context, nkVar, nkVar, new String[0]);
        this.f4303BZ = context.getPackageName();
        this.akL = (C1608nk) C0348n.m861i(nkVar);
        this.akL.mo9529a(this);
    }

    /* renamed from: c */
    private void m5705c(C1609nl nlVar, C1603nh nhVar) {
        this.akM.mo9518a(nlVar, nhVar);
    }

    /* renamed from: d */
    private void m5706d(C1609nl nlVar, C1603nh nhVar) {
        try {
            m5707mW();
            ((C1600ng) mo4435gS()).mo9510a(this.f4303BZ, nlVar, nhVar);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            m5705c(nlVar, nhVar);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            m5705c(nlVar, nhVar);
        }
    }

    /* renamed from: mW */
    private void m5707mW() {
        C1609nl nlVar;
        C0313a.m678I(!this.akN);
        if (!this.akM.isEmpty()) {
            C1609nl nlVar2 = null;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<C1604ni.C1606a> it = this.akM.mo9523mU().iterator();
                while (it.hasNext()) {
                    C1604ni.C1606a next = it.next();
                    if (next.akD != null) {
                        ((C1600ng) mo4435gS()).mo9512a(this.f4303BZ, next.akB, C1718pm.m6092f(next.akD));
                    } else {
                        if (next.akB.equals(nlVar2)) {
                            arrayList.add(next.akC);
                            nlVar = nlVar2;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((C1600ng) mo4435gS()).mo9511a(this.f4303BZ, nlVar2, (List<C1603nh>) arrayList);
                                arrayList.clear();
                            }
                            C1609nl nlVar3 = next.akB;
                            arrayList.add(next.akC);
                            nlVar = nlVar3;
                        }
                        nlVar2 = nlVar;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((C1600ng) mo4435gS()).mo9511a(this.f4303BZ, nlVar2, (List<C1603nh>) arrayList);
                }
                this.akM.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: S */
    public void mo9539S(boolean z) {
        synchronized (this.f4304mw) {
            boolean z2 = this.akN;
            this.akN = z;
            if (z2 && !this.akN) {
                m5707mW();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3827a(C0339k kVar, C0316d.C0321e eVar) throws RemoteException {
        kVar.mo4524f(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: b */
    public void mo9540b(C1609nl nlVar, C1603nh nhVar) {
        synchronized (this.f4304mw) {
            if (this.akN) {
                m5705c(nlVar, nhVar);
            } else {
                m5706d(nlVar, nhVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bD */
    public C1600ng mo3832j(IBinder iBinder) {
        return C1600ng.C1601a.m5689bC(iBinder);
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f4304mw
            monitor-enter(r1)
            boolean r0 = r3.isConnecting()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000f
            boolean r0 = r3.isConnected()     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.nk r0 = r3.akL     // Catch:{ all -> 0x001c }
            r2 = 1
            r0.mo9528R(r2)     // Catch:{ all -> 0x001c }
            r3.connect()     // Catch:{ all -> 0x001c }
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            goto L_0x0010
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1611nn.start():void");
    }

    public void stop() {
        synchronized (this.f4304mw) {
            this.akL.mo9528R(false);
            disconnect();
        }
    }
}
