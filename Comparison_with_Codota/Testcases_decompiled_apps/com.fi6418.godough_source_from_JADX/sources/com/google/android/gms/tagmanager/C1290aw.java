package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.aw */
class C1290aw extends C1289av {

    /* renamed from: a */
    private static final Object f5341a = new Object();

    /* renamed from: k */
    private static C1290aw f5342k;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1330u f5343b;

    /* renamed from: c */
    private volatile C1329t f5344c;

    /* renamed from: d */
    private int f5345d = 1800000;

    /* renamed from: e */
    private boolean f5346e = true;

    /* renamed from: f */
    private boolean f5347f = false;

    /* renamed from: g */
    private boolean f5348g = true;

    /* renamed from: h */
    private boolean f5349h = true;

    /* renamed from: i */
    private C1331v f5350i = new C1291ax(this);

    /* renamed from: j */
    private boolean f5351j = false;

    private C1290aw() {
    }

    /* renamed from: b */
    public static C1290aw m5321b() {
        if (f5342k == null) {
            f5342k = new C1290aw();
        }
        return f5342k;
    }

    /* renamed from: a */
    public synchronized void mo9114a() {
        if (!this.f5347f) {
            C1333x.m5444d("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f5346e = true;
        } else {
            this.f5344c.mo9184a(new C1292ay(this));
        }
    }
}
