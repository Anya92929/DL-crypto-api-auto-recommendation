package com.flurry.android;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.android.ah */
final class C0094ah {

    /* renamed from: a */
    private List f111a = new ArrayList();

    /* renamed from: b */
    private Handler f112b;

    /* renamed from: c */
    private Handler f113c;

    /* renamed from: d */
    private int f114d;

    /* renamed from: e */
    private Runnable f115e;

    C0094ah(Handler handler, int i) {
        this.f112b = handler;
        this.f113c = new Handler();
        this.f114d = i;
        this.f115e = new C0109k(this);
        m94b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo3301a(C0113o oVar) {
        oVar.mo3323a();
        this.f111a.add(new WeakReference(oVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m92a() {
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : this.f111a) {
            C0113o oVar = (C0113o) weakReference.get();
            if (oVar != null) {
                arrayList.add(oVar);
            }
        }
        this.f113c.post(new C0108j(arrayList));
        m94b();
    }

    /* renamed from: b */
    private synchronized void m94b() {
        Iterator it = this.f111a.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this.f112b.removeCallbacks(this.f115e);
        this.f112b.postDelayed(this.f115e, (long) this.f114d);
    }
}
