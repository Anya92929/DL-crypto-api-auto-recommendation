package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/* renamed from: com.google.android.gms.tagmanager.cy */
class C2097cy extends C2096cx {
    private static C2097cy arp;
    /* access modifiers changed from: private */

    /* renamed from: yc */
    public static final Object f4579yc = new Object();
    private Context arf;
    /* access modifiers changed from: private */
    public C2009at arg;
    private volatile C2006ar arh;
    /* access modifiers changed from: private */
    public int ari = 1800000;
    private boolean arj = true;
    private boolean ark = false;
    private boolean arl = true;
    private C2010au arm = new C2010au() {
        /* renamed from: z */
        public void mo11564z(boolean z) {
            C2097cy.this.mo11724a(z, C2097cy.this.connected);
        }
    };
    private C2035bo arn;
    /* access modifiers changed from: private */
    public boolean aro = false;
    /* access modifiers changed from: private */
    public boolean connected = true;
    /* access modifiers changed from: private */
    public Handler handler;

    private C2097cy() {
    }

    /* renamed from: eb */
    private void m7057eb() {
        this.arn = new C2035bo(this);
        this.arn.mo11590z(this.arf);
    }

    /* renamed from: ec */
    private void m7058ec() {
        this.handler = new Handler(this.arf.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && C2097cy.f4579yc.equals(msg.obj)) {
                    C2097cy.this.dispatch();
                    if (C2097cy.this.ari > 0 && !C2097cy.this.aro) {
                        C2097cy.this.handler.sendMessageDelayed(C2097cy.this.handler.obtainMessage(1, C2097cy.f4579yc), (long) C2097cy.this.ari);
                    }
                }
                return true;
            }
        });
        if (this.ari > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, f4579yc), (long) this.ari);
        }
    }

    /* renamed from: pu */
    public static C2097cy m7060pu() {
        if (arp == null) {
            arp = new C2097cy();
        }
        return arp;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public synchronized void mo11720A(boolean z) {
        mo11724a(this.aro, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo11723a(Context context, C2006ar arVar) {
        if (this.arf == null) {
            this.arf = context.getApplicationContext();
            if (this.arh == null) {
                this.arh = arVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo11724a(boolean z, boolean z2) {
        if (!(this.aro == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.ari > 0) {
                    this.handler.removeMessages(1, f4579yc);
                }
            }
            if (!z && z2 && this.ari > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, f4579yc), (long) this.ari);
            }
            C2028bh.m6818V("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.aro = z;
            this.connected = z2;
        }
    }

    public synchronized void dispatch() {
        if (!this.ark) {
            C2028bh.m6818V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.arj = true;
        } else {
            this.arh.mo11557b(new Runnable() {
                public void run() {
                    C2097cy.this.arg.dispatch();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ee */
    public synchronized void mo11722ee() {
        if (!this.aro && this.connected && this.ari > 0) {
            this.handler.removeMessages(1, f4579yc);
            this.handler.sendMessage(this.handler.obtainMessage(1, f4579yc));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: pv */
    public synchronized C2009at mo11725pv() {
        if (this.arg == null) {
            if (this.arf == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.arg = new C2050cb(this.arm, this.arf);
        }
        if (this.handler == null) {
            m7058ec();
        }
        this.ark = true;
        if (this.arj) {
            dispatch();
            this.arj = false;
        }
        if (this.arn == null && this.arl) {
            m7057eb();
        }
        return this.arg;
    }
}
