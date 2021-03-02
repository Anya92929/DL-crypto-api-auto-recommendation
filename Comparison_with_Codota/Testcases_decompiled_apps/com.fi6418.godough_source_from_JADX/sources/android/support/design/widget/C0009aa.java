package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: android.support.design.widget.aa */
class C0009aa {

    /* renamed from: a */
    private static C0009aa f110a;

    /* renamed from: b */
    private final Object f111b = new Object();

    /* renamed from: c */
    private final Handler f112c = new Handler(Looper.getMainLooper(), new C0010ab(this));

    /* renamed from: d */
    private C0012ad f113d;

    /* renamed from: e */
    private C0012ad f114e;

    private C0009aa() {
    }

    /* renamed from: a */
    static C0009aa m171a() {
        if (f110a == null) {
            f110a = new C0009aa();
        }
        return f110a;
    }

    /* renamed from: a */
    private void m173a(C0012ad adVar) {
        if (adVar.f117b != -2) {
            int i = 2750;
            if (adVar.f117b > 0) {
                i = adVar.f117b;
            } else if (adVar.f117b == -1) {
                i = 1500;
            }
            this.f112c.removeCallbacksAndMessages(adVar);
            this.f112c.sendMessageDelayed(Message.obtain(this.f112c, 0, adVar), (long) i);
        }
    }

    /* renamed from: a */
    private boolean m174a(C0012ad adVar, int i) {
        C0011ac acVar = (C0011ac) adVar.f116a.get();
        if (acVar == null) {
            return false;
        }
        acVar.mo176a(i);
        return true;
    }

    /* renamed from: b */
    private void m175b() {
        if (this.f114e != null) {
            this.f113d = this.f114e;
            this.f114e = null;
            C0011ac acVar = (C0011ac) this.f113d.f116a.get();
            if (acVar != null) {
                acVar.mo175a();
            } else {
                this.f113d = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m176b(C0012ad adVar) {
        synchronized (this.f111b) {
            if (this.f113d == adVar || this.f114e == adVar) {
                m174a(adVar, 2);
            }
        }
    }

    /* renamed from: e */
    private boolean m177e(C0011ac acVar) {
        return this.f113d != null && this.f113d.mo177a(acVar);
    }

    /* renamed from: f */
    private boolean m178f(C0011ac acVar) {
        return this.f114e != null && this.f114e.mo177a(acVar);
    }

    /* renamed from: a */
    public void mo169a(C0011ac acVar) {
        synchronized (this.f111b) {
            if (m177e(acVar)) {
                this.f113d = null;
                if (this.f114e != null) {
                    m175b();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo170a(C0011ac acVar, int i) {
        synchronized (this.f111b) {
            if (m177e(acVar)) {
                m174a(this.f113d, i);
            } else if (m178f(acVar)) {
                m174a(this.f114e, i);
            }
        }
    }

    /* renamed from: b */
    public void mo171b(C0011ac acVar) {
        synchronized (this.f111b) {
            if (m177e(acVar)) {
                m173a(this.f113d);
            }
        }
    }

    /* renamed from: c */
    public void mo172c(C0011ac acVar) {
        synchronized (this.f111b) {
            if (m177e(acVar)) {
                this.f112c.removeCallbacksAndMessages(this.f113d);
            }
        }
    }

    /* renamed from: d */
    public void mo173d(C0011ac acVar) {
        synchronized (this.f111b) {
            if (m177e(acVar)) {
                m173a(this.f113d);
            }
        }
    }
}
