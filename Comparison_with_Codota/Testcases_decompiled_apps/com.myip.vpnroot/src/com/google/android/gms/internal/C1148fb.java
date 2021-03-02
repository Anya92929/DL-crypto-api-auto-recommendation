package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.C1146fa;
import com.google.android.gms.internal.C1162ff;
import com.google.android.gms.internal.C1168fi;
import org.json.JSONException;

@C1130ez
/* renamed from: com.google.android.gms.internal.fb */
public class C1148fb extends C1206gg implements C1162ff.C1163a {
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: mw */
    public final Object f3480mw = new Object();

    /* renamed from: pR */
    private C1004cm f3481pR;
    /* access modifiers changed from: private */

    /* renamed from: sU */
    public final C1146fa.C1147a f3482sU;

    /* renamed from: sV */
    private final Object f3483sV = new Object();

    /* renamed from: sW */
    private final C1168fi.C1169a f3484sW;

    /* renamed from: sX */
    private final C1391k f3485sX;

    /* renamed from: sY */
    private C1206gg f3486sY;

    /* renamed from: sZ */
    private C1171fk f3487sZ;

    @C1130ez
    /* renamed from: com.google.android.gms.internal.fb$a */
    private static final class C1151a extends Exception {

        /* renamed from: tc */
        private final int f3491tc;

        public C1151a(String str, int i) {
            super(str);
            this.f3491tc = i;
        }

        public int getErrorCode() {
            return this.f3491tc;
        }
    }

    public C1148fb(Context context, C1168fi.C1169a aVar, C1391k kVar, C1146fa.C1147a aVar2) {
        this.f3482sU = aVar2;
        this.mContext = context;
        this.f3484sW = aVar;
        this.f3485sX = kVar;
    }

    /* renamed from: a */
    private C0927ay m4405a(C1168fi fiVar) throws C1151a {
        if (this.f3487sZ.f3565tL == null) {
            throw new C1151a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f3487sZ.f3565tL.split("x");
        if (split.length != 2) {
            throw new C1151a("Could not parse the ad size from the ad response: " + this.f3487sZ.f3565tL, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (C0927ay ayVar : fiVar.f3530lH.f2624oh) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = ayVar.width == -1 ? (int) (((float) ayVar.widthPixels) / f) : ayVar.width;
                int i2 = ayVar.height == -2 ? (int) (((float) ayVar.heightPixels) / f) : ayVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new C0927ay(ayVar, fiVar.f3530lH.f2624oh);
                }
            }
            throw new C1151a("The ad size from the ad response was not one of the requested sizes: " + this.f3487sZ.f3565tL, 0);
        } catch (NumberFormatException e) {
            throw new C1151a("Could not parse the ad size from the ad response: " + this.f3487sZ.f3565tL, 0);
        }
    }

