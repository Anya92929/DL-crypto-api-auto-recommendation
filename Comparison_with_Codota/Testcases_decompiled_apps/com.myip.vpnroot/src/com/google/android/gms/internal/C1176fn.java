package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.C0955bq;
import com.google.android.gms.internal.C1154fd;
import com.google.android.gms.internal.C1196fz;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@C1130ez
/* renamed from: com.google.android.gms.internal.fn */
public class C1176fn extends C1206gg {

    /* renamed from: mw */
    private final Object f3575mw;

    /* renamed from: sZ */
    private final C1171fk f3576sZ;

    /* renamed from: tU */
    private final C1178fo f3577tU;

    /* renamed from: tV */
    private Future<C1196fz> f3578tV;
    /* access modifiers changed from: private */

    /* renamed from: tm */
    public final C1154fd.C1155a f3579tm;

    /* renamed from: tn */
    private final C1196fz.C1197a f3580tn;

    public C1176fn(Context context, C1735u uVar, C0899ai aiVar, C1196fz.C1197a aVar, C1154fd.C1155a aVar2) {
        this(aVar, aVar2, new C1178fo(context, uVar, aiVar, new C1222go(), aVar));
    }

    C1176fn(C1196fz.C1197a aVar, C1154fd.C1155a aVar2, C1178fo foVar) {
        this.f3575mw = new Object();
        this.f3580tn = aVar;
        this.f3576sZ = aVar.f3692vw;
        this.f3579tm = aVar2;
        this.f3577tU = foVar;
    }

    /* renamed from: r */
    private C1196fz m4468r(int i) {
        return new C1196fz(this.f3580tn.f3691vv.f3539tx, (C1232gv) null, (List<String>) null, i, (List<String>) null, (List<String>) null, this.f3576sZ.orientation, this.f3576sZ.f3557qj, this.f3580tn.f3691vv.f3532tA, false, (C1003cl) null, (C1016cu) null, (String) null, (C1004cm) null, (C1006co) null, this.f3576sZ.f3563tJ, this.f3580tn.f3686lH, this.f3576sZ.f3561tH, this.f3580tn.f3689vs, this.f3576sZ.f3566tM, this.f3576sZ.f3567tN, this.f3580tn.f3687vp, (C0955bq.C0956a) null);
    }

    /* renamed from: cp */
    public void mo8384cp() {
        final C1196fz fzVar;
        int i;
        try {
            synchronized (this.f3575mw) {
                this.f3578tV = C1209gi.submit(this.f3577tU);
            }
            fzVar = this.f3578tV.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            C1229gs.m4679W("Timed out waiting for native ad.");
            i = 2;
            fzVar = null;
        } catch (ExecutionException e2) {
            i = 0;
            fzVar = null;
        } catch (InterruptedException e3) {
            fzVar = null;
            i = -1;
        } catch (CancellationException e4) {
            fzVar = null;
            i = -1;
        }
        if (fzVar == null) {
            fzVar = m4468r(i);
        }
        C1228gr.f3776wC.post(new Runnable() {
            public void run() {
                C1176fn.this.f3579tm.mo8484a(fzVar);
            }
        });
    }

    public void onStop() {
        synchronized (this.f3575mw) {
            if (this.f3578tV != null) {
                this.f3578tV.cancel(true);
            }
        }
    }
}
