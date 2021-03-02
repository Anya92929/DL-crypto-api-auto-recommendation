package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.s */
public final class C0616s {

    /* renamed from: el */
    private final Runnable f1569el;
    /* access modifiers changed from: private */

    /* renamed from: em */
    public C0620v f1570em;
    /* access modifiers changed from: private */

    /* renamed from: en */
    public boolean f1571en = false;

    public C0616s(final C0614r rVar) {
        this.f1569el = new Runnable() {

            /* renamed from: eo */
            private final WeakReference<C0614r> f1572eo = new WeakReference<>(rVar);

            public void run() {
                boolean unused = C0616s.this.f1571en = false;
                C0614r rVar = (C0614r) this.f1572eo.get();
                if (rVar != null) {
                    rVar.mo5321b(C0616s.this.f1570em);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo5322a(C0620v vVar, long j) {
        if (this.f1571en) {
            C0344cn.m737q("An ad refresh is already scheduled.");
            return;
        }
        C0344cn.m735o("Scheduling ad refresh " + j + " milliseconds from now.");
        this.f1570em = vVar;
        this.f1571en = true;
        C0343cm.f1013hO.postDelayed(this.f1569el, j);
    }

    public void cancel() {
        C0343cm.f1013hO.removeCallbacks(this.f1569el);
    }

    /* renamed from: d */
    public void mo5324d(C0620v vVar) {
        mo5322a(vVar, 60000);
    }
}