    /* renamed from: c */
    private boolean m4408c(long j) throws C1151a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f3480mw.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C1151a("Ad request cancelled.", -1);
        }
    }

    /* renamed from: cy */
    private void m4409cy() throws C1151a {
        if (this.f3487sZ.errorCode != -3) {
            if (TextUtils.isEmpty(this.f3487sZ.f3560tG)) {
                throw new C1151a("No fill from ad server.", 3);
            }
            C1201gb.m4560a(this.mContext, this.f3487sZ.f3559tF);
            if (this.f3487sZ.f3562tI) {
                try {
                    this.f3481pR = new C1004cm(this.f3487sZ.f3560tG);
                } catch (JSONException e) {
                    throw new C1151a("Could not parse mediation config: " + this.f3487sZ.f3560tG, 0);
                }
            }
        }
    }

    /* renamed from: e */
    private void m4410e(long j) throws C1151a {
        while (m4408c(j)) {
            if (this.f3487sZ != null) {
                synchronized (this.f3483sV) {
                    this.f3486sY = null;
                }
                if (this.f3487sZ.errorCode != -2 && this.f3487sZ.errorCode != -3) {
                    throw new C1151a("There was a problem getting an ad response. ErrorCode: " + this.f3487sZ.errorCode, this.f3487sZ.errorCode);
                }
                return;
            }
        }
        throw new C1151a("Timed out waiting for ad response.", 2);
    }

    /* renamed from: r */
    private void m4411r(boolean z) {
        C1201gb.m4564cV().mo8574v(z);
        C0909an l = C1201gb.m4564cV().mo8573l(this.mContext);
        if (l != null && !l.isAlive()) {
            C1229gs.m4675S("start fetching content...");
            l.mo7988aV();
        }
    }

    /* renamed from: a */
    public void mo8468a(C1171fk fkVar) {
        synchronized (this.f3480mw) {
            C1229gs.m4675S("Received ad response.");
            this.f3487sZ = fkVar;
            this.f3480mw.notify();
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: cp */
    public void mo8384cp() {
        /*
            r12 = this;
            r8 = 0
            java.lang.Object r11 = r12.f3480mw
            monitor-enter(r11)
            java.lang.String r0 = "AdLoaderBackgroundTask started."
            com.google.android.gms.internal.C1229gs.m4675S(r0)     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.k r0 = r12.f3485sX     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.g r0 = r0.mo9092z()     // Catch:{ all -> 0x00b9 }
            android.content.Context r1 = r12.mContext     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r0.mo8540a((android.content.Context) r1)     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fi r1 = new com.google.android.gms.internal.fi     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fi$a r2 = r12.f3484sW     // Catch:{ all -> 0x00b9 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00b9 }
            r5 = -2
            r2 = -1
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ a -> 0x003e }
            android.content.Context r0 = r12.mContext     // Catch:{ a -> 0x003e }
            com.google.android.gms.internal.gg r0 = com.google.android.gms.internal.C1162ff.m4442a(r0, r1, r12)     // Catch:{ a -> 0x003e }
            java.lang.Object r4 = r12.f3483sV     // Catch:{ a -> 0x003e }
            monitor-enter(r4)     // Catch:{ a -> 0x003e }
            r12.f3486sY = r0     // Catch:{ all -> 0x003b }
            com.google.android.gms.internal.gg r0 = r12.f3486sY     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0093
            com.google.android.gms.internal.fb$a r0 = new com.google.android.gms.internal.fb$a     // Catch:{ all -> 0x003b }
            java.lang.String r5 = "Could not start the ad request service."
            r6 = 0
            r0.<init>(r5, r6)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ a -> 0x003e }
        L_0x003e:
            r0 = move-exception
            r4 = r8
        L_0x0040:
            int r5 = r0.getErrorCode()     // Catch:{ all -> 0x00b9 }
            r6 = 3
            if (r5 == r6) goto L_0x004a
            r6 = -1
            if (r5 != r6) goto L_0x00b1
        L_0x004a:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.C1229gs.m4677U(r0)     // Catch:{ all -> 0x00b9 }
        L_0x0051:
            com.google.android.gms.internal.fk r0 = r12.f3487sZ     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x00bc
            com.google.android.gms.internal.fk r0 = new com.google.android.gms.internal.fk     // Catch:{ all -> 0x00b9 }
            r0.<init>(r5)     // Catch:{ all -> 0x00b9 }
            r12.f3487sZ = r0     // Catch:{ all -> 0x00b9 }
        L_0x005c:
            android.os.Handler r0 = com.google.android.gms.internal.C1228gr.f3776wC     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fb$1 r6 = new com.google.android.gms.internal.fb$1     // Catch:{ all -> 0x00b9 }
            r6.<init>()     // Catch:{ all -> 0x00b9 }
            r0.post(r6)     // Catch:{ all -> 0x00b9 }
            r6 = r2
        L_0x0067:
            com.google.android.gms.internal.fk r0 = r12.f3487sZ     // Catch:{ all -> 0x00b9 }
            java.lang.String r0 = r0.f3570tQ     // Catch:{ all -> 0x00b9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x00ce
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c8 }
            com.google.android.gms.internal.fk r0 = r12.f3487sZ     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r0 = r0.f3570tQ     // Catch:{ Exception -> 0x00c8 }
            r10.<init>(r0)     // Catch:{ Exception -> 0x00c8 }
        L_0x007a:
            com.google.android.gms.internal.fz$a r0 = new com.google.android.gms.internal.fz$a     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fk r2 = r12.f3487sZ     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.cm r3 = r12.f3481pR     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fk r8 = r12.f3487sZ     // Catch:{ all -> 0x00b9 }
            long r8 = r8.f3566tM     // Catch:{ all -> 0x00b9 }
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10)     // Catch:{ all -> 0x00b9 }
            android.os.Handler r1 = com.google.android.gms.internal.C1228gr.f3776wC     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fb$2 r2 = new com.google.android.gms.internal.fb$2     // Catch:{ all -> 0x00b9 }
            r2.<init>(r0)     // Catch:{ all -> 0x00b9 }
            r1.post(r2)     // Catch:{ all -> 0x00b9 }
            monitor-exit(r11)     // Catch:{ all -> 0x00b9 }
            return
        L_0x0093:
            monitor-exit(r4)     // Catch:{ all -> 0x003b }
            r12.m4410e(r6)     // Catch:{ a -> 0x003e }
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ a -> 0x003e }
            r12.m4409cy()     // Catch:{ a -> 0x003e }
            com.google.android.gms.internal.ay r0 = r1.f3530lH     // Catch:{ a -> 0x003e }
            com.google.android.gms.internal.ay[] r0 = r0.f2624oh     // Catch:{ a -> 0x003e }
            if (r0 == 0) goto L_0x00d3
            com.google.android.gms.internal.ay r4 = r12.m4405a((com.google.android.gms.internal.C1168fi) r1)     // Catch:{ a -> 0x003e }
        L_0x00a8:
            com.google.android.gms.internal.fk r0 = r12.f3487sZ     // Catch:{ a -> 0x00d0 }
            boolean r0 = r0.f3573tT     // Catch:{ a -> 0x00d0 }
            r12.m4411r(r0)     // Catch:{ a -> 0x00d0 }
            r6 = r2
            goto L_0x0067
        L_0x00b1:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.C1229gs.m4679W(r0)     // Catch:{ all -> 0x00b9 }
            goto L_0x0051
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00b9 }
            throw r0
        L_0x00bc:
            com.google.android.gms.internal.fk r0 = new com.google.android.gms.internal.fk     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.fk r6 = r12.f3487sZ     // Catch:{ all -> 0x00b9 }
            long r6 = r6.f3557qj     // Catch:{ all -> 0x00b9 }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x00b9 }
            r12.f3487sZ = r0     // Catch:{ all -> 0x00b9 }
            goto L_0x005c
        L_0x00c8:
            r0 = move-exception
            java.lang.String r2 = "Error parsing the JSON for Active View."
            com.google.android.gms.internal.C1229gs.m4681b(r2, r0)     // Catch:{ all -> 0x00b9 }
        L_0x00ce:
            r10 = r8
            goto L_0x007a
        L_0x00d0:
            r0 = move-exception
            goto L_0x0040
        L_0x00d3:
            r4 = r8
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1148fb.mo8384cp():void");
    }

    public void onStop() {
        synchronized (this.f3483sV) {
            if (this.f3486sY != null) {
                this.f3486sY.cancel();
            }
        }
    }
}
