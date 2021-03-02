package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.C1735u;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@C1130ez
/* renamed from: com.google.android.gms.internal.w */
class C1744w implements C1198g, Runnable {

    /* renamed from: lr */
    private C1735u.C1740b f4405lr;

    /* renamed from: me */
    private final List<Object[]> f4406me = new Vector();

    /* renamed from: mf */
    private final AtomicReference<C1198g> f4407mf = new AtomicReference<>();

    /* renamed from: mg */
    CountDownLatch f4408mg = new CountDownLatch(1);

    public C1744w(C1735u.C1740b bVar) {
        this.f4405lr = bVar;
        if (C1228gr.m4673dt()) {
            C1209gi.m4606a(this);
        } else {
            run();
        }
    }

    /* renamed from: ax */
    private void m6221ax() {
        if (!this.f4406me.isEmpty()) {
            for (Object[] next : this.f4406me) {
                if (next.length == 1) {
                    this.f4407mf.get().mo8543a((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    this.f4407mf.get().mo8542a(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
        }
    }

    /* renamed from: a */
    public String mo8540a(Context context) {
        mo10158aw();
        C1198g gVar = this.f4407mf.get();
        if (gVar == null) {
            return "";
        }
        m6221ax();
        return gVar.mo8540a(context);
    }

    /* renamed from: a */
    public String mo8541a(Context context, String str) {
        mo10158aw();
        C1198g gVar = this.f4407mf.get();
        if (gVar == null) {
            return "";
        }
        m6221ax();
        return gVar.mo8541a(context, str);
    }

    /* renamed from: a */
    public void mo8542a(int i, int i2, int i3) {
        C1198g gVar = this.f4407mf.get();
        if (gVar != null) {
            m6221ax();
            gVar.mo8542a(i, i2, i3);
            return;
        }
        this.f4406me.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* renamed from: a */
    public void mo8543a(MotionEvent motionEvent) {
        C1198g gVar = this.f4407mf.get();
        if (gVar != null) {
            m6221ax();
            gVar.mo8543a(motionEvent);
            return;
        }
        this.f4406me.add(new Object[]{motionEvent});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10157a(C1198g gVar) {
        this.f4407mf.set(gVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aw */
    public void mo10158aw() {
        try {
            this.f4408mg.await();
        } catch (InterruptedException e) {
            C1229gs.m4683d("Interrupted during GADSignals creation.", e);
        }
    }

    public void run() {
        try {
            mo10157a((C1198g) C1358j.m5095a(this.f4405lr.f4377lD.f3777wD, this.f4405lr.f4375lB));
        } finally {
            this.f4408mg.countDown();
            this.f4405lr = null;
        }
    }
}
