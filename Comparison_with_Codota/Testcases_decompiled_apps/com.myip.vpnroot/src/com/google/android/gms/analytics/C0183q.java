package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.analytics.C0199t;

/* renamed from: com.google.android.gms.analytics.q */
class C0183q extends C0156ae {
    /* access modifiers changed from: private */

    /* renamed from: yc */
    public static final Object f188yc = new Object();

    /* renamed from: yo */
    private static C0183q f189yo;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: yd */
    private C0168d f190yd;

    /* renamed from: ye */
    private volatile C0170f f191ye;
    /* access modifiers changed from: private */

    /* renamed from: yf */
    public int f192yf = 1800;

    /* renamed from: yg */
    private boolean f193yg = true;

    /* renamed from: yh */
    private boolean f194yh;

    /* renamed from: yi */
    private String f195yi;
    /* access modifiers changed from: private */

    /* renamed from: yj */
    public boolean f196yj = true;

    /* renamed from: yk */
    private boolean f197yk = true;

    /* renamed from: yl */
    private C0169e f198yl = new C0169e() {
        /* renamed from: z */
        public void mo3662z(boolean z) {
            C0183q.this.mo3710a(z, C0183q.this.f196yj);
        }
    };

    /* renamed from: ym */
    private C0182p f199ym;
    /* access modifiers changed from: private */

    /* renamed from: yn */
    public boolean f200yn = false;

    private C0183q() {
    }

    /* renamed from: ea */
    public static C0183q m217ea() {
        if (f189yo == null) {
            f189yo = new C0183q();
        }
        return f189yo;
    }

    /* renamed from: eb */
    private void m218eb() {
        this.f199ym = new C0182p(this);
        this.f199ym.mo3708z(this.mContext);
    }

    /* renamed from: ec */
    private void m219ec() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new Handler.Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && C0183q.f188yc.equals(msg.obj)) {
                    C0199t.m276eq().mo3730B(true);
                    C0183q.this.dispatchLocalHits();
                    C0199t.m276eq().mo3730B(false);
                    if (C0183q.this.f192yf > 0 && !C0183q.this.f200yn) {
                        C0183q.this.mHandler.sendMessageDelayed(C0183q.this.mHandler.obtainMessage(1, C0183q.f188yc), (long) (C0183q.this.f192yf * 1000));
                    }
                }
                return true;
            }
        });
        if (this.f192yf > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f188yc), (long) (this.f192yf * 1000));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public synchronized void mo3617A(boolean z) {
        mo3710a(this.f200yn, z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3709a(Context context, C0170f fVar) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.f191ye == null) {
                this.f191ye = fVar;
                if (this.f193yg) {
                    dispatchLocalHits();
                    this.f193yg = false;
                }
                if (this.f194yh) {
                    mo3711dO();
                    this.f194yh = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3710a(boolean z, boolean z2) {
        if (!(this.f200yn == z && this.f196yj == z2)) {
            if (z || !z2) {
                if (this.f192yf > 0) {
                    this.mHandler.removeMessages(1, f188yc);
                }
            }
            if (!z && z2 && this.f192yf > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f188yc), (long) (this.f192yf * 1000));
            }
            C0207z.m308V("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.f200yn = z;
            this.f196yj = z2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: dO */
    public void mo3711dO() {
        if (this.f191ye == null) {
            C0207z.m308V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.f194yh = true;
            return;
        }
        C0199t.m276eq().mo3731a(C0199t.C0200a.SET_FORCE_LOCAL_DISPATCH);
        this.f191ye.mo3695dO();
    }

    /* access modifiers changed from: package-private */
    public synchronized void dispatchLocalHits() {
        if (this.f191ye == null) {
            C0207z.m308V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f193yg = true;
        } else {
            C0199t.m276eq().mo3731a(C0199t.C0200a.DISPATCH);
            this.f191ye.dispatch();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ed */
    public synchronized C0168d mo3712ed() {
        if (this.f190yd == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f190yd = new C0152ab(this.f198yl, this.mContext);
            if (this.f195yi != null) {
                this.f190yd.mo3605dN().mo3629af(this.f195yi);
                this.f195yi = null;
            }
        }
        if (this.mHandler == null) {
            m219ec();
        }
        if (this.f199ym == null && this.f197yk) {
            m218eb();
        }
        return this.f190yd;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ee */
    public synchronized void mo3619ee() {
        if (!this.f200yn && this.f196yj && this.f192yf > 0) {
            this.mHandler.removeMessages(1, f188yc);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, f188yc));
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            C0207z.m308V("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.f192yf = dispatchPeriodInSeconds;
        } else {
            C0199t.m276eq().mo3731a(C0199t.C0200a.SET_DISPATCH_PERIOD);
            if (!this.f200yn && this.f196yj && this.f192yf > 0) {
                this.mHandler.removeMessages(1, f188yc);
            }
            this.f192yf = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.f200yn && this.f196yj) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f188yc), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }
}
