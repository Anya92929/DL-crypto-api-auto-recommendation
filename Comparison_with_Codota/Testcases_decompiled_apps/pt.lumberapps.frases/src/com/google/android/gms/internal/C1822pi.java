package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.support.p009v4.p019f.C0136a;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpm;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.pi */
class C1822pi implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    final /* synthetic */ zzqc f5482a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Queue f5483b = new LinkedList();

    /* renamed from: c */
    private final Api.zze f5484c;

    /* renamed from: d */
    private final Api.zzb f5485d;

    /* renamed from: e */
    private final zzpj f5486e;

    /* renamed from: f */
    private final SparseArray f5487f = new SparseArray();

    /* renamed from: g */
    private final Set f5488g = new HashSet();

    /* renamed from: h */
    private final SparseArray f5489h = new SparseArray();

    /* renamed from: i */
    private boolean f5490i;

    /* renamed from: j */
    private ConnectionResult f5491j = null;

    public C1822pi(zzqc zzqc, zzc zzc) {
        this.f5482a = zzqc;
        this.f5484c = m6548a(zzc);
        if (this.f5484c instanceof zzah) {
            this.f5485d = ((zzah) this.f5484c).zzatn();
        } else {
            this.f5485d = this.f5484c;
        }
        this.f5486e = zzc.zzaob();
    }

    /* renamed from: a */
    private Api.zze m6548a(zzc zzc) {
        Api zzanz = zzc.zzanz();
        if (!zzanz.zzant()) {
            return zzc.zzanz().zzanq().zza(zzc.getApplicationContext(), this.f5482a.f6890n.getLooper(), zzg.zzcd(zzc.getApplicationContext()), zzc.zzaoa(), this, this);
        }
        Api.zzh zzanr = zzanz.zzanr();
        return new zzah(zzc.getApplicationContext(), this.f5482a.f6890n.getLooper(), zzanr.zzanw(), this, this, zzg.zzcd(zzc.getApplicationContext()), zzanr.zzr(zzc.zzaoa()));
    }

    /* renamed from: a */
    private void m6549a(ConnectionResult connectionResult) {
        for (zzpl zza : this.f5488g) {
            zza.zza(this.f5486e, connectionResult);
        }
        this.f5488g.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6550a(Status status) {
        for (zzpi zzx : this.f5483b) {
            zzx.zzx(status);
        }
        this.f5483b.clear();
    }

    /* renamed from: b */
    private void m6554b(zzpi zzpi) {
        C0136a aVar;
        zzpi.zza(this.f5487f);
        if (zzpi.f6771iq == 3) {
            try {
                Map map = (Map) this.f5489h.get(zzpi.f6772sx);
                if (map == null) {
                    C0136a aVar2 = new C0136a(1);
                    this.f5489h.put(zzpi.f6772sx, aVar2);
                    aVar = aVar2;
                } else {
                    aVar = map;
                }
                zzpm.zza zza = ((zzpi.zza) zzpi).f6773sy;
                aVar.put(((zzqm) zza).zzaqu(), zza);
            } catch (ClassCastException e) {
                throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
            }
        } else if (zzpi.f6771iq == 4) {
            try {
                Map map2 = (Map) this.f5489h.get(zzpi.f6772sx);
                zzqm zzqm = (zzqm) ((zzpi.zza) zzpi).f6773sy;
                if (map2 != null) {
                    map2.remove(zzqm.zzaqu());
                } else {
                    Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                }
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
            }
        }
        try {
            zzpi.zzb(this.f5485d);
        } catch (DeadObjectException e3) {
            this.f5484c.disconnect();
            onConnectionSuspended(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6558e() {
        if (this.f5490i) {
            m6563j();
        }
    }

    /* renamed from: f */
    private void m6559f() {
        if (this.f5490i) {
            this.f5482a.f6890n.removeMessages(9, this.f5486e);
            this.f5482a.f6890n.removeMessages(8, this.f5486e);
            this.f5490i = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6560g() {
        if (this.f5490i) {
            m6559f();
            m6550a(this.f5482a.f6883g.isGooglePlayServicesAvailable(this.f5482a.f6882f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f5484c.disconnect();
        }
    }

    /* renamed from: h */
    private void m6561h() {
        this.f5482a.f6890n.removeMessages(10, this.f5486e);
        this.f5482a.f6890n.sendMessageDelayed(this.f5482a.f6890n.obtainMessage(10, this.f5486e), this.f5482a.f6881c);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m6562i() {
        if (this.f5484c.isConnected() && this.f5489h.size() == 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f5487f.size()) {
                    this.f5484c.disconnect();
                    return;
                } else if (((zzqy) this.f5487f.get(this.f5487f.keyAt(i2))).zzara()) {
                    m6561h();
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m6563j() {
        if (!this.f5484c.isConnected() && !this.f5484c.isConnecting()) {
            if (this.f5484c.zzanu() && this.f5482a.f6884h != 0) {
                int unused = this.f5482a.f6884h = this.f5482a.f6883g.isGooglePlayServicesAvailable(this.f5482a.f6882f);
                if (this.f5482a.f6884h != 0) {
                    onConnectionFailed(new ConnectionResult(this.f5482a.f6884h, (PendingIntent) null));
                    return;
                }
            }
            this.f5484c.zza(new C1824pk(this.f5482a, this.f5484c, this.f5486e));
        }
    }

    /* renamed from: a */
    public void mo7636a() {
        while (this.f5484c.isConnected() && !this.f5483b.isEmpty()) {
            m6554b((zzpi) this.f5483b.remove());
        }
    }

    /* renamed from: a */
    public void mo7637a(int i) {
        this.f5487f.put(i, new zzqy(this.f5486e.zzans(), this.f5484c));
    }

    /* renamed from: a */
    public void mo7638a(int i, boolean z) {
        Iterator it = this.f5483b.iterator();
        while (it.hasNext()) {
            zzpi zzpi = (zzpi) it.next();
            if (zzpi.f6772sx == i && zzpi.f6771iq != 1 && zzpi.cancel()) {
                it.remove();
            }
        }
        ((zzqy) this.f5487f.get(i)).release();
        this.f5489h.delete(i);
        if (!z) {
            this.f5487f.remove(i);
            this.f5482a.f6892p.remove(i);
            if (this.f5487f.size() == 0 && this.f5483b.isEmpty()) {
                m6559f();
                this.f5484c.disconnect();
                this.f5482a.f6887k.remove(this.f5486e);
                synchronized (zzqc.f6877d) {
                    this.f5482a.f6889m.remove(this.f5486e);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo7639a(zzpi zzpi) {
        if (this.f5484c.isConnected()) {
            m6554b(zzpi);
            m6561h();
            return;
        }
        this.f5483b.add(zzpi);
        if (this.f5491j == null || !this.f5491j.hasResolution()) {
            m6563j();
        } else {
            onConnectionFailed(this.f5491j);
        }
    }

    /* renamed from: a */
    public void mo7640a(zzpl zzpl) {
        this.f5488g.add(zzpl);
    }

    /* renamed from: b */
    public void mo7641b() {
        this.f5491j = null;
    }

    /* renamed from: b */
    public void mo7642b(int i) {
        ((zzqy) this.f5487f.get(i)).zza(new C1823pj(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ConnectionResult mo7643c() {
        return this.f5491j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo7644d() {
        return this.f5484c.isConnected();
    }

    public void onConnected(Bundle bundle) {
        mo7641b();
        m6549a(ConnectionResult.f4269rb);
        m6559f();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f5489h.size()) {
                for (zzpm.zza zzb : ((Map) this.f5489h.get(this.f5489h.keyAt(i2))).values()) {
                    try {
                        zzb.zzb(this.f5485d);
                    } catch (DeadObjectException e) {
                        this.f5484c.disconnect();
                        onConnectionSuspended(1);
                    }
                }
                i = i2 + 1;
            } else {
                mo7636a();
                m6561h();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (r5.f5482a.mo8965a(r6, r0) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r6.getErrorCode() != 18) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r5.f5490i = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r5.f5490i == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r5.f5482a.f6890n.sendMessageDelayed(android.os.Message.obtain(r5.f5482a.f6890n, 8, r5.f5486e), r5.f5482a.f6879a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r2 = java.lang.String.valueOf(r5.f5486e.zzaon());
        m6550a(new com.google.android.gms.common.api.Status(17, new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 38).append("API: ").append(r2).append(" is not available on this device.").toString()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConnectionFailed(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r5.mo7641b()
            com.google.android.gms.internal.zzqc r0 = r5.f5482a
            r1 = -1
            int unused = r0.f6884h = r1
            r5.m6549a((com.google.android.gms.common.ConnectionResult) r6)
            android.util.SparseArray r0 = r5.f5487f
            r1 = 0
            int r0 = r0.keyAt(r1)
            java.util.Queue r1 = r5.f5483b
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001e
            r5.f5491j = r6
        L_0x001d:
            return
        L_0x001e:
            java.lang.Object r1 = com.google.android.gms.internal.zzqc.f6877d
            monitor-enter(r1)
            com.google.android.gms.internal.zzqc r2 = r5.f5482a     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzpr r2 = com.google.android.gms.internal.zzqc.m7502d(r2)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047
            com.google.android.gms.internal.zzqc r2 = r5.f5482a     // Catch:{ all -> 0x0044 }
            java.util.Set r2 = r2.f6889m     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzpj r3 = r5.f5486e     // Catch:{ all -> 0x0044 }
            boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047
            com.google.android.gms.internal.zzqc r2 = r5.f5482a     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzpr r2 = com.google.android.gms.internal.zzqc.m7502d(r2)     // Catch:{ all -> 0x0044 }
            r2.zzb(r6, r0)     // Catch:{ all -> 0x0044 }
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            goto L_0x001d
        L_0x0044:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            throw r0
        L_0x0047:
            monitor-exit(r1)     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.zzqc r1 = r5.f5482a
            boolean r0 = r1.mo8965a((com.google.android.gms.common.ConnectionResult) r6, (int) r0)
            if (r0 != 0) goto L_0x001d
            int r0 = r6.getErrorCode()
            r1 = 18
            if (r0 != r1) goto L_0x005b
            r0 = 1
            r5.f5490i = r0
        L_0x005b:
            boolean r0 = r5.f5490i
            if (r0 == 0) goto L_0x007d
            com.google.android.gms.internal.zzqc r0 = r5.f5482a
            android.os.Handler r0 = r0.f6890n
            com.google.android.gms.internal.zzqc r1 = r5.f5482a
            android.os.Handler r1 = r1.f6890n
            r2 = 8
            com.google.android.gms.internal.zzpj r3 = r5.f5486e
            android.os.Message r1 = android.os.Message.obtain(r1, r2, r3)
            com.google.android.gms.internal.zzqc r2 = r5.f5482a
            long r2 = r2.f6879a
            r0.sendMessageDelayed(r1, r2)
            goto L_0x001d
        L_0x007d:
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
            r1 = 17
            com.google.android.gms.internal.zzpj r2 = r5.f5486e
            java.lang.String r2 = r2.zzaon()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r4 = r4 + 38
            r3.<init>(r4)
            java.lang.String r4 = "API: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = " is not available on this device."
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            r5.m6550a((com.google.android.gms.common.api.Status) r0)
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1822pi.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
    }

    public void onConnectionSuspended(int i) {
        mo7641b();
        this.f5490i = true;
        this.f5482a.f6890n.sendMessageDelayed(Message.obtain(this.f5482a.f6890n, 8, this.f5486e), this.f5482a.f6879a);
        this.f5482a.f6890n.sendMessageDelayed(Message.obtain(this.f5482a.f6890n, 9, this.f5486e), this.f5482a.f6880b);
        int unused = this.f5482a.f6884h = -1;
    }
}
