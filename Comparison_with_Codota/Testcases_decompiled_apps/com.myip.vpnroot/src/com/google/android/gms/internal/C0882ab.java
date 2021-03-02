package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

@C1130ez
/* renamed from: com.google.android.gms.internal.ab */
public class C0882ab {

    /* renamed from: mj */
    private final C0884a f2498mj;

    /* renamed from: mk */
    private final Runnable f2499mk;
    /* access modifiers changed from: private */

    /* renamed from: ml */
    public C0924av f2500ml;
    /* access modifiers changed from: private */

    /* renamed from: mm */
    public boolean f2501mm;

    /* renamed from: mn */
    private boolean f2502mn;

    /* renamed from: mo */
    private long f2503mo;

    /* renamed from: com.google.android.gms.internal.ab$a */
    public static class C0884a {
        private final Handler mHandler;

        public C0884a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public C0882ab(C1735u uVar) {
        this(uVar, new C0884a(C1228gr.f3776wC));
    }

    C0882ab(final C1735u uVar, C0884a aVar) {
        this.f2501mm = false;
        this.f2502mn = false;
        this.f2503mo = 0;
        this.f2498mj = aVar;
        this.f2499mk = new Runnable() {

            /* renamed from: mp */
            private final WeakReference<C1735u> f2504mp = new WeakReference<>(uVar);

            public void run() {
                boolean unused = C0882ab.this.f2501mm = false;
                C1735u uVar = (C1735u) this.f2504mp.get();
                if (uVar != null) {
                    uVar.mo10144b(C0882ab.this.f2500ml);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo7888a(C0924av avVar, long j) {
        if (this.f2501mm) {
            C1229gs.m4679W("An ad refresh is already scheduled.");
            return;
        }
        this.f2500ml = avVar;
        this.f2501mm = true;
        this.f2503mo = j;
        if (!this.f2502mn) {
            C1229gs.m4677U("Scheduling ad refresh " + j + " milliseconds from now.");
            this.f2498mj.postDelayed(this.f2499mk, j);
        }
    }

    /* renamed from: ay */
    public boolean mo7889ay() {
        return this.f2501mm;
    }

    /* renamed from: c */
    public void mo7890c(C0924av avVar) {
        mo7888a(avVar, 60000);
    }

    public void cancel() {
        this.f2501mm = false;
        this.f2498mj.removeCallbacks(this.f2499mk);
    }

    public void pause() {
        this.f2502mn = true;
        if (this.f2501mm) {
            this.f2498mj.removeCallbacks(this.f2499mk);
        }
    }

    public void resume() {
        this.f2502mn = false;
        if (this.f2501mm) {
            this.f2501mm = false;
            mo7888a(this.f2500ml, this.f2503mo);
        }
    }
}
